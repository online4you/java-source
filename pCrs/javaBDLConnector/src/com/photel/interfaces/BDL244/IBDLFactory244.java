package com.photel.interfaces.BDL244;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.photel.interfaces.data.BDL.IBdlCountries;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlHotelDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDestinations;
import com.photel.interfaces.data.BDL.IBdlHotels;
import com.photel.interfaces.data.BDL.IBdlReservas;
import com.photel.interfaces.data.BDL.IBdlReservasMails;
import com.photel.webserviceClient.BDL244.vo.serviceAddRQ.ServiceAddRS;



public interface IBDLFactory244 {

	public abstract IBDLDisponibilidad getDisponibilidad(
			List<List<String>> distribuciones,List<String> roomCount, Calendar fechaIni,
			Calendar fechaFin, String idSesion, String numero_pagina,
			String codIdioma, String codZgeSup, boolean multihilo,String codigosDeHotel)
			throws Exception;
	
	public IBDLDisponibilidad ordenaHotelesASC(IBDLDisponibilidad dispo)
			throws Exception;
	public IBDLDisponibilidad ordenaHotelesDESC(IBDLDisponibilidad dispo)
			throws Exception ;
	public IBDLHotel bloquearReserva(IBDLHotel hotel, Calendar fechaEntrada,
			Calendar fechaSalida, List<List<String>> distribuciones, int ofi,
			String nombreContrato, String idi, String codigoHotel,
			String codigoZona, String codigoClasificacion,
			List<String> seleccion, String tokenDeDispo) throws Exception;
	
	public IBDLHotel confirmarReserva(String idi,String idReserva,
			List<List<String>> distribuciones, IBDLHotel pHotel)
			throws Exception;
	public IBdlCountries getCountry(String code, String idi);
	public IBdlDestinations getDestination(String code, String idi);
	public IBdlHotelDescriptions getHotelDescription(String code, String idi);
	public IBdlHotelDestinations getHotelDestination(String countryCode, String destinationCode) ;
	public boolean delReserva(IBdlReservas res);
	public IBdlReservas getReserva(int idReserva);
	public ArrayList<IBdlReservas> getReservas();
	public IBdlReservas getUltimaFactura() ;
	public IBdlReservas setReserva(IBdlReservas res) ;
	public IBdlReservasMails getReservaMail(int idReservaMail);
	public ArrayList getReservasMails() ;
	public ArrayList getReservasMails(int idReserva);
	public IBdlReservasMails setReservaMails(IBdlReservasMails res) ;
	public void clearSession();
	public void closeSession();
	public IBDLHotel getHotelDetails(String languageCode);
	public IBDLHotel getHotelDetails(IBDLHotel hotel, String languageCode);
	public IBDLHotel cancelValuation(IBDLHotel hotel,String language, String locata,int officeCode) throws Exception;
	public IBDLHotel cancelConfirm(IBDLHotel hotel,String language, String locata,int officeCode)throws Exception;
	public IBDLHotel getHDetailFacilitesGrouped(IBDLHotel hotel,String LanguageCode)throws Exception;
	public IBDLHotel getHotelImages(IBDLHotel hotel, String languageCode);
	public IBDLHotel getHDetailImagesGrouped(IBDLHotel hotel,String LanguageCode);
	public IBDLHotel getHotel(String code,String languageCode);
	public ArrayList<IBdlDestinations> getDestinations(String languageCode);
	public ArrayList<IBDLHotel> getDestinationHotels(String destination);
}