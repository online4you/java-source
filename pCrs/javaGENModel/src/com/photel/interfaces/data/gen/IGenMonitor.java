package com.photel.interfaces.data.gen;

public interface IGenMonitor {

	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 *  generator-class="sequence"
	 *  column="GER_ERROR_ID"
	 */
	public abstract java.lang.Integer getId();

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public abstract void setId(java.lang.Integer id);

	/**
	 * Return the value associated with the column: GER_URL
	 */
	public abstract java.lang.String getGerUrl();

	/**
	 * Set the value related to the column: GER_URL
	 * @param gerUrl the GER_URL value
	 */
	public abstract void setGerUrl(java.lang.String gerUrl);

	/**
	 * Return the value associated with the column: GER_URLFROM
	 */
	public abstract java.lang.String getGerUrlfrom();

	/**
	 * Set the value related to the column: GER_URLFROM
	 * @param gerUrlfrom the GER_URLFROM value
	 */
	public abstract void setGerUrlfrom(java.lang.String gerUrlfrom);

	/**
	 * Return the value associated with the column: GER_HEADERS
	 */
	public abstract java.lang.String getGerHeaders();

	/**
	 * Set the value related to the column: GER_HEADERS
	 * @param gerHeaders the GER_HEADERS value
	 */
	public abstract void setGerHeaders(java.lang.String gerHeaders);

	/**
	 * Return the value associated with the column: GER_PARAMS
	 */
	public abstract java.lang.String getGerParams();

	/**
	 * Set the value related to the column: GER_PARAMS
	 * @param gerParams the GER_PARAMS value
	 */
	public abstract void setGerParams(java.lang.String gerParams);

	/**
	 * Return the value associated with the column: GER_SESSION
	 */
	public abstract java.lang.String getGerSession();

	/**
	 * Set the value related to the column: GER_SESSION
	 * @param gerSession the GER_SESSION value
	 */
	public abstract void setGerSession(java.lang.String gerSession);

	/**
	 * Return the value associated with the column: GER_IP
	 */
	public abstract java.lang.String getGerIp();

	/**
	 * Set the value related to the column: GER_IP
	 * @param gerIp the GER_IP value
	 */
	public abstract void setGerIp(java.lang.String gerIp);

	/**
	 * Return the value associated with the column: GER_HOST
	 */
	public abstract java.lang.String getGerHost();

	/**
	 * Set the value related to the column: GER_HOST
	 * @param gerHost the GER_HOST value
	 */
	public abstract void setGerHost(java.lang.String gerHost);

	/**
	 * Return the value associated with the column: GER_ACTION
	 */
	public abstract java.lang.String getGerAction();

	/**
	 * Set the value related to the column: GER_ACTION
	 * @param gerAction the GER_ACTION value
	 */
	public abstract void setGerAction(java.lang.String gerAction);

	/**
	 * Return the value associated with the column: GER_TOSTRING
	 */
	public abstract java.lang.String getGerTostring();

	/**
	 * Set the value related to the column: GER_TOSTRING
	 * @param gerTostring the GER_TOSTRING value
	 */
	public abstract void setGerTostring(java.lang.String gerTostring);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

	public abstract String toString();

}