
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoutingInformation" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}RoutingInformationType"/>
 *         &lt;element name="Style" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}StyleType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "routingInformation",
    "style"
})
@XmlRootElement(name = "MasonInventoryElement")
public class MasonInventoryElement {

    @XmlElement(name = "RoutingInformation", required = true)
    protected RoutingInformationType routingInformation;
    @XmlElement(name = "Style", required = true)
    protected StyleType style;

    /**
     * Gets the value of the routingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RoutingInformationType }
     *     
     */
    public RoutingInformationType getRoutingInformation() {
        return routingInformation;
    }

    /**
     * Sets the value of the routingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingInformationType }
     *     
     */
    public void setRoutingInformation(RoutingInformationType value) {
        this.routingInformation = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link StyleType }
     *     
     */
    public StyleType getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link StyleType }
     *     
     */
    public void setStyle(StyleType value) {
        this.style = value;
    }

}
