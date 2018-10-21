package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenImagesSite;
import com.photel.interfaces.data.gen.IGenImagesSitePK;


/**
 * This is an object that contains data related to the GEN_IMAGES_SITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_IMAGES_SITE"
 */

public abstract class BaseGenImagesSite  implements Serializable, IGenImagesSite {

	public static String REF = "GenImagesSite";
	public static String PROP_GEN_TITLE = "GenTitle";
	public static String PROP_GEN_ALT = "GenAlt";
	public static String PROP_ID = "Id";
	public static String PROP_GEN_ORDER = "GenOrder";
	public static String PROP_GEN_VAL = "GenVal";
	public static String PROP_GEN_VALUE = "GenValue";


	// constructors
	public BaseGenImagesSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenImagesSite (IGenImagesSitePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenImagesSitePK id;

	// fields
	private java.lang.String genTitle;
	private java.lang.String genAlt;
	private java.lang.String genValue;
	private java.lang.Integer genOrder;
	private java.lang.String genVal;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public IGenImagesSitePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (IGenImagesSitePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: GEN_TITLE
	 */
	public java.lang.String getGenTitle () {
		return genTitle;
	}

	/**
	 * Set the value related to the column: GEN_TITLE
	 * @param genTitle the GEN_TITLE value
	 */
	public void setGenTitle (java.lang.String genTitle) {
		this.genTitle = genTitle;
	}



	/**
	 * Return the value associated with the column: GEN_ALT
	 */
	public java.lang.String getGenAlt () {
		return genAlt;
	}

	/**
	 * Set the value related to the column: GEN_ALT
	 * @param genAlt the GEN_ALT value
	 */
	public void setGenAlt (java.lang.String genAlt) {
		this.genAlt = genAlt;
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
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenImagesSite)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenImagesSite genImagesSite = (com.photel.data.gen.ddbb.hibernate.pojo.GenImagesSite) obj;
			if (null == this.getId() || null == genImagesSite.getId()) return false;
			else return (this.getId().equals(genImagesSite.getId()));
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