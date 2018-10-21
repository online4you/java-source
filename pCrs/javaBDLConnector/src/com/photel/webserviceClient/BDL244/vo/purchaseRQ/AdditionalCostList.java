//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.01 at 12:19:03 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.purchaseRQ;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * List of additional costs.
 * 
 * <p>Java class for AdditionalCostList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdditionalCostList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Currency" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Currency" minOccurs="0"/>
 *         &lt;element name="PvpEquivalent" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AdditionalCost" type="{http://www.hotelbeds.com/schemas/2005/06/messages}AdditionalCost" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdditionalCostList", propOrder = {
    "currency",
    "pvpEquivalent",
    "additionalCost"
})
public class AdditionalCostList {

    @XmlElement(name = "Currency")
    protected Currency currency;
    @XmlElement(name = "PvpEquivalent")
    protected BigDecimal pvpEquivalent;
    @XmlElement(name = "AdditionalCost", required = true)
    protected List<AdditionalCost> additionalCost;

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link Currency }
     *     
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currency }
     *     
     */
    public void setCurrency(Currency value) {
        this.currency = value;
    }

    /**
     * Gets the value of the pvpEquivalent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPvpEquivalent() {
        return pvpEquivalent;
    }

    /**
     * Sets the value of the pvpEquivalent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPvpEquivalent(BigDecimal value) {
        this.pvpEquivalent = value;
    }

    /**
     * Gets the value of the additionalCost property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalCost property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalCost().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalCost }
     * 
     * 
     */
    public List<AdditionalCost> getAdditionalCost() {
        if (additionalCost == null) {
            additionalCost = new ArrayList<AdditionalCost>();
        }
        return this.additionalCost;
    }

}