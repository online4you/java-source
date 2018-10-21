package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlConfigSite;
import com.photel.interfaces.data.BDL.IBdlConfigSitePK;


/**
 * This is an object that contains data related to the BDL_CONFIG_SITE table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BDL_CONFIG_SITE"
 */

public abstract class BaseBdlConfigSite  implements Serializable, IBdlConfigSite {

	public static String REF = "BdlConfigSite";
	public static String PROP_BDL_VALUE = "bdlValue";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlConfigSite () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlConfigSite (IBdlConfigSitePK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlConfigSitePK id;

	// fields
	private java.lang.String bdlValue;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#getId()
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#getId()
	 */
	@Override
	public IBdlConfigSitePK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#setId(com.photel.data.BDL.ddbb.hibernate.pojo.GenConfigSitePK)
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#setId(com.photel.interfaces.data.BDL.IBdlConfigSitePK)
	 */
	@Override
	public void setId (IBdlConfigSitePK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#getBdlValue()
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#getBdlValue()
	 */
	@Override
	public java.lang.String getBdlValue () {
		return bdlValue;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#setBdlValue(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#setBdlValue(java.lang.String)
	 */
	@Override
	public void setBdlValue (java.lang.String bdlValue) {
		this.bdlValue = bdlValue;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#equals(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfigSite)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfigSite bdlConfigSite = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfigSite) obj;
			if (null == this.getId() || null == bdlConfigSite.getId()) return false;
			else return (this.getId().equals(bdlConfigSite.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#hashCode()
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfigSite#toString()
	 */
	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlConfigSite#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}