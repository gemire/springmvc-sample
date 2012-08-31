package com.dhenton9000.hibernatetest.generated;

import java.util.HashSet;
import java.util.Set;


/**
 * Item entity. @author eclipse Persistence Tools
 */

public class Item  implements java.io.Serializable {


    // Fields    

     private long itemId;
     private String description;
     private Set bids = new HashSet(0);


    // Constructors

    /** default constructor */
    public Item() {
    }

    
    /** full constructor */
    public Item(String description, Set bids) {
        this.description = description;
        this.bids = bids;
    }

   
    // Property accessors

    public long getItemId() {
        return this.itemId;
    }
    
    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Set getBids() {
        return this.bids;
    }
    
    public void setBids(Set bids) {
        this.bids = bids;
    }
   



    public void addBid(Bid b)
    {
    	bids.add(b);
    	b.setItem(this);
    }




}