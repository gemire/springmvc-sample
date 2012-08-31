
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ItemAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sku" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="Width" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="Length" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="ManufacturerName" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="ManufacterModel" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType" minOccurs="0"/>
 *         &lt;element name="UPC" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="Brand" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="ShortDescription" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="TextLongDescription">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HtmlLongDescription" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="MerchantCategories" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}MerchantCategoriesType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemAttributesType", propOrder = {
    "sku",
    "width",
    "length",
    "manufacturerName",
    "manufacterModel",
    "upc",
    "brand",
    "shortDescription",
    "textLongDescription",
    "htmlLongDescription",
    "merchantCategories"
})
public class ItemAttributesType {

    @XmlElement(name = "Sku", required = true)
    protected String sku;
    @XmlElement(name = "Width", required = true)
    protected String width;
    @XmlElement(name = "Length", required = true)
    protected String length;
    @XmlElement(name = "ManufacturerName", required = true)
    protected String manufacturerName;
    @XmlElement(name = "ManufacterModel")
    protected String manufacterModel;
    @XmlElement(name = "UPC", required = true)
    protected String upc;
    @XmlElement(name = "Brand", required = true)
    protected String brand;
    @XmlElement(name = "ShortDescription", required = true)
    protected String shortDescription;
    @XmlElement(name = "TextLongDescription", required = true)
    protected String textLongDescription;
    @XmlElement(name = "HtmlLongDescription", required = true)
    protected String htmlLongDescription;
    @XmlElement(name = "MerchantCategories", required = true)
    protected MerchantCategoriesType merchantCategories;

    /**
     * Gets the value of the sku property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSku() {
        return sku;
    }

    /**
     * Sets the value of the sku property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSku(String value) {
        this.sku = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWidth(String value) {
        this.width = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLength(String value) {
        this.length = value;
    }

    /**
     * Gets the value of the manufacturerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * Sets the value of the manufacturerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacturerName(String value) {
        this.manufacturerName = value;
    }

    /**
     * Gets the value of the manufacterModel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManufacterModel() {
        return manufacterModel;
    }

    /**
     * Sets the value of the manufacterModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManufacterModel(String value) {
        this.manufacterModel = value;
    }

    /**
     * Gets the value of the upc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUPC() {
        return upc;
    }

    /**
     * Sets the value of the upc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUPC(String value) {
        this.upc = value;
    }

    /**
     * Gets the value of the brand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the shortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * Sets the value of the shortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShortDescription(String value) {
        this.shortDescription = value;
    }

    /**
     * Gets the value of the textLongDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextLongDescription() {
        return textLongDescription;
    }

    /**
     * Sets the value of the textLongDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextLongDescription(String value) {
        this.textLongDescription = value;
    }

    /**
     * Gets the value of the htmlLongDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHtmlLongDescription() {
        return htmlLongDescription;
    }

    /**
     * Sets the value of the htmlLongDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHtmlLongDescription(String value) {
        this.htmlLongDescription = value;
    }

    /**
     * Gets the value of the merchantCategories property.
     * 
     * @return
     *     possible object is
     *     {@link MerchantCategoriesType }
     *     
     */
    public MerchantCategoriesType getMerchantCategories() {
        return merchantCategories;
    }

    /**
     * Sets the value of the merchantCategories property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerchantCategoriesType }
     *     
     */
    public void setMerchantCategories(MerchantCategoriesType value) {
        this.merchantCategories = value;
    }

}
