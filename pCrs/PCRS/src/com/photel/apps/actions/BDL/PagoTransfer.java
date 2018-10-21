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

public class PagoTransfer extends MainAction {
	private static final String OK_PATERN="$*$OKY$*$";
	
	private String idReserva;
	private IBDLHotel hotel;
	private String resultado;
	private String voucher;
	
	@Override
	public String executeHalconAction() throws Exception {
		resultado=OK_PATERN;
		try{
			IBdlReservas res = this.getReserva(Integer.parseInt(idReserva));
			
			String idi=res.getBdlIdioma();
			
			String hotelStr=res.getBdlHotel();
			IBDLHotel pHotel=(IBDLHotel) XMLStreamUtil.xmlLoadObject(hotelStr);
			
			
			String paxes = res.getBdlPaxes();
			List<List<String>> distribuciones=(List<List<String>>) XMLStreamUtil.xmlLoadObject(paxes);
			
			
			pHotel=this.confirmarReserva(idi, idReserva, distribuciones, pHotel);
			if (pHotel.getPurchase().getLocalizador()!=null){
				if(pHotel.getPurchase().getLocalizador().indexOf("B-")==-1){
					pHotel.getPurchase().setLocalizador("B-"+pHotel.getPurchase().getLocalizador());
				}
			}else{
				hotelStr=XMLStreamUtil.xmlSaveObject(pHotel);
				res.setBdlHotel(hotelStr);
				this.setReserva(res);
				throw new Exception("Sin localizador del proveedor");
			}
			
			
			hotelStr=XMLStreamUtil.xmlSaveObject(pHotel);
			res.setBdlHotel(hotelStr);
			res.setBdlLocata(pHotel.getPurchase().getLocalizador());
			/*
			res.setBdlReservaConfirmada("1");
			IBdlReservas reser2 = this.getUltimaFactura();
			if (res.getBdlCheckFactura().equals("1")){
				int num=0;
				if (reser2!=null){
					num = reser2.getBdlFacturaNumero();
				}
				num=num+1;
				res.setBdlFacturaNumero(num);	
			}
			*/
			
			
			this.setReserva(res);
			
			//guillempuigros@gmail.com
			String idioma=this.getConfigParam(idi);
			voucher=this.sendVoucher(idioma, "", Integer.parseInt(idReserva));
			
			
			
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
	
	
	

	
}