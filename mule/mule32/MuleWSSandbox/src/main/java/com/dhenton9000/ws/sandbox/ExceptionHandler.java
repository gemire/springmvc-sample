/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.ws.sandbox;

import java.util.Iterator;
import java.util.Set;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.mule.message.ExceptionMessage;

/**
 *
 * @author dhenton
 */
public class ExceptionHandler implements Callable {

    private static final Logger logger = LogManager.getLogger(ExceptionHandler.class);

    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {
        Object o = eventContext.getMessage().getPayload();

        ExceptionMessage exceptionMessage = null;
        if (o instanceof ExceptionMessage) {
            exceptionMessage = (ExceptionMessage) o;
            exceptionMessage.getComponentName();
            Throwable t = exceptionMessage.getException();
            StringBuffer be = new StringBuffer();
            be.append("\nGeneral error has occurred for wrapper file: ");

            be.append("\nThe error message is " + t.getMessage());
            be.append("\nThe error class is " + t.getClass().getName());
            logger.error(be.toString());

        } else {
            // this should never happen as we are handling an item in the defaultExceptionStrategy
            logger.error("Expecting ExceptionMessage but got  "+ o.getClass().getName());

        }
        // /////////////////////////
        Object origPayload = eventContext.getMessage().getOriginalPayload();
        StringBuffer be = new StringBuffer();
        be.append("\n===============================\n");
        if (origPayload instanceof ExceptionMessage) {
            ExceptionMessage oException = (ExceptionMessage) origPayload;

            Throwable t = oException.getException();
            be.append("\nOriginalPayload: The error message is " + t.getMessage());
            be.append("\nOriginalPayload: The error class is " + t.getClass().getName());
            be.append("\nOriginalPayload: The payload class is " + oException.getPayload().getClass().getName());
            be.append("\nOriginalPayload: The payload class is " + oException.getPayload().toString());
            Object p = oException.getPayload();

            if (p instanceof PostMethod) {
                PostMethod postMeth = (PostMethod) p;
                String body = postMeth.getResponseBodyAsString();
                be.append("\nError PostMethod Body:\n" + body + "\n");
            }

        } else {

            be.append("\nOriginal Payload class: " + origPayload.getClass().getName());
            be.append("\nOriginal Payload as string: " + origPayload.toString());

        }

        be.append("Props\n" + reportProperties(eventContext.getMessage()));

        logger.error(be.toString());
        return null;
    }

    public String reportProperties(MuleMessage message) {
        String propInfo = "";

        Set<String> inboundSet = message.getPropertyNames(PropertyScope.INBOUND);

        Iterator<String> iS = inboundSet.iterator();
        propInfo += "\nINBOUND\n";
        while (iS.hasNext()) {
            String key = iS.next();
            Object prop = message.getProperty(key, PropertyScope.INBOUND);
            propInfo += "\t" + key + " --> " + prop + "\n";

        }

        Set<String> outboundSet = message.getPropertyNames(PropertyScope.OUTBOUND);
        propInfo += "\nOUTBOUND\n";
        iS = outboundSet.iterator();
        while (iS.hasNext()) {
            String key = iS.next();
            Object prop = message.getProperty(key, PropertyScope.OUTBOUND);
            propInfo += "\t" + key + " --> " + prop + "\n";
        }

        return propInfo;

    }
}
