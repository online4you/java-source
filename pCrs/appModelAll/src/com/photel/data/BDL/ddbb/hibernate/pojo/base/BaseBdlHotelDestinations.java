package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlHotelDestinations;
import com.photel.interfaces.data.BDL.IBdlHotelDestinationsPK;


/**
 * This is an object that contains data related to the bdl_hotel_destinations table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_hotel_destinations"
 */

public abstract class BaseBdlHotelDestinations  implements Serializable, IBdlHotelDestinations {

	public static String REF = "BdlHotelDestinations";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlHotelDestinations () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlHotelDestinations (IBdlHotelDestinationsPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlHotelDestinationsPK id;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#getId()
	 */
	
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#getId()
	 */
	@Override
	public IBdlHotelDestinationsPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#setId(IBdlHotelDestinationsPK)
	 */
	
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#setId(com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK)
	 */
	@Override
	public void setId (IBdlHotelDestinationsPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}





	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#equals(java.lang.Object)
	 */
	
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDestinations)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDestinations bdlHotelDestinations = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDestinations) obj;
			if (null == this.getId() || null == bdlHotelDestinations.getId()) return false;
			else return (this.getId().equals(bdlHotelDestinations.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#hashCode()
	 */
	
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#toString()
	 */
	
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinations#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}