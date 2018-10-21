package com.photel.webserviceClient.BDL244;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;

import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.JaxbUtil;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.webserviceClient.BDL244.Client.FrontendServiceProxy;
import com.photel.webserviceClient.BDL244.vo.purchaseRQ.*;

/**
 * <p>Title: DBLFactory244</p>
 * <p>Description: Clase que implementa la versi�n 2.2.4 de los WS de BDL</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: HalconViajes.com</p>
 * @author: GPG
 * @version 1.0
 */
public class BDLFactory244Purchase {
	private static JAXBContext conector;
	
	Logger  log = Logger.getLogger("DBL");

	private XPathFactory Xfactory = XPathFactory.newInstance();
	private XPath xpath = Xfactory.newXPath();
	private static int maxHilos=10;
	private FrontendServiceProxy proxi;
	private String endpoint;
	private String user;
	private String password;
	

	public BDLFactory244Purchase(String endpoint, String user, String password) throws Exception{
		super();
		if (endpoint!=null && user!=null && password!=null){
			this.endpoint=endpoint;
			this.user=user;
			this.password=password;
			this.proxi=new FrontendServiceProxy(endpoint);
			this.conector= JAXBContext.newInstance("com.photel.webserviceClient.BDL244.vo.purchaseRQ");
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
	private Customer crearPaxResponsable(String lastName, String name,  Calendar fechaNacimiento) {
		Customer holder = new Customer();
		//holder.setCustomerId("0");
		holder.setType(HotelbedsCustomerType.AD);
		holder.setLastName(lastName);
		holder.setName(name);
		if(fechaNacimiento!=null){
			String fecha=getFecha(fechaNacimiento);
			DateTime fecNac = new DateTime();
			fecNac.setDate(fecha);
		}
		// holder.setBirthDate(fecNac);
		return holder;

	}
	private String getFecha(Calendar cal) {
		String anyo = String.valueOf(cal.get(Calendar.YEAR));
		String mes = String.valueOf(cal.get(Calendar.MONTH)+1);
		String dia = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		mes=mes.length()==1?"0"+mes:mes;
		dia=dia.length()==1?"0"+dia:dia;
		String fecha=anyo+mes+dia;
		return fecha;

	}

	
	public IBDLHotel confirmarReserva(String idi, String idReserva,
									List<List<String>> distribuciones, 
									IBDLHotel pHotel) throws Exception{
		PurchaseConfirmRQ petConfRes = new PurchaseConfirmRQ();
		Credentials credentials = new Credentials();
		credentials.setUser(user);
		credentials.setPassword(password);
		petConfRes.setCredentials(credentials);
		petConfRes.setLanguage(idi);
		ConfirmationPurchaseData datosConfirmacion = new ConfirmationPurchaseData();
		
		String nombreResponsable=getNombreResponsable(distribuciones);
		String apellidosResponsable=getApellidosResponsable(distribuciones);
		Calendar fechaNacimientoResponsable=getFechaNacimientoResponsable(distribuciones);
		
		datosConfirmacion.setHolder(crearPaxResponsable(apellidosResponsable, nombreResponsable,  fechaNacimientoResponsable));
		ConfirmationServiceDataTicket servicioConfirmacion = new ConfirmationServiceDataTicket();
		CustomerList customerList = this.getAllPaxes(distribuciones);
		for (int i=0;i<customerList.getCustomer().size();i++){
			customerList.getCustomer().get(i).setCustomerId(String.valueOf(i+1));
		}
		servicioConfirmacion.setCustomerList(customerList);
		
		datosConfirmacion.setAgencyReference(idReserva);
		datosConfirmacion.setPurchaseToken(pHotel.getPurchase().getToken());
		
		servicioConfirmacion.setSPUI(pHotel.getSPUI());

		
		
		
		ConfirmationServiceDataList serviceData=new ConfirmationServiceDataList();
		serviceData.getServiceData().add(servicioConfirmacion);
		datosConfirmacion.setConfirmationServiceDataList(serviceData);
		
		petConfRes.setConfirmationData(datosConfirmacion);
		
		String xmlPeticion = JaxbUtil.objectToXml(conector, petConfRes);
		
		FrontendServiceProxy proxi=new FrontendServiceProxy(endpoint);
		String returnedXml= (String) proxi.purchaseConfirm(xmlPeticion);
		PurchaseConfirmRS respInser = (PurchaseConfirmRS) JaxbUtil.xmlToObject(conector, returnedXml);
		
		log.info("Peticion:");
		log.info(xmlPeticion);
		log.info("");
		log.info("Respuesta:");
		log.info(returnedXml);
		
		
		pHotel.getPurchase().getXmlsPurchase().add(xmlPeticion);
		pHotel.getPurchase().getXmlsPurchase().add(returnedXml);
		
		if (respInser.getPurchase()!=null && respInser.getPurchase().getReference()!=null){
			String localizador = respInser.getPurchase().getReference().getFileNumber();
			pHotel.getPurchase().setLocalizador(localizador);
			try{
				pHotel.getPurchase().setSupplierName(respInser.getPurchase().getServiceList().getService().get(0).getSupplier().getName());
				pHotel.getPurchase().setSupplierVatNumber(respInser.getPurchase().getServiceList().getService().get(0).getSupplier().getVatNumber());
			}catch (Exception e){}
		}
		return pHotel;
	}
	
	private String getNombreResponsable(List<List<String>> distribuciones){
		//ADT#0#Nom#Cognom1 Cognom2#19760312
		return distribuciones.get(0).get(0).split("#")[2];
	}
	private String getApellidosResponsable(List<List<String>> distribuciones){
		//ADT#0#Nom#Cognom1 Cognom2#19760312
		return distribuciones.get(0).get(0).split("#")[3];
	}
	private Calendar getFechaNacimientoResponsable(List<List<String>> distribuciones){
		//ADT#0#Nom#Cognom1 Cognom2#19760312
		String fNac= distribuciones.get(0).get(0).split("#")[4];
		if (fNac.equals("void")){
			return null;
		}
		Calendar fNacRes=DateTimeUtil.getCalendar(fNac, "0000");
		return fNacRes;
	}
	private CustomerList getAllPaxes(List<List<String>> distribuciones) throws Exception{
		CustomerList guests=new CustomerList();
		for (int h=0;h<distribuciones.size();h++){
			guests.getCustomer().addAll(crearListadoPax(distribuciones,h).getCustomer());
		}
		return guests;
	}
	private CustomerList crearListadoPax(List<List<String>> distribuciones, int distribucion) throws Exception {
		Customer customer;
		CustomerList guest=null;
		int ad;
		int ch;
		if(distribucion>distribuciones.size()){
			throw new Exception("No existe el listado de paxes!!");
		}
		List<String> paxes = distribuciones.get(distribucion);
		ad=0;
		ch=0;
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
			
			if(!pax[2].equals("void")){
				customer.setName(pax[2]);}
			if(!pax[3].equals("void")){
				customer.setLastName(pax[3]);}
			if(!pax[4].equals("void")){
				DateTime fecNac = new DateTime();
				fecNac.setDate(pax[4]);
				customer.setBirthDate(fecNac);
			}
			
						
			
			
			guest.getCustomer().add(customer);
		}
		
		return guest;
	}
}
