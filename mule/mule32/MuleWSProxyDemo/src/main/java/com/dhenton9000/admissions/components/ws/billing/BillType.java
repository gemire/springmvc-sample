
package com.dhenton9000.admissions.components.ws.billing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for billType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="billType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="costPerNight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initialStayEstimate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="runningTotal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pending"/>
 *               &lt;enumeration value="Complete"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "billType", namespace = "http://www.mule-health.com/SOA/model/1.0", propOrder = {
    "costPerNight",
    "initialStayEstimate",
    "runningTotal",
    "status"
})
public class BillType {

    @XmlElement(required = true)
    protected String costPerNight;
    @XmlElement(required = true)
    protected String initialStayEstimate;
    @XmlElement(required = true)
    protected String runningTotal;
    @XmlElement(required = true)
    protected String status;

    /**
     * Gets the value of the costPerNight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCostPerNight() {
        return costPerNight;
    }

    /**
     * Sets the value of the costPerNight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCostPerNight(String value) {
        this.costPerNight = value;
    }

    /**
     * Gets the value of the initialStayEstimate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialStayEstimate() {
        return initialStayEstimate;
    }

    /**
     * Sets the value of the initialStayEstimate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialStayEstimate(String value) {
        this.initialStayEstimate = value;
    }

    /**
     * Gets the value of the runningTotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRunningTotal() {
        return runningTotal;
    }

    /**
     * Sets the value of the runningTotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRunningTotal(String value) {
        this.runningTotal = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
