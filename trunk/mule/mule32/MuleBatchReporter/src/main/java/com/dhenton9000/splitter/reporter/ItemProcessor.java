/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.splitter.reporter;

import com.dhenton9000.splitter.reporter.work.WorkItem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

/**
 *
 * @author dhenton
 */
public class ItemProcessor implements Callable {

    private static final Logger logger = LogManager.getLogger(ItemProcessor.class);
    private WorkItem.WORK_TYPE workType = null;
    
    @Override
    public Object onCall(MuleEventContext mec) throws Exception {
        
        logger.info(workType +" is processing "+mec.getMessage().getPayloadAsString());
        return mec;
    }

    /**
     * @return the workType
     */
    public WorkItem.WORK_TYPE getWorkType() {
        return workType;
    }

    /**
     * @param workType the workType to set
     */
    public void setWorkType(WorkItem.WORK_TYPE workType) {
        this.workType = workType;
    }
    
}
