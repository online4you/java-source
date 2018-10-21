package com.photel.apps.interceptors.gen.session;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

import com.photel.interfaces.model.gen.sesion.ISesion;
import com.photel.model.PCRSModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class GetSessionInterceptor  implements Interceptor{

	private static final long serialVersionUID = -2197546882431135086L;
	private String model;
	private String  parametrosPeticion;
	
	
	protected String getSesion(ActionInvocation invocation) throws SQLException, Exception{
		ActionContext acc = invocation.getInvocationContext();
		Map<String, Object> ses = invocation.getInvocationContext().getSession();
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
			ValueStack stack = ActionContext.getContext().getValueStack();
			Object obj = stack.findValue("halconModel");
			PCRSModel service;
			ISesion beanSesion=null;
			if (obj instanceof PCRSModel){
				service = (PCRSModel) obj;
				if (stack.findValue("beanSesion")!=null){
					beanSesion = (ISesion) stack.findValue("beanSesion");
				}else{
					Object objs = parameters.get("idSesion");
					String sesParam=null;
					if (objs instanceof String[]){
						sesParam=((String[])objs)[0];
					}else if(objs instanceof String){
						sesParam=(String)objs;
					}
					
					beanSesion = service.getGenSesion(sesParam);
				}
				stack.setValue("beanSesion", beanSesion);
				
				if (beanSesion.getSesion()!=null){
					hastableToMap(ses,beanSesion);
					//ses=beanSesion.getSesion();
				}
				ses.put("sesionId", beanSesion.getId());
				return beanSesion.getId();
			}
		return null;
	}
	protected void setSesion(ActionInvocation invocation,String actSesion) throws SQLException, Exception{
		ActionContext acc = invocation.getInvocationContext();
		Map<String, Object> ses = invocation.getInvocationContext().getSession();
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
			ValueStack stack = ActionContext.getContext().getValueStack();
			Object obj = stack.findValue(model);
			PCRSModel service;
			if (obj instanceof PCRSModel){
				service = (PCRSModel) obj;
				if(actSesion!=null && !actSesion.equalsIgnoreCase("")){
				//service.setGenSesion(actSesion, (Hashtable<String, Object>) ses);
				service.setGenSesion(actSesion, (Hashtable<String, Object>) getMapToHastable(ses));
				}
			}
		
		delSession(invocation);
	}
	protected void hastableToMap(Map<String, Object> ses,ISesion beanSesion){
		Iterator<String> ite = null;
		String key;
		//Una vez ejecutacada la acción recogemos los parámetros de sesión
		Set<String> keys = beanSesion.getSesion().keySet();// ses.keySet();
		ite = keys.iterator();
		while (ite.hasNext()){
			key=ite.next();
			ses.put(key, beanSesion.getSesion().get(key));
		}
	}
	protected Hashtable<String,Object> getMapToHastable(Map<String, Object> ses){
		Hashtable<String,Object> hTable = new Hashtable();
		Iterator<String> ite = null;
		String key;
		//Una vez ejecutacada la acción recogemos los parámetros de sesión
		Set<String> keys = ses.keySet();
		ite = keys.iterator();
		while (ite.hasNext()){
			key=ite.next();
			hTable.put(key,ses.get(key));
		}
		return hTable;
	}
	/*metodo de Hashtable -->Map   y otro de Map--> Hashtable*/
	
	protected void delSession (ActionInvocation invocation){
		Map<String, Object> ses = invocation.getInvocationContext().getSession();
		Iterator<String> ite = null;
		String key;
		//Una vez ejecutacada la acción recogemos los parámetros de sesión
		Set<String> keys = ses.keySet();
		ite = keys.iterator();
		while (ite.hasNext()){
			key=ite.next();
			ses.remove(key);
		}
	}
	private PCRSModel getService(){
		ValueStack stack = ActionContext.getContext().getValueStack();
		Object obj = stack.findValue(model);
		PCRSModel service=null;
		if (obj instanceof PCRSModel){
			service = (PCRSModel) obj;
		}
		return service;
	}
	public String intercept(ActionInvocation invocation)throws Exception {
			String result;
			Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
			String setSession = (String) parameters.get("setSession");
			String deleteSession = (String) parameters.get("deleteSession");
			String actSesion=null;
			PCRSModel serv = getService();
			
			
			String log = "invocation.getInvocationContext().getName()=" + invocation.getInvocationContext().getName() + "\n";
			
			
			if (setSession!=null && setSession.equalsIgnoreCase("true")){
				log+="\t invocation.getInvocationContext().getName()=" + invocation.getInvocationContext().getName() + "\n";
				String nullStr=null;
				serv.setTracking("INFO", actSesion, nullStr,nullStr, nullStr, this.getClass().getName(), "intercept", log,	nullStr, nullStr, getParam("host"), "OL4U", nullStr);
				parameters.put("setSession","false");
				actSesion = getSesion(invocation);
				
			}
			
			result = invocation.invoke();//frontera before after
			
			if (actSesion!=null && deleteSession!=null && deleteSession.equalsIgnoreCase("true")){
				log+="\t invocation.getInvocationContext().getName()=" + invocation.getInvocationContext().getName() + "\n";
				String nullStr=null;
				serv.setTracking("INFO", actSesion, nullStr,nullStr, nullStr, this.getClass().getName(), "intercept", log,	nullStr, nullStr, getParam("host"), "OL4U", nullStr);
				parameters.put("deleteSession","false");
				setSesion(invocation, actSesion);
				
			}
			
			return result;
				
	}

	private String getParam(String parametroPeticion){
		ValueStack stack = ActionContext.getContext().getValueStack();
		Object obj = stack.findValue(parametrosPeticion);
		Hashtable<String,String> param=null;
		if (obj instanceof Hashtable){
			param = (Hashtable<String,String>) obj;
			return param.get(parametroPeticion);
		}
		return null;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	public String getParametrosPeticion() {
		return parametrosPeticion;
	}
	public void setParametrosPeticion(String parametrosPeticion) {
		this.parametrosPeticion = parametrosPeticion;
	}
	

}