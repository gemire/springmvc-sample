/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dhenton9000.csvfeed.customerfeed;

import com.dhenton9000.feeds.IFeedItemGenerator;
import com.dhenton9000.feeds.ItemGeneratorException;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 *
 * @author Don
 */
public class GeneralCustomerFeedGenerator extends SqlMapClientDaoSupport implements IFeedItemGenerator {
    private static Logger log = LogManager.getLogger(GeneralCustomerFeedGenerator.class);
    

    public List getItems() throws ItemGeneratorException {
       List  tList =
                getSqlMapClientTemplate().queryForList("getAllCustomers");

       return tList;
    }


	public String getDescription() {
		 
		return "CustomerFeed";
	}

 
  

    

}
