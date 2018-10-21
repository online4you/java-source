package com.photel.data.gen.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.gen.IGenBanners01;


/**
 * This is an object that contains data related to the genv_banners01 table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="genv_banners01"
 */

public abstract class BaseGenBanners01  implements Serializable, IGenBanners01 {

	public static String REF = "GenBanners01";
	public static String PROP_IMAGEURL = "Imageurl";
	public static String PROP_STICKY = "Sticky";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_EDITOR = "Editor";
	public static String PROP_ORDERING = "Ordering";
	public static String PROP_CUSTOMBANNERCODE = "Custombannercode";
	public static String PROP_TYPE = "Type";
	public static String PROP_CLICKURL = "Clickurl";
	public static String PROP_CHECKED_OUT = "CheckedOut";
	public static String PROP_CLICKS = "Clicks";
	public static String PROP_NAME = "Name";
	public static String PROP_TAGS = "Tags";
	public static String PROP_SHOW_BANNER = "ShowBanner";
	public static String PROP_ALIAS = "Alias";
	public static String PROP_CID = "Cid";
	public static String PROP_PARAMS = "Params";
	public static String PROP_IMPTOTAL = "Imptotal";
	public static String PROP_ID = "id";
	public static String PROP_CATID = "Catid";
	public static String PROP_IMPMADE = "Impmade";


	// constructors
	public BaseGenBanners01 () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseGenBanners01 (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseGenBanners01 (
		java.lang.Integer id,
		java.lang.Integer cid,
		java.lang.String type,
		java.lang.String name,
		java.lang.String alias,
		java.lang.Integer imptotal,
		java.lang.Integer impmade,
		java.lang.Integer clicks,
		java.lang.String imageurl,
		java.lang.String clickurl,
		boolean showBanner,
		boolean checkedOut,
		java.lang.Integer catid,
		java.lang.String description,
		boolean sticky,
		java.lang.Integer ordering,
		java.lang.String tags,
		java.lang.String params) {

		this.setId(id);
		this.setCid(cid);
		this.setType(type);
		this.setName(name);
		this.setAlias(alias);
		this.setImptotal(imptotal);
		this.setImpmade(impmade);
		this.setClicks(clicks);
		this.setImageurl(imageurl);
		this.setClickurl(clickurl);
		this.setShowBanner(showBanner);
		this.setCheckedOut(checkedOut);
		this.setCatid(catid);
		this.setDescription(description);
		this.setSticky(sticky);
		this.setOrdering(ordering);
		this.setTags(tags);
		this.setParams(params);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer cid;
	private java.lang.String type;
	private java.lang.String name;
	private java.lang.String alias;
	private java.lang.Integer imptotal;
	private java.lang.Integer impmade;
	private java.lang.Integer clicks;
	private java.lang.String imageurl;
	private java.lang.String clickurl;
	private boolean showBanner;
	private boolean checkedOut;
	private java.lang.String editor;
	private java.lang.String custombannercode;
	private java.lang.Integer catid;
	private java.lang.String description;
	private boolean sticky;
	private java.lang.Integer ordering;
	private java.lang.String tags;
	private java.lang.String params;



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getId()
	 */
	@Override
	public java.lang.Integer getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setId(java.lang.Integer)
	 */
	@Override
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getCid()
	 */
	@Override
	public java.lang.Integer getCid () {
		return cid;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setCid(java.lang.Integer)
	 */
	@Override
	public void setCid (java.lang.Integer cid) {
		this.cid = cid;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getType()
	 */
	@Override
	public java.lang.String getType () {
		return type;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setType(java.lang.String)
	 */
	@Override
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getName()
	 */
	@Override
	public java.lang.String getName () {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setName(java.lang.String)
	 */
	@Override
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getAlias()
	 */
	@Override
	public java.lang.String getAlias () {
		return alias;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setAlias(java.lang.String)
	 */
	@Override
	public void setAlias (java.lang.String alias) {
		this.alias = alias;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getImptotal()
	 */
	@Override
	public java.lang.Integer getImptotal () {
		return imptotal;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setImptotal(java.lang.Integer)
	 */
	@Override
	public void setImptotal (java.lang.Integer imptotal) {
		this.imptotal = imptotal;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getImpmade()
	 */
	@Override
	public java.lang.Integer getImpmade () {
		return impmade;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setImpmade(java.lang.Integer)
	 */
	@Override
	public void setImpmade (java.lang.Integer impmade) {
		this.impmade = impmade;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getClicks()
	 */
	@Override
	public java.lang.Integer getClicks () {
		return clicks;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setClicks(java.lang.Integer)
	 */
	@Override
	public void setClicks (java.lang.Integer clicks) {
		this.clicks = clicks;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getImageurl()
	 */
	@Override
	public java.lang.String getImageurl () {
		return imageurl;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setImageurl(java.lang.String)
	 */
	@Override
	public void setImageurl (java.lang.String imageurl) {
		this.imageurl = imageurl;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getClickurl()
	 */
	@Override
	public java.lang.String getClickurl () {
		return clickurl;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setClickurl(java.lang.String)
	 */
	@Override
	public void setClickurl (java.lang.String clickurl) {
		this.clickurl = clickurl;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#isShowBanner()
	 */
	@Override
	public boolean isShowBanner () {
		return showBanner;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setShowBanner(boolean)
	 */
	@Override
	public void setShowBanner (boolean showBanner) {
		this.showBanner = showBanner;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#isCheckedOut()
	 */
	@Override
	public boolean isCheckedOut () {
		return checkedOut;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setCheckedOut(boolean)
	 */
	@Override
	public void setCheckedOut (boolean checkedOut) {
		this.checkedOut = checkedOut;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getEditor()
	 */
	@Override
	public java.lang.String getEditor () {
		return editor;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setEditor(java.lang.String)
	 */
	@Override
	public void setEditor (java.lang.String editor) {
		this.editor = editor;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getCustombannercode()
	 */
	@Override
	public java.lang.String getCustombannercode () {
		return custombannercode;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setCustombannercode(java.lang.String)
	 */
	@Override
	public void setCustombannercode (java.lang.String custombannercode) {
		this.custombannercode = custombannercode;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getCatid()
	 */
	@Override
	public java.lang.Integer getCatid () {
		return catid;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setCatid(java.lang.Integer)
	 */
	@Override
	public void setCatid (java.lang.Integer catid) {
		this.catid = catid;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getDescription()
	 */
	@Override
	public java.lang.String getDescription () {
		return description;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#isSticky()
	 */
	@Override
	public boolean isSticky () {
		return sticky;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setSticky(boolean)
	 */
	@Override
	public void setSticky (boolean sticky) {
		this.sticky = sticky;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getOrdering()
	 */
	@Override
	public java.lang.Integer getOrdering () {
		return ordering;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setOrdering(java.lang.Integer)
	 */
	@Override
	public void setOrdering (java.lang.Integer ordering) {
		this.ordering = ordering;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getTags()
	 */
	@Override
	public java.lang.String getTags () {
		return tags;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setTags(java.lang.String)
	 */
	@Override
	public void setTags (java.lang.String tags) {
		this.tags = tags;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#getParams()
	 */
	@Override
	public java.lang.String getParams () {
		return params;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#setParams(java.lang.String)
	 */
	@Override
	public void setParams (java.lang.String params) {
		this.params = params;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.gen.ddbb.hibernate.pojo.GenBanners01)) return false;
		else {
			com.photel.data.gen.ddbb.hibernate.pojo.GenBanners01 genBanners01 = (com.photel.data.gen.ddbb.hibernate.pojo.GenBanners01) obj;
			if (null == this.getId() || null == genBanners01.getId()) return false;
			else return (this.getId().equals(genBanners01.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#hashCode()
	 */
	@Override
	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	/* (non-Javadoc)
	 * @see com.photel.data.gen.ddbb.hibernate.pojo.base.IGenBanners01#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}