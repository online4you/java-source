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
 * Concrete hotel service.
 * 
 * <p>Java class for ServiceHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceHotel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Service">
 *       &lt;sequence>
 *         &lt;element name="PackageRate" type="{http://www.hotelbeds.com/schemas/2005/06/messages}YesNo" minOccurs="0"/>
 *         &lt;element name="HotelInfo" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductHotel"/>
 *         &lt;element name="AvailableRoom" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceHotelRoomList" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceHotel", propOrder = {
    "packageRate",
    "hotelInfo",
    "availableRoom"
})
public class ServiceHotel
    extends Service
{

    @XmlElement(name = "PackageRate")
    protected YesNo packageRate;
    @XmlElement(name = "HotelInfo", required = true)
    protected ProductHotel hotelInfo;
    @XmlElement(name = "AvailableRoom", required = true)
    protected List<ServiceHotelRoomList> availableRoom;

    /**
     * Gets the value of the packageRate property.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getPackageRate() {
        return packageRate;
    }

    /**
     * Sets the value of the packageRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setPackageRate(YesNo value) {
        this.packageRate = value;
    }

    /**
     * Gets the value of the hotelInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHotel }
     *     
     */
    public ProductHotel getHotelInfo() {
        return hotelInfo;
    }

    /**
     * Sets the value of the hotelInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHotel }
     *     
     */
    public void setHotelInfo(ProductHotel value) {
        this.hotelInfo = value;
    }

    /**
     * Gets the value of the availableRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceHotelRoomList }
     * 
     * 
     */
    public List<ServiceHotelRoomList> getAvailableRoom() {
        if (availableRoom == null) {
            availableRoom = new ArrayList<ServiceHotelRoomList>();
        }
        return this.availableRoom;
    }

}
