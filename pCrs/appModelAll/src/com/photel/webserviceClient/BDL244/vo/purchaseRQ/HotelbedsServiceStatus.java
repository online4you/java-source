//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.01 at 12:19:03 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.purchaseRQ;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HotelbedsServiceStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HotelbedsServiceStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="CONFIRMED"/>
 *     &lt;enumeration value="MODIFIED"/>
 *     &lt;enumeration value="CANCELLED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HotelbedsServiceStatus")
@XmlEnum
public enum HotelbedsServiceStatus {

    NEW,
    CONFIRMED,
    MODIFIED,
    CANCELLED;

    public String value() {
        return name();
    }

    public static HotelbedsServiceStatus fromValue(String v) {
        return valueOf(v);
    }

}
