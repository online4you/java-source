//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.5-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.01 at 12:19:03 PM CEST 
//


package com.photel.webserviceClient.BDL244.vo.purchaseRQ;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Contrete hotel product.
 * 
 * <p>Java class for ProductHotel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductHotel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.hotelbeds.com/schemas/2005/06/messages}Product">
 *       &lt;sequence>
 *         &lt;element name="Category" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductHotelCategory" minOccurs="0"/>
 *         &lt;element name="Destination" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Destination" minOccurs="0"/>
 *         &lt;element name="ChildAge" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.hotelbeds.com/schemas/2005/06/messages}AgeRange"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FacilityList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductFeatureList" minOccurs="0"/>
 *         &lt;element name="Chain" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductVendor" minOccurs="0"/>
 *         &lt;element name="LicenseNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Position" type="{http://www.hotelbeds.com/schemas/2005/06/messages}Position" minOccurs="0"/>
 *         &lt;element name="IssuesList" type="{http://www.hotelbeds.com/schemas/2005/06/messages}ProductHotelIssueList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductHotel", propOrder = {
    "category",
    "destination",
    "childAge",
    "facilityList",
    "chain",
    "licenseNumber",
    "position",
    "issuesList"
})
public class ProductHotel
    extends Product
{

    @XmlElement(name = "Category")
    protected ProductHotelCategory category;
    @XmlElement(name = "Destination")
    protected Destination destination;
    @XmlElement(name = "ChildAge")
    protected ProductHotel.ChildAge childAge;
    @XmlElement(name = "FacilityList")
    protected ProductFeatureList facilityList;
    @XmlElement(name = "Chain")
    protected ProductVendor chain;
    @XmlElement(name = "LicenseNumber")
    protected String licenseNumber;
    @XmlElement(name = "Position")
    protected Position position;
    @XmlElement(name = "IssuesList")
    protected ProductHotelIssueList issuesList;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHotelCategory }
     *     
     */
    public ProductHotelCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHotelCategory }
     *     
     */
    public void setCategory(ProductHotelCategory value) {
        this.category = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link Destination }
     *     
     */
    public Destination getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Destination }
     *     
     */
    public void setDestination(Destination value) {
        this.destination = value;
    }

    /**
     * Gets the value of the childAge property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHotel.ChildAge }
     *     
     */
    public ProductHotel.ChildAge getChildAge() {
        return childAge;
    }

    /**
     * Sets the value of the childAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHotel.ChildAge }
     *     
     */
    public void setChildAge(ProductHotel.ChildAge value) {
        this.childAge = value;
    }

    /**
     * Gets the value of the facilityList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductFeatureList }
     *     
     */
    public ProductFeatureList getFacilityList() {
        return facilityList;
    }

    /**
     * Sets the value of the facilityList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductFeatureList }
     *     
     */
    public void setFacilityList(ProductFeatureList value) {
        this.facilityList = value;
    }

    /**
     * Gets the value of the chain property.
     * 
     * @return
     *     possible object is
     *     {@link ProductVendor }
     *     
     */
    public ProductVendor getChain() {
        return chain;
    }

    /**
     * Sets the value of the chain property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductVendor }
     *     
     */
    public void setChain(ProductVendor value) {
        this.chain = value;
    }

    /**
     * Gets the value of the licenseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * Sets the value of the licenseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicenseNumber(String value) {
        this.licenseNumber = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link Position }
     *     
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link Position }
     *     
     */
    public void setPosition(Position value) {
        this.position = value;
    }

    /**
     * Gets the value of the issuesList property.
     * 
     * @return
     *     possible object is
     *     {@link ProductHotelIssueList }
     *     
     */
    public ProductHotelIssueList getIssuesList() {
        return issuesList;
    }

    /**
     * Sets the value of the issuesList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductHotelIssueList }
     *     
     */
    public void setIssuesList(ProductHotelIssueList value) {
        this.issuesList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{http://www.hotelbeds.com/schemas/2005/06/messages}AgeRange"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ChildAge {

        @XmlAttribute
        protected Integer ageFrom;
        @XmlAttribute
        protected Integer ageTo;

        /**
         * Gets the value of the ageFrom property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getAgeFrom() {
            return ageFrom;
        }

        /**
         * Sets the value of the ageFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setAgeFrom(Integer value) {
            this.ageFrom = value;
        }

        /**
         * Gets the value of the ageTo property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getAgeTo() {
            return ageTo;
        }

        /**
         * Sets the value of the ageTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setAgeTo(Integer value) {
            this.ageTo = value;
        }

    }

}
