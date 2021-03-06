//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 11:27:53 AM CEST 
//


package com.photel.webserviceClient.BDL244.vo.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Needed data to confirm a Transfer service.
 * 
 * <p>Java class for ConfirmationServiceDataTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmationServiceDataTransfer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}ConfirmationServiceData">
 *       &lt;sequence>
 *         &lt;element name="TravelInfo" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceTransferTravelInfo" minOccurs="0"/>
 *         &lt;element name="HotelName" type="{http://www.hotelbeds.com/schemas/2005/06/messages}StringLength1to50" minOccurs="0"/>
 *         &lt;element name="HotelAddress" type="{http://www.hotelbeds.com/schemas/2005/06/messages}StringLength1to200" minOccurs="0"/>
 *         &lt;element name="HotelPostalCode" type="{http://www.hotelbeds.com/schemas/2005/06/messages}StringLength1to10" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmationServiceDataTransfer", propOrder = {
    "travelInfo",
    "hotelName",
    "hotelAddress",
    "hotelPostalCode"
})
public class ConfirmationServiceDataTransfer
    extends ConfirmationServiceData
{

    @XmlElement(name = "TravelInfo")
    protected ServiceTransferTravelInfo travelInfo;
    @XmlElement(name = "HotelName")
    protected String hotelName;
    @XmlElement(name = "HotelAddress")
    protected String hotelAddress;
    @XmlElement(name = "HotelPostalCode")
    protected String hotelPostalCode;

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
     * Gets the value of the hotelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the hotelAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelAddress() {
        return hotelAddress;
    }

    /**
     * Sets the value of the hotelAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelAddress(String value) {
        this.hotelAddress = value;
    }

    /**
     * Gets the value of the hotelPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHotelPostalCode() {
        return hotelPostalCode;
    }

    /**
     * Sets the value of the hotelPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHotelPostalCode(String value) {
        this.hotelPostalCode = value;
    }

}
