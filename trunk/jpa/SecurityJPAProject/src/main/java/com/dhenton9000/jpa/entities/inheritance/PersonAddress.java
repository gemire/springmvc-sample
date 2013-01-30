/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.inheritance;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "PERSON_ADDRESS")
@NamedQueries({
    @NamedQuery(name = "PersonAddress.findAll", query = "SELECT p FROM PersonAddress p")})
public class PersonAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @Column(name = "ZIP_POSTAL")
    private String zipPostal;
    @Basic(optional = false)
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    @ManyToOne
    private Person personId;

    public PersonAddress() {
    }

    public PersonAddress(Integer id) {
        this.id = id;
    }

    public PersonAddress(Integer id, String city, String zipPostal, String country) {
        this.id = id;
        this.city = city;
        this.zipPostal = zipPostal;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipPostal() {
        return zipPostal;
    }

    public void setZipPostal(String zipPostal) {
        this.zipPostal = zipPostal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonAddress)) {
            return false;
        }
        PersonAddress other = (PersonAddress) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.entities.generated.PersonAddress[ id=" + id + " ]";
    }
    
}
