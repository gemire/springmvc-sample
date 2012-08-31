package com.dhenton9000.hibernatetest.generated;



/**
 * Bid entity. @author eclipse Persistence Tools
 */

public class Bid  implements java.io.Serializable {


    // Fields    

     private long bidId;
     private Item item;


    // Constructors

    /** default constructor */
    public Bid() {
    }

    
    /** full constructor */
    public Bid(Item item) {
        this.item = item;
    }

   
    // Property accessors

    public long getBidId() {
        return this.bidId;
    }
    
    public void setBidId(long bidId) {
        this.bidId = bidId;
    }

    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item item) {
        this.item = item;
    }
   








}