package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenVOpcionesPK;


public abstract class BaseGenvOpcionesPK implements Serializable, IGenVOpcionesPK {

	protected int hashCode = Integer.MIN_VALUE;
	
	private java.lang.String gopSite;
	private java.lang.Integer gopIdopc;
	private java.lang.String gopCodsec;
	private java.lang.String gopCodmenu;
	private java.lang.String gopIdioma;


	public BaseGenvOpcionesPK () {}
	
	public BaseGenvOpcionesPK (
		java.lang.String gopSite,
		java.lang.Integer gopIdopc,
		java.lang.String gopCodsec,
		java.lang.String gopCodmenu,
		java.lang.String gopIdioma) {

		this.setGopSite(gopSite);
		this.setGopIdopc(gopIdopc);
		this.setGopCodsec(gopCodsec);
		this.setGopCodmenu(gopCodmenu);
		this.setGopIdioma(gopIdioma);
	}


	public java.lang.String getGopSite() {
		return gopSite;
	}

	public void setGopSite(java.lang.String gopSite) {
		this.gopSite = gopSite;
	}

	public java.lang.String getGopCodmenu() {
		return gopCodmenu;
	}

	public void setGopCodmenu(java.lang.String gopCodmenu) {
		this.gopCodmenu = gopCodmenu;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#getGopIdopc()
	 */
	public java.lang.Integer getGopIdopc () {
		return gopIdopc;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#setGopIdopc(java.lang.Integer)
	 */
	public void setGopIdopc (java.lang.Integer gopIdopc) {
		this.gopIdopc = gopIdopc;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#getGopCodsec()
	 */
	public java.lang.String getGopCodsec () {
		return gopCodsec;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#setGopCodsec(java.lang.String)
	 */
	public void setGopCodsec (java.lang.String gopCodsec) {
		this.gopCodsec = gopCodsec;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#getGopIdioma()
	 */
	public java.lang.String getGopIdioma () {
		return gopIdioma;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#setGopIdioma(java.lang.String)
	 */
	public void setGopIdioma (java.lang.String gopIdioma) {
		this.gopIdioma = gopIdioma;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenvOpcionesPK)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenvOpcionesPK mObj = (com.photel.data.gen.ddbb.hibernate.pojo.GenvOpcionesPK) obj;
			if (null != this.getGopIdopc() && null != mObj.getGopIdopc()) {
				if (!this.getGopIdopc().equals(mObj.getGopIdopc())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGopCodsec() && null != mObj.getGopCodsec()) {
				if (!this.getGopCodsec().equals(mObj.getGopCodsec())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGopIdioma() && null != mObj.getGopIdioma()) {
				if (!this.getGopIdioma().equals(mObj.getGopIdioma())) {
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
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenVOpcionesPK#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getGopIdopc()) {
				sb.append(this.getGopIdopc().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGopCodsec()) {
				sb.append(this.getGopCodsec().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGopIdioma()) {
				sb.append(this.getGopIdioma().hashCode());
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