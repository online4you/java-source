package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlConfig;


/**
 * This is an object that contains data related to the BDL_CONFIG table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="BDL_CONFIG"
 */

public abstract class BaseBdlConfig  implements Serializable, IBdlConfig {

	public static String REF = "BdlConfig";
	public static String PROP_BDL_VALUE = "BdlValue";
	public static String PROP_ID = "Id";


	// constructors
	public BaseBdlConfig () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlConfig (java.lang.String id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String id;

	// fields
	private java.lang.String bdlValue;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#getId()
	 */
	@Override
	public java.lang.String getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#setId(java.lang.String)
	 */
	@Override
	public void setId (java.lang.String id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#getBdlValue()
	 */
	@Override
	public java.lang.String getBdlValue () {
		return bdlValue;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#setBdlValue(java.lang.String)
	 */
	@Override
	public void setBdlValue (java.lang.String bdlValue) {
		this.bdlValue = bdlValue;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfig)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfig bdlConfig = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfig) obj;
			if (null == this.getId() || null == bdlConfig.getId()) return false;
			else return (this.getId().equals(bdlConfig.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBaseBdlConfig#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}