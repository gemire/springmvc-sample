/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.guicesample;


import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author dhenton
 */
public abstract class AbstractPayment implements PaymentMethod {

    
    private String baseReply = "I paid %d dollars with ";
   
    /**
     * @return the baseReply
     */
    public String getBaseReply() {
        return baseReply;
    }

    protected String formatMessage(int amount) {
        StringBuilder sb = new StringBuilder();
        String info = getBaseReply() + getMethod();
        // Send all output to the Appendable object sb
        Formatter formatter = new Formatter(sb, Locale.US);
        return formatter.format(info, amount).toString();
    }

    public String pay(int amount) {
        return formatMessage(amount);
    }

    /**
     * @return the method
     */
    public abstract String getMethod();

    /**
     * @param baseReply the baseReply to set
     */
    public void setBaseReply(String baseReply) {
        this.baseReply = baseReply;
    }
}
