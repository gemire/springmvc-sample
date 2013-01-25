/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import au.com.bytecode.opencsv.CSVReader;
import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This class will read the file, and dispatch a web service call for
 * each line in the file. Because the transmitter is through a service with
 * an interface it can be mocked.
 * 
 * @author Don
 */
public class WebServiceFileInputReaderImpl implements WebServiceFileInputReader {

    private WebServiceTransmitter webServiceTransmitter;
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE_CHARACTER = '"';
    private static Logger log = LogManager.getLogger(WebServiceFileInputReaderImpl.class);
    private LineProcessor lineProcessor;

    @Override
    public void processInput(InputStream input) {
        RegisterInput nextTransmission = null;
        long lineCounter = 0;
        CSVReader reader = null;
        try {

            BufferedReader buffReader = new BufferedReader(new InputStreamReader(input));
            boolean strictQuotes = false;
            reader = new CSVReader(buffReader, DEFAULT_SEPARATOR, DEFAULT_QUOTE_CHARACTER, strictQuotes);
            // get the headers
            String[] line = reader.readNext();

            List<String> columnLabels = Collections.unmodifiableList(Arrays.asList(line));
            // now start the loop of the file body
            while ((line = reader.readNext()) != null) {
                lineCounter ++;
                
                Map<String, String> dataMap = loadMapLine(line, columnLabels);
                nextTransmission = getLineProcessor().processLine(dataMap);
                log.debug("begin transmission "+nextTransmission.getName());
                
                webServiceTransmitter.transmit(nextTransmission,lineCounter,line);
                
                log.debug("done transmission "+nextTransmission.getName());
            }
        } catch (Exception err) {
            log.error("web service error: " + err.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
            }
        }



    }//end processInput

    @Override
    public void setWebServiceTransmitter(WebServiceTransmitter t) {
        this.webServiceTransmitter = t;
    }

    public WebServiceTransmitter getWebServiceTransmitter() {
        return webServiceTransmitter;
    }

    /**
     * load a map containing the column names and values
     * @param line
     * @param columnLabels
     * @return 
     */
    private Map<String, String> loadMapLine(String[] line, List<String> columnLabels) {
        int ndx = 0;
        Map<String, String> dataMap = new HashMap<String, String>();
        for (String label : columnLabels) {
            if (ndx < line.length) {
                dataMap.put(label, line[ndx]);
            }
            ndx++;
        } //
        return dataMap;
    }

    /**
     * @return the lineProcessor
     */
    public LineProcessor getLineProcessor() {
        return lineProcessor;
    }

    /**
     * @param lineProcessor the lineProcessor to set
     */
    public void setLineProcessor(LineProcessor lineProcessor) {
        this.lineProcessor = lineProcessor;
    }
    
   

    
    
    
}//end class
