package com.pRemote.pCell.messages;
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
import gnu.io.CommPortIdentifier;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.pRemote.commonServices.util.AppModelProperties;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.devices.IDevice;
import com.pRemote.interfaces.pCell.devices.IDevice_ONOFF;
import com.pRemote.messages.Message;
import com.pRemote.pCell.Cell;
import com.pRemote.pCell.deviceComm.SerialUSBComm;
import com.pRemote.pCell.pojo.devices.Device_ONOFF;
/**
 * Cada petición al puerto en el que se escucha lanzará un nuevo hilo
 * para procesar el mensaje recibido
 *
 * @author	Guillem 
 * @version	1.0 25/10/2012
 */

 
public class MessageProcess extends Thread { 
	
	private static Logger log;
	private static String dateFormat;
	private static Integer messageTTLMinutes;
	private static Hashtable<String,IDevice> devices;
	private static AppModelProperties prop;
	private static final String TYPE_ONOFF="ONOFF";
	private static final String COMM_USB="USB";
	private Socket s;
	private String systemId;
	private String cellId;
	private Cell cell;
    /**
     * Métode constructor
     * @throws Exception 
      */		
	public MessageProcess(Socket s,Cell cell) throws Exception { 
		this.s = s; 
		this.devices=cell.getDevices();
		this.systemId=cell.getSystemId();
		this.cellId=cell.getCellId();
		this.cell=cell;
		log=log==null?Logger.getLogger(this.getClass()):log;
		prop=prop==null?new AppModelProperties():prop;
		dateFormat=dateFormat==null?prop.getProperty("com.pRemote.messageDateFormat"):dateFormat;
		messageTTLMinutes=messageTTLMinutes==null?Integer.parseInt(prop.getProperty("com.pRemote.messageTTLMinutes")):messageTTLMinutes;
		
	}
    /**
     * Métode que gestiona la connexió del client.
     * Crea un objecte de tipus GetPaginaWeb per tal de crear un 
     * socket client que sol·licitarà la url
     */	
 	public void run() { 
 		BufferedReader in = null;
 		PrintStream out = null;
 		String message;
 		String retorn=null;
 		String result=null;
 		IMessage msg=null;
 		// Gestiona la connexió
 		try {
 			//in serà el canal d'entrada
		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//out serà el canal de sortida
        out = new PrintStream(s.getOutputStream());

			//Legim la url sol·licitada
        message=in.readLine();
        	
        	try {
        		/*
        		System.out.println("[device_node_systemFrom##device_node_systemTo##messageType_Operation##time##validUntill]");
				System.out.println("Exemple:");
				System.out.println("[0001_0001_0001##0000_0000_0001##ONOFF_ON_FORCED##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000]");
				*/
        		log.info("Message from " + s.getRemoteSocketAddress());
        		log.info("Process message "+ message );
        		
        		msg=new Message(message,dateFormat);
        		if (msg.getOperation().equals(cell.SHUTDOWN)){
        			if(cell.isListen()){
        				cell.setListen(false);
        				retorn=composeReturn(msg,"Cell " + this.cellId + " is going down!");
        				cell.lookUp(msg);
        			}
        		}else if (cell.isThisMasterCell() &&  this.systemId.equals(msg.getSystemTo()) && !this.cellId.equals(msg.getCellTo())){
        			Hashtable<String, String> cells = cell.getCells();
        			for(Entry<String, String> c:cells.entrySet()){
        				if (c.getKey().equals(msg.getCellTo())){
        					result=cell.sendMessageToCell(msg,c.getValue().split(":")[0], Integer.parseInt(c.getValue().split(":")[1]));
        				}
        				retorn=result;
        			}
        		}else if (this.systemId.equals(msg.getSystemTo()) && this.cellId.equals(msg.getCellTo())){
        			if (msg.getOperationType().equals(TYPE_ONOFF)){
        				IDevice_ONOFF device=(IDevice_ONOFF) devices.get(String.valueOf(Integer.parseInt(msg.getDeviceTo())));
        				if (device!=null){
        					result = device.operate(msg);
        				}else{
        					result="Not Such a device!";
        				}
        			
                		retorn=composeReturn(msg,result);
        			}
        			
        		}else{
        			retorn=composeReturn(msg,"Message unknown!");
        		}
        		retorn=retorn==null?"":retorn;
	        	//Enviem el resultat
        		out.println("__SOF__");
	    		out.println(retorn.toString());
	    		//Esperem que el client faci la lectura i tanquem el socket que s'havia creat a partir de ss.accept()
	    		out.println("__EOF__");
	    		log.info("Returning "+retorn+" to : " + s.getRemoteSocketAddress());
	    		message=in.readLine();
	    		s.close();
	        }catch  (Exception e) {
	        	log.error("Operation has NOT been succed!",e);
	        	out.println("__SOF__");
	    		out.println(composeReturn(msg,e.getMessage()));
	    		//Esperem que el client faci la lectura i tanquem el socket que s'havia creat a partir de ss.accept()
	    		out.println("__EOF__");
	    		message=in.readLine();
	    		s.close();
	        }
	 	} catch (Exception e) {
	 		log.error("Operation has NOT been succed!",e);
	 		out.println("__SOF__");
    		out.println(composeReturn(msg,e.getMessage()));
    		//Esperem que el client faci la lectura i tanquem el socket que s'havia creat a partir de ss.accept()
    		out.println("__EOF__");	
    		try {
				message=in.readLine();
				s.close();
    		} catch (IOException e1) {
    			log.error("Operation has NOT been succed!",e1);
			}
	 	}
	} 
 	private String composeReturn(IMessage msg, String result){
 		String retorn="";
 		retorn+=this.systemId+"_"+this.cellId+"_"+msg.getDeviceTo()+"##";
		retorn+=msg.getSystemFrom()+"_"+msg.getCellFrom()+"_"+msg.getDeviceTo()+"##";
		retorn+=msg.getOperationType()+"_RESPONSE_"+result+"##";
		GregorianCalendar cal=new GregorianCalendar();
   		retorn+=getDateToString(cal)+"##";
   		cal.add(Calendar.MINUTE, messageTTLMinutes);
   		retorn+=getDateToString(cal);
   		
   		return retorn;
 	}
 	
 	private String getDateToString(GregorianCalendar cal){
 		 Date date = cal.getTime();
         SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
         return sdf.format(date);
 	}
 	
 	
 	
}