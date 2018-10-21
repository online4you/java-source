package com.photel.commonServices.util;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.photel.commonServices.comparators.GenericCompartor;



public class SystemHelper {
	private static Logger oLog = Logger.getLogger(SystemHelper.class);
	private static AppModelProperties resourceApp;
	private static String maquina = null;
	
	private static void init(){
		maquina="Sin definir";
		try{
			resourceApp = new AppModelProperties();
			String nombreApp = resourceApp.getProperty("com.globalia.servires.nombreApp");
			InetAddress inetAddress = InetAddress.getLocalHost();
			nombreApp=inetAddress.getHostName()+ " - " + nombreApp;
			maquina = nombreApp;
		}catch (Exception e){
			oLog.error(e);
			maquina="Servires";
		}
	}
	public static <T> List<T> sortList(List<T> list, String sortBy,boolean sortDesc) throws Exception {
		GenericCompartor comp=new GenericCompartor();
		comp.setSortBy(sortBy);
		comp.setSortDesc(sortDesc);
		Collections.sort(list, comp);
		return list;
	}
	public static String getNombreMaquina(){
		if (maquina==null){
			init();
		}
		return maquina;
	}
	public static String getCallerName(){
		String method=Thread.currentThread().getStackTrace()[2].getMethodName();
		return method;
	}
	public static String getToken(){
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32).toUpperCase();
	}
	
	public static String getCalendarTo_ddMMYYYYHHmmss(Calendar cal) throws ParseException{
		String ret=null;
		if (cal!=null){
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		    ret=sdf.format(cal.getTime());
		}
		return ret;
	}
	public static String getCalendarTo_YYYYMMddHHmmss(Calendar cal) throws ParseException{
		String ret=null;
		if (cal!=null){
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		    ret=sdf.format(cal.getTime());
		}
		return ret;
	}
	public static String getCalendarTo_dd_mm_yyyy(Calendar cal) throws ParseException{
		String ret=null;
		if (cal!=null){
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    ret=sdf.format(cal.getTime());
		}
		return ret;
	}
	public static String getCalendarTo_ddMMYYYYHHmmssSSS(Calendar cal) throws ParseException{
		String ret=null;
		if (cal!=null){
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS");
		    ret=sdf.format(cal.getTime());
		}
		return ret;
	}
	
	
	public static Calendar getCalendarFromYYYYMMDD(String date) throws ParseException{
		Calendar ret=null;
		if (date!=null){
			Calendar cal= Calendar.getInstance();
			//arrivalDate= Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		    cal.setTime(sdf.parse(date));
		    ret=cal;
		}
		return ret;
	}
	
	
	public static Calendar getCalendarFromYYYYMMDD_HHMM(String date, String hour) throws ParseException{ //yyyyMMdd HHmm
		Calendar ret=null;
		if (date!=null){
			hour=hour!=null && hour.length()>4?hour.substring(0,4):hour;
			Calendar cal= Calendar.getInstance();
			//arrivalDate= Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmm");
		    cal.setTime(sdf.parse(date+" "+hour));
		    //oLog.info(cal.getTime().toString());
		    ret=cal;
		}
		return ret;
	}
	public static Calendar getCalendarFromDDMMYYYY(String date) throws ParseException{
		Calendar ret=null;
		if (date!=null){
			Calendar cal= Calendar.getInstance();
			//arrivalDate= Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    cal.setTime(sdf.parse(date));
		    ret=cal;
		}
		return ret;
	}
	public static String getCalendarTo_YYYY_MM_dd(Calendar cal) throws ParseException{
		String ret=null;
		if (cal!=null){
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    ret=sdf.format(cal.getTime());
		}
		return ret;
	}
	public static String getDateFromDDMONYYToYYYYMMDD(String date) throws ParseException{
		String ret=null;
		if (date!=null){
			Calendar cal= Calendar.getInstance();
			//arrivalDate= Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyy",Locale.ENGLISH);
		    cal.setTime(sdf.parse(date));
		    
		    
			if (cal != null) {
				sdf = new SimpleDateFormat("yyyyMMdd");
				ret = sdf.format(cal.getTime());
			}
		}
		return ret;
	}
	public static Calendar getNow(){
		return new GregorianCalendar();
	}
	public static String getUrlEncoded(String url) throws Exception {
		String encodedurl = URLEncoder.encode(url.toString(),"UTF-8"); 
		return encodedurl;
    }
	public static String getUrlDecoded(String url) throws Exception {
		String encodedurl = URLDecoder.decode(url.toString(),"UTF-8"); 
		return encodedurl;
    }
    public static String getUrl(String url) throws Exception {
    	StringBuffer ret=new StringBuffer();
        URL getUrl = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(getUrl.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
        	ret.append(inputLine);
        in.close();
        return ret.toString();
    }
	public static Exception mergeStackTraces(Throwable error1,Throwable error2){
		ArrayList<StackTraceElement> stackList1 = new ArrayList<StackTraceElement>(Arrays.asList(error1.getStackTrace()));
		ArrayList<StackTraceElement> stackList2 = new ArrayList<StackTraceElement>(Arrays.asList(error2.getStackTrace()));
		ArrayList<StackTraceElement> join=new ArrayList<StackTraceElement>();
		StackTraceElement sep = new StackTraceElement("â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�â•�","Join","", -3);
		join.addAll(stackList1);
		join.add(sep);
		join.addAll(stackList2);
		StackTraceElement[] stack = new StackTraceElement[join.size()];
		for(int i=0;i<join.size();i++){
			stack[i]=join.get(i);
		}
		String Message = error1.getMessage();
		Message=Message==null?error2.getMessage():Message;
		if (Message!=null && error2.getMessage()!=null && !Message.equals(error2.getMessage())){
			Message=Message+" "+error2.getMessage();
		}
		Exception e=new Exception(Message);
		e.setStackTrace(stack);
		return e;
    }
	public static String getTimeElapsed(Calendar cal){
		String ret="";
		Calendar ahora=new GregorianCalendar();
		long milis = ahora.getTimeInMillis() - cal.getTimeInMillis();
		long seconds = milis / 1000;
			
		ret=milis + " ms "+ seconds + " s ";
		return ret;
	}
	public static String getTimeElapsedMinutes(Calendar cal){
		String ret="";
		Calendar ahora=new GregorianCalendar();
		long milis = ahora.getTimeInMillis() - cal.getTimeInMillis();
		long seconds = milis / 1000;
		long minutes = seconds / 60;	
		
		ret=minutes+" min "+seconds + " s "+ milis + " ms ";
		return ret;
	}
	public static Long getTimeElapsedMilis(Calendar cal){
		Calendar ahora=new GregorianCalendar();
		long milis = ahora.getTimeInMillis() - cal.getTimeInMillis();
		Long ret=new Long(milis);
		return ret;
	}
	public static Long getTimeElapsedSeconds(Calendar cal){
		Calendar ahora=new GregorianCalendar();
		long milis = ahora.getTimeInMillis() - cal.getTimeInMillis();
		long seconds = milis / 1000;
		Long ret=new Long(seconds);
		return ret;
	}
	
	public static String getFileContents(File aFile) {
		aFile.setReadable(true);
		aFile.setWritable(true);
		aFile.setExecutable(true);
	    StringBuilder contents = new StringBuilder();
	    
	    try {
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null; 
	        while (( line = input.readLine()) != null){
	          contents.append(line);
	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }


	  public static void setFileContents(File aFile, String aContents)
	                                 throws FileNotFoundException, IOException {
	    if (aFile == null) {
	      throw new IllegalArgumentException("File should not be null.");
	    }
	    if (!aFile.exists()) {
		    aFile.createNewFile();
			aFile.setReadable(true);
			aFile.setWritable(true);
			aFile.setExecutable(true);
	    }
	    
	    if (!aFile.isFile()) {
	      throw new IllegalArgumentException("Should not be a directory: " + aFile);
	    }
	    if (!aFile.canWrite()) {
	      throw new IllegalArgumentException("File cannot be written: " + aFile);
	    }
	    Writer output = new BufferedWriter(new FileWriter(aFile));
	    try {
	      output.write( aContents );
	    }
	    finally {
	      output.close();
	    }
	  }
	
	  public static int getAge(Calendar dateOfBirth) {
		    return getAge(dateOfBirth, new GregorianCalendar());
		}
	
	  public static int getAge(Calendar dateOfBirth,Calendar dateToCompute) {
		    int age = 0;
		    if(dateOfBirth!= null) {
		        if(dateOfBirth.after(dateToCompute)) {
		            throw new IllegalArgumentException("Can't be born in the future");
		        }
		        age = dateToCompute.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);             
		        if(dateToCompute.get(Calendar.DAY_OF_YEAR) < dateOfBirth.get(Calendar.DAY_OF_YEAR))  {
		            age-=1;
		        }
		    }  
		    return age;
		}
}
