package com.dhenton9000.registration.components;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import com.dhenton9000.registration.bindings.RegisterInput;
 
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
		if (o instanceof RegisterInput)
                {
                    RegisterInput r = (RegisterInput) o;
                    log.debug("r.name "+r.getName());
                    log.debug("r.details "+r.getRegistrationDetails().getPaymentPlan());
                    
                }
                else
                {
                    
                
		
		 log.debug("class "+o.getClass().getName());
                 log.debug("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n"+o.toString()
                         +"\nxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
		 
		 }
		 
		 
		 
		 return null;
	}

}
