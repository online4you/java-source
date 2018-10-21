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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Minimum sale element.
 * 
 * <p>Java class for Product complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Product">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Code" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Name" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DescriptionList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductDescriptionList" minOccurs="0"/>
 *         &lt;element name="ImageList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductImageList" minOccurs="0"/>
 *         &lt;element name="Contact" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ContactInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
    "code",
    "name",
    "descriptionList",
    "imageList",
    "contact"
})
@XmlSeeAlso({
    ProductTicket.class,
    ProductZone.class,
    ProductTransferTerminal.class,
    ProductTransfer.class,
    ProductCarOffice.class,
    ProductHotel.class,
    ProductInsurance.class,
    ProductCar.class,
    ProductTransferHotel.class
})
public abstract class Product {

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "DescriptionList")
    protected ProductDescriptionList descriptionList;
    @XmlElement(name = "ImageList")
    protected ProductImageList imageList;
    @XmlElement(name = "Contact")
    protected ContactInfo contact;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the descriptionList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductDescriptionList }
     *     
     */
    public ProductDescriptionList getDescriptionList() {
        return descriptionList;
    }

    /**
     * Sets the value of the descriptionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductDescriptionList }
     *     
     */
    public void setDescriptionList(ProductDescriptionList value) {
        this.descriptionList = value;
    }

    /**
     * Gets the value of the imageList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductImageList }
     *     
     */
    public ProductImageList getImageList() {
        return imageList;
    }

    /**
     * Sets the value of the imageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductImageList }
     *     
     */
    public void setImageList(ProductImageList value) {
        this.imageList = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link ContactInfo }
     *     
     */
    public ContactInfo getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactInfo }
     *     
     */
    public void setContact(ContactInfo value) {
        this.contact = value;
    }

}
