
package com.dhenton9000.cxf.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The actual parameters of the web call
 * 
 * <p>Java class for InventoryRequestParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InventoryRequestParametersType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RoutingInformation" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}RoutingRequestType"/>
 *         &lt;element name="Style" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}StyleIdentifierType"/>
 *         &lt;element name="ServiceRequests" type="{http://dhenton9000.inventory/schema/InventoryBusSchema}ServiceRequestsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InventoryRequestParametersType", propOrder = {
    "routingInformation",
    "style",
    "serviceRequests"
})
public class InventoryRequestParametersType {

    @XmlElement(name = "RoutingInformation", required = true)
    protected RoutingRequestType routingInformation;
    @XmlElement(name = "Style", required = true)
    protected String style;
    @XmlElement(name = "ServiceRequests")
    protected ServiceRequestsType serviceRequests;

    /**
     * Gets the value of the routingInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RoutingRequestType }
     *     
     */
    public RoutingRequestType getRoutingInformation() {
        return routingInformation;
    }

    /**
     * Sets the value of the routingInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoutingRequestType }
     *     
     */
    public void setRoutingInformation(RoutingRequestType value) {
        this.routingInformation = value;
    }

    /**
     * Gets the value of the style property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
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

}
