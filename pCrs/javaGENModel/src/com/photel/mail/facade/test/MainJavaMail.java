package com.photel.mail.facade.test;

import java.util.Hashtable;

import com.photel.interfaces.mail.IGenMailTemplates;
import com.photel.mail.facade.MailFacade;


public class MainJavaMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MailFacade model = new MailFacade("217.76.146.62","25","adr874c","Javier69","reservas@online4you.es");
		//IGenMailTemplates temp = model.getTemplates("voucherTrenes","es");
		User[] users = new User[] {
				new User("Boris", "234234234123","1"),
				new User("Natasha", "jsdfklasdj","2"),
				new User("Jorge", "klasdjfklasdajf","3"),
				new User("Vladimir", "jklasdfklasdj","4") };
		Billetes [] billetes = new Billetes[] {
				new Billetes("1", "20"),
				new Billetes("2", "30"),
				new Billetes("3", "40"),
				new Billetes("4", "50") };
		
		
		
		Hashtable<String,Object> att=new Hashtable<String,Object>();
		att.put("nombreCliente","Willy");
		att.put("localizador","23455668567sdhfghfasd");
		att.put("emailCliente","a@a.es");
		att.put("tlfCliente","569389");
		att.put("salidaIda","dia 1");
		att.put("llegadaIda","dia 2");
		att.put("salidaVuelta","dia 3");
		att.put("llegadaVuelta","dia 4");
		att.put("total","230");
		
		
		String ret = model.renderTemplate("voucherTPV","any", att);
		String ret2 = model.renderTemplate("voucherTPV","any", att);
		String cabecera="C:\\Dev\\workspaces\\halconApp\\DES\\99999_javaMail\\src\\com/globalia/mail/facade/test/cabecera-mail.jpg";
		//cabecera+=";C:\\Dev\\workspaces\\halconApp\\DES\\99999_javaMail\\src\\mailConfig.properties";
		cabecera=null;
		//model.send("Reservado!!!", ret, "guillermo.puigros@globalia-sistemas.com;guillempuigros@gmail.com", "reservas.web@halconviajes.com");
		String result = model.sendTemplate(cabecera,"voucherTPV","any", att,"Reservado!!!", "guillempuigros@gmail.com",null,"guillermo.puigros@globalia-sistemas.com", "reservas@online4you.es");
		
		//System.out.println(ret);
	}

}
