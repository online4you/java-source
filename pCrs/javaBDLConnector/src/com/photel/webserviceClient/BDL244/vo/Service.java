//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Generic, non instanciable service data.
 * 
 * <p>Java class for Service complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reference" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Reference" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsServiceStatus" minOccurs="0"/>
 *         &lt;element name="DirectPayment" type="{http://www.hotelbeds.com/schemas/2005/06/messages}YesNo" minOccurs="0"/>
 *         &lt;element name="ContractList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ContractList" minOccurs="0"/>
 *         &lt;element name="Supplier" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceSupplier" minOccurs="0"/>
 *         &lt;element name="CommentList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CommentList" minOccurs="0"/>
 *         &lt;element name="DateFrom" type="{http://www.hotelbeds.com/schemas/2005/06/messages}DateTime"/>
 *         &lt;element name="DateTo" type="{http://www.hotelbeds.com/schemas/2005/06/messages}DateTime" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Currency" minOccurs="0"/>
 *         &lt;element name="AcceptedCardTypes" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CardList" minOccurs="0"/>
 *         &lt;element name="TotalAmount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NetPrice" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Commission" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SellingPrice" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;restriction base="&lt;http://www.hotelbeds.com/schemas/2005/06/messages>SellingPrice">
 *               &lt;/restriction>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ValuationFileNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="999999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SupplementList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *         &lt;element name="DiscountList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *         &lt;element name="AdditionalCostList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}AdditionalCostList" minOccurs="0"/>
 *         &lt;element name="ServiceExtraInfoList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ExtendedDataList" minOccurs="0"/>
 *         &lt;element name="ErrorList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsErrorList" minOccurs="0"/>
 *         &lt;element name="ModificationPolicyList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceModificationPolicyList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="SPUI">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="30"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="availToken">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="24"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Service", propOrder = {
    "reference",
    "status",
    "directPayment",
    "contractList",
    "supplier",
    "commentList",
    "dateFrom",
    "dateTo",
    "currency",
    "acceptedCardTypes",
    "totalAmount",
    "netPrice",
    "commission",
    "sellingPrice",
    "valuationFileNumber",
    "supplementList",
    "discountList",
    "additionalCostList",
    "serviceExtraInfoList",
    "errorList",
    "modificationPolicyList"
})
@XmlSeeAlso({
    ServiceTicket.class,
    ServiceCar.class,
    ServiceHotel.class,
    ServiceInsurance.class,
    ServiceTransfer.class
})
public abstract class Service {

    @XmlElement(name = "Reference")
    protected Reference reference;
    @XmlElement(name = "Status")
    protected HotelbedsServiceStatus status;
    @XmlElement(name = "DirectPayment")
    protected YesNo directPayment;
    @XmlElement(name = "ContractList")
    protected ContractList contractList;
    @XmlElement(name = "Supplier")
    protected ServiceSupplier supplier;
    @XmlElement(name = "CommentList")
    protected CommentList commentList;
    @XmlElement(name = "DateFrom", required = true)
    protected DateTime dateFrom;
    @XmlElement(name = "DateTo")
    protected DateTime dateTo;
    @XmlElement(name = "Currency")
    protected Currency currency;
    @XmlElement(name = "AcceptedCardTypes")
    protected CardList acceptedCardTypes;
    @XmlElement(name = "TotalAmount")
    protected BigDecimal totalAmount;
    @XmlElement(name = "NetPrice")
    protected BigDecimal netPrice;
    @XmlElement(name = "Commission")
    protected BigDecimal commission;
    @XmlElement(name = "SellingPrice")
    protected Service.SellingPrice sellingPrice;
    @XmlElement(name = "ValuationFileNumber")
    protected Integer valuationFileNumber;
    @XmlElement(name = "SupplementList")
    protected PriceList supplementList;
    @XmlElement(name = "DiscountList")
    protected PriceList discountList;
    @XmlElement(name = "AdditionalCostList")
    protected AdditionalCostList additionalCostList;
    @XmlElement(name = "ServiceExtraInfoList")
    protected ExtendedDataList serviceExtraInfoList;
    @XmlElement(name = "ErrorList")
    protected HotelbedsErrorList errorList;
    @XmlElement(name = "ModificationPolicyList")
    protected ServiceModificationPolicyList modificationPolicyList;
    @XmlAttribute(name = "SPUI")
    protected String spui;
    @XmlAttribute
    protected String availToken;

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
     *     {@link HotelbedsServiceStatus }
     *     
     */
    public HotelbedsServiceStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelbedsServiceStatus }
     *     
     */
    public void setStatus(HotelbedsServiceStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the directPayment property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getDirectPayment() {
        return directPayment;
    }

    /**
     * Sets the value of the directPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setDirectPayment(YesNo value) {
        this.directPayment = value;
    }

    /**
     * Gets the value of the contractList property.
     * 
     * @return
     *     possible object is
     *     {@link ContractList }
     *     
     */
    public ContractList getContractList() {
        return contractList;
    }

    /**
     * Sets the value of the contractList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractList }
     *     
     */
    public void setContractList(ContractList value) {
        this.contractList = value;
    }

    /**
     * Gets the value of the supplier property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSupplier }
     *     
     */
    public ServiceSupplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the value of the supplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSupplier }
     *     
     */
    public void setSupplier(ServiceSupplier value) {
        this.supplier = value;
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
     * Gets the value of the dateFrom property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getDateFrom() {
        return dateFrom;
    }

    /**
     * Sets the value of the dateFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setDateFrom(DateTime value) {
        this.dateFrom = value;
    }

    /**
     * Gets the value of the dateTo property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getDateTo() {
        return dateTo;
    }

    /**
     * Sets the value of the dateTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setDateTo(DateTime value) {
        this.dateTo = value;
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
     * Gets the value of the acceptedCardTypes property.
     * 
     * @return
     *     possible object is
     *     {@link CardList }
     *     
     */
    public CardList getAcceptedCardTypes() {
        return acceptedCardTypes;
    }

    /**
     * Sets the value of the acceptedCardTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardList }
     *     
     */
    public void setAcceptedCardTypes(CardList value) {
        this.acceptedCardTypes = value;
    }

    /**
     * Gets the value of the totalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the totalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalAmount(BigDecimal value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the netPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNetPrice() {
        return netPrice;
    }

    /**
     * Sets the value of the netPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNetPrice(BigDecimal value) {
        this.netPrice = value;
    }

    /**
     * Gets the value of the commission property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * Sets the value of the commission property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCommission(BigDecimal value) {
        this.commission = value;
    }

    /**
     * Gets the value of the sellingPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Service.SellingPrice }
     *     
     */
    public Service.SellingPrice getSellingPrice() {
        return sellingPrice;
    }

    /**
     * Sets the value of the sellingPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service.SellingPrice }
     *     
     */
    public void setSellingPrice(Service.SellingPrice value) {
        this.sellingPrice = value;
    }

    /**
     * Gets the value of the valuationFileNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValuationFileNumber() {
        return valuationFileNumber;
    }

    /**
     * Sets the value of the valuationFileNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValuationFileNumber(Integer value) {
        this.valuationFileNumber = value;
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
     *     {@link AdditionalCostList }
     *     
     */
    public AdditionalCostList getAdditionalCostList() {
        return additionalCostList;
    }

    /**
     * Sets the value of the additionalCostList property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalCostList }
     *     
     */
    public void setAdditionalCostList(AdditionalCostList value) {
        this.additionalCostList = value;
    }

    /**
     * Gets the value of the serviceExtraInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedDataList }
     *     
     */
    public ExtendedDataList getServiceExtraInfoList() {
        return serviceExtraInfoList;
    }

    /**
     * Sets the value of the serviceExtraInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedDataList }
     *     
     */
    public void setServiceExtraInfoList(ExtendedDataList value) {
        this.serviceExtraInfoList = value;
    }

    /**
     * Gets the value of the errorList property.
     * 
     * @return
     *     possible object is
     *     {@link HotelbedsErrorList }
     *     
     */
    public HotelbedsErrorList getErrorList() {
        return errorList;
    }

    /**
     * Sets the value of the errorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelbedsErrorList }
     *     
     */
    public void setErrorList(HotelbedsErrorList value) {
        this.errorList = value;
    }

    /**
     * Gets the value of the modificationPolicyList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceModificationPolicyList }
     *     
     */
    public ServiceModificationPolicyList getModificationPolicyList() {
        return modificationPolicyList;
    }

    /**
     * Sets the value of the modificationPolicyList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceModificationPolicyList }
     *     
     */
    public void setModificationPolicyList(ServiceModificationPolicyList value) {
        this.modificationPolicyList = value;
    }

    /**
     * Gets the value of the spui property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPUI() {
        return spui;
    }

    /**
     * Sets the value of the spui property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPUI(String value) {
        this.spui = value;
    }

    /**
     * Gets the value of the availToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvailToken() {
        return availToken;
    }

    /**
     * Sets the value of the availToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvailToken(String value) {
        this.availToken = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;restriction base="&lt;http://www.hotelbeds.com/schemas/2005/06/messages>SellingPrice">
     *     &lt;/restriction>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SellingPrice
        extends com.photel.webserviceClient.BDL244.vo.SellingPrice
    {


    }

}
