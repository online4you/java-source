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

public class PagoTransfer extends MainAction {
	private static final String OK_PATERN="$*$OKY$*$";
	
	private String hotelSeleccionado;
	private Villa hotel;
	private String resultado;
	private String voucher;
	
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
	private String idReserva;
	private BigDecimal toPayBefore;
	
	
	@Override
	public String executeHalconAction() throws Exception {
		resultado=OK_PATERN;
		try{
			//hotelSeleccionado=org.apache.commons.lang.StringEscapeUtils.unescapeHtml(hotelSeleccionado);
			//hotelSeleccionado=this.service.decodeHTML(hotelSeleccionado);
			hotel=(Villa) com.photel.commonServices.util.XMLStreamUtil.xmlLoadObject(hotelSeleccionado);
			HibernateReservas res = this.setReservaHotelan();
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
				String confirm=this.getConfigParam("confirmacionTransferPortVill");
				if (confirm!=null && confirm.equalsIgnoreCase("S")){
					this.service.getIrqVillaConfirmReservation(pres.getReserve().getId(), pres.getReserve().getCs());
				}
			}else{
				throw new Exception("Sin localizador del proveedor");
			}
			
			//res.setHlLocata("P-123456");
			//res.setHlCs("adsfadsfasdf");
			
			this.service.setReservaHotelan(res);
			
			
			voucher=this.service.sendVoucherHotelan(this.getLocale().getLanguage(), "", res.getHlLocata());
			
			
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
	public boolean isOperationOK(){
		return resultado.equals(OK_PATERN);
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

public String getResultado() {
	return resultado;
}

public void setResultado(String resultado) {
	this.resultado = resultado;
}

public String getVoucher() {
	return voucher;
}

public void setVoucher(String voucher) {
	this.voucher = voucher;
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

public String getIdReserva() {
	return idReserva;
}

public void setIdReserva(String idReserva) {
	this.idReserva = idReserva;
}

public BigDecimal getToPayBefore() {
	return toPayBefore;
}

public void setToPayBefore(BigDecimal toPayBefore) {
	this.toPayBefore = toPayBefore;
}


}