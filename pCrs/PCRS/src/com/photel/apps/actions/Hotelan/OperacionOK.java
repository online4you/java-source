package com.photel.apps.actions.Hotelan;

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
import com.photel.data.hotelan.ddbb.hibernate.pojo.HibernateReservas;
import com.photel.hotelan.client.IrqVillaAvailablePrice.Villa;
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

public class OperacionOK extends MainAction {
	
	private String idReserva;
	private Villa hotel;
	
	@Override
	public String executeHalconAction() throws Exception {
		
		HibernateReservas res = this.service.getReservaHotelanFromLocata(idReserva);
		
		String hotelStr=res.getHlHotel();
		hotel = (Villa) XMLStreamUtil.xmlLoadObject(hotelStr);
		
		
		return SUCCESS;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public Villa getHotel() {
		return hotel;
	}

	public void setHotel(Villa hotel) {
		this.hotel = hotel;
	}


	
}
