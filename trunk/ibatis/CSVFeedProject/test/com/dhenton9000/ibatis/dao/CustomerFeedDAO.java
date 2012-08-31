/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.ibatis.dao;
import com.dhenton9000.ibatis.vo.Customers;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;


/**
 *
 * @author Don
 */
public class CustomerFeedDAO extends SqlMapClientDaoSupport
    implements ICustomerDAO
{
	private static Logger log = LogManager.getLogger(CustomerFeedDAO.class);

    public List<Customers> getCustomersByZip(String postalCode) {


        List<Customers>  custList =
                getSqlMapClientTemplate().queryForList("getCustomersByZip","94217");

        return custList;
    }

    public List<Customers> getAllCustomers() {

      List<Customers>  custList =
                getSqlMapClientTemplate().queryForList("getAllCustomers");

        return custList;

    }



}
