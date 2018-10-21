package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlCountriesPK;


public abstract class BaseBdlCountriesPK implements Serializable, IBdlCountriesPK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String bdlCode;
	private java.lang.String bdlIdi;


	public BaseBdlCountriesPK () {}
	
	public BaseBdlCountriesPK (
		java.lang.String bdlCode,
		java.lang.String bdlIdi) {

		this.setBdlCode(bdlCode);
		this.setBdlIdi(bdlIdi);
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK#getBdlCode()
	 */
	@Override
	public java.lang.String getBdlCode () {
		return bdlCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK#setBdlCode(java.lang.String)
	 */
	@Override
	public void setBdlCode (java.lang.String bdlCode) {
		this.bdlCode = bdlCode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK#getBdlIdi()
	 */
	@Override
	public java.lang.String getBdlIdi () {
		return bdlIdi;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK#setBdlIdi(java.lang.String)
	 */
	@Override
	public void setBdlIdi (java.lang.String bdlIdi) {
		this.bdlIdi = bdlIdi;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlCountriesPK)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlCountriesPK mObj = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlCountriesPK) obj;
			if (null != this.getBdlCode() && null != mObj.getBdlCode()) {
				if (!this.getBdlCode().equals(mObj.getBdlCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBdlIdi() && null != mObj.getBdlIdi()) {
				if (!this.getBdlIdi().equals(mObj.getBdlIdi())) {
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlCountriesPK#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getBdlCode()) {
				sb.append(this.getBdlCode().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBdlIdi()) {
				sb.append(this.getBdlIdi().hashCode());
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