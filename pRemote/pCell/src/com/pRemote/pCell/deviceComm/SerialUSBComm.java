package com.pRemote.pCell.deviceComm;
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
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.CommPortOwnershipListener;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.log4j.Logger;

import com.pRemote.interfaces.pCell.deviceComm.IDeviceComm;

/**
 * Encapsula la funcinalidad del puerto USB 
 * 
 * @author Guillem
 * @version	1.0 25/10/2012
 */
public class SerialUSBComm implements IDeviceComm {
	private SerialPort serialPort;
	private static Logger log;
	
	public SerialUSBComm(){
		log=log==null?Logger.getLogger(this.getClass()):log;
		
		Enumeration portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
	    	log.info("PortList");
	    	CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
	    	log.info("Type: " + portId.getPortType());
	    	log.info("Name: " + portId.getName());
	    }
	}
	
	public SerialUSBComm(String portName,int boudrate) throws Exception{
		log=log==null?Logger.getLogger(this.getClass()):log;
		log.info("About to open " + portName + " at "+boudrate+" boudrate");
		Enumeration portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
	    	log.info("PortList");
	    	CommPortIdentifier portId = (CommPortIdentifier) portList.nextElement();
	    	log.info("Type: " + portId.getPortType());
	    	log.info("Name: " + portId.getName());
	    }
		try{
	        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
	        if ( portIdentifier.isCurrentlyOwned()){
	            throw new Exception("Error: Port is currently in use");
	        }else{
	            CommPort commPort = portIdentifier.open("SerialUSBWriter",2000);
	            if ( commPort instanceof SerialPort ){
	                serialPort = (SerialPort) commPort;
	                serialPort.setSerialPortParams(boudrate,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
	                Thread.sleep(2000);
	            }
	        }
		} catch(Exception e){
	        	log.error("Port "+portName+" not inicialized at "+boudrate+" boudrate!",e);
	        }
	}
	
	
	/* (non-Javadoc)
	 * @see com.pRemote.pCell.serial.ISerialComm#sendDataToDevice(java.lang.String)
	 */
	@Override
	public String sendDataToDevice ( String data ) throws Exception{
		String ret="";
            if ( serialPort!=null ){
                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();
                byte[] byteArray = data.getBytes("UTF-8");
                out.write(byteArray);

                byte[] buffer = new byte[1024];
                int len = -1;
                try{
                    while ((len = in.read(buffer)) > -1 ) {
                    	if(len!=0){
                    		ret+=new String(buffer,0,len);
                    		if(ret.indexOf("\n")!=-1){
                    			return ret;
                    			}
                    	}
                    }
                }catch ( IOException e ){
                    e.printStackTrace();
                }       
            }
            else{
                ret="Error: Something has been bad with the USB!!";
            }
		return ret;     
    }
}
