package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenStylesSite;
import com.photel.interfaces.data.gen.IGenStylesSitePK;


/**
 * This is an object that contains data related to the GEN_STYLES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_STYLES"
 */

public abstract class BaseGenStylesSite  implements Serializable, IGenStylesSite {

	public static String REF = "GenStylesSite";
	public static String PROP_ID = "Id";
	public static String PROP_GEN_ORDER = "GenOrder";
	public static String PROP_GEN_VAL = "GenVal";
	public static String PROP_GEN_VALUE = "GenValue";


	// constructors
	public BaseGenStylesSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenStylesSite (IGenStylesSitePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenStylesSitePK id;

	// fields
	private java.lang.String genValue;
	private java.lang.Integer genOrder;
	private java.lang.String genVal;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public IGenStylesSitePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (IGenStylesSitePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: GEN_VALUE
	 */
	public java.lang.String getGenValue () {
		return genValue;
	}

	/**
	 * Set the value related to the column: GEN_VALUE
	 * @param genValue the GEN_VALUE value
	 */
	public void setGenValue (java.lang.String genValue) {
		this.genValue = genValue;
	}



	/**
	 * Return the value associated with the column: GEN_ORDER
	 */
	public java.lang.Integer getGenOrder () {
		return genOrder;
	}

	/**
	 * Set the value related to the column: GEN_ORDER
	 * @param genOrder the GEN_ORDER value
	 */
	public void setGenOrder (java.lang.Integer genOrder) {
		this.genOrder = genOrder;
	}



	/**
	 * Return the value associated with the column: GEN_VAL
	 */
	public java.lang.String getGenVal () {
		return genVal;
	}

	/**
	 * Set the value related to the column: GEN_VAL
	 * @param genVal the GEN_VAL value
	 */
	public void setGenVal (java.lang.String genVal) {
		this.genVal = genVal;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenStylesSite)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenStylesSite genStylesSite = (com.photel.data.gen.ddbb.hibernate.pojo.GenStylesSite) obj;
			if (null == this.getId() || null == genStylesSite.getId()) return false;
			else return (this.getId().equals(genStylesSite.getId()));
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