package com.dhenton9000.jdbc.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.mule.api.transaction.Transaction;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

public class ErrorThrowingComponent implements Callable {

    private static Logger log = LogManager.getLogger(ErrorThrowingComponent.class);
    public static final String TARGET_TABLE_ID_COL = "TARGET_TABLE_ID";
    public static final String POLL_TABLE_ID_COL = "POLL_TABLE_ID";

    public ErrorThrowingComponent() {
        log.debug("creating test component");
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        Transaction tx = eventContext.getCurrentTransaction();
        if (tx != null) {
            log.debug("current tx " + tx.getClass().getName());
        } else {
            log.debug("current tx is null");
        }

        Object t = eventContext.getMuleContext().getTransactionManager();

        Object o = eventContext.getMessage().getPayload();
        Map<String, Integer> dataMap = (Map<String, Integer>) o;
        // the iterator is for the columns from the query
        // this method will be called for each matching row

        Integer tableId = dataMap.get(TARGET_TABLE_ID_COL);
        Integer pollId = dataMap.get(POLL_TABLE_ID_COL);
        log.debug("poll id : '" + pollId + "' table id '" + tableId + "' ");

        log.debug("now begin processing");
       // throw new RuntimeException("get a job");
        
        return eventContext.getMessage();
    
    }
}
