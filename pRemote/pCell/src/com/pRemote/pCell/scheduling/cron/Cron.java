package com.pRemote.pCell.scheduling.cron;
/* 
 * Copyright 2012 - www.puigros.es 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pRemote.commonServices.util.AppModelProperties;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.devices.IDevice;
import com.pRemote.messages.Message;
/**
 * Encapsula la funcinalidad de las tareas programadas.  
 * La funcionalidad es análoga a la de Linux. 
 *
 * @author Guillem
 * @version	1.0 25/10/2012
 */
public class Cron {
	private static Logger log = LoggerFactory.getLogger(Cron.class);
	private static AppModelProperties prop;
    
	private Hashtable<String,String> cronList;
	private List<String> txtLines;
	private SchedulerFactory sf;
	private Scheduler sched;
	private String group;
    private SimpleDateFormat sdf;
    private Hashtable<String,IDevice> devices;
    private String cellId;
	private String systemId;
	private String dateFormat;
	
	public Cron(String cronFile, String group,Hashtable<String,IDevice> devices) throws IOException, SchedulerException{
		log.info("------- Initializing Cron -------------------");
		this.devices=devices;
		txtLines=new ArrayList<String>();	
		cronList=new Hashtable<String,String>();
		this.group=group;
		prop=prop==null?new AppModelProperties():prop;
		dateFormat=prop.getProperty("com.pRemote.messageDateFormat");
		sdf=new SimpleDateFormat(dateFormat); 
		sf = new StdSchedulerFactory();
		sched = sf.getScheduler();
		cellId=prop.getProperty("com.pRemote.cellId");
		systemId=prop.getProperty("com.pRemote.systemId");
		
		InputStream file = this.getClass().getClassLoader().getResourceAsStream(cronFile);
		DataInputStream in = new DataInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ((strLine = br.readLine()) != null)   {
			log.info("adding " + strLine);
			try{txtLines.add(strLine);}
			catch(Exception e){
				log.info("error in  " + strLine + " - " +e.getMessage());
			}
		}
		in.close();
	}
	private IMessage getMessage(String operation){
		//0001_0001_0001##0000_0000_0001##ONOFF_ON##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000
		String strMessage="";
		strMessage+=systemId+"_"+cellId+"_XXXX##";
		strMessage+=systemId+"_"+cellId+"_XXXX##";
		strMessage+=operation+"##";
		strMessage+=sdf.format(new Date())+"##";
		strMessage+=sdf.format(new Date())+"";
		IMessage msg=new Message(strMessage,dateFormat);
		return msg;
	}
	
	public void cronTasks() throws SchedulerException, InterruptedException{
		if (txtLines!=null){
			String[] data;
			String line;
			String device;
			String operation;
			String cron;
			for (int i=0;i<txtLines.size();i++){
				line=txtLines.get(i);
				if (!line.substring(0,1).equals("#")){
					log.info("Scheduling  " + line);
					data = line.split("##");
					device=data[0];
					operation=data[1];
					cron=data[2];
					cronList.put(device+"##"+operation, cron);
				}
				
			}
		}
		startJobs(cronList);
	}
	public void startJobs(Hashtable<String,String> cronList) throws SchedulerException, InterruptedException{
		if (cronList!=null){
			String device;
			String operation;
			String cron;
			JobDetail job;
			CronTrigger trigger;
			Date ft;
			log.info("------- Scheduling Jobs ----------------");
			for (Entry<String, String> task:cronList.entrySet()){
				device=task.getKey().split("##")[0];
				operation=task.getKey().split("##")[1];
				cron=task.getValue();
				job = newJob(DeviceJob.class).withIdentity("job " + task.getKey(), group).build();
				trigger = newTrigger().withIdentity("trigger "  + task.getKey(), group).withSchedule(cronSchedule(cron)).build();
				//Set params
				job.getJobDataMap().put(DeviceJob.DEVICE, device);
				job.getJobDataMap().put(DeviceJob.OPERATION, operation);
				job.getJobDataMap().put(DeviceJob.CRON, cron);
				job.getJobDataMap().put(DeviceJob.DEVICES,devices);
				job.getJobDataMap().put(DeviceJob.SDF,sdf);
				job.getJobDataMap().put(DeviceJob.MESSAGE,getMessage(operation));
				
				// end set params
				ft = sched.scheduleJob(job, trigger);
				log.info(job.getKey() + " scheduled to run at: " + sdf.format(ft) + " CRON: " + trigger.getCronExpression());
			}
		}
        log.info("------- Starting Scheduler ----------------");
        sched.start();
        log.info("------- Started Scheduler -----------------");
        ///this.wait();
	}
	public void shutdown() throws SchedulerException{
		log.info("------- Shutting Down ---------------------");
		sched.shutdown(true);
		log.info("------- Shutdown Complete -----------------");
    }
}
