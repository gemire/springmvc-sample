package com.dhenton9000.test;

 
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

/**
This component is the Mule wrapper around the DAO. Testing errors
are thrown there.
*/
public class JdbcComponent  implements Callable {

    private static Logger log = LogManager.getLogger(JdbcComponent.class);
    private XADao xaDAO = null;

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
         Object p = eventContext.getMessage().getPayload();
         String payload = (String)  p;
         xaDAO.insertMessage(payload);
        return payload;
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
