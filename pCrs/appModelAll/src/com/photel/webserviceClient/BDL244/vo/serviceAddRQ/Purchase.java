//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.18 at 05:02:20 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.serviceAddRQ;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Purchase data.
 * 
 * <p>Java class for Purchase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Purchase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reference" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Reference" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsPurchaseStatus" minOccurs="0"/>
 *         &lt;element name="Agency" type="{http://www.hotelbeds.com/schemas/2005/06/messages}AgencyIdentification" minOccurs="0"/>
 *         &lt;element name="Language" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CreationDate" type="{http://www.hotelbeds.com/schemas/2005/06/messages}DateTime" minOccurs="0"/>
 *         &lt;element name="CreationUser" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Holder" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Customer" minOccurs="0"/>
 *         &lt;element name="AgencyReference" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ServiceList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceList" minOccurs="0"/>
 *         &lt;element name="SupplementList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *         &lt;element name="DiscountList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *         &lt;element name="AdditionalCostList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *         &lt;element name="CancelProtection" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CancellationProtection" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Currency" minOccurs="0"/>
 *         &lt;element name="PaymentData" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PaymentData" minOccurs="0"/>
 *         &lt;element name="PurchaseExtraInfoList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ExtendedDataList" minOccurs="0"/>
 *         &lt;element name="TotalPrice" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CommentList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CommentList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="purchaseToken">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="11"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="timeToExpiration" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Purchase", propOrder = {
    "reference",
    "status",
    "agency",
    "language",
    "creationDate",
    "creationUser",
    "holder",
    "agencyReference",
    "serviceList",
    "supplementList",
    "discountList",
    "additionalCostList",
    "cancelProtection",
    "currency",
    "paymentData",
    "purchaseExtraInfoList",
    "totalPrice",
    "commentList"
})
public class Purchase {

    @XmlElement(name = "Reference")
    protected Reference reference;
    @XmlElement(name = "Status")
    protected HotelbedsPurchaseStatus status;
    @XmlElement(name = "Agency")
    protected AgencyIdentification agency;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "CreationDate")
    protected DateTime creationDate;
    @XmlElement(name = "CreationUser")
    protected String creationUser;
    @XmlElement(name = "Holder")
    protected Customer holder;
    @XmlElement(name = "AgencyReference")
    protected String agencyReference;
    @XmlElement(name = "ServiceList")
    protected ServiceList serviceList;
    @XmlElement(name = "SupplementList")
    protected PriceList supplementList;
    @XmlElement(name = "DiscountList")
    protected PriceList discountList;
    @XmlElement(name = "AdditionalCostList")
    protected PriceList additionalCostList;
    @XmlElement(name = "CancelProtection")
    protected CancellationProtection cancelProtection;
    @XmlElement(name = "Currency")
    protected Currency currency;
    @XmlElement(name = "PaymentData")
    protected PaymentData paymentData;
    @XmlElement(name = "PurchaseExtraInfoList")
    protected ExtendedDataList purchaseExtraInfoList;
    @XmlElement(name = "TotalPrice")
    protected BigDecimal totalPrice;
    @XmlElement(name = "CommentList")
    protected CommentList commentList;
    @XmlAttribute
    protected String purchaseToken;
    @XmlAttribute
    protected Long timeToExpiration;

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link Reference }
     *     
     */
    public Reference getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reference }
     *     
     */
    public void setReference(Reference value) {
        this.reference = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link HotelbedsPurchaseStatus }
     *     
     */
    public HotelbedsPurchaseStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelbedsPurchaseStatus }
     *     
     */
    public void setStatus(HotelbedsPurchaseStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the agency property.
     * 
     * @return
     *     possible object is
     *     {@link AgencyIdentification }
     *     
     */
    public AgencyIdentification getAgency() {
        return agency;
    }

    /**
     * Sets the value of the agency property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgencyIdentification }
     *     
     */
    public void setAgency(AgencyIdentification value) {
        this.agency = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setCreationDate(DateTime value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the creationUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationUser() {
        return creationUser;
    }

    /**
     * Sets the value of the creationUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationUser(String value) {
        this.creationUser = value;
    }

    /**
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setHolder(Customer value) {
        this.holder = value;
    }

    /**
     * Gets the value of the agencyReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyReference() {
        return agencyReference;
    }

    /**
     * Sets the value of the agencyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyReference(String value) {
        this.agencyReference = value;
    }

    /**
     * Gets the value of the serviceList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceList }
     *     
     */
    public ServiceList getServiceList() {
        return serviceList;
    }

    /**
     * Sets the value of the serviceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceList }
     *     
     */
    public void setServiceList(ServiceList value) {
        this.serviceList = value;
    }

    /**
     * Gets the value of the supplementList property.
     * 
     * @return
     *     possible object is
     *     {@link PriceList }
     *     
     */
    public PriceList getSupplementList() {
        return supplementList;
    }

    /**
     * Sets the value of the supplementList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceList }
     *     
     */
    public void setSupplementList(PriceList value) {
        this.supplementList = value;
    }

    /**
     * Gets the value of the discountList property.
     * 
     * @return
     *     possible object is
     *     {@link PriceList }
     *     
     */
    public PriceList getDiscountList() {
        return discountList;
    }

    /**
     * Sets the value of the discountList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceList }
     *     
     */
    public void setDiscountList(PriceList value) {
        this.discountList = value;
    }

    /**
     * Gets the value of the additionalCostList property.
     * 
     * @return
     *     possible object is
     *     {@link PriceList }
     *     
     */
    public PriceList getAdditionalCostList() {
        return additionalCostList;
    }

    /**
     * Sets the value of the additionalCostList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceList }
     *     
     */
    public void setAdditionalCostList(PriceList value) {
        this.additionalCostList = value;
    }

    /**
     * Gets the value of the cancelProtection property.
     * 
     * @return
     *     possible object is
     *     {@link CancellationProtection }
     *     
     */
    public CancellationProtection getCancelProtection() {
        return cancelProtection;
    }

    /**
     * Sets the value of the cancelProtection property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancellationProtection }
     *     
     */
    public void setCancelProtection(CancellationProtection value) {
        this.cancelProtection = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

    /**
     * Gets the value of the paymentData property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentData }
     *     
     */
    public PaymentData getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentData }
     *     
     */
    public void setPaymentData(PaymentData value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the purchaseExtraInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedDataList }
     *     
     */
    public ExtendedDataList getPurchaseExtraInfoList() {
        return purchaseExtraInfoList;
    }

    /**
     * Sets the value of the purchaseExtraInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedDataList }
     *     
     */
    public void setPurchaseExtraInfoList(ExtendedDataList value) {
        this.purchaseExtraInfoList = value;
    }

    /**
     * Gets the value of the totalPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets the value of the totalPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPrice(BigDecimal value) {
        this.totalPrice = value;
    }

    /**
     * Gets the value of the commentList property.
     * 
     * @return
     *     possible object is
     *     {@link CommentList }
     *     
     */
    public CommentList getCommentList() {
        return commentList;
    }

    /**
     * Sets the value of the commentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommentList }
     *     
     */
    public void setCommentList(CommentList value) {
        this.commentList = value;
    }

    /**
     * Gets the value of the purchaseToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseToken() {
        return purchaseToken;
    }

    /**
     * Sets the value of the purchaseToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseToken(String value) {
        this.purchaseToken = value;
    }

    /**
     * Gets the value of the timeToExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeToExpiration() {
        return timeToExpiration;
    }

    /**
     * Sets the value of the timeToExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeToExpiration(Long value) {
        this.timeToExpiration = value;
    }

}