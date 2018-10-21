package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLPax;
import com.photel.interfaces.BDL244.IBDLRoom;

public class BDLDistribucion implements IBDLDistribucion,Serializable {
	private int adultos;
	private int ninos;
	private List<IBDLPax> paxes;
	private List<IBDLRoom> rooms;
	private int numDistribucion;
	private BigDecimal precioMin;
	private BigDecimal precioMax;
	private ArrayList<String> textosLenguas;
	
	public BDLDistribucion() {
		super();
		paxes=new ArrayList<IBDLPax>();
		rooms=new ArrayList<IBDLRoom>();
		ninos=0;
		adultos=0;
		textosLenguas=new ArrayList<String>();
		textosLenguas.add("Adultos");
		textosLenguas.add("Adulto");
		textosLenguas.add("Niños");
		textosLenguas.add("Niño");
		textosLenguas.add("Años");
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#createAdult()
	 */
	@Override
	public void createAdult(){
		BDLPax pax=new BDLPax();
		pax.setTipoPax("ADT");
		paxes.add(pax);
		adultos++;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#createChild(int)
	 */
	@Override
	public void createChild(int edad){
		BDLPax pax=new BDLPax();
		pax.setTipoPax("NIN");
		pax.setEdad(edad);
		paxes.add(pax);
		ninos++;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#getAdultos()
	 */
	@Override
	public int getAdultos() {
		return adultos;
	}
	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#getNinos()
	 */
	@Override
	public int getNinos() {
		return ninos;
	}
	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#getPaxes()
	 */
	@Override
	public List<IBDLPax> getPaxes() {
		return paxes;
	}

	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#getRooms()
	 */
	@Override
	public List<IBDLRoom> getRooms() {
		return rooms;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#setRooms(java.util.List)
	 */
	@Override
	public void setRooms(List<IBDLRoom> listaHabitaciones) {
		this.rooms = listaHabitaciones;
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

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#getNumDistribucion()
	 */
	@Override
	public int getNumDistribucion() {
		return numDistribucion;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDistribucion#setNumDistribucion(int)
	 */
	@Override
	public void setNumDistribucion(int numDistribucion) {
		this.numDistribucion = numDistribucion;
	}

	
	
	public String getStringOcupacion() {
		String ret="";
		int ad=this.getAdultos();
		int nin=this.getNinos();
		ret+=ad + " ";
		if (ad==1){
			ret+=textosLenguas.get(1);
		}else{
			ret+=textosLenguas.get(0);
		}
		if (nin>0){
			ret+=", " + nin + " ";
			if (nin==1){
				ret+=textosLenguas.get(3);
			}else{
				ret+=textosLenguas.get(2);
			}
			ret+=" (";
			for (int p=0;p<this.getPaxes().size();p++){
				IBDLPax pax = this.getPaxes().get(p);
				if (pax.getTipoPax().equals("NIN")){
					ret+= pax.getEdad();
					if (p!=(this.getPaxes().size()-1)){
						ret+=", ";
					}
				}
			}
			ret+=" "+textosLenguas.get(4)+")";
			
		}
		return ret;
	}
	
	public ArrayList<String> getStringHabitaciones() {
		ArrayList<String> ret=new ArrayList<String>();
		
		String str;
		for (int i=0;i< this.getRooms().size();i++){
			IBDLRoom room = this.getRooms().get(i);
			str=room.getHabitacion();
			for (int r=0;r< room.getRegimenesAlimentarios().size();r++){
				str+=", " + room.getRegimenesAlimentarios().get(r).getDescripcion();
			}
			ret.add(str);
			
		}
		
		return ret;
	}
	public ArrayList<String> getStringPaxes() {
		ArrayList<String> ret=new ArrayList<String>();
		
		String str;
		for (int p=0;p< this.getPaxes().size();p++){
			IBDLPax pax = this.getPaxes().get(p);
			str=pax.getNombre() + " " + pax.getApellidos() + ", " + pax.getEdad();
			ret.add(str);
		}

		return ret;
	}

	@Override
	public String toString() {
		String ret;
		ret=this.getStringOcupacion()+"\n";
		ret+=this.getStringHabitaciones()+"\n";
		ret+=this.getStringPaxes()+"\n";
		
		return ret;
	}

	public ArrayList<String> getTextosLenguas() {
		return textosLenguas;
	}

	public void setTextosLenguas(ArrayList<String> textosLenguas) {
		this.textosLenguas = textosLenguas;
	}
	
	

	
}
