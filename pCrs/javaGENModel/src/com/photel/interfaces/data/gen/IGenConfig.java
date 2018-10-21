package com.photel.interfaces.data.gen;

public interface IGenConfig {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  column="TRN_PARAM"
	 */
	public java.lang.String getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId(java.lang.String id);

	/**
	 * Return the value associated with the column: TRN_VALUE
	 */
	public java.lang.String getTrnValue();

	/**
	 * Set the value related to the column: TRN_VALUE
	 * @param trnValue the TRN_VALUE value
	 */
	public void setTrnValue(java.lang.String trnValue);

	public boolean equals(Object obj);

	public int hashCode();

	public String toString();

}