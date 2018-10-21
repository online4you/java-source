package com.photel.interfaces.BDL244;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface IBDLPurchase {

	public ArrayList<String> getXmlsPurchase();
	
	public void setXmlsPurchase(ArrayList<String> xmlsPurchase);

	public abstract String getStatus();

	public abstract void setStatus(String status);

	public abstract String getToken();

	public abstract void setToken(String token);

	public abstract BigDecimal getTotalPrice();

	public abstract void setTotalPrice(BigDecimal totalPrice);
	
	public String getLocalizador() ;

	public void setLocalizador(String localizador);
	
	public BigDecimal getAgComission() ;

	public void setAgComission(BigDecimal agComission);

	public BigDecimal getComissionVAT();

	public void setComissionVAT(BigDecimal comissionVAT);

	public BigDecimal getToPay();

	public void setToPay(BigDecimal toPay);
	public String getSupplierName() ;

	public void setSupplierName(String supplierName) ;

	public String getSupplierVatNumber() ;

	public void setSupplierVatNumber(String supplierVatNumber)  ;
	public List<IBDLDiscount> getDiscount();

	public void setDiscount(List<IBDLDiscount> discount);
}