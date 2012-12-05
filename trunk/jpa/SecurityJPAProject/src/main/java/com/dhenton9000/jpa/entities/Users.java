/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities;

import com.dhenton9000.jpa.domain.Identifiable;
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
//public class Users implements Identifiable<String>, Serializable  {
public class Users implements Identifiable<String>, Serializable  {
    private static final long serialVersionUID = 1L;
    
     
        private String userid;
        private String username;
        private Set<Groups> groupsSet;

    public Users() {
    }

    public Users(String userid) {
        this.userid = userid;
    }

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "USERID",   nullable = false, unique = true, length = 20)
        public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Column(name = "USERNAME", length = 20)
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
    @ManyToMany(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE
    },fetch=FetchType.LAZY)
    @JoinTable(name = "GROUP_ASSIGNMENTS", catalog = "sec", joinColumns = {
        @JoinColumn(name = "user_id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "group_id")
    })
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
    @Transient
    @Override
    public String getPrimaryKey() {
        return this.getUserid();
    }

    @Override
    public void setPrimaryKey(String id) {
        this.setUserid(id);
        
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return isUserIdSet();
    }
    
    @Transient
    public boolean isUserIdSet() {
        return userid != null && !userid.isEmpty();
    }

    
    
}
