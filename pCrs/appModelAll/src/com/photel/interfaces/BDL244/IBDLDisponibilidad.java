package com.photel.interfaces.BDL244;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.webserviceClient.BDL244.pojo.BDLHotel;

public interface IBDLDisponibilidad {

	public abstract List<IBDLHotel> getHoteles();

	public abstract void setHoteles(List<IBDLHotel> hoteles);

	public abstract int getNumeroDePaginas();

	public abstract void setNumeroDePaginas(int numeroDePaginas);

	public abstract List<String> getPeticiones();

	public abstract void setPeticiones(List<String> peticiones);

	public abstract List<String> getRespuestas();

	public abstract void setRespuestas(List<String> respuestas);
	
	public String getTokenDispo() ;
	
	public void setTokenDispo(String tokenDispo) ;

	public GregorianCalendar getAvailTimeStamp();
	public void setAvailTimeStamp(GregorianCalendar availTimeStamp) ;
	public List<IBDLCategoria> getCategorias();
	public void setCategorias(List<IBDLCategoria> categorias);
	public List<IBDLRegimen> getRegimenesAlimentarios();
	public void setRegimenesAlimentarios(List<IBDLRegimen> regimenesAlimentarios);
	public Hashtable<String, String> getContratos();
	public void setContratos(Hashtable<String, String> contratos);
	public Hashtable<String, ArrayList<String>> getFacilities();
	public void setFacilities(Hashtable<String, ArrayList<String>> facilities);
	public BigDecimal getPrecioMin();
	public void setPrecioMin(BigDecimal precioMin);
	public BigDecimal getPrecioMax();
	public void setPrecioMax(BigDecimal precioMax);
	public List<IBDLLocalidad> getLocalidades();
	public void setLocalidades(List<IBDLLocalidad> localidades);
}