package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenLanresourceSitePK;


public abstract class BaseGenLanresourceSitePK implements Serializable, IGenLanresourceSitePK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String genRes;
	private java.lang.String genLang;
	private java.lang.String genSite;

	public BaseGenLanresourceSitePK () {}
	
	public BaseGenLanresourceSitePK (
		java.lang.String genRes,
		java.lang.String genLang,
		java.lang.String genSite) {

		this.setGenRes(genRes);
		this.setGenLang(genLang);
		this.setGenSite(genSite);
	}


	public java.lang.String getGenSite() {
		return genSite;
	}

	public void setGenSite(java.lang.String genSite) {
		this.genSite = genSite;
	}

	/**
	 * Return the value associated with the column: GEN_RES
	 */
	public java.lang.String getGenRes () {
		return genRes;
	}

	/**
	 * Set the value related to the column: GEN_RES
	 * @param genRes the GEN_RES value
	 */
	public void setGenRes (java.lang.String genRes) {
		this.genRes = genRes;
	}



	/**
	 * Return the value associated with the column: GEN_LANG
	 */
	public java.lang.String getGenLang () {
		return genLang;
	}

	/**
	 * Set the value related to the column: GEN_LANG
	 * @param genLang the GEN_LANG value
	 */
	public void setGenLang (java.lang.String genLang) {
		this.genLang = genLang;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourceSitePK)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourceSitePK mObj = (com.photel.data.gen.ddbb.hibernate.pojo.GenLanresourceSitePK) obj;
			if (null != this.getGenRes() && null != mObj.getGenRes()) {
				if (!this.getGenRes().equals(mObj.getGenRes())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGenLang() && null != mObj.getGenLang()) {
				if (!this.getGenLang().equals(mObj.getGenLang())) {
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
			if (null != this.getGenRes()) {
				sb.append(this.getGenRes().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGenLang()) {
				sb.append(this.getGenLang().hashCode());
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