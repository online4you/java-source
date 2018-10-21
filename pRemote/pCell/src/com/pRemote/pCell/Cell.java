package com.pRemote.pCell;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import com.pRemote.commonServices.util.AppModelProperties;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.devices.IDevice;
import com.pRemote.messages.Message;
import com.pRemote.pCell.messages.MessageProcess;
import com.pRemote.pCell.pojo.devices.Device_ONOFF;
import com.pRemote.pCell.scheduling.cron.Cron;

/**
 * Define una célula que encapsula toda la funcionalidad. 
 * 
 * @author Guillem
 * @version	1.0 25/10/2012
 */
public class Cell {
	private Logger log;
	public static final String TYPE_ONOFF="ONOFF";
	public static final String COMM_USB="USB";
	public static final String SHUTDOWN="SHUTDOWN";
	
	private AppModelProperties prop;
	private String cellId;
	private String systemId;
	private String cronFile;
	private Cron cron;
	private int cellPort;
	private String publicIp;
	private String masterCellIp;
	private String cellType;
	private Hashtable<String,IDevice> devices;
	private Hashtable<String,String> cells;
	private boolean listen;
	private int sendMessageTimeOutMilisecons;
	public Cell (){
		init();
	}
	
	private void init(){
		log=Logger.getLogger(this.getClass());
		try{
			log.info("**************START**************");
			prop = new AppModelProperties();
			setDevices();
			cellId=prop.getProperty("com.pRemote.cellId");
			systemId=prop.getProperty("com.pRemote.systemId");
			cronFile=prop.getProperty("com.pRemote.cronFile");
			publicIp=prop.getProperty("com.pRemote.publicIp");
			masterCellIp=prop.getProperty("com.pRemote.masterCellIp");
			sendMessageTimeOutMilisecons=Integer.parseInt(prop.getProperty("com.pRemote.sendMessageTimeOutMilisecons"));
			
			try{cellPort=Integer.parseInt(prop.getProperty("com.pRemote.cellPort"));}
			catch(Exception e){cellPort=0;}
			cellType=prop.getProperty("com.pRemote.cellType");
			if (cellId!=null && cronFile!=null){
				cron = new Cron(cronFile, "cell"+cellId,this.devices);
				cron.cronTasks();
				log.info("Cell " + cellId + " scheduled with "+cronFile);
			}
			
			log.info("Cell " + cellId + " started.");
			//listen();
			//cron.shutdown();
			
		}catch(Exception e){
			log.error(e.getMessage(), e);
		}
	}
	public String getThisCellIp() throws UnknownHostException{
		return InetAddress.getLocalHost().getHostAddress();
	}
	public boolean isThisMasterCell() throws UnknownHostException{
		boolean ret=false;
		if (masterCellIp!=null && masterCellIp.equals(getThisCellIp())){
			ret=true;
		}
		return ret;
	}
	public void shutdown() throws SchedulerException{
		cron.shutdown();
	}
	private void setDevices() throws Exception{
			int numOfDevs=Integer.parseInt(prop.getProperty("com.pRemote.numberOfDevices"));
			devices=new Hashtable<String, IDevice>();
			for (int i=0;i<numOfDevs;i++){
				IDevice dev;
				String devType=prop.getProperty("com.pRemote.device."+i+".type");
				String devCommType=prop.getProperty("com.pRemote.device."+i+".communicationsType");
				if(devType.equals(TYPE_ONOFF)){
					if (devCommType.equals(COMM_USB)){
						String comm=prop.getProperty("com.pRemote.device."+i+".USB");
						String boudRate=prop.getProperty("com.pRemote.device."+i+".boudRate");
						String name=prop.getProperty("com.pRemote.device."+i+".name");
						dev=new Device_ONOFF(IDevice.COMM_USBSERIAL,comm,boudRate);
						dev.setState(IDevice.STATECAUSE_AUTO);
						dev.setId(String.valueOf(i));
						dev.setLastInfoState(new GregorianCalendar());
						dev.setName(name);
					}else{
						throw new Exception("Device  " + i + " is NOT set!");
					}
					devices.put(String.valueOf(i), dev);
				}
				
			}
	}
	private void setCells() throws Exception{
		int numOfCells=Integer.parseInt(prop.getProperty("com.pRemote.numberOfCells"));
		cells=new Hashtable<String,String>();
		for (int i=0;i<numOfCells;i++){
			String ipPort=prop.getProperty("com.pRemote.cell."+i+".ip")+":"+prop.getProperty("com.pRemote.cell."+i+".port");
			cells.put(String.valueOf(i),ipPort);
		}
	}
	public void listen() throws UnknownHostException {
		ServerSocket ss = null;
		
		log.info("Starting pCell at " +getThisCellIp()+":"+this.cellPort);
		if (this.isThisMasterCell()){
			log.info("This is a master cell listening at " +masterCellIp+":"+this.cellPort);
		}
		
		try {
			
	    	//Es crea un nou socket de Servidor
			ss = new ServerSocket(this.cellPort);
			listen=true;
	        	while (listen) {
		        	Socket s = ss.accept();
					//Delegam la gestió a un fil d'execució nou per tal de 
		        	//Poder acceptar noves peticions
		        	try {
		        		MessageProcess p = new MessageProcess(s,this);
		        		p.start();
		        	}catch (Exception e) {
		        		log.error(e.getMessage(),e);
		        	}
					//s.close();
	        	}
	        	shutdown();
	        	
		} catch (Exception e) { e.printStackTrace();}
	    }

	public String lookUp(IMessage message) throws UnknownHostException{
		 return sendMessageToCell(message,this.getThisCellIp(), this.cellPort); 
	}
	public String sendMessageToCell(IMessage message, String cellIp, int cellPort) {
		BufferedReader in = null;
		PrintStream out = null;
		Socket s = null;
		char getChar;
		String getStr;
		String getLine;
		String ret="";
		try {
					String strMessage= message.toString();
					log.info("About to send: " + strMessage);
					log.info("Sending to: " + cellIp+":"+cellPort);
					//Es crea un nou socket amb [args[0]] per port [port]
		    		try{s = new Socket(cellIp, cellPort);}
		    		catch (Exception e) { 
		    			log.error("Unable to connect to: " +  cellIp+":"+cellPort,e);
		    		}
		
		    		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
		       		out = new PrintStream(s.getOutputStream());
		       		
		       		out.println(strMessage);
		       		//Esperm a rebre el resultat
		       		getLine=in.readLine();
		       		//Esperarem 10 segons per a donar un timeout
					s.setSoTimeout(sendMessageTimeOutMilisecons);
					
			       	while (getLine.indexOf("__EOF__")==-1){
						try{
							getLine=in.readLine();
							if(getLine.indexOf("__EOF__")==-1)
								ret+=getLine;
							}
						catch (Exception e) { 
							log.error("Connection to : " +  cellIp+":"+cellPort + " timed out!!",e);
							getLine="__EOF__";
			    		}     		
			       	}
					//Es tanca el socket
			       	out.println("__EOF__");
					s.close();
		} catch (Exception e) { e.printStackTrace();}
		return ret;
    }
	public String getCellId() {
		return cellId;
	}

	public void setCellId(String cellId) {
		this.cellId = cellId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public int getCellPort() {
		return cellPort;
	}

	public void setCellPort(int cellPort) {
		this.cellPort = cellPort;
	}

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getMasterCellIp() {
		return masterCellIp;
	}

	public void setMasterCellIp(String masterCellIp) {
		this.masterCellIp = masterCellIp;
	}

	public String getCellType() {
		return cellType;
	}

	public void setCellType(String cellType) {
		this.cellType = cellType;
	}

	public Hashtable<String, IDevice> getDevices() {
		return devices;
	}

	public void setDevices(Hashtable<String, IDevice> devices) {
		this.devices = devices;
	}

	public boolean isListen() {
		return listen;
	}

	public void setListen(boolean listen) {
		this.listen = listen;
	}

	public Hashtable<String, String> getCells() {
		return cells;
	}

	public void setCells(Hashtable<String, String> cells) {
		this.cells = cells;
	}



	
	
}
