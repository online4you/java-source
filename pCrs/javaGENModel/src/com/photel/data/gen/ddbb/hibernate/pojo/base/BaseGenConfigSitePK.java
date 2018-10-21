package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenConfigSitePK;


public abstract class BaseGenConfigSitePK implements Serializable, IGenConfigSitePK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String genParam;
	private java.lang.String genSite;


	public BaseGenConfigSitePK () {}
	
	public BaseGenConfigSitePK (
		java.lang.String genParam,
		java.lang.String genSite) {

		this.setGenParam(genParam);
		this.setGenSite(genSite);
	}


	/**
	 * Return the value associated with the column: GEN_PARAM
	 */
	public java.lang.String getGenParam () {
		return genParam;
	}

	/**
	 * Set the value related to the column: GEN_PARAM
	 * @param genParam the GEN_PARAM value
	 */
	public void setGenParam (java.lang.String genParam) {
		this.genParam = genParam;
	}



	/**
	 * Return the value associated with the column: GEN_SITE
	 */
	public java.lang.String getGenSite () {
		return genSite;
	}

	/**
	 * Set the value related to the column: GEN_SITE
	 * @param genSite the GEN_SITE value
	 */
	public void setGenSite (java.lang.String genSite) {
		this.genSite = genSite;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenConfigSitePK)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenConfigSitePK mObj = (com.photel.data.gen.ddbb.hibernate.pojo.GenConfigSitePK) obj;
			if (null != this.getGenParam() && null != mObj.getGenParam()) {
				if (!this.getGenParam().equals(mObj.getGenParam())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGenSite() && null != mObj.getGenSite()) {
				if (!this.getGenSite().equals(mObj.getGenSite())) {
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
			if (null != this.getGenParam()) {
				sb.append(this.getGenParam().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGenSite()) {
				sb.append(this.getGenSite().hashCode());
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