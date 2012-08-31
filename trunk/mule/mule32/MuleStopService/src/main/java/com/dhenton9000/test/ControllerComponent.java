package com.dhenton9000.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.Connector;

public class ControllerComponent implements Callable {

    private static Logger log = LogManager.getLogger(ControllerComponent.class);

    public ControllerComponent() {
        log.debug("creating test component");
    }

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        Connector stopConnector =
                eventContext.getMuleContext().getRegistry().lookupConnector("StoppableQuartzConnector");

        if (stopConnector == null) {

            throw new RuntimeException("connector is null");
        }
        boolean switchOn = stopConnector.isStarted();

        if (switchOn) {
            log.debug("process on, turning it off");
            switchOn = false;
            stopConnector.stop();
        } else {
            log.debug("process off, turning it on");
            switchOn = true;
            stopConnector.start();
        }




        return null;
    }
}
