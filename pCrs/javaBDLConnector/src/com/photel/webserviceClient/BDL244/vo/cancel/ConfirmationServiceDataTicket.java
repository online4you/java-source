//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.11 at 11:27:53 AM CEST 
//


package com.photel.webserviceClient.BDL244.vo.cancel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Needed data to confirm a Ticket service.
 * 
 * <p>Java class for ConfirmationServiceDataTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmationServiceDataTicket">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}ConfirmationServiceData">
 *       &lt;sequence>
 *         &lt;element name="ServiceDetailList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ServiceDetailList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmationServiceDataTicket", propOrder = {
    "serviceDetailList"
})
public class ConfirmationServiceDataTicket
    extends ConfirmationServiceData
{

    @XmlElement(name = "ServiceDetailList")
    protected ServiceDetailList serviceDetailList;

    /**
     * Gets the value of the serviceDetailList property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceDetailList }
     *     
     */
    public ServiceDetailList getServiceDetailList() {
        return serviceDetailList;
    }

    /**
     * Sets the value of the serviceDetailList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceDetailList }
     *     
     */
    public void setServiceDetailList(ServiceDetailList value) {
        this.serviceDetailList = value;
    }

}
