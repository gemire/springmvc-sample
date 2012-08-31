package com.dhenton9000.splitter.reporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.mule.api.MuleEventContext;
import org.mule.api.config.MuleProperties;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import java.util.Set;
import org.apache.log4j.*;
import org.mule.api.MuleMessage;

/**
 * this class actually performs work on the individual message and the informs
 * the reporter that it is done
 *
 * @author dhenton
 *
 */
public class Reporter implements Callable {

    private static final Logger logger = LogManager.getLogger(Reporter.class);
    private HashMap<String, TotalCountTracker> batchCheck = new HashMap<String, TotalCountTracker>();

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        MuleMessage message = null;
        synchronized (this) {
            message = eventContext.getMessage();
            String correlationId = message.getCorrelationId();
            TotalCountTracker tracker = null;


            logger.debug("hashmap has size of 1 " + batchCheck.size());

            if (batchCheck.containsKey(correlationId)) {
                logger.debug("found " + correlationId);
                tracker = batchCheck.get(correlationId);
                tracker.currentCount++;
                logger.debug("found " + correlationId + " " + tracker);
                checkJobDone(tracker);

            } else {
                // its a new correlationId
                Integer totalCount =
                        message.getProperty(MuleProperties.MULE_CORRELATION_GROUP_SIZE_PROPERTY,
                        PropertyScope.OUTBOUND);
                logger.debug("total count is " + totalCount + " for " + correlationId);

                tracker = new TotalCountTracker();
                tracker.currentCount = 1;
                tracker.totalCount = totalCount;
                tracker.correlationId = correlationId;
                logger.debug("creating tracker " + tracker);
                checkJobDone(tracker);
            }
            logger.debug("hashmap has size of 2 " + batchCheck.size());
        }// end synchronized



        return message;
    }

    private void checkJobDone(TotalCountTracker tracker) {
        logger.debug("in checkJobDone " + tracker);
        if (tracker.totalCount == tracker.currentCount) {
            // this is where we would report out the completion process
            logger.info("!!!!!!!!!!!!!!!!!completed -->" + tracker);
            batchCheck.remove(tracker.correlationId);
        } else {
            // only save it if the size > 1
            logger.debug("checkJobDone put " + tracker);
            batchCheck.put(tracker.correlationId, tracker);

        }// send out announcement

    }
}

class TotalCountTracker {

    public int totalCount;
    public int currentCount;
    public String correlationId;

    @Override
    public String toString() {
        return "totalCount: " + totalCount + " currentCount: " + currentCount
                + " id: " + correlationId;
    }
}