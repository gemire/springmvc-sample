package com.dhenton9000.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.config.MuleProperties;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import org.mule.api.transport.PropertyScope;

public class TestComponent implements Callable {

    private static Logger log = LogManager.getLogger(TestComponent.class);

    public TestComponent() {
        log.debug("creating test component");
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        Object o = eventContext.getMessage().getPayload();

        log.debug("Payload "+eventContext.getMessageAsString());




        return null;
    }
}
