//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 11:27:53 AM CEST 
//


package com.photel.webserviceClient.BDL244.vo.cancel;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Concrete ticket product.
 * 
 * <p>Java class for ProductTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductTicket">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Product">
 *       &lt;sequence>
 *         &lt;element name="TicketClass" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsTicketClass" minOccurs="0"/>
 *         &lt;element name="Destination" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Destination" minOccurs="0"/>
 *         &lt;element name="TicketZone" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductZone" minOccurs="0"/>
 *         &lt;element name="Classification" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Classification" minOccurs="0"/>
 *         &lt;element name="TicketFeature" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductFeatureGroup" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductTicket", propOrder = {
    "ticketClass",
    "destination",
    "ticketZone",
    "classification",
    "ticketFeature"
})
public class ProductTicket
    extends Product
{

    @XmlElement(name = "TicketClass")
    protected HotelbedsTicketClass ticketClass;
    @XmlElement(name = "Destination")
    protected Destination destination;
    @XmlElement(name = "TicketZone")
    protected ProductZone ticketZone;
    @XmlElement(name = "Classification")
    protected Classification classification;
    @XmlElement(name = "TicketFeature")
    protected List<ProductFeatureGroup> ticketFeature;

    /**
     * Gets the value of the ticketClass property.
     * 
     * @return
     *     possible object is
     *     {@link HotelbedsTicketClass }
     *     
     */
    public HotelbedsTicketClass getTicketClass() {
        return ticketClass;
    }

    /**
     * Sets the value of the ticketClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelbedsTicketClass }
     *     
     */
    public void setTicketClass(HotelbedsTicketClass value) {
        this.ticketClass = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link Destination }
     *     
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Destination }
     *     
     */
    public void setDestination(Destination value) {
        this.destination = value;
    }

    /**
     * Gets the value of the ticketZone property.
     * 
     * @return
     *     possible object is
     *     {@link ProductZone }
     *     
     */
    public ProductZone getTicketZone() {
        return ticketZone;
    }

    /**
     * Sets the value of the ticketZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductZone }
     *     
     */
    public void setTicketZone(ProductZone value) {
        this.ticketZone = value;
    }

    /**
     * Gets the value of the classification property.
     * 
     * @return
     *     possible object is
     *     {@link Classification }
     *     
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * Sets the value of the classification property.
     * 
     * @param value
     *     allowed object is
     *     {@link Classification }
     *     
     */
    public void setClassification(Classification value) {
        this.classification = value;
    }

    /**
     * Gets the value of the ticketFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductFeatureGroup }
     * 
     * 
     */
    public List<ProductFeatureGroup> getTicketFeature() {
        if (ticketFeature == null) {
            ticketFeature = new ArrayList<ProductFeatureGroup>();
        }
        return this.ticketFeature;
    }

}
