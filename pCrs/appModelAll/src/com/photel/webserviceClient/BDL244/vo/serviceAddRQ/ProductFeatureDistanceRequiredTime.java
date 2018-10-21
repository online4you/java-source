//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.18 at 05:02:20 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.serviceAddRQ;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Time to cover the distance using the specified mean of transport.
 * 
 * <p>Java class for ProductFeatureDistanceRequiredTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductFeatureDistanceRequiredTime">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.hotelbeds.com/schemas/2005/06/messages>Number1To999999999">
 *       &lt;attribute name="mean" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="50"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="unit" default="minutes">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="25"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductFeatureDistanceRequiredTime", propOrder = {
    "value"
})
public class ProductFeatureDistanceRequiredTime {

    @XmlValue
    protected int value;
    @XmlAttribute(required = true)
    protected String mean;
    @XmlAttribute
    protected String unit;

    /**
     * Used for a number from 1 to 999999999.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the mean property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMean() {
        return mean;
    }

    /**
     * Sets the value of the mean property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMean(String value) {
        this.mean = value;
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
        if (unit == null) {
            return "minutes";
        } else {
            return unit;
        }
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
