package com.photel.interfaces.data.gen;

public interface IGenClasesMenu {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="sequence"
	 *  column="GCM_ID"
	 */
	public abstract java.lang.Integer getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(java.lang.Integer id);

	/**
	 * Return the value associated with the column: GCM_DES
	 */
	public abstract java.lang.String getGcmDes();

	/**
	 * Set the value related to the column: GCM_DES
	 * @param gcmDes the GCM_DES value
	 */
	public abstract void setGcmDes(java.lang.String gcmDes);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();
	public java.lang.String getGcmIdi();

	public void setGcmIdi(java.lang.String gcmIdi);

}