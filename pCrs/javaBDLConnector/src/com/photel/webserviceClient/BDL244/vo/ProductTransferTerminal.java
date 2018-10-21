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
 * Concrete product transfer teminal. (Airport, port, railway station,...)
 * 
 * <p>Java class for ProductTransferTerminal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductTransferTerminal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Product">
 *       &lt;sequence>
 *         &lt;element name="TransferZone" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductZone" minOccurs="0"/>
 *         &lt;element name="DateTime" type="{http://www.hotelbeds.com/schemas/2005/06/messages}DateTime" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Country" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductTransferTerminal", propOrder = {
    "transferZone",
    "dateTime",
    "country"
})
public class ProductTransferTerminal
    extends Product
{

    @XmlElement(name = "TransferZone")
    protected ProductZone transferZone;
    @XmlElement(name = "DateTime")
    protected DateTime dateTime;
    @XmlElement(name = "Country")
    protected Country country;

    /**
     * Gets the value of the transferZone property.
     * 
     * @return
     *     possible object is
     *     {@link ProductZone }
     *     
     */
    public ProductZone getTransferZone() {
        return transferZone;
    }

    /**
     * Sets the value of the transferZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductZone }
     *     
     */
    public void setTransferZone(ProductZone value) {
        this.transferZone = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setDateTime(DateTime value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link Country }
     *     
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link Country }
     *     
     */
    public void setCountry(Country value) {
        this.country = value;
    }

}
