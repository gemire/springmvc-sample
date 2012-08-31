
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 The style type which is the collection of all sku/items
 *                 for a style, the style owns the color and has its own
 *                 pricing element
 *             
 * 
 * <p>Java class for StyleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StyleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StyleID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ColorDescription" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ColorDescriptionType"/>
 *         &lt;element name="StylePricing" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ItemPricingType"/>
 *         &lt;element name="Items" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ItemsType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {
    "styleID",
    "colorDescription",
    "stylePricing",
    "items"
})
public class StyleType {

    @XmlElement(name = "StyleID", required = true)
    protected String styleID;
    @XmlElement(name = "ColorDescription", required = true)
    protected ColorDescriptionType colorDescription;
    @XmlElement(name = "StylePricing", required = true)
    protected ItemPricingType stylePricing;
    @XmlElement(name = "Items", required = true)
    protected ItemsType items;

    /**
     * Gets the value of the styleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyleID() {
        return styleID;
    }

    /**
     * Sets the value of the styleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyleID(String value) {
        this.styleID = value;
    }

    /**
     * Gets the value of the colorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link ColorDescriptionType }
     *     
     */
    public ColorDescriptionType getColorDescription() {
        return colorDescription;
    }

    /**
     * Sets the value of the colorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColorDescriptionType }
     *     
     */
    public void setColorDescription(ColorDescriptionType value) {
        this.colorDescription = value;
    }

    /**
     * Gets the value of the stylePricing property.
     * 
     * @return
     *     possible object is
     *     {@link ItemPricingType }
     *     
     */
    public ItemPricingType getStylePricing() {
        return stylePricing;
    }

    /**
     * Sets the value of the stylePricing property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemPricingType }
     *     
     */
    public void setStylePricing(ItemPricingType value) {
        this.stylePricing = value;
    }

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link ItemsType }
     *     
     */
    public ItemsType getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemsType }
     *     
     */
    public void setItems(ItemsType value) {
        this.items = value;
    }

}
