package com.photel.apps.actions.Hotelan;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;

import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.SystemHelper;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.data.hotelan.ddbb.hibernate.pojo.HibernateReservas;
import com.photel.hotelan.client.IrqVillaAvailablePrice.Villa;
import com.photel.hotelan.client.IrqVillaPreReservation.IrqVillaPreReservationResponse;
import com.photel.interfaces.BDL244.IBDLCancelationPrice;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPax;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlReservas;
import com.photel.interfaces.model.gen.sesion.ISesion;

public class Pago extends MainAction {
	private String hotelSeleccionado;
	private Villa hotel;
	
	private String idReserva;
	private String urlOk;
	private String urlKo;
	private String merchantID;
	private String acquirerBIN;
	private String terminalID;
	private String clave;
	private String cifrado;
	private String cadenaEncriptada;
	private String urlCeca;
	private String tipoMoneda;
	private String exponente;
	private String pagoSoportado;
	private String idiceca;
	private String importe;
	private String debugInfo;
	private String resultado;
	
	
	private String entrada;//20/08/2012
	private String salida;//25/08/2012
	private String noches;
	private String adults;//2/3/...
	private String ninos;//2-6/3-5/...
	private String bebes;//2/3/...
	
	private String ape;
	private String nom;
	private String tipoDocu;
	private String tipoDocuId;
	private String documento;
	private String tel;
	private String email;
	private String coments;
	private String paxes;
	private String checkFactura;
	private String factNombre;
	private String factCifNif;
	private String factCP;
	private String factDir;
	private String factLoc;
	private String factPais;
	private String factEmail;
	private String checkPersonaContacto;
	private String apeContact;
	private String nomContact;
	private String telContact;
	private String deseoRecibirOfertas;
	private String informacion;
	private String acepto;
	private String typeOfPaymentID;
	private BigDecimal toPayBefore;
	
	//http://82.223.216.227:8080/PCRS/apps/portvill/disponibilidad.html?option=com_hotelguide&view=procesoReserva&destinos=Mallorca&destinosid=P1&hotel=&hotelid=&ini=05/12/2016&noches=5&fin=10/12/2016&adul=2&nin=2&hab=1&adul1=2&bebes1=1&nin1=1&nin_edad_1_1=12&nin_edad_1_2=0&nin_edad_1_3=0&nin_edad_1_4=0&nin_edad_1_5=0&nin_edad_1_6=0&nin_edad_1_7=0&nin_edad_1_8=0&nin_edad_1_9=0&abZonaHidden=&abEstrellasHidden=&abEscalaHidden=&abRegimenHidden=&abTipoAlojamientoHidden=&abTipoHotelHidden=&abServiciosHidden=&researchSessionId=&Itemid=&&request_locale=es

	@Override
	public String executeHalconAction() throws Exception {
		try{
			//hotelSeleccionado=org.apache.commons.lang.StringEscapeUtils.unescapeHtml(hotelSeleccionado);
			//hotelSeleccionado=this.service.decodeHTML(hotelSeleccionado);
			hotel=(Villa) com.photel.commonServices.util.XMLStreamUtil.xmlLoadObject(hotelSeleccionado);
			HibernateReservas res = this.setReservaHotelan();
			debugInfo=debugInfo==null?"":debugInfo;
			debugInfo=debugInfo.equals("")?"false":debugInfo;
			res.setHlHotelType(hotel.getType());
			res.setHlHotelRoom(hotel.getRoom());
			try {res.setHlAdults(Integer.parseInt(adults));} catch (Exception e) {res.setHlAdults(0);}
			try {res.setHlChilds(Integer.parseInt(ninos));} catch (Exception e) {res.setHlChilds(0);}
			try {res.setHlInfants(Integer.parseInt(bebes));} catch (Exception e) {res.setHlInfants(0);}
			res.setHlPaxes(getPaxesString(adults,ninos,bebes));
			res.setHLBoard(hotel.getBoard());
			IrqVillaPreReservationResponse pres = this.service.getIrqVillaPreReservation(
					this.getLocale().getLanguage(), 
					hotel.getId(), 
					SystemHelper.getCalendarFromDDMMYYYY(entrada), 
					noches, 
					hotel.getRoomId(), 
					hotel.getBoardId(), 
					adults, 
					ninos, 
					bebes, 
					nom, 
					null, 
					null, 
					null, 
					null, 
					null, 
					null, 
					null, 
					null, 
					null, 
					coments);
			if (pres!=null && pres.getReserve()!=null && pres.getReserve().getId()!=null && !pres.getReserve().getId().equals("")){
				res.setHlLocata("P-"+pres.getReserve().getId());
				res.setHlCs(pres.getReserve().getCs());
				this.service.setReservaHotelan(res);
				idReserva=pres.getReserve().getId();
				//this.service.getIrqVillaConfirmReservation(pres.getReserve().getId(), pres.getReserve().getCs());
			}else{
				throw new Exception("Sin localizador del proveedor");
			}

			this.service.setReservaHotelan(res);
			
			
			//String config="http://www.online4you.es##/apps/bdl/operacionOK.html##/apps/bdl/operacionKO.html##079205084##0000554041##00000006##GQCVSPIX##SHA1##978##2##SSL##https://pgw.ceca.es/cgi-bin/tpv";
			String config=this.getConfigParam("datosTerminalTPV_PRO_PortVill");
			
			String[] datosTPV=config.split("##");
			
			urlOk=datosTPV[0]+this.getContextPath()+datosTPV[1]+"?idReserva="+res.getHlLocata()+"&request_locale="+this.getLocale().getLanguage();
			urlKo=datosTPV[0]+this.getContextPath()+datosTPV[2]+"?idReserva="+res.getHlLocata()+"&request_locale="+this.getLocale().getLanguage();
			merchantID=datosTPV[3];
			acquirerBIN=datosTPV[4];
			terminalID=datosTPV[5];
			clave=datosTPV[6];
			cifrado=datosTPV[7];
			tipoMoneda=datosTPV[8];
			exponente=datosTPV[9];
			pagoSoportado=datosTPV[10];
			//urlCeca="https://pgw.ceca.es/cgi-bin/tpv"; //PRO
			//urlCeca="http://tpv.ceca.es:8000/cgi-bin/tpv"; //PRE
			urlCeca=datosTPV[11];
			
			String lang=this.getLocale().getLanguage();
			idiceca="1";	
			idiceca=lang.equals("es")?"1":idiceca;
			idiceca=lang.equals("en")?"6":idiceca;
			idiceca=lang.equals("de")?"8":idiceca;
			idiceca=lang.equals("it")?"10":idiceca;
			idiceca=lang.equals("fr")?"7":idiceca;
			
			Double toPay = res.getHlImportePagado();
			String intToPay=twoDecimalFormat(toPay);
			intToPay=intToPay.replace(".", "");
			intToPay=intToPay.replace(",", "");
			importe=String.valueOf(intToPay);
			
			idReserva="P-"+idReserva;
			String toEncrypt=clave + merchantID + acquirerBIN + terminalID + idReserva + importe + tipoMoneda + exponente + cifrado + urlOk + urlKo;
			//DigestUtils.shaHex("El coche amarillo");
			//968be676ad7988e8d911fce686da3fececbb22eb
			cadenaEncriptada=DigestUtils.shaHex(toEncrypt);
		}catch (Exception e){
			
			e.printStackTrace();
			StackTraceElement[] trace = e.getStackTrace();
			resultado="KO\n\n";
			resultado+=e.getClass()+": "+e.getMessage()+ "\n";
			for (int i=0; i < trace.length; i++)
				resultado+="\tat " + trace[i]+"\n";
		}
		return SUCCESS;
	}

	public HibernateReservas setReservaHotelan() throws Exception{
		HibernateReservas res = this.service.getReservaHotelan(0);
		this.service.setReservaHotelan(res);
		idReserva=String.valueOf(res.getId());
		String hotelBloqueadoStr = XMLStreamUtil.xmlSaveObject(hotel);
		res.setHlHotel(hotelBloqueadoStr);
		
		
		res.setHlAgComission(hotel.getPricePrepago().doubleValue());
		res.setHlApellidos(ape);
		res.setHlCheckAceptoCondidiones(informacion);
		res.setHlCheckAceptoPolitica(acepto);
		res.setHlCheckContacto(checkPersonaContacto);
		res.setHlCheckFactura(checkFactura);
		res.setHlCheckRecibirOfertas(deseoRecibirOfertas);
		res.setHlComentarios(coments);
		res.setHlComissionVat(hotel.getComision().doubleValue());
		res.setHlContactoApellidos(apeContact);
		res.setHlContactoNombre(nomContact);
		res.setHlContactoTelefono(telContact);
		res.setHlDocumento(documento);
		res.setHlEmail(email);
		res.setHlEntrada(SystemHelper.getCalendarFromDDMMYYYY(entrada).getTime());
		res.setHlSalida(SystemHelper.getCalendarFromDDMMYYYY(salida).getTime());
		res.setHlFacturaCp(factCP);
		res.setHlFacturaDireccion(factDir);
		res.setHlFacturaDocumento(factCifNif);
		res.setHlFacturaEmail(factEmail);
		res.setHlFacturaLocalidad(factLoc);
		res.setHlFacturaPais(factPais);
		res.setHlFacturaNombre(factNombre);
		//GregorianCalendar fechaMasCercana = getPrimeraFechaCancelacion(hotelBloqueado);
		//BigDecimal gastos=getGastosTotalesCancelacion(hotelBloqueado);
		res.setHlFechaGastos(getFechaGastos().getTime());
		res.setHlGastos(getGastosCancelacion().doubleValue());
		res.setHlHotel(hotelBloqueadoStr);
		res.setHlIdHotel(hotel.getId());
		res.setHlIdioma(this.getLocale().getLanguage());
		
		res.setHlImportePagado(getGastosCancelacion().doubleValue());
		res.setHlImporteTotal(hotel.getPriceBigDecimal().doubleValue());
		res.setHlDescuento(descuento);
		
		
		res.setHlNoches(Integer.parseInt(noches));
		res.setHlNombre(nom);
		res.setHlNombreHotel(hotel.getName());
		res.setHlPaxes(null);
		res.setHlRadioTipoPago(typeOfPaymentID);
		res.setHlReservaConfirmada("0");
		res.setHlTelefono(tel);
		res.setHlTipoDocumento(tipoDocu);
		res.setHlTipoDocumentoId(tipoDocuId);
		res.setHlUrl(this.getParametrosPeticion().get("urlFrom"));
		res.setHlZona(hotel.getZone());
				
		return this.service.setReservaHotelan(res);
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
	
	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}


	public String getUrlOk() {
		return urlOk;
	}


	public void setUrlOk(String urlOk) {
		this.urlOk = urlOk;
	}


	public String getUrlKo() {
		return urlKo;
	}


	public void setUrlKo(String urlKo) {
		this.urlKo = urlKo;
	}


	public String getMerchantID() {
		return merchantID;
	}


	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}


	public String getAcquirerBIN() {
		return acquirerBIN;
	}


	public void setAcquirerBIN(String acquirerBIN) {
		this.acquirerBIN = acquirerBIN;
	}


	public String getTerminalID() {
		return terminalID;
	}


	public void setTerminalID(String terminalID) {
		this.terminalID = terminalID;
	}


	public String getCifrado() {
		return cifrado;
	}


	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}


	public String getTipoMoneda() {
		return tipoMoneda;
	}


	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}


	public String getExponente() {
		return exponente;
	}


	public void setExponente(String exponente) {
		this.exponente = exponente;
	}


	public String getPagoSoportado() {
		return pagoSoportado;
	}


	public void setPagoSoportado(String pagoSoportado) {
		this.pagoSoportado = pagoSoportado;
	}


	public String getIdiceca() {
		return idiceca;
	}


	public void setIdiceca(String idiceca) {
		this.idiceca = idiceca;
	}




	public String getImporte() {
		return importe;
	}


	public void setImporte(String importe) {
		this.importe = importe;
	}


	public String getCadenaEncriptada() {
		return cadenaEncriptada;
	}


	public void setCadenaEncriptada(String cadenaEncriptada) {
		this.cadenaEncriptada = cadenaEncriptada;
	}


	public String getUrlCeca() {
		return urlCeca;
	}


	public void setUrlCeca(String urlCeca) {
		this.urlCeca = urlCeca;
	}


	public String getDebugInfo() {
		return debugInfo;
	}


	public void setDebugInfo(String debugInfo) {
		this.debugInfo = debugInfo;
	}


	public String getHotelSeleccionado() {
		return hotelSeleccionado;
	}


	public void setHotelSeleccionado(String hotelSeleccionado) {
		this.hotelSeleccionado = hotelSeleccionado;
	}


	public Villa getHotel() {
		return hotel;
	}


	public void setHotel(Villa hotel) {
		this.hotel = hotel;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
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


	public String getApe() {
		return ape;
	}


	public void setApe(String ape) {
		this.ape = ape;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getTipoDocu() {
		return tipoDocu;
	}


	public void setTipoDocu(String tipoDocu) {
		this.tipoDocu = tipoDocu;
	}


	public String getTipoDocuId() {
		return tipoDocuId;
	}


	public void setTipoDocuId(String tipoDocuId) {
		this.tipoDocuId = tipoDocuId;
	}


	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getComents() {
		return coments;
	}


	public void setComents(String coments) {
		this.coments = coments;
	}


	public String getPaxes() {
		return paxes;
	}


	public void setPaxes(String paxes) {
		this.paxes = paxes;
	}


	public String getCheckFactura() {
		return checkFactura;
	}


	public void setCheckFactura(String checkFactura) {
		this.checkFactura = checkFactura;
	}


	public String getFactNombre() {
		return factNombre;
	}


	public void setFactNombre(String factNombre) {
		this.factNombre = factNombre;
	}


	public String getFactCifNif() {
		return factCifNif;
	}


	public void setFactCifNif(String factCifNif) {
		this.factCifNif = factCifNif;
	}


	public String getFactCP() {
		return factCP;
	}


	public void setFactCP(String factCP) {
		this.factCP = factCP;
	}


	public String getFactDir() {
		return factDir;
	}


	public void setFactDir(String factDir) {
		this.factDir = factDir;
	}


	public String getFactLoc() {
		return factLoc;
	}


	public void setFactLoc(String factLoc) {
		this.factLoc = factLoc;
	}


	public String getFactPais() {
		return factPais;
	}


	public void setFactPais(String factPais) {
		this.factPais = factPais;
	}


	public String getFactEmail() {
		return factEmail;
	}


	public void setFactEmail(String factEmail) {
		this.factEmail = factEmail;
	}


	public String getCheckPersonaContacto() {
		return checkPersonaContacto;
	}


	public void setCheckPersonaContacto(String checkPersonaContacto) {
		this.checkPersonaContacto = checkPersonaContacto;
	}


	public String getApeContact() {
		return apeContact;
	}


	public void setApeContact(String apeContact) {
		this.apeContact = apeContact;
	}


	public String getNomContact() {
		return nomContact;
	}


	public void setNomContact(String nomContact) {
		this.nomContact = nomContact;
	}


	public String getTelContact() {
		return telContact;
	}


	public void setTelContact(String telContact) {
		this.telContact = telContact;
	}


	public String getDeseoRecibirOfertas() {
		return deseoRecibirOfertas;
	}


	public void setDeseoRecibirOfertas(String deseoRecibirOfertas) {
		this.deseoRecibirOfertas = deseoRecibirOfertas;
	}


	public String getInformacion() {
		return informacion;
	}


	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}


	public String getAcepto() {
		return acepto;
	}


	public void setAcepto(String acepto) {
		this.acepto = acepto;
	}


	public String getTypeOfPaymentID() {
		return typeOfPaymentID;
	}


	public void setTypeOfPaymentID(String typeOfPaymentID) {
		this.typeOfPaymentID = typeOfPaymentID;
	}


	public BigDecimal getToPayBefore() {
		return toPayBefore;
	}


	public void setToPayBefore(BigDecimal toPayBefore) {
		this.toPayBefore = toPayBefore;
	}






	
	
	

	
}