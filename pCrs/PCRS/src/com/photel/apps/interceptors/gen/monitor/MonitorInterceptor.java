package com.photel.apps.interceptors.gen.monitor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.photel.model.PCRSModel;

public class MonitorInterceptor extends AbstractInterceptor  implements Interceptor{

	private static final long serialVersionUID = -515101379788196361L;
	private String model;
	private String parametrosPeticion;
	private String monitorAll;
	private String actionsToMonitor;
    public String obtenerNombreMaquina(){
    	String maquina=null;
		try{
			InetAddress inetAddress = InetAddress.getLocalHost();
			maquina = inetAddress.getHostName();
		} catch(UnknownHostException e){}
		return maquina;
    } 
    
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result;
		if (parametrosPeticion!=null && !parametrosPeticion.equalsIgnoreCase("")){
			String urlFrom;
			String headers;
			String url;
			String protocol;
			String params;
			String preSession;
			String postSession;
			String ip;
			String host;
			Hashtable<String,String> peticion=new Hashtable<String,String>();
			PCRSModel service;
			String[] actions;
			String toString;
			
			ActionContext acc = invocation.getInvocationContext();
			HttpServletRequest req = (HttpServletRequest) acc.getContext().get(ServletActionContext.HTTP_REQUEST);
			Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
			Map<String, Object> ses = invocation.getInvocationContext().getSession();
			ActionInvocation in = acc.getActionInvocation();
			ValueStack stack = ActionContext.getContext().getValueStack();
			
			
			urlFrom= req.getHeader("referer");
			url=req.getRequestURI();
			protocol = req.getProtocol();
			headers= getHeaders(req);
			params=getParamsToString(parameters);
			preSession=getMapToString(ses);
			ip=req.getRemoteAddr();
			host=obtenerNombreMaquina();
			
			urlFrom=(urlFrom==null ? "" : urlFrom);
			url=(url==null ? "" : url);
			headers=(headers==null ? "" : headers);
			params=(params==null ? "" : params);
			preSession=(preSession==null ? "" : preSession);
			ip=(ip==null ? "" : ip);
			host=(host==null ? "" : host);

			
			peticion.put("urlFrom", urlFrom);
			peticion.put("url", url);
			peticion.put("protocol", protocol);
			peticion.put("headers", headers);
			peticion.put("params", params);
			peticion.put("preSession", preSession);
			peticion.put("ip", ip);
			peticion.put("host", host);
			peticion.put("Action", acc.getName());
			
			stack.set(parametrosPeticion, peticion);
			
					
			Object obj = stack.findValue(model);
			if (obj instanceof PCRSModel){
				service=(PCRSModel) obj;
				Hashtable<String, String> config = service.getGenConfig();
				if (config.get("monitorAll")!=null){monitorAll=config.get("monitorAll");}
				if (config.get("actionsToMonitor")!=null){actionsToMonitor=config.get("actionsToMonitor");}
				if (monitorAll!=null && monitorAll.equalsIgnoreCase("true")){
					toString=getMapToString(peticion);
					service.setMonitor(0, url, urlFrom, headers, params, preSession, ip, host, acc.getName(), toString);
				}else{
					if (actionsToMonitor!=null && !actionsToMonitor.equalsIgnoreCase("")){
						actions=actionsToMonitor.split(",");
						for (int i=0;i<actions.length;i++){
							if (acc.getName().equalsIgnoreCase(actions[i].trim())){
								toString=getMapToString(peticion);
								url=url!=null && url.length()>250?url.substring(0,249):url;
								urlFrom=urlFrom!=null && urlFrom.length()>250?urlFrom.substring(0,249):urlFrom;
								headers=headers!=null && headers.length()>2000?headers.substring(0,1999):headers;
								params=params!=null && params.length()>4000?params.substring(0,3999):params;
								preSession=preSession!=null && preSession.length()>2000?preSession.substring(0,1999):preSession;
								ip=ip!=null && ip.length()>50?ip.substring(0,49):ip;
								host=host!=null && host.length()>250?host.substring(0,249):host;
								toString=toString!=null && toString.length()>4000?toString.substring(0,3999):toString;
								
								service.setMonitor(0, url, urlFrom, headers, params, preSession, ip, host, acc.getName(), toString);
							}
						}
					}
				}
				
				
				
			}
			
			
			
		}
		
		
		result=invocation.invoke();
		
		
		
		
		return result;
	}
	private String getMapToString(Map map){
		String ret="";
		if (map!=null){
			Iterator<String> paramNames = map.keySet().iterator();
			String paramName ;
		    while(paramNames.hasNext()) {
		        paramName = paramNames.next();
		        ret+= "VALUE:"+paramName+"="+map.get(paramName) + " \n";
		    }	
		}
	    return ret;
	    
	}
	private String getParamsToString(Map map){
		String ret="";
		String[] params;
		String paramName ;
		String paramValue ;
		if (map!=null){
			Iterator<String> paramNames = map.keySet().iterator();
			
		    while(paramNames.hasNext()) {
		    	paramValue="";
		        paramName = paramNames.next();
		        if (map.get(paramName) instanceof String[]){
		        	params=(String[]) map.get(paramName);
		        	for (int i=0;i<params.length;i++){
			        	paramValue+=params[i];}
		        }else {
		        	paramValue=(String) map.get(paramName);
		        }
		        
		        
		        ret+= "PARAM:"+paramName+"="+paramValue + " \n";
		    }	
		}
	    return ret;
	    
	}

	private String getHeaders(HttpServletRequest req){
		Enumeration<String> paramNames = req.getHeaderNames();
		String paramName ;
		String ret="";
	    while(paramNames.hasMoreElements()) {
	        paramName = paramNames.nextElement();
	        ret+= "HEADER:"+paramName+"="+req.getHeader(paramName) + " \n";
	    }	
	    return ret;
	    
	}
	
	public String getParametrosPeticion() {
		return parametrosPeticion;
	}
	public void setParametrosPeticion(String parametrosPeticion) {
		this.parametrosPeticion = parametrosPeticion;
	}
	public String getMonitorAll() {
		return monitorAll;
	}
	public void setMonitorAll(String monitorAll) {
		this.monitorAll = monitorAll;
	}
	public String getActionsToMonitor() {
		return actionsToMonitor;
	}
	public void setActionsToMonitor(String actionsToMonitor) {
		this.actionsToMonitor = actionsToMonitor;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}


}
