//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Concrete transfer service.
 * 
 * <p>Java class for ServiceTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceTransfer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Service">
 *       &lt;sequence>
 *         &lt;element name="TransferInfo" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductTransfer"/>
 *         &lt;element name="Paxes" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceOccupancy" minOccurs="0"/>
 *         &lt;element name="PickupLocation" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Product"/>
 *         &lt;element name="DestinationLocation" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Product"/>
 *         &lt;element name="TravelInfo" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceTransferTravelInfo" minOccurs="0"/>
 *         &lt;element name="CancellationPolicy" type="{http://www.hotelbeds.com/schemas/2005/06/messages}PriceList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="transferType" type="{http://www.hotelbeds.com/schemas/2005/06/messages}HotelbedsTransferType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceTransfer", propOrder = {
    "transferInfo",
    "paxes",
    "pickupLocation",
    "destinationLocation",
    "travelInfo",
    "cancellationPolicy"
})
public class ServiceTransfer
    extends Service
{

    @XmlElement(name = "TransferInfo", required = true)
    protected ProductTransfer transferInfo;
    @XmlElement(name = "Paxes")
    protected ServiceOccupancy paxes;
    @XmlElement(name = "PickupLocation", required = true)
    protected Product pickupLocation;
    @XmlElement(name = "DestinationLocation", required = true)
    protected Product destinationLocation;
    @XmlElement(name = "TravelInfo")
    protected ServiceTransferTravelInfo travelInfo;
    @XmlElement(name = "CancellationPolicy")
    protected PriceList cancellationPolicy;
    @XmlAttribute
    protected HotelbedsTransferType transferType;

    /**
     * Gets the value of the transferInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProductTransfer }
     *     
     */
    public ProductTransfer getTransferInfo() {
        return transferInfo;
    }

    /**
     * Sets the value of the transferInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTransfer }
     *     
     */
    public void setTransferInfo(ProductTransfer value) {
        this.transferInfo = value;
    }

    /**
     * Gets the value of the paxes property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceOccupancy }
     *     
     */
    public ServiceOccupancy getPaxes() {
        return paxes;
    }

    /**
     * Sets the value of the paxes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceOccupancy }
     *     
     */
    public void setPaxes(ServiceOccupancy value) {
        this.paxes = value;
    }

    /**
     * Gets the value of the pickupLocation property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getPickupLocation() {
        return pickupLocation;
    }

    /**
     * Sets the value of the pickupLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setPickupLocation(Product value) {
        this.pickupLocation = value;
    }

    /**
     * Gets the value of the destinationLocation property.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public Product getDestinationLocation() {
        return destinationLocation;
    }

    /**
     * Sets the value of the destinationLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setDestinationLocation(Product value) {
        this.destinationLocation = value;
    }

    /**
     * Gets the value of the travelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTransferTravelInfo }
     *     
     */
    public ServiceTransferTravelInfo getTravelInfo() {
        return travelInfo;
    }

    /**
     * Sets the value of the travelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTransferTravelInfo }
     *     
     */
    public void setTravelInfo(ServiceTransferTravelInfo value) {
        this.travelInfo = value;
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
     * Gets the value of the transferType property.
     * 
     * @return
     *     possible object is
     *     {@link HotelbedsTransferType }
     *     
     */
    public HotelbedsTransferType getTransferType() {
        return transferType;
    }

    /**
     * Sets the value of the transferType property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelbedsTransferType }
     *     
     */
    public void setTransferType(HotelbedsTransferType value) {
        this.transferType = value;
    }

}
