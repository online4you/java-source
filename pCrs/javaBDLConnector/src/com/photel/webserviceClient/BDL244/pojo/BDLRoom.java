package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

import com.photel.interfaces.BDL244.IBDLCancelationPrice;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;

public class BDLRoom implements IBDLRoom,Serializable {
	
	private String habitacionCodigo; 
	private String habitacionCaracteristica; 
	private String habitacion;
	private String habitacionTipo; 
	private List<IBDLRegimen> regimenesAlimentarios;
	private List<IBDLCancelationPrice> preciosCancelacion;
	
	public BDLRoom(){
		super();
		regimenesAlimentarios=new ArrayList<IBDLRegimen>();
		preciosCancelacion=new ArrayList<IBDLCancelationPrice>();
	}
	
	
	public IBDLRegimen getRegimen(String codigo){
		if (codigo!=null){
			for (int i=0;i<regimenesAlimentarios.size();i++){
				if (regimenesAlimentarios.get(i).getCodigo()!=null && regimenesAlimentarios.get(i).getCodigo().equals(codigo)){
					return regimenesAlimentarios.get(i);
				}
			}
		}
		return null;
		
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#setRegimen(java.lang.String, java.lang.String, java.math.BigDecimal)
	 */
	@Override
	public void setRegimen(String codigo, String descripcion,BigDecimal precio){
		BDLRegimen regimen=new BDLRegimen(codigo, descripcion,precio);
		regimenesAlimentarios.add(regimen);
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#getRegimenesAlimentarios()
	 */
	@Override
	public List<IBDLRegimen> getRegimenesAlimentarios() {
		return regimenesAlimentarios;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#setRegimenesAlimentarios(java.util.List)
	 */
	@Override
	public void setRegimenesAlimentarios(List<IBDLRegimen> regimenesAlimentarios) {
		this.regimenesAlimentarios = regimenesAlimentarios;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#getHabitacionCodigo()
	 */
	@Override
	public String getHabitacionCodigo() {
		return habitacionCodigo;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#setHabitacionCodigo(java.lang.String)
	 */
	@Override
	public void setHabitacionCodigo(String habitacionCodigo) {
		this.habitacionCodigo = habitacionCodigo;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#getHabitacion()
	 */
	@Override
	public String getHabitacion() {
		return habitacion;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#setHabitacion(java.lang.String)
	 */
	@Override
	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
	

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#getHabitacionTipo()
	 */
	@Override
	public String getHabitacionTipo() {
		return habitacionTipo;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLRoom#setHabitacionTipo(java.lang.String)
	 */
	@Override
	public void setHabitacionTipo(String habitacionTipo) {
		this.habitacionTipo = habitacionTipo;
	}

	public String getHabitacionCaracteristica() {
		return habitacionCaracteristica;
	}

	public void setHabitacionCaracteristica(String habitacionCaracteristica) {
		this.habitacionCaracteristica = habitacionCaracteristica;
	}

	public List<IBDLCancelationPrice> getPreciosCancelacion() {
		return preciosCancelacion;
	}

	public void setPreciosCancelacion(List<IBDLCancelationPrice> preciosCancelacion) {
		this.preciosCancelacion = preciosCancelacion;
	}



	


}
