/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ersatzdb.demo.dao;

import com.dhenton9000.ersatzdb.vo.Customers;
import java.util.List;

/**
 *
 * 
 */
public interface CustomerDAO {
    
    public List<Customers> findAll();
    public Customers getCustomerById(int id);
    
    
    
}
