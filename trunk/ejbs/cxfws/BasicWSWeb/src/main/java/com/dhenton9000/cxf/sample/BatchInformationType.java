
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 optional element used to describe the participation of this
 *                 style in a batch process
 *             
 * 
 * <p>Java class for BatchInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BatchInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BatchId" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}nonZeroInteger"/>
 *         &lt;element name="BatchPosition" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}nonZeroInteger"/>
 *         &lt;element name="Total" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}nonZeroInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BatchInformationType", propOrder = {
    "batchId",
    "batchPosition",
    "total"
})
public class BatchInformationType {

    @XmlElement(name = "BatchId")
    protected long batchId;
    @XmlElement(name = "BatchPosition")
    protected long batchPosition;
    @XmlElement(name = "Total")
    protected long total;

    /**
     * Gets the value of the batchId property.
     * 
     */
    public long getBatchId() {
        return batchId;
    }

    /**
     * Sets the value of the batchId property.
     * 
     */
    public void setBatchId(long value) {
        this.batchId = value;
    }

    /**
     * Gets the value of the batchPosition property.
     * 
     */
    public long getBatchPosition() {
        return batchPosition;
    }

    /**
     * Sets the value of the batchPosition property.
     * 
     */
    public void setBatchPosition(long value) {
        this.batchPosition = value;
    }

    /**
     * Gets the value of the total property.
     * 
     */
    public long getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     */
    public void setTotal(long value) {
        this.total = value;
    }

}
