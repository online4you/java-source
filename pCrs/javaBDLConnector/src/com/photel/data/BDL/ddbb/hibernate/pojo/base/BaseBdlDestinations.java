package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlDestinationsPK;


/**
 * This is an object that contains data related to the bdl_destinations table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_destinations"
 */

public abstract class BaseBdlDestinations  implements Serializable, IBdlDestinations {

	public static String REF = "BdlDestinations";
	public static String PROP_BDL_DESCRIPTION = "BdlDescription";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlDestinations () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlDestinations (IBdlDestinationsPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlDestinations (
		IBdlDestinationsPK id,
		java.lang.String bdlDescription) {

		this.setId(id);
		this.setBdlDescription(bdlDescription);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlDestinationsPK id;

	// fields
	private java.lang.String bdlDescription;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#getId()
	 */
	@Override
	public IBdlDestinationsPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#setId(com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinationsPK)
	 */
	@Override
	public void setId (IBdlDestinationsPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#getBdlDescription()
	 */
	@Override
	public java.lang.String getBdlDescription () {
		return bdlDescription;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#setBdlDescription(java.lang.String)
	 */
	@Override
	public void setBdlDescription (java.lang.String bdlDescription) {
		this.bdlDescription = bdlDescription;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlDestinations)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlDestinations bdlDestinations = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlDestinations) obj;
			if (null == this.getId() || null == bdlDestinations.getId()) return false;
			else return (this.getId().equals(bdlDestinations.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlDestinations#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}