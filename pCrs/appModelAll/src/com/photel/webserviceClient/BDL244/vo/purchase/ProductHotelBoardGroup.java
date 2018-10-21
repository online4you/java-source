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
 * Contains simple hotel board list for a hotel board group.
 * 
 * <p>Java class for ProductHotelBoardGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductHotelBoardGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupHotelBoard" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductHotelBoard"/>
 *         &lt;element name="SimpleHotelBoardList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductHotelBoardList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductHotelBoardGroup", propOrder = {
    "groupHotelBoard",
    "simpleHotelBoardList"
})
public class ProductHotelBoardGroup {

    @XmlElement(name = "GroupHotelBoard", required = true)
    protected ProductHotelBoard groupHotelBoard;
    @XmlElement(name = "SimpleHotelBoardList", required = true)
    protected ProductHotelBoardList simpleHotelBoardList;

    /**
     * Gets the value of the groupHotelBoard property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHotelBoard }
     *     
     */
    public ProductHotelBoard getGroupHotelBoard() {
        return groupHotelBoard;
    }

    /**
     * Sets the value of the groupHotelBoard property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHotelBoard }
     *     
     */
    public void setGroupHotelBoard(ProductHotelBoard value) {
        this.groupHotelBoard = value;
    }

    /**
     * Gets the value of the simpleHotelBoardList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHotelBoardList }
     *     
     */
    public ProductHotelBoardList getSimpleHotelBoardList() {
        return simpleHotelBoardList;
    }

    /**
     * Sets the value of the simpleHotelBoardList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHotelBoardList }
     *     
     */
    public void setSimpleHotelBoardList(ProductHotelBoardList value) {
        this.simpleHotelBoardList = value;
    }

}
