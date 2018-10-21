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

public class Destinos extends MainAction {
	private ArrayList<IBdlDestinations> destinations;

	@Override
	public String executeHalconAction() throws Exception {
		String languageCode=this.getConfigParam(this.getLocale().getLanguage());
		destinations = this.getDestinations(languageCode);
		return SUCCESS;
	}

	public ArrayList<IBdlDestinations> getDestinations() {
		return destinations;
	}

	public void setDestinations(ArrayList<IBdlDestinations> destinations) {
		this.destinations = destinations;
	}
	
	
	
	

	
}
