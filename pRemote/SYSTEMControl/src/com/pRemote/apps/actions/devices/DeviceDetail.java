package com.pRemote.apps.actions.devices;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.pRemote.apps.actions.MainAction;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.interfaces.pCell.devices.IDevice;
import com.pRemote.messages.Message;
import com.pRemote.pCell.pojo.devices.Device_ONOFF;

public class DeviceDetail extends MainAction{

	private static final long serialVersionUID = 1L;
	private String systemId;
	private String cellId;
	private String deviceId;
	private String keyId;
	private IDevice device;
	private String deviceType;
	private int maxMessages;
	
	@Override
	public String executeHalconAction() throws Exception {
		String result=SUCCESS;
		maxMessages=5;
		systemId=(String) this.getUserInfo().get("activeSistemId");
		if (keyId!=null && !keyId.equals("")){
			deviceType=keyId.split("##")[1];
			cellId=keyId.split("##")[2];
			deviceId=keyId.split("##")[3];
		}
		boolean deviceLoaded=true;
		
		deviceLoaded=systemId==null && !systemId.equals("")?false:deviceLoaded;
		deviceLoaded=cellId==null && !cellId.equals("")?false:deviceLoaded;
		deviceLoaded=deviceId==null && !deviceId.equals("")?false:deviceLoaded;
		deviceLoaded=deviceType==null && !deviceType.equals("")?false:deviceLoaded;
		
		if(deviceLoaded){
			
			if (deviceType.equals(TYPE_ONOFF)){
				device=new Device_ONOFF();
				device.setId(deviceId);
				device.setCellId(cellId);
				device.setSystemId(systemId);
				device.setLastInfoState(new GregorianCalendar());
				if (deviceId.equals("0000")){
					device.setName("Televisor");
					device.setState("ON");
					device.setStateCause("AUTO");
					//http://www.shutterstock.com
					device.setImgUrl("/static/main/images/devicesIcons/fountain.jpg");
					device.setInfoMessages(getDummyMessages());
				}
				
			}else{
				result=ERROR;
			}
			
			
			
			
		}else{
			result=ERROR;
		}
		
		
		return result;
	}
	
	public String getToday(){
		return getDateToStringDDMMYYYY(new GregorianCalendar());
	}
	private List<IMessage> getDummyMessages(){
		List<IMessage> messages=new ArrayList<IMessage>();
		GregorianCalendar cal = new GregorianCalendar();
		String time = getDateToString(cal);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		String validUntill=getDateToString(cal);
		IMessage msg=new Message("0000_0000_0000##0000_0000_"+deviceId+"##ONOFF_ON_AUTO##"+time+"##"+validUntill,dateFormat);
		for (int i=0;i<10;i++){
			messages.add(msg);
		}
		
		return messages;
	}
	
	public List<String> getHoras(){
		List<String> ret=new ArrayList<String>();
		String str;
		for (int i=0;i<24;i++){
			str=String.valueOf(i);
			str=str.length()==1?"0"+str:str;
			ret.add(str);
		}
		return ret;
	}
	public List<String> getMinutes(){
		List<String> ret=new ArrayList<String>();
		String str;
		for (int i=0;i<60;i++){
			str=String.valueOf(i);
			str=str.length()==1?"0"+str:str;
			ret.add(str);
		}
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

	
	
	
	
	

	public int getMaxMessages() {
		return maxMessages;
	}

	public void setMaxMessages(int maxMessages) {
		this.maxMessages = maxMessages;
	}

	public String getKeyId() {
		return keyId;
	}





	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}





	public IDevice getDevice() {
		return device;
	}





	public void setDevice(IDevice device) {
		this.device = device;
	}





	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	

}
