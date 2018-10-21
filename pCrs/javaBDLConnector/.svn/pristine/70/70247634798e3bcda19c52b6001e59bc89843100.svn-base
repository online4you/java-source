package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPurchase;
import com.photel.interfaces.data.BDL.IBdlHdetailDescriptions;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.data.BDL.IBdlvHimages;


public class BDLHotel implements IBDLHotel,Serializable {
	private String nombre;
	private String servicioCodigo; 
	private String servicio;
	private String producto;
	private String zona;
	private String zonaCodigo;
	private String destino;
	private String destinoCodigo;
	private String cadena;
	private String cadenaCodigo;
	private String localidad;
	private String localidadCodigo;
	private String pais;
	private String paisCodigo;
	private String categoria;
	private String categoriaCodigo;
	private String latitud;
	private String longitud;
	private List<String> imagenes;
	private List<IBDLContrato> contratos;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private String descripcion;
	private String availToken;
	private GregorianCalendar availTimeStamp;
	private IBDLPurchase purchase;
	private String SPUI;
	private Hashtable<String,IBdlHdetailDescriptions> descriptions;
	private Hashtable<String, ArrayList<IBdlvHdetailFacilities>> facilities;
	private Hashtable<String, ArrayList<IBdlvHimages>> imagesMap;
	private ArrayList<IBdlvHimages> imagesList;
	
	public BDLHotel(List<List<String>> distri) throws Exception{
		super();
		init();
		IBDLContrato distribuciones = new BDLContrato(distri);
		this.contratos=new ArrayList<IBDLContrato>();
		this.contratos.add(distribuciones);
	}
	
	public BDLHotel(){
		super();
		init();

	}	
	private void init(){
		this.contratos=new ArrayList<IBDLContrato>();
		this.descriptions=new Hashtable<String,IBdlHdetailDescriptions>();
		this.facilities=new Hashtable<String, ArrayList<IBdlvHdetailFacilities>>();
		this.imagesMap=new Hashtable<String, ArrayList<IBdlvHimages>>();
		this.imagesList=new ArrayList<IBdlvHimages>();
	}


	




	public Hashtable<String, ArrayList<IBdlvHimages>> getImagesMap() {
		return imagesMap;
	}

	public void setImagesMap(Hashtable<String, ArrayList<IBdlvHimages>> imagesMap) {
		this.imagesMap = imagesMap;
	}

	public ArrayList<IBdlvHimages> getImagesList() {
		return imagesList;
	}

	public void setImagesList(ArrayList<IBdlvHimages> imagesList) {
		this.imagesList = imagesList;
	}

	public Hashtable<String, IBdlHdetailDescriptions> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(
			Hashtable<String, IBdlHdetailDescriptions> descriptions) {
		this.descriptions = descriptions;
	}
	public IBdlHdetailDescriptions getDescription(String languageCode) {
		return descriptions.get(languageCode);
	}
	public void setDescription(String languageCode, IBdlHdetailDescriptions description) {
		this.descriptions.put(languageCode, description);
	}
	
	

	public Hashtable<String, ArrayList<IBdlvHdetailFacilities>> getFacilities() {
		return facilities;
	}

	public void setFacilities(
			Hashtable<String, ArrayList<IBdlvHdetailFacilities>> facilities) {
		this.facilities = facilities;
	}

	public GregorianCalendar getAvailTimeStamp() {
		return availTimeStamp;
	}










	public void setAvailTimeStamp(GregorianCalendar availTimeStamp) {
		this.availTimeStamp = availTimeStamp;
	}










	public String getSPUI() {
		return SPUI;
	}





	public void setSPUI(String sPUI) {
		SPUI = sPUI;
	}





	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getNombre()
	 */
	@Override
	public String getNombre() {
		return nombre;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getServicioCodigo()
	 */
	@Override
	public String getServicioCodigo() {
		return servicioCodigo;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setServicioCodigo(java.lang.String)
	 */
	@Override
	public void setServicioCodigo(String servicioCodigo) {
		this.servicioCodigo = servicioCodigo;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getServicio()
	 */
	@Override
	public String getServicio() {
		return servicio;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setServicio(java.lang.String)
	 */
	@Override
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getProducto()
	 */
	@Override
	public String getProducto() {
		return producto;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setProducto(java.lang.String)
	 */
	@Override
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getZona()
	 */
	@Override
	public String getZona() {
		return zona;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setZona(java.lang.String)
	 */
	@Override
	public void setZona(String zona) {
		this.zona = zona;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getZonaCodigo()
	 */
	@Override
	public String getZonaCodigo() {
		return zonaCodigo;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setZonaCodigo(java.lang.String)
	 */
	@Override
	public void setZonaCodigo(String zonaCodigo) {
		this.zonaCodigo = zonaCodigo;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getCategoria()
	 */
	@Override
	public String getCategoria() {
		return categoria;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setCategoria(java.lang.String)
	 */
	@Override
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getCategoriaCodigo()
	 */
	@Override
	public String getCategoriaCodigo() {
		return categoriaCodigo;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setCategoriaCodigo(java.lang.String)
	 */
	@Override
	public void setCategoriaCodigo(String categoriaCodigo) {
		this.categoriaCodigo = categoriaCodigo;
	}



	public List<IBDLContrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<IBDLContrato> contrato) {
		this.contratos = contrato;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getLatitud()
	 */
	@Override
	public String getLatitud() {
		return latitud;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setLatitud(java.lang.String)
	 */
	@Override
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getLongitud()
	 */
	@Override
	public String getLongitud() {
		return longitud;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setLongitud(java.lang.String)
	 */
	@Override
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#getImagenes()
	 */
	@Override
	public List<String> getImagenes() {
		return imagenes;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLHotel#setImagenes(java.util.List)
	 */
	@Override
	public void setImagenes(List<String> imagenes) {
		this.imagenes = imagenes;
	}


	public BigDecimal getPrecioMin() {
		return precioMin;
	}


	public void setPrecioMin(BigDecimal precioMin) {
		this.precioMin = precioMin;
	}


	public BigDecimal getPrecioMax() {
		return precioMax;
	}


	public void setPrecioMax(BigDecimal precioMax) {
		this.precioMax = precioMax;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getAvailToken() {
		return availToken;
	}


	public void setAvailToken(String availToken) {
		this.availToken = availToken;
	}


	public IBDLPurchase getPurchase() {
		return purchase;
	}


	public void setPurchase(IBDLPurchase purchase) {
		this.purchase = purchase;
	}





	public String getLocalidad() {
		return localidad;
	}





	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}





	public String getPais() {
		return pais;
	}





	public void setPais(String pais) {
		this.pais = pais;
	}





	public String getLocalidadCodigo() {
		return localidadCodigo;
	}





	public void setLocalidadCodigo(String localidadCodigo) {
		this.localidadCodigo = localidadCodigo;
	}





	public String getPaisCodigo() {
		return paisCodigo;
	}





	public void setPaisCodigo(String paisCodigo) {
		this.paisCodigo = paisCodigo;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getDestinoCodigo() {
		return destinoCodigo;
	}

	public void setDestinoCodigo(String destinoCodigo) {
		this.destinoCodigo = destinoCodigo;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getCadenaCodigo() {
		return cadenaCodigo;
	}

	public void setCadenaCodigo(String cadenaCodigo) {
		this.cadenaCodigo = cadenaCodigo;
	}


	
	
}
