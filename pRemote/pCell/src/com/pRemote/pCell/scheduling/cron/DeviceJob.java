/* 
 * Copyright 2005 - 2009 Terracotta, Inc. 
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

package com.pRemote.pCell.scheduling.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.pRemote.commonServices.util.AppModelProperties;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.devices.IDevice;
import com.pRemote.messages.Message;

/**
 * <p>
 * This is just a simple job that gets fired off many times by example 1
 * </p>
 * 
 * @author Bill Kratzer
 */
public class DeviceJob implements Job {
	private static AppModelProperties prop;
    private static Logger _log = LoggerFactory.getLogger(DeviceJob.class);
    public static final String DEVICE="Device";
    public static final String OPERATION="Operation";
    public static final String CRON="Cron";
    public static final String DEVICES="Devices";
    public static final String SDF="SimpleDateFormat";
    public static final String MESSAGE="Message";
   
    private  static SimpleDateFormat sdf;
    
    /**
     * Quartz requires a public empty constructor so that the
     * scheduler can instantiate the class whenever it needs.
     */
    public DeviceJob() {
    	super();
    }

    /**
     * <p>
     * Called by the <code>{@link org.quartz.Scheduler}</code> when a
     * <code>{@link org.quartz.Trigger}</code> fires that is associated with
     * the <code>Job</code>.
     * </p>
     * 
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
       	// Grab and print passed parameters
        JobDataMap data = context.getJobDetail().getJobDataMap();
        sdf=sdf==null?sdf=(SimpleDateFormat) data.get(SDF):sdf;
        
        String device = data.getString(DEVICE);
        String operation = data.getString(OPERATION);
        String cron = data.getString(CRON);
        IMessage message=(IMessage) data.get(MESSAGE);
        Hashtable<String,IDevice> devices = (Hashtable<String,IDevice>)data.get(DEVICES);
        
        IDevice dev = devices.get(String.valueOf(Integer.parseInt(device)));

        JobKey jobKey = context.getJobDetail().getKey();
        _log.info("DeviceJob: " + jobKey + " [" + sdf.format(new Date()) + "] Device: " + device + " Operation: " + operation + " Cron: " + cron);
        //0001_0001_0001##0000_0000_0001##ONOFF_ON##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000
        if (dev.getState()!=null && dev.getState().equals(IDevice.STATECAUSE_AUTO)){
        	_log.info("About to proccess : " + message.toString() );
        	String result=dev.operate(message);
			_log.info("Operation done. Result:"+result);
        }else{
        	_log.info("Operation Failed!!. Device in state:"+dev.getState());
        }
        
        
    }
    
    

}
