package com.dhenton9000.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
 
import java.io.File;

public class TestComponent implements Callable {
	private static Logger log = LogManager.getLogger(TestComponent.class);

	public TestComponent()
	{
		log.debug("creating test component");
	}
	
	
    @Override
	public Object onCall(MuleEventContext arg0) throws Exception {
		
		Object o = arg0.getMessage().getPayload();
		
		
		 log.debug("class "+o.getClass().getName());
		 
		 if (o instanceof File)
		 {
			 File f = (File) o;
			 log.debug("file is "+f.getAbsolutePath());
		 }
		 
		 
		 
		 return null;
	}

}
