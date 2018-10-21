package com.photel.interfaces.data.BDL;

public interface IBdlDestinationsPK extends java.io.Serializable {

	/**
	 * Return the value associated with the column: BDL_CODE
	 */
	public abstract java.lang.String getBdlCode();

	/**
	 * Set the value related to the column: BDL_CODE
	 * @param bdlCode the BDL_CODE value
	 */
	public abstract void setBdlCode(java.lang.String bdlCode);

	/**
	 * Return the value associated with the column: BDL_IDI
	 */
	public abstract java.lang.String getBdlIdi();

	/**
	 * Set the value related to the column: BDL_IDI
	 * @param bdlIdi the BDL_IDI value
	 */
	public abstract void setBdlIdi(java.lang.String bdlIdi);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

}