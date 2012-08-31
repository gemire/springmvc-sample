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
@Table(name = "GROUPS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groups.findAll", query = "SELECT g FROM Groups g"),
    @NamedQuery(name = "Groups.findById", query = "SELECT g FROM Groups g WHERE g.id = :id"),
    @NamedQuery(name = "Groups.findByGroupName", query = "SELECT g FROM Groups g WHERE g.groupName = :groupName")})
public class Groups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "GROUP_NAME", length = 120)
    private String groupName;
     @ManyToMany(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE
    },fetch=FetchType.LAZY)
    @JoinTable(name = "GROUP_ASSIGNMENTS", catalog = "sec", joinColumns = {
        @JoinColumn(name = "group_id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "user_id")
    })
    private Set<Users> usersSet;
    @ManyToMany(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE
    },fetch=FetchType.LAZY)
    @JoinTable(name = "APPLICATION_GROUPS", catalog = "sec", joinColumns = {
        @JoinColumn(name = "group_id" )
    }, inverseJoinColumns = {
        @JoinColumn(name = "application_id")
    })
    private Set<Applications> applicationsSet;
     
     
    public Groups() {
    }

    public Groups(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Groups other = (Groups) obj;
        if ((this.groupName == null) ? (other.groupName != null) : !this.groupName.equals(other.groupName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.groupName != null ? this.groupName.hashCode() : 0);
        return hash;
    }

     

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.generated.Groups[ id=" + id + " ]";
    }

    /**
     * @return the usersSet
     */
    @XmlTransient
    public Set<Users> getUsersSet() {
        return usersSet;
    }

    /**
     * @param usersSet the usersSet to set
     */
    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    /**
     * @return the applicationsSet
     */
    @XmlTransient
    public Set<Applications> getApplicationsSet() {
        return applicationsSet;
    }

    /**
     * @param applicationsSet the applicationsSet to set
     */
    public void setApplicationsSet(Set<Applications> applicationsSet) {
        this.applicationsSet = applicationsSet;
    }
    
}
