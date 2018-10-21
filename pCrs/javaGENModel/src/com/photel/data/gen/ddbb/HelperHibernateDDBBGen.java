package com.photel.data.gen.ddbb;

import com.photel.commonServices.util.AppModelProperties;
import com.photel.data.gen.ddbb.hibernate.HibernateSessionFactory;
import com.photel.data.gen.ddbb.hibernate.pojo.*;
import com.photel.interfaces.data.gen.*;


import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.Session;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class HelperHibernateDDBBGen<C> {
    private AppModelProperties properties;	
	public static ArrayList<IGenConfig> staticConfig;
	public static ArrayList<IGenLanResource> staticResources;
	public static ArrayList<IGenMetas> staticMetas;
	public static ArrayList<IGenStyles> staticStyles;
	public static ArrayList<IGenScripts> staticScripts;
	public static ArrayList<IGenImages> staticImages;
	public static ArrayList<IGenConfigSite> staticConfigSite;
	public static ArrayList<IGenLanresourceSite> staticResourcesSite;
	public static ArrayList<IGenStylesSite> staticStylesSite;
	public static ArrayList<IGenScriptsSite> staticScriptsSite;
	public static ArrayList<IGenImagesSite> staticImagesSite;
	public static ArrayList<IGenvMenus> staticVMenus;
	public static ArrayList<IGenVOpciones> staticVOpciones;
	public static ArrayList<IGenLanResource> staticTextosNewHalcon;
	public static ArrayList<IGenvMenus> staticVMenusPpt;
	public static ArrayList<IGenVOpciones> staticVOpcionesPpt;
	public static ArrayList<IGenTrackingLevel> staticTrackingLevel;
	public static Hashtable<String,ArrayList<IGenBanners01>> staticBanners01;
	private static String site;
	

	
	
	
	
	public HelperHibernateDDBBGen(String site) throws IOException {
		super();
		this.site = site;
		
		reloadStaticDDBB(site);
		
		properties = new AppModelProperties();
		if(staticConfig==null){loadGenConfig();}
		if(staticResources==null){loadGenLanResource();}
		if(staticMetas==null){loadGenMetas();}
		if(staticStyles==null){loadGenStyles();}
		if(staticScripts==null){loadGenScripts();}
		if(staticImages==null){loadGenImages();}
		/*
		if(staticVMenus==null){loadGenvMenus();}
		if(staticVOpciones==null){loadGenvOpciones();}
		if(staticVMenusPpt==null){loadGenvMenusPpt();}
		if(staticVOpcionesPpt==null){loadGenvOpcionesPpt();}
		if(staticTextosNewHalcon==null){loadGenTextosNewHalcon();}
		*/
		if(staticConfigSite==null){loadGenConfigSite();}
		if(staticResourcesSite==null){loadGenLanResourceSite();}
		if(staticStylesSite==null){loadGenStylesSite();}
		if(staticScriptsSite==null){loadGenScriptsSite();}
		if(staticImagesSite==null){loadGenImagesSite();}
		
		if(staticTrackingLevel==null){loadGenTrackingLevel();}
	}
	
	

	protected void finalize() throws Throwable {
		HibernateSessionFactory.closeSession();
		super.finalize();
	}
	public void clearSession(){
		Session ses = getSession();
		ses.clear();
		ses.flush();
	}

	public void closeSession(){
		HibernateSessionFactory.closeSession();
	}

	private Object copyClass(Object oFrom, Object oTo) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
		if (!oFrom.getClass().getName().equals(oTo.getClass().getName())){
			return null;
		}
		
	    Method[] allMethodsFrom;
	    Method[] allMethodsTo;
	    String mnameF;
	    String mnameIni;
	    String mnameSetter;
	    String mnameT;
	    allMethodsFrom = oFrom.getClass().getMethods();
	    allMethodsTo = oTo.getClass().getMethods();
	    for (Method mf : allMethodsFrom) {
	    	mnameF = mf.getName();
	    	mnameIni=mnameF.substring(0, 3);
	    	if (mnameIni.equals("get")){
	    		for (Method mt : allMethodsTo) {
	    			mnameT = mt.getName();
	    			mnameSetter="set"+mnameF.substring(3, mnameF.length());
	    	    	if (mnameSetter.equals(mnameT)){
	    	    		Object r1 = mf.invoke(oFrom);
	    	    		mt.invoke(oTo, r1);
	    	    	}
	    	    	
	     		}
	    	}
	    	
 		}
	   
		
		return oTo; 
	}
	
	public Object getInstance(String classe) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Object ret=null;
		Class<Object> fc = (Class<Object>) Class.forName("com.globalia.data.gen.ddbb.hibernate.pojo."+classe);
		ret = fc.newInstance();
		return ret;
	}
	

	
	private Session getSession(){
		return HibernateSessionFactory.getSession();
	}
	
	
	public static void init(){
		try{
		
		HibernateSessionFactory.getSession().clear();
		
		loadGenConfig();
		loadGenLanResource();
		loadGenLanResourceSite();
		loadGenMetas();
		loadGenStyles();
		loadGenScripts();
		loadGenImages();
		loadGenvMenus();
		loadGenvOpciones();
		loadGenTextosNewHalcon();
		loadGenConfigSite();
		loadGenStylesSite();
		loadGenScriptsSite();
		loadGenImagesSite();
		loadGenTrackingLevel();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public static void loadGenConfig(){
		String sql;
		sql="SELECT GEN_PARAM,GEN_VALUE from GEN_CONFIG";
   		staticConfig =(ArrayList<IGenConfig>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenConfig.class).list();	
	}
	public static void loadGenTextosNewHalcon(){
		ArrayList<IGenLanResource> tmpTxtHalcon= new ArrayList<IGenLanResource>();
		ArrayList<String> arraySql=new ArrayList<String>();
		String version = getVersionNewHalcon();
		arraySql.add("select DECODE(WET_CODIDI,'ESP','es','PTE','pt','es') AS GEN_LANG, WET_TIPTEXT AS GEN_RES, WET_TEXTO AS GEN_DES  from web_textos  where wet_numver=" + version + " and wet_tiptext='H1OFERTASINI'");
		arraySql.add("select DECODE(WET_CODIDI,'ESP','es','PTE','pt','es') AS GEN_LANG, WET_TIPTEXT AS GEN_RES, WET_TEXTO AS GEN_DES  from web_textos  where wet_numver=" + version + " and wet_tiptext='PIE_1'");
		arraySql.add("select DECODE(WET_CODIDI,'ESP','es','PTE','pt','es') AS GEN_LANG, WET_TIPTEXT AS GEN_RES, WET_TEXTO AS GEN_DES  from web_textos  where wet_numver=" + version + " and wet_tiptext='PIE_HOR'");
		arraySql.add("select DECODE(WET_CODIDI,'ESP','es','PTE','pt','es') AS GEN_LANG, WET_TIPTEXT AS GEN_RES, WET_TEXTO AS GEN_DES  from web_textos  where wet_numver=" + version + " and wet_tiptext='PIE_TLF'");
		arraySql.add("select 'es' AS GEN_LANG,'TELEFONONEWHALCON' AS GEN_RES ,SIN_TELEFONO AS GEN_DES from SITES_INFO where SIN_CODSITE='NEWHAL'");
		arraySql.add("select 'pt' AS GEN_LANG,'TELEFONONEWHALCON' AS GEN_RES ,SIN_TELEFONO AS GEN_DES from SITES_INFO where SIN_CODSITE='NEWHAL'");

		/*arraySql.add("select DECODE(TSI_CODIDI,'ESP','es','PTE','pt','es') AS TRL_LANG, 'textos_site.'||TSI_TIPTEX AS TRL_RES ,TSI_TEXTO AS TRL_DES from textos_site where TSI_CODSITE='NEWHAL' and TSI_NUMVER='"+version+"'and TSI_TIPTEX='PIE_1'");*/
		for(int k=0; k< arraySql.size();k++ ){
			tmpTxtHalcon.addAll((ArrayList<IGenLanResource>) HibernateSessionFactory.getSession().createSQLQuery(arraySql.get(k)).addEntity(GenLanresource.class).list());
		}
		staticResources.addAll(tmpTxtHalcon);
		staticTextosNewHalcon=tmpTxtHalcon;
	}
	private static String getVersionNewHalcon(){
		List version ;
		String sql ="select wtv_numver as RESULT from web_textos_versiones where wtv_activa='S'";
		version = HibernateSessionFactory.getSession().createSQLQuery(sql).addScalar("RESULT", Hibernate.STRING).list();
		if(version!=null){
			return version.get(0).toString();
		}
		return null;
	}
	
	
	public static void loadGenLanResource(){
		String sql;	
		sql="SELECT GEN_LANG, GEN_RES, GEN_DES FROM GENV_LANRESOURCE";
		staticResources =(ArrayList<IGenLanResource>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenLanresource.class).list();	
	}
	public static void loadGenMetas(){
		String sql;
		sql="SELECT GEN_PARAM, GEN_VALUE FROM GEN_METAS WHERE GEN_VAL='S'  ORDER BY GEN_ORDER";
	   	staticMetas =(ArrayList<IGenMetas>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenMetas.class).list();
	}
	public static void loadGenStyles(){
		String sql;
	   	sql="SELECT GEN_PARAM, GEN_VALUE, GEN_ORDER, GEN_VAL FROM GEN_STYLES WHERE GEN_VAL='S'  ORDER BY GEN_ORDER";
	   	staticStyles =(ArrayList<IGenStyles>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenStyles.class).list();	
	}
	public static void loadGenScripts(){
		String sql;
	   	sql="SELECT GEN_PARAM, GEN_VALUE, GEN_ORDER, GEN_VAL FROM GEN_SCRIPTS   WHERE GEN_VAL='S'  ORDER BY GEN_ORDER";
	   	staticScripts =(ArrayList<IGenScripts>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenScripts.class).list();	
	}
	public static void loadGenImages(){
		String sql;
	   	sql="SELECT GEN_IDI,GEN_PARAM,GEN_TITLE,GEN_ALT, GEN_VALUE, GEN_ORDER, GEN_VAL FROM GEN_IMAGES WHERE GEN_VAL='S' ORDER BY GEN_ORDER";
	   	staticImages =(ArrayList<IGenImages>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenImages.class).list();	
	}
	public static void loadGenConfigSite(){
   		staticConfigSite = (ArrayList<IGenConfigSite>) HibernateSessionFactory.getSession().createQuery("from GenConfigSite").list(); 
   		
	}
	public static void loadGenLanResourceSite(){
		staticResourcesSite = (ArrayList<IGenLanresourceSite>) HibernateSessionFactory.getSession().createQuery("from GenLanresourceSite").list(); 
	}
	public static void loadGenStylesSite(){
		staticStylesSite = (ArrayList<IGenStylesSite>) HibernateSessionFactory.getSession().createQuery("from GenStylesSite order by Gen_Site, Gen_Order").list(); 
	}
	public static void loadGenScriptsSite(){
		staticScriptsSite = (ArrayList<IGenScriptsSite>) HibernateSessionFactory.getSession().createQuery("from GenScriptsSite order by Gen_Site, Gen_Order").list(); 
	}
	public static void loadGenTrackingLevel(){
		staticTrackingLevel = (ArrayList<IGenTrackingLevel>) HibernateSessionFactory.getSession().createQuery("from GenTrackingLevel").list(); 
	}
	public static void loadGenImagesSite(){
		staticImagesSite = (ArrayList<IGenImagesSite>) HibernateSessionFactory.getSession().createQuery("from GenImagesSite").list(); 
	}
	public static void loadGenvMenus(){
		String sql;
	   	sql="SELECT * FROM GENV_MENUS_HAL";
	   	staticVMenus =(ArrayList<IGenvMenus>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenvMenus.class).list();	
	}
	public static void loadGenvOpciones(){
		String sql;
	   	sql="SELECT * FROM GENV_OPCIONES_HAL";
	   	staticVOpciones =(ArrayList<IGenVOpciones>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenvOpciones.class).list();	
	}
	
	public static void loadGenvMenusPpt(){
		String sql;
	   	sql="SELECT * FROM GENV_MENUS_PPT ORDER BY GME_ORD, GME_CODSECC";
	   	staticVMenusPpt =(ArrayList<IGenvMenus>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenvMenus.class).list();	
	}
	public static void loadGenvOpcionesPpt(){
		String sql;
	   	sql="SELECT * FROM GENV_OPCIONES_PPT";
	   	staticVOpcionesPpt =(ArrayList<IGenVOpciones>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(GenvOpciones.class).list();	
	}
/*
	static{
		init();
	}
	*/
	

	
	public void reloadTable(String table){
		if (table.equalsIgnoreCase("GEN_CONFIG")){
			loadGenConfig();
		}else if (table.equalsIgnoreCase("GEN_LANRESOURCE")){
			loadGenLanResource();
		}else if (table.equalsIgnoreCase("GEN_METAS")){
			loadGenMetas();
		}else if (table.equalsIgnoreCase("GEN_STYLES")){
			loadGenStyles();
		}else if (table.equalsIgnoreCase("GEN_SCRIPTS")){
			loadGenScripts();
		}else if (table.equalsIgnoreCase("GEN_IMAGES")){
			loadGenImages();
		}else if (table.equalsIgnoreCase("GENV_MENUS")){
			loadGenvMenus();
		}else if (table.equalsIgnoreCase("GENV_OPCIONES")){
			loadGenvOpciones();
		}
		
		
	}

	public IGenErrores setErrores(int id, String url, String urlFrom,String headers,String params,String session,String ip,String host, String action, String toString, String serialized, String error ){
		IGenErrores err;
		
		err=(IGenErrores) getSession().get(GenErrores.class, id);
		
    	Transaction tx = getSession().beginTransaction();
    	tx.begin();
    	if (err!=null){
    		err.setGerAction(action);
    		err.setGerHeaders(headers);
    		err.setGerHost(host);
    		err.setGerIp(ip);
    		err.setGerParams(params);
    		err.setGerSession(session);
    		err.setGerTostring(toString);
    		err.setGerUrl(url);
    		err.setGerUrlfrom(urlFrom);
    		err.setGerSerialized(serialized);
    		err.setGerError(error);
    		err.setGerSite(site);
    		getSession().update(err);
    	}else{
    		err=new GenErrores();
    		err.setGerAction(action);
    		err.setGerHeaders(headers);
    		err.setGerHost(host);
    		err.setGerIp(ip);
    		err.setGerParams(params);
    		err.setGerSession(session);
    		err.setGerTostring(toString);
    		err.setGerUrl(url);
    		err.setGerUrlfrom(urlFrom);
    		err.setGerSerialized(serialized);
    		err.setGerError(error);
    		err.setGerSite(site);
    		getSession().save(err);
   			
      	}
    	  	
    	tx.commit();

		return err; 
	}

	
	public IGenMonitor setMonitor(int id, String url, String urlFrom,String headers,String params,String session,String ip,String host, String action, String toString ){
		IGenMonitor mon;
		
		mon=(IGenMonitor) getSession().get(GenMonitor.class, id);
		
    	Transaction tx = getSession().beginTransaction();
    	tx.begin();
    	if (mon!=null){
    		mon.setGerAction(action);
    		mon.setGerHeaders(headers);
    		mon.setGerHost(host);
    		mon.setGerIp(ip);
    		mon.setGerParams(params);
    		mon.setGerSession(session);
    		mon.setGerTostring(toString);
    		mon.setGerUrl(url);
    		mon.setGerUrlfrom(urlFrom);
    		getSession().update(mon);
    	}else{
    		mon=new GenMonitor();
    		mon.setGerAction(action);
    		mon.setGerHeaders(headers);
    		mon.setGerHost(host);
    		mon.setGerIp(ip);
    		mon.setGerParams(params);
    		mon.setGerSession(session);
    		mon.setGerTostring(toString);
    		mon.setGerUrl(url);
    		mon.setGerUrlfrom(urlFrom);
    		getSession().save(mon);
   			
      	}
    	  	
    	tx.commit();

		return mon; 
	}
	
	public ArrayList<IGenConfigSite> getStaticConfigSite(String site)  {
		ArrayList<IGenConfigSite> ret = new ArrayList<IGenConfigSite>();
		if (staticConfigSite!=null){
			for(int i=0;i<staticConfigSite.size();i++){
				if (staticConfigSite.get(i).getId().getGenSite()!=null && staticConfigSite.get(i).getId().getGenSite().equalsIgnoreCase(site)){
					ret.add(staticConfigSite.get(i));
				}
			}
		}
		return ret;
	}
	
	public ArrayList<IGenConfigSite> getStaticConfigSite() {
		return staticConfigSite;
	}

	public ArrayList<IGenLanresourceSite> getStaticResourcesSite(String site)  {
		ArrayList<IGenLanresourceSite> ret = new ArrayList<IGenLanresourceSite>();
		if (staticResourcesSite!=null){
			for(int i=0;i<staticResourcesSite.size();i++){
				if (staticResourcesSite.get(i).getId().getGenSite()!=null && staticResourcesSite.get(i).getId().getGenSite().equalsIgnoreCase(site)){
					ret.add(staticResourcesSite.get(i));
				}
			}
		}
		return ret;
	}
	public ArrayList<IGenLanresourceSite> getStaticResourcesSite() {
		return staticResourcesSite;
	}
	public ArrayList<IGenStylesSite> getStaticStylesSite(String site)  {
		ArrayList<IGenStylesSite> ret = new ArrayList<IGenStylesSite>();
		if (staticStylesSite!=null){
			for(int i=0;i<staticStylesSite.size();i++){
				if (staticStylesSite.get(i).getId().getGenSite()!=null && staticStylesSite.get(i).getId().getGenSite().equalsIgnoreCase(site)){
					ret.add(staticStylesSite.get(i));
				}
			}
		}
		return ret;
	}
	public ArrayList<IGenStylesSite> getStaticStylesSite() {
		return staticStylesSite;
	}
	public ArrayList<IGenScriptsSite> getStaticScriptsSite(String site)  {
		ArrayList<IGenScriptsSite> ret = new ArrayList<IGenScriptsSite>();
		if (staticScriptsSite!=null){
			for(int i=0;i<staticScriptsSite.size();i++){
				if (staticScriptsSite.get(i).getId().getGenSite()!=null && staticScriptsSite.get(i).getId().getGenSite().equalsIgnoreCase(site)){
					ret.add(staticScriptsSite.get(i));
				}
			}
		}
		return ret;
	}
	public ArrayList<IGenScriptsSite> getStaticScriptsSite()  {
		return staticScriptsSite;
	}
	public ArrayList<IGenImagesSite> getStaticImagesSite(String site) {
		ArrayList<IGenImagesSite> ret = new ArrayList<IGenImagesSite>();
		if (staticImagesSite!=null){
			for(int i=0;i<staticImagesSite.size();i++){
				if (staticImagesSite.get(i).getId().getGenSite()!=null && staticImagesSite.get(i).getId().getGenSite().equalsIgnoreCase(site)){
					ret.add(staticImagesSite.get(i));
				}
			}
		}
		return ret;
	}
	public ArrayList<IGenImagesSite> getStaticImagesSite() {
		return staticImagesSite;
	}

	/**
	 * @return the staticConfig
	 */
	public  ArrayList<IGenConfig> getStaticConfig() {
		return staticConfig;
	}




	/**
	 * @return the staticResources
	 */
	public  ArrayList<IGenLanResource> getStaticResources() {
		return staticResources;
	}



	/**
	 * @return the staticMetas
	 */
	public  ArrayList<IGenMetas> getStaticMetas() {
		return staticMetas;
	}
	
	public ArrayList<IGenTrackingLevel> getStaticTrackingLevel() {
		return staticTrackingLevel;
	}

	/**
	 * @return the staticStyles
	 * 
	 */
	public  ArrayList<IGenStyles> getStaticStyles() {
		ArrayList<IGenStyles> ret = new ArrayList<IGenStyles>();
		IGenStyles elem;
		IGenStylesSite elemFrom;
		TreeMap<String,IGenStyles> aux=new TreeMap<String,IGenStyles>();
		for (int i=0;i<staticStyles.size();i++){
			aux.put(staticStyles.get(i).getGenParam(), staticStyles.get(i));
		}
		ArrayList<IGenStylesSite> retSite = this.getStaticStylesSite(this.site);
		for (int i=0;i<retSite.size();i++){
			elemFrom = retSite.get(i);
			elem=new GenStyles();
			elem.setGenParam(elemFrom.getId().getGenParam());
			elem.setGenOrder(elemFrom.getGenOrder());
			elem.setGenVal(elemFrom.getGenVal());
			elem.setGenValue(elemFrom.getGenValue());
			ret.add(elem);
			if (aux.containsKey(elem.getGenParam())){
				aux.remove(elem.getGenParam());
			}
		}
		Iterator<Entry<String, IGenStyles>> set = aux.entrySet().iterator();
		while(set.hasNext()){
			elem=set.next().getValue();
			ret.add(elem);
		}
		return ret;
	}

	

	/**
	 * @return the staticScripts
	 */
	public  ArrayList<IGenScripts> getStaticScripts() {
		ArrayList<IGenScripts> ret = new ArrayList<IGenScripts>();
		IGenScripts elem;
		IGenScriptsSite elemFrom;
		TreeMap<String,IGenScripts> aux=new TreeMap<String,IGenScripts>();
		for (int i=0;i<staticScripts.size();i++){
			aux.put(staticScripts.get(i).getGenParam(), staticScripts.get(i));
		}
		ArrayList<IGenScriptsSite> retSite = this.getStaticScriptsSite(this.site);
		for (int i=0;i<retSite.size();i++){
			elemFrom = retSite.get(i);
			elem=new GenScripts();
			elem.setGenParam(elemFrom.getId().getGenParam());
			elem.setGenOrder(elemFrom.getGenOrder());
			elem.setGenVal(elemFrom.getGenVal());
			elem.setGenValue(elemFrom.getGenValue());
			ret.add(elem);
			if (aux.containsKey(elem.getGenParam())){
				aux.remove(elem.getGenParam());
			}
		}
		Iterator<Entry<String, IGenScripts>> set = aux.entrySet().iterator();
		while(set.hasNext()){
			elem=set.next().getValue();
			ret.add(elem);
		}
		Collections.sort(ret, new ScriptsComparator());
		return ret;
	}



	/**
	 * @return the staticImages
	 */
	public  ArrayList<IGenImages> getStaticImages() {
		ArrayList<IGenImages> ret = new ArrayList<IGenImages>();
		IGenImages elem;
		IGenImagesSite elemFrom;
		TreeMap<String,IGenImages> aux=new TreeMap<String,IGenImages>();
		for (int i=0;i<staticImages.size();i++){
			aux.put(staticImages.get(i).getId().getGenIdi()+"##"+staticImages.get(i).getId().getGenParam(), staticImages.get(i));
		}
		ArrayList<IGenImagesSite> retSite = this.getStaticImagesSite(this.site);
		for (int i=0;i<retSite.size();i++){
			elemFrom = retSite.get(i);
			elem=new GenImages();
			IGenImagesPK pk=new GenImagesPK();
			pk.setGenIdi(elemFrom.getId().getGenIdi());
			pk.setGenParam(elemFrom.getId().getGenParam());
			elem.setId(pk);
			elem.setGenAlt(elemFrom.getGenAlt());
			elem.setGenOrder(elemFrom.getGenOrder());
			elem.setGenTitle(elemFrom.getGenTitle());
			elem.setGenVal(elemFrom.getGenVal());
			elem.setGenValue(elemFrom.getGenValue());
			elem.setGenAlt(elemFrom.getGenAlt());
			ret.add(elem);
			if (aux.containsKey(elem.getId().getGenIdi()+"##"+staticImages.get(i).getId().getGenParam())){
				aux.remove(elem.getId().getGenIdi()+"##"+staticImages.get(i).getId().getGenParam());
			}
		}
		Iterator<Entry<String, IGenImages>> set = aux.entrySet().iterator();
		while(set.hasNext()){
			elem=set.next().getValue();
			ret.add(elem);
		}
		
		return ret;
	}

	


	public ArrayList<IGenvMenus> getStaticVMenus() {
		return staticVMenus;
	}


	
	
	public String formatSQL(String str) {
		String ret;
		ret=str.replaceAll("'", "''");
		return ret;
	}
	private void reloadResourcesFalse(){
		clearSession();
		GenConfig config=(GenConfig) getSession().get(GenConfig.class, "reloadResources");
		if (config!=null && config.getTrnValue().equals("true")){
			config.setTrnValue("false");
			Transaction tx = getSession().beginTransaction();
			tx.begin();
			getSession().merge(config);
			tx.commit();
			
		}else{
			for (int i=0;i<staticConfig.size();i++){
				if(staticConfig.get(i).getId()!=null && staticConfig.get(i).getId().equalsIgnoreCase("reloadResources")){
					staticConfig.get(i).setTrnValue("false");
					break;
				}
			}
		}

	}
	private void reloadStaticDDBB(String site){
		IGenConfigSitePK pk=new GenConfigSitePK();
		pk.setGenParam("reloadStatic");
		pk.setGenSite(site);
		clearSession();
		GenConfigSite config=(GenConfigSite) getSession().get(GenConfigSite.class, pk);
		if (config!=null && config.getGenValue().equals("true")){
			init();
			config.setGenValue("false");
			Transaction tx = getSession().beginTransaction();
			tx.begin();
			getSession().merge(config);
			tx.commit();
			reloadResourcesFalse();
		}
	}
	public void reloadStatic(){
		init();
	}
	private String getPatam(String param){
		for (int i=0;i<staticConfig.size();i++){
			if (staticConfig.get(i).getId().equalsIgnoreCase(param)){
				return staticConfig.get(i).getTrnValue();
			}
		}
		return "";
		
	}

	public ArrayList<IMenu> getMenus(String idi, String codMenu){
		String idioma=getPatam(idi);
		ArrayList<IMenu> menus = getGenvMenusIdi(idioma,codMenu);
		return menus;
	}
	public ArrayList<IMenu> getMenusPpt(String idi, String codMenu){
		String idioma=getPatam(idi);
		ArrayList<IMenu> menus = getGenvMenusPptIdi(idioma,codMenu);
		return menus;
	}
	private ArrayList<IMenu> getGenvMenusIdi(String idi, String codMenu){
		String idioma=idi;
		ArrayList<IMenu> menus = new ArrayList<IMenu>();
		IMenu menu;
		ArrayList<IGenVOpciones> opciones;
		
		for (int i=0;i<staticVMenus.size();i++){
			if (staticVMenus.get(i).getId().getGmeIdi().equalsIgnoreCase(idioma) &&  staticVMenus.get(i).getId().getGmeCodmenu().equalsIgnoreCase(codMenu)){
				menu=new Menu();
				menu.setMenu(staticVMenus.get(i));
				opciones=getGenvOpcionesIdi(idioma,staticVMenus.get(i).getId().getGmeCodsecc(), codMenu);
				menu.setSubmenu(opciones);
				
				menus.add(menu);
			}
		}
		return menus;
		
	}
	private ArrayList<IGenVOpciones> getGenvOpcionesPptIdi(String idi,String codSeccion, String codMenu){
		String idioma=idi;
		ArrayList<IGenVOpciones> opciones = new ArrayList<IGenVOpciones>();
		IMenu menu;
		for (int i=0;i<staticVOpcionesPpt.size();i++){
			if (staticVOpcionesPpt.get(i).getId().getGopIdioma().equalsIgnoreCase(idioma) && staticVOpcionesPpt.get(i).getId().getGopCodsec().equalsIgnoreCase(codSeccion) && staticVOpcionesPpt.get(i).getId().getGopCodmenu().equalsIgnoreCase(codMenu)){
				opciones.add(staticVOpcionesPpt.get(i));
			}
		}
		return opciones;
		
	}
	private ArrayList<IMenu> getGenvMenusPptIdi(String idi, String codMenu){
		String idioma=idi;
		ArrayList<IMenu> menus = new ArrayList<IMenu>();
		IMenu menu;
		ArrayList<IGenVOpciones> opciones;
		
		for (int i=0;i<staticVMenusPpt.size();i++){
			if (staticVMenusPpt.get(i).getId().getGmeIdi().equalsIgnoreCase(idioma) &&  staticVMenusPpt.get(i).getId().getGmeCodmenu().equalsIgnoreCase(codMenu)){
				menu=new Menu();
				menu.setMenu(staticVMenusPpt.get(i));
				opciones=getGenvOpcionesPptIdi(idioma,staticVMenusPpt.get(i).getId().getGmeCodsecc(), codMenu);
				menu.setSubmenu(opciones);
				
				menus.add(menu);
			}
		}
		return menus;
		
	}
	private ArrayList<IGenVOpciones> getGenvOpcionesIdi(String idi,String codSeccion, String codMenu){
		String idioma=idi;
		ArrayList<IGenVOpciones> opciones = new ArrayList<IGenVOpciones>();
		IMenu menu;
		for (int i=0;i<staticVOpciones.size();i++){
			if (staticVOpciones.get(i).getId().getGopIdioma().equalsIgnoreCase(idioma) && staticVOpciones.get(i).getId().getGopCodsec().equalsIgnoreCase(codSeccion) && staticVOpciones.get(i).getId().getGopCodmenu().equalsIgnoreCase(codMenu)){
				opciones.add(staticVOpciones.get(i));
			}
		}
		return opciones;
		
	}

	public String getQuery(String sql){
		Object obj;
		Iterator ite=((List) getSession().createSQLQuery(sql).addScalar("RESULT", Hibernate.STRING).list()).iterator();
		
		if (ite!=null && ite.hasNext()){
			obj=ite.next();
			if (obj!=null){
				return obj.toString();}
		}

		return "";
		}

	
	
	
	public ArrayList<IGenConfig> getConfig() throws Exception, SQLException {
		ArrayList<IGenConfig> lista;
   		String sql="SELECT GEN_PARAM,GEN_VALUE from GEN_CONFIG";
   		lista =(ArrayList<IGenConfig>) getSession().createSQLQuery(sql).addEntity(GenConfig.class).list();	
    	return lista;

       }
	
	
	public ArrayList<IGenLanResource> getResources() throws Exception, SQLException {
		ArrayList<IGenLanResource> lista;
	   	String sql="SELECT TRL_LANG, TRL_RES, TRL_DES FROM GEN_LANRESOURCE";
		lista =(ArrayList<IGenLanResource>) getSession().createSQLQuery(sql).addEntity(GenLanresource.class).list();	

    	return lista;

       }
	

	
	
	public ArrayList<IGenMetas> getGenMetas() throws Exception, SQLException {
		ArrayList<IGenMetas> lista;
	   	String sql="SELECT GEN_PARAM, GEN_VALUE FROM GEN_METAS WHERE GEN_VAL='S' ORDER BY GEN_ORDER";
		lista =(ArrayList<IGenMetas>) getSession().createSQLQuery(sql).addEntity(GenMetas.class).list();	

    	return lista;

       }

	
	public ArrayList<IGenStyles> getGenStyles() throws Exception, SQLException {
		ArrayList<IGenStyles> lista;
	   	String sql="SELECT GEN_PARAM, GEN_VALUE, GEN_ORDER, GEN_VAL FROM GEN_STYLES WHERE GEN_VAL='S' ORDER BY GEN_ORDER";
		lista =(ArrayList<IGenStyles>) getSession().createSQLQuery(sql).addEntity(GenStyles.class).list();	

    	return lista;

       }

	public ArrayList<IGenScripts> getGenScripts() throws Exception, SQLException {
		ArrayList<IGenScripts> lista;
	   	String sql="SELECT GEN_PARAM, GEN_VALUE, GEN_ORDER, GEN_VAL FROM GEN_SCRIPTS WHERE GEN_VAL='S' ORDER BY GEN_ORDER";
		lista =(ArrayList<IGenScripts>) getSession().createSQLQuery(sql).addEntity(GenScripts.class).list();	

    	return lista;

       }

	public ArrayList<IGenImages> getGenImages() throws Exception, SQLException {
		ArrayList<IGenImages> lista;
	   	String sql="SELECT GEN_IDI,GEN_PARAM,GEN_TITLE,GEN_ALT, GEN_VALUE, GEN_ORDER, GEN_VAL FROM GEN_IMAGES WHERE GEN_VAL='S' ORDER BY GEN_ORDER";
		lista =(ArrayList<IGenImages>) getSession().createSQLQuery(sql).addEntity(GenImages.class).list();	

    	return lista;

       }
	
	
	private ArrayList<IGenSesiones> getGenSesiones(String sql) throws Exception, SQLException {
		ArrayList<IGenSesiones> lista;
    	
		lista =(ArrayList<IGenSesiones>) getSession().createSQLQuery(sql).addEntity(GenSesiones.class).list();	

    	return lista;
       }

	private ArrayList<IGenSesiones> getConsultaGenSesiones(String id,String idSesion,GregorianCalendar cal) throws SQLException, Exception{		
    	String mCal="";
    	if (id.compareToIgnoreCase("")==0){
    		id="-1";
    	}
	    if (cal!=null){
	    	mCal = "AND GSE_TIMCRE >= TO_DATE('"+ cal.get(Calendar.DAY_OF_MONTH) + "/"; 
	    	mCal = mCal + (cal.get(Calendar.MONTH)+1) + "/"; 
	    	mCal = mCal + cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR_OF_DAY);
	    	mCal = mCal + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	    	mCal = mCal + "','DD/MM/YYYY HH24:MI:SS')";
	    }
    	String sql;
    	
		sql="SELECT ";
		sql+="GSE_ID,GSE_IDSESION,GSE_SESION, GSE_TIMCRE ";
		sql+="FROM GEN_SESIONES ";
		sql+="WHERE GSE_ID=" + id + " AND GSE_IDSESION='"+idSesion+ "' ";
		sql+= mCal  ;
				    
    	ArrayList<IGenSesiones> lSesion=getGenSesiones(sql);
    	

		return lSesion;
	}
	private ArrayList<IGenSesiones> getConsultaGenSesionesJSessionId(String idSesion,GregorianCalendar cal) throws SQLException, Exception{		
    	String mCal="";
    	
	    if (cal!=null){
	    	mCal = "AND GSE_TIMCRE >= TO_DATE('"+ cal.get(Calendar.DAY_OF_MONTH) + "/"; 
	    	mCal = mCal + (cal.get(Calendar.MONTH)+1) + "/"; 
	    	mCal = mCal + cal.get(Calendar.YEAR) + " " + cal.get(Calendar.HOUR_OF_DAY);
	    	mCal = mCal + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	    	mCal = mCal + "','DD/MM/YYYY HH24:MI:SS')";
	    }
    	String sql;
    	
		sql="SELECT ";
		sql+="GSE_ID,GSE_IDSESION,GSE_SESION, GSE_TIMCRE ";
		sql+="FROM GEN_SESIONES ";
		sql+="WHERE GSE_IDSESION LIKE '"+idSesion+ "%' ";
		sql+= mCal  ;
		sql+= " ORDER BY GSE_ID DESC"  ;
		
    	ArrayList<IGenSesiones> lSesion=getGenSesiones(sql);
    	

		return lSesion;
	}
	public IGenSesiones getGenSesiones(String id,String idSesion,GregorianCalendar cal) throws SQLException, Exception{
		return this.getGenSesiones(id, idSesion, cal,true);
	}
	public IGenSesiones getGenSesiones(String id,String idSesion,GregorianCalendar cal,boolean create) throws SQLException, Exception{
		ArrayList<IGenSesiones> lSes;
		if (id==null){
			lSes=getConsultaGenSesionesJSessionId(idSesion,cal);
		}else{
			lSes=getConsultaGenSesiones(id,idSesion,cal);
		}
		if(lSes.size()==0){
			if (create){
				return setCreaSesion(idSesion);
			}else{
				return null;
			}
		}
		return lSes.get(0);
	}
	public void delSession(String id,String idSesion,GregorianCalendar cal) throws SQLException, Exception{
		IGenSesiones ses = this.getGenSesiones(id, idSesion, cal,true);
		if (ses!=null){
			Transaction tx = getSession().beginTransaction();
	    	tx.begin();
	    	getSession().delete(ses);
	    	tx.commit();
	    	this.clearSession();
		}
	}
	public IGenSesiones setGenSesiones(String id,String idSesion,String sesion) throws SQLException, Exception{
		GregorianCalendar calActual = new GregorianCalendar();
		IGenSesiones cacheSes = new  GenSesiones();
    	ArrayList<IGenSesiones> lSes=getConsultaGenSesiones(id,idSesion,null);
    	Transaction tx = getSession().beginTransaction();
    	tx.begin();
    	cacheSes = lSes.get(0);
	    cacheSes.setGseTimCre(calActual.getTime());
	    cacheSes.setGseSesion(sesion);
    	getSession().update(cacheSes);    	
    	tx.commit();
		return cacheSes;
	}
	
	private IGenSesiones setCreaSesion(String defaultID) throws NumberFormatException, IOException{
		IGenSesiones cacheSes = new  GenSesiones();
		String newIdSesion;
		int car=Integer.parseInt(properties.getProperty("com.globalia.gen.tamanoIdSesion"));
		GregorianCalendar calActual = new GregorianCalendar();
		Transaction tx = getSession().beginTransaction();
    	tx.begin();
		getSession().save(cacheSes);
		newIdSesion=Long.toString(cacheSes.getGseId());
		car=car-newIdSesion.length()-1;
		if(defaultID==null){
			newIdSesion=getDameRamdom(car)+'_'+ newIdSesion;
		}else{
			newIdSesion=defaultID+'_'+ newIdSesion;
		}
		cacheSes.setGseIdSesion(newIdSesion);
		cacheSes.setGseTimCre(calActual.getTime());
		getSession().update(cacheSes);
		tx.commit();
		return cacheSes;
	}

	private String getDameRamdom(int car){
		SecureRandom s= new SecureRandom();
		BigInteger r = new BigInteger(512,s);
		String result = r.toString(16);
		return result.substring(0,car);
	}
	
	
	
	public ILlamadasCliente setLlamadasCliente(String seq,String site,GregorianCalendar fecha
											  ,String telefono,GregorianCalendar diaHora,String swiRevisada
											  ,String idUsuarioMaquina,String nombre,String numExp,String swiVenta
											  ,String datosError){
/* si hay default en el xml hay que ponerle los insert="false" en esos campos */
		String vSeq = dameIdLlamadasCliente();
		if (vSeq!=null && telefono!=null && !telefono.equals("") && diaHora!=null && !site.equals("")){
			ILlamadasCliente lla=new LlamadasCliente();
			lla.setLlcSeq(vSeq);
			lla.setLlcSite(site);
			lla.setLlcFecha(null);
			if(fecha!=null){
				lla.setLlcFecha(fecha.getTime());
			}
			lla.setLlcTelefono(telefono);
			lla.setLlcDiaHora(diaHora.getTime());
			lla.setLlcSwirevisada(swiRevisada);
			lla.setLlcIdUsuarioMaquina(idUsuarioMaquina);
			lla.setLlcNombre(nombre);
			lla.setLlcNumexp(numExp);
			lla.setLlcSwiventa(swiVenta);
			lla.setLlcDatosError(datosError);
			Transaction tx = getSession().beginTransaction();
	    	tx.begin();
	    		getSession().save(lla);
			tx.commit();
			/*borran la cache del objeto, asi buscara de nuevo y pondra los valores default*/
			getSession().flush();
			getSession().clear();
			lla=(ILlamadasCliente) getSession().get(LlamadasCliente.class, lla.getLlcSeq());
			return lla;
		}else{
			return null;
		}
	}
	public ILlamadasCliente updateLlamadasCliente(ILlamadasCliente lla){
		ILlamadasCliente llaTmp = null;
		getSession().clear();
		llaTmp=(ILlamadasCliente) getSession().get(LlamadasCliente.class, lla.getLlcSeq());
		if (llaTmp!=null){
			llaTmp.setLlcSeq(lla.getLlcSeq());
			if(lla.getLlcSite()!=null){llaTmp.setLlcSite(lla.getLlcSite());}
			if(lla.getLlcFecha()!=null){llaTmp.setLlcFecha(lla.getLlcFecha());}
			if(lla.getLlcTelefono()!=null){llaTmp.setLlcTelefono(lla.getLlcTelefono());}
			if(lla.getLlcDiaHora()!=null){llaTmp.setLlcDiaHora(lla.getLlcDiaHora());}
			if(lla.getLlcSwirevisada()!=null){llaTmp.setLlcSwirevisada(lla.getLlcSwirevisada());}
			if(lla.getLlcIdUsuarioMaquina()!=null){llaTmp.setLlcIdUsuarioMaquina(lla.getLlcIdUsuarioMaquina());}
			if(lla.getLlcNombre()!=null){llaTmp.setLlcNombre(lla.getLlcNombre());}
			if(lla.getLlcNumexp()!=null){llaTmp.setLlcNumexp(lla.getLlcNumexp());}
			if(lla.getLlcSwiventa()!=null){llaTmp.setLlcSwiventa(lla.getLlcSwiventa());}
			if(lla.getLlcDatosError()!=null){llaTmp.setLlcDatosError(lla.getLlcDatosError());}
		}else{
			return null;
		}
		Transaction tx = getSession().beginTransaction();
    	tx.begin();
    		getSession().save(llaTmp);
		tx.commit();
		return llaTmp;
	}
	
	public ILlamadasCliente getLlamadasCliente (String seq){
		String sql;
		sql="select ";
		sql+="LLC_SEQ, LLC_SITE, LLC_FECHA, LLC_NOMBRE, LLC_TELEFONO, LLC_DIA_HORA, LLC_DATOS_ERROR, LLC_SWIVENTA, LLC_NUMEXP, LLC_SWIREVISADA, LLC_ID_USUARIO_MAQUINA";
		sql+=" from "; 
		sql+=" LLAMADAS_CLIENTE ";
		if (seq!=null && !seq.equalsIgnoreCase("")){
			sql+=" where LLC_SEQ='"+ seq +"'";
		}
		ArrayList<ILlamadasCliente> llamadas = (ArrayList<ILlamadasCliente>) getSession().createSQLQuery(sql).addEntity(LlamadasCliente.class).list();
		if (llamadas.size()>0){
			return llamadas.get(0);
		}
		return null;
	}
	public String dameIdLlamadasCliente(){
		String idClave = getQuery("select TO_CHAR(sysdate,'YYYYMMDD') RESULT  from dual");
		if(idClave==null){
			return null;
		}
		String seqAux = getQuery("select TRIM(TO_CHAR(LLC_SEQ.NEXTVAL,'000000000')) RESULT from dual");
		if(seqAux==null){
			return null;
		}
		
		return idClave+seqAux;
	}
	public ILlamadasClienteBusqueda setLlamadasClienteBusqueda(String seqBusqueda,String seqLlamada,GregorianCalendar fecha,String provinciaOrigen,String provinciaDestino,String idProducto ){
		if (seqBusqueda!=null && !seqBusqueda.equalsIgnoreCase("") && seqLlamada!=null && !seqLlamada.equalsIgnoreCase("") && idProducto!=null && !idProducto.equals("")){
			ILlamadasClienteBusqueda lla =  new LlamadasClienteBusqueda();
			lla.setLcbSeqbusqueda(seqBusqueda);
			lla.setLcbSeqllamada(seqLlamada);
			lla.setLcbVacIdprc(idProducto);
			lla.setLcbVacZonaOrigen(provinciaOrigen);
			lla.setLcbVacZonaDestino(provinciaDestino);
			Transaction tx = getSession().beginTransaction();
			tx.begin();
			getSession().save(lla);
			tx.commit();
			getSession().flush();
			getSession().clear();
			lla=(ILlamadasClienteBusqueda) getSession().get(LlamadasClienteBusqueda.class, lla.getLcbSeqbusqueda());
			return lla;
		}else{
			return null;
		}
	}
	public ILlamadasClienteBusqueda updateLlamadasClienteBusqueda(ILlamadasClienteBusqueda lla){
		ILlamadasClienteBusqueda llaTmp = null;
		getSession().clear();
		llaTmp=(ILlamadasClienteBusqueda) getSession().get(LlamadasClienteBusqueda.class,lla.getLcbSeqbusqueda());
		if (llaTmp!=null){
			llaTmp.setLcbSeqbusqueda(lla.getLcbSeqbusqueda());
			if(lla.getLcbVacZonaOrigen()!=null){llaTmp.setLcbVacZonaOrigen(lla.getLcbVacZonaOrigen());}
			if(lla.getLcbVacZonaDestino()!=null){llaTmp.setLcbVacZonaDestino(lla.getLcbVacZonaDestino());}
			if(lla.getLcbVacIdprc()!=null){llaTmp.setLcbVacIdprc(lla.getLcbVacIdprc());}
		}else{
			return null;
		}
		Transaction tx = getSession().beginTransaction();
		tx.begin();
		getSession().save(llaTmp);
		tx.commit();
		return llaTmp;
	}
		
	public ILlamadasClienteBusqueda getLlamadasClienteBusqueda (String seqBusqueda,String seqLlamada){
		String sql;
		sql="select ";
		sql+="LCB_SEQBUSQUEDA, LCB_SEQLLAMADA, LCB_FECHA_ALTA, LCB_IPCLIENTE, LCB_HOSTNAME, LCB_NAVEGADOR, LCB_ACCION, LCB_SITE, LCB_HOT_IDPRC, LCB_HOT_ZONA, LCB_HOT_FECHAINICIO, LCB_HOT_FECHAFIN, LCB_HOT_ADULTOS, LCB_HOT_NINOS, LCB_HOT_BEBES, LCB_HOT_CATEGORIA, LCB_HOT_REGIMEN, LCB_HOT_HABITACIONES, LCB_VUE_IDPRC, LCB_VUE_ZONA_ORIGEN, LCB_VUE_ZONA_DESTINO, LCB_VUE_FECHAINICIO, LCB_VUE_FECHAFIN, LCB_VUE_ADULTOS, LCB_VUE_NINOS, LCB_VUE_BEBES, LCB_VUE_SOLOIDA, LCB_VUE_COMPANIA, LCB_VUE_SOLOVUESDIRECTOS, LCB_COC_IDPRC, LCB_COC_ZONA_ORIGEN, LCB_COC_ZONA_DESTINO, LCB_COC_FECHAINICIO, LCB_COC_FECHAFIN, LCB_COC_VEHICULO, LCB_VAC_IDPRC, LCB_VAC_ZONA_ORIGEN, LCB_VAC_ZONA_DESTINO, LCB_VAC_FECHAINICIO, LCB_VAC_FECHAFIN, LCB_VAC_ADULTOS, LCB_VAC_NINOS, LCB_VAC_BEBES, LCB_VAC_CATEGORIA, LCB_VAC_REGIMEN, LCB_VAC_HABITACIONES, LCB_ESP_TIPO, LCB_ESP_EVENTO, LCB_VUE_HORAIDA, LCB_VUE_HORAVUELTA";
		sql+=" from "; 
		sql+=" LLAMADAS_CLIENTE_BUSQUEDA ";
		sql+=" where LCB_SEQBUSQUEDA='"+ seqBusqueda +"'";
		if(seqLlamada!=null){
			sql+=" and LCB_SEQLLAMADA='"+ seqLlamada +"'";
		}

		ArrayList<ILlamadasClienteBusqueda> llamadas = (ArrayList<ILlamadasClienteBusqueda>) getSession().createSQLQuery(sql).addEntity(LlamadasClienteBusqueda.class).list();
		if (llamadas.size()>0){
			return llamadas.get(0);
		}
		return null;
	}
	
	
	public ITrackingBusqueda setTrackingBusqueda(String provinciaOrigen,String provinciaDestino,String idProducto ){
		String vSeq = dameIdTrackingBusqueda();
		if (vSeq!=null  && idProducto!=null && !idProducto.equals("")){
			ITrackingBusqueda tra = new TrackingBusqueda();
			tra.setTbSeq(vSeq);
			tra.setTbVacIdprc(idProducto);
			tra.setTbVacZonaOrigen(provinciaOrigen);
			tra.setTbVacZonaDestino(provinciaDestino);
			Transaction tx = getSession().beginTransaction();
			tx.begin();
			getSession().save(tra);
			tx.commit();
			getSession().flush();
			getSession().clear();
			tra=(ITrackingBusqueda) getSession().get(TrackingBusqueda.class, tra.getTbSeq());
			return tra;
		}else{
			return null;
		}
	}
	public ITrackingBusqueda updateTrackingBusqueda(ITrackingBusqueda tra){
		ITrackingBusqueda traTmp = null;
		getSession().clear();
		traTmp=(ITrackingBusqueda) getSession().get(TrackingBusqueda.class,tra.getTbSeq());
		if (traTmp!=null){
			traTmp.setTbSeq(tra.getTbSeq());
			if(tra.getTbVacZonaOrigen()!=null){traTmp.setTbVacZonaOrigen(tra.getTbVacZonaOrigen());}
			if(tra.getTbVacZonaDestino()!=null){traTmp.setTbVacZonaDestino(tra.getTbVacZonaDestino());}
			if(tra.getTbVacIdprc()!=null){traTmp.setTbVacIdprc(tra.getTbVacIdprc());}
		}else{
			return null;
		}
		Transaction tx = getSession().beginTransaction();
		tx.begin();
		getSession().save(traTmp);
		tx.commit();
		return traTmp;
	}
		
	public ITrackingBusqueda getTrackingBusqueda (String seq){
		/*String sql;
		sql="select ";		
		sql+="TB_SEQ, TB_FECHA_ALTA, TB_VAC_IDPRC, TB_VAC_ZONA_ORIGEN, TB_VAC_ZONA_DESTINO";
		sql+=" from "; 
		sql+=" TRACKING_BUSQUEDA ";
		sql+=" where TB_SEQ='"+ seq +"'";*/

		ITrackingBusqueda tracks = (ITrackingBusqueda) getSession().get(TrackingBusqueda.class, seq);
		return tracks;
	}
	
	public String dameIdTrackingBusqueda(){
		String idClave = getQuery("select TO_CHAR(sysdate,'YYYYMMDD') RESULT  from dual");
		if(idClave==null){
			return null;
		}
		String seqAux = getQuery("select TRIM(TO_CHAR(SEQ_TRACKIN_BUSQUEDA.NEXTVAL,'000000000')) RESULT from dual");
		if(seqAux==null){
			return null;
		}
		
			return idClave+seqAux;
	}
	
	public ArrayList<IGenClasesMenu> getPepTipoPromoList(){
		Session ses = getSession();
		ArrayList<IGenClasesMenu> ret =(ArrayList<IGenClasesMenu>) ses.createQuery("from GenClasesMenu").list();
		return ret;
	}
		
	public ArrayList<IGenMenus> getGenMenus(int idClase) throws Exception, SQLException {
			ArrayList<IGenMenus> lista;
			String sql;
			sql="SELECT * FROM GEN_MENUS WHERE GMN_CLASE="+idClase;
			
			lista =(ArrayList<IGenMenus>) getSession().createSQLQuery(sql).addEntity(GenMenus.class).list();	
			
			return lista;
       }
	public ArrayList<IGenMenus> getGenMenusOpciones() throws Exception, SQLException{
		ArrayList<IGenMenus> lista;
		String sql;
		sql="SELECT * FROM GEN_MENUS WHERE GMN_ID NOT IN(SELECT   GMN_SUP FROM GEN_MENUS WHERE GMN_SUP IS NOT NULL)and gmn_clase=1 ORDER BY GMN_SUP,GMN_ORDER,GMN_ID";
		lista =(ArrayList<IGenMenus>) getSession().createSQLQuery(sql).addEntity(GenMenus.class).list();
		return lista;		
   }
	
	public IGenMenus setGenMenus(int id, String gmnDes, String gmnEtiqueta, String gmnTitle, String gmnUrl, String gmnVal, Integer gmnOrder, 
			int gmnClase, int gmnSup){
		Session ses = getSession();
		IGenMenus men = (IGenMenus) ses.get(GenMenus.class, id);
		if (men==null){
			men =new GenMenus();
		}
		if (id!=0){
			men.setId(id);
		}
		
		men.setGmnDes(gmnDes);
		men.setGmnEtiqueta(gmnEtiqueta);
		men.setGmnTitle(gmnTitle);
		men.setGmnUrl(gmnUrl);
		men.setGmnVal(gmnVal);
		men.setGmnOrder(gmnOrder);
		IGenClasesMenu clase = (IGenClasesMenu) ses.get(GenClasesMenu.class, gmnClase);
		men.setGmnClase(clase);
		IGenMenus pare = (IGenMenus) ses.get(GenMenus.class, gmnSup);
		men.setGmnSup(pare);
		
		Transaction tx = getSession().beginTransaction();
    	tx.begin();
		ses.saveOrUpdate(men);
		tx.commit();
		
		return men;
	}
	
	//cache 
	
	
	private ArrayList<IGenCache> getCache(String sql) throws Exception, SQLException {
		ArrayList<IGenCache> lista;
    	
		lista =(ArrayList<IGenCache>) getSession().createSQLQuery(sql).addEntity(GenCache.class).list();	

    	return lista;
       }

	public ArrayList<IGenCache> getCache(String id,GregorianCalendar calDesde,GregorianCalendar calHasta) throws SQLException, Exception{		
    	String desde;
    	//calDesde.set(Calendar.DAY_OF_MONTH);
    	desde = "'"+ calDesde.get(Calendar.YEAR) + "-"; 
    	desde = desde + (calDesde.get(Calendar.MONTH)+1) + "-"; 
    	desde = desde + calDesde.get(Calendar.DAY_OF_MONTH) + " " + calDesde.get(Calendar.HOUR_OF_DAY);
    	desde = desde + ":" + calDesde.get(Calendar.MINUTE) + ":" + calDesde.get(Calendar.SECOND);
    	desde = desde + "' ";
    	
    	String hasta;
    	//calHasta.set(Calendar.DAY_OF_MONTH);
    	hasta = "'"+ calHasta.get(Calendar.YEAR) + "-"; 
    	hasta = hasta + (calHasta.get(Calendar.MONTH)+1) + "-"; 
    	hasta = hasta + calHasta.get(Calendar.DAY_OF_MONTH) + " " + calHasta.get(Calendar.HOUR_OF_DAY);
    	hasta = hasta + ":" + calHasta.get(Calendar.MINUTE) + ":" + calHasta.get(Calendar.SECOND);
    	hasta = hasta + "' ";
    	
    	
		String sql;
    	
		sql="SELECT ";
		sql+="TRD_CRITERIA, TRD_DETALLE, TRD_TIMCRE ";
		sql+="FROM GEN_CACHE ";
		sql+="WHERE TRD_CRITERIA='" + id + "' AND TRD_TIMCRE>=" + desde + " AND TRD_TIMCRE<=" + hasta + "ORDER BY TRD_TIMCRE" ;
				    
    	ArrayList<IGenCache> lCDis=getCache(sql);
    	

		return lCDis;
	}
	public IGenCache getCacheById (String id){
		IGenCache cacheList = (IGenCache) getSession().get(GenCache.class, id);
		return cacheList;
	}
	public ArrayList<IGenCache> getCacheByIdLike (String id) throws SQLException, Exception{
		String sql = "SELECT ";
		sql+="TRD_CRITERIA, TRD_DETALLE, TRD_TIMCRE ";
		sql+="FROM GEN_CACHE ";
		sql+="WHERE TRD_CRITERIA like '%" + id + "%' " ;
		sql+="order by TRD_TIMCRE desc " ;
		
		ArrayList<IGenCache> cacheList =  getCache(sql);
		return cacheList;
	}

	public IGenCache setCache(String id,String toLob,GregorianCalendar cal) throws SQLException, Exception{		
    	IGenCache cache=getCacheById(id);
    	cache=cache==null?new  GenCache():cache;
    	Transaction tx = getSession().beginTransaction();
    	tx.begin();
    	cache.setId(id);
    	cache.setTrdDetalle(toLob);
    	cache.setTrdTimcre(cal.getTime());
    	getSession().saveOrUpdate(cache);
		 	
    	tx.commit();

		return cache;
	}
	
	public IGenTracking getTrackingById (String id){
		Session ses=getSession();
		IGenTracking res = (IGenTracking) ses.get(GenTracking.class, Integer.parseInt(id));
		return res;
	}
	public ArrayList<IGenTracking> getTracking (String gtrIdeses,String gtrTmpven,String gtrIdven,String gtrNumexp,String gtrOricla
			,String gtrOrimet,String gtrTipgtr) throws SQLException, Exception{
		Session ses=getSession();
		String sql = "SELECT * ";
		sql+="FROM GEN_TRACKING ";
		sql+="WHERE GTR_SEQ IS NOT NULL ";
		if(gtrIdeses!=null && !gtrIdeses.equalsIgnoreCase("")){
			sql+=" AND GTR_IDESES = '"+gtrIdeses+"'";
		}
		if(gtrTmpven!=null && !gtrTmpven.equalsIgnoreCase("")){
			sql+=" AND GTR_TMPVEN = '"+gtrTmpven+"'";
		}
		if(gtrIdven!=null && !gtrIdven.equalsIgnoreCase("")){
			sql+=" AND GTR_IDEVEN = '"+gtrIdven+"'";
		}
		if(gtrOricla!=null && !gtrOricla.equalsIgnoreCase("")){
			sql+=" AND GTR_ORICLA = '"+gtrOricla+"'";
		}
		if(gtrOrimet!=null && !gtrOrimet.equalsIgnoreCase("")){
			sql+=" AND GTR_ORIMET = '"+gtrOrimet+"'";
		}
		sql+="order by GTR_DATCRE desc " ;
		
		ArrayList<IGenTracking>  lista =(ArrayList<IGenTracking>) ses.createSQLQuery(sql).addEntity(GenTracking.class).list();	

		return lista;
	}
	
	public IGenTracking setTracking(String gtrIdeses,String gtrTmpven,String gtrIdven,String gtrNumexp,String gtrOricla,String gtrOrimet
			,String gtrDesgtr,String gtrTipgtr,String gtrDatos,String gtrNivel, String gtrMaquina, String gtrSite, String gtrLine) throws SQLException, Exception{
		Session ses = getSession();
		IGenTracking res = new GenTracking();
		res.setGtrIdeses(gtrIdeses);
		res.setGtrDatos(gtrDatos);
		res.setGtrDesgtr(gtrDesgtr);
		res.setGtrIdven(gtrIdven);
		res.setGtrNumexp(gtrNumexp);
		res.setGtrOricla(gtrOricla);
		res.setGtrOrimet(gtrOrimet);
		res.setGtrTipgtr(gtrTipgtr);
		res.setGtrTmpven(gtrTmpven);
		res.setGtrNivel(gtrNivel);
		res.setGtrMaquina(gtrMaquina);
		res.setGtrSite(gtrSite);
		res.setGtrLine(gtrLine);
		
		Transaction tx = getSession().beginTransaction();
    	tx.begin();
		ses.save(res);
		tx.commit();
		
		return res;
	}



	//********************************************************	Banners 01	******************************************************************//
	
	public ArrayList<IGenBanners01> getBanners01 (String idi) throws SQLException, Exception{
		if(staticBanners01==null){staticBanners01=new Hashtable<String,ArrayList<IGenBanners01>>();}
		
		ArrayList<IGenBanners01> ban=staticBanners01.get(idi);
		if (ban==null){
			ban = getBanners01();
			ArrayList<IGenJomfish> jf = getJomFish(idi,"banner");
			IGenBanners01 banner;
			for (int b=0;b<ban.size();b++){
				banner = ban.get(b);
				for (int j=0;j<jf.size();j++){
					if (jf.get(j).getReferenceId().equals(banner.getId())){
						if (jf.get(j).getReferenceField().equals("name")){
							banner.setName(jf.get(j).getValue());
							ban.set(b, banner);
							break;
						}
						if (jf.get(j).getReferenceField().equals("clickurl")){
							banner.setClickurl(jf.get(j).getValue());
							ban.set(b, banner);
							break;
						}
					}
					
				}
			}
			staticBanners01.put(idi, ban);
		}
		
		return ban;
	}

	private ArrayList<IGenBanners01> getBanners01 () throws SQLException, Exception{
				 
		ArrayList<IGenBanners01>  ret=	(ArrayList<IGenBanners01>) getSession().createQuery("from GenBanners01").list();
		

		return ret;
	}

	//********************************************************	JomFish	******************************************************************//
	
		public ArrayList<IGenJomfish> getJomFish (String idi, String table) throws SQLException, Exception{
					 
			Session ses=getSession();
			String sql = "SELECT * ";
			sql+="FROM GENV_JOMFISH ";
			sql+="WHERE shortcode ='"+idi+"' ";
			sql+="AND reference_table ='"+table+"' ";
			
			
			ArrayList<IGenJomfish>  lista =(ArrayList<IGenJomfish>) ses.createSQLQuery(sql).addEntity(GenJomfish.class).list();	

			return lista;
		}

	
	
}
