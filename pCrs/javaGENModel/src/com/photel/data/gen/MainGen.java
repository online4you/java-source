package com.photel.data.gen;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import com.photel.data.gen.facade.GenFacade;
import com.photel.interfaces.data.gen.IGenConfig;
import com.photel.interfaces.data.gen.IGenConfigSite;
import com.photel.interfaces.data.gen.IGenErrores;
import com.photel.interfaces.data.gen.IGenImages;
import com.photel.interfaces.data.gen.IGenImagesSite;
import com.photel.interfaces.data.gen.IGenLanResource;
import com.photel.interfaces.data.gen.IGenLanresourceSite;
import com.photel.interfaces.data.gen.IGenMenus;
import com.photel.interfaces.data.gen.IGenMonitor;
import com.photel.interfaces.data.gen.IGenScripts;
import com.photel.interfaces.data.gen.IGenScriptsSite;
import com.photel.interfaces.data.gen.IGenStyles;
import com.photel.interfaces.data.gen.IGenStylesSite;
import com.photel.interfaces.data.gen.IGenTrackingLevel;
import com.photel.interfaces.data.gen.IGenvMenus;
import com.photel.interfaces.data.gen.ILlamadasCliente;
import com.photel.interfaces.data.gen.ILlamadasClienteBusqueda;
import com.photel.interfaces.data.gen.IMenu;
import com.photel.interfaces.data.gen.IGenSesiones;
import com.photel.interfaces.data.gen.ITrackingBusqueda;





public class MainGen {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hashtable params=new Hashtable();
		Hashtable result=new Hashtable();
		GenFacade model;

		try {
			model = new GenFacade("NEWHAL");
			ArrayList<IGenScripts> s = model.getGenScripts();
			ArrayList bb = model.getBanners01("en");
			ArrayList bb2 = model.getBanners01("en");
			ArrayList bb3 = model.getBanners01("es");
			//model.setTracking("gtrIdeses", "gtrTmpven", "gtrIdven", "gtrNumexp", "gtrOricla", "gtrOrimet", "gtrDesgtr", "gtrTipgtr", "gtrDatos", "INFO", "gtrMaquina", "gtrSite", "gtrLine");
			ArrayList<IGenTrackingLevel> trakL = model.getStaticTrackingLevel();
			ArrayList<IGenImagesSite> img = model.getStaticImagesSite();
			ArrayList<IGenConfigSite> con = model.getStaticConfigSite();
			ArrayList<IGenLanresourceSite> resu = model.getStaticResourcesSite();
			ArrayList<IGenScriptsSite> scr = model.getStaticScriptsSite();
			ArrayList<IGenStylesSite> style = model.getStaticStylesSite();
			
			
			ArrayList<IGenImagesSite> imgp = model.getStaticImagesSite("PPT");
			ArrayList<IGenConfigSite> conp = model.getStaticConfigSite("PPT");
			ArrayList<IGenLanresourceSite> resup = model.getStaticResourcesSite("PPT");
			ArrayList<IGenScriptsSite> scrp = model.getStaticScriptsSite("PPT");
			ArrayList<IGenStylesSite> stylep = model.getStaticStylesSite("PPT");
			
			model = new GenFacade("PPT");
			 imgp = model.getStaticImagesSite("PPT");
			conp = model.getStaticConfigSite("PPT");
			 resup = model.getStaticResourcesSite("PPT");
			 scrp = model.getStaticScriptsSite("PPT");
		stylep = model.getStaticStylesSite("PPT");
			
			ArrayList<IGenScripts> a = model.getStaticScripts();
			ArrayList<IGenImages> b = model.getGenImages();
			ArrayList<IGenScripts> c = model.getGenScripts();
			
			ArrayList<IGenImagesSite> imgpp = model.getStaticImagesSite("PPTPROMO");
			ArrayList<IGenConfigSite> conpp = model.getStaticConfigSite("PPTPROMO");
			ArrayList<IGenLanresourceSite> resupp = model.getStaticResourcesSite("PPTPROMO");
			ArrayList<IGenScriptsSite> scrpp = model.getStaticScriptsSite("PPTPROMO");
			ArrayList<IGenStylesSite> stylepp = model.getStaticStylesSite("PPTPROMO");
			
			//model.setGenMenus(0, "gmnDes", "gmnEtiqueta", "gmnTitle", "gmnUrl", "V", 1, 1, 2);
			ArrayList<IGenMenus> men = model.getGenMenus(1);
			
			ArrayList<IGenScripts> sc = model.getGenScripts();
			
			//ITrackingBusqueda var = model.setTrackingBusqueda("59894", "59864", "REN");
			ITrackingBusqueda var = model.getTrackingBusqueda("20110620000015342");
			//var.setTbVacZonaDestino("31301");
			//ITrackingBusqueda varup = model.updateTrackingBusqueda(var);
			ILlamadasCliente lla = model.getLlamadasClientes("20070726000000020");
			
			ILlamadasClienteBusqueda tt = model.setLlamadasClienteBusqueda(var.getTbSeq(), lla.getLlcSeq(), null, var.getTbVacZonaOrigen(), var.getTbVacZonaDestino(), var.getTbVacIdprc());
			
			/*ArrayList<IGenConfig> con = model.getGenConfig(false);20070726000000020
			model.reloadStatic();
			con = model.getGenConfig(false);
			
			GregorianCalendar cal=new GregorianCalendar();
			cal.add(Calendar.MINUTE, -10);*/
			//IGenSesiones p = model.setGenSesiones("18", "c1d549a9ddc717412b971363bedaf_18", "new prueba");
			//IGenSesiones p = model.getGenSesiones("18", "c1d549a9ddc717412b971363bedaf_18",null);

			System.out.println("done");
			/*
			IGenErrores err = model.setErrores(0, "url2", "urlFrom2", "headers2", "params2", "session", "ip", "host", "action", "toString");
			 IGenMonitor err2 = model.setMonitor(0, "url2", "urlFrom2", "headers2", "params2", "session", "ip", "host", "action", "toString");
			*/
			/*ArrayList<IGenMenus> men = model.getStaticMenus();
			ArrayList<IGenConfig> con = model.getGenConfig(false);
			ArrayList<IGenLanResource> res = model.getGenResources();
			ArrayList<IGenStyles> styles = model.getGenStyles();
			ArrayList<IGenScripts> scr = model.getGenScripts();
			ArrayList<IGenImages> img = model.getGenImages();
			ArrayList<IGenvMenus> vmen = model.getStaticVMenus();
			ArrayList<IMenu> vmenIdi = model.getMenus("es","P");
			*/
			
			System.out.println("done");
			model.reloadStatic();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
		}
		//result=model.test();

		

	}

}
