//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Data to represent a cancel proctection element.
 * 
 * <p>Java class for CancellationProtection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancellationProtection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsServiceStatus"/>
 *         &lt;element name="Price" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Price" minOccurs="0"/>
 *         &lt;element name="ModificationPolicyList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceModificationPolicyList" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *         &lt;element name="CommentList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CommentList" minOccurs="0"/>
 *         &lt;element name="AdditionalCostList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}AdditionalCostList" minOccurs="0"/>
 *         &lt;element name="ErrorList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsErrorList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancellationProtection", propOrder = {
    "status",
    "price",
    "modificationPolicyList",
    "cancellationPolicy",
    "commentList",
    "additionalCostList",
    "errorList"
})
public class CancellationProtection {

    @XmlElement(name = "Status", required = true)
    protected HotelbedsServiceStatus status;
    @XmlElement(name = "Price")
    protected Price price;
    @XmlElement(name = "ModificationPolicyList")
    protected ServiceModificationPolicyList modificationPolicyList;
    @XmlElement(name = "CancellationPolicy")
    protected PriceList cancellationPolicy;
    @XmlElement(name = "CommentList")
    protected CommentList commentList;
    @XmlElement(name = "AdditionalCostList")
    protected AdditionalCostList additionalCostList;
    @XmlElement(name = "ErrorList")
    protected HotelbedsErrorList errorList;

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
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPrice(Price value) {
        this.price = value;
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
     * Gets the value of the cancellationPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link PriceList }
     *     
     */
    public PriceList getCancellationPolicy() {
        return cancellationPolicy;
    }

    /**
     * Sets the value of the cancellationPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceList }
     *     
     */
    public void setCancellationPolicy(PriceList value) {
        this.cancellationPolicy = value;
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

}
