package com.dhenton9000.splitter.reporter.work;

import java.util.ArrayList;

import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.apache.log4j.*;
import org.mule.DefaultMuleMessage;
import org.mule.api.config.MuleProperties;
import org.mule.api.transport.PropertyScope;
import org.mule.util.UUID;

/**
 * This class generates the messages it must package them as a List, which is
 * passed thru a collection-splitter which assigns a correlation id and count
 *
 * @author dhenton
 *
 */
public class WorkGenerator implements Callable {

    private static final Logger logger = LogManager.getLogger(WorkGenerator.class);

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        Object o = eventContext.getMessage().getPayload();
        String workCountString = (String) o;
        logger.debug("the worker received " + o.getClass().getName() + " " + o.toString());
        int workCount = 0;
        try {
            workCount = Integer.parseInt(workCountString);
        } catch (Exception err) {
            throw new RuntimeException("cannot parse '" + workCountString + "' ");

        }
        ArrayList<WorkItem> arrayItems = new ArrayList<WorkItem>();
        for (int j = 0; j < workCount; j++) {

            WorkItem.WORK_TYPE workItemLabel = null;
            if (j % 2 == 0) {
                workItemLabel = WorkItem.WORK_TYPE.ALPHA;
            } else {
                workItemLabel = WorkItem.WORK_TYPE.BETA;
            }
            WorkItem i = new WorkItem(workItemLabel, "get a job " + j);
            arrayItems.add(i);
        }




        DefaultMuleMessage dM =
                new DefaultMuleMessage(arrayItems,
                eventContext.getMuleContext());

        
        //set the correlation id to a value for the batch that has
        //real world meaning, eg, a key to the parent table
        String myCorr =  UUID.getUUID();
        dM.setProperty(MuleProperties.MULE_CORRELATION_ID_PROPERTY, myCorr, PropertyScope.OUTBOUND);
        return dM;
    }
}
