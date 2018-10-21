package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenvMenusPK;


public abstract class BaseGenvMenusPK implements Serializable, IGenvMenusPK {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1001220037123127088L;

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String gmeSite;
	private java.lang.String gmeCodsecc;
	private java.lang.String gmeCodmenu;
	private java.lang.String gmeIdi;


	public BaseGenvMenusPK () {}
	
	public BaseGenvMenusPK (
		java.lang.String gmeSite,
		java.lang.String gmeCodsecc,
		java.lang.String gmeCodmenu,
		java.lang.String gmeIdi) {

		this.setGmeSite(gmeSite);
		this.setGmeCodsecc(gmeCodsecc);
		this.setGmeCodmenu(gmeCodmenu);
		this.setGmeIdi(gmeIdi);
	}


	public java.lang.String getGmeSite() {
		return gmeSite;
	}

	public void setGmeSite(java.lang.String gmeSite) {
		this.gmeSite = gmeSite;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeCodsecc()
	 */
	public java.lang.String getGmeCodsecc () {
		return gmeCodsecc;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeCodsecc(java.lang.String)
	 */
	public void setGmeCodsecc (java.lang.String gmeCodsecc) {
		this.gmeCodsecc = gmeCodsecc;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeCodmenu()
	 */
	public java.lang.String getGmeCodmenu () {
		return gmeCodmenu;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeCodmenu(java.lang.String)
	 */
	public void setGmeCodmenu (java.lang.String gmeCodmenu) {
		this.gmeCodmenu = gmeCodmenu;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#getGmeIdi()
	 */
	public java.lang.String getGmeIdi () {
		return gmeIdi;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#setGmeIdi(java.lang.String)
	 */
	public void setGmeIdi (java.lang.String gmeIdi) {
		this.gmeIdi = gmeIdi;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenvMenusPK)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenvMenusPK mObj = (com.photel.data.gen.ddbb.hibernate.pojo.GenvMenusPK) obj;
			if (null != this.getGmeCodsecc() && null != mObj.getGmeCodsecc()) {
				if (!this.getGmeCodsecc().equals(mObj.getGmeCodsecc())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGmeCodmenu() && null != mObj.getGmeCodmenu()) {
				if (!this.getGmeCodmenu().equals(mObj.getGmeCodmenu())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGmeIdi() && null != mObj.getGmeIdi()) {
				if (!this.getGmeIdi().equals(mObj.getGmeIdi())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenvMenus#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getGmeCodsecc()) {
				sb.append(this.getGmeCodsecc().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGmeCodmenu()) {
				sb.append(this.getGmeCodmenu().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGmeIdi()) {
				sb.append(this.getGmeIdi().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}


}