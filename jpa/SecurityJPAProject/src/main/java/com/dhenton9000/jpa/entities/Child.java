/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities;

import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "CHILD")
@XmlRootElement
public class Child implements Identifiable<Integer>, Serializable {

    private Integer id;
    private String name;
    private Parent parent;

    @Override
     @Transient
    @XmlTransient
    public Integer getPrimaryKey() {
        return getId();
    }

    @Override
    public void setPrimaryKey(Integer id) {
        this.setId(id);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        if (this.getId() == null) {
            return false;
        } else {
            return true;
        }
    }

     
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "child_id_seq")
    @SequenceGenerator(name = "child_id_seq", sequenceName = "child_id_seq", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name = "CHILD_NAME", length = 50)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the parent
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARENT_ID", referencedColumnName = "ID", nullable = false, 
            insertable = false, updatable = false)

    public Parent getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Parent parent) {
        this.parent = parent;
    }

}
