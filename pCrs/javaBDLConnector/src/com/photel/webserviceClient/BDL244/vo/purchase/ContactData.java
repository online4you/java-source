//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.13 at 05:38:07 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.purchase;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contact data.
 * 
 * <p>Java class for ContactData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContactData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Email" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductEmail"/>
 *         &lt;element name="PhoneNumber" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductContactNumber"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContactData", propOrder = {
    "email",
    "phoneNumber"
})
public class ContactData {

    @XmlElement(name = "Email", required = true)
    protected ProductEmail email;
    @XmlElement(name = "PhoneNumber", required = true)
    protected ProductContactNumber phoneNumber;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link ProductEmail }
     *     
     */
    public ProductEmail getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductEmail }
     *     
     */
    public void setEmail(ProductEmail value) {
        this.email = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link ProductContactNumber }
     *     
     */
    public ProductContactNumber getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductContactNumber }
     *     
     */
    public void setPhoneNumber(ProductContactNumber value) {
        this.phoneNumber = value;
    }

}
