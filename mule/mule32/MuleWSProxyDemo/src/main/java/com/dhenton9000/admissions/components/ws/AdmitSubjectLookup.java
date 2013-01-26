
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
 *         &lt;element ref="{http://www.mule-health.com/SOA/message/1.0}admitSubject"/>
 *         &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}Lookup"/>
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
    "admitSubject",
    "lookup"
})
@XmlRootElement(name = "admitSubjectLookup")
public class AdmitSubjectLookup {

    @XmlElement(namespace = "http://www.mule-health.com/SOA/message/1.0", required = true)
    protected AdmitSubject admitSubject;
    @XmlElement(name = "Lookup", namespace = "http://www.mule-health.com/SOA/model/1.0", required = true)
    protected String lookup;

    /**
     * Gets the value of the admitSubject property.
     * 
     * @return
     *     possible object is
     *     {@link AdmitSubject }
     *     
     */
    public AdmitSubject getAdmitSubject() {
        return admitSubject;
    }

    /**
     * Sets the value of the admitSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdmitSubject }
     *     
     */
    public void setAdmitSubject(AdmitSubject value) {
        this.admitSubject = value;
    }

    /**
     * Gets the value of the lookup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookup() {
        return lookup;
    }

    /**
     * Sets the value of the lookup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookup(String value) {
        this.lookup = value;
    }

}
