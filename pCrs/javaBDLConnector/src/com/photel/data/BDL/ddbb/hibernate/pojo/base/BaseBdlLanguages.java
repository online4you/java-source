package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlLanguages;


/**
 * This is an object that contains data related to the bdl_languages table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_languages"
 */

public abstract class BaseBdlLanguages  implements Serializable,IBdlLanguages {

	public static String REF = "BdlLanguages";
	public static String PROP_BDL_DESCRIPTION = "BdlDescription";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlLanguages () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlLanguages (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlLanguages (
		java.lang.String id,
		java.lang.String bdlDescription) {

		this.setId(id);
		this.setBdlDescription(bdlDescription);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bdlDescription;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="BDL_CODE"
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
	 * Return the value associated with the column: BDL_DESCRIPTION
	 */
	public java.lang.String getBdlDescription () {
		return bdlDescription;
	}

	/**
	 * Set the value related to the column: BDL_DESCRIPTION
	 * @param bdlDescription the BDL_DESCRIPTION value
	 */
	public void setBdlDescription (java.lang.String bdlDescription) {
		this.bdlDescription = bdlDescription;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlLanguages)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlLanguages bdlLanguages = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlLanguages) obj;
			if (null == this.getId() || null == bdlLanguages.getId()) return false;
			else return (this.getId().equals(bdlLanguages.getId()));
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