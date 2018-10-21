package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenLanresourceSite;
import com.photel.interfaces.data.gen.IGenLanresourceSitePK;


/**
 * This is an object that contains data related to the GEN_LANRESOURCE_SITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_LANRESOURCE_SITE"
 */

public abstract class BaseGenLanresourceSite  implements Serializable, IGenLanresourceSite {

	public static String REF = "GenLanresourceSite";
	public static String PROP_ID = "Id";
	public static String PROP_GEN_DES = "GenDes";


	// constructors
	public BaseGenLanresourceSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenLanresourceSite (IGenLanresourceSitePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenLanresourceSitePK id;

	// fields
	private java.lang.String genDes;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public IGenLanresourceSitePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (IGenLanresourceSitePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: GEN_DES
	 */
	public java.lang.String getGenDes () {
		return genDes;
	}

	/**
	 * Set the value related to the column: GEN_DES
	 * @param genDes the GEN_DES value
	 */
	public void setGenDes (java.lang.String genDes) {
		this.genDes = genDes;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourceSite)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourceSite genLanresourceSite = (com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourceSite) obj;
			if (null == this.getId() || null == genLanresourceSite.getId()) return false;
			else return (this.getId().equals(genLanresourceSite.getId()));
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