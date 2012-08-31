/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ersatzdb.demo.dao;

import com.dhenton9000.ersatzdb.generators.CustomerGenerator;
import com.dhenton9000.ersatzdb.vo.Customers;
import java.util.List;

/**
 * This class is a demonstration of using the generators to create a mock
 * DAO implementation
 */
public class CustomerDAOImpl implements CustomerDAO {

    private CustomerGenerator customerGenerator = null;
      
    @Override
    public List<Customers> findAll() {
       return
        (List<Customers>) 
               customerGenerator.getItemCollection().get("allCustomers");
    }

    @Override
    public Customers getCustomerById(int id) {
        
        Customers retCustomer = null;
        List<Customers> cList = (List<Customers>)
                 customerGenerator.getItemCollection().get("badCustomers");
        if (id == 256)
        {
            retCustomer = cList.get(1);
        }
        else
        {
            cList = (List<Customers>)
            customerGenerator.getItemCollection().get("allCustomers");
            retCustomer = cList.get(0);
            retCustomer.setCustomerNumber(id);
        }
            
        
        
        return retCustomer;
        
    }

    /**
     * @return the customerGenerator
     */
    public CustomerGenerator getCustomerGenerator() {
        return customerGenerator;
    }

    /**
     * @param customerGenerator the customerGenerator to set
     */
    public void setCustomerGenerator(CustomerGenerator customerGenerator) {
        this.customerGenerator = customerGenerator;
    }
    
}
