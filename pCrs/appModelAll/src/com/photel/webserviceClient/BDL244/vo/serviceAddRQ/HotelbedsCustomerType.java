//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.18 at 05:02:20 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.serviceAddRQ;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelbedsCustomerType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelbedsCustomerType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AD"/>
 *     &lt;enumeration value="CH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HotelbedsCustomerType")
@XmlEnum
public enum HotelbedsCustomerType {

    AD,
    CH;

    public String value() {
        return name();
    }

    public static HotelbedsCustomerType fromValue(String v) {
        return valueOf(v);
    }

}