//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.08 at 09:26:37 AM CET 
//


package com.photel.webserviceClient.BDL244.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contrete transfer product.
 * 
 * <p>Java class for ProductTransfer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductTransfer">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Product">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductTransferType"/>
 *         &lt;element name="VehicleType" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductTransferVehicleType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductTransfer", propOrder = {
    "type",
    "vehicleType"
})
public class ProductTransfer
    extends Product
{

    @XmlElement(name = "Type", required = true)
    protected ProductTransferType type;
    @XmlElement(name = "VehicleType", required = true)
    protected ProductTransferVehicleType vehicleType;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ProductTransferType }
     *     
     */
    public ProductTransferType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTransferType }
     *     
     */
    public void setType(ProductTransferType value) {
        this.type = value;
    }

    /**
     * Gets the value of the vehicleType property.
     * 
     * @return
     *     possible object is
     *     {@link ProductTransferVehicleType }
     *     
     */
    public ProductTransferVehicleType getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets the value of the vehicleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTransferVehicleType }
     *     
     */
    public void setVehicleType(ProductTransferVehicleType value) {
        this.vehicleType = value;
    }

}
