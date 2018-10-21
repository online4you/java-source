package com.photel.interfaces.data.gen;

public interface IGenConfigSite {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 */
	public abstract IGenConfigSitePK getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(IGenConfigSitePK id);

	/**
	 * Return the value associated with the column: GEN_VALUE
	 */
	public abstract java.lang.String getGenValue();

	/**
	 * Set the value related to the column: GEN_VALUE
	 * @param genValue the GEN_VALUE value
	 */
	public abstract void setGenValue(java.lang.String genValue);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}