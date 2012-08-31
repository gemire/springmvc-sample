/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dhenton
 */
package com.dhenton9000.jms.transactions;

import com.dhenton9000.jms.components.*;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.log4j.LogManager;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.apache.log4j.*;
import org.mule.api.transaction.Transaction;

public class JmsTransactionsTestComponent implements Callable {

    private static Logger log = LogManager.getLogger(JmsTransactionsTestComponent.class);
    private boolean doCommit = false;

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        String payload = eventContext.getMessage().getPayloadAsString();
        Transaction currentTransaction = eventContext.getCurrentTransaction();
        if (payload == null) {
            payload = "NULL";
        }

        payload = payload.trim().toUpperCase();
        if (payload.indexOf("BOZO1") > -1) {
            throw new RuntimeException("you cannot be a BOZO1");
        }

        if (doCommit)
        {
            currentTransaction.commit();
        }
        ArrayList<String> t = new ArrayList<String>();
        t.add(payload);
        t.add("alpha");
        t.add("beta");
        t.add("gamma");
        log.info("got message " + payload);
        return t;
    }

    /**
     * @return the doCommit
     */
    public boolean isDoCommit() {
        return doCommit;
    }

    /**
     * @param doCommit the doCommit to set
     */
    public void setDoCommit(boolean doCommit) {
        this.doCommit = doCommit;
    }
}
