
package com.dhenton9000.admissions.components.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for procedureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="procedureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.mule-health.com/SOA/model/1.0}procedureCodeType"/>
 *         &lt;element name="admission" type="{http://www.mule-health.com/SOA/model/1.0}admissionType"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "procedureType", namespace = "http://www.mule-health.com/SOA/model/1.0", propOrder = {
    "code",
    "admission",
    "department"
})
public class ProcedureType {

    @XmlElement(required = true)
    protected ProcedureCodeType code;
    @XmlElement(required = true)
    protected AdmissionType admission;
    @XmlElement(required = true)
    protected String department;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureCodeType }
     *     
     */
    public ProcedureCodeType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureCodeType }
     *     
     */
    public void setCode(ProcedureCodeType value) {
        this.code = value;
    }

    /**
     * Gets the value of the admission property.
     * 
     * @return
     *     possible object is
     *     {@link AdmissionType }
     *     
     */
    public AdmissionType getAdmission() {
        return admission;
    }

    /**
     * Sets the value of the admission property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdmissionType }
     *     
     */
    public void setAdmission(AdmissionType value) {
        this.admission = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartment(String value) {
        this.department = value;
    }

}
