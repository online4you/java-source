package com.photel.model.gen.objects;

import java.io.Serializable;
import java.util.Hashtable;

import com.photel.interfaces.model.gen.sesion.ISesion;

public class Sesion implements Serializable,ISesion {
	private String id;
	private Hashtable<String,Object> sesion;
	/* (non-Javadoc)
	 * @see com.photel.model.gen.objects.ISesion#getId()
	 */
	public String getId() {
		return id;
	}
	/* (non-Javadoc)
	 * @see com.photel.model.gen.objects.ISesion#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see com.photel.model.gen.objects.ISesion#getSesion()
	 */
	public Hashtable<String, Object> getSesion() {
		return sesion;
	}
	/* (non-Javadoc)
	 * @see com.photel.model.gen.objects.ISesion#setSesion(java.util.Hashtable)
	 */
	public void setSesion(Hashtable<String, Object> sesion) {
		this.sesion = sesion;
	}
	
}
