package com.pRemote.interfaces.messages;
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

/**
 * Interface que debe ser implepentado por un mensaje
 * 
 * @author Guillem
 * @version	1.0 25/10/2012
 */
public interface IMessage {

	public abstract String getSystemFrom();

	public abstract void setSystemFrom(String systemFrom);

	public abstract String getCellFrom();

	public abstract void setCellFrom(String cellFrom);

	public abstract String getDeviceFrom();

	public abstract void setDeviceFrom(String deviceFrom);

	public abstract String getSystemTo();

	public abstract void setSystemTo(String systemTo);

	public abstract String getCellTo();

	public abstract void setCellTo(String cellTo);

	public abstract String getDeviceTo();

	public abstract void setDeviceTo(String deviceTo);

	public abstract String getOperationType();

	public abstract void setOperationType(String operationType);

	public abstract String getOperation();

	public abstract void setOperation(String operation);

	public abstract String getTime();

	public abstract void setTime(String time);

	public abstract String getValidUntill();

	public abstract void setValidUntill(String validUntill);

	public abstract GregorianCalendar getCalendarTime();


	public abstract GregorianCalendar getCalendarValidUntill();
	
	public String getStateCause();
	
	public void setStateCause(String stateCause);
	


}