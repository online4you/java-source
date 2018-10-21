package com.pRemote.interfaces.pCell.devices;
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
import java.util.List;

import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.deviceComm.IDeviceComm;

/**
 *	Interface que debe serimplementado por un dispositivo
 * 
 * @author Guillem
 * @version	1.0 25/10/2012
 */
public interface IDevice {

	public static final String STATECAUSE_FORCED = "FORCED";
	public static final String STATECAUSE_AUTO = "AUTO";
	public static final String COMM_USBSERIAL = "USBSERIAL";
	
	public abstract String getId();

	public abstract void setId(String id);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getState();

	public abstract void setState(String state);
	public GregorianCalendar getLastInfoState();
	public void setLastInfoState(GregorianCalendar lastInfoState);
	public IDeviceComm getComm();
	public void setComm(IDeviceComm comm);
	public abstract String operate(IMessage message);
	public String getCellId() ;
	public void setCellId(String cellId);
	public String getSystemId();
	public void setSystemId(String systemId);
	public String getStateCause();
	public void setStateCause(String stateCause);
	public String getImgUrl();
	public void setImgUrl(String imgUrl);
	public List<IMessage> getInfoMessages() ;
	public void setInfoMessages(List<IMessage> infoMessages);
	
}