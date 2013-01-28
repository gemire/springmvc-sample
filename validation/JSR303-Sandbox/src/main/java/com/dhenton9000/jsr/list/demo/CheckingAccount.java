/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jsr.list.demo;

import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;
/**
 *
 * @author dhenton
 */
public class CheckingAccount {
    
    private String name = null;
    private ArrayList<Transactions> transactions = new ArrayList<Transactions>();
    
    /**
     * @return the name
     */
    @NotNull
    @Size(max=50, min=5)
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
     * @return the transactions
     */
    @Valid
    @NotNull
    @Size(min=1)
    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }
    
    
    
    
    
}
