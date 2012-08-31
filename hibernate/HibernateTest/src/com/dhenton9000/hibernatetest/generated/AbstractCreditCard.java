package com.dhenton9000.hibernatetest.generated;



/**
 * AbstractCreditCard entity provides the base persistence definition of the CreditCard entity. @author eclipse Persistence Tools
 */

public abstract class AbstractCreditCard extends com.dhenton9000.hibernatetest.generated.BillingDetails implements java.io.Serializable {


    // Fields    

     private String cardNumber;
     private Integer expMonth;
     private String expYear;


    // Constructors

    /** default constructor */
    public AbstractCreditCard() {
    }

    
    /** full constructor */
    public AbstractCreditCard(String name, String cardNumber, Integer expMonth, String expYear) {
        super(name);        
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

   
    // Property accessors

    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpMonth() {
        return this.expMonth;
    }
    
    public void setExpMonth(Integer expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return this.expYear;
    }
    
    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
   








}