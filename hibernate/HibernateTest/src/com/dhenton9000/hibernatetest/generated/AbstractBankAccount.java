package com.dhenton9000.hibernatetest.generated;



/**
 * AbstractBankAccount entity provides the base persistence definition of the BankAccount entity. @author eclipse Persistence Tools
 */

public abstract class AbstractBankAccount extends com.dhenton9000.hibernatetest.generated.BillingDetails implements java.io.Serializable {


    // Fields    

     private String accountNumber;
     private String bankName;
     private String swiftId;


    // Constructors

    /** default constructor */
    public AbstractBankAccount() {
    }

    
    /** full constructor */
    public AbstractBankAccount(String name, String accountNumber, String bankName, String swiftId) {
        super(name);        
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.swiftId = swiftId;
    }

   
    // Property accessors

    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwiftId() {
        return this.swiftId;
    }
    
    public void setSwiftId(String swiftId) {
        this.swiftId = swiftId;
    }
   








}