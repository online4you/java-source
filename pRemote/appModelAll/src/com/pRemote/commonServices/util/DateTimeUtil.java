package com.pRemote.commonServices.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeUtil {
	 public static String now() {
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	        return sdf.format(cal.getTime());
	      }
	 public static String formatCalendar(Calendar cal) {
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	        return sdf.format(cal.getTime());
	      }
	 public static long getElapsetTime(Calendar cal1,Calendar cal2) {
	    	if (cal1!=null && cal1!=null){
		    	try{
	    		long milis1 = cal1.getTimeInMillis(); 
		        long milis2 = cal2.getTimeInMillis(); 
		        long diff = Math.abs(milis2 - milis1); 
		        long diffMinutes = diff / (60 * 1000); 
		        long diffHours = diff / (60 * 60 * 1000); 
		        long diffDays = diff / (24 * 60 * 60 * 1000); 
		        return diff;
		    	} catch (Exception e){
		    		return 0;
		    	}
	    	}
	    	return 0;
	      }
	 
	 public static  String getFormatedHour(String hora){
			String h=hora.substring(0,2);
			String min=hora.substring(2,4);
			return h+":"+min;
		}
	 public static  String formatDate(String date){
			String ret=null;
	        if (date==null){
	        	return ret;}
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	        try { 
	        	Date fecha = df.parse(date);
	        	Calendar cal=new GregorianCalendar ();
	        	cal.setTime(fecha);
	        	String month = String.valueOf(cal.get(Calendar.MONTH)+1);
	        	String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	        	if (month.length()==1){month="0"+month;}
	        	if (day.length()==1){day="0"+day;}
	        	ret= String.valueOf(cal.get(Calendar.YEAR)) + month + day;  
	        } catch (Exception e) { 
	            return null;} 
			return ret;
		}
		
	 public static  Calendar getCalendar(String data, String hora){
			String anyo=data.substring(0,4);
			String mes=data.substring(4,6);
			String dia=data.substring(6,8);
			String h=hora.substring(0,2);
			String min=hora.substring(2,4);

			Calendar cal=new GregorianCalendar();
			cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dia));
			cal.set(Calendar.MONTH, Integer.parseInt(mes)-1);
			cal.set(Calendar.YEAR, Integer.parseInt(anyo));
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(h));
			cal.set(Calendar.MINUTE,Integer.parseInt(min));

			return cal;
		}
}
