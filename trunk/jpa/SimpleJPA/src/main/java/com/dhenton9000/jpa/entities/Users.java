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
@Table(name = "USERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid"),
    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERID", nullable = false, length = 20)
    private String userid;
    @Column(name = "USERNAME", length = 20)
    private String username;
        
    @ManyToMany(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE
    },fetch=FetchType.LAZY)
    @JoinTable(name = "GROUP_ASSIGNMENTS", catalog = "sec", joinColumns = {
        @JoinColumn(name = "user_id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "group_id")
    })
     

    private Set<Groups> groupsSet;

    public Users() {
    }

    public Users(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.username != null ? this.username.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "com.dhenton9000.jpa.generated.Users[ userid=" + userid + " ]";
    }

    /**
     * @return the groupsSet
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
