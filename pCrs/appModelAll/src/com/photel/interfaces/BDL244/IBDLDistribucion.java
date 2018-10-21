package com.photel.interfaces.BDL244;
/*
 
 
 
 
 * */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface IBDLDistribucion {

	public abstract void createAdult();

	public abstract void createChild(int edad);

	public abstract int getAdultos();

	public abstract int getNinos();

	public abstract List<IBDLPax> getPaxes();

	public abstract List<IBDLRoom> getRooms();

	public abstract void setRooms(List<IBDLRoom> listaHabitaciones);

	public abstract int getNumDistribucion();

	public abstract void setNumDistribucion(int numDistribucion);
	
	public BigDecimal getPrecioMin() ;

	public void setPrecioMin(BigDecimal precioMin);

	public BigDecimal getPrecioMax();

	public void setPrecioMax(BigDecimal precioMax);
	
	public String getStringOcupacion();
	
	public ArrayList<String> getStringHabitaciones();

	public ArrayList<String> getStringPaxes();

	public ArrayList<String> getTextosLenguas();

	public void setTextosLenguas(ArrayList<String> textosLenguas);

}