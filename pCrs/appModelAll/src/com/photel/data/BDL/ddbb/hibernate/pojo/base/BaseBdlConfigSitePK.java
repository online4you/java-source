package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlConfigSitePK;


public abstract class BaseBdlConfigSitePK implements Serializable, IBdlConfigSitePK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String bdlParam;
	private java.lang.String bdlSite;


	public BaseBdlConfigSitePK () {}
	
	public BaseBdlConfigSitePK (
		java.lang.String bdlParam,
		java.lang.String bdlSite) {

		this.setBdlParam(bdlParam);
		this.setBdlSite(bdlSite);
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IGenConfigSitePK#getBdlParam()
	 */
	@Override
	public java.lang.String getBdlParam () {
		return bdlParam;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IGenConfigSitePK#setBdlParam(java.lang.String)
	 */
	@Override
	public void setBdlParam (java.lang.String bdlParam) {
		this.bdlParam = bdlParam;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IGenConfigSitePK#getBdlSite()
	 */
	@Override
	public java.lang.String getBdlSite () {
		return bdlSite;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IGenConfigSitePK#setBdlSite(java.lang.String)
	 */
	@Override
	public void setBdlSite (java.lang.String bdlSite) {
		this.bdlSite = bdlSite;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IGenConfigSitePK#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfigSitePK)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfigSitePK mObj = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlConfigSitePK) obj;
			if (null != this.getBdlParam() && null != mObj.getBdlParam()) {
				if (!this.getBdlParam().equals(mObj.getBdlParam())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBdlSite() && null != mObj.getBdlSite()) {
				if (!this.getBdlSite().equals(mObj.getBdlSite())) {
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IGenConfigSitePK#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getBdlParam()) {
				sb.append(this.getBdlParam().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBdlSite()) {
				sb.append(this.getBdlSite().hashCode());
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