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
 * Product feature group.
 * 
 * <p>Java class for ProductFeatureGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductFeatureGroup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductFeature">
 *       &lt;sequence>
 *         &lt;element name="FeatureList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductFeatureList"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductFeatureGroup", propOrder = {
    "featureList"
})
public class ProductFeatureGroup
    extends ProductFeature
{

    @XmlElement(name = "FeatureList", required = true)
    protected ProductFeatureList featureList;

    /**
     * Gets the value of the featureList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductFeatureList }
     *     
     */
    public ProductFeatureList getFeatureList() {
        return featureList;
    }

    /**
     * Sets the value of the featureList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductFeatureList }
     *     
     */
    public void setFeatureList(ProductFeatureList value) {
        this.featureList = value;
    }

}