package com.photel.interfaces.data.gen;

public interface IGenLanresourceSite {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 */
	public abstract IGenLanresourceSitePK getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(IGenLanresourceSitePK id);

	/**
	 * Return the value associated with the column: GEN_DES
	 */
	public abstract java.lang.String getGenDes();

	/**
	 * Set the value related to the column: GEN_DES
	 * @param genDes the GEN_DES value
	 */
	public abstract void setGenDes(java.lang.String genDes);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}