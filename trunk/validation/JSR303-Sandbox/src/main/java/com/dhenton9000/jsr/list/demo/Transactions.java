/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jsr.list.demo;

 
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author dhenton
 */
public class Transactions {
    
    private String payee = null;
    private Float amount = 0.0f;

    public Transactions(String name, Float f) {
        payee = name;
        amount = f;
    }
    
    public Transactions(){}

    /**
     * @return the payee
     */
    @NotNull
    @Size(max=50, min=5)
    public String getPayee() {
        return payee;
    }

    /**
     * @param payee the payee to set
     */
    public void setPayee(String payee) {
        this.payee = payee;
    }

    /**
     * @return the amount
     */
    @NotNull
    public Float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }
    
}
