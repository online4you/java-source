package com.photel.apps.actions.BDL;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.data.BDL.IBdlReservas;

public class 	JsonEnviaReserva extends MainAction {

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
				
				String voucher = this.reSendVoucher(this.getLocale().getLanguage(), "", Integer.parseInt(idReserva));
				resultado="ENVIADO";
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
		stack.set("JsonEnviaReserva",this);
		
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
