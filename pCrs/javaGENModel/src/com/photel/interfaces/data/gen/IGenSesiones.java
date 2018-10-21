package com.photel.interfaces.data.gen;

public interface IGenSesiones {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="sequence"
	 *  column="GSE_ID"
	 */
	public abstract java.lang.Integer getGseId();

	/**
	 * Set the unique identifier of this class
	 * @param gseId the new ID
	 */
	public abstract void setGseId(java.lang.Integer gseId);

	/**
	 * Return the value associated with the column: GSE_IDSESION
	 */
	public abstract java.lang.String getGseIdSesion();

	/**
	 * Set the value related to the column: GSE_IDSESION
	 * @param gseIdSesion the GSE_IDSESION value
	 */
	public abstract void setGseIdSesion(java.lang.String gseIdSesion);

	/**
	 * Return the value associated with the column: GSE_SESION
	 */
	public abstract java.lang.String getGseSesion();

	/**
	 * Set the value related to the column: GSE_SESION
	 * @param gseSesion the GSE_SESION value
	 */
	public abstract void setGseSesion(java.lang.String gseSesion);

	/**
	 * Return the value associated with the column: GSE_TIMCRE
	 */
	public abstract java.util.Date getGseTimCre();

	/**
	 * Set the value related to the column: GSE_TIMCRE
	 * @param gseTimCre the GSE_TIMCRE value
	 */
	public abstract void setGseTimCre(java.util.Date gseTimCre);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}