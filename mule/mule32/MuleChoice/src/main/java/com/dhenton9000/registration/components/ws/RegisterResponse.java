
package com.dhenton9000.registration.components.ws;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element name="responseInformation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="currentTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="totalCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="paymentDepartment" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "responseInformation",
    "currentTime",
    "totalCost",
    "paymentDepartment"
})
@XmlRootElement(name = "RegisterResponse")
public class RegisterResponse {

    @XmlElement(required = true)
    protected String responseInformation;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar currentTime;
    @XmlElement(required = true)
    protected BigDecimal totalCost;
    @XmlElement(required = true)
    protected String paymentDepartment;

    /**
     * Gets the value of the responseInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseInformation() {
        return responseInformation;
    }

    /**
     * Sets the value of the responseInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseInformation(String value) {
        this.responseInformation = value;
    }

    /**
     * Gets the value of the currentTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getCurrentTime() {
        return currentTime;
    }

    /**
     * Sets the value of the currentTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentTime(Calendar value) {
        this.currentTime = value;
    }

    /**
     * Gets the value of the totalCost property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCost() {
        return totalCost;
    }

    /**
     * Sets the value of the totalCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCost(BigDecimal value) {
        this.totalCost = value;
    }

    /**
     * Gets the value of the paymentDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDepartment() {
        return paymentDepartment;
    }

    /**
     * Sets the value of the paymentDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDepartment(String value) {
        this.paymentDepartment = value;
    }

}
