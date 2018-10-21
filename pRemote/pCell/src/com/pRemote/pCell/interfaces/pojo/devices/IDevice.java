package com.pRemote.pCell.interfaces.pojo.devices;

import java.util.GregorianCalendar;

public interface IDevice {

	public static final String STATECAUSE_FORCED = "FORCED";
	public static final String STATECAUSE_AUTO = "AUTO";
	
	public abstract String getId();

	public abstract void setId(String id);

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getState();

	public abstract void setState(String state);
	public GregorianCalendar getLastInfoState();
	public void setLastInfoState(GregorianCalendar lastInfoState);
}