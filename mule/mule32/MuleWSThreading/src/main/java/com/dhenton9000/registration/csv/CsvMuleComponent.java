/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import com.dhenton9000.registration.bindings.RegisterInput;
import java.io.InputStream;
import java.util.ArrayList;
import org.mule.DefaultMuleMessage;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleException;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This mule component delegates to the WebServiceFileInputReader
 * which dispatches for each line.
 * @author dhenton
 */
public class CsvMuleComponent implements Callable  {

 

    private WebServiceFileInputReader fileReader;
    private static Logger log = LoggerFactory.getLogger(CsvMuleComponent.class);

    //this is the mule message property key
    @Override
    public Object onCall(MuleEventContext eventContext) throws Exception {

        InputStream is = (InputStream) eventContext.getMessage().getPayload();
        ArrayList<RegisterInput> items = getFileReader().processInput(is);
	is.close();
        return items ;
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
   
}
