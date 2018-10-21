package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.photel.interfaces.BDL244.IBDLPurchase;
import com.photel.interfaces.BDL244.IBDLDiscount;

public class BDLPurchase implements IBDLPurchase, Serializable {
	
	private ArrayList<String> xmlsPurchase;
	private String status;
	private String token;
	private BigDecimal totalPrice;
	private BigDecimal agComission;
	private BigDecimal comissionVAT;
	private BigDecimal toPay;
	private String localizador;
	private String supplierName;
	private String supplierVatNumber;
	private List<IBDLDiscount> discount;
	
	
	public BDLPurchase(){
		super();
		totalPrice=BigDecimal.ZERO;
		agComission=BigDecimal.ZERO;
		comissionVAT=BigDecimal.ZERO;
		toPay=BigDecimal.ZERO;
		xmlsPurchase=new ArrayList<String>();
		discount=new ArrayList<IBDLDiscount>();
	}
	
	public BDLPurchase(BigDecimal totalPrice){
		super();
		this.totalPrice=totalPrice;
		xmlsPurchase=new ArrayList<String>();
		discount=new ArrayList<IBDLDiscount>();
	}
	
	public String getLocalizador() {
		return localizador;
	}


	public void setLocalizador(String localizador) {
		this.localizador = localizador;
	}
	
	

	
	public ArrayList<String> getXmlsPurchase() {
		return xmlsPurchase;
	}

	public void setXmlsPurchase(ArrayList<String> xmlsPurchase) {
		this.xmlsPurchase = xmlsPurchase;
	}

	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPurchase#getStatus()
	 */
	@Override
	public String getStatus() {
		return status;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPurchase#setStatus(java.lang.String)
	 */
	@Override
	public void setStatus(String status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPurchase#getToken()
	 */
	@Override
	public String getToken() {
		return token;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPurchase#setToken(java.lang.String)
	 */
	@Override
	public void setToken(String token) {
		this.token = token;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPurchase#getTotalPrice()
	 */
	@Override
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLPurchase#setTotalPrice(java.math.BigDecimal)
	 */
	@Override
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getAgComission() {
		return agComission;
	}

	public void setAgComission(BigDecimal agComission) {
		this.agComission = agComission;
	}

	public BigDecimal getComissionVAT() {
		return comissionVAT;
	}

	public void setComissionVAT(BigDecimal comissionVAT) {
		this.comissionVAT = comissionVAT;
	}

	public BigDecimal getToPay() {
		return toPay;
	}

	public void setToPay(BigDecimal toPay) {
		this.toPay = toPay;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierVatNumber() {
		return supplierVatNumber;
	}

	public void setSupplierVatNumber(String supplierVatNumber) {
		this.supplierVatNumber = supplierVatNumber;
	}

	public List<IBDLDiscount> getDiscount() {
		return discount;
	}

	public void setDiscount(List<IBDLDiscount> discount) {
		this.discount = discount;
	}
	
	
}
