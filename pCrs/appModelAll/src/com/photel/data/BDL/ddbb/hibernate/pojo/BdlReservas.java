package com.photel.data.BDL.ddbb.hibernate.pojo;

import com.photel.data.BDL.ddbb.hibernate.pojo.base.BaseBdlReservas;



public class BdlReservas extends BaseBdlReservas {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BdlReservas () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BdlReservas (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BdlReservas (
		java.lang.Integer id,
		java.util.Date bdlTimcre,
		java.lang.String bdlReservaConfirmada) {

		super (
			id,
			bdlTimcre,
			bdlReservaConfirmada);
	}

/*[CONSTRUCTOR MARKER END]*/


}