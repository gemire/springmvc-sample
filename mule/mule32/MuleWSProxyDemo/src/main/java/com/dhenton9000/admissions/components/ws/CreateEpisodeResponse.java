
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
 *         &lt;element ref="{http://www.mule-health.com/SOA/model/1.0}Episode"/>
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
    "episode"
})
@XmlRootElement(name = "createEpisodeResponse")
public class CreateEpisodeResponse {

    @XmlElement(name = "Episode", namespace = "http://www.mule-health.com/SOA/model/1.0", required = true)
    protected EpisodeType episode;

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

}
