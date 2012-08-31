/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.hibernate.join.inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Don
 */
@Entity
@Table(name = "PersonalComputer", catalog = "SANDBOX")
public class PersonalComputer extends NetworkAsset{
 
    
    private String employeeName;
    private int memory;

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the memory
     */
    public int getMemory() {
        return memory;
    }

    /**
     * @param memory the memory to set
     */
    public void setMemory(int memory) {
        this.memory = memory;
    }
    
}
