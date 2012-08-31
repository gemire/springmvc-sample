/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox.generated;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Don
 */
@Entity
@Table(name = "APPLICATIONS", catalog = "", schema = "security")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Applications.findAll", query = "SELECT a FROM Applications a"),
    @NamedQuery(name = "Applications.findById", query = "SELECT a FROM Applications a WHERE a.id = :id"),
    @NamedQuery(name = "Applications.findByApplicationName", query = "SELECT a FROM Applications a WHERE a.applicationName = :applicationName")})
public class Applications implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "APPLICATION_NAME", length = 120)
    private String applicationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicationId", fetch = FetchType.LAZY)
    private List<ApplicationGroups> applicationGroupsList;

    public Applications() {
    }

    public Applications(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @XmlTransient
    public List<ApplicationGroups> getApplicationGroupsList() {
        return applicationGroupsList;
    }

    public void setApplicationGroupsList(List<ApplicationGroups> applicationGroupsList) {
        this.applicationGroupsList = applicationGroupsList;
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
        if (!(object instanceof Applications)) {
            return false;
        }
        Applications other = (Applications) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.sandbox.generated.Applications[ id=" + id + " ]";
    }
    
}
