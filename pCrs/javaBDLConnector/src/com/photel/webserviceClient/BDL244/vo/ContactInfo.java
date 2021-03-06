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
 * Contact information.
 * 
 * <p>Java class for ContactInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Address" minOccurs="0"/>
 *         &lt;element name="EmailList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductEmailList" minOccurs="0"/>
 *         &lt;element name="PhoneList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductContactNumberList" minOccurs="0"/>
 *         &lt;element name="FaxList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductContactNumberList" minOccurs="0"/>
 *         &lt;element name="WebList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductWebList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactInfo", propOrder = {
    "address",
    "emailList",
    "phoneList",
    "faxList",
    "webList"
})
public class ContactInfo {

    @XmlElement(name = "Address")
    protected Address address;
    @XmlElement(name = "EmailList")
    protected ProductEmailList emailList;
    @XmlElement(name = "PhoneList")
    protected ProductContactNumberList phoneList;
    @XmlElement(name = "FaxList")
    protected ProductContactNumberList faxList;
    @XmlElement(name = "WebList")
    protected ProductWebList webList;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the emailList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductEmailList }
     *     
     */
    public ProductEmailList getEmailList() {
        return emailList;
    }

    /**
     * Sets the value of the emailList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductEmailList }
     *     
     */
    public void setEmailList(ProductEmailList value) {
        this.emailList = value;
    }

    /**
     * Gets the value of the phoneList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductContactNumberList }
     *     
     */
    public ProductContactNumberList getPhoneList() {
        return phoneList;
    }

    /**
     * Sets the value of the phoneList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductContactNumberList }
     *     
     */
    public void setPhoneList(ProductContactNumberList value) {
        this.phoneList = value;
    }

    /**
     * Gets the value of the faxList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductContactNumberList }
     *     
     */
    public ProductContactNumberList getFaxList() {
        return faxList;
    }

    /**
     * Sets the value of the faxList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductContactNumberList }
     *     
     */
    public void setFaxList(ProductContactNumberList value) {
        this.faxList = value;
    }

    /**
     * Gets the value of the webList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductWebList }
     *     
     */
    public ProductWebList getWebList() {
        return webList;
    }

    /**
     * Sets the value of the webList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductWebList }
     *     
     */
    public void setWebList(ProductWebList value) {
        this.webList = value;
    }

}
