package com.pRemote.apps.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.pRemote.commonServices.util.AppModelProperties;

public abstract class MainAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware  {
	public static final String TYPE_ONOFF="ONOFF";
	protected String messageDateFormat;
	protected String dateFormat;
	protected String messageDateFormatNoMilis;
	protected static AppModelProperties prop;
	protected boolean debug=false;
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String login;
	protected Hashtable<String, Object> userInfo;
	protected String loginMessage;
	protected String mainPage;
	protected String doLogin;
	
    Logger  log = Logger.getLogger(this.getClass().getName());
    
    public boolean isDebug() {
		return debug;
	}
	public final String execute() throws Exception{
		prop=prop==null?new AppModelProperties():prop;
		messageDateFormat=prop.getProperty("com.pRemote.messageDateFormat");
		messageDateFormatNoMilis=prop.getProperty("com.pRemote.messageDateFormatNoMilis");
		dateFormat=prop.getProperty("com.pRemote.dateFormat");
		
		
		return executeHalconAction();
    }
	
	public abstract String executeHalconAction() throws Exception;
	
	public String getDateToStringDDMMYYYY(GregorianCalendar cal){
		 Date date = cal.getTime();
		 SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		 return sdf.format(date);
	}
	public String getDateToString(GregorianCalendar cal){
		 Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(messageDateFormat);
        return sdf.format(date);
	}
	public String getDateToStringNoMilis(GregorianCalendar cal){
		 Date date = cal.getTime();
       SimpleDateFormat sdf = new SimpleDateFormat(messageDateFormatNoMilis);
       return sdf.format(date);
	}
	
	public String getContextPath() {
		if (this.request!=null){
			return this.request.getContextPath();
		}else{
			return "";
		}
		
	}
	
	
	
	
	
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
	public void setLogin(String login) {
		this.login=login;
		
	}
	public void setUserInfo(Hashtable<String, Object> userInfo) {
		this.userInfo=userInfo;
		
	}
	public String getLoginMessage() {
		return loginMessage;
	}
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}
	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	public String getDoLogin() {
		return doLogin;
	}
	public void setDoLogin(String doLogin) {
		this.doLogin = doLogin;
	}
	public String getLogin() {
		return login;
	}
	public Hashtable<String, Object> getUserInfo() {
		return userInfo;
	}
	
	
}
