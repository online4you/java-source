//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 11:27:53 AM CEST 
//


package com.photel.webserviceClient.BDL244.vo.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Common response data.
 * 
 * <p>Java class for CoreResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CoreResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AuditData" type="{http://www.hotelbeds.com/schemas/2005/06/messages}AuditData"/>
 *         &lt;element name="ExtraInfoList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ExtendedDataList" minOccurs="0"/>
 *         &lt;element name="ErrorList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsErrorList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="echoToken">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
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
@XmlType(name = "CoreResponse", propOrder = {
    "auditData",
    "extraInfoList",
    "errorList"
})
@XmlSeeAlso({
    PurchaseCancelRS.class
})
public abstract class CoreResponse {

    @XmlElement(name = "AuditData", required = true)
    protected AuditData auditData;
    @XmlElement(name = "ExtraInfoList")
    protected ExtendedDataList extraInfoList;
    @XmlElement(name = "ErrorList")
    protected HotelbedsErrorList errorList;
    @XmlAttribute
    protected String echoToken;

    /**
     * Gets the value of the auditData property.
     * 
     * @return
     *     possible object is
     *     {@link AuditData }
     *     
     */
    public AuditData getAuditData() {
        return auditData;
    }

    /**
     * Sets the value of the auditData property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditData }
     *     
     */
    public void setAuditData(AuditData value) {
        this.auditData = value;
    }

    /**
     * Gets the value of the extraInfoList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedDataList }
     *     
     */
    public ExtendedDataList getExtraInfoList() {
        return extraInfoList;
    }

    /**
     * Sets the value of the extraInfoList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedDataList }
     *     
     */
    public void setExtraInfoList(ExtendedDataList value) {
        this.extraInfoList = value;
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
     * Gets the value of the echoToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoToken() {
        return echoToken;
    }

    /**
     * Sets the value of the echoToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoToken(String value) {
        this.echoToken = value;
    }

}
