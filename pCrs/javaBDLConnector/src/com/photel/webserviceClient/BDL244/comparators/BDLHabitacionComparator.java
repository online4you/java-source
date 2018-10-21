package com.photel.webserviceClient.BDL244.comparators;

import java.util.Comparator;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLContrato;
import com.photel.interfaces.BDL244.IBDLDistribucion;
import com.photel.interfaces.BDL244.IBDLHotel;
import com.photel.interfaces.BDL244.IBDLRegimen;
import com.photel.interfaces.BDL244.IBDLRoom;

public class BDLHabitacionComparator implements Comparator<IBDLRoom> {
	
	public static final String ASC="asc";
	public static final String DESC="desc";
	private int ordenacion;
	
	public BDLHabitacionComparator(String ordenacion) throws Exception{
		if (ordenacion.equals(ASC)){
			this.ordenacion=1;
		}else if (ordenacion.equals(DESC)){
			this.ordenacion=-1;
		}else{
			throw new Exception("Ordenación incorrecta");
		}
	}
	

	@Override
	public int compare(IBDLRoom r1, IBDLRoom r2) {
		// TODO Auto-generated method stub
		boolean r1OK=(r1.getRegimenesAlimentarios()!=null && r1.getRegimenesAlimentarios().size()>0);
		boolean r2OK=(r2.getRegimenesAlimentarios()!=null && r2.getRegimenesAlimentarios().size()>0);
		int ret=0;
		if (r1OK && r2OK){
			ret=r1.getRegimenesAlimentarios().get(0).getPrecio().compareTo(r2.getRegimenesAlimentarios().get(0).getPrecio());
			ret=ret*this.ordenacion;
		}else if (r1OK){
			ret=1;
		}else if (r2OK){
			ret=-1;
		}
		return ret;
	}


	


}
