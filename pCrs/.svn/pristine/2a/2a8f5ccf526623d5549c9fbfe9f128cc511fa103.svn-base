package com.photel.data.BDL.ddbb;



import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.photel.commonServices.util.AppModelProperties;
import com.photel.data.BDL.ddbb.hibernate.HibernateSessionFactory;
import com.photel.data.BDL.ddbb.hibernate.pojo.*;
import com.photel.interfaces.data.BDL.*;


public class HelperHibernateDDBBGen<C> {
    private AppModelProperties properties;	
	public static ArrayList<IBdlConfig> staticConfig;
	public static ArrayList<IBdlConfigSite> staticConfigSite;
	private Logger  log = Logger.getRootLogger();
	
	private static String site;
	

	
	
	
	
	public HelperHibernateDDBBGen(String site) throws IOException {
		super();
		this.site = site;
		
		reloadStaticDDBB(site);
		
		properties = new AppModelProperties();
		if(staticConfig==null){loadGenConfig();}
		if(staticConfigSite==null){loadGenConfigSite();}
		
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
		loadGenConfigSite();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public static void loadGenConfig(){
		String sql;
		sql="SELECT BDL_PARAM,BDL_VALUE from BDL_CONFIG";
   		staticConfig =(ArrayList<IBdlConfig>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlConfig.class).list();	
	}
	

	public static void loadGenConfigSite(){
   		staticConfigSite = (ArrayList<IBdlConfigSite>) HibernateSessionFactory.getSession().createQuery("from BdlConfigSite").list(); 
   		
	}
	
	public ArrayList<IBdlConfigSite> getStaticConfigSite(String site)  {
		ArrayList<IBdlConfigSite> ret = new ArrayList<IBdlConfigSite>();
		if (staticConfigSite!=null){
			for(int i=0;i<staticConfigSite.size();i++){
				if (staticConfigSite.get(i).getId().getBdlSite()!=null && staticConfigSite.get(i).getId().getBdlSite().equalsIgnoreCase(site)){
					ret.add(staticConfigSite.get(i));
				}
			}
		}
		return ret;
	}
	
	public ArrayList<IBdlConfigSite> getStaticConfigSite() {
		return staticConfigSite;
	}

	public  ArrayList<IBdlConfig> getStaticConfig() {
		return staticConfig;
	}
	
	
	private void reloadResourcesFalse(){
		clearSession();
		BdlConfig config=(BdlConfig) getSession().get(BdlConfig.class, "reloadResources");
		if (config!=null && config.getBdlValue().equals("true")){
			config.setBdlValue("false");
			Transaction tx = getSession().beginTransaction();
			tx.begin();
			getSession().merge(config);
			tx.commit();
			
		}else{
			for (int i=0;i<staticConfig.size();i++){
				if(staticConfig.get(i).getId()!=null && staticConfig.get(i).getId().equalsIgnoreCase("reloadResources")){
					staticConfig.get(i).setBdlValue("false");
					break;
				}
			}
		}

	}
	private void reloadStaticDDBB(String site){
		IBdlConfigSitePK pk=new BdlConfigSitePK();
		pk.setBdlParam("reloadStatic");
		pk.setBdlSite(site);
		clearSession();
		BdlConfigSite config=(BdlConfigSite) getSession().get(BdlConfigSite.class, pk);
		if (config!=null && config.getBdlValue().equals("true")){
			init();
			config.setBdlValue("false");
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
	public String getPatam(String param){
		for (int i=0;i<staticConfig.size();i++){
			if (staticConfig.get(i).getId().equalsIgnoreCase(param)){
				return staticConfig.get(i).getBdlValue();
			}
		}
		return "";
		
	}
	public int truncate(String className)  { 
		Transaction tx = getSession().beginTransaction();
    	tx.begin();
		Session s = getSession(); 
	    int rowsAffected = 0; 
	    String hql = "delete from " + className; 
	    Query q = s.createQuery( hql ); 
	    rowsAffected = q.executeUpdate();
	    tx.commit();
	    
	    log.info(className + " truncated with " + rowsAffected + "rows affected");
	    return rowsAffected; 
	} 

	//********************************************************	Languages	******************************************************************//
	public IBdlLanguages getLanguage(String code){
		IBdlLanguages lan=(BdlLanguages) getSession().get(BdlLanguages.class, code);
		return lan;
	}
	public ArrayList<IBdlLanguages> getLanguages(){
		ArrayList<IBdlLanguages> lan=(ArrayList<IBdlLanguages>) HibernateSessionFactory.getSession().createQuery("from BdlLanguages").list(); 
		return lan;
	}
	public IBdlLanguages setLanguage(String code, String description){
		IBdlLanguages lan=null;
		if (code!=null && description!=null){
			Transaction tx = getSession().beginTransaction();
	    	tx.begin();
	    	lan = new BdlLanguages();
			lan.setId(code);
			lan.setBdlDescription(description);
			getSession().saveOrUpdate(lan);
	    	tx.commit();
		}
		return lan;
	}
	
	public boolean delLanguage(String code){
		boolean ret;
		IBdlLanguages lan=(BdlLanguages) getSession().get(BdlLanguages.class, code);
		if (lan!=null){
			Transaction tx = getSession().beginTransaction();
	    	tx.begin();
	    	getSession().delete(lan);
	    	tx.commit();
	    	ret=true;
		}else{
			ret=false;
		}
		return ret;
	}


	
	//********************************************************	Countries	******************************************************************//
		public IBdlCountries getCountry(String code, String idi){
			IBdlCountriesPK pk=new BdlCountriesPK();
			pk.setBdlCode(code);
			pk.setBdlIdi(idi);
			IBdlCountries obj=(BdlCountries) getSession().get(BdlLanguages.class, pk);
			return obj;
		}
		public ArrayList<IBdlCountries> getCountries(){
			ArrayList<IBdlCountries> obj=(ArrayList<IBdlCountries>) HibernateSessionFactory.getSession().createQuery("from BdlCountries").list(); 
			return obj;
		}
		public IBdlCountries setCountry(String code, String idi, String description){
			IBdlCountries obj=null;
			if (code!=null && idi!=null && description!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	obj = new BdlCountries();
		    	IBdlCountriesPK pk=new BdlCountriesPK();
				pk.setBdlCode(code);
				pk.setBdlIdi(idi);
		    	obj.setId(pk);
		    	obj.setBdlDescription(description);
				getSession().saveOrUpdate(obj);
		    	tx.commit();
			}
			return obj;
		}
		
		public boolean delCountry(String code, String idi){
			boolean ret;
			
			IBdlCountries obj=getCountry(code, idi);
			if (obj!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	getSession().delete(obj);
		    	tx.commit();
		    	ret=true;
			}else{
				ret=false;
			}
			return ret;
		}
		//********************************************************	Destinations	******************************************************************//
		public IBdlDestinations getDestination(String code, String idi){
			IBdlDestinationsPK pk=new BdlDestinationsPK();
			pk.setBdlCode(code);
			pk.setBdlIdi(idi);
			IBdlDestinations obj=(BdlDestinations) getSession().get(BdlDestinations.class, pk);
			return obj;
		}
		public ArrayList<IBdlDestinations> getDestinations(){
			ArrayList<IBdlDestinations> obj=(ArrayList<IBdlDestinations>) HibernateSessionFactory.getSession().createQuery("from BdlDestinations").list(); 
			return obj;
		}
		public ArrayList<IBdlDestinations> getDestinations(String languageCode){
			String sql;
			sql="select * from bdl_destinations ";
			sql+="where BDL_IDI='"+languageCode+"' ";
			
			ArrayList<IBdlDestinations> ret = (ArrayList<IBdlDestinations>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlDestinations.class).list();
			return ret;
		}
		public ArrayList<IBdlDestinations> getHotelFromDestination(String languageCode){
			String sql;
			sql="select * from bdl_destinations ";
			sql+="where BDL_IDI='"+languageCode+"' ";
			
			ArrayList<IBdlDestinations> ret = (ArrayList<IBdlDestinations>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlDestinations.class).list();
			return ret;
		}
		public IBdlDestinations setDestination(String code, String idi, String description){
			IBdlDestinations obj=null;
			if (code!=null && idi!=null && description!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	obj = new BdlDestinations();
		    	IBdlDestinationsPK pk=new BdlDestinationsPK();
				pk.setBdlCode(code);
				pk.setBdlIdi(idi);
		    	obj.setId(pk);
		    	obj.setBdlDescription(description);
				getSession().saveOrUpdate(obj);
		    	tx.commit();
			}
			return obj;
		}
		
		public boolean delDestination(String code, String idi){
			boolean ret;
			
			IBdlDestinations obj=getDestination(code, idi);
			if (obj!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	getSession().delete(obj);
		    	tx.commit();
		    	ret=true;
			}else{
				ret=false;
			}
			return ret;
		}
	
		//********************************************************	Hotel Destinations	******************************************************************//
		public IBdlHotelDestinations getHotelDestination(String countryCode, String destinationCode){
			IBdlHotelDestinationsPK pk=new BdlHotelDestinationsPK();
			pk.setBdlCountryCode(countryCode);
			pk.setBdlDestinationCode(destinationCode);
			IBdlHotelDestinations obj=(BdlHotelDestinations) getSession().get(BdlHotelDestinations.class, pk);
			return obj;
		}
		public ArrayList<IBdlHotelDestinations> getHotelDestinations(){
			ArrayList<IBdlHotelDestinations> obj=(ArrayList<IBdlHotelDestinations>) HibernateSessionFactory.getSession().createQuery("from BdlHotelDestinations").list(); 
			return obj;
		}
		public IBdlHotelDestinations setHotelDestination(String countryCode, String destinationCode){
			IBdlHotelDestinations obj=null;
			if (countryCode!=null && destinationCode!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	obj = new BdlHotelDestinations();
		    	IBdlHotelDestinationsPK pk=new BdlHotelDestinationsPK();
		    	pk.setBdlCountryCode(countryCode);
				pk.setBdlDestinationCode(destinationCode);
		    	obj.setId(pk);
				getSession().saveOrUpdate(obj);
		    	tx.commit();
			}
			return obj;
		}
		
		public boolean delHotelDestination(String countryCode, String destinationCode){
			boolean ret;
			
			IBdlHotelDestinations obj=getHotelDestination(countryCode, countryCode);
			if (obj!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	getSession().delete(obj);
		    	tx.commit();
		    	ret=true;
			}else{
				ret=false;
			}
			return ret;
		}
		
		//********************************************************	Destinations	******************************************************************//
		public IBdlHotelDescriptions getHotelDescription(String code, String idi){
			IBdlHotelDescriptionsPK pk=new BdlHotelDescriptionsPK();
			pk.setBdlCode(code);
			pk.setBdlIdi(idi);
			IBdlHotelDescriptions obj=(BdlHotelDescriptions) getSession().get(BdlHotelDescriptions.class, pk);
			return obj;
		}
		public ArrayList<IBdlHotelDescriptions> getHotelsDescriptions(){
			ArrayList<IBdlHotelDescriptions> obj=(ArrayList<IBdlHotelDescriptions>) HibernateSessionFactory.getSession().createQuery("from BdlHotelDescriptions").list(); 
			return obj;
		}
		public IBdlHotelDescriptions setHotelDescription(String code, String idi, String description){
			IBdlHotelDescriptions obj=null;
			if (code!=null && idi!=null && description!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	obj = new BdlHotelDescriptions();
		    	IBdlHotelDescriptionsPK pk=new BdlHotelDescriptionsPK();
				pk.setBdlCode(code);
				pk.setBdlIdi(idi);
		    	obj.setId(pk);
		    	obj.setBdlDescription(description);
				getSession().saveOrUpdate(obj);
		    	tx.commit();
			}
			return obj;
		}
		
		public boolean delHotelDescription(String code, String idi){
			boolean ret;
			
			IBdlHotelDescriptions obj=getHotelDescription(code, idi);
			if (obj!=null){
				Transaction tx = getSession().beginTransaction();
		    	tx.begin();
		    	getSession().delete(obj);
		    	tx.commit();
		    	ret=true;
			}else{
				ret=false;
			}
			return ret;
		}
		
		public ArrayList<IBdlHotelDescriptions> getHotelsDescriptions(ArrayList<String> codes, String idi){
			ArrayList<IBdlHotelDescriptions> ret=null;
			String sql;
			String strCodes="";
			if (codes!=null && codes.size()>0){
				for (int i=0;i<codes.size();i++){
					strCodes+="'"+codes.get(i)+"',";
				}
				strCodes=strCodes.substring(0, strCodes.length()-1);
				sql="select * from bdl_hotels_descriptions ";
				sql+="where BDL_IDI='"+idi+"' ";
				sql+="and BDL_CODE in ("+strCodes+")";
				
		   		ret = (ArrayList<IBdlHotelDescriptions>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlHotelDescriptions.class).list();
			}
	   		return ret;
		}
		//********************************************************	Detail Descriptions	******************************************************************//
		public IBdlHdetailDescriptions getHDetailDescription(String hotelCode, String languageCode){
			IBdlHdetailDescriptionsPK pk=new BdlHdetailDescriptionsPK();
			pk.setHotelCode(hotelCode);
			pk.setLanguageCode(languageCode);
			IBdlHdetailDescriptions obj=(IBdlHdetailDescriptions) getSession().get(BdlHdetailDescriptions.class, pk);
			return obj;
		}

		
		public ArrayList<IBdlHdetailDescriptions> getHDetailDescriptions(ArrayList<String> codes, String LanguageCode){
			ArrayList<IBdlHdetailDescriptions> ret=null;
			String sql;
			String strCodes="";
			if (codes!=null && codes.size()>0){
				for (int i=0;i<codes.size();i++){
					strCodes+="'"+codes.get(i)+"',";
				}
				strCodes=strCodes.substring(0, strCodes.length()-1);
				sql="select * from bdlv_hdetail_descriptions ";
				sql+="where LanguageCode='"+LanguageCode+"' ";
				sql+="and HotelCode in ("+strCodes+")";
				
		   		ret = (ArrayList<IBdlHdetailDescriptions>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlHdetailDescriptions.class).list();
			}
	   		return ret;
		}
		//********************************************************	Detail Images	******************************************************************//
				public IBdlvHimages getHDetailImage(String hotelCode, String languageCode, String imagecode, String order){
					IBdlvHimagesPK pk=new BdlvHimagesPK();
					pk.setHotelCode(hotelCode);
					pk.setLanguagecode(languageCode);
					pk.setImagecode(imagecode);
					pk.setOrder(order);
					IBdlvHimages obj=(IBdlvHimages) getSession().get(BdlvHimages.class, pk);
					return obj;
				}

				
				public ArrayList<IBdlvHimages> getHDetailImages(ArrayList<String> codes, String LanguageCode){
					ArrayList<IBdlvHimages> ret=null;
					String sql;
					String strCodes="";
					if (codes!=null && codes.size()>0){
						for (int i=0;i<codes.size();i++){
							strCodes+="'"+codes.get(i)+"',";
						}
						strCodes=strCodes.substring(0, strCodes.length()-1);
						sql="select * from bdlv_himages ";
						sql+="where LanguageCode='"+LanguageCode+"' ";
						sql+="and HotelCode in ("+strCodes+") ";
						sql+="order by VISUALIZATIONORDER";
						
				   		ret = (ArrayList<IBdlvHimages>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlvHimages.class).list();
					}
			   		return ret;
				}
				
				public Hashtable<String,ArrayList<IBdlvHimages>> getHDetailImagesGrouped(String hotelCode, String LanguageCode) {
					ArrayList<String> codes=new ArrayList<String>();
					codes.add(hotelCode);
					Hashtable<String,ArrayList<IBdlvHimages>>  ret=new Hashtable<String,ArrayList<IBdlvHimages>>();
					ArrayList<IBdlvHimages> fac = getHDetailImages(codes, LanguageCode);
					if (fac!=null){
						for (int i=0;i<fac.size();i++){
							String key=fac.get(i).getId().getImagecode()+"+"+fac.get(i).getName();
							ArrayList<IBdlvHimages> obj = ret.get(key);
							obj=obj==null?new ArrayList<IBdlvHimages>():obj;
							obj.add(fac.get(i));
							ret.put(key, obj);
						}
					}
					
					return ret;
				}
				
				//********************************************************	Detail Facilities	******************************************************************//
				public IBdlvHdetailFacilities getHDetailFacility(String hotelCode, String code, String groupCode, String languageCode){
					IBdlvHdetailFacilitiesPK pk=new BdlvHdetailFacilitiesPK();
					pk.setHotelCode(hotelCode);
					pk.setLanguagecode(languageCode);
					pk.setCode(code);
					pk.setGroup(groupCode);
					IBdlvHdetailFacilities obj=(IBdlvHdetailFacilities) getSession().get(BdlvHdetailFacilities.class, pk);
					return obj;
				}

				
				public ArrayList<IBdlvHdetailFacilities> getHDetailFacilites(ArrayList<String> codes, String LanguageCode){
					ArrayList<IBdlvHdetailFacilities> ret=null;
					String sql;
					String strCodes="";
					if (codes!=null && codes.size()>0){
						for (int i=0;i<codes.size();i++){
							strCodes+="'"+codes.get(i)+"',";
						}
						strCodes=strCodes.substring(0, strCodes.length()-1);
						sql="select * from bdlv_hdetail_facilities ";
						sql+="where LanguageCode='"+LanguageCode+"' ";
						sql+="and HotelCode in ("+strCodes+")";
						
				   		ret = (ArrayList<IBdlvHdetailFacilities>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlvHdetailFacilities.class).list();
					}
			   		return ret;
				}
				
				public Hashtable<String,ArrayList<IBdlvHdetailFacilities>> getHDetailFacilitesGrouped(String hotelCode, String LanguageCode) {
					ArrayList<String> codes=new ArrayList<String>();
					codes.add(hotelCode);
					Hashtable<String,ArrayList<IBdlvHdetailFacilities>>  ret=new Hashtable<String,ArrayList<IBdlvHdetailFacilities>>();
					ArrayList<IBdlvHdetailFacilities> fac = getHDetailFacilites(codes, LanguageCode);
					if (fac!=null){
						for (int i=0;i<fac.size();i++){
							String key=fac.get(i).getId().getGroup()+"-"+fac.get(i).getGroupdes();
							ArrayList<IBdlvHdetailFacilities> obj = ret.get(key);
							obj=obj==null?new ArrayList<IBdlvHdetailFacilities>():obj;
							obj.add(fac.get(i));
							ret.put(key, obj);
						}
					}
					
					return ret;
				}
				public Hashtable<String,ArrayList<IBdlvHdetailFacilities>> getHDetailFacilitesGrouped(ArrayList<String> hotelCodes, String LanguageCode) {
					Hashtable<String,ArrayList<IBdlvHdetailFacilities>>  ret=new Hashtable<String,ArrayList<IBdlvHdetailFacilities>>();
					ArrayList<IBdlvHdetailFacilities> fac = getHDetailFacilites(hotelCodes, LanguageCode);
					if (fac!=null){
						for (int i=0;i<fac.size();i++){
							String key=fac.get(i).getId().getGroup()+"-"+fac.get(i).getGroupdes();
							ArrayList<IBdlvHdetailFacilities> obj = ret.get(key);
							obj=obj==null?new ArrayList<IBdlvHdetailFacilities>():obj;
							obj.add(fac.get(i));
							ret.put(key, obj);
						}
					}
					
					return ret;
				}
				
				public ArrayList<String> getHDetailDispoFacilites(ArrayList<String> codes, String LanguageCode){
					ArrayList<String> ret=null;
					String sql;
					String strCodes="";
					if (codes!=null && codes.size()>0){
						for (int i=0;i<codes.size();i++){
							strCodes+="'"+codes.get(i)+"',";
						}
						strCodes=strCodes.substring(0, strCodes.length()-1);
						sql="select FACILITIE from (  ";
						sql+="select concat(GROUP_,'##',CODE,'##',ORDER_,'##',GROUPDES,'##',NAME) FACILITIE, GROUP_,CODE,GROUPDES,NAME from bdlv_hdetail_facilities  ";
						sql+="where LanguageCode='"+LanguageCode+"' ";
						sql+="and HotelCode in ("+strCodes+") AND LOGIC='S' ";
						sql+="GROUP BY GROUP_,CODE,ORDER_,GROUPDES,NAME ";
						sql+=" )a order by GROUP_, NAME";
				   		ret = (ArrayList<String>) HibernateSessionFactory.getSession().createSQLQuery(sql).addScalar("FACILITIE").list();
					}
			   		return ret;
				}
				
								
				public Hashtable<String,ArrayList<String>> getHDetailFacilitesDispoGrouped(ArrayList<String> hotelCodes, String LanguageCode) {
					Hashtable<String,ArrayList<String>>  ret=new Hashtable<String,ArrayList<String>>();
					ArrayList<String> fac = getHDetailDispoFacilites(hotelCodes, LanguageCode);
					if (fac!=null){
						for (int i=0;i<fac.size();i++){
							String[] values=fac.get(i).split("##");
							String key=values[0]+"-"+values[3];
							ArrayList<String> obj = ret.get(key);
							obj=obj==null?new ArrayList<String>():obj;
							obj.add(fac.get(i));
							ret.put(key, obj);
						}
					}
					
					return ret;
				}
		//********************************************************	Reservas	******************************************************************//
				public IBdlReservas getReserva(int idReserva){
					IBdlReservas obj=(BdlReservas) getSession().get(BdlReservas.class, idReserva);
					if(obj==null){
						obj=new BdlReservas();
					}
					return obj;
				}
				public ArrayList<IBdlReservas> getReservas(){
					ArrayList<IBdlReservas> obj=(ArrayList<IBdlReservas>) HibernateSessionFactory.getSession().createQuery("from BdlReservas").list(); 
					return obj;
				}

				public IBdlReservas setReserva(IBdlReservas res){
					/*
					if (res.getBdlTimcre()==null){
						Date bdlTimcre=(new GregorianCalendar()).getTime();
						res.setBdlTimcre(bdlTimcre);
					}
					*/
					Transaction tx = getSession().beginTransaction();
			    	tx.begin();
					getSession().saveOrUpdate(res);
			    	tx.commit();
					return res;
				}
				
				public boolean delReserva(IBdlReservas res){
					boolean ret;
					
					IBdlReservas obj=getReserva(res.getId());
					if (obj!=null){
						Transaction tx = getSession().beginTransaction();
				    	tx.begin();
				    	getSession().delete(res);
				    	tx.commit();
				    	ret=true;
					}else{
						ret=false;
					}
					return ret;
				}
				
				
				public IBdlReservas getUltimaFactura(){
					IBdlReservas ret=null;
					String sql;
					sql="select * from bdl_reservas ";
					sql+="where BDL_FACTURA_NUMERO is not null ";
					sql+="order by BDL_FACTURA_NUMERO desc ";
					sql+="limit 1 ";
						
				   	ArrayList<IBdlReservas> obj = (ArrayList<IBdlReservas>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlReservas.class).list();
				   	if (obj!=null && obj.size()>0){
				   		ret=obj.get(0);
				   	}
				   	return ret;
				}
				
				//********************************************************	Reservas Mails	******************************************************************//
				public IBdlReservasMails getReservaMail(int idReservaMail){
					IBdlReservasMails obj=(BdlReservasMails) getSession().get(BdlReservasMails.class, idReservaMail);
					if(obj==null){
						obj=new BdlReservasMails();
					}
					return obj;
				}
				public ArrayList<IBdlReservasMails> getReservasMails(){
					ArrayList<IBdlReservasMails> obj=(ArrayList<IBdlReservasMails>) HibernateSessionFactory.getSession().createQuery("from BdlReservasMails").list(); 
					return obj;
				}
				public ArrayList<IBdlReservasMails> getReservasMails(int idReserva){
					String sql;
					sql="select * from bdl_reservas_mails ";
					sql+="where BDL_ID_RESERVA ="+ idReserva;
						
				   	ArrayList<IBdlReservasMails> obj = (ArrayList<IBdlReservasMails>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlReservasMails.class).list();
					return obj;
				}

				public IBdlReservasMails setReservaMails(IBdlReservasMails res){
					/*
					if (res.getBdlTimcre()==null){
						Date bdlTimcre=(new GregorianCalendar()).getTime();
						res.setBdlTimcre(bdlTimcre);
					}
					*/
					Transaction tx = getSession().beginTransaction();
			    	tx.begin();
					getSession().saveOrUpdate(res);
			    	tx.commit();
					return res;
				}
				
				public boolean delReservaMails(IBdlReservasMails res){
					boolean ret;
					
					IBdlReservasMails obj=getReservaMail(res.getId());
					if (obj!=null){
						Transaction tx = getSession().beginTransaction();
				    	tx.begin();
				    	getSession().delete(res);
				    	tx.commit();
				    	ret=true;
					}else{
						ret=false;
					}
					return ret;
				}
				
				//********************************************************	Hotels	******************************************************************//
				public IBdlHotels getHotel(String code){
					IBdlHotels obj=(IBdlHotels) getSession().get(BdlHotels.class, code);
					if (obj==null){
						obj = new BdlHotels();
					}
					return obj;
				}
				public ArrayList<IBdlHotels> getDestinationHotels(String destination){
					String sql="select * from bdl_hotels ";
					sql+="where BDL_DESTINATION='"+destination+"' ";
					
					ArrayList<IBdlHotels>  obj = (ArrayList<IBdlHotels>) HibernateSessionFactory.getSession().createSQLQuery(sql).addEntity(BdlHotels.class).list();
					return obj;
				}
				
				public IBdlHotels setHotel(IBdlHotels hotel){
					if (hotel.getId()!=null){
  	
				    	Transaction tx = getSession().beginTransaction();
				    	tx.begin();
						getSession().saveOrUpdate(hotel);
				    	tx.commit();
					}
					return hotel;
				}

				public IBdlHotels setHotel(String code, String bdlName, String bdlCat, String bdlDestination, String bdlZone, String bdlChain, String bdlLicence, String bdlLatitude, String bdlLongitude){
						IBdlHotels hotel=getHotel(code);
						if(hotel.getId()==null){
							hotel.setId(code);
						}
						
						hotel.setBdlName(bdlName);
						hotel.setBdlCat(bdlCat);
						hotel.setBdlDestination(bdlDestination);
						hotel.setBdlZone(bdlZone);
						hotel.setBdlChain(bdlChain);
						hotel.setBdlLicence(bdlLicence);
						hotel.setBdlLatitude(bdlLatitude);
						hotel.setBdlLongitude(bdlLongitude);
							
							
				    	Transaction tx = getSession().beginTransaction();
				    	tx.begin();
						getSession().saveOrUpdate(hotel);
				    	tx.commit();
				    	return hotel;
				}
				
				public boolean delHotel(String code){
					boolean ret;
					
					IBdlHotels obj=getHotel(code);
					if (obj!=null){
						Transaction tx = getSession().beginTransaction();
				    	tx.begin();
				    	getSession().delete(obj);
				    	tx.commit();
				    	ret=true;
					}else{
						ret=false;
					}
					return ret;
				}
				
				
				
}
