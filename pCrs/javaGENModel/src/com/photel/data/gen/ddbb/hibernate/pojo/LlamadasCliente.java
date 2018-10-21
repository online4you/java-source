package com.photel.data.gen.ddbb.hibernate.pojo;

import com.photel.data.gen.ddbb.hibernate.pojo.base.BaseLlamadasCliente;



public class LlamadasCliente extends BaseLlamadasCliente {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LlamadasCliente () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LlamadasCliente (java.lang.String llcSeq) {
		super(llcSeq);
	}

	/**
	 * Constructor for required fields
	 */
	public LlamadasCliente (
		java.lang.String llcSeq,
		java.lang.String llcSite,
		java.util.Date llcFecha,
		java.lang.String llcTelefono,
		java.util.Date llcDiaHora,
		java.lang.String llcSwirevisada) {

		super (
			llcSeq,
			llcSite,
			llcFecha,
			llcTelefono,
			llcDiaHora,
			llcSwirevisada);
	}

/*[CONSTRUCTOR MARKER END]*/


}