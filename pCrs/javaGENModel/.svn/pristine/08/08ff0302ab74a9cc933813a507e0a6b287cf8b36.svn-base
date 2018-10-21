package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenConfigSite;
import com.photel.interfaces.data.gen.IGenConfigSitePK;


/**
 * This is an object that contains data related to the GEN_CONFIG_SITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_CONFIG_SITE"
 */

public abstract class BaseGenConfigSite  implements Serializable, IGenConfigSite {

	public static String REF = "GenConfigSite";
	public static String PROP_ID = "Id";
	public static String PROP_GEN_VALUE = "GenValue";


	// constructors
	public BaseGenConfigSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenConfigSite (IGenConfigSitePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenConfigSitePK id;

	// fields
	private java.lang.String genValue;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public IGenConfigSitePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (IGenConfigSitePK id) {
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenConfigSite)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenConfigSite genConfigSite = (com.photel.data.gen.ddbb.hibernate.pojo.GenConfigSite) obj;
			if (null == this.getId() || null == genConfigSite.getId()) return false;
			else return (this.getId().equals(genConfigSite.getId()));
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