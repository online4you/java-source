package com.pRemote.apps.json;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.pRemote.apps.actions.MainAction;
import com.pRemote.apps.json.types.*;

public class JsonDevices extends MainAction {
	
	private String text;
	private List<Node> children;
	
	
	@Override
	public String executeHalconAction() {
		text=".";
		
		children=getNodes();
		
		setRoot();
		return SUCCESS;
	}
	
	private List<Node> getNodes(){
		ArrayList<Node> ch=ch = new ArrayList<Node>();
		Node node;
		ArrayList<Node> childs;
		
		
		childs = new ArrayList<Node>();
		//node = createNode("Nombre","Tipo","id-D##type##cellId##deviceId","task",true,null);
		node = createNode("Televisor","Dispositivo","D##ONOFF##0000##0000","task",true,true,null);
		childs.add(node);
		node = createNode("Lampara","Dispositivo","D##ONOFF##0000##0001","task",true,true,null);
		childs.add(node);
		
		node = createNode("Habitacion","Grupo","G##0001","task-folder",false,true,childs);
		ch.add(node);
		
		childs = new ArrayList<Node>();
		node = createNode("Lago","Dispositivo","D##ONOFF##0000##0002","task",true,true,null);
		childs.add(node);
		node = createNode("Luz exterior","Dispositivo","D##ONOFF##0000##0003","task",true,true,null);
		childs.add(node);
		
		node = createNode("Patio","Grupo","G##0001","task-folder",false,true,childs);
		ch.add(node);
		
		childs = new ArrayList<Node>();
		node = createNode("Puerta","Dispositivo","D##ONOFF##0000##0004","task",true,true,null);
		childs.add(node);
		node = createNode("Iluminacion","Dispositivo","D##ONOFF##0000##0005","task",true,true,null);
		childs.add(node);
		
		node = createNode("Garaje","Grupo","G##0001","task-folder",false,true,childs);
		ch.add(node);
		
		return ch;
	}
	
	private Node createNode(
			String device,
			String type,
			String deviceId,
			String iconCls,
			boolean leaf,
			boolean expanded,
			List<Node> children){
		
		Node ret=new Node();
		ret.setDevice(device);
		ret.setType(type);
		ret.setDeviceId(deviceId);
		ret.setIconCls(iconCls);
		ret.setLeaf(leaf);
		ret.setExpanded(expanded);
		ret.setChildren(children);
		return ret;
	}
	private void setRoot(){
		ValueStack stack = ActionContext.getContext().getValueStack();    
		//Object obj = stack.findValue("pcrsModel");
		stack.set("jsonDevices",this);
	}
	public String getText() {
		return text;
	}
	public List<Node> getChildren() {
		return children;
	}
	
	
	

}
