//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo.avail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Product feature distance containing the distance and the units.
 * 
 * <p>Java class for ProductFeatureDistanceItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductFeatureDistanceItem">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.hotelbeds.com/schemas/2005/06/messages>Number1To99999">
 *       &lt;attribute name="unit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductFeatureDistanceItem", propOrder = {
    "value"
})
public class ProductFeatureDistanceItem {

    @XmlValue
    protected int value;
    @XmlAttribute
    protected String unit;

    /**
     * Used for a number from 1 to 99999.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Used for a number from 1 to 99999.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

}
