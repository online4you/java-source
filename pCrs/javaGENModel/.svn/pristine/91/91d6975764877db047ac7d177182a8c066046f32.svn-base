package com.photel.mail.data.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.mail.IGenMailTemplatesAttPK;


public abstract class BaseGenMailTemplatesAttPK implements Serializable, IGenMailTemplatesAttPK {

	protected int hashCode = Integer.MIN_VALUE;

	private java.lang.String gmaLang;
	private java.lang.String gmaTitle;
	private java.lang.String gmaFilename;


	public BaseGenMailTemplatesAttPK () {}
	
	public BaseGenMailTemplatesAttPK (
		java.lang.String gmaLang,
		java.lang.String gmaTitle,
		java.lang.String gmaFilename) {

		this.setGmaLang(gmaLang);
		this.setGmaTitle(gmaTitle);
		this.setGmaFilename(gmaFilename);
	}


	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#getGmaLang()
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#getGmaLang()
	 */
	public java.lang.String getGmaLang () {
		return gmaLang;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#setGmaLang(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#setGmaLang(java.lang.String)
	 */
	public void setGmaLang (java.lang.String gmaLang) {
		this.gmaLang = gmaLang;
	}



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#getGmaTitle()
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#getGmaTitle()
	 */
	public java.lang.String getGmaTitle () {
		return gmaTitle;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#setGmaTitle(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#setGmaTitle(java.lang.String)
	 */
	public void setGmaTitle (java.lang.String gmaTitle) {
		this.gmaTitle = gmaTitle;
	}



	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#getGmaFilename()
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#getGmaFilename()
	 */
	public java.lang.String getGmaFilename () {
		return gmaFilename;
	}

	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#setGmaFilename(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#setGmaFilename(java.lang.String)
	 */
	public void setGmaFilename (java.lang.String gmaFilename) {
		this.gmaFilename = gmaFilename;
	}




	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#equals(java.lang.Object)
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#equals(java.lang.Object)
	 */
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAttPK)) return false;
		else {
			com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAttPK mObj = (com.photel.mail.data.ddbb.hibernate.pojo.GenMailTemplatesAttPK) obj;
			if (null != this.getGmaLang() && null != mObj.getGmaLang()) {
				if (!this.getGmaLang().equals(mObj.getGmaLang())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGmaTitle() && null != mObj.getGmaTitle()) {
				if (!this.getGmaTitle().equals(mObj.getGmaTitle())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getGmaFilename() && null != mObj.getGmaFilename()) {
				if (!this.getGmaFilename().equals(mObj.getGmaFilename())) {
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
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesPK#hashCode()
	 */
	/* (non-Javadoc)
	 * @see com.photel.mail.data.ddbb.hibernate.pojo.base.IGenMailTemplatesAttPK#hashCode()
	 */
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuilder sb = new StringBuilder();
			if (null != this.getGmaLang()) {
				sb.append(this.getGmaLang().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGmaTitle()) {
				sb.append(this.getGmaTitle().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getGmaFilename()) {
				sb.append(this.getGmaFilename().hashCode());
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