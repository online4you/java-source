package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenTrackingLevel;


/**
 * This is an object that contains data related to the GEN_TRACKING_LEVEL table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_TRACKING_LEVEL"
 */

public abstract class BaseGenTrackingLevel  implements Serializable, IGenTrackingLevel {

	public static String REF = "GenTrackingLevel";
	public static String PROP_GTL_ORDER = "GtlOrder";
	public static String PROP_GTL_NIVEL = "GtlNivel";


	// constructors
	public BaseGenTrackingLevel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenTrackingLevel (java.lang.String gtlNivel) {
		this.setGtlNivel(gtlNivel);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String gtlNivel;

	// fields
	private java.lang.Integer gtlOrder;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#getGtlNivel()
	 */
	public java.lang.String getGtlNivel () {
		return gtlNivel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#setGtlNivel(java.lang.String)
	 */
	public void setGtlNivel (java.lang.String gtlNivel) {
		this.gtlNivel = gtlNivel;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#getGtlOrder()
	 */
	public java.lang.Integer getGtlOrder () {
		return gtlOrder;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#setGtlOrder(java.lang.Integer)
	 */
	public void setGtlOrder (java.lang.Integer gtlOrder) {
		this.gtlOrder = gtlOrder;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenTrackingLevel)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenTrackingLevel genTrackingLevel = (com.photel.data.gen.ddbb.hibernate.pojo.GenTrackingLevel) obj;
			if (null == this.getGtlNivel() || null == genTrackingLevel.getGtlNivel()) return false;
			else return (this.getGtlNivel().equals(genTrackingLevel.getGtlNivel()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getGtlNivel()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getGtlNivel().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenTrakingLevel#toString()
	 */
	public String toString () {
		return super.toString();
	}


}