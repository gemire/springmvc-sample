package com.dhenton9000.test;

 
import com.arjuna.ats.jta.exceptions.RollbackException;
import com.dhenton9000.test.exceptions.commit.CommitException;
import javax.sql.DataSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transaction.Transaction;

public class SimpleTestComponent implements Callable {

    private static Logger log = LogManager.getLogger(SimpleTestComponent.class);
    private DataSource dataSource = null;
    
    public SimpleTestComponent() {
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
        
//        if (getDataSource() == null)
//        {
//            log.debug("data source is null");
//        }
//        else
//        {
//            log.debug("data source is "+dataSource);
//        }
        
        
        
        if (message == null)
            message = "";
        
        if (message.toUpperCase().indexOf("COMMIT")> -1)
        {
            log.debug("throwing commit!!!!");
            throw new CommitException("commit this exception!");
        }
       if (message.toUpperCase().indexOf("ROLLBACK")> -1)
        {
            log.debug("throwing rollback!!!!");
            throw new RollbackException("rollback this exception");
        }
      if (message.toUpperCase().indexOf("GENERAL")> -1)
        {
            log.debug("throwing general!!!!");
            throw new Exception("general exception");
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
