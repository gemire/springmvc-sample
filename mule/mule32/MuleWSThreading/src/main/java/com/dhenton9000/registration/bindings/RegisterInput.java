
package com.dhenton9000.registration.bindings;

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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{uri:dhenton9000:registrationService:ref}registrationDetails"/>
 *         &lt;element name="registrationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
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
    "name",
    "password",
    "registrationDetails",
    "registrationDate"
})
@XmlRootElement(name = "RegisterInput")
public class RegisterInput {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected RegistrationDetails registrationDetails;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "dateTime")
    protected Calendar registrationDate;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the registrationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationDetails }
     *     
     */
    public RegistrationDetails getRegistrationDetails() {
        return registrationDetails;
    }

    /**
     * Sets the value of the registrationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationDetails }
     *     
     */
    public void setRegistrationDetails(RegistrationDetails value) {
        this.registrationDetails = value;
    }

    /**
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrationDate(Calendar value) {
        this.registrationDate = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegisterInput other = (RegisterInput) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.registrationDetails != other.registrationDetails && (this.registrationDetails == null || !this.registrationDetails.equals(other.registrationDetails))) {
            return false;
        }
//        if (this.registrationDate != other.registrationDate && (this.registrationDate == null || this.registrationDate.compareTo(other.registrationDate)!= 0)) {
//            return false;
//        }
       return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 29 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = 29 * hash + (this.registrationDetails != null ? this.registrationDetails.hashCode() : 0);
        hash = 29 * hash + (this.registrationDate != null ? this.registrationDate.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "RegisterInput{" + "name=" + name + ", password=" + password  + ", registrationDate=" + registrationDate + '}';
    }

    
     
    
}
