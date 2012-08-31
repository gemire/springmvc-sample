package com.dhenton9000.splitter.reporter;

import com.dhenton9000.splitter.reporter.work.WorkGenerator;
import java.util.HashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

/**
 * This class sets up the demo, it looks for a parameter in the http request
 * called 'count' then sends it both the generator and as the response to the
 * http request
 * 
 * The count is the number of requests that will be sent by the Generator
 * to the Single Processor
 * @author dhenton
 *
 */

public class Initializer implements Callable {
	
	public static final String WORK_COUNT_PARAMETER_NAME = "count";
	
	private static final Logger logger = LogManager.getLogger(WorkGenerator.class);
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		Object o = eventContext.getMessage().getPayload();
		HashMap<String,String> parms = (HashMap<String,String>) o;
		Integer workCount = 0;
		String workCountString = parms.get(WORK_COUNT_PARAMETER_NAME);
		if (workCountString == null)
		{
			logger.warn("the parameter '"+WORK_COUNT_PARAMETER_NAME+"' was not found");
			return "0";
		}
		return workCountString;
		
	}
}
