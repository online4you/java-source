package com.photel.model.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.photel.interfaces.data.gen.IGenBanners01;
import com.photel.interfaces.data.gen.IGenCache;
import com.photel.interfaces.data.gen.IGenConfig;
import com.photel.interfaces.data.gen.IGenLanResource;
import com.photel.interfaces.data.gen.IGenTrackingLevel;
import com.photel.interfaces.data.gen.IMenu;
import com.photel.interfaces.model.gen.sesion.ISesion;
import com.photel.model.gen.facade.ModelGenFacade;
import com.photel.model.gen.helpers.LDAPFactory;



public class MainGen {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */

	
	public static void main(String[] args) {
		Hashtable params=new Hashtable();

		ModelGenFacade model;
		try {
			params.put("WS_RENFE_ENDPOINT", "PRO");
			params.put("site", "PRO");
			model = new ModelGenFacade("OL4U");
			Hashtable<String, String> es = model.getHashResources("es");
			Hashtable<String, String> con = model.getGenConfig();
			
			ArrayList<IGenBanners01> bann = model.getBanners01("en");
			
			
			model.setTracking("DEBUG", "gtrTmpven2", "gtrIdven2", "gtrNumexp2", "gtrOricla", "gtrOrimet", "gtrDesgtr", "gtrTipgtr", "gtrDatos", "INFO", "gtrMaquina", "gtrSite", "gtrLine");


			
			model.setCache("111111", "Lob", new GregorianCalendar());
			
			
			IGenCache cache = model.getCacheById("111111");
			model.setGenSesion("2c7bc5d5ef33022081de203d1260_708", new Hashtable<String,Object>());
			//ldap.validateUser("ldapadmin@globalia.com", "unicsajk");

			//ldap.validateUser("XX344", "26011");
			Hashtable<String,Object> att = model.authenticateUser("XX344", "260111", "DC=globalia,DC=com");
			System.out.println(att);
			/*ArrayList<IMenu> menus = model.getMenus("es", "M");
			
			ArrayList<IGenConfig> con = model.getGenConfig(false);
			Hashtable<String, StringBuffer> res = model.getGeneralResources();
			model = new ModelGenFacade(params);
			ArrayList<IMenu> menus = model.getMenus("es", "M");
			model.convertMenusToHttps(menus);
			
			
			String mSesion="1b96310720fb767aada1e427284f9_24";
			String a = "es,una,prova,20010516";
			ArrayList<String> objProva =new ArrayList<String>(Arrays.asList(a.split(",")));
			Hashtable<String,Object> hProva= new Hashtable<String,Object>();
			hProva.put("alfa", objProva);
			model.setGenSesion(mSesion, hProva);
			
			
			ISesion recSesion = model.getGenSesion(null);*/
			//GregorianCalendar cal = new GregorianCalendar();
			
			
			/*
			 * revisar las condiciones de null o vacio;
			 * 
			 * 
			String b = model.llamadasCliente(null
								, "NEWHAL"
								, null
								, "666999666"
								, "17:00"
								, null
								, null
								, null
								, null
								, null
								, "pruebas desde Maingen de ModelGen"
								, null
								, "59894"
								, "59864"
								, "REN");
			
*/
			System.out.println("done");
			System.out.println("Done");
			
			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//result=model.test();

		

	}

}
