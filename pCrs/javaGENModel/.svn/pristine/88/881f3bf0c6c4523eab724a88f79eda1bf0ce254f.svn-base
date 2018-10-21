package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenCache;


/**
 * This is an object that contains data related to the GEN_CACHE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_CACHE"
 */

public abstract class BaseGenCache  implements Serializable, IGenCache {

	public static String REF = "GenCache";
	public static String PROP_TRD_TIMCRE = "TrdTimcre";
	public static String PROP_TRD_DETALLE = "TrdDetalle";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenCache () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenCache (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private String trdDetalle;
	private java.util.Date trdTimcre;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#getId()
	 */
	public java.lang.String getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#setId(java.lang.String)
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TRD_DETALLE
	 */
	public String getTrdDetalle () {
		return trdDetalle;
	}

	/**
	 * Set the value related to the column: TRD_DETALLE
	 * @param trdDetalle the TRD_DETALLE value
	 */
	public void setTrdDetalle (String trdDetalle) {
		this.trdDetalle = trdDetalle;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#getTrdTimcre()
	 */
	public java.util.Date getTrdTimcre () {
		return trdTimcre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#setTrdTimcre(java.util.Date)
	 */
	public void setTrdTimcre (java.util.Date trdTimcre) {
		this.trdTimcre = trdTimcre;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenCache)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenCache genCache = (com.photel.data.gen.ddbb.hibernate.pojo.GenCache) obj;
			if (null == this.getId() || null == genCache.getId()) return false;
			else return (this.getId().equals(genCache.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#hashCode()
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
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenCache#toString()
	 */
	public String toString () {
		return super.toString();
	}


}