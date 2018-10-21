package com.photel.mail.facade;

import java.util.ArrayList;
import java.util.Hashtable;

import com.photel.interfaces.mail.IGenMailTemplates;
import com.photel.interfaces.mail.IGenMailTemplatesAtt;
import com.photel.mail.data.ddbb.HelperHibernateDDBBMail;
import com.photel.mail.helpers.MailHelper;
import com.photel.mail.helpers.TemplateHelper;



public class MailFacade {
	private HelperHibernateDDBBMail hdb= new HelperHibernateDDBBMail();
	private TemplateHelper renderer;
	private MailHelper mail;
	
	public MailFacade(String SMTPHost,String port,String usuario, String password, String from) {
		super();
		this.hdb = new HelperHibernateDDBBMail();
		this.renderer=new TemplateHelper();
		this.mail=new MailHelper(SMTPHost,port, usuario,password,from);

	}
	
	public void closeSession() {
		hdb.closeSession();
	}

	public IGenMailTemplates getTemplates(String title,String lang) {
		return hdb.getTemplates(title,lang);
	}
	public String renderTemplate(String template, String lang, Hashtable<String,Object> att){
		IGenMailTemplates temp = getTemplates(template, lang);
		String ret=renderer.generate(temp.getGmtTemplate(), att);
		return ret;
	}

	public boolean send(String images, String asuntoMensaje, String cuerpoMensaje,String destinoMensaje,String destinoMensajeCC,String destinoMensajeCCO, String from,ArrayList<IGenMailTemplatesAtt> attachList){
		
		return mail.sendImagesEmbebed(images,asuntoMensaje, cuerpoMensaje,destinoMensaje,destinoMensajeCC,destinoMensajeCCO, from,attachList);
	}
	
	public String sendTemplate(String images,String template, String lang, Hashtable<String,Object> att,String asuntoMensaje, String destinoMensaje,String destinoMensajeCC,String destinoMensajeCCO, String from){
		String htmlMail = renderTemplate(template,lang,att);
		ArrayList<IGenMailTemplatesAtt> attachList = getTemplatesAttachements(template,lang);
		boolean ret=send(images,asuntoMensaje,htmlMail,destinoMensaje, destinoMensajeCC, destinoMensajeCCO,from,attachList);
		if (ret){
			return htmlMail;
		}else{
			return null;
		}
	}

	public ArrayList<IGenMailTemplatesAtt> getTemplatesAttachements(
			String title, String lang) {
		return hdb.getTemplatesAttachements(title, lang);
	}

	public void clearSession() {
		hdb.clearSession();
	}

 	
}
