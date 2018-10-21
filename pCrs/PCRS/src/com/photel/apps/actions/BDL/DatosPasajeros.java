package com.photel.apps.actions.BDL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPax;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.model.gen.sesion.ISesion;

public class DatosPasajeros extends MainAction {
	
	private String distribucionesSeleccinada;//0___APT-E10__1B-ST__SC-E10||1___APT-E10__1B-ST__SC-E10
	private String contratoSeleccinado;
	private String hotelSeleccionado;
	private IBDLHotel hotel;
	private ArrayList<String> seleccion;
	private String entrada;//20/08/2012
	private String salida;//25/08/2012
	private String noches;
	private int paso;
	private List<IBDLDistribucion> detalleDistribuciones;
	private String zona;
	private String idioma;
	//roomCode##clasification##boardCode --> STU-E10##ST##SC-E10 APT-E10##1B-C4##SC-E10

	@Override
	public String executeHalconAction() throws Exception {
		
		
		
		if (hotelSeleccionado!=null && !hotelSeleccionado.equals("")){
			paso=2;
			hotelSeleccionado=org.apache.commons.lang.StringEscapeUtils.unescapeHtml(hotelSeleccionado);
			hotel=(IBDLHotel) com.photel.commonServices.util.XMLStreamUtil.xmlLoadObject(hotelSeleccionado);
			seleccion=new ArrayList<String>();
			String[] distribuciones = distribucionesSeleccinada.split("DISTRIBUCION");
			String roomCode;
			String clasification;
			String boardCode;
			ArrayList<String> textosLenguas=new ArrayList<String>();
			textosLenguas.add(this.getText("lang.gen.glo.Adultos").equals("lang.gen.glo.Adultos")?"":this.getText("lang.gen.glo.Adultos"));
			textosLenguas.add(this.getText("lang.gen.glo.Adulto").equals("lang.gen.glo.Adulto")?this.getText("lang.gen.glo.Adultos"):this.getText("lang.gen.glo.Adulto"));
			textosLenguas.add(this.getText("lang.gen.glo.ninos").equals("lang.gen.glo.ninos")?"":this.getText("lang.gen.glo.ninos"));
			textosLenguas.add(this.getText("lang.gen.glo.nino").equals("lang.gen.glo.nino")?this.getText("lang.gen.glo.ninos"):this.getText("lang.gen.glo.nino"));
			textosLenguas.add(this.getText("lang.gen.crs.i_anyos")==null?"":this.getText("lang.gen.crs.i_anyos"));
			
			for(int i=0;i<distribuciones.length;i++){
				String[] datos = distribuciones[i].split("___")[1].split("__");
				roomCode = datos[0];
				clasification = datos[1];
				boardCode = datos[2];
				seleccion.add(roomCode+"##"+clasification+"##"+boardCode);
				getContratoSeleccionado().getDistribuciones().get(i).setTextosLenguas(textosLenguas);
			}
		}
		detalleDistribuciones=getContratoSeleccionado().getDistribuciones();
		return SUCCESS;
	}
	public String getDestinationDescription() throws Exception{
		String ret="";
		IBdlDestinations destination = this.getDestination(zona, idioma);
		ret=destination.getBdlDescription();
		return ret;
	}
	public IBDLContrato getContratoSeleccionado(){
		IBDLContrato ret=null;
		for (int i=0;i<hotel.getContratos().size();i++){
			if (contratoSeleccinado!=null && contratoSeleccinado.endsWith(hotel.getContratos().get(i).getCodigoClasificacion())){
				ret=hotel.getContratos().get(i);
				break;
			}
			
		}
		return ret;
	}
	public String getMinDateChild(int edad){
		String ret="";
		if (entrada!=null){
			String fechaEntrada=(entrada.substring(6,10)+entrada.substring(3,5)+entrada.substring(0,2));
			Calendar f=DateTimeUtil.getCalendar(fechaEntrada, "0000");
			f.add(Calendar.YEAR, -edad);
			ret=String.valueOf(f.get(Calendar.YEAR));
			String aux=String.valueOf(f.get(Calendar.MONTH)+1);;
			aux=aux.length()==1?"0"+aux:aux;
			ret+=aux;
			aux=String.valueOf(f.get(Calendar.DAY_OF_MONTH));;
			aux=aux.length()==1?"0"+aux:aux;
			ret+=aux;
		}
		return ret;
	}
	public String getMaxDateChild(int edad){
		String ret="";
		if (entrada!=null){
			String fechaEntrada=(entrada.substring(6,10)+entrada.substring(3,5)+entrada.substring(0,2));
			Calendar f=DateTimeUtil.getCalendar(fechaEntrada, "0000");
			f.add(Calendar.YEAR, -(edad-1));
			ret=String.valueOf(f.get(Calendar.YEAR));
			String aux=String.valueOf(f.get(Calendar.MONTH)+1);;
			aux=aux.length()==1?"0"+aux:aux;
			ret+=aux;
			aux=String.valueOf(f.get(Calendar.DAY_OF_MONTH));;
			aux=aux.length()==1?"0"+aux:aux;
			ret+=aux;
		}
		return ret;
	}
	public IBDLRoom getHabitacionSeleccionada(int distribucion){
		IBDLContrato con=getContratoSeleccionado();
		IBDLDistribucion distri = con.getDistribuciones().get(distribucion);
		String[] select = seleccion.get(distribucion).split("##");
		String roomCode=select[0];
		String clasification=select[1];
		String boardCode=select[2];
		IBDLRoom ret=null;
		for (int i=0;i<distri.getRooms().size();i++){
			if (roomCode!=null && roomCode.equals(distri.getRooms().get(i).getHabitacionCodigo())){
				if (clasification!=null && clasification.equals(distri.getRooms().get(i).getHabitacionCaracteristica())){
					ret=distri.getRooms().get(i);
					break;
				}
			}
		}
		return ret;
	}
	public IBDLRegimen getRegimenSeleccionado(int distribucion){
		String[] select = seleccion.get(distribucion).split("##");
		String roomCode=select[0];
		String clasification=select[1];
		String boardCode=select[2];
		IBDLRoom room=getHabitacionSeleccionada(distribucion);
		IBDLRegimen ret=null;
		for (int i=0;i<room.getRegimenesAlimentarios().size();i++){
			if (boardCode!=null && boardCode.equals(room.getRegimenesAlimentarios().get(i).getCodigo())){
				ret=room.getRegimenesAlimentarios().get(i);
				break;
			}
		}
		return ret;
	}
	public List<IBDLPax> getAdultos(int distribucion){
		List<IBDLPax> ret=getPaxes(distribucion,this.TIPO_PAX_ADULTO);
		return ret;
	}
	public List<IBDLPax> getNinos(int distribucion){
		List<IBDLPax> ret=getPaxes(distribucion,this.TIPO_PAX_NINO);
		return ret;
	}
	public List<IBDLPax> getBebes(int distribucion){
		List<IBDLPax> ret=getPaxes(distribucion,this.TIPO_PAX_BEBE);
		return ret;
	}
	public List<IBDLPax> getPaxes(int distribucion, String tipoPax){
		List<IBDLPax> ret=new ArrayList<IBDLPax>();
		IBDLContrato con=getContratoSeleccionado();
		IBDLDistribucion distri = con.getDistribuciones().get(distribucion);
		List<IBDLPax> paxes = distri.getPaxes();
		for (int i=0;i<paxes.size();i++){
			if (paxes.get(i).getTipoPax().equals(tipoPax)){
				ret.add(paxes.get(i));
			}
		}
		return ret;
		
	}
	
	public String getRandomParam(){
		String ret="";
		if (debug){
			ret=getRamdomString(5);
		}
		return ret;
	}
	public String getAdultDate(){
		String ret="";
		if (debug){
			ret="19760125";
		}
		return ret;
	}
	public String getChildDate(){
		String ret="";
		if (debug){
			ret="20080125";
		}
		return ret;
	}
	public String getEmail(){
		String ret="";
		if (debug){
			ret="a@a.es";
		}
		return ret;
	}
	public String getTlf(){
		String ret="";
		if (debug){
			ret="971414141";
		}
		return ret;
	}
	public String getNIF(){
		String ret="";
		if (debug){
			ret="11111111H";
		}
		return ret;
	}
	public IBDLHotel getHotel() {
		return hotel;
	}


	public void setHotel(IBDLHotel hotel) {
		this.hotel = hotel;
	}



	public String getDistribucionesSeleccinada() {
		return distribucionesSeleccinada;
	}



	public void setDistribucionesSeleccinada(String distribucionesSeleccinada) {
		this.distribucionesSeleccinada = distribucionesSeleccinada;
	}



	public String getContratoSeleccinado() {
		return contratoSeleccinado;
	}



	public void setContratoSeleccinado(String contratoSeleccinado) {
		this.contratoSeleccinado = contratoSeleccinado;
	}



	public String getHotelSeleccionado() {
		return hotelSeleccionado;
	}



	public void setHotelSeleccionado(String hotelSeleccionado) {
		this.hotelSeleccionado = hotelSeleccionado;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getNoches() {
		return noches;
	}

	public void setNoches(String noches) {
		this.noches = noches;
	}

	public List<IBDLDistribucion> getDetalleDistribuciones() {
		return detalleDistribuciones;
	}

	public void setDetalleDistribuciones(
			List<IBDLDistribucion> detalleDistribuciones) {
		this.detalleDistribuciones = detalleDistribuciones;
	}

	public int getPaso() {
		return paso;
	}

	public void setPaso(int paso) {
		this.paso = paso;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	


	
}
