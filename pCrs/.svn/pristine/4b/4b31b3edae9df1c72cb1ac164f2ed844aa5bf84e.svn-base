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

public class HotelesDestino extends MainAction {
	private String destinoId;
	private String destino;
	private ArrayList<IBDLHotel> hotels;
	
	@Override
	public String executeHalconAction() throws Exception {
		String languageCode=this.getConfigParam(this.getLocale().getLanguage());
		if (destinoId!=null && !destinoId.equals("")){
			destino=getDestinationDescription(destinoId,languageCode);
			hotels = this.getDestinationHotels(destinoId);
		}
		return SUCCESS;
	}

	public String getDestinationDescription(String zona, String idioma) throws Exception{
		String ret="";
		IBdlDestinations destination = this.getDestination(zona, idioma);
		ret=destination.getBdlDescription();
		return ret;
	}

	public String getDestinoId() {
		return destinoId;
	}

	public void setDestinoId(String destinoId) {
		this.destinoId = destinoId;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public ArrayList<IBDLHotel> getHotels() {
		return hotels;
	}

	public void setHotels(ArrayList<IBDLHotel> hotels) {
		this.hotels = hotels;
	}
	
	
	

	
}
