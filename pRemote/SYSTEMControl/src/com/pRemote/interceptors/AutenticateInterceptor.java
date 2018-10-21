package com.pRemote.interceptors;



import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;
import com.pRemote.apps.actions.MainAction;

public class AutenticateInterceptor implements Interceptor{
	
	private Hashtable<String,Object> getUserInfo(ActionContext acc){
		HttpServletRequest res = (HttpServletRequest) acc.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = res.getSession();
		Hashtable<String,Object> userInfo=(Hashtable<String,Object>) session.getAttribute("userInfo");
		return userInfo;
	}
	private void setUserInfo(ActionContext acc,Hashtable<String,Object> userInfo){
		HttpServletRequest res = (HttpServletRequest) acc.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = res.getSession();
		session.setAttribute("userInfo",userInfo);

	}
	private String getInitPage(ActionContext acc){
			HttpServletRequest res = (HttpServletRequest) acc.getContext().get(ServletActionContext.HTTP_REQUEST);
			String path = res.getContextPath();
			return path+"/apps/pRemote/DashBoard.html";
	}

	private void removeUserInfo(ActionContext acc){
		HttpServletRequest res = (HttpServletRequest) acc.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = res.getSession();
		session.removeAttribute("userInfo");
	}
	
	private boolean isLogedIn(ActionContext acc) throws RemoteException{
		boolean ret=false;
		Hashtable<String,Object> userInfo=getUserInfo(acc);
		if(userInfo!=null){
			String tiempo = "10"; //10 min
			tiempo=tiempo==null?"0":tiempo;
			if (!tiempo.equalsIgnoreCase("0")){
				GregorianCalendar when = (GregorianCalendar)userInfo.get("timestamp");
				when=(GregorianCalendar) when.clone();
				GregorianCalendar now = new GregorianCalendar();
				when.add(Calendar.MINUTE, Integer.parseInt(tiempo));
				if(when.compareTo(now)>0){
					ret=true;
				}
			}else{
				
				ret=true;
			}
		}
		return ret;
	}
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	public void init() {
		// TODO Auto-generated method stub
		
	}
	private String getParam(ActionContext acc, String param){
		Map<String, Object> params = acc.getParameters();
		Object ret= params.get(param);
		String strRet=null;
		try{strRet=(String) ret;}
		catch(Exception e1){
			try{strRet=((String[]) ret)[0];}
			catch(Exception e2){strRet=null;}
			}
		return strRet;
	}
	public String intercept(ActionInvocation invocation) throws Exception {
		String result;
		ActionContext acc = invocation.getInvocationContext();
		ValueStack stack = acc.getValueStack();
		
		
		boolean loged = isLogedIn(acc);
		stack.setValue("mainPage", getInitPage(acc));
		String strUser=getParam(acc,"username");
		String strPpassword=getParam(acc,"password");
		String strDisconect=getParam(acc,"disconect");

		if(loged){
			if (stack.findString("doLogin")==null){
				if (strDisconect!=null){
					result = "login";
					stack.setValue("doLogin", "doLogin");
					removeUserInfo(acc);
					
				}else{	
					Object main =  invocation.getAction();
					if (main instanceof MainAction){
						((MainAction) main).setLogin("logedIn");
						((MainAction) main).setUserInfo(this.getUserInfo(acc));
					}
					result = invocation.invoke();
				}
			}else{
				result=null;
			}
		}else{
			if (strUser!=null && strPpassword!=null){
				Hashtable<String, Object> userInfo = new Hashtable<String, Object>();
				if (strUser.equals("demo") && strPpassword.equals("demo")){
					userInfo.put(strUser, strPpassword);
					userInfo.put("timestamp", new GregorianCalendar());
					userInfo.put("activeSistemId", "0000");
					setUserInfo(acc,userInfo);
					Object main =  invocation.getAction();
					if (main instanceof MainAction){
						((MainAction) main).setLogin("logedIn");
						((MainAction) main).setUserInfo(userInfo);
					}
					result = invocation.invoke();
				}else{
						Object main =  invocation.getAction();
						
						if (main instanceof MainAction){
							stack.setValue("loginMessage",((MainAction) main).getText("lang.gen.login.badUserPass"));
						}
						result = "login";
					}
				}
			}
			if (stack.findString("doLogin")==null){
				result = "login";
				stack.setValue("doLogin", "doLogin");
			}else{
				result=null;
			}
			
		return result;
	}
}
