package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlvHdetailFacilitiesPK;


public abstract class BaseBdlvHdetailFacilitiesPK implements Serializable, IBdlvHdetailFacilitiesPK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String hotelCode;
	private java.lang.String code;
	private java.lang.String group;
	private java.lang.String languagecode;


	public BaseBdlvHdetailFacilitiesPK () {}
	
	public BaseBdlvHdetailFacilitiesPK (
		java.lang.String hotelCode,
		java.lang.String code,
		java.lang.String group,
		java.lang.String languagecode) {

		this.setHotelCode(hotelCode);
		this.setCode(code);
		this.setGroup(group);
		this.setLanguagecode(languagecode);
	}


	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#getHotelCode()
	 */
	@Override
	public java.lang.String getHotelCode () {
		return hotelCode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#setHotelCode(java.lang.String)
	 */
	@Override
	public void setHotelCode (java.lang.String hotelCode) {
		this.hotelCode = hotelCode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#getCode()
	 */
	@Override
	public java.lang.String getCode () {
		return code;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#setCode(java.lang.String)
	 */
	@Override
	public void setCode (java.lang.String code) {
		this.code = code;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#getGroup()
	 */
	@Override
	public java.lang.String getGroup () {
		return group;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#setGroup(java.lang.String)
	 */
	@Override
	public void setGroup (java.lang.String group) {
		this.group = group;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#getLanguagecode()
	 */
	@Override
	public java.lang.String getLanguagecode () {
		return languagecode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#setLanguagecode(java.lang.String)
	 */
	@Override
	public void setLanguagecode (java.lang.String languagecode) {
		this.languagecode = languagecode;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHdetailFacilitiesPK)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHdetailFacilitiesPK mObj = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHdetailFacilitiesPK) obj;
			if (null != this.getHotelCode() && null != mObj.getHotelCode()) {
				if (!this.getHotelCode().equals(mObj.getHotelCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getCode() && null != mObj.getCode()) {
				if (!this.getCode().equals(mObj.getCode())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGroup() && null != mObj.getGroup()) {
				if (!this.getGroup().equals(mObj.getGroup())) {
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHdetailFacilitiesPK#hashCode()
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
			if (null != this.getCode()) {
				sb.append(this.getCode().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGroup()) {
				sb.append(this.getGroup().hashCode());
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