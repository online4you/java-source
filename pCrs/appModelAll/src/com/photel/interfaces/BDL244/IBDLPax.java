package com.photel.interfaces.BDL244;

import java.util.GregorianCalendar;

public interface IBDLPax {

	public abstract String getTipoPax();

	public abstract void setTipoPax(String tipoPax);

	public abstract int getEdad();

	public abstract void setEdad(int edad);
	public String getNombre();
	public void setNombre(String nombre) ;
	public String getApellidos() ;
	public void setApellidos(String apellidos) ;
	public GregorianCalendar getFechaNacimiento();
	public void setFechaNacimiento(GregorianCalendar fechaNacimiento);
}