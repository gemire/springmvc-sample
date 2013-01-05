/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities;

import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "WINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wine.findAll", query = "SELECT u FROM Wine u"),
    @NamedQuery(name = "Wine.findByid", query = "SELECT u FROM Wine u WHERE u.id = :id"),
    @NamedQuery(name = "Wine.findByName", query = "SELECT u FROM Wine u WHERE u.name = :name")})
public class Wine implements Identifiable<Integer>, Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
        private String name;
        private Integer wineYear;
        private String grapes;
        private String country;
        private String region;
        private String description;
        private String picture;

    public Wine() {
    }

    public Wine(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Wine other = (Wine) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.generated.Wine[ id=" + id + " ]";
    }

    @Override
    @Transient
    @XmlTransient
    public Integer getPrimaryKey() {
        return this.getId();
    }

    @Override
    public void setPrimaryKey(Integer id) {
        this.setId(id);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return id != null;
    }

    /**
     * @return the wineYear
     */
    @Column(name = "WINE_YEAR")
    public Integer getWineYear() {
        return wineYear;
    }

    /**
     * @param wineYear the wineYear to set
     */
    public void setWineYear(Integer wineYear) {
        this.wineYear = wineYear;
    }

    /**
     * @return the grapes
     */
    @Column(name = "GRAPES", length = 45)
    public String getGrapes() {
        return grapes;
    }

    /**
     * @param grapes the grapes to set
     */
    public void setGrapes(String grapes) {
        this.grapes = grapes;
    }

    /**
     * @return the country
     */
    @Column(name = "COUNTRY", length = 45)
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the region
     */
    @Column(name = "REGION", length = 45)
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the description
     */
    @Column(name = "DESCRIPTION", length = 45)
    @Lob
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the picture
     */
    @Column(name = "PICTURE", length = 250)
    public String getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
}
