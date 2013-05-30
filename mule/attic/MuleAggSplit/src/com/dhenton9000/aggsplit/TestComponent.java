package com.dhenton9000.aggsplit;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.dom4j.Document;
 

public class TestComponent implements Callable {
	private static Log log = LogFactory.getLog(TestComponent.class);
	@SuppressWarnings("unchecked")
	public Object onCall(MuleEventContext arg0) throws Exception {
		 
		Object payload = arg0.getMessage().getPayload();
		List<Document> var = (List<Document>) payload;
		
		
		
		log.debug("payload class "+payload.getClass().getName());
		
		log.debug(payload);
		
		for (Document d:var)
		{
			log.debug(d.asXML());
		}
		
		
		return null;
	}

}
