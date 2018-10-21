package com.pRemote.apps.actions.general;

import com.pRemote.apps.actions.MainAction;

public class DashBoard extends MainAction{

	private static final long serialVersionUID = 1L;
	private String message="ON";


	@Override
	public String executeHalconAction() {
		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
