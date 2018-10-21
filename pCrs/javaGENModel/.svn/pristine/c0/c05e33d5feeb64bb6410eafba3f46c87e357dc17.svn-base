package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenLanResourcePK;


public abstract class BaseGenLanresourcePK implements Serializable, IGenLanResourcePK {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5865089717164147235L;

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String trlRes;
	private java.lang.String trlLang;


	public BaseGenLanresourcePK () {}
	
	public BaseGenLanresourcePK (
		java.lang.String trlRes,
		java.lang.String trlLang) {

		this.setTrlRes(trlRes);
		this.setTrlLang(trlLang);
	}


	/**
	 * Return the value associated with the column: TRL_RES
	 */
	public java.lang.String getTrlRes () {
		return trlRes;
	}

	/**
	 * Set the value related to the column: TRL_RES
	 * @param trlRes the TRL_RES value
	 */
	public void setTrlRes (java.lang.String trlRes) {
		this.trlRes = trlRes;
	}



	/**
	 * Return the value associated with the column: TRL_LANG
	 */
	public java.lang.String getTrlLang () {
		return trlLang;
	}

	/**
	 * Set the value related to the column: TRL_LANG
	 * @param trlLang the TRL_LANG value
	 */
	public void setTrlLang (java.lang.String trlLang) {
		this.trlLang = trlLang;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourcePK)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourcePK mObj = (com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourcePK) obj;
			if (null != this.getTrlRes() && null != mObj.getTrlRes()) {
				if (!this.getTrlRes().equals(mObj.getTrlRes())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getTrlLang() && null != mObj.getTrlLang()) {
				if (!this.getTrlLang().equals(mObj.getTrlLang())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getTrlRes()) {
				sb.append(this.getTrlRes().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getTrlLang()) {
				sb.append(this.getTrlLang().hashCode());
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