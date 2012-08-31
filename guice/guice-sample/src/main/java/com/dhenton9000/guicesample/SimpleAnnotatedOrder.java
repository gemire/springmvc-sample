/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;

import com.google.inject.Inject;

/**
 *
 * @author dhenton
 */
public class SimpleAnnotatedOrder {
    
    
    // PaymentMethod is an interface with an ImplementedBy annotation
    @Inject
    private PaymentMethod method;
    private String orderNum = null;
    private int amount = 0;
    
    public String reportOrderPayment()
    {
        String info = "For order number "+getOrderNum()+", "+ getMethod().pay(getAmount());
        return info;
    }

    /**
     * @return the method
     */
    public PaymentMethod getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    /**
     * @return the orderNum
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum the orderNum to set
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
