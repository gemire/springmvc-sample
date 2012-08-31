
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 These are color descriptors
 *             
 * 
 * <p>Java class for ColorDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ColorDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MainColor" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType"/>
 *         &lt;element name="ParentColor" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}TextContentType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ColorDescriptionType", propOrder = {
    "mainColor",
    "parentColor"
})
public class ColorDescriptionType {

    @XmlElement(name = "MainColor", required = true)
    protected String mainColor;
    @XmlElement(name = "ParentColor")
    protected String parentColor;

    /**
     * Gets the value of the mainColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainColor() {
        return mainColor;
    }

    /**
     * Sets the value of the mainColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainColor(String value) {
        this.mainColor = value;
    }

    /**
     * Gets the value of the parentColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentColor() {
        return parentColor;
    }

    /**
     * Sets the value of the parentColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentColor(String value) {
        this.parentColor = value;
    }

}
