package com.pRemote.pCell.pojo.devices;
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

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.devices.IDevice_ONOFF;

public class Device_ONOFF extends Device implements IDevice_ONOFF {
	
	public Device_ONOFF(String commType, String portName, String boudRate)throws Exception {
		super(commType, portName, boudRate);
		log=log==null?Logger.getLogger(this.getClass()):log;
	}
	public Device_ONOFF()throws Exception {
		super();
		log=log==null?Logger.getLogger(this.getClass()):log;
	}
	public String operate(IMessage message ) {
		String ret=null;
		String op = message.getOperation();
		this.setState(message.getStateCause());
		this.setLastInfoState(new GregorianCalendar());
		String operation=null;
		if(op.equals("ON")){
			operation="1";
    	}else if(op.equals("OFF")){
    		operation="0";
    	}else if(op.equals("BLINK")){
    		operation="2";
    	}
		if (operation!=null){
			try {
				ret=this.getComm().sendDataToDevice(operation);
			} catch (Exception e) {
				ret="Operation undefinied " + message.toString();
				log.error(ret);
			}
		}
		return ret;
	}

	
	
}
