package com.photel.webserviceClient.BDL244;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.photel.commonServices.util.JaxbUtil;
import com.photel.interfaces.BDL244.IBDLCancelationPrice;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPurchase;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.webserviceClient.BDL244.Client.FrontendServiceProxy;
import com.photel.webserviceClient.BDL244.pojo.BDLCancelationPrice;
import com.photel.webserviceClient.BDL244.pojo.BDLContrato;
import com.photel.webserviceClient.BDL244.pojo.BDLDistribucion;
import com.photel.webserviceClient.BDL244.pojo.BDLHotel;
import com.photel.webserviceClient.BDL244.pojo.BDLPurchase;
import com.photel.webserviceClient.BDL244.pojo.BDLRegimen;
import com.photel.webserviceClient.BDL244.pojo.BDLRoom;
import com.photel.webserviceClient.BDL244.vo.cancel.*;
import com.photel.webserviceClient.BDL244.vo.cancel.ServiceHotelRoomList.HotelRoom;


/**
 * <p>Title: DBLFactory244</p>
 * <p>Description: Clase que implementa la versi�n 2.2.4 de los WS de BDL</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: HalconViajes.com</p>
 * @author: GPG
 * @version 1.0
 */
public class BDLFactory244Cancel {
	private static JAXBContext conector;
	
	Logger  log = Logger.getLogger("DBL");

	private XPathFactory Xfactory = XPathFactory.newInstance();
	private XPath xpath = Xfactory.newXPath();
	private static int maxHilos=10;
	private FrontendServiceProxy proxi;
	private String endpoint;
	private String user;
	private String password;
	

	public BDLFactory244Cancel(String endpoint, String user, String password) throws Exception{
		super();
		if (endpoint!=null && user!=null && password!=null){
			this.endpoint=endpoint;
			this.user=user;
			this.password=password;
			this.proxi=new FrontendServiceProxy(endpoint);
			this.conector= JAXBContext.newInstance("com.photel.webserviceClient.BDL244.vo.cancel");
		}else{
			throw new Exception("Endpoint, user or password no inicializados");
		}
	}
		
	private IBDLHotel cancelaReserva(IBDLHotel hotel,String language, String type, String locata, int officeCode) throws Exception{
		PurchaseCancelRQ cancel=new PurchaseCancelRQ();
		Credentials credentials = new Credentials();
		credentials.setUser(user);
		credentials.setPassword(password);
		cancel.setCredentials(credentials);
		cancel.setLanguage(language);
		cancel.setType(type);
		Reference ref=new Reference();
		ref.setFileNumber(locata);
		
		IncomingOffice office=new IncomingOffice();
		office.setCode(officeCode);
		
		ref.setIncomingOffice(office);
		
		cancel.setPurchaseReference(ref);
		
		String xmlPeticion = JaxbUtil.objectToXml(conector, cancel);
		
		FrontendServiceProxy proxi=new FrontendServiceProxy(endpoint);
		String returnedXml= (String) proxi.purchaseCancel(xmlPeticion);
		PurchaseCancelRS respInser = (PurchaseCancelRS) JaxbUtil.xmlToObject(conector, returnedXml);
		/*
		String returnedXml="<PurchaseCancelRS xmlns=\"http://www.hotelbeds.com/schemas/2005/06/messages\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.hotelbeds.com/schemas/2005/06/messages PurchaseCancelRS.xsd\" type=\"C\"><AuditData><ProcessTime>6295</ProcessTime><Timestamp>2012-09-11 12:45:56.642</Timestamp><RequestHost>195.76.0.0:255</RequestHost><ServerName>FORM</ServerName><ServerId>FO</ServerId><SchemaRelease>2005/06</SchemaRelease><HydraCoreRelease>2.0.201205251332</HydraCoreRelease><HydraEnumerationsRelease>1.0.201205251332</HydraEnumerationsRelease><MerlinRelease>N/A</MerlinRelease></AuditData><Purchase purchaseToken=\"FO124550297\" timeToExpiration=\"1799984\"><Reference><FileNumber>1067627</FileNumber><IncomingOffice code=\"1\"></IncomingOffice></Reference><Status>CANCELLED</Status><Agency><Code>53317</Code><Branch>1</Branch></Agency><Language>ENG</Language><CreationDate date=\"20120906\"/><CreationUser>ONLINE4YOU53317</CreationUser><Holder type=\"AD\"><Age>0</Age><Name>ASD</Name><LastName>SDFA</LastName></Holder><AgencyReference>80</AgencyReference><ServiceList><Service xsi:type=\"ServiceHotel\" SPUI=\"1#H#1\"><Reference><FileNumber>1067627-H1</FileNumber><IncomingOffice code=\"1\"></IncomingOffice></Reference><Status>CANCELLED</Status><ContractList><Contract><Name>CG-TODOS</Name><IncomingOffice code=\"1\"></IncomingOffice></Contract></ContractList><Supplier name=\"HOTELBEDS SPAIN, S.L.U.\" vatNumber=\"B28916765\"/><CommentList><Comment type=\"SERVICE\"></Comment></CommentList><DateFrom date=\"20121022\"/><DateTo date=\"20121027\"/><Currency code=\"EUR\">Euro</Currency><TotalAmount>0.000</TotalAmount><AdditionalCostList><AdditionalCost type=\"AG_COMMISSION\"><Price><Amount>0.000</Amount></Price></AdditionalCost><AdditionalCost type=\"COMMISSION_VAT\"><Price><Amount>0.000</Amount></Price></AdditionalCost><AdditionalCost type=\"COMMISSION_PCT\"><Price><Amount>15.000</Amount></Price></AdditionalCost></AdditionalCostList><ModificationPolicyList><ModificationPolicy>Cancellation</ModificationPolicy><ModificationPolicy>Confirmation</ModificationPolicy><ModificationPolicy>Modification</ModificationPolicy></ModificationPolicyList><HotelInfo xsi:type=\"ProductHotel\"><Code>1098</Code><Name>Charly&apos;s</Name><Category type=\"SIMPLE\" code=\"1LL\">1 KEY</Category><Destination type=\"SIMPLE\" code=\"PMI\"><Name>Majorca</Name><ZoneList><Zone type=\"SIMPLE\" code=\"39\">Ca&apos;n Picafort</Zone></ZoneList></Destination></HotelInfo><AvailableRoom><HotelOccupancy><RoomCount>1</RoomCount><Occupancy><AdultCount>2</AdultCount><ChildCount>2</ChildCount></Occupancy></HotelOccupancy><HotelRoom SHRUI=\"8KxAPl9UMH13+Xde20W5ZQ==\" availCount=\"1\" status=\"CANCELLED\"><Board type=\"SIMPLE\" code=\"SC-E10\">SELF CATERING</Board><RoomType type=\"SIMPLE\" code=\"APT-E10\" characteristic=\"1B-C4\">APARTMENT ONE BEDROOM-4 PEOPLE</RoomType><Price><Amount>0.000</Amount></Price><HotelRoomExtraInfo><ExtendedData><Name>INFO_ROOM_AGENCY_BOOKING_STATUS</Name><Value>O</Value></ExtendedData><ExtendedData><Name>INFO_ROOM_INCOMING_BOOKING_STATUS</Name><Value>O</Value></ExtendedData></HotelRoomExtraInfo></HotelRoom></AvailableRoom></Service></ServiceList><Currency code=\"EUR\"></Currency><PaymentData><PaymentType code=\"C\"></PaymentType><Description>The total amount for this pro-forma invoice should be made in full to Beds On Line, Bank: BBVA(Palma de Mallorca) Account:0182-4899-16-0200711397,  SWIFT:BBVAESMMXXX,  7 days prior to clients arrival (except group bookings with fixed days in advance at the time of the confirmation) . Please indicate our reference number when making payment. Thank you for your cooperation., NOTICE: SWIFT CODE CHANGED</Description></PaymentData><TotalPrice>0.000</TotalPrice></Purchase><Currency code=\"EUR\"></Currency><Amount>0.000</Amount></PurchaseCancelRS>";
		PurchaseCancelRS respInser = (PurchaseCancelRS) JaxbUtil.xmlToObject(conector, returnedXml);
		*/
		log.info("Peticion:");
		log.info(xmlPeticion);
		log.info("");
		log.info("Respuesta:");
		log.info(returnedXml);
		
		
		IBDLHotel pHotel=convierteABDLHotel(hotel,respInser, xmlPeticion, returnedXml);
		
		
		return pHotel;
		
	}
	
	public IBDLHotel cancelValuation(IBDLHotel hotel,String language, String locata,int officeCode) throws Exception{
		String type="V";
		IBDLHotel cancel=this.cancelaReserva(hotel,language, type, locata,  officeCode);
		return cancel;
	}
	public IBDLHotel cancelConfirm(IBDLHotel hotel,String language, String locata,int officeCode) throws Exception{
		String type="C";
		IBDLHotel cancel=this.cancelaReserva(hotel,language, type, locata,  officeCode);
		return cancel;
	}
	
	
	public IBDLHotel convierteABDLHotel(IBDLHotel hotel, PurchaseCancelRS purchaseCancel,  String xmlPeticion,String xmlPurchase) throws Exception {
		//IBDLHotel pHotel=new BDLHotel(distribuciones);
		IBDLHotel pHotel=hotel;
		pHotel=pHotel==null?new BDLHotel():pHotel;
		
		ServiceHotel srv = (ServiceHotel) purchaseCancel.getPurchase().getServiceList().getService().get(0);
		ProductHotel info=srv.getHotelInfo();
		pHotel.setNombre(info.getName());
		
		List<Contract> contracts=srv.getContractList().getContract();
		if (pHotel.getContratos().size()==0){
			pHotel.getContratos().add(new BDLContrato());
		}
		for (int ii=0;ii<contracts.size();ii++){
			
			if (contracts.get(ii).getName()!=null){
				
				pHotel.getContratos().get(0).setNombre(contracts.get(ii).getName());
			}
			if (contracts.get(ii).getClassification()!=null){
				pHotel.getContratos().get(0).setCodigoClasificacion(contracts.get(ii).getClassification().getCode());
				pHotel.getContratos().get(0).setClasificacion(contracts.get(ii).getClassification().getValue());
			}
			if (contracts.get(ii).getIncomingOffice()!=null){
				pHotel.getContratos().get(0).setCodigoOficina(String.valueOf(contracts.get(ii).getIncomingOffice().getCode()));
				pHotel.getContratos().get(0).setOficina(contracts.get(ii).getIncomingOffice().getDescription());
			}
		}
		
		String codiSrv = info.getCode();
		String nombre = info.getName();
		String nomZona = info.getDestination().getName();
		String acodZonaProveedor = info.getDestination().getCode();
		String categ = info.getCategory().getValue();
		String codCateg = info.getCategory().getCode();
		pHotel.setServicioCodigo(codiSrv);
		pHotel.setServicio(nombre);
		pHotel.setZona(nomZona);
		pHotel.setZonaCodigo(acodZonaProveedor);
		pHotel.setCategoria(categ);
		pHotel.setCategoriaCodigo(codCateg);
		
		
		if(info.getPosition()!=null){
			if (info.getPosition().getLatitude()!=null){
				pHotel.setLatitud(info.getPosition().getLatitude().toString());
			}
			if (info.getPosition().getLatitude()!=null){
				pHotel.setLongitud(info.getPosition().getLongitude().toString());
			}
		}
		if (info.getImageList()!=null && info.getImageList().getImage()!=null && info.getImageList().getImage().size()!=0){
			List<String> fotos=new ArrayList<String>();
			String img=info.getImageList().getImage().get(0).getUrl();
			img=img.substring(0, img.indexOf("/small/")) + img.substring(img.indexOf("/small/")+6, img.length());
			fotos.add(img);
			
			pHotel.setImagenes(fotos);
		}
		
		for (int i=0;i<srv.getAvailableRoom().size();i++){
			
			ServiceHotelRoomList rooms = srv.getAvailableRoom().get(i);
			for (int r=0;r<rooms.getHotelRoom().size();r++){
				HotelRoom room = rooms.getHotelRoom().get(r);
				IBDLRoom habitacion = new BDLRoom();
				habitacion.setHabitacionCodigo(room.getRoomType().getCode());
				habitacion.setHabitacion(formatCapitalizeAllWords(room.getRoomType().getValue()));
				habitacion.setHabitacionCaracteristica(room.getRoomType().getCharacteristic());
				
				ProductHotelBoard board = room.getBoard();
				IBDLRegimen reg=new BDLRegimen();
				reg.setCodigo(board.getCode());
				reg.setDescripcion(formatCapitalizeAllWords(board.getValue()));
				double precio = room.getPrice().getAmount().doubleValue();
				reg.setPrecio(new BigDecimal(precio));
				List<IBDLRegimen> regimenesAlimentarios= new ArrayList<IBDLRegimen>();
				regimenesAlimentarios.add(reg);
				habitacion.setRegimenesAlimentarios(regimenesAlimentarios);
			    if(room.getCancellationPolicy()!=null){
					for (Price p : room.getCancellationPolicy().getPrice()){
						IBDLCancelationPrice cancelPrice=new BDLCancelationPrice();
						cancelPrice.setCancelationAmount(p.getAmount());
						cancelPrice.setCancelationFrom(getCalendar(p.getDateTimeFrom().getDate(), p.getDateTimeFrom().getTime()));
						cancelPrice.setCancelationTo(getCalendar(p.getDateTimeTo().getDate(), p.getDateTimeTo().getTime()));
						habitacion.getPreciosCancelacion().add(cancelPrice);
				    }
			    }
				List<IBDLRoom> listaHabitaciones=new ArrayList<IBDLRoom>();
				listaHabitaciones.add(habitacion);
				if (pHotel.getContratos().get(0).getDistribuciones().size()<=i){
					pHotel.getContratos().get(0).getDistribuciones().add(new BDLDistribucion());
				}
				pHotel.getContratos().get(0).getDistribuciones().get(i).setRooms(listaHabitaciones);
			}
			
		}
		BigDecimal total = purchaseCancel.getPurchase().getTotalPrice();
		IBDLPurchase purchase=new BDLPurchase(total);
		purchase.setStatus(purchaseCancel.getPurchase().getStatus().name());
		purchase.setToken(purchaseCancel.getPurchase().getPurchaseToken());
		
		
		purchase.getXmlsPurchase().add(xmlPeticion);
		purchase.getXmlsPurchase().add(xmlPurchase);
		
		List<AdditionalCost> addCost = srv.getAdditionalCostList().getAdditionalCost();
		
		for (int i=0;i<addCost.size();i++){
			if(addCost.get(i).getType().equals("AG_COMMISSION")){
				BigDecimal price=BigDecimal.ZERO;
				for(Price p : addCost.get(i).getPrice()){
					price=price.add(p.getAmount());
				}
				purchase.setAgComission(price);		
			}
			if(addCost.get(i).getType().equals("COMMISSION_VAT")){
				BigDecimal price=BigDecimal.ZERO;
				for(Price p : addCost.get(i).getPrice()){
					price=price.add(p.getAmount());
				}
				purchase.setComissionVAT(price);
			}
		}
		purchase.setToPay(purchase.getAgComission().add(purchase.getComissionVAT()));
		
		pHotel.setPurchase(purchase);
		//pHotel.setAvailToken(tokenDeDispo);
		pHotel.setSPUI(srv.getSPUI());
		
		
		
		
		return pHotel;
		
	}
	private GregorianCalendar getCalendar(String fecha, String hora) {
		GregorianCalendar cal=new GregorianCalendar();
		cal.set(Calendar.YEAR, Integer.parseInt(fecha.substring(0, 4)));
		cal.set(Calendar.MONTH, Integer.parseInt(fecha.substring(4, 6))-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fecha.substring(6, 8)));
		hora=hora==null?"0000":hora;
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora.substring(0, 2)));
		cal.set(Calendar.MINUTE, Integer.parseInt(hora.substring(2, 4)));
		return cal;

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
}
