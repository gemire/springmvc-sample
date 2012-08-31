/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

/**
 * This component will confirm that the database record got written
 * by looking it up via the DAO. the Payload is the key on the database. It
 * returns the value from the DAO, which will be reported out by the logging
 * component
 * @author Don
 */
public class JdbcMonitorComponent implements Callable{
    private static Logger log = LogManager.getLogger(JdbcComponent.class);
    private XADao xaDAO = null;

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        Object p = eventContext.getMessage().getPayload();
        String payload = (String)  p;
        int retval = xaDAO.getMessage(payload);
        return retval;
    }
    
       /**
     * @return the xaDAO
     */
    public XADao getXaDAO() {
        return xaDAO;
    }

    /**
     * @param xaDAO the xaDAO to set
     */
    public void setXaDAO(XADao xaDAO) {
        this.xaDAO = xaDAO;
    }
}
