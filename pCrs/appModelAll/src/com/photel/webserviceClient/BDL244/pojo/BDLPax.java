package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.photel.interfaces.BDL244.IBDLPax;

public class BDLPax  implements Serializable, IBDLPax{
	private String tipoPax; //ADT, NIN, INF
	private int edad;
	private String nombre;
	private String apellidos;
	private GregorianCalendar fechaNacimiento;
	
	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPax#getTipoPax()
	 */
	@Override
	public String getTipoPax() {
		return tipoPax;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPax#setTipoPax(java.lang.String)
	 */
	@Override
	public void setTipoPax(String tipoPax) {
		this.tipoPax = tipoPax;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPax#getEdad()
	 */
	@Override
	public int getEdad() {
		return edad;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPax#setEdad(int)
	 */
	@Override
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public GregorianCalendar getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		this.edad=getAge(fechaNacimiento);
	}
	private int getAge(Calendar cal) {
        Calendar now = new GregorianCalendar();
        int res = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
          || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)
          && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH)))
        {
           res--;
        }
        return res;
      }
	
}
