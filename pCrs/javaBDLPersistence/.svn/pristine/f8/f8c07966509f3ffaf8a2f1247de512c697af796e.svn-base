package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlvHimagesPK;


public abstract class BaseBdlvHimagesPK implements Serializable, IBdlvHimagesPK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String hotelCode;
	private java.lang.String imagecode;
	private java.lang.String order;
	private java.lang.String languagecode;


	public BaseBdlvHimagesPK () {}
	
	public BaseBdlvHimagesPK (
		java.lang.String hotelCode,
		java.lang.String imagecode,
		java.lang.String order,
		java.lang.String languagecode) {

		this.setHotelCode(hotelCode);
		this.setImagecode(imagecode);
		this.setOrder(order);
		this.setLanguagecode(languagecode);
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#getHotelCode()
	 */
	@Override
	public java.lang.String getHotelCode () {
		return hotelCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#setHotelCode(java.lang.String)
	 */
	@Override
	public void setHotelCode (java.lang.String hotelCode) {
		this.hotelCode = hotelCode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#getImagecode()
	 */
	@Override
	public java.lang.String getImagecode () {
		return imagecode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#setImagecode(java.lang.String)
	 */
	@Override
	public void setImagecode (java.lang.String imagecode) {
		this.imagecode = imagecode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#getOrder()
	 */
	@Override
	public java.lang.String getOrder () {
		return order;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#setOrder(java.lang.String)
	 */
	@Override
	public void setOrder (java.lang.String order) {
		this.order = order;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#getLanguagecode()
	 */
	@Override
	public java.lang.String getLanguagecode () {
		return languagecode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#setLanguagecode(java.lang.String)
	 */
	@Override
	public void setLanguagecode (java.lang.String languagecode) {
		this.languagecode = languagecode;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHimagesPK)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHimagesPK mObj = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHimagesPK) obj;
			if (null != this.getHotelCode() && null != mObj.getHotelCode()) {
				if (!this.getHotelCode().equals(mObj.getHotelCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getImagecode() && null != mObj.getImagecode()) {
				if (!this.getImagecode().equals(mObj.getImagecode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getOrder() && null != mObj.getOrder()) {
				if (!this.getOrder().equals(mObj.getOrder())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getLanguagecode() && null != mObj.getLanguagecode()) {
				if (!this.getLanguagecode().equals(mObj.getLanguagecode())) {
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK#hashCode()
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
			if (null != this.getImagecode()) {
				sb.append(this.getImagecode().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getOrder()) {
				sb.append(this.getOrder().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getLanguagecode()) {
				sb.append(this.getLanguagecode().hashCode());
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