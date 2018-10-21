package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLCategoria;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLLocalidad;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;

public class BDLDisponibilidad implements IBDLDisponibilidad,Serializable {
	private List<IBDLHotel> hoteles;
	private int numeroDePaginas;
	private List<String> peticiones;
	private List<String> respuestas;
	private String tokenDispo;
	private GregorianCalendar availTimeStamp=new GregorianCalendar();
	private List<IBDLCategoria> categorias;
	private List<IBDLRegimen> regimenesAlimentarios;
	private Hashtable<String, String> contratos;
	private Hashtable<String, ArrayList<String>> facilities;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private List<IBDLLocalidad> localidades;
	
	public BDLDisponibilidad(){
		hoteles=new ArrayList<IBDLHotel>();
		peticiones=new ArrayList<String>();
		respuestas=new ArrayList<String>();
		precioMin=BigDecimal.ZERO;
		precioMax=BigDecimal.ZERO;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#getHoteles()
	 */
	@Override
	public List<IBDLHotel> getHoteles() {
		return hoteles;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#setHoteles(java.util.List)
	 */
	@Override
	public void setHoteles(List<IBDLHotel> hoteles) {
		this.hoteles = hoteles;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#getNumeroDePaginas()
	 */
	@Override
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#setNumeroDePaginas(int)
	 */
	@Override
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}
	
	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#getPeticiones()
	 */
	@Override
	public List<String> getPeticiones() {
		return peticiones;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#setPeticiones(java.util.List)
	 */
	@Override
	public void setPeticiones(List<String> peticiones) {
		this.peticiones = peticiones;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#getRespuestas()
	 */
	@Override
	public List<String> getRespuestas() {
		return respuestas;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDisponibilidad#setRespuestas(java.util.List)
	 */
	@Override
	public void setRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}
	public String getTokenDispo() {
		return tokenDispo;
	}
	public void setTokenDispo(String tokenDispo) {
		this.tokenDispo = tokenDispo;
	}
	public GregorianCalendar getAvailTimeStamp() {
		return availTimeStamp;
	}
	public void setAvailTimeStamp(GregorianCalendar availTimeStamp) {
		this.availTimeStamp = availTimeStamp;
	}
	public Hashtable<String, ArrayList<String>> getFacilities() {
		return facilities;
	}
	public void setFacilities(
			Hashtable<String, ArrayList<String>> facilities) {
		this.facilities = facilities;
	}
	public List<IBDLCategoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<IBDLCategoria> categorias) {
		this.categorias = categorias;
	}
	public List<IBDLRegimen> getRegimenesAlimentarios() {
		return regimenesAlimentarios;
	}
	public void setRegimenesAlimentarios(List<IBDLRegimen> regimenesAlimentarios) {
		this.regimenesAlimentarios = regimenesAlimentarios;
	}
	public Hashtable<String, String> getContratos() {
		return contratos;
	}
	public void setContratos(Hashtable<String, String> contratos) {
		this.contratos = contratos;
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
	public List<IBDLLocalidad> getLocalidades() {
		return localidades;
	}
	public void setLocalidades(List<IBDLLocalidad> localidades) {
		this.localidades = localidades;
	}

	

}
