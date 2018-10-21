package com.photel.data.hotelan.ddbb.hibernate.pojo;

import java.io.Serializable;



/**
 * This is an object that contains data related to the Hl_reservas_mails table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Hl_reservas_mails"
 */

public class HibernateReservasMails  implements Serializable {

	public static String REF = "HlReservasMails";
	public static String PROP_Hl_ASUNTO = "HlAsunto";
	public static String PROP_Hl_FROM = "HlFrom";
	public static String PROP_ID = "Id";
	public static String PROP_Hl_CCO = "HlCco";
	public static String PROP_Hl_TO = "HlTo";
	public static String PROP_Hl_ID_RESERVA = "HlIdReserva";
	public static String PROP_Hl_CC = "HlCc";
	public static String PROP_Hl_TIMCRE = "HlTimcre";
	public static String PROP_Hl_MAIL = "HlMail";


	// constructors
	public HibernateReservasMails () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public HibernateReservasMails (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public HibernateReservasMails (
		java.lang.Integer id,
		java.util.Date HlTimcre) {

		this.setId(id);
		this.setHlTimcre(HlTimcre);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer HlIdReserva;
	private java.util.Date HlTimcre;
	private java.lang.String HlFrom;
	private java.lang.String HlTo;
	private java.lang.String HlCc;
	private java.lang.String HlCco;
	private java.lang.String HlAsunto;
	private java.lang.String HlMail;



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getId()
	 */
	
	public java.lang.Integer getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setId(java.lang.Integer)
	 */
	
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlIdReserva()
	 */
	
	public java.lang.Integer getHlIdReserva () {
		return HlIdReserva;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlIdReserva(java.lang.Integer)
	 */
	
	public void setHlIdReserva (java.lang.Integer HlIdReserva) {
		this.HlIdReserva = HlIdReserva;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlTimcre()
	 */
	
	public java.util.Date getHlTimcre () {
		return HlTimcre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlTimcre(java.util.Date)
	 */
	
	public void setHlTimcre (java.util.Date HlTimcre) {
		this.HlTimcre = HlTimcre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlFrom()
	 */
	
	public java.lang.String getHlFrom () {
		return HlFrom;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlFrom(java.lang.String)
	 */
	
	public void setHlFrom (java.lang.String HlFrom) {
		this.HlFrom = HlFrom;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlTo()
	 */
	
	public java.lang.String getHlTo () {
		return HlTo;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlTo(java.lang.String)
	 */
	
	public void setHlTo (java.lang.String HlTo) {
		this.HlTo = HlTo;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlCc()
	 */
	
	public java.lang.String getHlCc () {
		return HlCc;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlCc(java.lang.String)
	 */
	
	public void setHlCc (java.lang.String HlCc) {
		this.HlCc = HlCc;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlCco()
	 */
	
	public java.lang.String getHlCco () {
		return HlCco;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlCco(java.lang.String)
	 */
	
	public void setHlCco (java.lang.String HlCco) {
		this.HlCco = HlCco;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlAsunto()
	 */
	
	public java.lang.String getHlAsunto () {
		return HlAsunto;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlAsunto(java.lang.String)
	 */
	
	public void setHlAsunto (java.lang.String HlAsunto) {
		this.HlAsunto = HlAsunto;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#getHlMail()
	 */
	
	public java.lang.String getHlMail () {
		return HlMail;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#setHlMail(java.lang.String)
	 */
	
	public void setHlMail (java.lang.String HlMail) {
		this.HlMail = HlMail;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#equals(java.lang.Object)
	 */
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof HibernateReservasMails)) return false;
		else {
			HibernateReservasMails HlReservasMails = (HibernateReservasMails) obj;
			if (null == this.getId() || null == HlReservasMails.getId()) return false;
			else return (this.getId().equals(HlReservasMails.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#hashCode()
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
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservasMails#toString()
	 */
	
	public String toString () {
		return super.toString();
	}


}