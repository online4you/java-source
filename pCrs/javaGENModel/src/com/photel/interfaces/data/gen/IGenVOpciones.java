package com.photel.interfaces.data.gen;

public interface IGenVOpciones {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 */
	public abstract IGenVOpcionesPK getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(IGenVOpcionesPK id);

	/**
	 * Return the value associated with the column: GOP_LNKOPC
	 */
	public abstract java.lang.String getGopLnkopc();

	/**
	 * Set the value related to the column: GOP_LNKOPC
	 * @param gopLnkopc the GOP_LNKOPC value
	 */
	public abstract void setGopLnkopc(java.lang.String gopLnkopc);

	/**
	 * Return the value associated with the column: GOP_DES
	 */
	public abstract java.lang.String getGopDes();

	/**
	 * Set the value related to the column: GOP_DES
	 * @param gopDes the GOP_DES value
	 */
	public abstract void setGopDes(java.lang.String gopDes);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}