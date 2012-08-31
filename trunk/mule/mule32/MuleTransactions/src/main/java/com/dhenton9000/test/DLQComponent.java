package com.dhenton9000.test;

 
import com.dhenton9000.test.exceptions.commit.CommitException;
import javax.sql.DataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transaction.Transaction;

public class DLQComponent implements Callable {

    private static Logger log = LogManager.getLogger(DLQComponent.class);
    private DataSource dataSource = null;
    
    public DLQComponent() {
        log.debug("creating test component");
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        Object o = eventContext.getMessage().getPayload();
        log.debug("@@@@@@@@@@@@@@@@@@class " + o.getClass().getName());
        String message = eventContext.getMessage().getPayloadAsString();
        log.debug("@@@@@@@@@@@@@@@@@@payload " + message);
        Transaction tx = eventContext.getCurrentTransaction();
        if (tx != null)
            log.debug("current tx "+tx.getClass().getName());
        else
            log.debug("current tx is null");
        
        Object t = eventContext.getMuleContext().getTransactionManager();
        if (t != null)
            log.debug("transaction Manager "+t.getClass().getName());
        else
            log.debug("transaction manager is null");
        
        if (getDataSource() == null)
        {
            log.debug("data source is null");
        }
        else
        {
            log.debug("data source is "+dataSource);
        }
        
        
        
        if (message == null)
            message = "";
        
        if (message.toUpperCase().indexOf("BOZO")> -1)
        {
            log.debug("throwing bozo!!!!");
            throw new CommitException("no bozos!");
        }
        
        
        return eventContext.getMessage();
    }

    /**
     * @return the dataSource
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource the dataSource to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
