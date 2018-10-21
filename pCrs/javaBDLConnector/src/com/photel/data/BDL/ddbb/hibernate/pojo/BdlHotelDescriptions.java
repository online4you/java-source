package com.photel.data.BDL.ddbb.hibernate.pojo;

import com.photel.data.BDL.ddbb.hibernate.pojo.base.BaseBdlHotelDescriptions;



public class BdlHotelDescriptions extends BaseBdlHotelDescriptions {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdlHotelDescriptions () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdlHotelDescriptions (com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDescriptionsPK id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdlHotelDescriptions (
		com.photel.data.BDL.ddbb.hibernate.pojo.BdlHotelDescriptionsPK id,
		java.lang.String bdlDescription) {

		super (
			id,
			bdlDescription);
	}

/*[CONSTRUCTOR MARKER END]*/


}