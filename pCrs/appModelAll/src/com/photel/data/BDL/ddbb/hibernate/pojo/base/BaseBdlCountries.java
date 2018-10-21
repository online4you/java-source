package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlCountries;
import com.photel.interfaces.data.BDL.IBdlCountriesPK;


/**
 * This is an object that contains data related to the bdl_countries table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_countries"
 */

public abstract class BaseBdlCountries  implements Serializable, IBdlCountries {

	public static String REF = "BdlCountries";
	public static String PROP_BDL_DESCRIPTION = "BdlDescription";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlCountries () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlCountries (IBdlCountriesPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlCountries (
		IBdlCountriesPK id,
		java.lang.String bdlDescription) {

		this.setId(id);
		this.setBdlDescription(bdlDescription);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlCountriesPK id;

	// fields
	private java.lang.String bdlDescription;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#getId()
	 */
	@Override
	public IBdlCountriesPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#setId(com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK)
	 */
	@Override
	public void setId (IBdlCountriesPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#getBdlDescription()
	 */
	@Override
	public java.lang.String getBdlDescription () {
		return bdlDescription;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#setBdlDescription(java.lang.String)
	 */
	@Override
	public void setBdlDescription (java.lang.String bdlDescription) {
		this.bdlDescription = bdlDescription;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlCountries)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlCountries bdlCountries = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlCountries) obj;
			if (null == this.getId() || null == bdlCountries.getId()) return false;
			else return (this.getId().equals(bdlCountries.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountries#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}