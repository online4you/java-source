package com.photel.data.BDL.ddbb.hibernate.pojo.base;

import java.io.Serializable;

import com.photel.interfaces.data.BDL.IBdlReservas;


/**
 * This is an object that contains data related to the bdl_reservas table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="bdl_reservas"
 */

public abstract class BaseBdlReservas  implements Serializable, IBdlReservas {

	public static String REF = "BdlReservas";
	public static String PROP_BDL_CHECK_ACEPTO_POLITICA = "BdlCheckAceptoPolitica";
	public static String PROP_BDL_FACTURA_DOCUMENTO = "BdlFacturaDocumento";
	public static String PROP_BDL_RESERVA_CONFIRMADA = "BdlReservaConfirmada";
	public static String PROP_BDL_NOMBRE = "BdlNombre";
	public static String PROP_BDL_TIPO_DOCUMENTO_ID = "BdlTipoDocumentoId";
	public static String PROP_BDL_IDIOMA = "BdlIdioma";
	public static String PROP_BDL_ID_HOTEL = "BdlIdHotel";
	public static String PROP_BDL_APELLIDOS = "BdlApellidos";
	public static String PROP_BDL_CHECK_ACEPTO_CONDIDIONES = "BdlCheckAceptoCondidiones";
	public static String PROP_BDL_FACTURA_PAIS = "BdlFacturaPais";
	public static String PROP_BDL_CONTACTO_NOMBRE = "BdlContactoNombre";
	public static String PROP_BDL_AG_COMISSION = "BdlAgComission";
	public static String PROP_BDL_NOCHES = "BdlNoches";
	public static String PROP_BDL_IMPORTE_TOTAL = "BdlImporteTotal";
	public static String PROP_BDL_COMENTARIOS = "BdlComentarios";
	public static String PROP_BDL_GASTOS = "BdlGastos";
	public static String PROP_BDL_IMPORTE_PAGADO = "BdlImportePagado";
	public static String PROP_BDL_DESCUENTO = "BdlDescuento";
	public static String PROP_BDL_FACTURA_DIRECCION = "BdlFacturaDireccion";
	public static String PROP_BDL_PAXES = "BdlPaxes";
	public static String PROP_BDL_CONTACTO_APELLIDOS = "BdlContactoApellidos";
	public static String PROP_BDL_TIPO_DOCUMENTO = "BdlTipoDocumento";
	public static String PROP_BDL_FACTURA_LOCALIDAD = "BdlFacturaLocalidad";
	public static String PROP_BDL_LOCATA = "BdlLocata";
	public static String PROP_BDL_URL = "BdlUrl";
	public static String PROP_BDL_FACTURA_NOMBRE = "BdlFacturaNombre";
	public static String PROP_BDL_FACTURA_EMAIL = "BdlFacturaEmail";
	public static String PROP_BDL_COMISSION_VAT = "BdlComissionVat";
	public static String PROP_BDL_CONTACTO_TELEFONO = "BdlContactoTelefono";
	public static String PROP_BDL_FECHA_GASTOS = "BdlFechaGastos";
	public static String PROP_BDL_RADIO_TIPO_PAGO = "BdlRadioTipoPago";
	public static String PROP_BDL_FACTURA_CP = "BdlFacturaCp";
	public static String PROP_BDL_ZONA = "BdlZona";
	public static String PROP_BDL_TIMCRE = "BdlTimcre";
	public static String PROP_BDL_CHECK_CONTACTO = "BdlCheckContacto";
	public static String PROP_BDL_TELEFONO = "BdlTelefono";
	public static String PROP_BDL_NOMBRE_HOTEL = "BdlNombreHotel";
	public static String PROP_BDL_CHECK_FACTURA = "BdlCheckFactura";
	public static String PROP_BDL_FACTURA_NUMERO = "BdlFacturaNumero";
	public static String PROP_BDL_EMAIL = "BdlEmail";
	public static String PROP_ID = "Id";
	public static String PROP_BDL_ENTRADA = "BdlEntrada";
	public static String PROP_BDL_HOTEL = "BdlHotel";
	public static String PROP_BDL_SALIDA = "BdlSalida";
	public static String PROP_BDL_DOCUMENTO = "BdlDocumento";
	public static String PROP_BDL_CHECK_RECIBIR_OFERTAS = "BdlCheckRecibirOfertas";


	// constructors
	public BaseBdlReservas () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBdlReservas (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBdlReservas (
		java.lang.Integer id,
		java.util.Date bdlTimcre,
		java.lang.String bdlReservaConfirmada) {

		this.setId(id);
		this.setBdlTimcre(bdlTimcre);
		this.setBdlReservaConfirmada(bdlReservaConfirmada);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date bdlTimcre;
	private java.lang.String bdlHotel;
	private java.lang.String bdlIdHotel;
	private java.lang.String bdlNombreHotel;
	private java.util.Date bdlFechaGastos;
	private java.lang.Double bdlGastos;
	private java.util.Date bdlEntrada;
	private java.util.Date bdlSalida;
	private java.lang.Integer bdlNoches;
	private java.lang.String bdlZona;
	private java.lang.String bdlIdioma;
	private java.lang.String bdlNombre;
	private java.lang.String bdlApellidos;
	private java.lang.String bdlTipoDocumento;
	private java.lang.String bdlTipoDocumentoId;
	private java.lang.String bdlDocumento;
	private java.lang.String bdlTelefono;
	private java.lang.String bdlEmail;
	private java.lang.String bdlComentarios;
	private java.lang.String bdlPaxes;
	private java.lang.String bdlCheckFactura;
	private java.lang.Integer bdlFacturaNumero;
	private java.lang.String bdlFacturaNombre;
	private java.lang.String bdlFacturaDocumento;
	private java.lang.String bdlFacturaCp;
	private java.lang.String bdlFacturaDireccion;
	private java.lang.String bdlFacturaLocalidad;
	private java.lang.String bdlFacturaPais;
	private java.lang.String bdlFacturaEmail;
	private java.lang.String bdlCheckContacto;
	private java.lang.String bdlContactoNombre;
	private java.lang.String bdlContactoApellidos;
	private java.lang.String bdlContactoTelefono;
	private java.lang.String bdlCheckRecibirOfertas;
	private java.lang.String bdlCheckAceptoCondidiones;
	private java.lang.String bdlCheckAceptoPolitica;
	private java.lang.String bdlRadioTipoPago;
	private java.lang.Double bdlImporteTotal;
	private java.lang.Double bdlAgComission;
	private java.lang.Double bdlComissionVat;
	private java.lang.Double bdlImportePagado;
	private java.lang.Double bdlDescuento;
	private java.lang.String bdlReservaConfirmada;
	private java.lang.String bdlLocata;
	private java.lang.String bdlUrl;



	public java.lang.Double getBdlDescuento() {
		return bdlDescuento;
	}

	public void setBdlDescuento(java.lang.Double bdlDescuento) {
		this.bdlDescuento = bdlDescuento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getId()
	 */
	@Override
	public java.lang.Integer getId () {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setId(java.lang.Integer)
	 */
	@Override
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlTimcre()
	 */
	@Override
	public java.util.Date getBdlTimcre () {
		return bdlTimcre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlTimcre(java.util.Date)
	 */
	@Override
	public void setBdlTimcre (java.util.Date bdlTimcre) {
		this.bdlTimcre = bdlTimcre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlHotel()
	 */
	@Override
	public java.lang.String getBdlHotel () {
		return bdlHotel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlHotel(java.lang.String)
	 */
	@Override
	public void setBdlHotel (java.lang.String bdlHotel) {
		this.bdlHotel = bdlHotel;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlIdHotel()
	 */
	@Override
	public java.lang.String getBdlIdHotel () {
		return bdlIdHotel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlIdHotel(java.lang.String)
	 */
	@Override
	public void setBdlIdHotel (java.lang.String bdlIdHotel) {
		this.bdlIdHotel = bdlIdHotel;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlNombreHotel()
	 */
	@Override
	public java.lang.String getBdlNombreHotel () {
		return bdlNombreHotel;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlNombreHotel(java.lang.String)
	 */
	@Override
	public void setBdlNombreHotel (java.lang.String bdlNombreHotel) {
		this.bdlNombreHotel = bdlNombreHotel;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFechaGastos()
	 */
	@Override
	public java.util.Date getBdlFechaGastos () {
		return bdlFechaGastos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFechaGastos(java.util.Date)
	 */
	@Override
	public void setBdlFechaGastos (java.util.Date bdlFechaGastos) {
		this.bdlFechaGastos = bdlFechaGastos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlGastos()
	 */
	@Override
	public java.lang.Double getBdlGastos () {
		return bdlGastos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlGastos(java.lang.Double)
	 */
	@Override
	public void setBdlGastos (java.lang.Double bdlGastos) {
		this.bdlGastos = bdlGastos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlEntrada()
	 */
	@Override
	public java.util.Date getBdlEntrada () {
		return bdlEntrada;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlEntrada(java.util.Date)
	 */
	@Override
	public void setBdlEntrada (java.util.Date bdlEntrada) {
		this.bdlEntrada = bdlEntrada;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlSalida()
	 */
	@Override
	public java.util.Date getBdlSalida () {
		return bdlSalida;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlSalida(java.util.Date)
	 */
	@Override
	public void setBdlSalida (java.util.Date bdlSalida) {
		this.bdlSalida = bdlSalida;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlNoches()
	 */
	@Override
	public java.lang.Integer getBdlNoches () {
		return bdlNoches;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlNoches(java.lang.Integer)
	 */
	@Override
	public void setBdlNoches (java.lang.Integer bdlNoches) {
		this.bdlNoches = bdlNoches;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlZona()
	 */
	@Override
	public java.lang.String getBdlZona () {
		return bdlZona;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlZona(java.lang.String)
	 */
	@Override
	public void setBdlZona (java.lang.String bdlZona) {
		this.bdlZona = bdlZona;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlIdioma()
	 */
	@Override
	public java.lang.String getBdlIdioma () {
		return bdlIdioma;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlIdioma(java.lang.String)
	 */
	@Override
	public void setBdlIdioma (java.lang.String bdlIdioma) {
		this.bdlIdioma = bdlIdioma;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlNombre()
	 */
	@Override
	public java.lang.String getBdlNombre () {
		return bdlNombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlNombre(java.lang.String)
	 */
	@Override
	public void setBdlNombre (java.lang.String bdlNombre) {
		this.bdlNombre = bdlNombre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlApellidos()
	 */
	@Override
	public java.lang.String getBdlApellidos () {
		return bdlApellidos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlApellidos(java.lang.String)
	 */
	@Override
	public void setBdlApellidos (java.lang.String bdlApellidos) {
		this.bdlApellidos = bdlApellidos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlTipoDocumento()
	 */
	@Override
	public java.lang.String getBdlTipoDocumento () {
		return bdlTipoDocumento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlTipoDocumento(java.lang.String)
	 */
	@Override
	public void setBdlTipoDocumento (java.lang.String bdlTipoDocumento) {
		this.bdlTipoDocumento = bdlTipoDocumento;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlTipoDocumentoId()
	 */
	@Override
	public java.lang.String getBdlTipoDocumentoId () {
		return bdlTipoDocumentoId;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlTipoDocumentoId(java.lang.String)
	 */
	@Override
	public void setBdlTipoDocumentoId (java.lang.String bdlTipoDocumentoId) {
		this.bdlTipoDocumentoId = bdlTipoDocumentoId;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlDocumento()
	 */
	@Override
	public java.lang.String getBdlDocumento () {
		return bdlDocumento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlDocumento(java.lang.String)
	 */
	@Override
	public void setBdlDocumento (java.lang.String bdlDocumento) {
		this.bdlDocumento = bdlDocumento;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlTelefono()
	 */
	@Override
	public java.lang.String getBdlTelefono () {
		return bdlTelefono;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlTelefono(java.lang.String)
	 */
	@Override
	public void setBdlTelefono (java.lang.String bdlTelefono) {
		this.bdlTelefono = bdlTelefono;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlEmail()
	 */
	@Override
	public java.lang.String getBdlEmail () {
		return bdlEmail;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlEmail(java.lang.String)
	 */
	@Override
	public void setBdlEmail (java.lang.String bdlEmail) {
		this.bdlEmail = bdlEmail;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlComentarios()
	 */
	@Override
	public java.lang.String getBdlComentarios () {
		return bdlComentarios;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlComentarios(java.lang.String)
	 */
	@Override
	public void setBdlComentarios (java.lang.String bdlComentarios) {
		this.bdlComentarios = bdlComentarios;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlPaxes()
	 */
	@Override
	public java.lang.String getBdlPaxes () {
		return bdlPaxes;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlPaxes(java.lang.String)
	 */
	@Override
	public void setBdlPaxes (java.lang.String bdlPaxes) {
		this.bdlPaxes = bdlPaxes;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlCheckFactura()
	 */
	@Override
	public java.lang.String getBdlCheckFactura () {
		return bdlCheckFactura;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlCheckFactura(java.lang.String)
	 */
	@Override
	public void setBdlCheckFactura (java.lang.String bdlCheckFactura) {
		this.bdlCheckFactura = bdlCheckFactura;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaNumero()
	 */
	@Override
	public java.lang.Integer getBdlFacturaNumero () {
		return bdlFacturaNumero;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaNumero(java.lang.Integer)
	 */
	@Override
	public void setBdlFacturaNumero (java.lang.Integer bdlFacturaNumero) {
		this.bdlFacturaNumero = bdlFacturaNumero;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaNombre()
	 */
	@Override
	public java.lang.String getBdlFacturaNombre () {
		return bdlFacturaNombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaNombre(java.lang.String)
	 */
	@Override
	public void setBdlFacturaNombre (java.lang.String bdlFacturaNombre) {
		this.bdlFacturaNombre = bdlFacturaNombre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaDocumento()
	 */
	@Override
	public java.lang.String getBdlFacturaDocumento () {
		return bdlFacturaDocumento;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaDocumento(java.lang.String)
	 */
	@Override
	public void setBdlFacturaDocumento (java.lang.String bdlFacturaDocumento) {
		this.bdlFacturaDocumento = bdlFacturaDocumento;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaCp()
	 */
	@Override
	public java.lang.String getBdlFacturaCp () {
		return bdlFacturaCp;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaCp(java.lang.String)
	 */
	@Override
	public void setBdlFacturaCp (java.lang.String bdlFacturaCp) {
		this.bdlFacturaCp = bdlFacturaCp;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaDireccion()
	 */
	@Override
	public java.lang.String getBdlFacturaDireccion () {
		return bdlFacturaDireccion;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaDireccion(java.lang.String)
	 */
	@Override
	public void setBdlFacturaDireccion (java.lang.String bdlFacturaDireccion) {
		this.bdlFacturaDireccion = bdlFacturaDireccion;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaLocalidad()
	 */
	@Override
	public java.lang.String getBdlFacturaLocalidad () {
		return bdlFacturaLocalidad;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaLocalidad(java.lang.String)
	 */
	@Override
	public void setBdlFacturaLocalidad (java.lang.String bdlFacturaLocalidad) {
		this.bdlFacturaLocalidad = bdlFacturaLocalidad;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaPais()
	 */
	@Override
	public java.lang.String getBdlFacturaPais () {
		return bdlFacturaPais;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaPais(java.lang.String)
	 */
	@Override
	public void setBdlFacturaPais (java.lang.String bdlFacturaPais) {
		this.bdlFacturaPais = bdlFacturaPais;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlFacturaEmail()
	 */
	@Override
	public java.lang.String getBdlFacturaEmail () {
		return bdlFacturaEmail;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlFacturaEmail(java.lang.String)
	 */
	@Override
	public void setBdlFacturaEmail (java.lang.String bdlFacturaEmail) {
		this.bdlFacturaEmail = bdlFacturaEmail;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlCheckContacto()
	 */
	@Override
	public java.lang.String getBdlCheckContacto () {
		return bdlCheckContacto;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlCheckContacto(java.lang.String)
	 */
	@Override
	public void setBdlCheckContacto (java.lang.String bdlCheckContacto) {
		this.bdlCheckContacto = bdlCheckContacto;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlContactoNombre()
	 */
	@Override
	public java.lang.String getBdlContactoNombre () {
		return bdlContactoNombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlContactoNombre(java.lang.String)
	 */
	@Override
	public void setBdlContactoNombre (java.lang.String bdlContactoNombre) {
		this.bdlContactoNombre = bdlContactoNombre;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlContactoApellidos()
	 */
	@Override
	public java.lang.String getBdlContactoApellidos () {
		return bdlContactoApellidos;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlContactoApellidos(java.lang.String)
	 */
	@Override
	public void setBdlContactoApellidos (java.lang.String bdlContactoApellidos) {
		this.bdlContactoApellidos = bdlContactoApellidos;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlContactoTelefono()
	 */
	@Override
	public java.lang.String getBdlContactoTelefono () {
		return bdlContactoTelefono;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlContactoTelefono(java.lang.String)
	 */
	@Override
	public void setBdlContactoTelefono (java.lang.String bdlContactoTelefono) {
		this.bdlContactoTelefono = bdlContactoTelefono;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlCheckRecibirOfertas()
	 */
	@Override
	public java.lang.String getBdlCheckRecibirOfertas () {
		return bdlCheckRecibirOfertas;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlCheckRecibirOfertas(java.lang.String)
	 */
	@Override
	public void setBdlCheckRecibirOfertas (java.lang.String bdlCheckRecibirOfertas) {
		this.bdlCheckRecibirOfertas = bdlCheckRecibirOfertas;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlCheckAceptoCondidiones()
	 */
	@Override
	public java.lang.String getBdlCheckAceptoCondidiones () {
		return bdlCheckAceptoCondidiones;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlCheckAceptoCondidiones(java.lang.String)
	 */
	@Override
	public void setBdlCheckAceptoCondidiones (java.lang.String bdlCheckAceptoCondidiones) {
		this.bdlCheckAceptoCondidiones = bdlCheckAceptoCondidiones;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlCheckAceptoPolitica()
	 */
	@Override
	public java.lang.String getBdlCheckAceptoPolitica () {
		return bdlCheckAceptoPolitica;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlCheckAceptoPolitica(java.lang.String)
	 */
	@Override
	public void setBdlCheckAceptoPolitica (java.lang.String bdlCheckAceptoPolitica) {
		this.bdlCheckAceptoPolitica = bdlCheckAceptoPolitica;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlRadioTipoPago()
	 */
	@Override
	public java.lang.String getBdlRadioTipoPago () {
		return bdlRadioTipoPago;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlRadioTipoPago(java.lang.String)
	 */
	@Override
	public void setBdlRadioTipoPago (java.lang.String bdlRadioTipoPago) {
		this.bdlRadioTipoPago = bdlRadioTipoPago;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlImporteTotal()
	 */
	@Override
	public java.lang.Double getBdlImporteTotal () {
		return bdlImporteTotal;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlImporteTotal(java.lang.Double)
	 */
	@Override
	public void setBdlImporteTotal (java.lang.Double bdlImporteTotal) {
		this.bdlImporteTotal = bdlImporteTotal;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlAgComission()
	 */
	@Override
	public java.lang.Double getBdlAgComission () {
		return bdlAgComission;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlAgComission(java.lang.Double)
	 */
	@Override
	public void setBdlAgComission (java.lang.Double bdlAgComission) {
		this.bdlAgComission = bdlAgComission;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlComissionVat()
	 */
	@Override
	public java.lang.Double getBdlComissionVat () {
		return bdlComissionVat;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlComissionVat(java.lang.Double)
	 */
	@Override
	public void setBdlComissionVat (java.lang.Double bdlComissionVat) {
		this.bdlComissionVat = bdlComissionVat;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlImportePagado()
	 */
	@Override
	public java.lang.Double getBdlImportePagado () {
		return bdlImportePagado;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlImportePagado(java.lang.Double)
	 */
	@Override
	public void setBdlImportePagado (java.lang.Double bdlImportePagado) {
		this.bdlImportePagado = bdlImportePagado;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlReservaConfirmada()
	 */
	@Override
	public java.lang.String getBdlReservaConfirmada () {
		return bdlReservaConfirmada;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlReservaConfirmada(java.lang.String)
	 */
	@Override
	public void setBdlReservaConfirmada (java.lang.String bdlReservaConfirmada) {
		this.bdlReservaConfirmada = bdlReservaConfirmada;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlLocata()
	 */
	@Override
	public java.lang.String getBdlLocata () {
		return bdlLocata;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlLocata(java.lang.String)
	 */
	@Override
	public void setBdlLocata (java.lang.String bdlLocata) {
		this.bdlLocata = bdlLocata;
	}



	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#getBdlUrl()
	 */
	@Override
	public java.lang.String getBdlUrl () {
		return bdlUrl;
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#setBdlUrl(java.lang.String)
	 */
	@Override
	public void setBdlUrl (java.lang.String bdlUrl) {
		this.bdlUrl = bdlUrl;
	}




	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#equals(java.lang.Object)
	 */
	@Override
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.photel.data.BDL.ddbb.hibernate.pojo.BdlReservas)) return false;
		else {
			com.photel.data.BDL.ddbb.hibernate.pojo.BdlReservas bdlReservas = (com.photel.data.BDL.ddbb.hibernate.pojo.BdlReservas) obj;
			if (null == this.getId() || null == bdlReservas.getId()) return false;
			else return (this.getId().equals(bdlReservas.getId()));
		}
	}

	/* (non-Javadoc)
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#hashCode()
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
	 * @see com.photel.data.BDL.ddbb.hibernate.pojo.base.IBdlReservas#toString()
	 */
	@Override
	public String toString () {
		return super.toString();
	}


}