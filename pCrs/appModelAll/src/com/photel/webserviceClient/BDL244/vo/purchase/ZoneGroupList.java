//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.13 at 05:38:07 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.purchase;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of zone groups.
 * 
 * <p>Java class for ZoneGroupList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ZoneGroupList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZoneGroup" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ZoneGroup" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZoneGroupList", propOrder = {
    "zoneGroup"
})
public class ZoneGroupList {

    @XmlElement(name = "ZoneGroup", required = true)
    protected List<ZoneGroup> zoneGroup;

    /**
     * Gets the value of the zoneGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the zoneGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getZoneGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ZoneGroup }
     * 
     * 
     */
    public List<ZoneGroup> getZoneGroup() {
        if (zoneGroup == null) {
            zoneGroup = new ArrayList<ZoneGroup>();
        }
        return this.zoneGroup;
    }

}
