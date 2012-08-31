/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.ibatis.dao;

import com.dhenton9000.ibatis.vo.Customers;
import java.util.List;

/**
 *
 * @author Don
 */
public interface ICustomerDAO {

    List<Customers> getCustomersByZip(String postalCode);
    List<Customers> getAllCustomers();
}
