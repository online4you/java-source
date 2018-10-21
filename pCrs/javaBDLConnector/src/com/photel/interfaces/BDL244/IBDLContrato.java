package com.photel.interfaces.BDL244;

import java.math.BigDecimal;
import java.util.List;


public interface IBDLContrato {

	public abstract String getCodigoClasificacion();

	public abstract void setCodigoClasificacion(String codigoClasificacion);

	public abstract String getClasificacion();

	public abstract void setClasificacion(String clasificacion);

	public abstract String getCodigoOficina();

	public abstract void setCodigoOficina(String codigoOficina);

	public abstract String getOficina();

	public abstract void setOficina(String oficina);

	public abstract String getNombre();

	public abstract void setNombre(String nombre);

	public abstract List<IBDLDistribucion> getDistribuciones();

	public abstract void setDistribuciones(List<IBDLDistribucion> distribuciones);
	
	public BigDecimal getPrecioMin() ;

	public void setPrecioMin(BigDecimal precioMin);

	public BigDecimal getPrecioMax();

	public void setPrecioMax(BigDecimal precioMax);

	public List<String> getComentarios();

	public void setComentarios(List<String> comentarios);
	
	public List<IBDLPromotion> getPromotions();

	public void setPromotions(List<IBDLPromotion> promotions);
}