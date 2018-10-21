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
 * Data to represent occupantion for any service.
 * 
 * <p>Java class for ServiceOccupancy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceOccupancy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdultCount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ChildCount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="999"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GuestList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CustomerList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceOccupancy", propOrder = {
    "adultCount",
    "childCount",
    "guestList"
})
public class ServiceOccupancy {

    @XmlElement(name = "AdultCount")
    protected Integer adultCount;
    @XmlElement(name = "ChildCount")
    protected Integer childCount;
    @XmlElement(name = "GuestList")
    protected CustomerList guestList;

    /**
     * Gets the value of the adultCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdultCount() {
        return adultCount;
    }

    /**
     * Sets the value of the adultCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdultCount(Integer value) {
        this.adultCount = value;
    }

    /**
     * Gets the value of the childCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getChildCount() {
        return childCount;
    }

    /**
     * Sets the value of the childCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setChildCount(Integer value) {
        this.childCount = value;
    }

    /**
     * Gets the value of the guestList property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerList }
     *     
     */
    public CustomerList getGuestList() {
        return guestList;
    }

    /**
     * Sets the value of the guestList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerList }
     *     
     */
    public void setGuestList(CustomerList value) {
        this.guestList = value;
    }

}
