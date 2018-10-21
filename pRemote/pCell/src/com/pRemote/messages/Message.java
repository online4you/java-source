package com.pRemote.messages;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import com.pRemote.interfaces.messages.IMessage;

public class Message implements IMessage {

	private String systemFrom;
	private String cellFrom;
	private String deviceFrom;
	private String systemTo;
	private String cellTo;
	private String deviceTo;
	private String operationType;
	private String operation;
	private String stateCause;
	private String time;
	private String validUntill;
	private String dateFormat;
	private DateFormat df;
	
	
	public Message(){
		super();
	}
	public Message(String message,String dateFormat){
		super();
		this.dateFormat=dateFormat;
		String[] data=message.split("##");
		systemFrom=data[0].split("_")[0];
		cellFrom=data[0].split("_")[1];
		deviceFrom=data[0].split("_")[2];
		systemTo=data[1].split("_")[0];
		cellTo=data[1].split("_")[1];
		deviceTo=data[1].split("_")[2];
		operationType=data[2].split("_")[0];
		operation=data[2].split("_")[1];
		stateCause=data[2].split("_")[2];
		time=data[3];
		validUntill=data[4];	
		df = new SimpleDateFormat(dateFormat);
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getSystemFrom()
	 */
	@Override
	public String getSystemFrom() {
		return systemFrom;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setSystemFrom(java.lang.String)
	 */
	@Override
	public void setSystemFrom(String systemFrom) {
		this.systemFrom = systemFrom;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getCellFrom()
	 */
	@Override
	public String getCellFrom() {
		return cellFrom;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setCellFrom(java.lang.String)
	 */
	@Override
	public void setCellFrom(String cellFrom) {
		this.cellFrom = cellFrom;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getDeviceFrom()
	 */
	@Override
	public String getDeviceFrom() {
		return deviceFrom;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setDeviceFrom(java.lang.String)
	 */
	@Override
	public void setDeviceFrom(String deviceFrom) {
		this.deviceFrom = deviceFrom;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getSystemTo()
	 */
	@Override
	public String getSystemTo() {
		return systemTo;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setSystemTo(java.lang.String)
	 */
	@Override
	public void setSystemTo(String systemTo) {
		this.systemTo = systemTo;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getCellTo()
	 */
	@Override
	public String getCellTo() {
		return cellTo;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setCellTo(java.lang.String)
	 */
	@Override
	public void setCellTo(String cellTo) {
		this.cellTo = cellTo;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getDeviceTo()
	 */
	@Override
	public String getDeviceTo() {
		return deviceTo;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setDeviceTo(java.lang.String)
	 */
	@Override
	public void setDeviceTo(String deviceTo) {
		this.deviceTo = deviceTo;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getOperationType()
	 */
	@Override
	public String getOperationType() {
		return operationType;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setOperationType(java.lang.String)
	 */
	@Override
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getOperation()
	 */
	@Override
	public String getOperation() {
		return operation;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setOperation(java.lang.String)
	 */
	@Override
	public void setOperation(String operation) {
		this.operation = operation;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getTime()
	 */
	@Override
	public String getTime() {
		return time;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setTime(java.lang.String)
	 */
	@Override
	public void setTime(String time) {
		this.time = time;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getValidUntill()
	 */
	@Override
	public String getValidUntill() {
		return validUntill;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setValidUntill(java.lang.String)
	 */
	@Override
	public void setValidUntill(String validUntill) {
		this.validUntill = validUntill;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getCalendarTime()
	 */
	public String getStateCause() {
		return stateCause;
	}
	public void setStateCause(String stateCause) {
		this.stateCause = stateCause;
	}
	
	
	
	@Override
	public GregorianCalendar getCalendarTime() {
		GregorianCalendar cal=null;
		Date date;
		try {
			date = df.parse(time);
			cal=new GregorianCalendar();
			cal.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return cal;
	}
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#setCalendarTime(java.util.GregorianCalendar)
	 */
	
	/* (non-Javadoc)
	 * @see com.pRemote.messages.IMessage#getCalendarValidUntill()
	 */
	@Override
	public GregorianCalendar getCalendarValidUntill() {
		GregorianCalendar cal=null;
		Date date;
		try {
			date = df.parse(validUntill);
			cal=new GregorianCalendar();
			cal.setTime(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return cal;
	}
	@Override
	public String toString() {
		String strMessage="";
		strMessage+=systemFrom+"_"+cellFrom+"_"+deviceFrom+"##";
		strMessage+=systemTo+"_"+cellTo+"_"+deviceTo+"##";
		strMessage+=operationType+"_"+operation+"_"+stateCause+"##";
		strMessage+=time+"##";
		strMessage+=validUntill;
		
		return strMessage;
	}

	
	
}
