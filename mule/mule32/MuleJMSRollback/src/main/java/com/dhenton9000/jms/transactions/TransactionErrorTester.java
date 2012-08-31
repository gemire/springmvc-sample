/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.jms.transactions;

import java.util.ArrayList;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transaction.Transaction;
import org.apache.log4j.*;
/**
 *
 * @author dhenton
 */
public class TransactionErrorTester implements Callable {
 private static final Logger log = LogManager.getLogger(TransactionErrorTester.class);
    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        String payload = eventContext.getMessage().getPayloadAsString();
        if (payload == null) {
            payload = "NULL";
        }
        Transaction currentTransaction = eventContext.getCurrentTransaction();


        payload = payload.trim().toUpperCase();
        if (payload.indexOf("BOZO2") > -1) {
            throw new RuntimeException("you cannot be a BOZO2");
        }

        log.info("transaction testing "+payload);
        return eventContext.getMessage();
    }
}
