package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenVOpciones;
import com.photel.interfaces.data.gen.IGenVOpcionesPK;


/**
 * This is an object that contains data related to the GENV_OPCIONES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GENV_OPCIONES"
 */

public abstract class BaseGenvOpciones  implements Serializable, IGenVOpciones {

	public static String REF = "GenvOpciones";
	public static String PROP_GOP_DES = "GopDes";
	public static String PROP_GOP_LNKOPC = "GopLnkopc";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenvOpciones () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenvOpciones (IGenVOpcionesPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenVOpcionesPK id;

	// fields
	private java.lang.String gopLnkopc;
	private java.lang.String gopDes;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#getId()
	 */
	public IGenVOpcionesPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#setId(com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK)
	 */
	public void setId (IGenVOpcionesPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#getGopLnkopc()
	 */
	public java.lang.String getGopLnkopc () {
		return gopLnkopc;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#setGopLnkopc(java.lang.String)
	 */
	public void setGopLnkopc (java.lang.String gopLnkopc) {
		this.gopLnkopc = gopLnkopc;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#getGopDes()
	 */
	public java.lang.String getGopDes () {
		return gopDes;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#setGopDes(java.lang.String)
	 */
	public void setGopDes (java.lang.String gopDes) {
		this.gopDes = gopDes;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenvOpciones)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenvOpciones genvOpciones = (com.photel.data.gen.ddbb.hibernate.pojo.GenvOpciones) obj;
			if (null == this.getId() || null == genvOpciones.getId()) return false;
			else return (this.getId().equals(genvOpciones.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpciones#toString()
	 */
	public String toString () {
		return super.toString();
	}


}