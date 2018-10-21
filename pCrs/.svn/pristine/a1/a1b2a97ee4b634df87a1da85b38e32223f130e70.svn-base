package com.photel.model.gen.facade;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.Map.Entry;

import javax.naming.directory.Attributes;
import javax.xml.rpc.ServiceException;

import org.hibernate.Session;

import com.photel.commonServices.thread.ThreadBase;
import com.photel.commonServices.thread.ThreadException;
import com.photel.commonServices.thread.ThreadManager;
import com.photel.commonServices.util.SerializableHelper;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.data.gen.facade.GenFacade;
import com.photel.interfaces.data.gen.*;
import com.photel.interfaces.model.gen.listas.ILista;
import com.photel.interfaces.model.gen.sesion.ISesion;
import com.photel.mail.facade.MailFacade;
import com.photel.model.gen.helpers.LDAPFactory;
import com.photel.model.gen.objects.Lista;
import com.photel.model.gen.objects.Sesion;




public class ModelGenFacade  {
	private GenFacade gen;
	private Hashtable<String,String> genConfig;
	private MailFacade mail;
	private String site;
	private LDAPFactory ldap;
	private ArrayList<IGenScripts> scripts;
	private ArrayList<IGenStyles> styles;
	private ArrayList<IGenImages> images;
	private ThreadBase trackingThread;
	
	public ModelGenFacade(Hashtable initParams) throws SQLException, Exception{
		site=(String) initParams.get("SITE");
		init(initParams);
	}
	public ModelGenFacade(String site) throws SQLException, Exception{
		Hashtable initParams=new Hashtable();
		this.site=site;
		init(initParams);
	}

	
	public void clearSession(){
		gen.clearSession();
		mail.clearSession();
	}
	public void init(Hashtable initParams) throws SQLException, Exception{
		this.gen=new GenFacade(site);
		
		ArrayList<IGenConfig> con = this.getGenConfig(true);
		ArrayList<IGenConfigSite> conSite = gen.getStaticConfigSite(site);
		genConfig=new Hashtable<String,String>();
		for (int i=0;i<con.size();i++){
			if (con.get(i).getId()!=null && con.get(i).getTrnValue()!=null){
				genConfig.put(con.get(i).getId(),con.get(i).getTrnValue());
			}
		}
		for (int i=0;i<conSite.size();i++){
			if (conSite.get(i).getId()!=null && conSite.get(i).getGenValue()!=null){
				genConfig.put(conSite.get(i).getId().getGenParam(),conSite.get(i).getGenValue());
			}
		}
		//Mail
		String smtpHost=this.genConfig.get("smtpHost");
		String smtpPort=this.genConfig.get("smtpPort");
		String smtpUser=this.genConfig.get("smtpUser");
		String smtpPassword=this.genConfig.get("smtpPassword");
		String smtpFromReservas=this.genConfig.get("smtpFromReservas");
		this.mail=new MailFacade(smtpHost,smtpPort,smtpUser,smtpPassword,smtpFromReservas);
		
		//LDAP
		String ldapHost=this.genConfig.get("ldapHost");
		String ldapPort=this.genConfig.get("ldapPort");
		String ldapDomain=this.genConfig.get("ldapDomain");
		if(ldapHost!=null && ldapPort!=null && ldapDomain!=null ){
			ldap=new LDAPFactory(ldapHost,ldapPort,ldapDomain);
		}
		

	}


	public ISesion getGenSesion(String idSesion) throws SQLException, Exception{
		String id;
		
		boolean isValidSession=(idSesion!=null && idSesion.compareToIgnoreCase("")!=0 && idSesion.split("_").length==2);
		id=isValidSession? idSesion.split("_")[1]:"-1";
		
		GregorianCalendar cal = getCal();
		IGenSesiones d;
		if (!isValidSession){
			d = gen.getGenSesiones(null,idSesion,cal);
		}else{
			d = gen.getGenSesiones(id,idSesion,cal);
		}
		Hashtable<String,Object> objSesion = null;
		//SerializableHelper help= new SerializableHelper();
		if(d.getGseSesion()!=null && !d.getGseSesion().equalsIgnoreCase("")){
			objSesion = (Hashtable<String, Object>) SerializableHelper.unserialize(d.getGseSesion());
		}
		ISesion beanSesion = new Sesion();
		beanSesion.setId(String.valueOf(d.getGseIdSesion()));
		beanSesion.setSesion(objSesion);
		return beanSesion;
		
	}
	public boolean isSessionInDDBB(String idSesion) throws SQLException, Exception{
		String id;
		
		boolean isValidSession=(idSesion!=null && idSesion.compareToIgnoreCase("")!=0 && idSesion.split("_").length==2);
		id=isValidSession? idSesion.split("_")[1]:"-1";
		
		GregorianCalendar cal = getCal();
		IGenSesiones d;
		if (!isValidSession){
			boolean create=false;
			d = gen.getGenSesiones(null,idSesion,cal,create);
		}else{
			boolean create=false;
			d = gen.getGenSesiones(id,idSesion,cal,create);
		}

		return d==null?false:true;
		
	}
	
	public void delSession(String idSesion) throws SQLException, Exception {
		String id;
		
		boolean isValidSession=(idSesion!=null && idSesion.compareToIgnoreCase("")!=0 && idSesion.split("_").length==2);
		id=isValidSession? idSesion.split("_")[1]:"-1";
		
		GregorianCalendar cal = getCal();
		IGenSesiones d;
		if (!isValidSession){
			gen.delSession(null,idSesion,cal);
		}else{
			gen.delSession(id,idSesion,cal);
		}
	}
	public void setGenSesion(String idSesion, Hashtable<String,Object> sesion) throws SQLException, Exception{
		//SerializableHelper help= new SerializableHelper();
		String strSesion = null;
		if(sesion!=null){
			strSesion = SerializableHelper.serialize(sesion);
		}
		String id = idSesion.split("_")[1];
		gen.setGenSesiones(id, idSesion, strSesion);
		
	}
	private GregorianCalendar getCal(){
		GregorianCalendar cal = new GregorianCalendar();
		String d = this.genConfig.get("tiempoCacheSesion");//this.config.get("tiempoCacheMinutosRenfe");
		if(d.compareToIgnoreCase("0")==0){
			return null;
		}
		cal.add(Calendar.MINUTE, -Integer.parseInt(d));
		return cal;
	}
	
	
	public Hashtable<String,StringBuffer> getGeneralResources() throws SQLException, Exception{
		Hashtable<String,StringBuffer> ret=new Hashtable<String,StringBuffer>();
		ArrayList<IGenLanResource> res = this.getGenResources();
		ArrayList<IGenLanresourceSite> resSite = gen.getStaticResourcesSite(site);
		String idi;
		StringBuffer lang;
		String prefijo=this.getGenConfig().get("ResourcesPrefijoDatos");
		if (prefijo!=null){
			Hashtable<String,String> data=new Hashtable<String,String>();
			for (int i=0;i<res.size();i++){
				idi = res.get(i).getId().getTrlLang();
				data.put(res.get(i).getId().getTrlLang()+"##"+res.get(i).getId().getTrlRes(), res.get(i).getTrlDes());
			}
			for (int i=0;i<resSite.size();i++){
				data.put(resSite.get(i).getId().getGenLang()+"##"+resSite.get(i).getId().getGenRes(), resSite.get(i).getGenDes());
			}
			Iterator<Entry<String, String>> set = data.entrySet().iterator();
			Entry<String, String> elem;
			String[] key;
			while (set.hasNext()){
				elem = set.next();
				key = elem.getKey().split("##");
				idi = key[0];
				lang = ret.get(idi);
				if (lang==null){
					lang=new StringBuffer();}
				lang.append(prefijo+key[1] + "=" + elem.getValue() + "\n");
				ret.put(idi, lang);
			}
		}
		return ret;
		
	}

	public Hashtable<String, String> getHashResources(String idioma) throws SQLException, Exception{
		Hashtable<String,String> ret=new Hashtable<String,String>();
		ArrayList<IGenLanResource> res = this.getGenResources();
		ArrayList<IGenLanresourceSite> resSite = gen.getStaticResourcesSite(site);
		String idi;
		StringBuffer lang;
		String prefijo=this.getGenConfig().get("ResourcesPrefijoDatos");
		if (prefijo!=null){
			for (int i=0;i<res.size();i++){
				idi = res.get(i).getId().getTrlLang();
				if (idioma.equals(idi)){
					ret.put(prefijo+res.get(i).getId().getTrlRes(), res.get(i).getTrlDes());
				}
			}
			for (int i=0;i<resSite.size();i++){
				idi = resSite.get(i).getId().getGenLang();
				if (idioma.equals(idi)){
					ret.put(prefijo+resSite.get(i).getId().getGenRes(), resSite.get(i).getGenDes());
				}
			}
		}
		return ret;
	}
	public ArrayList<ILista> getGenericList(ArrayList<String> in){
		ILista lista;
		ArrayList<ILista> ret=new ArrayList<ILista>();
		for (int i=0;i<in.size();i++){
			lista=new Lista();
			lista.setKey(in.get(i));
			lista.setValue(in.get(i));
			ret.add(lista);
		}
		return ret;
	}
	
	
	public ArrayList<IMenu> convertMenusToHttps(ArrayList<IMenu> menus){
		IMenu menu;
		String xmlMenu;
		Object obj;
		String from;
		String to;
		String[] dom;
		String[] val;
		String dominios=this.getGenConfig().get("dominiosToExcludeMenu");
		if (dominios!=null){
			for (int i=0;i<menus.size();i++){
				menu = menus.get(i);
				xmlMenu = XMLStreamUtil.xmlSaveObject(menu);
				dom = dominios.split("@@");
				for (int m=0;m<dom.length;m++){
					val = dom[m].split("##");
					from=val[0];
					to="";
					if (val.length>1){
						to=val[1];
					}
					xmlMenu=xmlMenu.replace(from, to);
				}
				
				obj=XMLStreamUtil.xmlLoadObject(xmlMenu);
				menu=(IMenu) obj;
				menus.set(i, menu);
			}
		}
		return menus;
	}
	//eduard 20110606
	
	private ITrackingBusqueda TrackingBusqueda(String seqTra,String provinciaOrigenKey, String provinciaDestinoKey, String idProComercial){
		ITrackingBusqueda tempTra;
		ITrackingBusqueda tra;
		String origen ="";
		String destino="";
		String idPro="";
		if(provinciaOrigenKey!=null && !provinciaOrigenKey.equalsIgnoreCase("") && provinciaDestinoKey!=null && !provinciaDestinoKey.equalsIgnoreCase("")){
			origen=provinciaOrigenKey;
			destino=provinciaDestinoKey;
			idPro=idProComercial;
			
		}
		if (seqTra==null){
			tra = setTrackingBusqueda(origen, destino, idPro);
		}else{
			tempTra=getTrackingBusqueda(seqTra);
			if(tempTra==null){
				tra = setTrackingBusqueda(origen, destino, idPro);
			}else{
				tempTra.setTbVacZonaOrigen(origen);
				tempTra.setTbVacZonaDestino(destino);
				tempTra.setTbVacIdprc(idPro);
				tra = updateTrackingBusqueda(tempTra);
			}
		}
		return tra;
	}
	private ILlamadasClienteBusqueda LlamadasClienteBusqueda(String seqLlamada, ITrackingBusqueda tra){
		ILlamadasClienteBusqueda tempLla = getLlamadasClienteBusqueda(tra.getTbSeq(),null);
		ILlamadasClienteBusqueda lla;
		if(tempLla==null){
			lla = setLlamadasClienteBusqueda(tra.getTbSeq(), seqLlamada, null, tra.getTbVacZonaOrigen(), tra.getTbVacZonaDestino(), tra.getTbVacIdprc());
		}else{
			tempLla.setLcbSeqllamada(seqLlamada);
			tempLla.setLcbVacZonaOrigen(tra.getTbVacZonaOrigen());
			tempLla.setLcbVacZonaDestino(tra.getTbVacZonaDestino());
			tempLla.setLcbVacIdprc(tra.getTbVacIdprc());
			lla = updateLlamadasClienteBusqueda(tempLla);
		}
		return lla;
	}
	/**
	 * @return the genConfig
	 */
	public Hashtable<String, String> getGenConfig() {
		return genConfig;
	}

	/**
	 * @param genConfig the genConfig to set
	 */
	public void setGenConfig(Hashtable<String, String> genConfig) {
		this.genConfig = genConfig;
	}

	/**
	 * @param reload
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.facade.GenFacade#getGenConfig(boolean)
	 */
	public ArrayList<IGenConfig> getGenConfig(boolean reload) throws Exception,
			SQLException {
		return gen.getGenConfig(reload);
	}

	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.facade.GenFacade#getGenResources()
	 */
	public ArrayList<IGenLanResource> getGenResources() throws Exception,
			SQLException {
		return gen.getGenResources();
	}

	/**
	 * @return the gen
	 */
	public GenFacade getGen() {
		return gen;
	}

	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.DataFacade#getGenMetas()
	 */
	public ArrayList<IGenMetas> getGenMetas() throws Exception, SQLException {
		return gen.getGenMetas();
	}

	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.DataFacade#getGenScripts()
	 */
	public ArrayList<IGenScripts> getGenScripts() throws Exception,
			SQLException {
		scripts = scripts==null?gen.getGenScripts():scripts;
		return scripts;
	}

	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.DataFacade#getGenStyles()
	 */
	public ArrayList<IGenStyles> getGenStyles() throws Exception, SQLException {
		styles = styles==null?gen.getGenStyles():styles;
		return styles;
	}



	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.DataFacade#getGenImages()
	 */
	public ArrayList<IGenImages> getGenImages() throws Exception, SQLException {
		images = images==null?gen.getGenImages():images;
		return images;
	}

	public ArrayList<IMenu> getMenus(String idi, String codMenu) {
		ArrayList<IMenu> menus = gen.getMenus(idi, codMenu);
		return menus;

	}

	public IGenErrores setErrores(int id, String url, String urlFrom,
			String headers, String params, String session, String ip,
			String host, String action, String toString, String serialized, String error) {
		return gen.setErrores(id, url, urlFrom, headers, params, session, ip,
				host, action, toString, serialized, error);
	}

	public IGenMonitor setMonitor(int id, String url, String urlFrom,
			String headers, String params, String session, String ip,
			String host, String action, String toString) {
		return gen.setMonitor(id, url, urlFrom, headers, params, session, ip,
				host, action, toString);
	}

	public IGenSesiones getGenSesiones(String id, String idSesion,
			GregorianCalendar cal) throws SQLException, Exception {
		return gen.getGenSesiones(id, idSesion, cal);
	}

	public IGenSesiones setGenSesiones(String id, String idSesion, String sesion)
			throws SQLException, Exception {
		return gen.setGenSesiones(id, idSesion, sesion);
	}



	public void reloadStatic() {
		gen.reloadStatic();
	}

	public ILlamadasClienteBusqueda getLlamadasClienteBusqueda(
			String seqBusqueda, String seqLlamada) {
		return gen.getLlamadasClienteBusqueda(seqBusqueda, seqLlamada);
	}

	public ITrackingBusqueda getTrackingBusqueda(String seq) {
		return gen.getTrackingBusqueda(seq);
	}

	public ILlamadasClienteBusqueda setLlamadasClienteBusqueda(
			String seqBusqueda, String seqLlamada, GregorianCalendar fecha,
			String provinciaOrigen, String provinciaDestino, String idProducto) {
		return gen.setLlamadasClienteBusqueda(seqBusqueda, seqLlamada, fecha,
				provinciaOrigen, provinciaDestino, idProducto);
	}

	public ITrackingBusqueda setTrackingBusqueda(String provinciaOrigen,
			String provinciaDestino, String idProducto) {
		return gen.setTrackingBusqueda(provinciaOrigen, provinciaDestino,
				idProducto);
	}

	public ILlamadasClienteBusqueda updateLlamadasClienteBusqueda(
			ILlamadasClienteBusqueda lla) {
		return gen.updateLlamadasClienteBusqueda(lla);
	}
	public ITrackingBusqueda updateTrackingBusqueda(ITrackingBusqueda tra) {
		return gen.updateTrackingBusqueda(tra);
	}
	public ArrayList<IGenMenus> getGenMenus(int idClase) throws Exception,
			SQLException {
		
		return gen.getGenMenus(idClase);
	}
	public IGenMenus setGenMenus(int id, String gmnDes, String gmnEtiqueta,
			String gmnTitle, String gmnUrl, String gmnVal, Integer gmnOrder,
			int gmnClase, int gmnSup) {
		return gen.setGenMenus(id, gmnDes, gmnEtiqueta, gmnTitle, gmnUrl,
				gmnVal, gmnOrder, gmnClase, gmnSup);
	}
	public ArrayList<IGenMenus> getGenMenusPlainTable(int idClase)
			throws Exception, SQLException {
		return gen.getGenMenusPlainTable(idClase);
	}
	public ArrayList<IMenu> getMenusPpt(String idi, String codMenu) {
		return gen.getMenusPpt(idi, codMenu);
	}
	public Hashtable<String,Object> authenticateUser(String username, String password,
			String searchBase) {
		return ldap.authenticateUser(username, password, searchBase);
	}
	public void closeSession() {
		gen.closeSession();
		mail.closeSession();
	}
	public ArrayList<IGenCache> getCache(String id, GregorianCalendar calDesde,
			GregorianCalendar calHasta) throws SQLException, Exception {
		return gen.getCache(id, calDesde, calHasta);
	}
	public IGenCache getCacheById(String id) {
		return gen.getCacheById(id);
	}
	public ArrayList<IGenCache> getCacheByIdLike(String id) throws SQLException, Exception {
		return gen.getCacheByIdLike(id);
	}
	public IGenCache setCache(String id, String toLob,
			GregorianCalendar cal) throws SQLException, Exception {
		return gen.setCache(id, toLob, cal);
	}
	public ArrayList<IGenMenus> getGenMenusOpciones() throws Exception,
			SQLException {
		return gen.getGenMenusOpciones();
	}
	public ArrayList<IGenTracking> getTracking(String gtrIdeses, String gtrTmpven, String gtrIdven, String gtrNumexp, String gtrOricla, String gtrOrimet, String gtrTipgtr) throws SQLException, Exception {
		return gen.getTracking(gtrIdeses, gtrTmpven, gtrIdven, gtrNumexp, gtrOricla, gtrOrimet, gtrTipgtr);
	}
	public IGenTracking getTrackingById(String id) {
		return gen.getTrackingById(id);
	}
	public boolean isToTracking(String nivelTracking){
		String nivel = this.genConfig.get("nivellDeTraking");
		String ni;
		IGenTrackingLevel defecto=null;
		IGenTrackingLevel track=null;
		if (nivel!=null && nivelTracking!=null ){
			ArrayList<IGenTrackingLevel> listaNiveles = gen.getStaticTrackingLevel();
			for (int i=0;i<listaNiveles.size();i++){
				ni = listaNiveles.get(i).getGtlNivel();
				if (ni!=null && ni.equalsIgnoreCase(nivel)){
					defecto=listaNiveles.get(i);
				}
				if (ni!=null && ni.equalsIgnoreCase(nivelTracking)){
					track=listaNiveles.get(i);
				}
			}
			if (defecto!=null && track!=null & defecto.getGtlOrder()!=null && track.getGtlOrder()!=null){
				if(defecto.getGtlOrder()<=track.getGtlOrder()){
					return true;
				}
			}
		}
		return false;
	}
	public void setThreadTracking(String nivelTracking, String gtrIdeses, String gtrTmpven, String gtrIdven, String gtrNumexp, String gtrOricla, String gtrOrimet, String gtrDesgtr, String gtrTipgtr, Object gtrDatos,String gtrMaquina, String gtrSite, String gtrLine) throws InterruptedException, ThreadException{
		Class[] tipoParams={String.class, String.class, 
				String.class, String.class,
				String.class, String.class,
				String.class, String.class,
				String.class, Object.class, ThreadBase.class,
				String.class, String.class,
				String.class};
		Object[] params={nivelTracking, gtrIdeses, 
				gtrTmpven, gtrIdven, 
				gtrNumexp, gtrOricla, 
				gtrOrimet, gtrDesgtr, 
				gtrTipgtr, gtrDatos,trackingThread,
				gtrMaquina, gtrSite,
				gtrLine};
		
		trackingThread=ThreadManager.start("HILO_setThreadTracking",this, "setTrackingSerializedData",tipoParams,params,4000);
	}
	public IGenTracking setTrackingSerializedData(String nivelTracking, String gtrIdeses, String gtrTmpven, String gtrIdven, String gtrNumexp, String gtrOricla, String gtrOrimet, String gtrDesgtr, String gtrTipgtr, Object gtrDatos,ThreadBase hiloAnterior,String gtrMaquina, String gtrSite, String gtrLine) throws SQLException, Exception {
		if (hiloAnterior!=null){
			hiloAnterior.join(5000);}
		
		String gtrDatosSerialized=null;
		if (gtrDatos!=null){
			if(gtrDatos instanceof String){
				gtrDatosSerialized=(String)gtrDatos;
			}else{
				gtrDatosSerialized=XMLStreamUtil.xmlSaveObject(gtrDatos);
			}
		}
		return this.setTracking(nivelTracking, gtrIdeses, gtrTmpven, gtrIdven, gtrNumexp, gtrOricla, gtrOrimet, gtrDesgtr, gtrTipgtr, gtrDatosSerialized, gtrMaquina,  gtrSite, gtrLine);
	}
	public IGenTracking setTracking(String nivelTracking, String gtrIdeses, String gtrTmpven, String gtrIdven, String gtrNumexp, String gtrOricla, String gtrOrimet, String gtrDesgtr, String gtrTipgtr, String gtrDatos,String gtrMaquina, String gtrSite, String gtrLine) throws SQLException, Exception {
		boolean isToTrack=isToTracking(nivelTracking);
		if (isToTrack){
			return gen.setTracking(gtrIdeses, gtrTmpven, gtrIdven, gtrNumexp, gtrOricla, gtrOrimet, gtrDesgtr, gtrTipgtr, gtrDatos,nivelTracking,gtrMaquina, gtrSite, gtrLine);
		}else{
			return null;
		}
	}
	public String sendTemplate(String images, String template, String lang,
			Hashtable<String, Object> att, String asuntoMensaje,
			String destinoMensaje, String destinoMensajeCC,
			String destinoMensajeCCO, String from) {
		return mail.sendTemplate(images, template, lang, att, asuntoMensaje,
				destinoMensaje, destinoMensajeCC, destinoMensajeCCO, from);
	}
	public String renderTemplate(String template, String lang,
			Hashtable<String, Object> att) {
		return mail.renderTemplate(template, lang, att);
	}
	public ArrayList<IGenBanners01> getBanners01(String idi) throws SQLException, Exception {
		return gen.getBanners01(idi);
	}
	
	
}
