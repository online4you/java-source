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
 * Concrete car service.
 * 
 * <p>Java class for ServiceCar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceCar">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Service">
 *       &lt;sequence>
 *         &lt;element name="CarInfo" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductCar"/>
 *         &lt;element name="CarGroup" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductCarGroup"/>
 *         &lt;element name="Driver" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Customer" minOccurs="0"/>
 *         &lt;element name="RentalOffice" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductCarOffice" minOccurs="0"/>
 *         &lt;element name="ReturnOffice" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductCarOffice" minOccurs="0"/>
 *         &lt;element name="SpecialEquipmentList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceCarSpecialEquipList" minOccurs="0"/>
 *         &lt;element name="FlightNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="20"/>
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
@XmlType(name = "ServiceCar", propOrder = {
    "carInfo",
    "carGroup",
    "driver",
    "rentalOffice",
    "returnOffice",
    "specialEquipmentList",
    "flightNumber"
})
public class ServiceCar
    extends Service
{

    @XmlElement(name = "CarInfo", required = true)
    protected ProductCar carInfo;
    @XmlElement(name = "CarGroup", required = true)
    protected ProductCarGroup carGroup;
    @XmlElement(name = "Driver")
    protected Customer driver;
    @XmlElement(name = "RentalOffice")
    protected ProductCarOffice rentalOffice;
    @XmlElement(name = "ReturnOffice")
    protected ProductCarOffice returnOffice;
    @XmlElement(name = "SpecialEquipmentList")
    protected ServiceCarSpecialEquipList specialEquipmentList;
    @XmlElement(name = "FlightNumber")
    protected String flightNumber;

    /**
     * Gets the value of the carInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCar }
     *     
     */
    public ProductCar getCarInfo() {
        return carInfo;
    }

    /**
     * Sets the value of the carInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCar }
     *     
     */
    public void setCarInfo(ProductCar value) {
        this.carInfo = value;
    }

    /**
     * Gets the value of the carGroup property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCarGroup }
     *     
     */
    public ProductCarGroup getCarGroup() {
        return carGroup;
    }

    /**
     * Sets the value of the carGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCarGroup }
     *     
     */
    public void setCarGroup(ProductCarGroup value) {
        this.carGroup = value;
    }

    /**
     * Gets the value of the driver property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getDriver() {
        return driver;
    }

    /**
     * Sets the value of the driver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setDriver(Customer value) {
        this.driver = value;
    }

    /**
     * Gets the value of the rentalOffice property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCarOffice }
     *     
     */
    public ProductCarOffice getRentalOffice() {
        return rentalOffice;
    }

    /**
     * Sets the value of the rentalOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCarOffice }
     *     
     */
    public void setRentalOffice(ProductCarOffice value) {
        this.rentalOffice = value;
    }

    /**
     * Gets the value of the returnOffice property.
     * 
     * @return
     *     possible object is
     *     {@link ProductCarOffice }
     *     
     */
    public ProductCarOffice getReturnOffice() {
        return returnOffice;
    }

    /**
     * Sets the value of the returnOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductCarOffice }
     *     
     */
    public void setReturnOffice(ProductCarOffice value) {
        this.returnOffice = value;
    }

    /**
     * Gets the value of the specialEquipmentList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCarSpecialEquipList }
     *     
     */
    public ServiceCarSpecialEquipList getSpecialEquipmentList() {
        return specialEquipmentList;
    }

    /**
     * Sets the value of the specialEquipmentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCarSpecialEquipList }
     *     
     */
    public void setSpecialEquipmentList(ServiceCarSpecialEquipList value) {
        this.specialEquipmentList = value;
    }

    /**
     * Gets the value of the flightNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Sets the value of the flightNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNumber(String value) {
        this.flightNumber = value;
    }

}
