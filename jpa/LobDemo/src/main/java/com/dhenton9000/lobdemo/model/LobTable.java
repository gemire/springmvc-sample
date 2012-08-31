/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.lobdemo.model;

import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "lob_table", catalog = "test", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LobTable.findAll", query = "SELECT l FROM LobTable l"),
    @NamedQuery(name = "LobTable.findById", query = "SELECT l FROM LobTable l WHERE l.id = :id"),
    @NamedQuery(name = "LobTable.findByDescription", query = "SELECT l FROM LobTable l WHERE l.description = :description")})
public class LobTable implements Identifiable<Integer>, Serializable {

    private static final long serialVersionUID = 1L;
        private Integer id = null;
        private String description;
        private String lobItem;

    public LobTable() {
    }

    public LobTable(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "description", length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
    @Column(name = "lob_item", length = 2147483647)
    public String getLobItem() {
        return lobItem;
    }

    public void setLobItem(String lobItem) {
        this.lobItem = lobItem;
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
        if (!(object instanceof LobTable)) {
            return false;
        }
        LobTable other = (LobTable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dhenton9000.lobdemo.model.LobTable[ id=" + id + "," + description + " ]";
    }

    @Transient
    @XmlTransient
    @Override
    public Integer getPrimaryKey() {
        return this.getId();
    }

    @Override
    public void setPrimaryKey(Integer id) {
        setId(id);
    }

    @Transient
    private boolean isUserIdSet() {
        return id != null;
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return isUserIdSet();
    }
}
