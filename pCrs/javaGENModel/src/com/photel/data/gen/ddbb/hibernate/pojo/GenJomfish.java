package com.photel.data.gen.ddbb.hibernate.pojo;

import com.photel.data.gen.ddbb.hibernate.pojo.base.BaseGenJomfish;



public class GenJomfish extends BaseGenJomfish {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public GenJomfish () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public GenJomfish (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public GenJomfish (
		java.lang.Integer id,
		java.lang.Integer languageId,
		java.lang.Integer referenceId,
		java.lang.String referenceTable,
		java.lang.String referenceField,
		java.lang.String value,
		java.lang.String originalText,
		java.util.Date modified,
		java.lang.Integer modifiedBy,
		boolean published) {

		super (
			id,
			languageId,
			referenceId,
			referenceTable,
			referenceField,
			value,
			originalText,
			modified,
			modifiedBy,
			published);
	}

/*[CONSTRUCTOR MARKER END]*/


}