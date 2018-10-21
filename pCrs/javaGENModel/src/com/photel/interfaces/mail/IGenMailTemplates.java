package com.photel.interfaces.mail;

public interface IGenMailTemplates {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  column="GMT_TITLE"
	 */
	public abstract java.lang.String getGmtTitle();

	/**
	 * Set the unique identifier of this class
	 * @param gmtTitle the new ID
	 */
	public abstract void setGmtTitle(java.lang.String gmtTitle);

	/**
	 * Return the value associated with the column: GMT_TEMPLATE
	 */
	public abstract java.lang.String getGmtTemplate();

	/**
	 * Set the value related to the column: GMT_TEMPLATE
	 * @param gmtTemplate the GMT_TEMPLATE value
	 */
	public abstract void setGmtTemplate(java.lang.String gmtTemplate);

	/**
	 * Return the value associated with the column: GMT_VAL
	 */
	public abstract java.lang.String getGmtVal();

	/**
	 * Set the value related to the column: GMT_VAL
	 * @param gmtVal the GMT_VAL value
	 */
	public abstract void setGmtVal(java.lang.String gmtVal);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}