package com.photel.interfaces.BDL244;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import com.photel.webserviceClient.BDL244.pojo.BDLRegimen;

public interface IBDLRoom {

	public abstract void setRegimen(String codigo, String descripcion,
			BigDecimal precio);

	public abstract List<IBDLRegimen> getRegimenesAlimentarios();

	public abstract void setRegimenesAlimentarios(
			List<IBDLRegimen> regimenesAlimentarios);

	public abstract String getHabitacionCodigo();

	public abstract void setHabitacionCodigo(String habitacionCodigo);

	public abstract String getHabitacion();

	public abstract void setHabitacion(String habitacion);

	public abstract String getHabitacionTipo();

	public abstract void setHabitacionTipo(String habitacionTipo);
	
	public String getHabitacionCaracteristica() ;

	public void setHabitacionCaracteristica(String habitacionCaracteristica) ;
	public List<IBDLCancelationPrice> getPreciosCancelacion() ;
	public void setPreciosCancelacion(List<IBDLCancelationPrice> preciosCancelacion) ;
	public IBDLRegimen getRegimen(String codigo);
}