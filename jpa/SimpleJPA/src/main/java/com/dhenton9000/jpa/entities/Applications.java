/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "APPLICATIONS")
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
    @ManyToMany(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE
    },fetch=FetchType.LAZY)
   @JoinTable(name = "APPLICATION_GROUPS", catalog = "sec", joinColumns = {
        @JoinColumn(name = "application_id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "group_id")
    })
    private Set<Groups> groupsSet;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Applications other = (Applications) obj;
        if ((this.applicationName == null) ? (other.applicationName != null) : !this.applicationName.equals(other.applicationName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (this.applicationName != null ? this.applicationName.hashCode() : 0);
        return hash;
    }

 
    @Override
    public String toString() {
        return "com.dhenton9000.jpa.generated.Applications[ id=" + id + " ]";
    }

    /**
     * @return the groupsSet this has to be a set to allow for hydrating
     * the full set
     */
    @XmlTransient
    public Set<Groups> getGroupsSet() {
        return groupsSet;
    }

  

    /**
     * @param groupsSet the groupsSet to set
     */
    public void setGroupsSet(Set<Groups> groupsSet) {
        this.groupsSet = groupsSet;
    }
    
}
