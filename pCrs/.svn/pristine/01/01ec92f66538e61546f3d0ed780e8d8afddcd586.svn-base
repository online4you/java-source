package com.photel.apps.actions;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fechaEntrada="20130401";
		String fechaSalida="20130404";
		System.out.println("fechaEntrada="+fechaEntrada);
		System.out.println("fechaSalida="+fechaSalida);
		
		Calendar fini=getCalendar(fechaEntrada, "0000");
		Calendar ffin=getCalendar(fechaSalida, "0200");
		System.out.println("fechaEntrada="+fini.getTime().toString());
		System.out.println("fechaSalida="+ffin.getTime().toString());
		
		String noches = String.valueOf(getElapsetTimeDays(fini, ffin));
	
		System.out.println("noches="+noches);
	}

	public static Calendar getCalendar(String data, String hora){
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
		cal.set(Calendar.MILLISECOND, 0);
		TimeZone utc = TimeZone.getTimeZone("CET"); 
		cal.setTimeZone(utc);
		return cal;
	}
	
	public static long getElapsetTimeDays(Calendar cal1,Calendar cal2) {
	    	if (cal1!=null && cal1!=null){
		    	try{
	    		long milis1 = cal1.getTimeInMillis(); 
		        long milis2 = cal2.getTimeInMillis(); 
		        long diff = Math.abs(milis2 - milis1); 
		        long diffMinutes = diff / (60 * 1000); 
		        long diffHours = diff / (60 * 60 * 1000); 
		        long diffDays = diff / (24 * 60 * 60 * 1000); 
		        return diffDays;
		    	} catch (Exception e){
		    		return 0;
		    	}
	    	}
	    	return 0;
	      }
}
