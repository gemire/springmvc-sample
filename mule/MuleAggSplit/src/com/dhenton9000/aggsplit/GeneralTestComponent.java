package com.dhenton9000.aggsplit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.dom4j.Document;
 

public class GeneralTestComponent implements Callable {
	private static Log log = LogFactory.getLog(GeneralTestComponent.class);
	@SuppressWarnings("unchecked")
	public Object onCall(MuleEventContext arg0) throws Exception {
		 
		Object payload = arg0.getMessage().getPayload();
		log.debug("payload class "+payload.getClass().getName());
		log.debug("Payload as string "+payload.toString());
		String c = arg0.getMessage().getCorrelationId();
		log.debug("correlation "+c);
		
		return null;
	}

}
