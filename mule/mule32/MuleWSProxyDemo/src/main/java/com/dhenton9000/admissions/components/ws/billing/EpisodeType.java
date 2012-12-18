
package com.dhenton9000.admissions.components.ws.billing;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for episodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="episodeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="episodeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}PatientId"/>
 *         &lt;element name="admission" type="{http://www.mule-health.com/SOA/model/1.0}admissionType"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="care" type="{http://www.mule-health.com/SOA/model/1.0}careType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "episodeType", namespace = "http://www.mule-health.com/SOA/model/1.0", propOrder = {
    "episodeId",
    "patientId",
    "admission",
    "startDate",
    "endDate",
    "care"
})
public class EpisodeType {

    @XmlElement(required = true)
    protected String episodeId;
    @XmlElement(name = "PatientId", namespace = "http://www.mule-health.com/SOA/model/1.0", required = true)
    protected String patientId;
    @XmlElement(required = true)
    protected AdmissionType admission;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Calendar startDate;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected Calendar endDate;
    @XmlElement(required = true)
    protected CareType care;

    /**
     * Gets the value of the episodeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpisodeId() {
        return episodeId;
    }

    /**
     * Sets the value of the episodeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpisodeId(String value) {
        this.episodeId = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPatientId(String value) {
        this.patientId = value;
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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(Calendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(Calendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the care property.
     * 
     * @return
     *     possible object is
     *     {@link CareType }
     *     
     */
    public CareType getCare() {
        return care;
    }

    /**
     * Sets the value of the care property.
     * 
     * @param value
     *     allowed object is
     *     {@link CareType }
     *     
     */
    public void setCare(CareType value) {
        this.care = value;
    }

}
