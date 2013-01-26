
package com.dhenton9000.admissions.components.ws.billing;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for referralType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="referralType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence>
 *           &lt;element name="procedure" type="{http://www.mule-health.com/SOA/model/1.0}procedureType"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "referralType", namespace = "http://www.mule-health.com/SOA/model/1.0", propOrder = {
    "procedure"
})
public class ReferralType {

    @XmlElement(required = true)
    protected ProcedureType procedure;

    /**
     * Gets the value of the procedure property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureType }
     *     
     */
    public ProcedureType getProcedure() {
        return procedure;
    }

    /**
     * Sets the value of the procedure property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureType }
     *     
     */
    public void setProcedure(ProcedureType value) {
        this.procedure = value;
    }

}
