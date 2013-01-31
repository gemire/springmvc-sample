/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.inheritance;

import com.dhenton9000.jpa.domain.Identifiable;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author dhenton
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE", discriminatorType = DiscriminatorType.INTEGER)
public class Person implements Serializable, Identifiable<Integer> {

    private static final long serialVersionUID = -2175150694352541150L;
    private Integer id = null;
    private String firstName = null;
    private String lastName = null;
    private Set<PersonAddress> PersonAddresses = null;
    private Date created = null;

    /**
     * Gets id (primary key).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    /**
     * Sets id (primary key).
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets list of
     * <code>PersonAddress</code>es.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    public Set<PersonAddress> getPersonAddresses() {
        return PersonAddresses;
    }

    /**
     * Sets list of
     * <code>PersonAddress</code>es.
     */
    public void setPersonAddresses(Set<PersonAddress> PersonAddresses) {
        this.PersonAddresses = PersonAddresses;
    }

    /**
     * Gets date created.
     */
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreated() {
        return created;
    }

    /**
     * Sets date created.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    public PersonAddress findPersonAddressById(Integer id) {
        PersonAddress result = null;

        if (PersonAddresses != null) {
            for (PersonAddress PersonAddress : PersonAddresses) {
                if (PersonAddress.getId().equals(id)) {
                    result = PersonAddress;

                    break;
                }
            }
        }

        return result;
    }

    @Override
    public Integer getPrimaryKey() {
        return getId();
    }

    @Override
    public void setPrimaryKey(Integer id) {
        
            setId((Integer) id);
        
    }

    @Override
    public boolean isPrimaryKeySet() {
        return id != null;
    }
}
