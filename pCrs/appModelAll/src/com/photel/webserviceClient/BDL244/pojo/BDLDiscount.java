package com.photel.webserviceClient.BDL244.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import com.photel.interfaces.BDL244.IBDLDiscount;

public class BDLDiscount implements IBDLDiscount,Serializable {
	private int unitCount;
	private int paxCount;
	private GregorianCalendar DateTimeFrom;
	private GregorianCalendar DateTimeTo;
	private String Description;
	private BigDecimal amount;
	
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDiscount#getDateTimeFrom()
	 */
	@Override
	public GregorianCalendar getDateTimeFrom() {
		return DateTimeFrom;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDiscount#setDateTimeFrom(java.util.GregorianCalendar)
	 */
	@Override
	public void setDateTimeFrom(GregorianCalendar dateTimeFrom) {
		DateTimeFrom = dateTimeFrom;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDiscount#getDateTimeTo()
	 */
	@Override
	public GregorianCalendar getDateTimeTo() {
		return DateTimeTo;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDiscount#setDateTimeTo(java.util.GregorianCalendar)
	 */
	@Override
	public void setDateTimeTo(GregorianCalendar dateTimeTo) {
		DateTimeTo = dateTimeTo;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDiscount#getDescription()
	 */
	@Override
	public String getDescription() {
		return Description;
	}
	/* (non-Javadoc)
	 * @see com.photel.webserviceClient.BDL244.pojo.IBDLDiscount#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String description) {
		Description = description;
	}
	public int getUnitCount() {
		return unitCount;
	}
	public void setUnitCount(int unitCount) {
		this.unitCount = unitCount;
	}
	public int getPaxCount() {
		return paxCount;
	}
	public void setPaxCount(int paxCount) {
		this.paxCount = paxCount;
	}
	
	
	
	
}
