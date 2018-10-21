package com.photel.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.stringtemplate.v4.compiler.STParser.compoundElement_return;

import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.SerializableHelper;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLFactory244;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.data.BDL.IBdlHotels;
import com.photel.webserviceClient.BDL244.BDLFactory244;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	String str="&lt;PurchaseCancelRS xmlns=&quot;http://www.hotelbeds.com/schemas/2005/06/messages&quot; xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot; xsi:schemaLocation=&quot;http://www.hotelbeds.com/schemas/2005/06/messages PurchaseCancelRS.xsd&quot; type=&quot;C&quot;&gt;&lt;AuditData&gt;&lt;ProcessTime&gt;293&lt;/ProcessTime&gt;&lt;Timestamp&gt;2012-10-30 11:41:34.906&lt;/Timestamp&gt;&lt;RequestHost&gt;82.223.216.227:227&lt;/RequestHost&gt;&lt;ServerName&gt;LIVE&lt;/ServerName&gt;&lt;ServerId&gt;54&lt;/ServerId&gt;&lt;SchemaRelease&gt;2005/06&lt;/SchemaRelease&gt;&lt;HydraCoreRelease&gt;2.0.201209211155&lt;/HydraCoreRelease&gt;&lt;HydraEnumerationsRelease&gt;1.0.201209211155&lt;/HydraEnumerationsRelease&gt;&lt;MerlinRelease&gt;N/A&lt;/MerlinRelease&gt;&lt;/AuditData&gt;&lt;Purchase purchaseToken=&quot;54114134206&quot; timeToExpiration=&quot;1799981&quot;&gt;&lt;Reference&gt;&lt;FileNumber&gt;1122268&lt;/FileNumber&gt;&lt;IncomingOffice code=&quot;1&quot;&gt;&lt;/IncomingOffice&gt;&lt;/Reference&gt;&lt;Status&gt;CANCELLED&lt;/Status&gt;&lt;Agency&gt;&lt;Code&gt;53317&lt;/Code&gt;&lt;Branch&gt;1&lt;/Branch&gt;&lt;/Agency&gt;&lt;Language&gt;ENG&lt;/Language&gt;&lt;CreationDate date=&quot;20121030&quot;/&gt;&lt;CreationUser&gt;ONLINE4YOU53317&lt;/CreationUser&gt;&lt;Holder type=&quot;AD&quot;&gt;&lt;Age&gt;0&lt;/Age&gt;&lt;Name&gt;ENG&lt;/Name&gt;&lt;LastName&gt;ENG&lt;/LastName&gt;&lt;/Holder&gt;&lt;AgencyReference&gt;189&lt;/AgencyReference&gt;&lt;ServiceList&gt;&lt;Service xsi:type=&quot;ServiceHotel&quot; SPUI=&quot;1#H#1&quot;&gt;&lt;Reference&gt;&lt;FileNumber&gt;1122268-H1&lt;/FileNumber&gt;&lt;IncomingOffice code=&quot;1&quot;&gt;&lt;/IncomingOffice&gt;&lt;/Reference&gt;&lt;Status&gt;CANCELLED&lt;/Status&gt;&lt;ContractList&gt;&lt;Contract&gt;&lt;Name&gt;CG-TODOS&lt;/Name&gt;&lt;IncomingOffice code=&quot;1&quot;&gt;&lt;/IncomingOffice&gt;&lt;/Contract&gt;&lt;/ContractList&gt;&lt;Supplier name=&quot;HOTELBEDS PRODUCT,S.L.U.&quot; vatNumber=&quot;B38877676&quot;/&gt;&lt;CommentList&gt;&lt;Comment type=&quot;SERVICE&quot;&gt;&lt;/Comment&gt;&lt;/CommentList&gt;&lt;DateFrom date=&quot;20130211&quot;/&gt;&lt;DateTo date=&quot;20130214&quot;/&gt;&lt;Currency code=&quot;EUR&quot;&gt;Euro&lt;/Currency&gt;&lt;TotalAmount&gt;0.000&lt;/TotalAmount&gt;&lt;AdditionalCostList&gt;&lt;AdditionalCost type=&quot;AG_COMMISSION&quot;&gt;&lt;Price&gt;&lt;Amount&gt;0.000&lt;/Amount&gt;&lt;/Price&gt;&lt;/AdditionalCost&gt;&lt;AdditionalCost type=&quot;COMMISSION_VAT&quot;&gt;&lt;Price&gt;&lt;Amount&gt;0.000&lt;/Amount&gt;&lt;/Price&gt;&lt;/AdditionalCost&gt;&lt;AdditionalCost type=&quot;COMMISSION_PCT&quot;&gt;&lt;Price&gt;&lt;Amount&gt;15.000&lt;/Amount&gt;&lt;/Price&gt;&lt;/AdditionalCost&gt;&lt;/AdditionalCostList&gt;&lt;ModificationPolicyList&gt;&lt;ModificationPolicy&gt;Cancellation&lt;/ModificationPolicy&gt;&lt;ModificationPolicy&gt;Confirmation&lt;/ModificationPolicy&gt;&lt;ModificationPolicy&gt;Modification&lt;/ModificationPolicy&gt;&lt;/ModificationPolicyList&gt;&lt;HotelInfo xsi:type=&quot;ProductHotel&quot;&gt;&lt;Code&gt;8701&lt;/Code&gt;&lt;Name&gt;Kensington Econotels&lt;/Name&gt;&lt;Category type=&quot;SIMPLE&quot; code=&quot;1LL&quot;&gt;1 KEY&lt;/Category&gt;&lt;Destination type=&quot;SIMPLE&quot; code=&quot;PMI&quot;&gt;&lt;Name&gt;Majorca&lt;/Name&gt;&lt;ZoneList&gt;&lt;Zone type=&quot;SIMPLE&quot; code=&quot;30&quot;&gt;Magaluf&lt;/Zone&gt;&lt;/ZoneList&gt;&lt;/Destination&gt;&lt;/HotelInfo&gt;&lt;AvailableRoom&gt;&lt;HotelOccupancy&gt;&lt;RoomCount&gt;1&lt;/RoomCount&gt;&lt;Occupancy&gt;&lt;AdultCount&gt;2&lt;/AdultCount&gt;&lt;ChildCount&gt;0&lt;/ChildCount&gt;&lt;/Occupancy&gt;&lt;/HotelOccupancy&gt;&lt;HotelRoom SHRUI=&quot;KtHaW01OPuz6mB1GUSB9sQ==&quot; availCount=&quot;1&quot; status=&quot;CANCELLED&quot;&gt;&lt;Board type=&quot;SIMPLE&quot; code=&quot;SC-E10&quot;&gt;SELF CATERING&lt;/Board&gt;&lt;RoomType type=&quot;SIMPLE&quot; code=&quot;APT-E10&quot; characteristic=&quot;C2&quot;&gt;APARTMENT 2 PEOPLE&lt;/RoomType&gt;&lt;Price&gt;&lt;Amount&gt;0.000&lt;/Amount&gt;&lt;/Price&gt;&lt;HotelRoomExtraInfo&gt;&lt;ExtendedData&gt;&lt;Name&gt;INFO_ROOM_AGENCY_BOOKING_STATUS&lt;/Name&gt;&lt;Value&gt;O&lt;/Value&gt;&lt;/ExtendedData&gt;&lt;ExtendedData&gt;&lt;Name&gt;INFO_ROOM_INCOMING_BOOKING_STATUS&lt;/Name&gt;&lt;Value&gt;O&lt;/Value&gt;&lt;/ExtendedData&gt;&lt;/HotelRoomExtraInfo&gt;&lt;/HotelRoom&gt;&lt;/AvailableRoom&gt;&lt;/Service&gt;&lt;/ServiceList&gt;&lt;Currency code=&quot;EUR&quot;&gt;&lt;/Currency&gt;&lt;PaymentData&gt;&lt;PaymentType code=&quot;C&quot;&gt;&lt;/PaymentType&gt;&lt;Description&gt;The total amount for this pro-forma invoice should be made in full to Beds On Line, Bank: BBVA(Palma de Mallorca) Account:0182-4899-16-0200711397,  SWIFT:BBVAESMMXXX,  7 days prior to clients arrival (except group bookings with fixed days in advance at the time of the confirmation) . Please indicate our reference number when making payment. Thank you for your cooperation., NOTICE: SWIFT CODE CHANGED&lt;/Description&gt;&lt;/PaymentData&gt;&lt;TotalPrice&gt;0.000&lt;/TotalPrice&gt;&lt;/Purchase&gt;&lt;Currency code=&quot;EUR&quot;&gt;&lt;/Currency&gt;&lt;Amount&gt;0.000&lt;/Amount&gt;&lt;/PurchaseCancelRS&gt;";
	System.out.println(StringEscapeUtils.unescapeHtml(str));
		//TODO Auto-generated method stub
		//System.out.println(DigestUtils.shaHex("El coche amarillo"));
		//str="Error en el procedimiento, int&#195;&#169;ntelo m&#195;&#161;s tarde o p&#195;&#179;ngase en contacto con";
		
		IBDLFactory244 bdl = new BDLFactory244("OL4U");

		//bdl.getHotel("1500", "CAS");
		
		Calendar ini=DateTimeUtil.getCalendar("20130827", "0000");
		Calendar fin=DateTimeUtil.getCalendar("20130906", "0000");
		List<List<String>> distribuciones=new ArrayList<List<String>>();
		List<String> roomCount=new ArrayList<String>();
		ArrayList<String> paxes = null;
		paxes = new ArrayList<String>();
		paxes.add("ADT#0#nom#cog#void");
		paxes.add("ADT#0#void#void#void");
		//paxes.add("NIN#5#void#void#void");
		//paxes.add("NIN#5#Nom3#Cognom13 Cognom23#20070312");
		roomCount.add("1");
		distribuciones.add(paxes);
		/*
		paxes = new ArrayList<String>();
		paxes.add("ADT#0#void#void#void");
		paxes.add("ADT#0#void#void#void");
		roomCount.add("1");
		distribuciones.add(paxes);
		*/
		String idSession="8";
		String numPagina="-1";
		String idioma="CAS";
		String zona="LEI";
		
		
		IBDLHotel hot;
		/*
		hot = bdl.cancelValuation(null,idioma, "1067627",1);
		hot = bdl.cancelConfirm(null,idioma, "1067627",1);
		*/
		IBDLDisponibilidad dispo=null;
		GregorianCalendar cal1=new GregorianCalendar();
		String codigosDeHotel="297";
		dispo = bdl.getDisponibilidad(distribuciones,roomCount, ini, fin, idSession, numPagina, idioma, zona,true,codigosDeHotel);
		//hot = bdl.getHotelDetails(dispo.getHoteles().get(0), idioma);
		//dispo=bdl.ordenaHotelesDESC(dispo);
		GregorianCalendar cal2=new GregorianCalendar();
		System.out.println(DateTimeUtil.getElapsetTime(cal1, cal2));
		System.out.println(cal1.getTime().toString());
		System.out.println(cal2.getTime().toString());
		System.out.println(cal1.compareTo(cal2));
		System.out.println(cal2.compareTo(cal1));
		List<String> seleccion=new ArrayList<String>();
		seleccion.add("DBT-TH1##DX-ZZ##RO-TH1");
		seleccion.add("DBT-TH1##DX##RO-TH1");
		
		IBDLHotel pHotel=null;
		for (int i=0;i<dispo.getHoteles().size();i++){
			if (dispo.getHoteles().get(i).getServicioCodigo().equals("158875")){
				pHotel = dispo.getHoteles().get(i);
			}
		}
		
		//pHotel=bdl.getHDetailFacilitesGrouped(pHotel, idioma);
		
		
		String codigoHotel="158875";
		String codigoClasificacion="SPE";
		String tokenDeDispo=dispo.getTokenDispo();
		String nombreContrato="OFS-ALL";
		int idOficina=321;
		
		IBDLHotel hotel = bdl.bloquearReserva(pHotel, ini, fin,  distribuciones, idOficina, nombreContrato, idioma,
				  codigoHotel,
				  zona,  codigoClasificacion,
					 seleccion,  tokenDeDispo);
		GregorianCalendar cal = new GregorianCalendar();
		cal.add(Calendar.YEAR, -30);
		hotel.getContratos().get(0).getDistribuciones().get(0).getPaxes().get(0).setFechaNacimiento(cal);
		hotel.getContratos().get(0).getDistribuciones().get(0).getPaxes().get(0).setNombre("nombre");
		hotel.getContratos().get(0).getDistribuciones().get(0).getPaxes().get(0).setApellidos("apellidos");
		System.out.println(hotel.getContratos().get(0).getDistribuciones().get(0).toString());
		System.out.println(hotel.getContratos().get(0).getDistribuciones().get(1).toString());
		String idReserva="willyWilly001";
		hotel=bdl.confirmarReserva(idioma, idReserva, distribuciones, hotel);
		
		System.out.println("Done!!");
	}

}
