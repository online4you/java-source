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
 * Contains simple hotel room type list for a hotel room type group.
 * 
 * <p>Java class for ServiceHotelRoomTypeGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceHotelRoomTypeGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupHotelRoomType" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceHotelRoomType"/>
 *         &lt;element name="SimpleHotelRoomTypeList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceHotelRoomTypeList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceHotelRoomTypeGroup", propOrder = {
    "groupHotelRoomType",
    "simpleHotelRoomTypeList"
})
public class ServiceHotelRoomTypeGroup {

    @XmlElement(name = "GroupHotelRoomType", required = true)
    protected ServiceHotelRoomType groupHotelRoomType;
    @XmlElement(name = "SimpleHotelRoomTypeList", required = true)
    protected ServiceHotelRoomTypeList simpleHotelRoomTypeList;

    /**
     * Gets the value of the groupHotelRoomType property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceHotelRoomType }
     *     
     */
    public ServiceHotelRoomType getGroupHotelRoomType() {
        return groupHotelRoomType;
    }

    /**
     * Sets the value of the groupHotelRoomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceHotelRoomType }
     *     
     */
    public void setGroupHotelRoomType(ServiceHotelRoomType value) {
        this.groupHotelRoomType = value;
    }

    /**
     * Gets the value of the simpleHotelRoomTypeList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceHotelRoomTypeList }
     *     
     */
    public ServiceHotelRoomTypeList getSimpleHotelRoomTypeList() {
        return simpleHotelRoomTypeList;
    }

    /**
     * Sets the value of the simpleHotelRoomTypeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceHotelRoomTypeList }
     *     
     */
    public void setSimpleHotelRoomTypeList(ServiceHotelRoomTypeList value) {
        this.simpleHotelRoomTypeList = value;
    }

}
