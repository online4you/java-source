package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlvHimages;
import com.photel.interfaces.data.BDL.IBdlvHimagesPK;


/**
 * This is an object that contains data related to the bdlv_himages table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdlv_himages"
 */

public abstract class BaseBdlvHimages  implements Serializable, IBdlvHimages {

	public static String REF = "BdlvHimages";
	public static String PROP_NAME = "Name";
	public static String PROP_VISUALIZATIONORDER = "Visualizationorder";
	public static String PROP_ID = "Id";
	public static String PROP_IMAGEPATH = "Imagepath";


	// constructors
	public BaseBdlvHimages () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlvHimages (IBdlvHimagesPK id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlvHimages (
		IBdlvHimagesPK id,
		java.lang.String imagepath) {

		this.setId(id);
		this.setImagepath(imagepath);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private IBdlvHimagesPK id;

	// fields
	private java.lang.String visualizationorder;
	private java.lang.String imagepath;
	private java.lang.String name;



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#getId()
	 */
	@Override
	public IBdlvHimagesPK getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#setId(com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimagesPK)
	 */
	@Override
	public void setId (IBdlvHimagesPK id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#getVisualizationorder()
	 */
	@Override
	public java.lang.String getVisualizationorder () {
		return visualizationorder;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#setVisualizationorder(java.lang.String)
	 */
	@Override
	public void setVisualizationorder (java.lang.String visualizationorder) {
		this.visualizationorder = visualizationorder;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#getImagepath()
	 */
	@Override
	public java.lang.String getImagepath () {
		return imagepath;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#setImagepath(java.lang.String)
	 */
	@Override
	public void setImagepath (java.lang.String imagepath) {
		this.imagepath = imagepath;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#getName()
	 */
	@Override
	public java.lang.String getName () {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#setName(java.lang.String)
	 */
	@Override
	public void setName (java.lang.String name) {
		this.name = name;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHimages)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHimages bdlvHimages = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlvHimages) obj;
			if (null == this.getId() || null == bdlvHimages.getId()) return false;
			else return (this.getId().equals(bdlvHimages.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlvHimages#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}