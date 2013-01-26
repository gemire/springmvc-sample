
package com.dhenton9000.admissions.components.ws.billing;

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
 *         &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}Subject"/>
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
    "subject"
})
@XmlRootElement(name = "upsertPatient")
public class UpsertPatient {

    @XmlElement(name = "Subject", namespace = "http://www.mule-health.com/SOA/model/1.0", required = true)
    protected DemographicType subject;

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link DemographicType }
     *     
     */
    public DemographicType getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link DemographicType }
     *     
     */
    public void setSubject(DemographicType value) {
        this.subject = value;
    }

}
