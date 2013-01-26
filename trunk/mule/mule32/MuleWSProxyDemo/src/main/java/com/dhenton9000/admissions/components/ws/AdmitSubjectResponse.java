
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
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}Episode"/>
 *           &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}Bill"/>
 *           &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}InsuranceCaseNumber"/>
 *         &lt;/sequence>
 *         &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}InsuranceCoverStatus"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "episode",
    "bill",
    "insuranceCaseNumber",
    "insuranceCoverStatus"
})
@XmlRootElement(name = "admitSubjectResponse")
public class AdmitSubjectResponse {

    @XmlElement(name = "Episode", namespace = "http://www.mule-health.com/SOA/model/1.0")
    protected EpisodeType episode;
    @XmlElement(name = "Bill", namespace = "http://www.mule-health.com/SOA/model/1.0")
    protected BillType bill;
    @XmlElement(name = "InsuranceCaseNumber", namespace = "http://www.mule-health.com/SOA/model/1.0")
    protected String insuranceCaseNumber;
    @XmlElement(name = "InsuranceCoverStatus", namespace = "http://www.mule-health.com/SOA/model/1.0")
    protected String insuranceCoverStatus;

    /**
     * Gets the value of the episode property.
     * 
     * @return
     *     possible object is
     *     {@link EpisodeType }
     *     
     */
    public EpisodeType getEpisode() {
        return episode;
    }

    /**
     * Sets the value of the episode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EpisodeType }
     *     
     */
    public void setEpisode(EpisodeType value) {
        this.episode = value;
    }

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

    /**
     * Gets the value of the insuranceCaseNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceCaseNumber() {
        return insuranceCaseNumber;
    }

    /**
     * Sets the value of the insuranceCaseNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceCaseNumber(String value) {
        this.insuranceCaseNumber = value;
    }

    /**
     * Gets the value of the insuranceCoverStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceCoverStatus() {
        return insuranceCoverStatus;
    }

    /**
     * Sets the value of the insuranceCoverStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceCoverStatus(String value) {
        this.insuranceCoverStatus = value;
    }

}
