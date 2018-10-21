package com.pRemote.commonServices.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TimeUtil {
	private GregorianCalendar ini;
	private long diffMilis;
	private long diffMinutes;
	private long diffHours;
	private long diffDays;
    
	public TimeUtil(){
		super();
		setIni();
	}
	public void setIni(){
		this.ini=new GregorianCalendar();
	}
	public void setFin(){
		GregorianCalendar fin = new GregorianCalendar();
		long milis1 = ini.getTimeInMillis(); 
		long milis2 = fin.getTimeInMillis(); 
		diffMilis = Math.abs(milis2 - milis1); 
		diffMinutes = diffMilis / (60 * 1000); 
	    diffHours = diffMilis / (60 * 60 * 1000); 
	    diffDays = diffMilis / (24 * 60 * 60 * 1000); 
	}
	public void setFin(GregorianCalendar ini){
		this.ini=ini;
		setFin();
	}
	
	public GregorianCalendar getIni() {
		return ini;
	}
	public void setIni(GregorianCalendar ini) {
		this.ini = ini;
	}
	public long getDiffMilis() {
		return diffMilis;
	}
	public long getDiffMinutes() {
		return diffMinutes;
	}
	public long getDiffHours() {
		return diffHours;
	}
	public long getDiffDays() {
		return diffDays;
	}
	
	
	
}
