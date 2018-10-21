package com.photel.interfaces.model.gen.sesion;

import java.util.Hashtable;

public interface ISesion {

	public abstract String getId();

	public abstract void setId(String id);

	public abstract Hashtable<String, Object> getSesion();

	public abstract void setSesion(Hashtable<String, Object> sesion);

}