/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.krams.domain;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 *
 * @author Don
 */
@Document
public class LineItems {
    private int amount =0;
    private String itemName = null;

    public LineItems()
    {
        
    }
    public LineItems(int amt, String name)
    {
        this.amount = amt;
        this.itemName = name;
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

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
}
