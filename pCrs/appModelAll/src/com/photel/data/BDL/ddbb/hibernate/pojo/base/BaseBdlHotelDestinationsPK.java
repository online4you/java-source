package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlHotelDestinationsPK;


public abstract class BaseBdlHotelDestinationsPK implements Serializable, IBdlHotelDestinationsPK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String bdlCountryCode;
	private java.lang.String bdlDestinationCode;


	public BaseBdlHotelDestinationsPK () {}
	
	public BaseBdlHotelDestinationsPK (
		java.lang.String bdlCountryCode,
		java.lang.String bdlDestinationCode) {

		this.setBdlCountryCode(bdlCountryCode);
		this.setBdlDestinationCode(bdlDestinationCode);
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK#getBdlCountryCode()
	 */
	@Override
	public java.lang.String getBdlCountryCode () {
		return bdlCountryCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK#setBdlCountryCode(java.lang.String)
	 */
	@Override
	public void setBdlCountryCode (java.lang.String bdlCountryCode) {
		this.bdlCountryCode = bdlCountryCode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK#getBdlDestinationCode()
	 */
	@Override
	public java.lang.String getBdlDestinationCode () {
		return bdlDestinationCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK#setBdlDestinationCode(java.lang.String)
	 */
	@Override
	public void setBdlDestinationCode (java.lang.String bdlDestinationCode) {
		this.bdlDestinationCode = bdlDestinationCode;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDestinationsPK)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDestinationsPK mObj = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDestinationsPK) obj;
			if (null != this.getBdlCountryCode() && null != mObj.getBdlCountryCode()) {
				if (!this.getBdlCountryCode().equals(mObj.getBdlCountryCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getBdlDestinationCode() && null != mObj.getBdlDestinationCode()) {
				if (!this.getBdlDestinationCode().equals(mObj.getBdlDestinationCode())) {
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHotelDestinationsPK#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getBdlCountryCode()) {
				sb.append(this.getBdlCountryCode().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getBdlDestinationCode()) {
				sb.append(this.getBdlDestinationCode().hashCode());
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