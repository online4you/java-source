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
import java.net.Socket;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import com.pRemote.commonServices.util.AppModelProperties;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.messages.Message;

/**
 * Clase con el método main para arrancar la célula.
 * Puede recibir el parámetro -l para arrancarcala automámticamente 
 *
 * @author Guillem
 * @version	1.0 25/10/2012
 */
 
//java -cp .;C:\dev\Java\pRemote\pCell\pCell.jar;C:\dev\Java\pRemote\pCell\lib\RXTXcomm.jar;C:\dev\Java\pRemote\pCell\lib\javaLibreriasExternas.jar;C:\dev\Java\pRemote\pCell\lib\javaCommons.jar;C:\dev\Java\pRemote\pCell\lib\javaCommonServices.jar com.pRemote.pCell.StartCell
/*
Field Name		Mandatory	Allowed Values		Allowed Special Characters
Seconds			YES			0-59				, - * /
Minutes			YES			0-59				, - * /
Hours			YES			0-23				, - * /
Day of month	YES			1-31				, - * ? / L W
Month			YES			1-12 or JAN-DEC		, - * /
Day of week		YES			1-7 or SUN-SAT		, - * ? / L #
Year			NO			empty, 1970-2099	, - * /

Expression				Meaning
0 0 12 * * ?				Fire at 12pm (noon) every day
0 15 10 ? * *				Fire at 10:15am every day
0 15 10 * * ?				Fire at 10:15am every day
0 15 10 * * ? *				Fire at 10:15am every day
0 15 10 * * ? 2005			Fire at 10:15am every day during the year 2005
0 * 14 * * ?				Fire every minute starting at 2pm and ending at 2:59pm, every day
0 0/5 14 * * ?				Fire every 5 minutes starting at 2pm and ending at 2:55pm, every day
0 0/5 14,18 * * ?			Fire every 5 minutes starting at 2pm and ending at 2:55pm, AND fire every 5 minutes starting at 6pm and ending at 6:55pm, every day
0 0-5 14 * * ?				Fire every minute starting at 2pm and ending at 2:05pm, every day
0 10,44 14 ? 3 WED			Fire at 2:10pm and at 2:44pm every Wednesday in the month of March.
0 15 10 ? * MON-FRI			Fire at 10:15am every Monday, Tuesday, Wednesday, Thursday and Friday
0 15 10 15 * ?				Fire at 10:15am on the 15th day of every month
0 15 10 L * ?				Fire at 10:15am on the last day of every month
0 15 10 ? * 6L				Fire at 10:15am on the last Friday of every month
0 15 10 ? * 6L				Fire at 10:15am on the last Friday of every month
0 15 10 ? * 6L 2002-2005	Fire at 10:15am on every last friday of every month during the years 2002, 2003, 2004 and 2005
0 15 10 ? * 6#3				Fire at 10:15am on the third Friday of every month
0 0 12 1/5 * ?				Fire at 12pm (noon) every 5 days every month, starting on the first day of the month.
0 11 11 11 11 ?				Fire every November 11th at 11:11am.

*/
public class StartCell {
	
	public static void main(String[] args) throws IOException, SchedulerException, InterruptedException {
		AppModelProperties prop=new AppModelProperties();
		Cell cell=new Cell();
		Logger log=Logger.getLogger("Main");
		String dateFormat=prop.getProperty("com.pRemote.messageDateFormat");
		char getChar;
		String getStr;
		
		if (args.length>0){
			for (String arg: args) {
		        if(arg.equals("-l")){
		        	cell.listen();
		        	cell.shutdown();
		        	log.info("Bye!!!");
		        }
		    }
		}else{
			try {
				
					while (true){
						getChar=1;
						System.out.println("L-Listen");
						System.out.println("S-to-message Send Message");
						System.out.println("\tExample: S-127.0.0.1:5224-0001_0001_0001##0000_0000_0000##ONOFF_ON_AUTO##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000: S-[message]Send Message");
						System.out.println("\t[device_node_systemFrom##device_node_systemTo##messageType_Operation##time##validUntill]");
						System.out.println("E-Exit");
				        		
						BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
						getStr = bufferRead.readLine();
					    System.out.println("\n\nLets proccess: " + getStr);
					    
					    					
						
			       		if (!getStr.equals("")){
				       		if (getStr.toLowerCase().compareTo("l")==0){
				       			cell.listen();
				       			break;
				       		}else if (getStr.substring(0,1).toLowerCase().compareTo("s")==0){
				       			IMessage msg=new Message(getStr.split("-")[2],dateFormat);
				       			System.out.println(cell.sendMessageToCell(msg, getStr.split("-")[1].split(":")[0], Integer.parseInt(getStr.split("-")[1].split(":")[1])));
				       		}else if (getStr.toLowerCase().compareTo("e")==0){
				       			break;
				       		}
						}
			       		
					}
					cell.shutdown();
					log.info("Bye!!!");;
			} catch (Exception e) { 
				log.error(e.getMessage(),e);
			
			}
		}
		
	}

}
