package com.pRemote.apps.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.pRemote.apps.actions.MainAction;
import com.pRemote.apps.json.types.*;
import com.pRemote.interfaces.messages.IMessage;
import com.pRemote.messages.Message;
import com.pRemote.net.OutGoing;
import com.pRemote.pCell.Cell;

public class JsonOperateDevice extends MainAction {
	private static Cell cell;
	
	private String result;
	private String operation;
	
	@Override
	public String executeHalconAction() throws Exception {
		cell=cell==null?new Cell():cell;
		String cellIp=prop.getProperty("com.pRemote.publicIp");
		int cellPort=Integer.parseInt(prop.getProperty("com.pRemote.cellPort"));
		String dateFormat=prop.getProperty("com.pRemote.messageDateFormat");
		result="";
		if (operation!=null && !operation.equals("")){
			IMessage msg=new Message("0001_0001_0001##0000_0000_0001##ONOFF_"+operation.toUpperCase()+"_AUTO##20/09/2012 23:00:00:000##20/09/2012 23:30:00:000",dateFormat);
			result=cell.sendMessageToCell(msg, cellIp, cellPort);
			msg=new Message(result,dateFormat);
			result=msg.getOperation();
		}	
		setRoot();
		return SUCCESS;
	}
	
	private void setRoot(){
		ValueStack stack = ActionContext.getContext().getValueStack();    
		//Object obj = stack.findValue("pcrsModel");
		stack.set("JsonOperateDevice",this);
	}

	public String getResult() {
		return result;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	
	
	

}
