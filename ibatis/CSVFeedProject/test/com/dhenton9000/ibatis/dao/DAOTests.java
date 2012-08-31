/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.ibatis.dao;

import com.dhenton9000.ibatis.vo.Customers;
import java.util.List;
import junit.framework.TestCase;




/**
 *
 * @author Don
 */
public class DAOTests extends TestCase {

   
    public void testGetCustomersByZip()
    {
        List<Customers> customers =
        GeneralDaoFactory.getCustomerFeedDAO().getCustomersByZip("94217");
        assertEquals(5,customers.size());
        Customers k = customers.get(0);
        assertEquals("USA",k.getCountry());
    }
 public void testGetAllCustomers()
    {
        List<Customers> customers =
        GeneralDaoFactory.getCustomerFeedDAO().getAllCustomers();
        assertEquals(122,customers.size());
        Customers k = customers.get(7);
        assertEquals("Germany",k.getCountry());
    }
}
