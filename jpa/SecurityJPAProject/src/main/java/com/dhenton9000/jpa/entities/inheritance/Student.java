/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name="PERSON_STUDENT")
@DiscriminatorValue("1")
public class Student extends Person {

    private static final long serialVersionUID = -8933409594928827120L;

    private String schoolName = null;

    /**
     * Gets school name.
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * Sets school name.
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    
}
       