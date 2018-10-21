package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenLanResource;


/**
 * This is an object that contains data related to the GEN_LANRESOURCE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_LANRESOURCE"
 */

public abstract class BaseGenLanresource  implements Serializable, IGenLanResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 184565063767658404L;
	public static String REF = "GenLanresource";
	public static String PROP_TRL_DES = "TrlDes";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenLanresource () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenLanresource (com.photel.interfaces.data.gen.IGenLanResourcePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private com.photel.interfaces.data.gen.IGenLanResourcePK id;

	// fields
	private java.lang.String trlDes;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     */
	public com.photel.interfaces.data.gen.IGenLanResourcePK getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (com.photel.interfaces.data.gen.IGenLanResourcePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: TRL_DES
	 */
	public java.lang.String getTrlDes () {
		return trlDes;
	}

	/**
	 * Set the value related to the column: TRL_DES
	 * @param trlDes the TRL_DES value
	 */
	public void setTrlDes (java.lang.String trlDes) {
		this.trlDes = trlDes;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenLanresource)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenLanresource genLanresource = (com.photel.data.gen.ddbb.hibernate.pojo.GenLanresource) obj;
			if (null == this.getId() || null == genLanresource.getId()) return false;
			else return (this.getId().equals(genLanresource.getId()));
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