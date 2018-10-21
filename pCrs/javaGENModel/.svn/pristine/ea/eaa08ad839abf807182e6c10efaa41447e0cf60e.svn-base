package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenClasesMenu;


/**
 * This is an object that contains data related to the GEN_CLASES_MENU table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_CLASES_MENU"
 */

public abstract class BaseGenClasesMenu  implements Serializable, IGenClasesMenu {

	public static String REF = "GenClasesMenu";
	public static String PROP_GCM_DES = "GcmDes";
	public static String PROP_ID = "Id";
	public static String PROP_GMC_IDI = "GcmIdi";

	// constructors
	public BaseGenClasesMenu () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenClasesMenu (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gcmDes;
	private java.lang.String gcmIdi;


	public java.lang.String getGcmIdi() {
		return gcmIdi;
	}

	public void setGcmIdi(java.lang.String gcmIdi) {
		this.gcmIdi = gcmIdi;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="GCM_ID"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: GCM_DES
	 */
	public java.lang.String getGcmDes () {
		return gcmDes;
	}

	/**
	 * Set the value related to the column: GCM_DES
	 * @param gcmDes the GCM_DES value
	 */
	public void setGcmDes (java.lang.String gcmDes) {
		this.gcmDes = gcmDes;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenClasesMenu)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenClasesMenu genClasesMenu = (com.photel.data.gen.ddbb.hibernate.pojo.GenClasesMenu) obj;
			if (null == this.getId() || null == genClasesMenu.getId()) return false;
			else return (this.getId().equals(genClasesMenu.getId()));
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