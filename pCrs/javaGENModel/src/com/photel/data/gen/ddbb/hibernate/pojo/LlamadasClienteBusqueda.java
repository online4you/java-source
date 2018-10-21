package com.photel.data.gen.ddbb.hibernate.pojo;

import com.photel.data.gen.ddbb.hibernate.pojo.base.BaseLlamadasClienteBusqueda;



public class LlamadasClienteBusqueda extends BaseLlamadasClienteBusqueda {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LlamadasClienteBusqueda () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LlamadasClienteBusqueda (java.lang.String lcbSeqbusqueda) {
		super(lcbSeqbusqueda);
	}

	/**
	 * Constructor for required fields
	 */
	public LlamadasClienteBusqueda (
		java.lang.String lcbSeqbusqueda,
		java.lang.String lcbSeqllamada) {

		super (
			lcbSeqbusqueda,
			lcbSeqllamada);
	}

/*[CONSTRUCTOR MARKER END]*/


}