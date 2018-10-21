package com.photel.apps.actions.Hotelan;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.SerializableHelper;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.hotelan.client.IrqVillaAvailablePrice.IrqVillaAvailablePriceResponse;
import com.photel.hotelan.client.IrqVillaAvailablePrice.Villa;
import com.photel.interfaces.BDL244.IBDLCategoria;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPromotion;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.model.gen.sesion.ISesion;

public class Disponibilidad extends MainAction {
	
	
	private String destinos;//Menorca
	private String entrada;//20/08/2012
	private String salida;//25/08/2012
	private String habitaciones;//2
	private String adults;//2/3/...
	private String ninos;//2-6/3-5/...
	private String bebes;//2/3/...
	private String numPagina;
	private String noches;
	private IrqVillaAvailablePriceResponse dispo;
	private String zona;
	private String idioma;
	private int paso;
	private List<IBDLDistribucion> detalleDistribuciones;
	
	//Joomla vars
	private String hotelid;
	private String destinosid;
	private String ini;//=03/09/2012&
	private String fin;//=04/09/2012&
	private String hab;//=2&
	private String adul;//	4
	private String nin;
	private String adul1;//	2
	private String adul2;//	2
	private String adul3;//	2
	private String adul4;//	2
	private String bebes1;//	0
	private String bebes2;//	0
	private String bebes3;//	0
	private String bebes4;//	0
	private String nin1;//	0
	private String nin2;//	0
	private String nin3;//	0
	private String nin4;//	0
	private String nin_edad_1_1;//	0
	private String nin_edad_1_2;//	0
	private String nin_edad_1_3;//	0
	private String nin_edad_1_4;//	0
	private String nin_edad_2_1;//	0
	private String nin_edad_2_2;//	0
	private String nin_edad_2_3;//	0
	private String nin_edad_2_4;//	0
	private String nin_edad_3_1;//	0
	private String nin_edad_3_2;//	0
	private String nin_edad_3_3;//	0
	private String nin_edad_3_4;//	0
	private String nin_edad_4_1;//	0
	private String nin_edad_4_2;//	0
	private String nin_edad_4_3;//	0
	private String nin_edad_4_4;//	0
	
	private String todosLosResultados;
	private String paginas;
	private String sessionId;
	
	//filtros
	private String amountRangeInput;
	private String categoriaInput;
	private String tipoHotelInput;
	private String facilitieInput;
	private String localidadInput;
	
	private Map<String,String> facilities;
	private Map<String,String> hotelTypes;
	
	/*
	 * 
	 http://www.book-villa.com/index.php?option=com_hotelguide&view=procesoReserva&destinos=Mallorca&destinosid=P1&hotel=&hotelid=&ini=19/11/2015&noches=5&fin=24/11/2015&adul=2&nin=0&hab=1&adul1=2&bebes1=0&nin1=0&nin_edad_1_1=0&nin_edad_1_2=0&nin_edad_1_3=0&nin_edad_1_4=0&adul2=2&bebes2=0&nin2=0&nin_edad_2_1=0&nin_edad_2_2=0&nin_edad_2_3=0&nin_edad_2_4=0&adul3=2&bebes3=0&nin3=0&nin_edad_3_1=0&nin_edad_3_2=0&nin_edad_3_3=0&nin_edad_3_4=0&adul4=2&bebes4=0&nin4=0&nin_edad_4_1=0&nin_edad_4_2=0&nin_edad_4_3=0&nin_edad_4_4=0&abZonaHidden=&abEstrellasHidden=&abEscalaHidden=&abRegimenHidden=&abTipoAlojamientoHidden=&abTipoHotelHidden=&abServiciosHidden=&researchSessionId
http://localhost:8080/PCRS/apps/portvill/disponibilidad.html?option=com_hotelguide&view=procesoReserva&destinos=Mallorca&destinosid=P1&hotel=&hotelid=&ini=19/11/2015&noches=5&fin=24/11/2015&adul=2&nin=0&hab=1&adul1=2&bebes1=0&nin1=0&nin_edad_1_1=0&nin_edad_1_2=0&nin_edad_1_3=0&nin_edad_1_4=0&adul2=2&bebes2=0&nin2=0&nin_edad_2_1=0&nin_edad_2_2=0&nin_edad_2_3=0&nin_edad_2_4=0&adul3=2&bebes3=0&nin3=0&nin_edad_3_1=0&nin_edad_3_2=0&nin_edad_3_3=0&nin_edad_3_4=0&adul4=2&bebes4=0&nin4=0&nin_edad_4_1=0&nin_edad_4_2=0&nin_edad_4_3=0&nin_edad_4_4=0&abZonaHidden=&abEstrellasHidden=&abEscalaHidden=&abRegimenHidden=&abTipoAlojamientoHidden=&abTipoHotelHidden=&abServiciosHidden=&researchSessionId=&Itemid=&&request_locale=es
http://www.portvil.com/interface/xml.php?us=francisca@online4you.es&pw=bzR5b3U=&id_agencia=175&peticion=IrqRoomTypesList&le=es
http://localhost:8080/PCRS/apps/portvill/disponibilidad.html?option=com_hotelguide&view=procesoReserva&destinos=Mallorca&destinosid=P1&hotel=&hotelid=&ini=19/11/2015&noches=5&fin=24/11/2015&adul=2&nin=0&hab=1&adul1=2&bebes1=0&nin1=0&nin_edad_1_1=0&nin_edad_1_2=0&nin_edad_1_3=0&nin_edad_1_4=0&adul2=2&bebes2=0&nin2=0&nin_edad_2_1=0&nin_edad_2_2=0&nin_edad_2_3=0&nin_edad_2_4=0&adul3=2&bebes3=0&nin3=0&nin_edad_3_1=0&nin_edad_3_2=0&nin_edad_3_3=0&nin_edad_3_4=0&adul4=2&bebes4=0&nin4=0&nin_edad_4_1=0&nin_edad_4_2=0&nin_edad_4_3=0&nin_edad_4_4=0&abZonaHidden=&abEstrellasHidden=&abEscalaHidden=&abRegimenHidden=&abTipoAlojamientoHidden=&abTipoHotelHidden=&abServiciosHidden=&researchSessionId=&Itemid=&&request_locale=es

http://localhost:8080/PCRS/apps/portvill/detalleHotel.html?idHotel=292&request_locale=es
http://www.portvil.com/PCRS/apps/portvill/detalleHotel.html?idHotel=292&request_locale=es

Detalle:
http://www.portvil.com/interface/xml.php?us=francisca@online4you.es&pw=bzR5b3U=&id_agencia=175&peticion=IrqHotelDetailsList&le=es&hotelId=348&destinationId=1&zoneId=1

	 * 
	 * 
	 */

	private boolean filtrar(){
		if (amountRangeInput!=null && !amountRangeInput.equals("")){
			return true;
		}else if (categoriaInput!=null && !categoriaInput.equals("")){
			return true;
		}else if (tipoHotelInput!=null && !tipoHotelInput.equals("")){
			return true;
		}else if (facilitieInput!=null && !facilitieInput.equals("")){
			return true;
		}else if (localidadInput!=null && !localidadInput.equals("")){
			return true;
		}
		return false;
			
	}
	
	private boolean isJoomla(){
		if (hab==null){
			return false;
		}else if (hab.equals("")){
			return false;
		}else{
			return true;
		}
			
	}

	@Override
	public String executeHalconAction() throws Exception {
		todosLosResultados=todosLosResultados==null?todosLosResultados="true":todosLosResultados;
		todosLosResultados=todosLosResultados.equals("")?todosLosResultados="true":todosLosResultados;
		
		paginas=paginas==null?paginas="1":paginas;
		paginas=paginas.equals("")?paginas="1":paginas;
		
		sessionId=sessionId==null?sessionId=getRamdomString(10):sessionId;
		sessionId=sessionId.equals("")?sessionId=getRamdomString(10):sessionId;
		
		
		facilities=this.service.getFacilities(this.getLocale().getLanguage());
		hotelTypes=this.service.getHotelTypes(this.getLocale().getLanguage());
		
		boolean normalized=(destinosid!=null && entrada!=null && salida!=null && habitaciones!=null && adults!=null);
		boolean joomla=(destinosid!=null && ini!=null && fin!=null && hab!=null && adul!=null);
		if (normalized || joomla){
			paso=1;
			if (isJoomla()){
				destinosid=destinosid.substring(1,destinosid.length());
				
				entrada=ini;
				salida=fin;
				habitaciones=hab;
				//adults=2/3&ninos=2-5-6/1-4
				int habs=Integer.parseInt(hab);
				if (habs==1 && nin.equals("0")){
					adults=adul;
				}else{
					if (habs>=1 ){
						adults=adul1;
						ninos=nin1+"-"+nin_edad_1_1+"-"+nin_edad_1_2+"-"+nin_edad_1_3+"-"+nin_edad_1_4;
						bebes=bebes1;
					}
					if (habs>=2){
						adults+="/"+adul2;
						ninos+="/"+nin2+"-"+nin_edad_2_1+"-"+nin_edad_2_2+"-"+nin_edad_2_3+"-"+nin_edad_2_4;
						bebes+="/"+bebes2;
					}
					if  (habs>=3){
						adults+="/"+adul3;
						ninos+="/"+nin3+"-"+nin_edad_3_1+"-"+nin_edad_3_2+"-"+nin_edad_3_3+"-"+nin_edad_3_4;
						bebes+="/"+bebes2;
					}
					if  (habs==4){
						adults+="/"+adul4;
						ninos+="/"+nin4+"-"+nin_edad_4_1+"-"+nin_edad_4_2+"-"+nin_edad_4_3+"-"+nin_edad_4_4;
						bebes+="/"+bebes2;
					}
				}
			}
			
			
			numPagina=numPagina==null?"-1":numPagina;
			ninos=ninos==null?"":ninos;
			bebes=bebes==null?"":bebes;
			String fechaEntrada=(entrada.substring(6,10)+entrada.substring(3,5)+entrada.substring(0,2));
			String fechaSalida=(salida.substring(6,10)+salida.substring(3,5)+salida.substring(0,2));
			
			
			
			Calendar fini=getCalendar(fechaEntrada, "0000");
			Calendar ffin=getCalendar(fechaSalida, "0200"); //Si no es una hora más en cambio horario funciona mal
			
			
			noches=String.valueOf(getElapsetTimeDays(fini, ffin));
			
			List<List<String>> distribuciones=new ArrayList<List<String>>();
			List<String> roomCount=new ArrayList<String>();
			
			ArrayList<String> paxes;
			int numHabs=Integer.parseInt(habitaciones);
			String[] adultosArr = adults.split("/");
			String[] ninArr = ninos.split("/");
			String[] bebesArr = bebes.split("/");
			int numPaxes;
			
			for (int h=0;h<numHabs;h++){
				paxes = new ArrayList<String>();
				numPaxes=Integer.parseInt(adultosArr[h]);
				for (int a=0;a<numPaxes;a++){
					paxes.add("ADT#0");
				}
				if(h<=ninArr.length-1 && ninArr[h]!=null && !ninArr[h].equals("") && !ninArr[h].equals("null")){
					String[] edades = ninArr[h].split("-");
					numPaxes=Integer.parseInt(edades[0]);
					for (int n=0;n<numPaxes;n++){
						paxes.add("NIN#"+edades[n+1]);
					}
				}
				if(h<=bebesArr.length-1 && bebesArr[h]!=null && !bebesArr[h].equals("") && !bebesArr[h].equals("null")){
					numPaxes=Integer.parseInt(bebesArr[h]);
					for (int n=0;n<numPaxes;n++){
						paxes.add("NIN#0");
					}
				}
				roomCount.add("1");
				distribuciones.add(paxes);
				
			}
			
			ISesion bean = (ISesion) this.getValueFromStack("beanSesion");
			if (bean==null){
				String jsessionId=this.getCookie("JSESSIONID");
				bean=this.getGenSesion(jsessionId);
			}
			String idSession=bean.getId().split("_")[1];
			idioma=this.getLocale().getLanguage();
			
			
			String zoneId=null;
			hotelid=hotelid!=null && hotelid.equals("")?null:hotelid;
			adults=adults!=null && adults.equals("")?"0":adults;
			ninos=ninos!=null && ninos.equals("")?"0":ninos;
			bebes=bebes!=null && bebes.equals("")?"0":bebes;
			
			String key=idioma+"_"+hotelid+"_"+destinosid+"_"+zoneId+"_"+entrada+"_"+salida+"_"+noches+"_"+adults+"_"+ninos+"_"+bebes;
			
				String ninHotelan=nin1!=null?nin1:"0";
				dispo=this.getDisponibilidadHotelan(
						idioma, 
						hotelid, 
						destinosid, 
						zoneId, 
						fini, 
						Integer.parseInt(noches), 
						Integer.parseInt(adults), 
						Integer.parseInt(ninHotelan), 
						Integer.parseInt(bebes),sessionId);
			

			
			
			if (filtrar() && dispo!=null){
				if (localidadInput!=null && !localidadInput.equals("")){
					dispo=filtrarLocalidad(dispo);
				}
				if (amountRangeInput!=null && !amountRangeInput.equals("")){
					dispo=filtrarPrecios(dispo);
				}
				if (categoriaInput!=null && !categoriaInput.equals("")){
					dispo=filtrarCategoria(dispo);
				}
				if (tipoHotelInput!=null && !tipoHotelInput.equals("")){
					dispo=filtrarTipoHotel(dispo);
				}
				if (facilitieInput!=null && !facilitieInput.equals("")){
					dispo=filtrarFacility(dispo);
				}
			}
			
		}
		return SUCCESS;
	}
	private IrqVillaAvailablePriceResponse filtrarPrecios(IrqVillaAvailablePriceResponse dispo) {
		List<Villa> hoteles = dispo.getVilla();
		dispo.setVilla(new ArrayList<Villa>());
		BigDecimal precioMin=new BigDecimal(amountRangeInput.split("-")[0]);
		BigDecimal precioMax=new BigDecimal(amountRangeInput.split("-")[1]);
		for (Villa hotel:hoteles){
			if (precioMin.compareTo(hotel.getPriceBigDecimal())<0 && precioMax.compareTo(hotel.getPriceBigDecimal())>0){
				dispo.getVilla().add(hotel);
			}
		}
		return dispo;
	}
	private IrqVillaAvailablePriceResponse filtrarCategoria(IrqVillaAvailablePriceResponse dispo){
		List<Villa> hoteles = dispo.getVilla();
		dispo.setVilla(new ArrayList<Villa>());
		String str=categoriaInput.replace("_", "##");
		String[] categorias=str.split("##");
		for (Villa hotel:hoteles){
			for(String cat:categorias){
				if (hotel.getCathegoryId().equalsIgnoreCase(cat)){
					dispo.getVilla().add(hotel);
					break;
				}
			}
		}
		return dispo;
	}
	private IrqVillaAvailablePriceResponse filtrarTipoHotel(IrqVillaAvailablePriceResponse dispo){
		List<Villa> hoteles = dispo.getVilla();
		dispo.setVilla(new ArrayList<Villa>());
		String[] tipos=tipoHotelInput.split("##");
		for (Villa hotel:hoteles){
			for(String tipo:tipos){
				if (hotel.getTypeId().equalsIgnoreCase(tipo)){
					dispo.getVilla().add(hotel);
					break;
				}
			}
		}
		return dispo;
	}
	private IrqVillaAvailablePriceResponse filtrarFacility(IrqVillaAvailablePriceResponse dispo){
		List<Villa> hoteles = dispo.getVilla();
		dispo.setVilla(new ArrayList<Villa>());
		String[] facilities=facilitieInput.split("##");
		boolean added;
		for (Villa hotel:hoteles){
			if (hotel.getJoomlaFacilities()!=null){
				added=false;
				for(String fac:facilities){
					for (Entry<String, String> faci:hotel.getJoomlaFacilities().entrySet()){
						if (faci.getKey().equals(fac)){
							dispo.getVilla().add(hotel);
							added=true;
							break;
						}
						if (added){break;}
					}
				}
				if (added){break;}
			}
		}
		return dispo;
	}
	private IrqVillaAvailablePriceResponse filtrarLocalidad(IrqVillaAvailablePriceResponse dispo){
		List<Villa> hoteles = dispo.getVilla();
		dispo.setVilla(new ArrayList<Villa>());
		for (Villa hotel:hoteles){
				if (hotel.getZoneId().equalsIgnoreCase(localidadInput)){
					dispo.getVilla().add(hotel);
				}
		}
		return dispo;
	}
	
	public boolean isInStr(String value, String selected){
		if (selected!=null && !selected.equals("")){
			String[] values=selected.split("##");
			if (value!=null && !value.equals("")){
				for(int i=0;i<values.length;i++){
					if (values[i].endsWith(value)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	
	public boolean mostrarFacility(String facility){
		boolean ret=false;
		String[] facilitesToShow=this.getConfigParam("facilitesToShow").split("##");
		for (int i=0;i<facilitesToShow.length;i++){
			if (facilitesToShow[i].equals(facility.split("-")[0])){
				ret=true;
			}
		}
		
		return ret;
	}
	
	public boolean maxHoteles(int index){
		String max=this.getConfigParam("maxHotelesEnPrimeraDispo");
		int numRes=Integer.parseInt(paginas)*Integer.parseInt(max);
		if((index+1)<=numRes){
			return true;
		}else{
			if (todosLosResultados.equals("true")){
				return true;
			}else{
				return false;
			}
		}
	}
	public IBDLPromotion getPromotion(IBDLContrato contract){
		if (contract!=null){
			if (contract.getPromotions()!=null){
				for (int i=0;i<contract.getPromotions().size();i++){
					return contract.getPromotions().get(i);
				}
			}
		}
		
		return null;
	}
	
	public String nextPaginas(){
		int numRes=Integer.parseInt(paginas)+1;
		return String.valueOf(numRes);
	}
	public String filtroPrecioMin(BigDecimal d){
		if (d==null){return "0";}
		int i = d.intValue();
		String dd=String.valueOf(i).replace(",", "");
		dd=dd.replace(".","");
		return dd;
	}
	public String filtroPrecioMax(BigDecimal d){
		if (d==null){return "0";}
		d=d.add(new BigDecimal(1));
		int i = d.intValue();
		String dd=String.valueOf(i).replace(",", "");
		dd=dd.replace(".","");
		return dd;
	}
	
	public String getContratosAMostrarOcultar(IBDLHotel hotel){
		String ret="";
		for (int i=0;i<hotel.getContratos().size();i++){
			if (i>0){
				ret+=hotel.getContratos().get(i).getCodigoClasificacion()+"##";
			}
		}
		if (!ret.equals("")){
			ret=ret.substring(0,ret.length()-2);
		}
		ret=ret.replace(" ", "_");
		return ret;
	}
	public List<IBDLDistribucion> getDetalleDistribuciones() {
		return detalleDistribuciones;
	}

	public void setDetalleDistribuciones(
			List<IBDLDistribucion> detalleDistribuciones) {
		this.detalleDistribuciones = detalleDistribuciones;
	}

	public String getDestinationDescription() throws Exception{
		String ret="";
		if (this.dispo!=null && this.dispo.getVilla()!=null && this.dispo.getVilla().size()>0){
			ret=this.dispo.getVilla().get(0).getDestination();
		}
		return ret;
	}
	public String recortaDescipcion(Villa hotel){
		String ret;
		int limite;
		try{
			limite=Integer.parseInt(this.getConfigParam("limiteCaracteresDescripcionHotelesDisponibilidad"));}
		catch (Exception e){
			limite=100;}
		
		if (hotel.getDescription()!=null && hotel.getDescription().length()>limite){
			ret=hotel.getDescription().substring(0,limite);
		}else{
			ret=hotel.getDescription();
		}
		return ret;
	}
	public String getSerializedHotel(Villa hotel){
		String ret;
		ret=com.photel.commonServices.util.XMLStreamUtil.xmlSaveObject(hotel);
		return ret;
	}
	public String getRegimenValue(IBDLRegimen reg){
		String ret="";
		if (this.noches!=null){
			BigDecimal precio = reg.getPrecio();
			precio=this.getPrecioDescuento(precio);
			BigDecimal noches=new BigDecimal(Long.parseLong(this.noches));
			ret=this.twoDecimalFormat(precio)+"##";
			precio=precio.divide(noches,2, RoundingMode.HALF_UP);
			ret+=this.twoDecimalFormat(precio)+"##";
			ret+=reg.getCodigo();
		}
		return ret;
	}
	public String getRegimenValueXNoche(BigDecimal precio){
		String ret="";
		if (this.noches!=null && precio!=null){
			BigDecimal noches=new BigDecimal(Long.parseLong(this.noches));
			BigDecimal xnoche=precio.divide(noches,2, RoundingMode.HALF_UP);
			ret+=this.twoDecimalFormat(xnoche);
		}
		return ret;
	}
	public String getRegimenValueXNocheFromString(String price){
		String ret="";
		BigDecimal precio=new BigDecimal(price);
		ret=this.getRegimenValueXNoche(precio);
		return ret;
	}
	public String getDestinosid() {
		return destinosid;
	}

	public void setDestinosid(String destinosid) {
		this.destinosid = destinosid;
	}

	public String getDestinos() {
		return destinos;
	}

	public void setDestinos(String destinos) {
		this.destinos = destinos;
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

	public String getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(String habitaciones) {
		this.habitaciones = habitaciones;
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

	public String getNumPagina() {
		return numPagina;
	}

	public void setNumPagina(String numPagina) {
		this.numPagina = numPagina;
	}

	public IrqVillaAvailablePriceResponse getDispo() {
		return dispo;
	}

	public void setDispo(IrqVillaAvailablePriceResponse dispo) {
		this.dispo = dispo;
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
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getIni() {
		return ini;
	}
	public void setIni(String ini) {
		this.ini = ini;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getHab() {
		return hab;
	}
	public void setHab(String hab) {
		this.hab = hab;
	}
	public String getAdul() {
		return adul;
	}
	public void setAdul(String adul) {
		this.adul = adul;
	}
	public String getAdul1() {
		return adul1;
	}
	public void setAdul1(String adul1) {
		this.adul1 = adul1;
	}
	public String getAdul2() {
		return adul2;
	}
	public void setAdul2(String adul2) {
		this.adul2 = adul2;
	}
	public String getAdul3() {
		return adul3;
	}
	public void setAdul3(String adul3) {
		this.adul3 = adul3;
	}
	public String getAdul4() {
		return adul4;
	}
	public void setAdul4(String adul4) {
		this.adul4 = adul4;
	}
	public String getBebes1() {
		return bebes1;
	}
	public void setBebes1(String bebes1) {
		this.bebes1 = bebes1;
	}
	public String getBebes2() {
		return bebes2;
	}
	public void setBebes2(String bebes2) {
		this.bebes2 = bebes2;
	}
	public String getBebes3() {
		return bebes3;
	}
	public void setBebes3(String bebes3) {
		this.bebes3 = bebes3;
	}
	public String getBebes4() {
		return bebes4;
	}
	public void setBebes4(String bebes4) {
		this.bebes4 = bebes4;
	}
	public String getNin1() {
		return nin1;
	}
	public void setNin1(String nin1) {
		this.nin1 = nin1;
	}
	public String getNin2() {
		return nin2;
	}
	public void setNin2(String nin2) {
		this.nin2 = nin2;
	}
	public String getNin3() {
		return nin3;
	}
	public void setNin3(String nin3) {
		this.nin3 = nin3;
	}
	public String getNin4() {
		return nin4;
	}
	public void setNin4(String nin4) {
		this.nin4 = nin4;
	}
	public String getNin_edad_1_1() {
		return nin_edad_1_1;
	}
	public void setNin_edad_1_1(String nin_edad_1_1) {
		this.nin_edad_1_1 = nin_edad_1_1;
	}
	public String getNin_edad_1_2() {
		return nin_edad_1_2;
	}
	public void setNin_edad_1_2(String nin_edad_1_2) {
		this.nin_edad_1_2 = nin_edad_1_2;
	}
	public String getNin_edad_1_3() {
		return nin_edad_1_3;
	}
	public void setNin_edad_1_3(String nin_edad_1_3) {
		this.nin_edad_1_3 = nin_edad_1_3;
	}
	public String getNin_edad_1_4() {
		return nin_edad_1_4;
	}
	public void setNin_edad_1_4(String nin_edad_1_4) {
		this.nin_edad_1_4 = nin_edad_1_4;
	}
	public String getNin_edad_2_1() {
		return nin_edad_2_1;
	}
	public void setNin_edad_2_1(String nin_edad_2_1) {
		this.nin_edad_2_1 = nin_edad_2_1;
	}
	public String getNin_edad_2_2() {
		return nin_edad_2_2;
	}
	public void setNin_edad_2_2(String nin_edad_2_2) {
		this.nin_edad_2_2 = nin_edad_2_2;
	}
	public String getNin_edad_2_3() {
		return nin_edad_2_3;
	}
	public void setNin_edad_2_3(String nin_edad_2_3) {
		this.nin_edad_2_3 = nin_edad_2_3;
	}
	public String getNin_edad_2_4() {
		return nin_edad_2_4;
	}
	public void setNin_edad_2_4(String nin_edad_2_4) {
		this.nin_edad_2_4 = nin_edad_2_4;
	}
	public String getNin_edad_3_1() {
		return nin_edad_3_1;
	}
	public void setNin_edad_3_1(String nin_edad_3_1) {
		this.nin_edad_3_1 = nin_edad_3_1;
	}
	public String getNin_edad_3_2() {
		return nin_edad_3_2;
	}
	public void setNin_edad_3_2(String nin_edad_3_2) {
		this.nin_edad_3_2 = nin_edad_3_2;
	}
	public String getNin_edad_3_3() {
		return nin_edad_3_3;
	}
	public void setNin_edad_3_3(String nin_edad_3_3) {
		this.nin_edad_3_3 = nin_edad_3_3;
	}
	public String getNin_edad_3_4() {
		return nin_edad_3_4;
	}
	public void setNin_edad_3_4(String nin_edad_3_4) {
		this.nin_edad_3_4 = nin_edad_3_4;
	}
	public String getNin_edad_4_1() {
		return nin_edad_4_1;
	}
	public void setNin_edad_4_1(String nin_edad_4_1) {
		this.nin_edad_4_1 = nin_edad_4_1;
	}
	public String getNin_edad_4_2() {
		return nin_edad_4_2;
	}
	public void setNin_edad_4_2(String nin_edad_4_2) {
		this.nin_edad_4_2 = nin_edad_4_2;
	}
	public String getNin_edad_4_3() {
		return nin_edad_4_3;
	}
	public void setNin_edad_4_3(String nin_edad_4_3) {
		this.nin_edad_4_3 = nin_edad_4_3;
	}
	public String getNin_edad_4_4() {
		return nin_edad_4_4;
	}
	public void setNin_edad_4_4(String nin_edad_4_4) {
		this.nin_edad_4_4 = nin_edad_4_4;
	}

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public String getTodosLosResultados() {
		return todosLosResultados;
	}

	public void setTodosLosResultados(String todosLosResultados) {
		this.todosLosResultados = todosLosResultados;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getAmountRangeInput() {
		return amountRangeInput;
	}

	public void setAmountRangeInput(String amountRangeInput) {
		this.amountRangeInput = amountRangeInput;
	}

	public String getCategoriaInput() {
		return categoriaInput;
	}

	public void setCategoriaInput(String categoriaInput) {
		this.categoriaInput = categoriaInput;
	}

	public String getTipoHotelInput() {
		return tipoHotelInput;
	}

	public void setTipoHotelInput(String tipoHotelInput) {
		this.tipoHotelInput = tipoHotelInput;
	}

	public String getFacilitieInput() {
		return facilitieInput;
	}

	public void setFacilitieInput(String facilitieInput) {
		this.facilitieInput = facilitieInput;
	}

	public String getLocalidadInput() {
		return localidadInput;
	}

	public void setLocalidadInput(String localidadInput) {
		this.localidadInput = localidadInput;
	}

	public Map<String, String> getFacilities() {
		return facilities;
	}

	public Map<String, String> getHotelTypes() {
		return hotelTypes;
	}



	
}