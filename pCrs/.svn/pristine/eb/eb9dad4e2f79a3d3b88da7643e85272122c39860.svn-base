package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenImagesPK;


public abstract class BaseGenImagesPK implements Serializable, IGenImagesPK {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7775131152099625923L;

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String genParam;
	private java.lang.String genIdi;


	public BaseGenImagesPK () {}
	
	public BaseGenImagesPK (
		java.lang.String genParam,
		java.lang.String genIdi) {

		this.setGenParam(genParam);
		this.setGenIdi(genIdi);
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
	 * Return the value associated with the column: GEN_IDI
	 */
	public java.lang.String getGenIdi () {
		return genIdi;
	}

	/**
	 * Set the value related to the column: GEN_IDI
	 * @param genIdi the GEN_IDI value
	 */
	public void setGenIdi (java.lang.String genIdi) {
		this.genIdi = genIdi;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenImagesPK)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenImagesPK mObj = (com.photel.data.gen.ddbb.hibernate.pojo.GenImagesPK) obj;
			if (null != this.getGenParam() && null != mObj.getGenParam()) {
				if (!this.getGenParam().equals(mObj.getGenParam())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGenIdi() && null != mObj.getGenIdi()) {
				if (!this.getGenIdi().equals(mObj.getGenIdi())) {
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
			if (null != this.getGenIdi()) {
				sb.append(this.getGenIdi().hashCode());
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