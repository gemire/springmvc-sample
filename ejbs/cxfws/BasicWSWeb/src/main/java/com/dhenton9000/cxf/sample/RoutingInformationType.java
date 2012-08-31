
package com.dhenton9000.cxf.sample;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoutingInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RoutingInformationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ProcessId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ServiceRequests" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ServiceRequestsType"/>
 *         &lt;element name="BatchInformation" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}BatchInformationType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoutingInformationType", propOrder = {
    "sourceId",
    "processId",
    "serviceRequests",
    "batchInformation"
})
public class RoutingInformationType {

    @XmlElement(name = "SourceId", required = true)
    protected BigInteger sourceId;
    @XmlElement(name = "ProcessId", required = true)
    protected BigInteger processId;
    @XmlElement(name = "ServiceRequests", required = true)
    protected ServiceRequestsType serviceRequests;
    @XmlElement(name = "BatchInformation")
    protected BatchInformationType batchInformation;

    /**
     * Gets the value of the sourceId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSourceId() {
        return sourceId;
    }

    /**
     * Sets the value of the sourceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSourceId(BigInteger value) {
        this.sourceId = value;
    }

    /**
     * Gets the value of the processId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProcessId(BigInteger value) {
        this.processId = value;
    }

    /**
     * Gets the value of the serviceRequests property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceRequestsType }
     *     
     */
    public ServiceRequestsType getServiceRequests() {
        return serviceRequests;
    }

    /**
     * Sets the value of the serviceRequests property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceRequestsType }
     *     
     */
    public void setServiceRequests(ServiceRequestsType value) {
        this.serviceRequests = value;
    }

    /**
     * Gets the value of the batchInformation property.
     * 
     * @return
     *     possible object is
     *     {@link BatchInformationType }
     *     
     */
    public BatchInformationType getBatchInformation() {
        return batchInformation;
    }

    /**
     * Sets the value of the batchInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BatchInformationType }
     *     
     */
    public void setBatchInformation(BatchInformationType value) {
        this.batchInformation = value;
    }

}
