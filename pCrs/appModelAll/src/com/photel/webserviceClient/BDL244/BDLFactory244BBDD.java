package com.photel.webserviceClient.BDL244;

import java.util.ArrayList;
import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.photel.data.BDL.facade.BdlDataFacade;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlHdetailDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDestinations;
import com.photel.interfaces.data.BDL.IBdlHotels;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.data.BDL.IBdlvHimages;
import com.photel.webserviceClient.BDL244.pojo.BDLHotel;

/**
 * <p>Title: DBLFactory244</p>
 * <p>Description: Clase que implementa la versi�n 2.2.4 de los WS de BDL</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: HalconViajes.com</p>
 * @author: GPG
 * @version 1.0
 */
public class BDLFactory244BBDD {
	
	Logger  log = Logger.getLogger("DBL");

	private BdlDataFacade data;

	public BDLFactory244BBDD(BdlDataFacade data) throws Exception{
		super();
		this.data = data;
	}
	public IBDLHotel getHotelDetails(String languageCode){
		IBDLHotel hotel=new BDLHotel();
		hotel=getHotelDetails(hotel, languageCode);
		return hotel;
	}
	public IBDLHotel getHotelDetails(IBDLHotel hotel,String languageCode){
		IBdlHdetailDescriptions details = data.getHDetailDescription(hotel.getServicioCodigo(), languageCode);
		if (details!=null){
			hotel.setDescription(languageCode, details);
		}
		return hotel;
	}
	public IBDLHotel getHDetailFacilitesGrouped(IBDLHotel hotel, String LanguageCode) {
		Hashtable<String, ArrayList<IBdlvHdetailFacilities>> facilities = data.getHDetailFacilitesGrouped(hotel.getServicioCodigo(), LanguageCode);
		hotel.setFacilities(facilities);
		return hotel;
	}
	

	public IBDLHotel getHotelImages(IBDLHotel hotel,String languageCode){
		ArrayList<IBdlvHimages> details = data.getHDetailImages(hotel.getServicioCodigo(), languageCode);
		hotel.setImagesList(details);
		return hotel;
	}
	public IBDLHotel getHDetailImagesGrouped(IBDLHotel hotel, String LanguageCode) {
		Hashtable<String, ArrayList<IBdlvHimages>> details = data.getHDetailImagesGrouped(hotel.getServicioCodigo(), LanguageCode);
		hotel.setImagesMap(details);
		return hotel;
	}
	public Hashtable<String, ArrayList<String>> getHDetailFacilitesDispoGrouped(
			ArrayList<String> hotelCodes, String LanguageCode) {
		return data.getHDetailFacilitesDispoGrouped(hotelCodes, LanguageCode);
	}
	
	public IBdlDestinations getDestination(String code, String idi) {
		return data.getDestination(code, idi);
	}
	public IBDLHotel getHotel(String code) {
		IBDLHotel ret;
		IBdlHotels dataHotel = data.getHotel(code);
		ret=convertToIBDLHotel(dataHotel);
		return ret;
	}
	private IBDLHotel convertToIBDLHotel(IBdlHotels dataHotel){
		IBDLHotel ret=new BDLHotel();
		ret.setServicioCodigo(dataHotel.getId());
		ret.setNombre(dataHotel.getBdlName());
		ret.setCategoriaCodigo(dataHotel.getBdlCat());
		ret.setLatitud(dataHotel.getBdlLatitude());
		ret.setLongitud(dataHotel.getBdlLongitude());
		ret.setZonaCodigo(dataHotel.getBdlZone());
		ret.setDestinoCodigo(dataHotel.getBdlDestination());
		ret.setCadenaCodigo(dataHotel.getBdlChain());
		return ret;
	}
	public IBdlHotelDescriptions getHotelDescription(String code, String idi) {
		return data.getHotelDescription(code, idi);
	}
	public ArrayList<IBdlDestinations> getDestinations(String languageCode) {
		return data.getDestinations(languageCode);
	}
	public ArrayList<IBDLHotel> getDestinationHotels(String destination) {
		ArrayList<IBDLHotel> hotels=new ArrayList<IBDLHotel>();
		ArrayList<IBdlHotels> hots = data.getDestinationHotels(destination);
		if (hots!=null){
			for (IBdlHotels hot:hots){
				hotels.add(convertToIBDLHotel(hot));
			}
		}
		return hotels;
	}
	


}
