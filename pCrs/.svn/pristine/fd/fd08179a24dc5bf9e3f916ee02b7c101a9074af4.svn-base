package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenScriptsSite;
import com.photel.interfaces.data.gen.IGenScriptsSitePK;


/**
 * This is an object that contains data related to the GEN_SCRIPTS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_SCRIPTS"
 */

public abstract class BaseGenScriptsSite  implements Serializable, IGenScriptsSite {

	public static String REF = "GenScriptsSite";
	public static String PROP_ID = "Id";
	public static String PROP_GEN_ORDER = "GenOrder";
	public static String PROP_GEN_VAL = "GenVal";
	public static String PROP_GEN_VALUE = "GenValue";


	// constructors
	public BaseGenScriptsSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenScriptsSite (IGenScriptsSitePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenScriptsSitePK id;

	// fields
	private java.lang.String genValue;
	private java.lang.Integer genOrder;
	private java.lang.String genVal;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public IGenScriptsSitePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (IGenScriptsSitePK id) {
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
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenScriptsSite)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenScriptsSite genScriptsSite = (com.photel.data.gen.ddbb.hibernate.pojo.GenScriptsSite) obj;
			if (null == this.getId() || null == genScriptsSite.getId()) return false;
			else return (this.getId().equals(genScriptsSite.getId()));
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