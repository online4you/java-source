//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for CommentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="INCOMING"/>
 *     &lt;enumeration value="AGENCY"/>
 *     &lt;enumeration value="SERVICE"/>
 *     &lt;enumeration value="CONTRACT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum CommentType {

    INCOMING,
    AGENCY,
    SERVICE,
    CONTRACT;

    public String value() {
        return name();
    }

    public static CommentType fromValue(String v) {
        return valueOf(v);
    }

}
