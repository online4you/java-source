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
import com.pRemote.interfaces.pCell.deviceComm.IDeviceComm;
import com.pRemote.interfaces.pCell.devices.IDevice;
import com.pRemote.pCell.deviceComm.SerialUSBComm;

/**
 * Encapsula la funcinalidad de un dispositivo gen�rico
 * 
 * @author Guillem
 * @version	1.0 25/10/2012
 */
public abstract class Device implements IDevice {
	protected Logger log;
	private String id;
	private String name;
	private String state;
	private String stateCause;
	private GregorianCalendar lastInfoState;
	private IDeviceComm comm;
	
	public abstract String operate(IMessage message);
		
	
	public Device(String commType, String portName, String boudRate) throws Exception {
		super();
		if(commType.equals(IDevice.COMM_USBSERIAL)){
			comm=new SerialUSBComm(portName, Integer.parseInt(boudRate));
		}else {
			throw new Exception("Communication with the device should be set!!");
		}
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStateCause() {
		return stateCause;
	}
	public void setStateCause(String stateCause) {
		this.stateCause = stateCause;
	}
	public GregorianCalendar getLastInfoState() {
		return lastInfoState;
	}
	public void setLastInfoState(GregorianCalendar lastInfoState) {
		this.lastInfoState = lastInfoState;
	}
	public IDeviceComm getComm() {
		return comm;
	}
	public void setComm(IDeviceComm comm) {
		this.comm = comm;
	}
	
	
	

	
	
	
	
}
