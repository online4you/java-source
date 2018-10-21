package com.photel.data.gen.ddbb.hibernate.pojo;

import com.photel.data.gen.ddbb.hibernate.pojo.base.BaseGenTracking;



public class GenTracking extends BaseGenTracking {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public GenTracking () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public GenTracking (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public GenTracking (
		java.lang.Integer id,
		java.util.Date gtrDatcre) {

		super (
			id,
			gtrDatcre);
	}

/*[CONSTRUCTOR MARKER END]*/


}