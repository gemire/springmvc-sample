
package com.dhenton9000.registration.bindings;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
 *         &lt;element name="paymentPlan" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="months" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
    "paymentPlan",
    "months"
})
@XmlRootElement(name = "registrationDetails")
public class RegistrationDetails {

    @XmlElement(required = true)
    protected String paymentPlan;
    @XmlElement(required = true)
    protected BigInteger months;
   

    /**
     * Gets the value of the paymentPlan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentPlan() {
        return paymentPlan;
    }

    /**
     * Sets the value of the paymentPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPlan(String value) {
        this.paymentPlan = value;
    }

    /**
     * Gets the value of the months property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMonths() {
        return months;
    }

    /**
     * Sets the value of the months property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMonths(BigInteger value) {
        this.months = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistrationDetails other = (RegistrationDetails) obj;
        if ((this.paymentPlan == null) ? (other.paymentPlan != null) : !this.paymentPlan.equals(other.paymentPlan)) {
            return false;
        }
        if (this.months != other.months && (this.months == null || !this.months.equals(other.months))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.paymentPlan != null ? this.paymentPlan.hashCode() : 0);
        hash = 67 * hash + (this.months != null ? this.months.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "RegistrationDetails{" + "paymentPlan=" + paymentPlan + ", months=" + months + '}';
    }

	

}
