package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenvMenus;
import com.photel.interfaces.data.gen.IGenvMenusPK;


/**
 * This is an object that contains data related to the GENV_MENUS table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GENV_MENUS"
 */

public abstract class BaseGenvMenus  implements Serializable, IGenvMenus {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3516732940619069011L;
	public static String REF = "GenvMenus";
	public static String PROP_GME_ORD = "GmeOrd";
	public static String PROP_GME_MOUSEOVER = "GmeMouseover";
	public static String PROP_ID = "Id";
	public static String PROP_GME_LINKSECC = "GmeLinksecc";
	public static String PROP_GME_MOUSEOUT = "GmeMouseout";
	public static String PROP_GME_DES = "GmeDes";


	// constructors
	public BaseGenvMenus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenvMenus (IGenvMenusPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenvMenusPK id;

	// fields
	private java.lang.String gmeDes;
	private java.lang.Integer gmeOrd;
	private java.lang.String gmeMouseout;
	private java.lang.String gmeMouseover;
	private java.lang.String gmeLinksecc;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getId()
	 */
	public IGenvMenusPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setId(com.photel.data.gen.ddbb.hibernate.pojo.GenvMenusPK)
	 */
	public void setId (IGenvMenusPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeDes()
	 */
	public java.lang.String getGmeDes () {
		return gmeDes;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeDes(java.lang.String)
	 */
	public void setGmeDes (java.lang.String gmeDes) {
		this.gmeDes = gmeDes;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeOrd()
	 */
	public java.lang.Integer getGmeOrd () {
		return gmeOrd;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeOrd(java.lang.Integer)
	 */
	public void setGmeOrd (java.lang.Integer gmeOrd) {
		this.gmeOrd = gmeOrd;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeMouseout()
	 */
	public java.lang.String getGmeMouseout () {
		return gmeMouseout;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeMouseout(java.lang.String)
	 */
	public void setGmeMouseout (java.lang.String gmeMouseout) {
		this.gmeMouseout = gmeMouseout;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeMouseover()
	 */
	public java.lang.String getGmeMouseover () {
		return gmeMouseover;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeMouseover(java.lang.String)
	 */
	public void setGmeMouseover (java.lang.String gmeMouseover) {
		this.gmeMouseover = gmeMouseover;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeLinksecc()
	 */
	public java.lang.String getGmeLinksecc () {
		return gmeLinksecc;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeLinksecc(java.lang.String)
	 */
	public void setGmeLinksecc (java.lang.String gmeLinksecc) {
		this.gmeLinksecc = gmeLinksecc;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenvMenus)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenvMenus genvMenus = (com.photel.data.gen.ddbb.hibernate.pojo.GenvMenus) obj;
			if (null == this.getId() || null == genvMenus.getId()) return false;
			else return (this.getId().equals(genvMenus.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#hashCode()
	 */
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
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#toString()
	 */
	public String toString () {
		return super.toString();
	}


}