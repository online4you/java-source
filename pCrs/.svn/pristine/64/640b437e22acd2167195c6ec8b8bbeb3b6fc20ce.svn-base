package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenSesiones;


/**
 * This is an object that contains data related to the GEN_SESIONES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_SESIONES"
 */

public abstract class BaseGenSesiones  implements Serializable, IGenSesiones {

	public static String REF = "GenSesiones";
	public static String PROP_GSE_ID_SESION = "gseIdSesion";
	public static String PROP_GSE_TIM_CRE = "gseTimCre";
	public static String PROP_GSE_SESION = "gseSesion";
	public static String PROP_GSE_ID = "gseId";


	// constructors
	public BaseGenSesiones () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenSesiones (java.lang.Integer gseId) {
		this.setGseId(gseId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer gseId;

	// fields
	private java.lang.String gseIdSesion;
	private java.lang.String gseSesion;
	private java.util.Date gseTimCre;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#getGseId()
	 */
	public java.lang.Integer getGseId () {
		return gseId;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#setGseId(java.lang.Integer)
	 */
	public void setGseId (java.lang.Integer gseId) {
		this.gseId = gseId;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#getGseIdSesion()
	 */
	public java.lang.String getGseIdSesion () {
		return gseIdSesion;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#setGseIdSesion(java.lang.String)
	 */
	public void setGseIdSesion (java.lang.String gseIdSesion) {
		this.gseIdSesion = gseIdSesion;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#getGseSesion()
	 */
	public java.lang.String getGseSesion () {
		return gseSesion;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#setGseSesion(java.lang.String)
	 */
	public void setGseSesion (java.lang.String gseSesion) {
		this.gseSesion = gseSesion;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#getGseTimCre()
	 */
	public java.util.Date getGseTimCre () {
		return gseTimCre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#setGseTimCre(java.util.Date)
	 */
	public void setGseTimCre (java.util.Date gseTimCre) {
		this.gseTimCre = gseTimCre;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenSesiones)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenSesiones genSesiones = (com.photel.data.gen.ddbb.hibernate.pojo.GenSesiones) obj;
			if (null == this.getGseId() || null == genSesiones.getGseId()) return false;
			else return (this.getGseId().equals(genSesiones.getGseId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getGseId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getGseId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenSesiones#toString()
	 */
	public String toString () {
		return super.toString();
	}


}