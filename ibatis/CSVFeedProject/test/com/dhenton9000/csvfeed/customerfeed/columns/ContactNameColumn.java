/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.csvfeed.customerfeed.columns;

import com.dhenton9000.csvfeed.FeedColumn;
import com.dhenton9000.ibatis.vo.Customers;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
/**
 *
 * @author Don
 */
public class ContactNameColumn extends FeedColumn {
    private static Logger log = LogManager.getLogger(ContactNameColumn.class);

    @Override
    public String getValue(Object item) {
        Customers cust = null;
        cust = (Customers) item;
        String f = cust.getContactFirstName();
        f = stripSpace(f);
        String el = cust.getContactLastName();
        el = stripSpace(el);
        String res = el + "," + f;

        return res;

    }
}
