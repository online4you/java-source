package com.photel.webserviceClient.BDL244.comparators;

import java.util.Comparator;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;

public class BDLContratosComparator implements Comparator<IBDLContrato> {
	
	public static final String ASC="asc";
	public static final String DESC="desc";
	private int ordenacion;
	
	public BDLContratosComparator(String ordenacion) throws Exception{
		if (ordenacion.equals(ASC)){
			this.ordenacion=1;
		}else if (ordenacion.equals(DESC)){
			this.ordenacion=-1;
		}else{
			throw new Exception("Ordenación incorrecta");
		}
	}
	

	@Override
	public int compare(IBDLContrato c1, IBDLContrato c2) {
		// TODO Auto-generated method stub
		int ret=c1.getPrecioMin().compareTo(c2.getPrecioMin());
		ret=ret*this.ordenacion;
		return ret;
	}


	



}
