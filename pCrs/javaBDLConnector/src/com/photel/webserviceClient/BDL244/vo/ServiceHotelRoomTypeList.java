//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Service hotel room type list.
 * 
 * <p>Java class for ServiceHotelRoomTypeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceHotelRoomTypeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoomType" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceHotelRoomType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceHotelRoomTypeList", propOrder = {
    "roomType"
})
public class ServiceHotelRoomTypeList {

    @XmlElement(name = "RoomType", required = true)
    protected List<ServiceHotelRoomType> roomType;

    /**
     * Gets the value of the roomType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceHotelRoomType }
     * 
     * 
     */
    public List<ServiceHotelRoomType> getRoomType() {
        if (roomType == null) {
            roomType = new ArrayList<ServiceHotelRoomType>();
        }
        return this.roomType;
    }

}
