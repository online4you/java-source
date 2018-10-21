package com.photel.apps.actions.BDL;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;

import com.photel.apps.actions.MainAction;
import com.photel.commonServices.util.DateTimeUtil;
import com.photel.commonServices.util.XMLStreamUtil;
import com.photel.interfaces.BDL244.IBDLCancelationPrice;
import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDisponibilidad;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLPax;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;
import com.photel.interfaces.data.BDL.IBdlDestinations;
import com.photel.interfaces.data.BDL.IBdlReservas;
import com.photel.interfaces.model.gen.sesion.ISesion;

public class OperacionKO extends MainAction {
	
	private String idReserva;
	private IBDLHotel hotel;
	
	@Override
	public String executeHalconAction() throws Exception {
		
		IBdlReservas res = this.getReserva(Integer.valueOf(idReserva));
		String hotelStr=res.getBdlHotel();
		hotel = (IBDLHotel) XMLStreamUtil.xmlLoadObject(hotelStr);
		
		
		return SUCCESS;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public IBDLHotel getHotel() {
		return hotel;
	}

	public void setHotel(IBDLHotel hotel) {
		this.hotel = hotel;
	}


	
}