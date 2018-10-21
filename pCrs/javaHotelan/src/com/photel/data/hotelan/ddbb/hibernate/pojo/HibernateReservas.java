package com.photel.data.hotelan.ddbb.hibernate.pojo;

import java.io.Serializable;



/**
 * This is an object that contains data related to the Hl_reservas table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Hl_reservas"
 */

public class HibernateReservas  implements Serializable {

	public static String REF = "HlReservas";
	public static String PROP_Hl_CHECK_ACEPTO_POLITICA = "HlCheckAceptoPolitica";
	public static String PROP_Hl_FACTURA_DOCUMENTO = "HlFacturaDocumento";
	public static String PROP_Hl_RESERVA_CONFIRMADA = "HlReservaConfirmada";
	public static String PROP_Hl_NOMBRE = "HlNombre";
	public static String PROP_Hl_TIPO_DOCUMENTO_ID = "HlTipoDocumentoId";
	public static String PROP_Hl_IDIOMA = "HlIdioma";
	public static String PROP_Hl_ID_HOTEL = "HlIdHotel";
	public static String PROP_Hl_APELLIDOS = "HlApellidos";
	public static String PROP_Hl_CHECK_ACEPTO_CONDIDIONES = "HlCheckAceptoCondidiones";
	public static String PROP_Hl_FACTURA_PAIS = "HlFacturaPais";
	public static String PROP_Hl_CONTACTO_NOMBRE = "HlContactoNombre";
	public static String PROP_Hl_AG_COMISSION = "HlAgComission";
	public static String PROP_Hl_NOCHES = "HlNoches";
	public static String PROP_Hl_IMPORTE_TOTAL = "HlImporteTotal";
	public static String PROP_Hl_COMENTARIOS = "HlComentarios";
	public static String PROP_Hl_GASTOS = "HlGastos";
	public static String PROP_Hl_IMPORTE_PAGADO = "HlImportePagado";
	public static String PROP_Hl_DESCUENTO = "HlDescuento";
	public static String PROP_Hl_FACTURA_DIRECCION = "HlFacturaDireccion";
	public static String PROP_Hl_PAXES = "HlPaxes";
	public static String PROP_Hl_CONTACTO_APELLIDOS = "HlContactoApellidos";
	public static String PROP_Hl_TIPO_DOCUMENTO = "HlTipoDocumento";
	public static String PROP_Hl_FACTURA_LOCALIDAD = "HlFacturaLocalidad";
	public static String PROP_Hl_LOCATA = "HlLocata";
	public static String PROP_Hl_URL = "HlUrl";
	public static String PROP_Hl_FACTURA_NOMBRE = "HlFacturaNombre";
	public static String PROP_Hl_FACTURA_EMAIL = "HlFacturaEmail";
	public static String PROP_Hl_COMISSION_VAT = "HlComissionVat";
	public static String PROP_Hl_CONTACTO_TELEFONO = "HlContactoTelefono";
	public static String PROP_Hl_FECHA_GASTOS = "HlFechaGastos";
	public static String PROP_Hl_RADIO_TIPO_PAGO = "HlRadioTipoPago";
	public static String PROP_Hl_FACTURA_CP = "HlFacturaCp";
	public static String PROP_Hl_ZONA = "HlZona";
	public static String PROP_Hl_TIMCRE = "HlTimcre";
	public static String PROP_Hl_CHECK_CONTACTO = "HlCheckContacto";
	public static String PROP_Hl_TELEFONO = "HlTelefono";
	public static String PROP_Hl_NOMBRE_HOTEL = "HlNombreHotel";
	public static String PROP_Hl_CHECK_FACTURA = "HlCheckFactura";
	public static String PROP_Hl_FACTURA_NUMERO = "HlFacturaNumero";
	public static String PROP_Hl_EMAIL = "HlEmail";
	public static String PROP_ID = "Id";
	public static String PROP_Hl_ENTRADA = "HlEntrada";
	public static String PROP_Hl_HOTEL = "HlHotel";
	public static String PROP_Hl_SALIDA = "HlSalida";
	public static String PROP_Hl_DOCUMENTO = "HlDocumento";
	public static String PROP_Hl_CHECK_RECIBIR_OFERTAS = "HlCheckRecibirOfertas";
	public static String PROP__HL_HOTEL_ROOM="HlHotelRoom";
	public static String PROP_HL_HOTEL_TYPE="HlHotelType";
	
	// constructors
	public HibernateReservas () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public HibernateReservas (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public HibernateReservas (
		java.lang.Integer id,
		java.util.Date HlTimcre,
		java.lang.String HlReservaConfirmada) {

		this.setId(id);
		this.setHlTimcre(HlTimcre);
		this.setHlReservaConfirmada(HlReservaConfirmada);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date HlTimcre;
	private java.lang.String HlHotel;
	private java.lang.String HlIdHotel;
	private java.lang.String HlNombreHotel;
	private java.util.Date HlFechaGastos;
	private java.lang.Double HlGastos;
	private java.util.Date HlEntrada;
	private java.util.Date HlSalida;
	private java.lang.Integer HlNoches;
	private java.lang.String HlZona;
	private java.lang.String HlIdioma;
	private java.lang.String HlNombre;
	private java.lang.String HlApellidos;
	private java.lang.String HlTipoDocumento;
	private java.lang.String HlTipoDocumentoId;
	private java.lang.String HlDocumento;
	private java.lang.String HlTelefono;
	private java.lang.String HlEmail;
	private java.lang.String HlComentarios;
	private java.lang.String HlPaxes;
	private java.lang.String HlCheckFactura;
	private java.lang.Integer HlFacturaNumero;
	private java.lang.String HlFacturaNombre;
	private java.lang.String HlFacturaDocumento;
	private java.lang.String HlFacturaCp;
	private java.lang.String HlFacturaDireccion;
	private java.lang.String HlFacturaLocalidad;
	private java.lang.String HlFacturaPais;
	private java.lang.String HlFacturaEmail;
	private java.lang.String HlCheckContacto;
	private java.lang.String HlContactoNombre;
	private java.lang.String HlContactoApellidos;
	private java.lang.String HlContactoTelefono;
	private java.lang.String HlCheckRecibirOfertas;
	private java.lang.String HlCheckAceptoCondidiones;
	private java.lang.String HlCheckAceptoPolitica;
	private java.lang.String HlRadioTipoPago;
	private java.lang.Double HlImporteTotal;
	private java.lang.Double HlAgComission;
	private java.lang.Double HlComissionVat;
	private java.lang.Double HlImportePagado;
	private java.lang.Double HlDescuento;
	private java.lang.String HlReservaConfirmada;
	private java.lang.String HlLocata;
	private java.lang.String HlUrl;
	private java.lang.String HlCs;
	private java.lang.String HlHotelRoom;
	private java.lang.String HlHotelType;
	private java.lang.Integer HlAdults;
	private java.lang.Integer HlChilds;
	private java.lang.Integer HlInfants;
	private java.lang.String HLBoard;
	
	
	public java.lang.Double getHlDescuento() {
		return HlDescuento;
	}

	public void setHlDescuento(java.lang.Double HlDescuento) {
		this.HlDescuento = HlDescuento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getId()
	 */
	
	public java.lang.Integer getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setId(java.lang.Integer)
	 */
	
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlTimcre()
	 */
	
	public java.util.Date getHlTimcre () {
		return HlTimcre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlTimcre(java.util.Date)
	 */
	
	public void setHlTimcre (java.util.Date HlTimcre) {
		this.HlTimcre = HlTimcre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlHotel()
	 */
	
	public java.lang.String getHlHotel () {
		return HlHotel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlHotel(java.lang.String)
	 */
	
	public void setHlHotel (java.lang.String HlHotel) {
		this.HlHotel = HlHotel;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlIdHotel()
	 */
	
	public java.lang.String getHlIdHotel () {
		return HlIdHotel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlIdHotel(java.lang.String)
	 */
	
	public void setHlIdHotel (java.lang.String HlIdHotel) {
		this.HlIdHotel = HlIdHotel;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlNombreHotel()
	 */
	
	public java.lang.String getHlNombreHotel () {
		return HlNombreHotel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlNombreHotel(java.lang.String)
	 */
	
	public void setHlNombreHotel (java.lang.String HlNombreHotel) {
		this.HlNombreHotel = HlNombreHotel;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFechaGastos()
	 */
	
	public java.util.Date getHlFechaGastos () {
		return HlFechaGastos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFechaGastos(java.util.Date)
	 */
	
	public void setHlFechaGastos (java.util.Date HlFechaGastos) {
		this.HlFechaGastos = HlFechaGastos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlGastos()
	 */
	
	public java.lang.Double getHlGastos () {
		return HlGastos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlGastos(java.lang.Double)
	 */
	
	public void setHlGastos (java.lang.Double HlGastos) {
		this.HlGastos = HlGastos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlEntrada()
	 */
	
	public java.util.Date getHlEntrada () {
		return HlEntrada;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlEntrada(java.util.Date)
	 */
	
	public void setHlEntrada (java.util.Date HlEntrada) {
		this.HlEntrada = HlEntrada;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlSalida()
	 */
	
	public java.util.Date getHlSalida () {
		return HlSalida;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlSalida(java.util.Date)
	 */
	
	public void setHlSalida (java.util.Date HlSalida) {
		this.HlSalida = HlSalida;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlNoches()
	 */
	
	public java.lang.Integer getHlNoches () {
		return HlNoches;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlNoches(java.lang.Integer)
	 */
	
	public void setHlNoches (java.lang.Integer HlNoches) {
		this.HlNoches = HlNoches;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlZona()
	 */
	
	public java.lang.String getHlZona () {
		return HlZona;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlZona(java.lang.String)
	 */
	
	public void setHlZona (java.lang.String HlZona) {
		this.HlZona = HlZona;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlIdioma()
	 */
	
	public java.lang.String getHlIdioma () {
		return HlIdioma;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlIdioma(java.lang.String)
	 */
	
	public void setHlIdioma (java.lang.String HlIdioma) {
		this.HlIdioma = HlIdioma;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlNombre()
	 */
	
	public java.lang.String getHlNombre () {
		return HlNombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlNombre(java.lang.String)
	 */
	
	public void setHlNombre (java.lang.String HlNombre) {
		this.HlNombre = HlNombre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlApellidos()
	 */
	
	public java.lang.String getHlApellidos () {
		return HlApellidos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlApellidos(java.lang.String)
	 */
	
	public void setHlApellidos (java.lang.String HlApellidos) {
		this.HlApellidos = HlApellidos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlTipoDocumento()
	 */
	
	public java.lang.String getHlTipoDocumento () {
		return HlTipoDocumento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlTipoDocumento(java.lang.String)
	 */
	
	public void setHlTipoDocumento (java.lang.String HlTipoDocumento) {
		this.HlTipoDocumento = HlTipoDocumento;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlTipoDocumentoId()
	 */
	
	public java.lang.String getHlTipoDocumentoId () {
		return HlTipoDocumentoId;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlTipoDocumentoId(java.lang.String)
	 */
	
	public void setHlTipoDocumentoId (java.lang.String HlTipoDocumentoId) {
		this.HlTipoDocumentoId = HlTipoDocumentoId;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlDocumento()
	 */
	
	public java.lang.String getHlDocumento () {
		return HlDocumento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlDocumento(java.lang.String)
	 */
	
	public void setHlDocumento (java.lang.String HlDocumento) {
		this.HlDocumento = HlDocumento;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlTelefono()
	 */
	
	public java.lang.String getHlTelefono () {
		return HlTelefono;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlTelefono(java.lang.String)
	 */
	
	public void setHlTelefono (java.lang.String HlTelefono) {
		this.HlTelefono = HlTelefono;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlEmail()
	 */
	
	public java.lang.String getHlEmail () {
		return HlEmail;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlEmail(java.lang.String)
	 */
	
	public void setHlEmail (java.lang.String HlEmail) {
		this.HlEmail = HlEmail;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlComentarios()
	 */
	
	public java.lang.String getHlComentarios () {
		return HlComentarios;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlComentarios(java.lang.String)
	 */
	
	public void setHlComentarios (java.lang.String HlComentarios) {
		this.HlComentarios = HlComentarios;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlPaxes()
	 */
	
	public java.lang.String getHlPaxes () {
		return HlPaxes;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlPaxes(java.lang.String)
	 */
	
	public void setHlPaxes (java.lang.String HlPaxes) {
		this.HlPaxes = HlPaxes;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlCheckFactura()
	 */
	
	public java.lang.String getHlCheckFactura () {
		return HlCheckFactura;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlCheckFactura(java.lang.String)
	 */
	
	public void setHlCheckFactura (java.lang.String HlCheckFactura) {
		this.HlCheckFactura = HlCheckFactura;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaNumero()
	 */
	
	public java.lang.Integer getHlFacturaNumero () {
		return HlFacturaNumero;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaNumero(java.lang.Integer)
	 */
	
	public void setHlFacturaNumero (java.lang.Integer HlFacturaNumero) {
		this.HlFacturaNumero = HlFacturaNumero;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaNombre()
	 */
	
	public java.lang.String getHlFacturaNombre () {
		return HlFacturaNombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaNombre(java.lang.String)
	 */
	
	public void setHlFacturaNombre (java.lang.String HlFacturaNombre) {
		this.HlFacturaNombre = HlFacturaNombre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaDocumento()
	 */
	
	public java.lang.String getHlFacturaDocumento () {
		return HlFacturaDocumento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaDocumento(java.lang.String)
	 */
	
	public void setHlFacturaDocumento (java.lang.String HlFacturaDocumento) {
		this.HlFacturaDocumento = HlFacturaDocumento;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaCp()
	 */
	
	public java.lang.String getHlFacturaCp () {
		return HlFacturaCp;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaCp(java.lang.String)
	 */
	
	public void setHlFacturaCp (java.lang.String HlFacturaCp) {
		this.HlFacturaCp = HlFacturaCp;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaDireccion()
	 */
	
	public java.lang.String getHlFacturaDireccion () {
		return HlFacturaDireccion;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaDireccion(java.lang.String)
	 */
	
	public void setHlFacturaDireccion (java.lang.String HlFacturaDireccion) {
		this.HlFacturaDireccion = HlFacturaDireccion;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaLocalidad()
	 */
	
	public java.lang.String getHlFacturaLocalidad () {
		return HlFacturaLocalidad;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaLocalidad(java.lang.String)
	 */
	
	public void setHlFacturaLocalidad (java.lang.String HlFacturaLocalidad) {
		this.HlFacturaLocalidad = HlFacturaLocalidad;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaPais()
	 */
	
	public java.lang.String getHlFacturaPais () {
		return HlFacturaPais;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaPais(java.lang.String)
	 */
	
	public void setHlFacturaPais (java.lang.String HlFacturaPais) {
		this.HlFacturaPais = HlFacturaPais;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlFacturaEmail()
	 */
	
	public java.lang.String getHlFacturaEmail () {
		return HlFacturaEmail;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlFacturaEmail(java.lang.String)
	 */
	
	public void setHlFacturaEmail (java.lang.String HlFacturaEmail) {
		this.HlFacturaEmail = HlFacturaEmail;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlCheckContacto()
	 */
	
	public java.lang.String getHlCheckContacto () {
		return HlCheckContacto;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlCheckContacto(java.lang.String)
	 */
	
	public void setHlCheckContacto (java.lang.String HlCheckContacto) {
		this.HlCheckContacto = HlCheckContacto;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlContactoNombre()
	 */
	
	public java.lang.String getHlContactoNombre () {
		return HlContactoNombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlContactoNombre(java.lang.String)
	 */
	
	public void setHlContactoNombre (java.lang.String HlContactoNombre) {
		this.HlContactoNombre = HlContactoNombre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlContactoApellidos()
	 */
	
	public java.lang.String getHlContactoApellidos () {
		return HlContactoApellidos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlContactoApellidos(java.lang.String)
	 */
	
	public void setHlContactoApellidos (java.lang.String HlContactoApellidos) {
		this.HlContactoApellidos = HlContactoApellidos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlContactoTelefono()
	 */
	
	public java.lang.String getHlContactoTelefono () {
		return HlContactoTelefono;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlContactoTelefono(java.lang.String)
	 */
	
	public void setHlContactoTelefono (java.lang.String HlContactoTelefono) {
		this.HlContactoTelefono = HlContactoTelefono;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlCheckRecibirOfertas()
	 */
	
	public java.lang.String getHlCheckRecibirOfertas () {
		return HlCheckRecibirOfertas;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlCheckRecibirOfertas(java.lang.String)
	 */
	
	public void setHlCheckRecibirOfertas (java.lang.String HlCheckRecibirOfertas) {
		this.HlCheckRecibirOfertas = HlCheckRecibirOfertas;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlCheckAceptoCondidiones()
	 */
	
	public java.lang.String getHlCheckAceptoCondidiones () {
		return HlCheckAceptoCondidiones;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlCheckAceptoCondidiones(java.lang.String)
	 */
	
	public void setHlCheckAceptoCondidiones (java.lang.String HlCheckAceptoCondidiones) {
		this.HlCheckAceptoCondidiones = HlCheckAceptoCondidiones;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlCheckAceptoPolitica()
	 */
	
	public java.lang.String getHlCheckAceptoPolitica () {
		return HlCheckAceptoPolitica;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlCheckAceptoPolitica(java.lang.String)
	 */
	
	public void setHlCheckAceptoPolitica (java.lang.String HlCheckAceptoPolitica) {
		this.HlCheckAceptoPolitica = HlCheckAceptoPolitica;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlRadioTipoPago()
	 */
	
	public java.lang.String getHlRadioTipoPago () {
		return HlRadioTipoPago;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlRadioTipoPago(java.lang.String)
	 */
	
	public void setHlRadioTipoPago (java.lang.String HlRadioTipoPago) {
		this.HlRadioTipoPago = HlRadioTipoPago;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlImporteTotal()
	 */
	
	public java.lang.Double getHlImporteTotal () {
		return HlImporteTotal;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlImporteTotal(java.lang.Double)
	 */
	
	public void setHlImporteTotal (java.lang.Double HlImporteTotal) {
		this.HlImporteTotal = HlImporteTotal;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlAgComission()
	 */
	
	public java.lang.Double getHlAgComission () {
		return HlAgComission;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlAgComission(java.lang.Double)
	 */
	
	public void setHlAgComission (java.lang.Double HlAgComission) {
		this.HlAgComission = HlAgComission;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlComissionVat()
	 */
	
	public java.lang.Double getHlComissionVat () {
		return HlComissionVat;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlComissionVat(java.lang.Double)
	 */
	
	public void setHlComissionVat (java.lang.Double HlComissionVat) {
		this.HlComissionVat = HlComissionVat;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlImportePagado()
	 */
	
	public java.lang.Double getHlImportePagado () {
		return HlImportePagado;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlImportePagado(java.lang.Double)
	 */
	
	public void setHlImportePagado (java.lang.Double HlImportePagado) {
		this.HlImportePagado = HlImportePagado;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlReservaConfirmada()
	 */
	
	public java.lang.String getHlReservaConfirmada () {
		return HlReservaConfirmada;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlReservaConfirmada(java.lang.String)
	 */
	
	public void setHlReservaConfirmada (java.lang.String HlReservaConfirmada) {
		this.HlReservaConfirmada = HlReservaConfirmada;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlLocata()
	 */
	
	public java.lang.String getHlLocata () {
		return HlLocata;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlLocata(java.lang.String)
	 */
	
	public void setHlLocata (java.lang.String HlLocata) {
		this.HlLocata = HlLocata;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlUrl()
	 */
	
	public java.lang.String getHlCs () {
		return HlCs;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlUrl(java.lang.String)
	 */
	
	public void setHlCs (java.lang.String HlCs) {
		this.HlCs = HlCs;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#getHlUrl()
	 */
	
	public java.lang.String getHlUrl () {
		return HlUrl;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#setHlUrl(java.lang.String)
	 */
	
	public void setHlUrl (java.lang.String HlUrl) {
		this.HlUrl = HlUrl;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#equals(java.lang.Object)
	 */
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof HibernateReservas)) return false;
		else {
			HibernateReservas HlReservas = (HibernateReservas) obj;
			if (null == this.getId() || null == HlReservas.getId()) return false;
			else return (this.getId().equals(HlReservas.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#hashCode()
	 */
	
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
	 * @see com.photel.data.Hl.ddbb.hibernate.pojo.base.IHlReservas#toString()
	 */
	
	public String toString () {
		return super.toString();
	}

	public java.lang.String getHlHotelRoom() {
		return HlHotelRoom;
	}

	public void setHlHotelRoom(java.lang.String hlHotelRoom) {
		HlHotelRoom = hlHotelRoom;
	}

	public java.lang.String getHlHotelType() {
		return HlHotelType;
	}

	public void setHlHotelType(java.lang.String hlHotelType) {
		HlHotelType = hlHotelType;
	}

	public java.lang.Integer getHlAdults() {
		return HlAdults;
	}

	public void setHlAdults(java.lang.Integer hlAdults) {
		HlAdults = hlAdults;
	}

	public java.lang.Integer getHlChilds() {
		return HlChilds;
	}

	public void setHlChilds(java.lang.Integer hlChilds) {
		HlChilds = hlChilds;
	}

	public java.lang.Integer getHlInfants() {
		return HlInfants;
	}

	public void setHlInfants(java.lang.Integer hlInfants) {
		HlInfants = hlInfants;
	}

	public java.lang.String  getHLBoard() {
		return HLBoard;
	}

	public void setHLBoard(java.lang.String  hLBoard) {
		HLBoard = hLBoard;
	}


}