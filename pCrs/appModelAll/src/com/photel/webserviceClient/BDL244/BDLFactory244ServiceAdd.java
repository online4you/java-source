package com.photel.webserviceClient.BDL244;

import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.JaxbUtil;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLCancelationPrice;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDiscount;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPurchase;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.webserviceClient.BDL244.Client.FrontendServiceProxy;
import com.photel.webserviceClient.BDL244.vo.serviceAddRQ.*;
import com.photel.webserviceClient.BDL244.vo.serviceAddRQ.ServiceHotelRoomList.*;
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
public class BDLFactory244ServiceAdd {
	private static JAXBContext conector;
	
	Logger  log = Logger.getLogger("DBL");

	private XPathFactory Xfactory = XPathFactory.newInstance();
	private XPath xpath = Xfactory.newXPath();
	private static int maxHilos=10;
	private FrontendServiceProxy proxi;
	private String endpoint;
	private String user;
	private String password;
	

	public BDLFactory244ServiceAdd(String endpoint, String user, String password) throws Exception{
		super();
		if (endpoint!=null && user!=null && password!=null){
			this.endpoint=endpoint;
			this.user=user;
			this.password=password;
			this.proxi=new FrontendServiceProxy(endpoint);
			this.conector= JAXBContext.newInstance("com.photel.webserviceClient.BDL244.vo.serviceAddRQ");
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
		holder.setCustomerId("1");
		holder.setType(HotelbedsCustomerType.AD);
		holder.setLastName(lastName);
		holder.setName(name);
		String fecha=getFecha(fechaNacimiento);
		DateTime fecNac = new DateTime();
		fecNac.setDate(fecha);
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
	public IBDLHotel bloquearReserva(IBDLHotel hotel,
									Calendar fechaEntrada, 
									Calendar fechaSalida, //YYYYMMDD
									List<List<String>> distribuciones, 
									int ofi, 
									String nombreContrato,
									String idi, 
									String codigoHotel, 
									String codigoZona, 
									String codigoClasificacion, 
									List<String> seleccion, 
									String tokenDeDispo) throws Exception  {
		
			ServiceAddRQ petAddServ = new ServiceAddRQ();

			petAddServ.setLanguage(idi);
			Credentials credentials = new Credentials();
			credentials.setUser(user);
			credentials.setPassword(password);
			petAddServ.setCredentials(credentials);
			ServiceHotel servicio = new ServiceHotel();

			
			DateTime fec = new DateTime();
			fec.setDate(getFecha(fechaEntrada));
			servicio.setDateFrom(fec);
			fec = new DateTime();
			fec.setDate(getFecha(fechaSalida));
			servicio.setDateTo(fec);
			
			ProductHotel hotelInfo=new ProductHotel();
			hotelInfo.setCode(codigoHotel);
			Destination destino=new Destination();
			destino.setType(SimpleGroup.SIMPLE);
			destino.setCode(codigoZona);
			hotelInfo.setDestination(destino);
			

			servicio.setHotelInfo(hotelInfo);
			
			List<ServiceHotelRoomList> rooms = this.getOcupacy(distribuciones, seleccion);
			servicio.getAvailableRoom().addAll(rooms);
			
			ContractList contratos=new ContractList();
			Contract contrato = new Contract();
			contrato.setName(nombreContrato);
			IncomingOffice oficina = new IncomingOffice();
			oficina.setCode(ofi);
			contrato.setIncomingOffice(oficina);
			ContractClassification clasi=new ContractClassification();
			clasi.setCode(codigoClasificacion);
			contrato.setClassification(clasi);
			contratos.getContract().add(contrato);
			servicio.setContractList(contratos);
			servicio.setAvailToken(tokenDeDispo);
			petAddServ.setService(servicio);

			String xmlPeticion = JaxbUtil.objectToXml(conector, petAddServ);
			
			FrontendServiceProxy proxi=new FrontendServiceProxy(endpoint);
			String returnedXml;
			returnedXml= (String) proxi.serviceAdd(xmlPeticion);
			//returnedXml="<ServiceAddRS xmlns="http://www.hotelbeds.com/schemas/2005/06/messages" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.hotelbeds.com/schemas/2005/06/messages ServiceAddRS.xsd"><AuditData><ProcessTime>1979</ProcessTime><Timestamp>2012-08-01 12:44:15.466</Timestamp><RequestHost>195.76.0.0:255</RequestHost><ServerName>FORM</ServerName><ServerId>FO</ServerId><SchemaRelease>2005/06</SchemaRelease><HydraCoreRelease>2.0.201205251332</HydraCoreRelease><HydraEnumerationsRelease>1.0.201205251332</HydraEnumerationsRelease><MerlinRelease>N/A</MerlinRelease></AuditData><Purchase purchaseToken="FO124413139" timeToExpiration="1798049"><Status>SHOPPING_CART</Status><Agency><Code>15465</Code><Branch>1</Branch></Agency><Language>CAS</Language><CreationUser>HALCOCOM</CreationUser><ServiceList><Service xsi:type="ServiceHotel" SPUI="1#H#1"><Status>NEW</Status><ContractList><Contract><Name>CG-TODOS SC2</Name><IncomingOffice code="1"></IncomingOffice></Contract></ContractList><Supplier name="HOTELBEDS SPAIN S.L.U." vatNumber="B28916765"/><DateFrom date="20121009"/><DateTo date="20121015"/><Currency code="EUR">Euro</Currency><TotalAmount>469.860</TotalAmount><DiscountList><Price unitCount="6" paxCount="1"><Amount>0.000</Amount><DateTimeFrom date="20121009"/><DateTimeTo date="20121015"/><Description>NI&#209;O Primero Ni&#241;o</Description></Price></DiscountList><AdditionalCostList><AdditionalCost type="AG_COMMISSION"><Price><Amount>75.170</Amount></Price></AdditionalCost><AdditionalCost type="COMMISSION_VAT"><Price><Amount>13.540</Amount></Price></AdditionalCost></AdditionalCostList><ModificationPolicyList><ModificationPolicy>Cancellation</ModificationPolicy><ModificationPolicy>Confirmation</ModificationPolicy><ModificationPolicy>Modification</ModificationPolicy></ModificationPolicyList><HotelInfo xsi:type="ProductHotel"><Code>1535</Code><Name>BelleVue Club</Name><Category type="SIMPLE" code="3EST">3 ESTRELLAS</Category><Destination type="SIMPLE" code="PMI"><Name>Mallorca</Name><ZoneList><Zone type="SIMPLE" code="40">Puerto de Alcudia</Zone></ZoneList></Destination></HotelInfo><AvailableRoom><HotelOccupancy><RoomCount>1</RoomCount><Occupancy><AdultCount>2</AdultCount><ChildCount>1</ChildCount><GuestList><Customer type="AD"><CustomerId>1</CustomerId><Age>30</Age><Name>Nom</Name><LastName>Cognom1 Cognom2</LastName><BirthDate date="19760312"/></Customer><Customer type="AD"><CustomerId>2</CustomerId><Age>30</Age><Name>Nom2</Name><LastName>Cognom12 Cognom22</LastName><BirthDate date="19750312"/></Customer><Customer type="CH"><CustomerId>3</CustomerId><Age>5</Age><Name>Nom3</Name><LastName>Cognom13 Cognom23</LastName><BirthDate date="20070312"/></Customer></GuestList></Occupancy></HotelOccupancy><HotelRoom SHRUI="0fZQ8R8WvffsraXvqJ+9CQ==" availCount="1" status="NEW"><Board type="SIMPLE" code="SC-E10">SOLO ALOJAMIENTO</Board><RoomType type="SIMPLE" code="STU-E10" characteristic="ST">Studio STANDARD</RoomType><Price><Amount>137.340</Amount></Price><CancellationPolicy><Price><Amount>22.890</Amount><DateTimeFrom date="20121006" time="2359"/><DateTimeTo date="20121009"/></Price></CancellationPolicy></HotelRoom></AvailableRoom><AvailableRoom><HotelOccupancy><RoomCount>2</RoomCount><Occupancy><AdultCount>4</AdultCount><ChildCount>0</ChildCount><GuestList><Customer type="AD"><CustomerId>4</CustomerId><Age>30</Age><Name>Nom1</Name><LastName>Cognom11 Cognom21</LastName><BirthDate date="19760312"/></Customer><Customer type="AD"><CustomerId>5</CustomerId><Age>30</Age><Name>Nom2</Name><LastName>Cognom12 Cognom22</LastName><BirthDate date="19750312"/></Customer><Customer type="AD"><CustomerId>6</CustomerId><Age>30</Age><Name>Nom3</Name><LastName>Cognom13 Cognom23</LastName><BirthDate date="19740312"/></Customer><Customer type="AD"><CustomerId>7</CustomerId><Age>30</Age><Name>Nom4</Name><LastName>Cognom14 Cognom24</LastName><BirthDate date="19730312"/></Customer><Customer type="AD"><CustomerId>8</CustomerId><Age>30</Age></Customer><Customer type="AD"><CustomerId>9</CustomerId><Age>30</Age></Customer><Customer type="AD"><CustomerId>10</CustomerId><Age>30</Age></Customer><Customer type="AD"><CustomerId>11</CustomerId><Age>30</Age></Customer></GuestList></Occupancy></HotelOccupancy><HotelRoom SHRUI="x/80PiHpnLA8H2/W9zexRA==" availCount="2" status="NEW"><Board type="SIMPLE" code="SC-E10">SOLO ALOJAMIENTO</Board><RoomType type="SIMPLE" code="APT-E10" characteristic="1B-C4">APARTAMENTO 1 DORMITORIO-4 PAX</RoomType><Price><Amount>332.520</Amount></Price><CancellationPolicy><Price><Amount>55.420</Amount><DateTimeFrom date="20121006" time="2359"/><DateTimeTo date="20121009"/></Price></CancellationPolicy></HotelRoom></AvailableRoom></Service></ServiceList><Currency code="EUR"></Currency><TotalPrice>469.860</TotalPrice></Purchase></ServiceAddRS>";
			ServiceAddRS respInSer = (ServiceAddRS) JaxbUtil.xmlToObject(conector, returnedXml);
			
			log.info("Peticion:");
			log.info(xmlPeticion);
			log.info("");
			log.info("Respuesta:");
			log.info(returnedXml);
			
			IBDLHotel pHotel=convierteABDLHotel(hotel, respInSer,distribuciones, xmlPeticion, returnedXml, tokenDeDispo);
			
			return pHotel;
			
			
		
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
	public IBDLHotel convierteABDLHotel(IBDLHotel hotel, ServiceAddRS serviceRS, List<List<String>> distribuciones, String xmlPeticion,String xmlPurchase, String tokenDeDispo) throws Exception {
		//IBDLHotel pHotel=new BDLHotel(distribuciones);
		IBDLHotel pHotel=hotel;
		ServiceHotel srv = (ServiceHotel) serviceRS.getPurchase().getServiceList().getService().get(0);
		ProductHotel info=srv.getHotelInfo();
		pHotel.setNombre(info.getName());
		
		List<Contract> contracts=srv.getContractList().getContract();
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
			if (contracts.get(ii).getCommentList()!=null && contracts.get(ii).getCommentList().getComment()!=null && contracts.get(ii).getCommentList().getComment().size()>0){
				List<String> coments = pHotel.getContratos().get(0).getComentarios();
				coments=coments==null?new ArrayList<String>():coments;
				for (int i=0;i<contracts.get(ii).getCommentList().getComment().size();i++){
					coments.add(contracts.get(ii).getCommentList().getComment().get(i).getType()+"##TYPE##"+contracts.get(ii).getCommentList().getComment().get(i).getValue());
				}
				 pHotel.getContratos().get(0).setComentarios(coments);
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
			    for (Price p : room.getCancellationPolicy().getPrice()){
					IBDLCancelationPrice cancelPrice=new BDLCancelationPrice();
					cancelPrice.setCancelationAmount(p.getAmount());
					cancelPrice.setCancelationFrom(getCalendar(p.getDateTimeFrom().getDate(), p.getDateTimeFrom().getTime()));
					cancelPrice.setCancelationTo(getCalendar(p.getDateTimeTo().getDate(), p.getDateTimeTo().getTime()));
					habitacion.getPreciosCancelacion().add(cancelPrice);
			    }
				List<IBDLRoom> listaHabitaciones=new ArrayList<IBDLRoom>();
				listaHabitaciones.add(habitacion);
				pHotel.getContratos().get(0).getDistribuciones().get(i).setRooms(listaHabitaciones);
			}
			
		}
		BigDecimal total = serviceRS.getPurchase().getTotalPrice();
		IBDLPurchase purchase=new BDLPurchase(total);
		purchase.setStatus(serviceRS.getPurchase().getStatus().name());
		purchase.setToken(serviceRS.getPurchase().getPurchaseToken());
		
		
		purchase.getXmlsPurchase().add(xmlPeticion);
		purchase.getXmlsPurchase().add(xmlPurchase);
		
		if (srv.getDiscountList()!=null && srv.getDiscountList().getPrice()!=null){
			List<Price> dis = srv.getDiscountList().getPrice();
			List<IBDLDiscount> discounts = purchase.getDiscount();
			for (int i=0;i<dis.size();i++){
				IBDLDiscount disco=new BDLDiscount();
				Price discount = dis.get(i);
				disco.setAmount(discount.getAmount());
				disco.setDateTimeFrom(getCalendar(discount.getDateTimeFrom().getDate(), discount.getDateTimeFrom().getTime()));
				disco.setDateTimeTo(getCalendar(discount.getDateTimeTo().getDate(), discount.getDateTimeTo().getTime()));
				disco.setDescription(discount.getDescription());
				disco.setPaxCount(discount.getPaxCount());
				disco.setUnitCount(discount.getUnitCount());
				discounts.add(disco);
			}
			purchase.setDiscount(discounts);
		}
		
		
		
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
		pHotel.setAvailToken(tokenDeDispo);
		pHotel.setSPUI(srv.getSPUI());
		
		
		
		
		return pHotel;
		
	}
	private List<ServiceHotelRoomList> getOcupacy(List<List<String>> distribuciones, List<String> seleccion) throws Exception{
		List<ServiceHotelRoomList> romList=new ArrayList<ServiceHotelRoomList>();
		ServiceHotelOccupancy soc=new ServiceHotelOccupancy();
		ServiceOccupancy so=new ServiceOccupancy();
		CustomerList guest;
		int ad;
		int ch;
		for (int h=0;h<distribuciones.size();h++){
			ServiceHotelRoomList room = new ServiceHotelRoomList();
			List<String> paxes = distribuciones.get(h);
			ad=numAdultosDistribucion(distribuciones,h);
			ch=numNinosDistribucion(distribuciones,h);
			soc=new ServiceHotelOccupancy();
			so=new ServiceOccupancy();
			guest=crearListadoPax(distribuciones,h);
			so.setGuestList(guest);
			so.setAdultCount(ad);
			so.setChildCount(ch);
			soc.setOccupancy(so);
			soc.setRoomCount(1);
			room.setHotelOccupancy(soc);
			HotelRoom hotelRoom=new HotelRoom();
			ServiceHotelRoomType roomType=new ServiceHotelRoomType();
			//roomCode##clasification##boardCode --> STU-E10##ST##SC-E10 APT-E10##1B-C4##SC-E10
			String sel = seleccion.get(h);
			String[] selArr = sel.split("##");
			roomType.setCode(selArr[0]);
			roomType.setType(SimpleGroup.SIMPLE);
			roomType.setCharacteristic(selArr[1]);
			hotelRoom.setRoomType(roomType);
			ProductHotelBoard board=new ProductHotelBoard();
			board.setCode(selArr[2]);
			board.setType(SimpleGroup.SIMPLE);
			hotelRoom.setBoard(board);
			room.getHotelRoom().add(hotelRoom);
			romList.add(room);
			
		}
		return romList;
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

	private int numAdultosDistribucion(List<List<String>> distribuciones, int distribucion) throws Exception {
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
			guest.getCustomer().add(customer);
		}
		
		return ad;
	}

	private int numNinosDistribucion(List<List<String>> distribuciones, int distribucion) throws Exception {
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
			guest.getCustomer().add(customer);
		}
		
		return ch;
	}

}
