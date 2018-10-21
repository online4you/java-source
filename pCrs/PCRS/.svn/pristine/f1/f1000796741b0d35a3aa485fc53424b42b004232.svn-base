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

public class ActualizarDatos extends MainAction {
	
	private String pass;
	@Override
	public String executeHalconAction() throws Exception {
		
		if (pass!=null && pass.equalsIgnoreCase("Javier69")){
			this.service.updateHotelanThread();
		}
		
		
		
		return SUCCESS;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}



	
}
