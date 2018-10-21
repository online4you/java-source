package com.photel.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLFactory244;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.webserviceClient.BDL244.BDLFactory244;

public class MainDuplicados {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
			
		IBDLFactory244 bdl = new BDLFactory244("OL4U");
		Calendar ini=DateTimeUtil.getCalendar("20121024", "0000");
		Calendar fin=DateTimeUtil.getCalendar("20121031", "0000");
		List<List<String>> distribuciones=new ArrayList<List<String>>();
		List<String> roomCount=new ArrayList<String>();
		ArrayList<String> paxes = null;
		paxes = new ArrayList<String>();
		paxes.add("ADT#0#Nom#Cognom1 Cognom2#19760312");
		paxes.add("ADT#0#Nom2#Cognom12 Cognom22#19750312");
		//paxes.add("NIN#5#Nom3#Cognom13 Cognom23#20070312");
		roomCount.add("1");
		distribuciones.add(paxes);
		paxes = new ArrayList<String>();
		paxes.add("ADT#0#Nom#Cognom1 Cognom2#19760312");
		paxes.add("ADT#0#Nom2#Cognom12 Cognom22#19750312");
		roomCount.add("1");
		distribuciones.add(paxes);
		
		String idSession="4";
		String numPagina="-1";
		String idioma="CAS";
		String zona="BCN";
		
		IBDLDisponibilidad dispo=null;
		GregorianCalendar cal1=new GregorianCalendar();
		String codigosDeHotel="121133";
		dispo = bdl.getDisponibilidad(distribuciones,roomCount, ini, fin, idSession, numPagina, idioma, zona,true,codigosDeHotel);
		//dispo=bdl.ordenaHotelesDESC(dispo);
		GregorianCalendar cal2=new GregorianCalendar();
		System.out.println(DateTimeUtil.getElapsetTime(cal1, cal2));
		System.out.println(cal1.getTime().toString());
		System.out.println(cal2.getTime().toString());
		System.out.println(cal1.compareTo(cal2));
		System.out.println(cal2.compareTo(cal1));
		List<String> seleccion=new ArrayList<String>();
		seleccion.add("STU-E10##ST##SC-E10");
		seleccion.add("APT-E10##1B-C4##SC-E10");
		
		IBDLHotel pHotel=null;
		for (int i=0;i<dispo.getHoteles().size();i++){
			if (dispo.getHoteles().get(i).getServicioCodigo().equals("1535")){
				pHotel = dispo.getHoteles().get(i);
			}
		}
		
		String codigoHotel="1535";
		String codigoClasificacion="NOR";
		String tokenDeDispo=dispo.getTokenDispo();
		String nombreContrato="CG-TODOS SC2";
		int idOficina=1;
		
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
