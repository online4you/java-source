package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlHotels;


/**
 * This is an object that contains data related to the bdl_hotels table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_hotels"
 */

public abstract class BaseBdlHotels  implements Serializable, IBdlHotels {

	public static String REF = "BdlHotels";
	public static String PROP_BDL_NAME = "BdlName";
	public static String PROP_BDL_LATITUDE = "BdlLatitude";
	public static String PROP_BDL_CAT = "BdlCat";
	public static String PROP_BDL_LONGITUDE = "BdlLongitude";
	public static String PROP_BDL_DESTINATION = "BdlDestination";
	public static String PROP_ID = "Id";
	public static String PROP_BDL_CHAIN = "BdlChain";
	public static String PROP_BDL_LICENCE = "BdlLicence";
	public static String PROP_BDL_ZONE = "BdlZone";
	

	// constructors
	public BaseBdlHotels () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlHotels (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bdlName;
	private java.lang.String bdlCat;
	private java.lang.String bdlDestination;
	private java.lang.String bdlZone;
	private java.lang.String bdlChain;
	private java.lang.String bdlLicence;
	private java.lang.String bdlLatitude;
	private java.lang.String bdlLongitude;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getId()
	 */
	@Override
	public java.lang.String getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setId(java.lang.String)
	 */
	@Override
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlName()
	 */
	@Override
	public java.lang.String getBdlName () {
		return bdlName;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlName(java.lang.String)
	 */
	@Override
	public void setBdlName (java.lang.String bdlName) {
		this.bdlName = bdlName;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlCat()
	 */
	@Override
	public java.lang.String getBdlCat () {
		return bdlCat;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlCat(java.lang.String)
	 */
	@Override
	public void setBdlCat (java.lang.String bdlCat) {
		this.bdlCat = bdlCat;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlDestination()
	 */
	@Override
	public java.lang.String getBdlDestination () {
		return bdlDestination;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlDestination(java.lang.String)
	 */
	@Override
	public void setBdlDestination (java.lang.String bdlDestination) {
		this.bdlDestination = bdlDestination;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlZone()
	 */
	@Override
	public java.lang.String getBdlZone () {
		return bdlZone;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlZone(java.lang.String)
	 */
	@Override
	public void setBdlZone (java.lang.String bdlZone) {
		this.bdlZone = bdlZone;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlChain()
	 */
	@Override
	public java.lang.String getBdlChain () {
		return bdlChain;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlChain(java.lang.String)
	 */
	@Override
	public void setBdlChain (java.lang.String bdlChain) {
		this.bdlChain = bdlChain;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlLicence()
	 */
	@Override
	public java.lang.String getBdlLicence () {
		return bdlLicence;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlLicence(java.lang.String)
	 */
	@Override
	public void setBdlLicence (java.lang.String bdlLicence) {
		this.bdlLicence = bdlLicence;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlLatitude()
	 */
	@Override
	public java.lang.String getBdlLatitude () {
		return bdlLatitude;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlLatitude(java.lang.String)
	 */
	@Override
	public void setBdlLatitude (java.lang.String bdlLatitude) {
		this.bdlLatitude = bdlLatitude;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#getBdlLongitude()
	 */
	@Override
	public java.lang.String getBdlLongitude () {
		return bdlLongitude;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#setBdlLongitude(java.lang.String)
	 */
	@Override
	public void setBdlLongitude (java.lang.String bdlLongitude) {
		this.bdlLongitude = bdlLongitude;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotels)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotels bdlHotels = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotels) obj;
			if (null == this.getId() || null == bdlHotels.getId()) return false;
			else return (this.getId().equals(bdlHotels.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotels#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}