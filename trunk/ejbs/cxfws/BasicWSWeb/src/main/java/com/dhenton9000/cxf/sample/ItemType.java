
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 the sku or item, with its associated information
 *             
 * 
 * <p>Java class for ItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Attributes" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ItemAttributesType"/>
 *         &lt;element name="Pricing" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ItemPricingType"/>
 *         &lt;element name="Quantity" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ItemQuantityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType", propOrder = {
    "attributes",
    "pricing",
    "quantity"
})
public class ItemType {

    @XmlElement(name = "Attributes", required = true)
    protected ItemAttributesType attributes;
    @XmlElement(name = "Pricing", required = true)
    protected ItemPricingType pricing;
    @XmlElement(name = "Quantity", required = true)
    protected ItemQuantityType quantity;

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link ItemAttributesType }
     *     
     */
    public ItemAttributesType getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemAttributesType }
     *     
     */
    public void setAttributes(ItemAttributesType value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the pricing property.
     * 
     * @return
     *     possible object is
     *     {@link ItemPricingType }
     *     
     */
    public ItemPricingType getPricing() {
        return pricing;
    }

    /**
     * Sets the value of the pricing property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemPricingType }
     *     
     */
    public void setPricing(ItemPricingType value) {
        this.pricing = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link ItemQuantityType }
     *     
     */
    public ItemQuantityType getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemQuantityType }
     *     
     */
    public void setQuantity(ItemQuantityType value) {
        this.quantity = value;
    }

}
