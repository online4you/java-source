package com.photel.apps.actions.Hotelan;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.SerializableHelper;
import com.photel.commonServices.util.SystemHelper;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.hotelan.client.IrqVillaAvailablePrice.Villa;
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
	
	private String hotelSeleccionado;
	private Villa hotel;
	private ArrayList<String> seleccion;
	private String entrada;//20/08/2012
	private String salida;//25/08/2012
	private String noches;
	private int paso;
	private String zona;
	private String idioma;
	private String adults;//2/3/...
	private String ninos;//2-6/3-5/...
	private String bebes;//2/3/...
	//roomCode##clasification##boardCode --> STU-E10##ST##SC-E10 APT-E10##1B-C4##SC-E10

	@Override
	public String executeHalconAction() throws Exception {
		
		
		
		if (hotelSeleccionado!=null && !hotelSeleccionado.equals("")){
			paso=2;
			String hotelSel=hotelSeleccionado;
			hotelSeleccionado=org.apache.commons.lang.StringEscapeUtils.unescapeHtml(hotelSeleccionado);
			hotel=(Villa) com.photel.commonServices.util.XMLStreamUtil.xmlLoadObject(hotelSeleccionado);
			//Villa hotel2 = (Villa) SerializableHelper.clone(hotel);
			//hotel2.setJoomlaDescription(null);
			//hotelSeleccionado=hotelSel;
			seleccion=new ArrayList<String>();
			ArrayList<String> textosLenguas=new ArrayList<String>();
			textosLenguas.add(this.getText("lang.gen.glo.Adultos").equals("lang.gen.glo.Adultos")?"":this.getText("lang.gen.glo.Adultos"));
			textosLenguas.add(this.getText("lang.gen.glo.Adulto").equals("lang.gen.glo.Adulto")?this.getText("lang.gen.glo.Adultos"):this.getText("lang.gen.glo.Adulto"));
			textosLenguas.add(this.getText("lang.gen.glo.ninos").equals("lang.gen.glo.ninos")?"":this.getText("lang.gen.glo.ninos"));
			textosLenguas.add(this.getText("lang.gen.glo.nino").equals("lang.gen.glo.nino")?this.getText("lang.gen.glo.ninos"):this.getText("lang.gen.glo.nino"));
			textosLenguas.add(this.getText("lang.gen.crs.i_anyos")==null?"":this.getText("lang.gen.crs.i_anyos"));
			
		}
		return SUCCESS;
	}
	public String getSerializedHotel(Villa hotel){
		String ret;
		ret=com.photel.commonServices.util.XMLStreamUtil.xmlSaveObject(hotel);
		return ret;
	}
	public BigDecimal getGastosCancelacion() throws ParseException{
		BigDecimal ret=hotel.getPricePrepago();
		Calendar fini=SystemHelper.getCalendarFromDDMMYYYY(entrada);
		Calendar now=new GregorianCalendar();
		now.add(Calendar.MONTH, 1);
		if (now.after(fini)){
			ret=hotel.getPriceBigDecimal();
		}
		return ret;
	}
	public Calendar getFechaGastos() throws ParseException{
		Calendar fini=SystemHelper.getCalendarFromDDMMYYYY(entrada);
		Calendar now=new GregorianCalendar();
		Calendar ret;
		now.add(Calendar.MONTH, 1);
		if (now.after(fini)){
			ret=new GregorianCalendar();
		}else{
			fini.add(Calendar.MONTH, -1);
			ret=fini;
		}
		return ret;
	}
	public boolean aPagarDesde() throws ParseException{
		if(getGastosCancelacion().equals(hotel.getPriceBigDecimal())){
			return false;
		}
		return true;
	}
	public String getDestinationDescription() throws Exception{
		String ret="";
		ret=hotel.getDestination();
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
	public Villa getHotel() {
		return hotel;
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
	public String getDestinos() {
		return hotel.getDestination();
	}
	public String getAdults() {
		return adults;
	}
	public void setAdults(String adults) {
		this.adults = adults;
	}
	public String getNinos() {
		return ninos;
	}
	public void setNinos(String ninos) {
		this.ninos = ninos;
	}
	public String getBebes() {
		return bebes;
	}
	public void setBebes(String bebes) {
		this.bebes = bebes;
	}
	
	


	
}
