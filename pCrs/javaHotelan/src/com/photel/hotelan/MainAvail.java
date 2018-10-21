package com.photel.hotelan;



import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.photel.commonServices.util.SystemHelper;
import com.photel.data.hotelan.ddbb.hibernate.pojo.HibernateReservas;
import com.photel.hotelan.client.HotelanClientStub;
import com.photel.hotelan.client.IrqAvailability.IrqAvailabilityResponse;
import com.photel.hotelan.client.IrqCathegoryList.IrqCathegoryListResponse;
import com.photel.hotelan.client.IrqDestinationList.IrqDestinationListResponse;
import com.photel.hotelan.client.IrqDestinationZoneList.IrqDestinationZoneListResponse;
import com.photel.hotelan.client.IrqHotelBookingDates.IrqHotelBookingDatesResponse;
import com.photel.hotelan.client.IrqHotelDetailsList.Hotel;
import com.photel.hotelan.client.IrqHotelDetailsList.IrqHotelDetailsListResponse;
import com.photel.hotelan.client.IrqRoomTypesList.IrqRoomTypesListResponse;
import com.photel.hotelan.client.IrqVillaAvailablePrice.IrqVillaAvailablePriceResponse;
import com.photel.hotelan.client.IrqZoneList.IrqZoneListResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class MainAvail {
	private static Logger  oLog=Logger.getLogger(MainAvail.class);
	public static void main(String[] args) throws Exception {
		HotelanClientStub client= new HotelanClientStub();
		IrqHotelDetailsListResponse detail = client.getIrqHotelDetailsList("es", "292", "1", "1");
		System.out.println(detail.getHotel().get(0).getDetails().replace("\n", "<br>"));
		IrqRoomTypesListResponse roomList = client.getIrqRoomTypesList("es");
		
		HotelanFacade fac=new HotelanFacade();
		
		
		String idioma="es";
		//fac.updateLookUps();
		//fac.updateHotels();
		
		IrqRoomTypesListResponse list = fac.getRoomTypesList("es");
		IrqDestinationListResponse destinos = fac.getDestinationList(idioma);
		String destinationId=destinos.getDestinations().getDestination().get(0).getId();
		IrqDestinationZoneListResponse zonas = fac.getDestinationZoneList(idioma, destinationId);
		String zoneId=zonas.getDestinations().getDestination().get(0).getZone().get(0).getId();
		zoneId=null;
		Integer infants=0;
		Integer nights=7;
		Calendar arrival=SystemHelper.getCalendarFromDDMMYYYY("20/09/2015");
		
		Integer adults=2;
		
		String hotelId="P157##P158##P159##P160";
		Integer children=0;
		
		String prepagoDefault="17";
		
		IrqVillaAvailablePriceResponse avail = fac.getVillaAvailableRich( prepagoDefault,idioma, hotelId, destinationId, zoneId, arrival, nights, adults, children, infants);
		oLog.info(avail.getVilla().get(0).getPrice());
		oLog.info(avail.getVilla().get(0).getPriceBigDecimal());
		oLog.info(avail.getVilla().get(0).getPricePrepago());
		
		/*
		HibernateReservas res = fac.getReserva(0);
		res.setHlHotel("fadsfsdafasd");
		res.setHlLocata("HlLocata");
		res.setHlCs("HlCs");
		fac.setReserva(res);
		*/
		
		oLog.info("Done!!");
		
		
		
		
		
		/*
		
		
		
		
		
		
		
		
		*/
	}

}