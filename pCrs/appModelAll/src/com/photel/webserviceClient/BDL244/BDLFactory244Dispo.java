package com.photel.webserviceClient.BDL244;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.photel.commonServices.thread.ThreadBase;
import com.photel.commonServices.thread.ThreadManager;
import com.photel.commonServices.util.AppModelProperties;
import com.photel.commonServices.util.JaxbUtil;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPromotion;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.webserviceClient.BDL244.Client.FrontendServiceProxy;
import com.photel.webserviceClient.BDL244.vo.avail.*;
import com.photel.webserviceClient.BDL244.vo.avail.ServiceHotelRoomList.HotelRoom;
import com.photel.webserviceClient.BDL244.comparators.*;
import com.photel.webserviceClient.BDL244.pojo.*;

/**
 * <p>Title: DBLFactory244</p>
 * <p>Description: Clase que implementa la versi�n 2.2.4 de los WS de BDL</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: HalconViajes.com</p>
 * @author: GPG
 * @version 1.0
 */
public class BDLFactory244Dispo {
	private static JAXBContext conector;
	
	Logger  log = Logger.getLogger("DBL");

	private XPathFactory Xfactory = XPathFactory.newInstance();
	private XPath xpath = Xfactory.newXPath();
	private static int maxHilos=10;
	private FrontendServiceProxy proxi;
	public static String endpoint;
	public static String user;
	public static String password;
	

	public BDLFactory244Dispo(String endpoint, String user, String password) throws Exception{
		super();
		if (endpoint!=null && user!=null && password!=null){
			this.endpoint=endpoint;
			this.user=user;
			this.password=password;
			this.proxi=new FrontendServiceProxy(endpoint);
			this.conector= JAXBContext.newInstance("com.photel.webserviceClient.BDL244.vo.avail");
		}else{
			throw new Exception("Endpoint, user or password no inicializados");
		}
	}
	public Calendar getDateTime(){
		String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss:SSS";
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
	    return cal;
	}
	
	public IBDLDisponibilidad  getDisponibilidad (
			List<List<String>> distribuciones,
			List<String> roomCount,
			Calendar fechaIni, 
			Calendar fechaFin, 
            String idSesion,
            String numero_pagina, 
            String codIdioma,
            String codZgeSup,
            boolean multihilo,
            String codigosDeHotel //1234##2345##3456
            ) throws Exception{
		
		IBDLDisponibilidad dispo;
		IBDLDisponibilidad dispoAux;
		if(!numero_pagina.equals("-1")){
			dispo= this.getPagina(distribuciones, roomCount,fechaIni, fechaFin, idSesion, numero_pagina, codIdioma, codZgeSup, codigosDeHotel );
		}else{
			dispo=this.getPagina(distribuciones, roomCount,fechaIni, fechaFin, idSesion, "0", codIdioma, codZgeSup,codigosDeHotel);
			List<ThreadBase> listaHilos=new ArrayList<ThreadBase>();
			ThreadBase hilo=null;
			int segundosExec;
			AppModelProperties prop=new AppModelProperties();

			try{segundosExec=Integer.parseInt(prop.getProperty("com.photel.segundosEjecucionHiloBDL"));
			}catch (Exception e){segundosExec=7;}
			long timeOut=1000*segundosExec;


			Class[] tipoParams = {List.class,
									List.class,
									Calendar.class, 
									Calendar.class, 
						            String.class,
						            String.class, 
						            String.class,
						            String.class,
						            String.class};
			
							
			for (int i=1;i<=dispo.getNumeroDePaginas();i++){
				Object[] params = {distribuciones,roomCount, fechaIni, fechaFin, idSesion, String.valueOf(i), codIdioma, codZgeSup,codigosDeHotel};
				hilo=ThreadManager.start("THREAD_DisponibilidadBDL_Pagina"+(i+1),this, "getPagina",tipoParams,params,timeOut);
				listaHilos.add(hilo);
				if (!multihilo){
					ThreadManager.esperarTerminacionHilos(listaHilos);
				}
			}
			
			ThreadManager.esperarTerminacionHilos(listaHilos);
			Object obj;
			for (int i=0;i<listaHilos.size();i++){
				 obj = listaHilos.get(i).getReturnedValue();
				 if (obj!=null){
					dispoAux=(IBDLDisponibilidad) obj;
					dispo.getHoteles().addAll(dispoAux.getHoteles());	
					dispo.getPeticiones().addAll(dispoAux.getPeticiones());
					dispo.getRespuestas().addAll(dispoAux.getRespuestas());
				 }
			}
		}
		dispo=unificaHoteles(dispo);
		dispo=ordenaHotelesASC(dispo);
		
		return dispo;
		
	}
	
	public IBDLDisponibilidad ordenaHotelesASC(IBDLDisponibilidad dispo) throws Exception {
		return ordenaHoteles(dispo,BDLHotelesComparator.ASC);
	}
	public IBDLDisponibilidad ordenaHotelesDESC(IBDLDisponibilidad dispo) throws Exception {
		return ordenaHoteles(dispo,BDLHotelesComparator.DESC);
	}
	private IBDLDisponibilidad ordenaHoteles(IBDLDisponibilidad dispo, String ordenacion) throws Exception {
		List<IBDLHotel> hoteles = dispo.getHoteles();
		List<IBDLContrato> contratos;
		List<IBDLDistribucion> distribuciones;
		List<IBDLRoom> habs;
		for (int h=0;h<hoteles.size();h++){
			contratos = hoteles.get(h).getContratos();
			for (int c=0;c<contratos.size();c++){
				distribuciones = contratos.get(c).getDistribuciones();
				for (int d=0;d<distribuciones.size();d++){
					//Eliminamos habitaciones duplicadas
					distribuciones.get(d).setRooms(eliminaHabitacionesDuplicadosHabitacion(distribuciones.get(d)));
					//*******
					
					habs = distribuciones.get(d).getRooms();
					for (int ha=0;ha<habs.size();ha++){
						
						//Eliminamos regimenes duplicados
						habs.get(ha).setRegimenesAlimentarios(eliminaRegimenesDuplicadosHabitacion(habs.get(ha)));
						//*******
						
						List<IBDLRegimen> regs = habs.get(ha).getRegimenesAlimentarios();
						if (regs.size()>1){
							Collections.sort(regs, new BDLRegimenesComparator(BDLRegimenesComparator.ASC));
							habs.get(ha).setRegimenesAlimentarios(regs);
						}
					}
					
					
					
					Collections.sort(habs, new BDLHabitacionComparator(BDLHabitacionComparator.ASC));
				}
				Collections.sort(distribuciones, new BDLDistribucionComparator(BDLDistribucionComparator.ASC));
				contratos.get(c).setDistribuciones(distribuciones);
			}
			Collections.sort(contratos, new BDLContratosComparator(BDLContratosComparator.ASC));
			hoteles.get(h).setContratos(contratos);
			
		}
		Collections.sort(hoteles, new BDLHotelesComparator(ordenacion));
		dispo.setHoteles(hoteles);
		return dispo;
	}
	private List<IBDLRoom> eliminaHabitacionesDuplicadosHabitacion(IBDLDistribucion distribucion){
		List<IBDLRoom> habs = distribucion.getRooms();
		Hashtable<String,IBDLRoom> hash=new Hashtable<String,IBDLRoom>();
		for (int ha=0;ha<habs.size();ha++){
			hash.put(habs.get(ha).getHabitacionCodigo()+"_"+habs.get(ha).getHabitacionCaracteristica()+"_"+habs.get(ha).getHabitacionTipo(),habs.get(ha));
		}
		habs=new ArrayList<IBDLRoom>();
		for (Entry<String, IBDLRoom> hab : hash.entrySet()){
			hab.getValue().setHabitacion(formatCapitalizeAllWords(hab.getValue().getHabitacion()));
			habs.add(hab.getValue());
		}
		return habs;
		
	}
	private List<IBDLRegimen> eliminaRegimenesDuplicadosHabitacion(IBDLRoom hab){
		List<IBDLRegimen> regs = hab.getRegimenesAlimentarios();
		Hashtable<String,IBDLRegimen> hash=new Hashtable<String,IBDLRegimen>();
		for (int re=0;re<regs.size();re++){
			hash.put(regs.get(re).getCodigo(),regs.get(re));
		}
		regs=new ArrayList<IBDLRegimen>();
		for (Entry<String, IBDLRegimen> reg : hash.entrySet()){
			reg.getValue().setDescripcion(formatCapitalizeAllWords(reg.getValue().getDescripcion()));
			regs.add(reg.getValue());
		}
		return regs;
	}
	public String formatFirstWordUpper(String str){
		return StringUtils.capitalize(str.toLowerCase());
	}
	public String formatCapitalizeAllWords(String str){
		String ret="";
		if (str!=null){
			String[] arr=str.toLowerCase().split(" ");
			for (int i=0;i<arr.length;i++){
				ret+=StringUtils.capitalize(arr[i] + " ");
			}
		}
		return ret.trim();
	}
	
	private IBDLDisponibilidad unificaHoteles(IBDLDisponibilidad dispo) {
		if (dispo!=null && dispo.getHoteles()!=null){
			Hashtable<String, IBDLHotel> hoteles = new Hashtable<String,IBDLHotel>();
			for (int i=0;i<dispo.getHoteles().size();i++){
				IBDLHotel hotel = dispo.getHoteles().get(i);
				IBDLHotel tHotel = hoteles.get(hotel.getServicioCodigo());
				if(tHotel==null){
					tHotel=hotel;
					tHotel.setPrecioMax(tHotel.getContratos().get(0).getPrecioMax());
					tHotel.setPrecioMin(tHotel.getContratos().get(0).getPrecioMin());
				}else{
					boolean existe=false;
					for(IBDLContrato con:tHotel.getContratos()){
						String enTabla=con.getCodigoClasificacion()+"##"+con.getNombre();
						String enLista=hotel.getContratos().get(0).getCodigoClasificacion()+"##"+hotel.getContratos().get(0).getNombre();
						if (enTabla.equals(enLista)){
							existe=true;
						}
					}
					if (!existe){
						BigDecimal max = hotel.getContratos().get(0).getPrecioMax();
						BigDecimal min = hotel.getContratos().get(0).getPrecioMin();
						BigDecimal hmax = tHotel.getPrecioMax();
						BigDecimal hmin = tHotel.getPrecioMin();
						hmax=hmax==null?max:hmax;
						hmin=hmin==null?min:hmin;
						hmin=hmin.compareTo(min)>0?min:hmin;
						hmax=hmax.compareTo(max)<0?max:hmax;
						tHotel.setPrecioMax(hmax);
						tHotel.setPrecioMin(hmin);
						tHotel.getContratos().add(hotel.getContratos().get(0));
					}
				}
				hoteles.put(tHotel.getServicioCodigo(), tHotel);
				
			}
			List<IBDLHotel> hotelesUnificados = new ArrayList<IBDLHotel>();
			for(Entry<String, IBDLHotel> hotel:hoteles.entrySet()){
				hotelesUnificados.add(hotel.getValue());
			}
			dispo.setHoteles(hotelesUnificados);
		}
		return dispo;
	}
	
	public IBDLDisponibilidad  getPagina (
			List<List<String>> distribuciones,
			List<String> roomCount,
			Calendar fechaIni, 
			Calendar fechaFin, 
            String idSesion,
            String numero_pagina, 
            String codIdioma,
            String codZgeSup,
            String codigosDeHotel //1234##2345##3456
            ) throws Exception{
		//http://212.170.239.71/appservices/ws/FrontendService
		ObjectFactory factory=new ObjectFactory();
		HotelValuedAvailRQ aval=factory.createHotelValuedAvailRQ();
		
		//Promotions
		ExtendedDataList extraParam=new ExtendedDataList();
		ExtendedData exData=new ExtendedData();
		exData.setName("DISPLAYER_DEFAULT");
		exData.setValue("PROMOTION:Y");
		exData.setType("EXT_DISPLAYER");
		extraParam.getExtendedData().add(exData);

		aval.setExtraParamList(extraParam);
		aval.setShowDiscountsList("Y");
		aval.setVersion("2011/01");
		//End Promotions
		
		HotelValuedAvailRS resp;
		
		Credentials cred=new Credentials();
		cred.setUser(user);
		cred.setPassword(password);
		aval.setCredentials(cred);
		PaginationRequestData pag=new PaginationRequestData();
		//pag.setItemsPerPage(1);
		pag.setPageNumber(Integer.parseInt(numero_pagina));
		aval.setPaginationData(pag);
		DateTime cidt=new DateTime();

        cidt.setDate(getCalendarString(fechaIni));
		DateTime codt=new DateTime();
		codt.setDate(getCalendarString(fechaFin));
		aval.setCheckInDate(cidt);
		aval.setCheckOutDate(codt);
		Destination dest=new Destination();
		dest.setCode(codZgeSup);
		//dest.setCode("PMI");
		SimpleGroup sg=SimpleGroup.SIMPLE;
		dest.setType(sg);
		
		aval.setDestination(dest);
		ServiceHotelOccupancyList ol=new ServiceHotelOccupancyList();
		ServiceHotelOccupancy soc=new ServiceHotelOccupancy();
		ServiceOccupancy so=new ServiceOccupancy();
		Customer customer;
		CustomerList guest;
		int ad;
		int ch;
		for (int h=0;h<distribuciones.size();h++){
			List<String> paxes = distribuciones.get(h);
			ad=0;
			ch=0;
			soc=new ServiceHotelOccupancy();
			so=new ServiceOccupancy();
			guest=new CustomerList();
			for (int p=0;p<paxes.size();p++){
				String[] pax=paxes.get(p).split("#");
				customer=new Customer();
				if (pax[0].equals("ADT")){
					customer.setType(HotelbedsCustomerType.AD);
					ad++;
				}else if (pax[0].equals("NIN")){
					customer.setType(HotelbedsCustomerType.CH);
					customer.setAge(Integer.parseInt(pax[1]));
					ch++;
				}else{
					throw new Exception("Error en las distribuciones: no se trata ni de ADT ni de NIN");
				}
				guest.getCustomer().add(customer);
			}
			so.setGuestList(guest);
			so.setAdultCount(ad);
			so.setChildCount(ch);
			soc.setOccupancy(so);
			
			int rCount=1;
			try{rCount=Integer.parseInt(roomCount.get(h));}catch(Exception e){rCount=1;}
			soc.setRoomCount(rCount);
			ol.getHotelOccupancy().add(soc);
		}
		aval.setOccupancyList(ol);
		aval.setSessionId(idSesion);
		aval.setLanguage(codIdioma);
		
		/*
		Contract contract=new Contract();
		contract.setName("CG-TODOS SC2");
		ContractClassification clasifi=new ContractClassification();
		clasifi.setCode("NOR");
		clasifi.setValue("STANDARD PRICING");
		contract.setClassification(clasifi);
		IncomingOffice office=new IncomingOffice();
		office.setCode(1);
		contract.setIncomingOffice(office);
		aval.setContract(contract);
		*/
		
		if(codigosDeHotel!=null && !codigosDeHotel.equals("")){
			ProductCodeList hotelCodeList=new ProductCodeList();
			String[] codigos = codigosDeHotel.split("##");
			for (int cod=0;cod<codigos.length;cod++){
				hotelCodeList.getProductCode().add(codigos[cod]);
			}
			hotelCodeList.setWithinResults(YesNo.Y);
			aval.setHotelCodeList(hotelCodeList);
		}
		
		
		JAXBContext conector;
		try {
			conector = JAXBContext.newInstance("com.photel.webserviceClient.BDL244.vo.avail");
		
		String xmlPeticion = JaxbUtil.objectToXml(conector, aval);
        log.info("peticion="+xmlPeticion);
        	
        FrontendServiceProxy proxi=new FrontendServiceProxy(endpoint);
		String returnedXml= (String) proxi.getHotelValuedAvail(xmlPeticion);
		//System.out.println(returnedXml);
		log.debug("respuesta="+returnedXml);
        		
		resp = (HotelValuedAvailRS) JaxbUtil.xmlToObject(conector, returnedXml);
		
		
		List<ServiceHotel> hoteles=resp.getServiceHotel();
		IBDLRoom habitacion=null;
		Double precio;
		Double precioFinal=0.0;
		String codiSrv;
		String nombre;
		String nomZona;
		String acodZonaProveedor;
		String categ;
		String codCateg;
		
		List<IBDLHotel> listaAlojamientos = new ArrayList<IBDLHotel>();
		List<IBDLRoom> listaHabitaciones = null;
		IBDLHotel pHotel;
		IBDLDistribucion distribucion;
		
		IBDLDisponibilidad dispo=new BDLDisponibilidad();
		dispo.setNumeroDePaginas(resp.getPaginationData().getTotalPages());
		Hashtable<String,IBDLRegimen> regimenes;
		Hashtable<String, IBDLRoom> habs;
		dispo.getPeticiones().add(xmlPeticion);
		dispo.getRespuestas().add(returnedXml);
		IBDLRegimen regimen;
		
		for (int i=0;i<hoteles.size();i++){
			if (hoteles.get(i)!=null && hoteles.get(i).getHotelInfo()!=null && hoteles.get(i).getHotelInfo().getCode()!=null){
				pHotel = new BDLHotel(distribuciones);
				pHotel.setAvailTimeStamp(dispo.getAvailTimeStamp());
				ServiceHotel hotel=hoteles.get(i);
				ProductHotel info=hotel.getHotelInfo();
				dispo.setTokenDispo(hotel.getAvailToken());
				pHotel.setAvailToken(hotel.getAvailToken());
				pHotel.setNombre(info.getName());
				
				/*
				if (info.getName().equals("Sun Beach")){
					pHotel.setNombre(info.getName());
				}
				*/
				
				List<Contract> contracts=hotel.getContractList().getContract();
				for (int ii=0;ii<contracts.size();ii++){
					pHotel.getContratos().get(0).setNombre(contracts.get(ii).getName());
					pHotel.getContratos().get(0).setCodigoClasificacion(contracts.get(ii).getClassification().getCode()+"FFFO4UFFF"+contracts.get(ii).getName());
					pHotel.getContratos().get(0).setClasificacion(contracts.get(ii).getClassification().getValue());
					pHotel.getContratos().get(0).setCodigoOficina(String.valueOf(contracts.get(ii).getIncomingOffice().getCode()));
					pHotel.getContratos().get(0).setOficina(contracts.get(ii).getIncomingOffice().getDescription());
					
					if (hotel.getPromotionList()!=null){
						List<Promotion> promos = hotel.getPromotionList().getPromotion();
						if (promos!=null){
							for (int p=0;p<promos.size();p++){
								IBDLPromotion promo=new BDLPromotion();
								promo.setCode(promos.get(p).getCode());
								promo.setName(promos.get(p).getName());
								promo.setObservations(promos.get(p).getObservations());
								promo.setShortName(promos.get(p).getShortName());
								pHotel.getContratos().get(0).getPromotions().add(promo);
								
							}
						}
					}
				}
				
				codiSrv = info.getCode();
				nombre = info.getName();
				nomZona = info.getDestination().getName();
				acodZonaProveedor = info.getDestination().getCode();
				categ = info.getCategory().getValue();
				categ=categ==null?"":categ;
				codCateg = info.getCategory().getCode();
				codCateg=codCateg==null?"":codCateg;
				pHotel.setServicioCodigo(codiSrv);
				pHotel.setServicio(nombre);
				pHotel.setZona(nomZona);
				if(info.getDestination()!=null && info.getDestination().getZoneList()!=null && info.getDestination().getZoneList().getZone()!=null){
					for (Zone z:info.getDestination().getZoneList().getZone()){
						pHotel.setLocalidad(z.getValue());
						pHotel.setLocalidadCodigo(z.getCode());
					}
				}else{
					pHotel.setLocalidad("NaN");
					pHotel.setLocalidadCodigo("0");
				}
				pHotel.setZonaCodigo(acodZonaProveedor);
				pHotel.setCategoria(categ);
				pHotel.setCategoriaCodigo(codCateg);
				
				
				
				if (info.getPosition().getLatitude()!=null){
					pHotel.setLatitud(info.getPosition().getLatitude().toString());
				}
				if (info.getPosition().getLatitude()!=null){
					pHotel.setLongitud(info.getPosition().getLongitude().toString());
				}
				
				if (info.getImageList()!=null && info.getImageList().getImage()!=null && info.getImageList().getImage().size()!=0){
					List<String> fotos=new ArrayList<String>();
					String img=info.getImageList().getImage().get(0).getUrl();
					img=img.substring(0, img.indexOf("/small/")) + img.substring(img.indexOf("/small/")+6, img.length());
					fotos.add(img);
					
					pHotel.setImagenes(fotos);
				}
				
				
				
				List<ServiceHotelRoomList> rooms=hotel.getAvailableRoom();
				ServiceHotelRoomList room=null;
						listaHabitaciones = new ArrayList<IBDLRoom>();
						regimenes=new Hashtable<String,IBDLRegimen>();
						BigDecimal minPrice=null;
						BigDecimal maxPrice=null;
						BigDecimal minPriceContract=BigDecimal.ZERO;
						BigDecimal maxPriceContract=BigDecimal.ZERO;
						for (int ii=0;ii<rooms.size();ii++){ 
							room = rooms.get(ii);
							List<IBDLDistribucion> distriList = pHotel.getContratos().get(0).getDistribuciones();
							habs = new Hashtable<String,IBDLRoom>();
							for (int di=0;di<distriList.size();di++){
								distribucion=distriList.get(di);
								int adCount = room.getHotelOccupancy().getOccupancy().getAdultCount();
								int chCount = room.getHotelOccupancy().getOccupancy().getChildCount();
								if (adCount==distribucion.getAdultos() && chCount==distribucion.getNinos()){
									minPrice=distribucion.getPrecioMin();
									maxPrice=distribucion.getPrecioMax();
									listaHabitaciones=distribucion.getRooms();
									//habs = new Hashtable<String,IBDLRoom>();
									for (int l=0;l<listaHabitaciones.size();l++){
										String habCode = listaHabitaciones.get(l).getHabitacionCodigo();
										String habDes = listaHabitaciones.get(l).getHabitacion();
										String key="distribucion:"+distribucion.getNumDistribucion()+"##"+habCode+"##"+habDes;
										habs.put(key, listaHabitaciones.get(l));
									}
									List<HotelRoom> avRoom = room.getHotelRoom();
									for (int iii=0;iii<avRoom.size();iii++){ 
										precio=avRoom.get(iii).getPrice().getAmount().doubleValue();
										
										if (ii==0 || precio<=precioFinal){
											precioFinal=precio;}
										
										String habCode = avRoom.get(iii).getRoomType().getCode();
										String habDes = avRoom.get(iii).getRoomType().getValue();
										String key="distribucion:"+distribucion.getNumDistribucion()+"##"+habCode+"##"+habDes;
										
										if (habs.get(key)!=null){
											habitacion=habs.get(key);
										}else{
											habitacion= new BDLRoom();
											habitacion.setHabitacionCodigo(avRoom.get(iii).getRoomType().getCode());
											habitacion.setHabitacion(avRoom.get(iii).getRoomType().getValue());
										}
										String codigo=avRoom.get(iii).getBoard().getCode();
										String descripcion=avRoom.get(iii).getBoard().getValue();
										
										BigDecimal price = new BigDecimal(precio);
										minPrice=minPrice==null?price:minPrice;
										maxPrice=maxPrice==null?price:maxPrice;
										minPrice=minPrice.compareTo(price)>0?price:minPrice;
										maxPrice=maxPrice.compareTo(price)<0?price:maxPrice;
										
										habitacion.setRegimen(codigo, descripcion, price);
										habitacion.setHabitacionCaracteristica(avRoom.get(iii).getRoomType().getCharacteristic());
										
										habs.put(key, habitacion);
									}
									listaHabitaciones=new ArrayList<IBDLRoom>();
									for (Entry<String, IBDLRoom> hab : habs.entrySet()){
										listaHabitaciones.add(hab.getValue());
									}
									
									distribucion.setPrecioMin(minPrice);
									distribucion.setPrecioMax(maxPrice);
									distribucion.setRooms(listaHabitaciones);
									pHotel.getContratos().get(0).getDistribuciones().set(di, distribucion);
								}
							}
						}
						for (int d=0;d<pHotel.getContratos().get(0).getDistribuciones().size();d++){
							if (pHotel.getContratos().get(0).getDistribuciones().get(d).getPrecioMin()==null)
								pHotel.getContratos().get(0).getDistribuciones().get(d).setPrecioMin(BigDecimal.ZERO);
							if (pHotel.getContratos().get(0).getDistribuciones().get(d).getPrecioMax()==null)
								pHotel.getContratos().get(0).getDistribuciones().get(d).setPrecioMax(BigDecimal.ZERO);
							minPriceContract=minPriceContract.add(pHotel.getContratos().get(0).getDistribuciones().get(d).getPrecioMin());
							maxPriceContract=maxPriceContract.add(pHotel.getContratos().get(0).getDistribuciones().get(d).getPrecioMax());
						}
						pHotel.getContratos().get(0).setPrecioMin(minPriceContract);
						pHotel.getContratos().get(0).setPrecioMax(maxPriceContract);
						listaAlojamientos.add(pHotel);	
				}
		}
		dispo.setHoteles(listaAlojamientos);
		return dispo; 
		

		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 

	}

	/**
	 * Devuelve la fecha de entrada en formato "YYYYMMDD"
	 * 
	 * @param Date dateIn
	 * 
	 * @return String "YYYYMMDD"
	 */
	private String getCalendarString (Calendar cal){
        String year=Integer.toString(cal.get(Calendar.YEAR));
        String month=Integer.toString(cal.get(Calendar.MONTH)+1);
        String day=Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        
        if (month.length()==1){month="0" + month;}
        if (day.length()==1){day="0" + day;}
        
        return year+month+day;
		
		
	}

	
	/**
	 * Devuelve la fecha de entrada en formato "YYYYMMDD"
	 * 
	 * @param Date dateIn
	 * 
	 * @return String "YYYYMMDD"
	 */
	private String getDateString (Date dateIn){
		Calendar cal=Calendar.getInstance();
		cal.setTime(dateIn);
        String year=Integer.toString(cal.get(Calendar.YEAR));
        String month=Integer.toString(cal.get(Calendar.MONTH)+1);
        String day=Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        
        if (month.length()==1){month="0" + month;}
        if (day.length()==1){day="0" + day;}
        
        return year+month+day;
		
		
	}
	/**
	 * Devuelve una lista de nodos segun una ruta
	 * 
	 * @param Object nodo
	 * @param String ruta
	 * 
	 * @return NodeList
	 */
	public NodeList getNodeList(Object nodo, String ruta ){
		if(ruta.lastIndexOf("/")<0)
			return ((Element)nodo).getElementsByTagName(ruta);
		else
			return getNodeListByXPath(nodo, ruta, xpath);
	}
	/**
	 * Devuelve una lista de nodos segun un xpath
	 * 
	 * @param Object nodo
	 * @param String ruta
	 * @param XPath xpath
	 * 
	 * @return NodeList
	 */

	public Node getNodeByXPath(Object nodo, String ruta, XPath xpath){
		try {
			return ((Node) xpath.compile(ruta).evaluate(nodo, XPathConstants.NODE));
		}
		catch (XPathExpressionException e) {
			return null;
		}
	}

	/**
	 * Devuelve una lista de nodos segun un xpath
	 * 
	 * @param Object nodo
	 * @param String ruta
	 * @param XPath xpath
	 * 
	 * @return NodeList
	 */

	public NodeList getNodeListByXPath(Object nodo, String ruta, XPath xpath ){
		try {
			return (NodeList) xpath.compile(ruta).evaluate(nodo,XPathConstants.NODESET);
		}
		catch (XPathExpressionException e) {
			return null;
		}
	}
	/**
	 * Devuelve Un elemento dado un nodo
	 * 
	 * @param Object nodo
	 * @param String ruta
	 * @param XPath xpath
	 * 
	 * @return Element
	 */

	public Element getElement(Object e, String nombre) {
		Element elem = null;
		try {
			elem = (Element)((Element)e).getElementsByTagName(nombre).item(0);
		} catch (Exception ex) {
			return null;
		}
		return elem;
	}

	/**
	 * Devuelve el valor de un elemento
	 * 
	 * @param Element e
	 * 
	 * @return String
	 */

	public String getValor(Element e) {
		String retorno = "";
		try {
			retorno = e.getFirstChild().getNodeValue();
		} catch (Exception ex) {
			retorno = "";
		}
		return retorno;
	}
	/**
	 * Devuelve el atributo especificado de un nodo
	 * 
	 * @param Node nodo
	 * @param String nombreAtributo
	 * 
	 * @return String
	 */
	
	public String AtributoValor(Node nodo, String nombreAtributo) {
		try {
			String valor = nodo.getAttributes().getNamedItem(nombreAtributo).getNodeValue();
			return valor;
		} catch (Exception ex) {
			return "";
		}
		
	}
	/**
	 * Devuelve el atributo especificado de un nodo dado un Document
	 * 
	 * @param Document dom
	 * @param Node nodo
	 * @param String nombreAtributo
	 * 
	 * @return String
	 */
	
	public String getXMLValue(Document dom, String nodo, String attribute){
		NodeList nlRequest = getNodeList(dom,nodo);
		String value="";
		for (int h = 0; h < nlRequest.getLength(); h++) {
			Node nRequest = nlRequest.item(h);
			value = AtributoValor(nRequest, attribute);
		}
		return value;
		
	}





}
