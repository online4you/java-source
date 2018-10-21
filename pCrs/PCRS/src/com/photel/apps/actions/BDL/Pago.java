package com.photel.apps.actions.BDL;

import org.apache.commons.codec.digest.DigestUtils;

import com.photel.apps.actions.MainAction;
import com.photel.interfaces.data.BDL.IBdlReservas;

public class Pago extends MainAction {
	
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
	
	@Override
	public String executeHalconAction() throws Exception {
		debugInfo=debugInfo==null?"":debugInfo;
		debugInfo=debugInfo.equals("")?"false":debugInfo;
		
		
		//String config="http://www.online4you.es##/apps/bdl/operacionOK.html##/apps/bdl/operacionKO.html##079205084##0000554041##00000006##GQCVSPIX##SHA1##978##2##SSL##https://pgw.ceca.es/cgi-bin/tpv";
		String config=this.getConfigParam("datosTerminalTPV_PRO");
		
		String[] datosTPV=config.split("##");
		
		urlOk=datosTPV[0]+this.getContextPath()+datosTPV[1]+"?idReserva="+idReserva+"&request_locale="+this.getLocale().getLanguage();
		urlKo=datosTPV[0]+this.getContextPath()+datosTPV[2]+"?idReserva="+idReserva+"&request_locale="+this.getLocale().getLanguage();
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
		
		IBdlReservas res = this.getReserva(Integer.parseInt(idReserva));
		Double toPay = res.getBdlImportePagado();
		String intToPay=twoDecimalFormat(toPay);
		intToPay=intToPay.replace(".", "");
		intToPay=intToPay.replace(",", "");
		importe=String.valueOf(intToPay);
		
		idReserva="B-"+idReserva;
		String toEncrypt=clave + merchantID + acquirerBIN + terminalID + idReserva + importe + tipoMoneda + exponente + cifrado + urlOk + urlKo;
		//DigestUtils.shaHex("El coche amarillo");
		//968be676ad7988e8d911fce686da3fececbb22eb
		cadenaEncriptada=DigestUtils.shaHex(toEncrypt);
		
		return SUCCESS;
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

	
}