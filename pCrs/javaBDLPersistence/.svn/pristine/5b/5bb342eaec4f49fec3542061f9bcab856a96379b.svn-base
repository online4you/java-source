package com.photel.data.BDL;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import com.photel.commonServices.opencsv.CSVReader;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.data.BDL.facade.BdlDataFacade;
import com.photel.interfaces.data.BDL.IBdlHdetailDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotels;
import com.photel.interfaces.data.BDL.IBdlReservas;
import com.photel.interfaces.data.BDL.IBdlReservasMails;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;

public class BdlMain {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		BdlDataFacade data = new BdlDataFacade("O4U");
		ArrayList des = data.getDestinations("CAS");
		
		IBdlHotels h = data.getHotel("10031");
		
		ArrayList<String> hotelCodes=new ArrayList<String>();
		hotelCodes.add("30345");
		hotelCodes.add("84838");
		hotelCodes.add("110733");
		Hashtable<String, ArrayList<String>> obj = data.getHDetailFacilitesDispoGrouped(hotelCodes, "CAS");
		//data.loadCountries();
		//data.loadDestinations();
		//data.loadHotelDestinations();
		//data.loadHotelDescriptions();
		//data.loadHotels();
		
		Hashtable img = data.getHDetailImagesGrouped("1", "CAS");
		
		IBdlvHdetailFacilities det = data.getHDetailFacility("1", "10", "70", "CAS");
		ArrayList<IBdlvHdetailFacilities> det2 = data.getHDetailFacilites("1", "CAS");
		Hashtable<String, ArrayList<IBdlvHdetailFacilities>> det3 = data.getHDetailFacilitesGrouped("1", "CAS");
		IBdlHdetailDescriptions detail = data.getHDetailDescription("1", "CAS");
		
		IBdlReservasMails mail = data.getReservaMail(16);
		mail.setBdlAsunto("bdlAsunto");
		mail.setBdlCc("bdlCc");
		mail.setBdlCco("bdlCco");
		mail.setBdlFrom("bdlFrom");
		mail.setBdlIdReserva(25);
		mail.setBdlMail("bdlMail");
		mail.setBdlTo("bdlTo");
		data.setReservaMails(mail);
		
		IBdlReservas res2=data.getUltimaFactura();
		
		IBdlReservas res = data.getReserva(0);
		res.setBdlFacturaNumero(1);
		res=data.setReserva(res);
		res.setBdlDescuento(1.0);
		res.setBdlReservaConfirmada("1");
		res = data.getReserva(0);
		res.setBdlFacturaNumero(2);
		res=data.setReserva(res);
		
		
		
		
		
		System.out.println("Runtime.getRuntime().maxMemory()="+Runtime.getRuntime().maxMemory());
		System.out.println("Runtime.getRuntime().freeMemory()="+Runtime.getRuntime().freeMemory());
		System.out.println("Runtime.getRuntime().totalMemory()="+Runtime.getRuntime().totalMemory());

		System.out.println("In!!!");
		GregorianCalendar cal1=new GregorianCalendar();
		System.out.println(cal1.getTime().toString());
		
		
		
		GregorianCalendar cal2=new GregorianCalendar();
		System.out.println(DateTimeUtil.getElapsetTime(cal1, cal2));
		
		/*
		ArrayList<String> a=new ArrayList<String>();
		a.add("100341");
		a.add("100342");
		a.add("100343");
		a.add("100344");
		a.add("100345");
		a.add("100346");
		
		 ArrayList<IBdlHotelDescriptions> h = data.getHotelsDescriptions(a, "CAS");
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("Done!!!");
		
	}

}
