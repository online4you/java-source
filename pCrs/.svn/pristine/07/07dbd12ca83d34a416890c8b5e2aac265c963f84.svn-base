package com.photel.apps.actions.BDL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPax;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlHdetailDescriptions;
import com.photel.interfaces.data.BDL.IBdlvHdetailFacilities;
import com.photel.interfaces.data.BDL.IBdlvHimages;
import com.photel.interfaces.model.gen.sesion.ISesion;

public class DetalleHotel extends MainAction {
	
	private String hotelSeleccionado;
	private String idHotel;
	private IBDLHotel hotel;
	private String languageCode;
	private IBdlHdetailDescriptions des;
	private Hashtable<String, ArrayList<IBdlvHdetailFacilities>> fac;
	private ArrayList<IBdlvHimages> images;
	
	@Override
	public String executeHalconAction() throws Exception {
		languageCode=this.getConfigParam(this.getLocale().getLanguage());
		if (hotelSeleccionado!=null && !hotelSeleccionado.equals("")){
			hotelSeleccionado=org.apache.commons.lang.StringEscapeUtils.unescapeHtml(hotelSeleccionado);
			hotel=(IBDLHotel) com.photel.commonServices.util.XMLStreamUtil.xmlLoadObject(hotelSeleccionado);
			hotel=this.getHotelDetails(hotel,languageCode);
			hotel=this.getHDetailImagesGrouped(hotel, languageCode);
			hotel=this.getHotelImages(hotel, languageCode);
			images = hotel.getImagesList();
			des = hotel.getDescription(languageCode);
			
			hotel=this.getHDetailFacilitesGrouped(hotel, languageCode);
			fac = hotel.getFacilities();
		}else if (idHotel!=null && !idHotel.equals("")){
			hotel=this.getHotel(idHotel, languageCode);
			images = hotel.getImagesList();
			des = hotel.getDescription(languageCode);
			fac = hotel.getFacilities();
		}
		
		if(hotel!=null){
			this.metaDescription=hotel.getDescripcion();
			this.metaKeywords=hotel.getNombre()+", "+hotel.getDestino();
			this.metaTitle=hotel.getNombre()+" - "+hotel.getDestino();
		}
		return SUCCESS;
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

	public IBDLHotel getHotel() {
		return hotel;
	}

	public void setHotel(IBDLHotel hotel) {
		this.hotel = hotel;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public IBdlHdetailDescriptions getDes() {
		return des;
	}

	public void setDes(IBdlHdetailDescriptions des) {
		this.des = des;
	}

	public Hashtable<String, ArrayList<IBdlvHdetailFacilities>> getFac() {
		return fac;
	}

	public void setFac(Hashtable<String, ArrayList<IBdlvHdetailFacilities>> fac) {
		this.fac = fac;
	}

	public ArrayList<IBdlvHimages> getImages() {
		return images;
	}

	public void setImages(ArrayList<IBdlvHimages> images) {
		this.images = images;
	}

	public String getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(String idHotel) {
		this.idHotel = idHotel;
	}
	
	
	

	
}
