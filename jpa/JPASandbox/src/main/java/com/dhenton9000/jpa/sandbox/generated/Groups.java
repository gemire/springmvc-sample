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
@Table(name = "GROUPS", catalog = "", schema = "security")
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", fetch = FetchType.LAZY)
    private List<ApplicationGroups> applicationGroupsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", fetch = FetchType.LAZY)
    private List<GroupAssignments> groupAssignmentsList;

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

    @XmlTransient
    public List<ApplicationGroups> getApplicationGroupsList() {
        return applicationGroupsList;
    }

    public void setApplicationGroupsList(List<ApplicationGroups> applicationGroupsList) {
        this.applicationGroupsList = applicationGroupsList;
    }

    @XmlTransient
    public List<GroupAssignments> getGroupAssignmentsList() {
        return groupAssignmentsList;
    }

    public void setGroupAssignmentsList(List<GroupAssignments> groupAssignmentsList) {
        this.groupAssignmentsList = groupAssignmentsList;
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
        if (!(object instanceof Groups)) {
            return false;
        }
        Groups other = (Groups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.sandbox.generated.Groups[ id=" + id + " ]";
    }
    
}
