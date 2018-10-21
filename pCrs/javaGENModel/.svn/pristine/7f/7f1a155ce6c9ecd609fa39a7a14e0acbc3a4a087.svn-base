package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;
import java.util.ArrayList;

import com.photel.interfaces.data.gen.IGenClasesMenu;
import com.photel.interfaces.data.gen.IGenMenus;


/**
 * This is an object that contains data related to the GEN_MENUS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_MENUS"
 */

public abstract class BaseGenMenus  implements IGenMenus, Serializable {

	public static String REF = "GenMenus";
	public static String PROP_GMN_DES = "GmnDes";
	public static String PROP_GMN_CLASE = "GmnClase";
	public static String PROP_GMN_ORDER = "GmnOrder";
	public static String PROP_GMN_ETIQUETA = "GmnEtiqueta";
	public static String PROP_ID = "Id";
	public static String PROP_GMN_SUP = "GmnSup";
	public static String PROP_GMN_VAL = "GmnVal";
	public static String PROP_GMN_TITLE = "GmnTitle";
	public static String PROP_GMN_URL = "GmnUrl";
	

	// constructors
	public BaseGenMenus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenMenus (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGenMenus (
		java.lang.Integer id,
		IGenClasesMenu gmnClase) {

		this.setId(id);
		this.setGmnClase(gmnClase);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gmnEtiqueta;
	private java.lang.String gmnDes;
	private java.lang.String gmnTitle;
	private java.lang.String gmnUrl;
	private java.lang.String gmnVal;
	private java.lang.Integer gmnOrder;

	// many to one
	private IGenMenus gmnSup;
	private IGenClasesMenu gmnClase;
	
	// one to many
	private ArrayList<IGenMenus> gmnInf;

	
	
	public ArrayList<IGenMenus> getGmnInf() {
		return gmnInf;
	}

	public void setGmnInf(ArrayList<IGenMenus> gmnInf) {
		this.gmnInf = gmnInf;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="GMN_ID"
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
	 * Return the value associated with the column: GMN_ETIQUETA
	 */
	public java.lang.String getGmnEtiqueta () {
		return gmnEtiqueta;
	}

	/**
	 * Set the value related to the column: GMN_ETIQUETA
	 * @param gmnEtiqueta the GMN_ETIQUETA value
	 */
	public void setGmnEtiqueta (java.lang.String gmnEtiqueta) {
		this.gmnEtiqueta = gmnEtiqueta;
	}



	/**
	 * Return the value associated with the column: GMN_DES
	 */
	public java.lang.String getGmnDes () {
		return gmnDes;
	}

	/**
	 * Set the value related to the column: GMN_DES
	 * @param gmnDes the GMN_DES value
	 */
	public void setGmnDes (java.lang.String gmnDes) {
		this.gmnDes = gmnDes;
	}



	/**
	 * Return the value associated with the column: GMN_TITLE
	 */
	public java.lang.String getGmnTitle () {
		return gmnTitle;
	}

	/**
	 * Set the value related to the column: GMN_TITLE
	 * @param gmnTitle the GMN_TITLE value
	 */
	public void setGmnTitle (java.lang.String gmnTitle) {
		this.gmnTitle = gmnTitle;
	}



	/**
	 * Return the value associated with the column: GMN_URL
	 */
	public java.lang.String getGmnUrl () {
		return gmnUrl;
	}

	/**
	 * Set the value related to the column: GMN_URL
	 * @param gmnUrl the GMN_URL value
	 */
	public void setGmnUrl (java.lang.String gmnUrl) {
		this.gmnUrl = gmnUrl;
	}



	/**
	 * Return the value associated with the column: GMN_VAL
	 */
	public java.lang.String getGmnVal () {
		return gmnVal;
	}

	/**
	 * Set the value related to the column: GMN_VAL
	 * @param gmnVal the GMN_VAL value
	 */
	public void setGmnVal (java.lang.String gmnVal) {
		this.gmnVal = gmnVal;
	}



	/**
	 * Return the value associated with the column: GMN_ORDER
	 */
	public java.lang.Integer getGmnOrder () {
		return gmnOrder;
	}

	/**
	 * Set the value related to the column: GMN_ORDER
	 * @param gmnOrder the GMN_ORDER value
	 */
	public void setGmnOrder (java.lang.Integer gmnOrder) {
		this.gmnOrder = gmnOrder;
	}



	/**
	 * Return the value associated with the column: GMN_SUP
	 */
	public IGenMenus getGmnSup () {
		return gmnSup;
	}

	/**
	 * Set the value related to the column: GMN_SUP
	 * @param gmnSup the GMN_SUP value
	 */
	public void setGmnSup (IGenMenus gmnSup) {
		this.gmnSup = gmnSup;
	}



	/**
	 * Return the value associated with the column: GMN_CLASE
	 */
	public IGenClasesMenu getGmnClase () {
		return gmnClase;
	}

	/**
	 * Set the value related to the column: GMN_CLASE
	 * @param gmnClase the GMN_CLASE value
	 */
	public void setGmnClase (IGenClasesMenu gmnClase) {
		this.gmnClase = gmnClase;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof IGenMenus)) return false;
		else {
			IGenMenus genMenus = (IGenMenus) obj;
			if (null == this.getId() || null == genMenus.getId()) return false;
			else return (this.getId().equals(genMenus.getId()));
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