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
import org.mule.api.MuleMessage;
import com.dhenton9000.registration.bindings.RegisterResponse;

/**
 * This mule component delegates to the WebServiceFileInputReader which
 * dispatches for each line.
 *
 * @author dhenton
 */
public class CsvMuleComponent implements Callable {

    private String dispatchDestination;
    private String errorDestination;
    private WebServiceFileInputReader fileReader;
    private static Logger log = LogManager.getLogger(CsvMuleComponent.class);
    private String processingType = null;

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

    /**
     * @return the processingType
     */
    public String getProcessingType() {
        return processingType;
    }

    /**
     * @param processingType the processingType to set
     */
    public void setProcessingType(String processingType) {
        this.processingType = processingType;
    }

    /**
     * @return the errorDestination
     */
    public String getErrorDestination() {
        return errorDestination;
    }

    /**
     * @param errorDestination the errorDestination to set
     */
    public void setErrorDestination(String errorDestination) {
        this.errorDestination = errorDestination;
    }
    ///////////////////////

    /**
     * this class fills the contract of the web transmitter via mule it derives
     * all its properties from mule via Spring and being an inner class has
     * access to the mulecontext
     */
    class MuleWebServiceTransmitter implements WebServiceTransmitter {

        private MuleEventContext muleEventContext = null;

        @Override
        public TransmitResult transmit(RegisterInput request, long currentLine, String[] lineContents) {

            TransmitResult tResult = new TransmitResult();
            tResult.setLineNumber(currentLine);
            tResult.setSuccessful(true);
            tResult.setLineContents(TransmitResult.convertArrayToCSVLine(lineContents));
            String fileName = muleEventContext.getMessage()
                    .getProperty("originalFileName", PropertyScope.OUTBOUND);
            tResult.setFileName(fileName);
            tResult.setMessage(null);

            DefaultMuleMessage dM = new DefaultMuleMessage(request, muleEventContext.getMuleContext());
            MuleMessage reply = null;
  
            try {
                // sync dispatch to the web service
                reply = muleEventContext.sendEvent(dM, dispatchDestination);
                // answer back
                RegisterResponse response = (RegisterResponse) reply.getPayload();
                log.debug("reply is " + response.getResponseInformation());
                // check status
                if (!response.getResponseStatus().equals("OK")) {
                    tResult.setSuccessful(false);
                    tResult.setMessage(response.getResponseInformation());
                    dM = 
                    new DefaultMuleMessage(tResult, muleEventContext.getMuleContext());
                    //async dispatch to the line error handler
                    muleEventContext.dispatchEvent(dM, getErrorDestination());
                }

            } catch (MuleException e) {
                throw new RuntimeException("Mule dispatch problem: " + e.getMessage());
            }

            return tResult;
        }

        public void setMuleEventContext(MuleEventContext muleEventContext) {
            this.muleEventContext = muleEventContext;
        }
    }
}
