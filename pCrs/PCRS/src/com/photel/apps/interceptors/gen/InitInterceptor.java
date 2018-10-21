package com.photel.apps.interceptors.gen;



import java.io.File;
import java.io.PrintWriter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.photel.model.PCRSModel;

public class InitInterceptor implements Interceptor {

	private static final long serialVersionUID = 7403928023774103836L;
	public static boolean isRegistered = false; 
    private static Logger log=Logger.getLogger(InitInterceptor.class.getName());
	private String model;
    private String serviceIp;
    private String servicePort;
    private String serviceName;
    private static boolean isFirstExecution=true;
    
    
    


	public void destroy() {
		
		if(isRegistered){ 
	         try { 
	     		if (serviceIp!=null && servicePort!=null && serviceName!=null && !serviceIp.equalsIgnoreCase("") && !servicePort.equalsIgnoreCase("") && !serviceName.equalsIgnoreCase("")){	 
	        	 Registry registry = LocateRegistry.getRegistry(1099);
	             registry.unbind("rmi://"+serviceIp+":"+servicePort+"/"+serviceName);
	             
	     		}
	             isRegistered = false; 
	             
	         } catch (Exception e) { 
	             e.printStackTrace(); 
	         } 
	     }
		
	}

	public void init() {
		try {
			createResources();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private  void createResources() throws RemoteException, SQLException, Exception{
		PCRSModel service = getService();
		if (isFirstExecution){
			isFirstExecution=false;
			Hashtable<String, String> conf = service.getGenConfig();
			Hashtable<String, StringBuffer> res = service.getAllResources();
			Enumeration<String> k = res.keys();
			String key;
			String path;
			if (conf.get("ResourcesPrefijo")!=null && conf.get("ResourcesPath")!=null){
		   		while (k.hasMoreElements()) {
		   		  key = k.nextElement();
				   		try {
				   			path = this.getClass().getProtectionDomain().getCodeSource().getLocation()+"";
							path=path.substring("file:/".length(),path.lastIndexOf("/"))+"/";
							path=path.substring(0,path.indexOf("classes"))+"classes/"+conf.get("ResourcesPath");
							path+=conf.get("ResourcesPrefijo")+"_"+key+".properties";
							path="/"+path;
							
							log.info(path);
							
							File flt =new File(path);
							flt.createNewFile();
							PrintWriter out = new PrintWriter(flt, "ISO-8859-1"); 
							StringBuffer buf = res.get(key);
							out.print(buf.toString());
						    out.flush();
						    out.close();
				   	    }
				   	    catch (Exception e) {
				   	      e.printStackTrace();
				   	    }
		
		
		   		  }
			}
		}
	}
	



	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext acc = invocation.getInvocationContext();
		ValueStack stack = acc.getValueStack();
		Object loadedModel = stack.findValue(model);
		PCRSModel service = null;
		if (loadedModel==null){
			service = getService();
			stack.set(model, service);
		}
		if(!isRegistered){ 
			bindService();
			tryService();
		}
		String result = invocation.invoke();
		
		if (service!=null){
			service.clearSession();
			service.closeSession();
		}
		service=null;
		//stack.setValue(model, null);
		
		return result;
	}

	private PCRSModel getService() throws Exception{ 
		return new PCRSModel();
	}
	
	private void tryService() throws SQLException, Exception{
		if (serviceIp!=null && servicePort!=null && serviceName!=null && !serviceIp.equalsIgnoreCase("") && !servicePort.equalsIgnoreCase("") && !serviceName.equalsIgnoreCase("")){	 
			try{
			Registry registry = LocateRegistry.getRegistry(serviceIp,Integer.parseInt(servicePort)); 
			String[] names = registry.list(); 
			PCRSModel serv = (PCRSModel) registry.lookup("rmi://"+serviceIp+":"+servicePort+"/"+serviceName);
			}catch (Exception e){
				
			}	
		}
	}
	private void bindService() throws SQLException, Exception{
		if (serviceIp!=null && servicePort!=null && serviceName!=null && !serviceIp.equalsIgnoreCase("") && !servicePort.equalsIgnoreCase("") && !serviceName.equalsIgnoreCase("")){
			isRegistered=true;
			Registry registry = LocateRegistry.createRegistry(Integer.parseInt(servicePort)); 
			try{
				registry.unbind("rmi://"+serviceIp+":"+servicePort+"/"+serviceName);
				String[] names = registry.list(); 
				boolean isThere=false;
				for (int i=0;i<names.length;i++){
					if (names[i].equalsIgnoreCase(serviceName)){
						isThere = true;
					}
				}
				if(!isThere){
					registry.rebind("rmi://"+serviceIp+":"+servicePort+"/"+serviceName, getService());
				}
			}catch (Exception e){
				
			}
		}
	}
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getServiceIp() {
		return serviceIp;
	}

	public void setServiceIp(String serviceIp) {
		this.serviceIp = serviceIp;
	}

	public String getServicePort() {
		return servicePort;
	}

	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	} 
	
	
}
