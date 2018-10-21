package com.photel.interfaces.data.BDL;

public interface IBdlHotelDestinationsPK extends java.io.Serializable{

	/**
	 * Return the value associated with the column: BDL_COUNTRY_CODE
	 */
	public abstract java.lang.String getBdlCountryCode();

	/**
	 * Set the value related to the column: BDL_COUNTRY_CODE
	 * @param bdlCountryCode the BDL_COUNTRY_CODE value
	 */
	public abstract void setBdlCountryCode(java.lang.String bdlCountryCode);

	/**
	 * Return the value associated with the column: BDL_DESTINATION_CODE
	 */
	public abstract java.lang.String getBdlDestinationCode();

	/**
	 * Set the value related to the column: BDL_DESTINATION_CODE
	 * @param bdlDestinationCode the BDL_DESTINATION_CODE value
	 */
	public abstract void setBdlDestinationCode(
			java.lang.String bdlDestinationCode);

	public abstract boolean equals(Object obj);

	public abstract int hashCode();

}