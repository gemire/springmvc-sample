
package com.dhenton9000.admissions.components.ws;

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
 *         &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}Bill"/>
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
    "bill"
})
@XmlRootElement(name = "createBillResponse")
public class CreateBillResponse {

    @XmlElement(name = "Bill", namespace = "http://www.mule-health.com/SOA/model/1.0", required = true)
    protected BillType bill;

    /**
     * Gets the value of the bill property.
     * 
     * @return
     *     possible object is
     *     {@link BillType }
     *     
     */
    public BillType getBill() {
        return bill;
    }

    /**
     * Sets the value of the bill property.
     * 
     * @param value
     *     allowed object is
     *     {@link BillType }
     *     
     */
    public void setBill(BillType value) {
        this.bill = value;
    }

}
