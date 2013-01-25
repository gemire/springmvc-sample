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

    @Override
    public void processInput(InputStream input) {
        RegisterInput nextTransmission = null;
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
                nextTransmission = new RegisterInput();
                Map<String, String> dataMap = loadMapLine(line, columnLabels);
                //name,password,plan,length,date
                nextTransmission.setName(dataMap.get("name"));
                nextTransmission.setPassword(dataMap.get("password"));
                RegistrationDetails details = new RegistrationDetails();
                details.setMonths(BigInteger.valueOf(Long.parseLong(dataMap.get("length"))));
                details.setPaymentPlan(dataMap.get("plan"));
                nextTransmission.setRegistrationDetails(details);
                Calendar dateCal = convertDate(dataMap.get("date"));
                nextTransmission.setRegistrationDate(dateCal);
                log.info("begin transmission "+nextTransmission.getName());
                webServiceTransmitter.transmit(nextTransmission);
                 log.info("done transmission "+nextTransmission.getName());
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
     * convert the dates in the csv file which are in the form '12/10/2011'
     * @param dateString
     * @return 
     */
    Calendar convertDate(String dateString)
    {
        Calendar dateCal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date dateVar = df.parse(dateString);
            dateCal.setTime(dateVar);
        } catch (ParseException ex) {
            
            throw new RuntimeException("could not parse '"+dateString+"' ");
        }
       
        return dateCal;
    }
    
    
    
}//end class
