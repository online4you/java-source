package com.photel.apps.actions.Hotelan;

import java.util.ArrayList;

import com.photel.apps.actions.MainAction;
import com.photel.hotelan.client.HotelanClientStub;
import com.photel.hotelan.client.IrqHotelDetailsList.IrqHotelDetailsListResponse;
import com.photel.hotelan.client.IrqVillaAvailablePrice.Villa;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;

public class DetalleHotel extends MainAction {
	
	private String hotelSeleccionado;
	private String idHotel;
	private Villa hotel;
	private String adults;//2/3/...
	private String ninos;//2-6/3-5/...
	private String bebes;//2/3/...
	private HotelanClientStub client;
	@Override
	public String executeHalconAction() throws Exception {
		if (hotelSeleccionado!=null && !hotelSeleccionado.equals("")){
			hotelSeleccionado=org.apache.commons.lang.StringEscapeUtils.unescapeHtml(hotelSeleccionado);
			hotel=(Villa) com.photel.commonServices.util.XMLStreamUtil.xmlLoadObject(hotelSeleccionado);
			hotel=this.service.getVilla(hotel, this.getLocale().getLanguage());
		}else if (idHotel!=null && !idHotel.equals("")){
			 hotel=this.service.getVilla(idHotel,this.getLocale().getLanguage());
			 client= new HotelanClientStub();
			 IrqHotelDetailsListResponse response = client.getIrqHotelDetailsList(this.getLocale().getCountry(), idHotel, null, null);
			 if(response.getHotel().size()!=0){
				 hotel.setLicense(response.getHotel().get(0).getLicense());
			 }
			 
		}

		if(hotel!=null){
			this.metaDescription=hotel.getDdbbHotel().getDetails();
			this.metaKeywords=hotel.getDdbbHotel().getName()+", "+hotel.getDdbbHotel().getDestinationDes();
			this.metaTitle=hotel.getDdbbHotel().getName()+", "+hotel.getDdbbHotel().getDestinationDes();
		}
		return SUCCESS;
	}
	public String convertIntrosBR(String str){
		return str.replace("\n", "<br>");
	}
	public String getImagesPath(){
		String ret;
		ret=this.getConfigParam("URLImages");
		return ret;
	}
	public boolean mostrarFacility(IBdlvHdetailFacilities facility){
		boolean ret=false;
			if (facility.getLogic().equals("S")){
				ret=true;
			}
		return ret;
	}
	public boolean dePago(IBdlvHdetailFacilities facility){
		boolean ret=false;
			if (facility.getFee().equals("S")){
				ret=true;
			}
		return ret;
	}
	public boolean mostrar(ArrayList<IBdlvHdetailFacilities> facilities){
		boolean ret=false;
		for(int i=0;i<facilities.size();i++){
			if (mostrarFacility(facilities.get(i))){
				ret=true;
				break;
			}
		}
			
		return ret;
	}
	public String getHotelSeleccionado() {
		return hotelSeleccionado;
	}

	public void setHotelSeleccionado(String hotelSeleccionado) {
		this.hotelSeleccionado = hotelSeleccionado;
	}

	public Villa getHotel() {
		return hotel;
	}



	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}
	
	
	public String getDestinos() {
		return hotel.getDestination();
	}

	public String getAdults() {
		return adults;
	}

	public void setAdults(String adults) {
		this.adults = adults;
	}

	public String getNinos() {
		return ninos;
	}

	public void setNinos(String ninos) {
		this.ninos = ninos;
	}

	public String getBebes() {
		return bebes;
	}

	public void setBebes(String bebes) {
		this.bebes = bebes;
	}

	
}