/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import com.dhenton9000.registration.bindings.RegisterInput;
import java.io.InputStream;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.apache.log4j.*;
/**
 * This mule component delegates to the WebServiceFileInputReader
 * which dispatches for each line.
 * @author dhenton
 */
public class CsvMuleComponent implements Callable  {

    private String credentialMessageProperyName;
    private String dispatchDestination;
    private String credentialPair = null;
    private WebServiceFileInputReader fileReader;
    private static Logger log = LogManager.getLogger(CsvMuleComponent.class);

    //this is the mule message property key
    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        InputStream is = (InputStream) eventContext.getMessage().getPayload();
	MuleWebServiceTransmitter webSender = new MuleWebServiceTransmitter();
	webSender.setMuleEventContext(eventContext);
	getFileReader().setWebServiceTransmitter(webSender);
	getFileReader().processInput(is);
	is.close();
        return null;
    }

   
    /**
     * @return the credentialPair
     */
    public String getCredentialPair() {
        return credentialPair;
    }

    /**
     * @param credentialPair the credentialPair to set
     */
    public void setCredentialPair(String credentialPair) {
        this.credentialPair = credentialPair;
    }

    /**
     * @return the credentialMessageProperyName
     */
    public String getCredentialMessageProperyName() {
        return credentialMessageProperyName;
    }

    /**
     * @param credentialMessageProperyName the credentialMessageProperyName to
     * set
     */
    public void setCredentialMessageProperyName(String credentialMessageProperyName) {
        this.credentialMessageProperyName = credentialMessageProperyName;
    }

    /**
     * @return the dispatchDestination
     */
    public String getDispatchDestination() {
        return dispatchDestination;
    }

    /**
     * @param dispatchDestination the dispatchDestination to set
     */
    public void setDispatchDestination(String dispatchDestination) {
        this.dispatchDestination = dispatchDestination;
    }

    /**
     * @return the fileReader
     */
    public WebServiceFileInputReader getFileReader() {
        return fileReader;
    }

    /**
     * @param fileReader the fileReader to set
     */
    public void setFileReader(WebServiceFileInputReader fileReader) {
        this.fileReader = fileReader;
    }
    ///////////////////////
    /**
     * this class fills the contract of the web transmitter via mule
     * it derives all its properties from mule via Spring and being an
     * inner class
     */
    class MuleWebServiceTransmitter implements WebServiceTransmitter {

        private MuleEventContext muleEventContext = null;

        @Override
        public void transmit(RegisterInput request) {

            DefaultMuleMessage dM = new DefaultMuleMessage(request, muleEventContext.getMuleContext());
            dM.setProperty(credentialMessageProperyName, credentialPair, PropertyScope.OUTBOUND);
            try {
                muleEventContext.dispatchEvent(dM, dispatchDestination);
            } catch (MuleException e) {
                throw new RuntimeException("Mule dispatch problem: " + e.getMessage());
            }
        }

        public void setMuleEventContext(MuleEventContext muleEventContext) {
            this.muleEventContext = muleEventContext;
        }
    }
}
