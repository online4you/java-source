package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlHdetailDescriptionsPK;


public abstract class BaseBdlHdetailDescriptionsPK implements Serializable, IBdlHdetailDescriptionsPK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String hotelCode;
	private java.lang.String languageCode;


	public BaseBdlHdetailDescriptionsPK () {}
	
	public BaseBdlHdetailDescriptionsPK (
		java.lang.String hotelCode,
		java.lang.String languageCode) {

		this.setHotelCode(hotelCode);
		this.setLanguageCode(languageCode);
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHdetailDescriptionsPK#getHotelCode()
	 */
	@Override
	public java.lang.String getHotelCode () {
		return hotelCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHdetailDescriptionsPK#setHotelCode(java.lang.String)
	 */
	@Override
	public void setHotelCode (java.lang.String hotelCode) {
		this.hotelCode = hotelCode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHdetailDescriptionsPK#getLanguageCode()
	 */
	@Override
	public java.lang.String getLanguageCode () {
		return languageCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHdetailDescriptionsPK#setLanguageCode(java.lang.String)
	 */
	@Override
	public void setLanguageCode (java.lang.String languageCode) {
		this.languageCode = languageCode;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHdetailDescriptionsPK#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlHdetailDescriptionsPK)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlHdetailDescriptionsPK mObj = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlHdetailDescriptionsPK) obj;
			if (null != this.getHotelCode() && null != mObj.getHotelCode()) {
				if (!this.getHotelCode().equals(mObj.getHotelCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getLanguageCode() && null != mObj.getLanguageCode()) {
				if (!this.getLanguageCode().equals(mObj.getLanguageCode())) {
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlHdetailDescriptionsPK#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getHotelCode()) {
				sb.append(this.getHotelCode().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getLanguageCode()) {
				sb.append(this.getLanguageCode().hashCode());
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