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
 * List of hotel board groups.
 * 
 * <p>Java class for ProductHotelBoardGroupList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductHotelBoardGroupList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HotelBoardGroup" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductHotelBoardGroup" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductHotelBoardGroupList", propOrder = {
    "hotelBoardGroup"
})
public class ProductHotelBoardGroupList {

    @XmlElement(name = "HotelBoardGroup", required = true)
    protected List<ProductHotelBoardGroup> hotelBoardGroup;

    /**
     * Gets the value of the hotelBoardGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelBoardGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelBoardGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProductHotelBoardGroup }
     * 
     * 
     */
    public List<ProductHotelBoardGroup> getHotelBoardGroup() {
        if (hotelBoardGroup == null) {
            hotelBoardGroup = new ArrayList<ProductHotelBoardGroup>();
        }
        return this.hotelBoardGroup;
    }

}
