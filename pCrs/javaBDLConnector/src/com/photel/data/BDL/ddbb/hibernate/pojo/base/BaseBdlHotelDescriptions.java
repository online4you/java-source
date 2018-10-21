package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlHotelDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDescriptionsPK;


/**
 * This is an object that contains data related to the bdl_HotelDescriptions table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_HotelDescriptions"
 */

public abstract class BaseBdlHotelDescriptions  implements Serializable, IBdlHotelDescriptions {

	public static String REF = "BdlHotelDescriptions";
	public static String PROP_BDL_DESCRIPTION = "BdlDescription";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlHotelDescriptions () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlHotelDescriptions (IBdlHotelDescriptionsPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlHotelDescriptions (
		IBdlHotelDescriptionsPK id,
		java.lang.String bdlDescription) {

		this.setId(id);
		this.setBdlDescription(bdlDescription);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlHotelDescriptionsPK id;

	// fields
	private java.lang.String bdlDescription;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#getId()
	 */
	@Override
	public IBdlHotelDescriptionsPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#setId(com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptionsPK)
	 */
	@Override
	public void setId (IBdlHotelDescriptionsPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#getBdlDescription()
	 */
	@Override
	public java.lang.String getBdlDescription () {
		return bdlDescription;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#setBdlDescription(java.lang.String)
	 */
	@Override
	public void setBdlDescription (java.lang.String bdlDescription) {
		this.bdlDescription = bdlDescription;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDescriptions)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDescriptions bdlHotelDescriptions = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDescriptions) obj;
			if (null == this.getId() || null == bdlHotelDescriptions.getId()) return false;
			else return (this.getId().equals(bdlHotelDescriptions.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDescriptions#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}