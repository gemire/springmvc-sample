/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jpa.entities.inheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dhenton
 */
@Entity
@Table(name = "PERSON_PROFESSIONAL")
@DiscriminatorValue("2")
@NamedQueries({
  @NamedQuery(name = "Professional.findAll", query = "SELECT p FROM Professional p")})
public class Professional extends Person {

    private static final long serialVersionUID = 8199967229715812072L;
    private String companyName = null;

    /**
     * Gets company name.
     */
    @Column(name = "COMPANY_NAME", length = 50)
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets company name.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}