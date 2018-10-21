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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Needed data to confirm a Purchase.
 * 
 * <p>Java class for ConfirmationPurchaseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmationPurchaseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Holder" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Customer" minOccurs="0"/>
 *         &lt;element name="AgencyReference" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ConfirmationServiceDataList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ConfirmationServiceDataList" minOccurs="0"/>
 *         &lt;element name="CommentList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}CommentList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="purchaseToken" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="11"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmationPurchaseData", propOrder = {
    "holder",
    "agencyReference",
    "confirmationServiceDataList",
    "commentList"
})
public class ConfirmationPurchaseData {

    @XmlElement(name = "Holder")
    protected Customer holder;
    @XmlElement(name = "AgencyReference")
    protected String agencyReference;
    @XmlElement(name = "ConfirmationServiceDataList")
    protected ConfirmationServiceDataList confirmationServiceDataList;
    @XmlElement(name = "CommentList")
    protected CommentList commentList;
    @XmlAttribute(required = true)
    protected String purchaseToken;

    /**
     * Gets the value of the holder property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getHolder() {
        return holder;
    }

    /**
     * Sets the value of the holder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setHolder(Customer value) {
        this.holder = value;
    }

    /**
     * Gets the value of the agencyReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyReference() {
        return agencyReference;
    }

    /**
     * Sets the value of the agencyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyReference(String value) {
        this.agencyReference = value;
    }

    /**
     * Gets the value of the confirmationServiceDataList property.
     * 
     * @return
     *     possible object is
     *     {@link ConfirmationServiceDataList }
     *     
     */
    public ConfirmationServiceDataList getConfirmationServiceDataList() {
        return confirmationServiceDataList;
    }

    /**
     * Sets the value of the confirmationServiceDataList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmationServiceDataList }
     *     
     */
    public void setConfirmationServiceDataList(ConfirmationServiceDataList value) {
        this.confirmationServiceDataList = value;
    }

    /**
     * Gets the value of the commentList property.
     * 
     * @return
     *     possible object is
     *     {@link CommentList }
     *     
     */
    public CommentList getCommentList() {
        return commentList;
    }

    /**
     * Sets the value of the commentList property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommentList }
     *     
     */
    public void setCommentList(CommentList value) {
        this.commentList = value;
    }

    /**
     * Gets the value of the purchaseToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchaseToken() {
        return purchaseToken;
    }

    /**
     * Sets the value of the purchaseToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchaseToken(String value) {
        this.purchaseToken = value;
    }

}
