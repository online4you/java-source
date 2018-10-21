package com.photel.mail.data.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.mail.IGenMailTemplates;


/**
 * This is an object that contains data related to the GEN_MAIL_TEMPLATES table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_MAIL_TEMPLATES"
 */

public abstract class BaseGenMailTemplates  implements Serializable, IGenMailTemplates {

	public static String REF = "GenMailTemplates";
	public static String PROP_GMT_VAL = "GmtVal";
	public static String PROP_GMT_TITLE = "GmtTitle";
	public static String PROP_GMT_TEMPLATE = "GmtTemplate";


	// constructors
	public BaseGenMailTemplates () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenMailTemplates (java.lang.String gmtTitle) {
		this.setGmtTitle(gmtTitle);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.String gmtTitle;

	// fields
	private java.lang.String gmtTemplate;
	private java.lang.String gmtVal;



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#getGmtTitle()
	 */
	public java.lang.String getGmtTitle () {
		return gmtTitle;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#setGmtTitle(java.lang.String)
	 */
	public void setGmtTitle (java.lang.String gmtTitle) {
		this.gmtTitle = gmtTitle;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#getGmtTemplate()
	 */
	public java.lang.String getGmtTemplate () {
		return gmtTemplate;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#setGmtTemplate(java.lang.String)
	 */
	public void setGmtTemplate (java.lang.String gmtTemplate) {
		this.gmtTemplate = gmtTemplate;
	}



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#getGmtVal()
	 */
	public java.lang.String getGmtVal () {
		return gmtVal;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#setGmtVal(java.lang.String)
	 */
	public void setGmtVal (java.lang.String gmtVal) {
		this.gmtVal = gmtVal;
	}




	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplates)) return false;
		else {
			com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplates genMailTemplates = (com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplates) obj;
			if (null == this.getGmtTitle() || null == genMailTemplates.getGmtTitle()) return false;
			else return (this.getGmtTitle().equals(genMailTemplates.getGmtTitle()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getGmtTitle()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getGmtTitle().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenTemplates#toString()
	 */
	public String toString () {
		return super.toString();
	}


}