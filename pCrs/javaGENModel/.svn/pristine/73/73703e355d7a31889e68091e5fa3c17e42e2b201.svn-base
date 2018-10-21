package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenScripts;


/**
 * This is an object that contains data related to the GEN_SCRIPTS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_SCRIPTS"
 */

public abstract class BaseGenScripts  implements Serializable, IGenScripts {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3882250739197900420L;
	public static String REF = "GenScripts";
	public static String PROP_GEN_PARAM = "GenParam";
	public static String PROP_GEN_ORDER = "GenOrder";
	public static String PROP_GEN_VALUE = "GenValue";
	public static String PROP_GEN_VAL = "GenVal";


	// constructors
	public BaseGenScripts () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenScripts (java.lang.String genParam) {
		this.setGenParam(genParam);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String genParam;

	// fields
	private java.lang.String genValue;
	private java.lang.Integer genOrder;
	private java.lang.String genVal;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="GEN_PARAM"
     */
	public java.lang.String getGenParam () {
		return genParam;
	}

	/**
	 * Set the unique identifier of this class
	 * @param genParam the new ID
	 */
	public void setGenParam (java.lang.String genParam) {
		this.genParam = genParam;
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
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenScripts)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenScripts genScripts = (com.photel.data.gen.ddbb.hibernate.pojo.GenScripts) obj;
			if (null == this.getGenParam() || null == genScripts.getGenParam()) return false;
			else return (this.getGenParam().equals(genScripts.getGenParam()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getGenParam()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getGenParam().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}