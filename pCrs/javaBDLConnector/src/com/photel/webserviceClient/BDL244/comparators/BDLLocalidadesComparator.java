package com.photel.webserviceClient.BDL244.comparators;

import java.util.Comparator;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLLocalidad;


public class BDLLocalidadesComparator implements Comparator<IBDLLocalidad> {
	
	public static final String ASC="asc";
	public static final String DESC="desc";
	private int ordenacion;
	
	public BDLLocalidadesComparator(String ordenacion) throws Exception{
		if (ordenacion.equals(ASC)){
			this.ordenacion=1;
		}else if (ordenacion.equals(DESC)){
			this.ordenacion=-1;
		}else{
			throw new Exception("Ordenación incorrecta");
		}
	}
	

	@Override
	public int compare(IBDLLocalidad c1, IBDLLocalidad c2) {
		// TODO Auto-generated method stub
		int ret=c1.getDescripcion().compareTo(c2.getDescripcion());
		ret=ret*this.ordenacion;
		return ret;
	}


	
}
