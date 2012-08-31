package com.dhenton9000.hibernatetest.generated;



/**
 * AbstractBillingDetails entity provides the base persistence definition of the BillingDetails entity. @author eclipse Persistence Tools
 */

public abstract class AbstractBillingDetails  implements java.io.Serializable {


    // Fields    

     private long billingDetailsId;
     private String name;


    // Constructors

    /** default constructor */
    public AbstractBillingDetails() {
    }

    
    /** full constructor */
    public AbstractBillingDetails(String name) {
        this.name = name;
    }

   
    // Property accessors

    public long getBillingDetailsId() {
        return this.billingDetailsId;
    }
    
    public void setBillingDetailsId(long billingDetailsId) {
        this.billingDetailsId = billingDetailsId;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}