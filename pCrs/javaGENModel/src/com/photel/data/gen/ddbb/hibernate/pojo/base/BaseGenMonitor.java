package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenMonitor;


/**
 * This is an object that contains data related to the GEN_MONITOR table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="GEN_MONITOR"
 */

public abstract class BaseGenMonitor  implements Serializable, IGenMonitor {

	public static String REF = "GenMonitor";
	public static String PROP_GER_HOST = "GerHost";
	public static String PROP_GER_SESSION = "GerSession";
	public static String PROP_GER_ACTION = "GerAction";
	public static String PROP_GER_TOSTRING = "GerTostring";
	public static String PROP_GER_IP = "GerIp";
	public static String PROP_GER_URL = "GerUrl";
	public static String PROP_ID = "Id";
	public static String PROP_GER_PARAMS = "GerParams";
	public static String PROP_GER_HEADERS = "GerHeaders";
	public static String PROP_GER_URLFROM = "GerUrlfrom";


	// constructors
	public BaseGenMonitor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenMonitor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String gerUrl;
	private java.lang.String gerUrlfrom;
	private java.lang.String gerHeaders;
	private java.lang.String gerParams;
	private java.lang.String gerSession;
	private java.lang.String gerIp;
	private java.lang.String gerHost;
	private java.lang.String gerAction;
	private java.lang.String gerTostring;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getId()
	 */
	public java.lang.Integer getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setId(java.lang.Integer)
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerUrl()
	 */
	public java.lang.String getGerUrl () {
		return gerUrl;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerUrl(java.lang.String)
	 */
	public void setGerUrl (java.lang.String gerUrl) {
		this.gerUrl = gerUrl;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerUrlfrom()
	 */
	public java.lang.String getGerUrlfrom () {
		return gerUrlfrom;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerUrlfrom(java.lang.String)
	 */
	public void setGerUrlfrom (java.lang.String gerUrlfrom) {
		this.gerUrlfrom = gerUrlfrom;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerHeaders()
	 */
	public java.lang.String getGerHeaders () {
		return gerHeaders;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerHeaders(java.lang.String)
	 */
	public void setGerHeaders (java.lang.String gerHeaders) {
		this.gerHeaders = gerHeaders;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerParams()
	 */
	public java.lang.String getGerParams () {
		return gerParams;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerParams(java.lang.String)
	 */
	public void setGerParams (java.lang.String gerParams) {
		this.gerParams = gerParams;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerSession()
	 */
	public java.lang.String getGerSession () {
		return gerSession;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerSession(java.lang.String)
	 */
	public void setGerSession (java.lang.String gerSession) {
		this.gerSession = gerSession;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerIp()
	 */
	public java.lang.String getGerIp () {
		return gerIp;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerIp(java.lang.String)
	 */
	public void setGerIp (java.lang.String gerIp) {
		this.gerIp = gerIp;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerHost()
	 */
	public java.lang.String getGerHost () {
		return gerHost;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerHost(java.lang.String)
	 */
	public void setGerHost (java.lang.String gerHost) {
		this.gerHost = gerHost;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerAction()
	 */
	public java.lang.String getGerAction () {
		return gerAction;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerAction(java.lang.String)
	 */
	public void setGerAction (java.lang.String gerAction) {
		this.gerAction = gerAction;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#getGerTostring()
	 */
	public java.lang.String getGerTostring () {
		return gerTostring;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#setGerTostring(java.lang.String)
	 */
	public void setGerTostring (java.lang.String gerTostring) {
		this.gerTostring = gerTostring;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenMonitor)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenMonitor genMonitor = (com.photel.data.gen.ddbb.hibernate.pojo.GenMonitor) obj;
			if (null == this.getId() || null == genMonitor.getId()) return false;
			else return (this.getId().equals(genMonitor.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#hashCode()
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
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenMonitor#toString()
	 */
	public String toString () {
		return super.toString();
	}


}