package com.photel.data.gen.facade;


import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import org.hibernate.Session;
import com.photel.data.gen.ddbb.HelperHibernateDDBBGen;
import com.photel.data.gen.ddbb.hibernate.pojo.GenConfig;
import com.photel.interfaces.data.gen.IGenBanners01;
import com.photel.interfaces.data.gen.IGenCache;
import com.photel.interfaces.data.gen.IGenConfig;
import com.photel.interfaces.data.gen.IGenConfigSite;
import com.photel.interfaces.data.gen.IGenErrores;
import com.photel.interfaces.data.gen.IGenImages;
import com.photel.interfaces.data.gen.IGenImagesSite;
import com.photel.interfaces.data.gen.IGenLanResource;
import com.photel.interfaces.data.gen.IGenLanresourceSite;
import com.photel.interfaces.data.gen.IGenMenus;
import com.photel.interfaces.data.gen.IGenMetas;
import com.photel.interfaces.data.gen.IGenMonitor;
import com.photel.interfaces.data.gen.IGenScripts;
import com.photel.interfaces.data.gen.IGenScriptsSite;
import com.photel.interfaces.data.gen.IGenSesiones;
import com.photel.interfaces.data.gen.IGenStyles;
import com.photel.interfaces.data.gen.IGenStylesSite;
import com.photel.interfaces.data.gen.IGenTracking;
import com.photel.interfaces.data.gen.IGenTrackingLevel;
import com.photel.interfaces.data.gen.IGenvMenus;
import com.photel.interfaces.data.gen.ILlamadasCliente;
import com.photel.interfaces.data.gen.ILlamadasClienteBusqueda;
import com.photel.interfaces.data.gen.IMenu;
import com.photel.interfaces.data.gen.ITrackingBusqueda;

public class GenFacade   {
	HelperHibernateDDBBGen hbd;
	private String site;
	public GenFacade(String site) throws SQLException, Exception{
		this.site=site;
		init();
	}
	public void init() throws SQLException, Exception{
		this.hbd=new HelperHibernateDDBBGen(site);
		
	}
	
	
			
	public ArrayList<IGenTrackingLevel> getStaticTrackingLevel() {
		return hbd.getStaticTrackingLevel();
	}
	/**
	 * @param reload
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getConfig(boolean)
	 */
	public ArrayList<IGenConfig> getGenConfig(boolean reload) throws Exception,
			SQLException {
		return hbd.getStaticConfig();
	}
	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getResources()
	 */
	public ArrayList<IGenLanResource> getGenResources() throws Exception,
			SQLException {
		return hbd.getStaticResources();
	}
	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getGenMetas()
	 */
	public ArrayList<IGenMetas> getGenMetas() throws Exception, SQLException {
		return hbd.getStaticMetas();
	}
	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getGenScripts()
	 */
	public ArrayList<IGenScripts> getGenScripts() throws Exception,
			SQLException {
		return hbd.getStaticScripts();
	}
	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getGenStyles()
	 */
	public ArrayList<IGenStyles> getGenStyles() throws Exception, SQLException {
		return hbd.getStaticStyles();
	}
	/**
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getGenImages()
	 */
	public ArrayList<IGenImages> getGenImages() throws Exception, SQLException {
		return hbd.getStaticImages();
	}

	/**
	 * @return
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getStaticMetas()
	 */
	public ArrayList<IGenMetas> getStaticMetas() {
		return hbd.getStaticMetas();
	}
	/**
	 * @return
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getStaticResources()
	 */
	public ArrayList<IGenLanResource> getStaticResources() {
		return hbd.getStaticResources();
	}
	
	
	/**
	 * @return
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getStaticScripts()
	 */
	public ArrayList<IGenScripts> getStaticScripts() {
		return hbd.getStaticScripts();
	}
	/**
	 * @return
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getStaticStyles()
	 */
	public ArrayList<IGenStyles> getStaticStyles() {
		return hbd.getStaticStyles();
	}
	/**
	 * 
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#reloadStatic()
	 */
	public void reloadStatic() {
		hbd.reloadStatic();
	}
	/**
	 * @return
	 * @see com.photel.data.gen.ddbb.HelperHibernateDDBBGen#getStaticConfig()
	 */
	public ArrayList<IGenConfig> getStaticConfig() {
		return hbd.getStaticConfig();
	}
	public ArrayList<IGenvMenus> getStaticVMenus() {
		return hbd.getStaticVMenus();
	}
	public void reloadTable(String table) {
		hbd.reloadTable(table);
	}
	public ArrayList<IMenu> getMenus(String idi, String codMenu) {
		return hbd.getMenus(idi,codMenu);
	}
	public IGenErrores setErrores(int id, String url, String urlFrom,
			String headers, String params, String session, String ip,
			String host, String action, String toString, String serialized, String error) {
		return hbd.setErrores(id, url, urlFrom, headers, params, session, ip,
				host, action, toString, serialized , error);
	}
	public IGenMonitor setMonitor(int id, String url, String urlFrom,
			String headers, String params, String session, String ip,
			String host, String action, String toString) {
		return hbd.setMonitor(id, url, urlFrom, headers, params, session, ip,
				host, action, toString);
	}
	public IGenSesiones getGenSesiones(String id, String idSesion,
			GregorianCalendar cal) throws SQLException, Exception {
		return hbd.getGenSesiones(id, idSesion, cal);
	}
	public IGenSesiones setGenSesiones(String id, String idSesion, String sesion)
			throws SQLException, Exception {
		return hbd.setGenSesiones(id, idSesion, sesion);
	}
	public ILlamadasCliente getLlamadasClientes(String seqLla) {
		return hbd.getLlamadasCliente(seqLla);
	}
	public ILlamadasCliente setLlamadasCliente(String seq, String site,
			GregorianCalendar fecha, String telefono,
			GregorianCalendar diaHora, String swiRevisada,
			String idUsuarioMaquina, String nombre, String numExp,
			String swiVenta, String datosError) {
		return hbd.setLlamadasCliente(seq, site, fecha, telefono, diaHora,
				swiRevisada, idUsuarioMaquina, nombre, numExp, swiVenta,
				datosError);
	}
	public ILlamadasCliente updateLlamadasCliente(ILlamadasCliente lla) {
		return hbd.updateLlamadasCliente(lla);
	}
	public ILlamadasClienteBusqueda getLlamadasClienteBusqueda(
			String seqBusqueda, String seqLlamada) {
		return hbd.getLlamadasClienteBusqueda(seqBusqueda, seqLlamada);
	}
	public ILlamadasClienteBusqueda updateLlamadasClienteBusqueda(
			ILlamadasClienteBusqueda lla) {
		return hbd.updateLlamadasClienteBusqueda(lla);
	}
	
	public ILlamadasClienteBusqueda setLlamadasClienteBusqueda(
			String seqBusqueda, String seqLlamada, GregorianCalendar fecha,
			String provinciaOrigen, String provinciaDestino, String idProducto) {
		return hbd.setLlamadasClienteBusqueda(seqBusqueda, seqLlamada, fecha,
				provinciaOrigen, provinciaDestino, idProducto);
	}
	public ITrackingBusqueda getTrackingBusqueda(String seq) {
		return hbd.getTrackingBusqueda(seq);
	}
	public ITrackingBusqueda setTrackingBusqueda(String provinciaOrigen,
			String provinciaDestino, String idProducto) {
		return hbd.setTrackingBusqueda(provinciaOrigen, provinciaDestino,
				idProducto);
	}
	
	public ITrackingBusqueda updateTrackingBusqueda(ITrackingBusqueda tra) {
		return hbd.updateTrackingBusqueda(tra);
	}
		public ArrayList<IGenMenus> getGenMenus(int idClase) throws Exception,
		SQLException {
		ArrayList<IGenMenus> plainTable = hbd.getGenMenus(idClase);
		plainTable=creaNiveles(plainTable);
		return plainTable;
		}
		public ArrayList<IGenMenus> getGenMenusPlainTable(int idClase) throws Exception,
		SQLException {
		ArrayList<IGenMenus> plainTable = hbd.getGenMenus(idClase);
		return plainTable;
		}
	private ArrayList<IGenMenus> creaNiveles(ArrayList<IGenMenus> menu){
		for (int j=0;j<menu.size();j++){
			if(menu.get(j).getGmnSup()!=null ){
				ArrayList<IGenMenus> aux = menu.get(j).getGmnSup().getGmnInf();
				if(aux==null){
					aux=new ArrayList<IGenMenus>();
				}
				aux.add(menu.get(j));
				menu.get(j).getGmnSup().setGmnInf(aux);
			}
		}
		ArrayList<IGenMenus> ret=new ArrayList<IGenMenus>();
		for (int j=0;j<menu.size();j++){
			if(menu.get(j).getGmnSup()==null ){
				ret.add(menu.get(j));
			}
		}
		
		return ret;
	}
	public IGenMenus setGenMenus(int id, String gmnDes, String gmnEtiqueta,
			String gmnTitle, String gmnUrl, String gmnVal, Integer gmnOrder,
			int gmnClase, int gmnSup) {
		return hbd.setGenMenus(id, gmnDes, gmnEtiqueta, gmnTitle, gmnUrl,
				gmnVal, gmnOrder, gmnClase, gmnSup);
	}
	public ArrayList<IMenu> getMenusPpt(String idi, String codMenu) {
		return hbd.getMenusPpt(idi, codMenu);
	}
	public ArrayList<IGenConfigSite> getStaticConfigSite() {
		return hbd.getStaticConfigSite();
	}
	public ArrayList<IGenImagesSite> getStaticImagesSite() {
		return hbd.getStaticImagesSite();
	}
	public ArrayList<IGenLanresourceSite> getStaticResourcesSite() {
		return hbd.getStaticResourcesSite();
	}
	public ArrayList<IGenScriptsSite> getStaticScriptsSite() {
		return hbd.getStaticScriptsSite();
	}
	public ArrayList<IGenStylesSite> getStaticStylesSite() {
		return hbd.getStaticStylesSite();
	}
	public ArrayList<IGenConfigSite> getStaticConfigSite(String site) {
		return hbd.getStaticConfigSite(site);
	}
	public ArrayList<IGenImagesSite> getStaticImagesSite(String site) {
		return hbd.getStaticImagesSite(site);
	}
	public ArrayList<IGenLanresourceSite> getStaticResourcesSite(String site) {
		return hbd.getStaticResourcesSite(site);
	}
	public ArrayList<IGenScriptsSite> getStaticScriptsSite(String site) {
		return hbd.getStaticScriptsSite(site);
	}
	public ArrayList<IGenStylesSite> getStaticStylesSite(String site) {
		return hbd.getStaticStylesSite(site);
	}
	public void clearSession() {
		hbd.clearSession();
	}
	public void closeSession() {
		hbd.closeSession();
	}
	public ArrayList<IGenCache> getCache(String id, GregorianCalendar calDesde,
			GregorianCalendar calHasta) throws SQLException, Exception {
		return hbd.getCache(id, calDesde, calHasta);
	}
	public IGenCache getCacheById(String id) {
		return hbd.getCacheById(id);
	}
	public ArrayList<IGenCache> getCacheByIdLike(String id) throws SQLException, Exception {
		return hbd.getCacheByIdLike(id);
	}
	public IGenCache setCache(String id, String toLob,
			GregorianCalendar cal) throws SQLException, Exception {
		return hbd.setCache(id, toLob, cal);
	}

	public ArrayList<IGenMenus> getGenMenusOpciones() throws Exception, SQLException {
		return hbd.getGenMenusOpciones();
	}
	public ArrayList<IGenTracking> getTracking(String gtrIdeses, String gtrTmpven, String gtrIdven, String gtrNumexp, String gtrOricla, String gtrOrimet, String gtrTipgtr) throws SQLException, Exception {
		return hbd.getTracking(gtrIdeses, gtrTmpven, gtrIdven, gtrNumexp, gtrOricla, gtrOrimet, gtrTipgtr);
	}
	public IGenTracking getTrackingById(String id) {
		return hbd.getTrackingById(id);
	}
	public IGenTracking setTracking(String gtrIdeses, String gtrTmpven, String gtrIdven, String gtrNumexp, String gtrOricla, String gtrOrimet, String gtrDesgtr, String gtrTipgtr, String gtrDatos,String gtrNivel,String gtrMaquina, String gtrSite, String gtrLine) throws SQLException, Exception {
		return hbd.setTracking(gtrIdeses, gtrTmpven, gtrIdven, gtrNumexp, gtrOricla, gtrOrimet, gtrDesgtr, gtrTipgtr, gtrDatos,gtrNivel,gtrMaquina, gtrSite, gtrLine);
	}
	
	public IGenSesiones getGenSesiones(String id, String idSesion,
			GregorianCalendar cal, boolean create) throws SQLException,
			Exception {
		return hbd.getGenSesiones(id, idSesion, cal, create);
	}
	public void delSession(String id, String idSesion, GregorianCalendar cal)
			throws SQLException, Exception {
		hbd.delSession(id, idSesion, cal);
	}
	public ArrayList<IGenBanners01> getBanners01(String idi) throws SQLException, Exception {
		return hbd.getBanners01(idi);
	}
	
}
