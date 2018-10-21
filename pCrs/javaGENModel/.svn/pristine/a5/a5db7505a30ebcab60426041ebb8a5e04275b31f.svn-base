package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenConfig;


/**
 * This is an object that contains data related to the GEN_CONFIG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_CONFIG"
 */

public abstract class BaseGenConfig  implements Serializable, IGenConfig{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6214966958175083902L;
	public static String REF = "GenConfig";
	public static String PROP_TRN_VALUE = "TrnValue";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenConfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenConfig (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String trnValue;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="TRN_PARAM"
     */
	public java.lang.String getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TRN_VALUE
	 */
	public java.lang.String getTrnValue () {
		return trnValue;
	}

	/**
	 * Set the value related to the column: TRN_VALUE
	 * @param trnValue the TRN_VALUE value
	 */
	public void setTrnValue (java.lang.String trnValue) {
		this.trnValue = trnValue;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenConfig)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenConfig genConfig = (com.photel.data.gen.ddbb.hibernate.pojo.GenConfig) obj;
			if (null == this.getId() || null == genConfig.getId()) return false;
			else return (this.getId().equals(genConfig.getId()));
		}
	}

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


	public String toString () {
		return super.toString();
	}


}