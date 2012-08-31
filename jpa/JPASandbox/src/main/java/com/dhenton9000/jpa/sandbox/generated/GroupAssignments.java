/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.sandbox.generated;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Don
 */
@Entity
@Table(name = "GROUP_ASSIGNMENTS", catalog = "", schema = "security")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupAssignments.findAll", query = "SELECT g FROM GroupAssignments g"),
    @NamedQuery(name = "GroupAssignments.findById", query = "SELECT g FROM GroupAssignments g WHERE g.id = :id")})
public class GroupAssignments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users userId;
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groups groupId;

    public GroupAssignments() {
    }

    public GroupAssignments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof GroupAssignments)) {
            return false;
        }
        GroupAssignments other = (GroupAssignments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.sandbox.generated.GroupAssignments[ id=" + id + " ]";
    }
    
}
