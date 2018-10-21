package com.photel.apps.actions.BDL;

import java.math.BigDecimal;
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
import com.photel.commonServices.util.XMLStreamUtil;
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

public class CancelaIprimeEnvia extends MainAction {
	private static final String OK_PATERN="$*$OKY$*$";
	
	private String idReserva;
	private String localizador;
	private String mail;
	private IBDLHotel hotel;
	private String resultado;
	private String voucher;
	private boolean gastos;
	
	@Override
	public String executeHalconAction() throws Exception {
		resultado=OK_PATERN;
		//localizador="B-1067872-98";
		voucher="";
		try{
			if(localizador.split("-").length==3){
				idReserva=localizador.split("-")[2];
				IBdlReservas res = this.getReserva(Integer.parseInt(idReserva));
				if (!res.getBdlLocata().split("-")[1].equals(localizador.split("-")[1]) || !res.getBdlEmail().equals(mail)){
					return SUCCESS;
				}
				String idi=res.getBdlIdioma();
				
				String hotelStr=res.getBdlHotel();
				IBDLHotel pHotel=(IBDLHotel) XMLStreamUtil.xmlLoadObject(hotelStr);
				
				
				
				
				boolean noReembolsable=false;
				String tarifasNoReembolsables=this.getConfigParam("tarifasNoReembolsables");
				String[] tNOR=tarifasNoReembolsables.split("##");
				for (int i=0;i<tNOR.length;i++){
					if (pHotel.getContratos().get(0).getCodigoClasificacion().equals(tNOR[i])){
						noReembolsable=true;
						break;
					}
				}
				
				
				GregorianCalendar now=new GregorianCalendar();
				GregorianCalendar fechaMasCercana=getPrimeraFechaCancelacion(pHotel);
				long elapsed=DateTimeUtil.getElapsetTime(now, fechaMasCercana);
				long diffDays = elapsed / (24 * 60 * 60 * 1000); 
				long tiempoMinutosDeSessionBDL=Long.parseLong(this.getConfigParam("diasMinimosDeAntelacionGastosParaTransferencia"));
				gastos=false;
				if (diffDays<tiempoMinutosDeSessionBDL || noReembolsable) {
					gastos=true;
				}
				
				//this.setReserva(res);
				
				//guillempuigros@gmail.com
				
				voucher=this.getVoucher(this.getLocale().getLanguage(), "", Integer.parseInt(idReserva));
			}
			
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


	public String getResultado() {
		return resultado;
	}


	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	public String getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}


	public IBDLHotel getHotel() {
		return hotel;
	}


	public void setHotel(IBDLHotel hotel) {
		this.hotel = hotel;
	}


	public String getVoucher() {
		return voucher;
	}


	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}


	public String getLocalizador() {
		return localizador;
	}


	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}


	public boolean isGastos() {
		return gastos;
	}


	public void setGastos(boolean gastos) {
		this.gastos = gastos;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	

	
}
