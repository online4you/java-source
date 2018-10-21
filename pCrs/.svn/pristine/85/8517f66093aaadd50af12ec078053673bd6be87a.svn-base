package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLPromotion;

public class BDLContrato implements IBDLContrato,Serializable {
	private String codigoClasificacion;
	private String clasificacion;
	private String codigoOficina;
	private String oficina;
	private List<String> comentarios;
	private List<IBDLPromotion> promotions;
	private String nombre;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	
	private List<IBDLDistribucion> distribuciones;
	
	public BDLContrato(List<List<String>> distri) throws Exception{
		super();
		promotions =new ArrayList<IBDLPromotion>();
		distribuciones= new ArrayList<IBDLDistribucion>();
		BDLDistribucion dist;
		int ad;
		int ch;
		for (int h=0;h<distri.size();h++){
			List<String> paxes = distri.get(h);
			dist= new BDLDistribucion();
			ad=0;
			ch=0;
			for (int p=0;p<paxes.size();p++){
				String[] pax=paxes.get(p).split("#");
				if (pax[0].equals("ADT")){
					dist.createAdult();
					ad++;
				}else if (pax[0].equals("NIN")){
					dist.createChild(Integer.parseInt(pax[1]));
					ch++;
				}else{
					throw new Exception("Error en las distribuciones: no se trata ni de ADT ni de NIN");
				}
			}
			dist.setNumDistribucion(h+1);
			distribuciones.add(dist);
		}
	}

	
	public List<IBDLPromotion> getPromotions() {
		return promotions;
	}


	public void setPromotions(List<IBDLPromotion> promotions) {
		this.promotions = promotions;
	}


	public BDLContrato() {
		super();
		distribuciones= new ArrayList<IBDLDistribucion>();
	}

	
	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#getCodigoClasificacion()
	 */
	@Override
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#setCodigoClasificacion(java.lang.String)
	 */
	@Override
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#getClasificacion()
	 */
	@Override
	public String getClasificacion() {
		return clasificacion;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#setClasificacion(java.lang.String)
	 */
	@Override
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#getCodigoOficina()
	 */
	@Override
	public String getCodigoOficina() {
		return codigoOficina;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#setCodigoOficina(java.lang.String)
	 */
	@Override
	public void setCodigoOficina(String codigoOficina) {
		this.codigoOficina = codigoOficina;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#getOficina()
	 */
	@Override
	public String getOficina() {
		return oficina;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#setOficina(java.lang.String)
	 */
	@Override
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#getNombre()
	 */
	@Override
	public String getNombre() {
		return nombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#getDistribuciones()
	 */
	@Override
	public List<IBDLDistribucion> getDistribuciones() {
		return distribuciones;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLContrato#setDistribuciones(java.util.List)
	 */
	@Override
	public void setDistribuciones(List<IBDLDistribucion> distribuciones) {
		this.distribuciones = distribuciones;
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


	public List<String> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<String> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
}
