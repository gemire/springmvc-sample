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
@Table(name = "APPLICATION_GROUPS", catalog = "", schema = "security")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ApplicationGroups.findAll", query = "SELECT a FROM ApplicationGroups a"),
    @NamedQuery(name = "ApplicationGroups.findById", query = "SELECT a FROM ApplicationGroups a WHERE a.id = :id")})
public class ApplicationGroups implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groups groupId;
    @JoinColumn(name = "APPLICATION_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Applications applicationId;

    public ApplicationGroups() {
    }

    public ApplicationGroups(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public Applications getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Applications applicationId) {
        this.applicationId = applicationId;
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
        if (!(object instanceof ApplicationGroups)) {
            return false;
        }
        ApplicationGroups other = (ApplicationGroups) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.jpa.sandbox.generated.ApplicationGroups[ id=" + id + " ]";
    }
    
}
