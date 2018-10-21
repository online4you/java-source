package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TIPOS_PAGO table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="TIPOS_PAGO"
 */

public abstract class BaseTiposPago  implements Serializable {

	public static String REF = "TiposPago";
	public static String PROP_TPA_DESCRIPCION = "TpaDescripcion";
	public static String PROP_ID = "id";


	// constructors
	public BaseTiposPago () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTiposPago (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String tpaDescripcion;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="TPA_CODPAGO"
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
	 * Return the value associated with the column: TPA_DESCRIPCION
	 */
	public java.lang.String getTpaDescripcion () {
		return tpaDescripcion;
	}

	/**
	 * Set the value related to the column: TPA_DESCRIPCION
	 * @param tpaDescripcion the TPA_DESCRIPCION value
	 */
	public void setTpaDescripcion (java.lang.String tpaDescripcion) {
		this.tpaDescripcion = tpaDescripcion;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.TiposPago)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.TiposPago tiposPago = (com.photel.data.gen.ddbb.hibernate.pojo.TiposPago) obj;
			if (null == this.getId() || null == tiposPago.getId()) return false;
			else return (this.getId().equals(tiposPago.getId()));
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