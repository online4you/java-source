package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenMetas;


/**
 * This is an object that contains data related to the GEN_METAS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_METAS"
 */

public abstract class BaseGenMetas  implements Serializable, IGenMetas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7626701770146892161L;
	public static String REF = "GenMetas";
	public static String PROP_TRN_VALUE = "TrnValue";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenMetas () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenMetas (java.lang.String id) {
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
     *  column="GEN_PARAM"
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
	 * Return the value associated with the column: GEN_VALUE
	 */
	public java.lang.String getTrnValue () {
		return trnValue;
	}

	/**
	 * Set the value related to the column: GEN_VALUE
	 * @param trnValue the GEN_VALUE value
	 */
	public void setTrnValue (java.lang.String trnValue) {
		this.trnValue = trnValue;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenMetas)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenMetas genMetas = (com.photel.data.gen.ddbb.hibernate.pojo.GenMetas) obj;
			if (null == this.getId() || null == genMetas.getId()) return false;
			else return (this.getId().equals(genMetas.getId()));
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