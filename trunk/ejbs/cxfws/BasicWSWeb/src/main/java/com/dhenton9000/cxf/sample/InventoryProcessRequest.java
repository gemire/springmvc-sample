
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
 *         &lt;element name="InventoryProcessRequestContents" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}InventoryRequestParametersType"/>
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
    "inventoryProcessRequestContents"
})
@XmlRootElement(name = "InventoryProcessRequest")
public class InventoryProcessRequest {

    @XmlElement(name = "InventoryProcessRequestContents", required = true)
    protected InventoryRequestParametersType inventoryProcessRequestContents;

    /**
     * Gets the value of the inventoryProcessRequestContents property.
     * 
     * @return
     *     possible object is
     *     {@link InventoryRequestParametersType }
     *     
     */
    public InventoryRequestParametersType getInventoryProcessRequestContents() {
        return inventoryProcessRequestContents;
    }

    /**
     * Sets the value of the inventoryProcessRequestContents property.
     * 
     * @param value
     *     allowed object is
     *     {@link InventoryRequestParametersType }
     *     
     */
    public void setInventoryProcessRequestContents(InventoryRequestParametersType value) {
        this.inventoryProcessRequestContents = value;
    }

}
