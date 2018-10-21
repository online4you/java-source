package com.photel.data.BDL.facade;

import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import org.hibernate.Session;

import com.photel.data.BDL.ddbb.HelperCSV;
import com.photel.data.BDL.ddbb.HelperHibernateDDBBGen;
import com.photel.interfaces.data.BDL.IBdlConfig;
import com.photel.interfaces.data.BDL.IBdlConfigSite;
import com.photel.interfaces.data.BDL.IBdlCountries;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlHdetailDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDescriptions;
import com.photel.interfaces.data.BDL.IBdlHotelDestinations;
import com.photel.interfaces.data.BDL.IBdlHotels;
import com.photel.interfaces.data.BDL.IBdlLanguages;
import com.photel.interfaces.data.BDL.IBdlReservas;
import com.photel.interfaces.data.BDL.IBdlReservasMails;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.data.BDL.IBdlvHimages;


public class BdlDataFacade   {
	private HelperHibernateDDBBGen hbd;
	private HelperCSV csv;
	
	private String site;
	public BdlDataFacade(String site) throws SQLException, Exception{
		this.site=site;
		init();
	}
	public void init() throws SQLException, Exception{
		this.hbd=new HelperHibernateDDBBGen(site);
		this.csv=new HelperCSV(hbd);
	}
	public ArrayList<IBdlConfigSite> getStaticConfigSite() {
		return hbd.getStaticConfigSite();
	}
	public ArrayList<IBdlConfig> getStaticConfig() {
		return hbd.getStaticConfig();
	}
	public void reloadStatic() {
		hbd.reloadStatic();
	}
	public String getPatam(String param) {
		return hbd.getPatam(param);
	}
	public int truncate(String className) {
		return hbd.truncate(className);
	}
	public IBdlLanguages setLanguage(String code, String description) {
		return hbd.setLanguage(code, description);
	}
	public boolean delLanguage(String code) {
		return hbd.delLanguage(code);
	}
	public IBdlLanguages getLanguage(String code) {
		return hbd.getLanguage(code);
	}
	public void loadCountries() throws IOException {
		csv.loadCountries();
	}
	public void loadDestinations() throws IOException {
		csv.loadDestinations();
	}
	public void loadHotelDestinations() throws IOException {
		csv.loadHotelDestinations();
	}
	public void loadHotelDescriptions() throws IOException {
		csv.loadHotelDescriptions();
	}
	public Object getInstance(String classe) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		return hbd.getInstance(classe);
	}
	public ArrayList<IBdlConfigSite> getStaticConfigSite(String site) {
		return hbd.getStaticConfigSite(site);
	}
	public ArrayList<IBdlLanguages> getLanguages() {
		return hbd.getLanguages();
	}
	public IBdlCountries getCountry(String code, String idi) {
		return hbd.getCountry(code, idi);
	}
	public ArrayList<IBdlCountries> getCountries() {
		return hbd.getCountries();
	}
	public IBdlCountries setCountry(String code, String idi, String description) {
		return hbd.setCountry(code, idi, description);
	}
	public boolean delCountry(String code, String idi) {
		return hbd.delCountry(code, idi);
	}
	public IBdlDestinations getDestination(String code, String idi) {
		return hbd.getDestination(code, idi);
	}
	public ArrayList<IBdlDestinations> getDestinations() {
		return hbd.getDestinations();
	}
	public IBdlDestinations setDestination(String code, String idi,
			String description) {
		return hbd.setDestination(code, idi, description);
	}
	public boolean delDestination(String code, String idi) {
		return hbd.delDestination(code, idi);
	}
	public IBdlHotelDestinations getHotelDestination(String countryCode,
			String destinationCode) {
		return hbd.getHotelDestination(countryCode, destinationCode);
	}
	public ArrayList<IBdlHotelDestinations> getHotelDestinations() {
		return hbd.getHotelDestinations();
	}
	public IBdlHotelDestinations setHotelDestination(String countryCode,
			String destinationCode) {
		return hbd.setHotelDestination(countryCode, destinationCode);
	}
	public boolean delHotelDestination(String countryCode,
			String destinationCode) {
		return hbd.delHotelDestination(countryCode, destinationCode);
	}
	public IBdlHotelDescriptions getHotelDescription(String code, String idi) {
		return hbd.getHotelDescription(code, idi);
	}
	public ArrayList<IBdlHotelDescriptions> getHotelsDescriptions() {
		return hbd.getHotelsDescriptions();
	}
	public IBdlHotelDescriptions setHotelDescription(String code, String idi,
			String description) {
		return hbd.setHotelDescription(code, idi, description);
	}
	public boolean delHotelDescription(String code, String idi) {
		return hbd.delHotelDescription(code, idi);
	}
	public ArrayList<IBdlHotelDescriptions> getHotelsDescriptions(ArrayList codes, String idi) {
		return hbd.getHotelsDescriptions(codes, idi);
	}
	public IBdlReservas getReserva(int idReserva) {
		return hbd.getReserva(idReserva);
	}
	public ArrayList<IBdlReservas> getReservas() {
		return hbd.getReservas();
	}
	public IBdlReservas setReserva(IBdlReservas res) {
		return hbd.setReserva(res);
	}
	public boolean delReserva(IBdlReservas res) {
		return hbd.delReserva(res);
	}
	public IBdlReservas getUltimaFactura() {
		return hbd.getUltimaFactura();
	}
	public IBdlReservasMails getReservaMail(int idReservaMail) {
		return hbd.getReservaMail(idReservaMail);
	}
	public ArrayList<IBdlReservasMails> getReservasMails() {
		return hbd.getReservasMails();
	}
	public boolean delReservaMails(IBdlReservasMails res) {
		return hbd.delReservaMails(res);
	}
	public ArrayList<IBdlReservasMails> getReservasMails(int idReserva) {
		return hbd.getReservasMails(idReserva);
	}
	public IBdlReservasMails setReservaMails(IBdlReservasMails res) {
		return hbd.setReservaMails(res);
	}
	public void clearSession() {
		hbd.clearSession();
	}
	public void closeSession() {
		hbd.closeSession();
	}
	public IBdlHotels getHotel(String code) {
		return hbd.getHotel(code);
	}
	public ArrayList<IBdlHotels> getDestinationHotels(String destination) {
		return hbd.getDestinationHotels(destination);
	}
	public IBdlHotels setHotel(IBdlHotels hotel) {
		return hbd.setHotel(hotel);
	}
	public boolean delHotel(String code) {
		return hbd.delHotel(code);
	}
	public void loadHotels() throws IOException {
		csv.loadHotels();
	}
	public IBdlHdetailDescriptions getHDetailDescription(String hotelCode,
			String languageCode) {
		return hbd.getHDetailDescription(hotelCode, languageCode);
	}
	public ArrayList<IBdlHdetailDescriptions> getHDetailDescriptions(ArrayList<String> codes, String LanguageCode) {
		return hbd.getHDetailDescriptions(codes, LanguageCode);
	}
	public IBdlvHdetailFacilities getHDetailFacility(String hotelCode,
			String code, String groupCode, String languageCode) {
		return hbd.getHDetailFacility(hotelCode, code, groupCode, languageCode);
	}
	public ArrayList<IBdlvHdetailFacilities> getHDetailFacilites(ArrayList<String> codes, String LanguageCode) {
		return hbd.getHDetailFacilites(codes, LanguageCode);
	}
	public ArrayList<IBdlvHdetailFacilities>  getHDetailFacilites(String hotelCode, String LanguageCode) {
		ArrayList<String> codes=new ArrayList<String>();
		codes.add(hotelCode);
		return hbd.getHDetailFacilites(codes, LanguageCode);
	}
	public Hashtable<String,ArrayList<IBdlvHdetailFacilities>> getHDetailFacilitesGrouped(String hotelCode, String LanguageCode) {
		return hbd.getHDetailFacilitesGrouped(hotelCode, LanguageCode);
	}
	public IBdlvHimages getHDetailImage(String hotelCode, String languageCode,String imagecode, String order) {
		return hbd.getHDetailImage(hotelCode, languageCode,imagecode, order);
	}
	public ArrayList<IBdlvHimages> getHDetailImages(String hotelCode, String LanguageCode) {
		ArrayList<String> codes=new ArrayList<String>();
		codes.add(hotelCode);
		return hbd.getHDetailImages(codes, LanguageCode);
	}
	public ArrayList<IBdlvHimages> getHDetailImages(ArrayList codes, String LanguageCode) {
		return hbd.getHDetailImages(codes, LanguageCode);
	}
	public Hashtable<String,ArrayList<IBdlvHimages>> getHDetailImagesGrouped(String hotelCode,
			String LanguageCode) {
		return hbd.getHDetailImagesGrouped(hotelCode, LanguageCode);
	}
	public Hashtable<String,ArrayList<String>> getHDetailFacilitesDispoGrouped(ArrayList<String> hotelCodes,
			String LanguageCode) {
		return hbd.getHDetailFacilitesDispoGrouped(hotelCodes, LanguageCode);
	}
	public ArrayList<IBdlDestinations> getDestinations(String languageCode) {
		return hbd.getDestinations(languageCode);
	}
	
}
