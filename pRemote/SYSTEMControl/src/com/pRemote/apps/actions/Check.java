package com.pRemote.apps.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pRemote.net.OutGoing;

public class Check extends MainAction{

	private static final long serialVersionUID = 1L;
	private String message="ON";


	@Override
	public String executeHalconAction() {
		OutGoing soc = new OutGoing();
		soc.doSendMessage("[0001_0001_0001##0000_0000_0001##ONOFF_"+message.toUpperCase()+"##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000]");
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
