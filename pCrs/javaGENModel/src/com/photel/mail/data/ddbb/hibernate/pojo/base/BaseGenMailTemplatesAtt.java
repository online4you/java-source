package com.photel.mail.data.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.mail.IGenMailTemplatesAtt;
import com.photel.interfaces.mail.IGenMailTemplatesAttPK;


/**
 * This is an object that contains data related to the GEN_MAIL_TEMPLATES_ATT table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_MAIL_TEMPLATES_ATT"
 */

public abstract class BaseGenMailTemplatesAtt  implements Serializable, IGenMailTemplatesAtt {

	public static String REF = "GenMailTemplatesAtt";
	public static String PROP_GMA_CONTENT_TYPE = "GmaContentType";
	public static String PROP_GMA_VAL = "GmaVal";
	public static String PROP_GMA_ATTAHMENT = "GmaAttahment";
	public static String PROP_ID = "Id";


	// constructors
	public BaseGenMailTemplatesAtt () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenMailTemplatesAtt (IGenMailTemplatesAttPK id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IGenMailTemplatesAttPK id;

	// fields
	private java.lang.String gmaContentType;
	private byte[] gmaAttahment;
	private java.lang.String gmaVal;



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#getId()
	 */
	public IGenMailTemplatesAttPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#setId(com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK)
	 */
	public void setId (IGenMailTemplatesAttPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#getGmaContentType()
	 */
	public java.lang.String getGmaContentType () {
		return gmaContentType;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#setGmaContentType(java.lang.String)
	 */
	public void setGmaContentType (java.lang.String gmaContentType) {
		this.gmaContentType = gmaContentType;
	}



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#getGmaAttahment()
	 */
	public byte[] getGmaAttahment () {
		return gmaAttahment;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#setGmaAttahment(byte[])
	 */
	public void setGmaAttahment (byte[] gmaAttahment) {
		this.gmaAttahment = gmaAttahment;
	}



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#getGmaVal()
	 */
	public java.lang.String getGmaVal () {
		return gmaVal;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#setGmaVal(java.lang.String)
	 */
	public void setGmaVal (java.lang.String gmaVal) {
		this.gmaVal = gmaVal;
	}




	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAtt)) return false;
		else {
			com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAtt genMailTemplatesAtt = (com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAtt) obj;
			if (null == this.getId() || null == genMailTemplatesAtt.getId()) return false;
			else return (this.getId().equals(genMailTemplatesAtt.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#hashCode()
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
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAtt#toString()
	 */
	public String toString () {
		return super.toString();
	}


}