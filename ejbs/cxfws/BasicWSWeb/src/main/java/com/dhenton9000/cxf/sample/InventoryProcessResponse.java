
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
 *         &lt;element name="InventoryProcessResponseAck" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}SimpleWebServiceResponseType"/>
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
    "inventoryProcessResponseAck"
})
@XmlRootElement(name = "InventoryProcessResponse")
public class InventoryProcessResponse {

    @XmlElement(name = "InventoryProcessResponseAck", required = true)
    protected SimpleWebServiceResponseType inventoryProcessResponseAck;

    /**
     * Gets the value of the inventoryProcessResponseAck property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleWebServiceResponseType }
     *     
     */
    public SimpleWebServiceResponseType getInventoryProcessResponseAck() {
        return inventoryProcessResponseAck;
    }

    /**
     * Sets the value of the inventoryProcessResponseAck property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleWebServiceResponseType }
     *     
     */
    public void setInventoryProcessResponseAck(SimpleWebServiceResponseType value) {
        this.inventoryProcessResponseAck = value;
    }

}
