package com.photel.apps.actions.BDL;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.data.BDL.IBdlReservas;

public class 	JsonCancelaReserva extends MainAction {

	private static final long serialVersionUID = 1L;
	private String localizador;
	private String resultado;
	private String mail;
	
	@Override
	public String executeHalconAction() throws Exception {
		try{
			if(localizador.split("-").length==3){
				String idReserva = localizador.split("-")[2];
				String locataBDL=localizador.split("-")[1];
				IBdlReservas res = this.getReserva(Integer.parseInt(idReserva));
				if (!res.getBdlLocata().split("-")[1].equals(localizador.split("-")[1]) || !res.getBdlEmail().equals(mail)){
					return SUCCESS;
				}
				if (res.getBdlLocata().indexOf("CANCELLED")==-1){
				
					String idi=res.getBdlIdioma();
					
					String hotelStr=res.getBdlHotel();
					IBDLHotel pHotel=(IBDLHotel) XMLStreamUtil.xmlLoadObject(hotelStr);
					
					//pHotel = this.cancelValuation(pHotel, idi, locataBDL, Integer.parseInt(pHotel.getContratos().get(0).getCodigoOficina()));
					pHotel = this.cancelConfirm(pHotel, idi, locataBDL, Integer.parseInt(pHotel.getContratos().get(0).getCodigoOficina()));
					
					resultado=pHotel.getPurchase().getStatus();
					
					//resultado="CANCELLED";
					
					hotelStr=XMLStreamUtil.xmlSaveObject(pHotel);
					res.setBdlHotel(hotelStr);
					
					if (resultado!=null && resultado.equals("CANCELLED")){
						res.setBdlLocata(localizador+"-"+resultado);
						String voucher = this.sendCancelVoucher(this.getLocale().getLanguage(), "", Integer.parseInt(idReserva));
					}
					
					this.setReserva(res);
				}else{
					resultado="CANCELLED";
				}
				
			}
			
		}catch (Exception e){
			
			e.printStackTrace();
			StackTraceElement[] trace = e.getStackTrace();
			resultado="KO\n\n";
			resultado+=e.getClass()+": "+e.getMessage()+ "\n";
			for (int i=0; i < trace.length; i++)
				resultado+="\tat " + trace[i]+"\n";
		}
		
		ValueStack stack = ActionContext.getContext().getValueStack(); 
		stack.set("JsonCancelaReserva",this);
		
		return SUCCESS;
	}

	public String getResultado() {
		return resultado;
	}

	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	
	
	

	
}
