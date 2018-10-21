package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenImages;


/**
 * This is an object that contains data related to the GEN_IMAGES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_IMAGES"
 */

public abstract class BaseGenImages  implements Serializable, IGenImages {

	/**
	 * 
	 */
	private static final long serialVersionUID = -596504329783997700L;
	public static String REF = "GenImages";
	public static String PROP_GEN_ORDER = "GenOrder";
	public static String PROP_GEN_VALUE = "GenValue";
	public static String PROP_GEN_ALT = "GenAlt";
	public static String PROP_GEN_TITLE = "GenTitle";
	public static String PROP_GEN_VAL = "GenVal";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenImages () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenImages (com.photel.interfaces.data.gen.IGenImagesPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.photel.interfaces.data.gen.IGenImagesPK id;

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
	public com.photel.interfaces.data.gen.IGenImagesPK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.photel.interfaces.data.gen.IGenImagesPK id) {
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
		if (!(obj instanceof com.photel.interfaces.data.gen.IGenImages)) return false;
		else {
			com.photel.interfaces.data.gen.IGenImages genImages = (com.photel.interfaces.data.gen.IGenImages) obj;
			if (null == this.getId() || null == genImages.getId()) return false;
			else return (this.getId().equals(genImages.getId()));
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