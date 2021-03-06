//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo.avail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Car information.
 * 
 * <p>Java class for ProductCar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductCar">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Product">
 *       &lt;sequence>
 *         &lt;element name="TransmissionType" type="{http://www.hotelbeds.com/schemas/2005/06/messages}VehicleTransmissionSimpleType" minOccurs="0"/>
 *         &lt;element name="AirConditioning" type="{http://www.hotelbeds.com/schemas/2005/06/messages}YesNo" minOccurs="0"/>
 *         &lt;element name="Vendor" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductVendor" minOccurs="0"/>
 *         &lt;element name="DoorCount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ABS" type="{http://www.hotelbeds.com/schemas/2005/06/messages}YesNo" minOccurs="0"/>
 *         &lt;element name="Airbag" type="{http://www.hotelbeds.com/schemas/2005/06/messages}YesNo" minOccurs="0"/>
 *         &lt;element name="PowerSteering" type="{http://www.hotelbeds.com/schemas/2005/06/messages}YesNo" minOccurs="0"/>
 *         &lt;element name="SeatCount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="99"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductCar", propOrder = {
    "transmissionType",
    "airConditioning",
    "vendor",
    "doorCount",
    "abs",
    "airbag",
    "powerSteering",
    "seatCount"
})
public class ProductCar
    extends Product
{

    @XmlElement(name = "TransmissionType")
    protected VehicleTransmissionSimpleType transmissionType;
    @XmlElement(name = "AirConditioning")
    protected YesNo airConditioning;
    @XmlElement(name = "Vendor")
    protected ProductVendor vendor;
    @XmlElement(name = "DoorCount")
    protected Integer doorCount;
    @XmlElement(name = "ABS")
    protected YesNo abs;
    @XmlElement(name = "Airbag")
    protected YesNo airbag;
    @XmlElement(name = "PowerSteering")
    protected YesNo powerSteering;
    @XmlElement(name = "SeatCount")
    protected Integer seatCount;

    /**
     * Gets the value of the transmissionType property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleTransmissionSimpleType }
     *     
     */
    public VehicleTransmissionSimpleType getTransmissionType() {
        return transmissionType;
    }

    /**
     * Sets the value of the transmissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleTransmissionSimpleType }
     *     
     */
    public void setTransmissionType(VehicleTransmissionSimpleType value) {
        this.transmissionType = value;
    }

    /**
     * Gets the value of the airConditioning property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getAirConditioning() {
        return airConditioning;
    }

    /**
     * Sets the value of the airConditioning property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setAirConditioning(YesNo value) {
        this.airConditioning = value;
    }

    /**
     * Gets the value of the vendor property.
     * 
     * @return
     *     possible object is
     *     {@link ProductVendor }
     *     
     */
    public ProductVendor getVendor() {
        return vendor;
    }

    /**
     * Sets the value of the vendor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductVendor }
     *     
     */
    public void setVendor(ProductVendor value) {
        this.vendor = value;
    }

    /**
     * Gets the value of the doorCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDoorCount() {
        return doorCount;
    }

    /**
     * Sets the value of the doorCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDoorCount(Integer value) {
        this.doorCount = value;
    }

    /**
     * Gets the value of the abs property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getABS() {
        return abs;
    }

    /**
     * Sets the value of the abs property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setABS(YesNo value) {
        this.abs = value;
    }

    /**
     * Gets the value of the airbag property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getAirbag() {
        return airbag;
    }

    /**
     * Sets the value of the airbag property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setAirbag(YesNo value) {
        this.airbag = value;
    }

    /**
     * Gets the value of the powerSteering property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPowerSteering() {
        return powerSteering;
    }

    /**
     * Sets the value of the powerSteering property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPowerSteering(YesNo value) {
        this.powerSteering = value;
    }

    /**
     * Gets the value of the seatCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSeatCount() {
        return seatCount;
    }

    /**
     * Sets the value of the seatCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSeatCount(Integer value) {
        this.seatCount = value;
    }

}
