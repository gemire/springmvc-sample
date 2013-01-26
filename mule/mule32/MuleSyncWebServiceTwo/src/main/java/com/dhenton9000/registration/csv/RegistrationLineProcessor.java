/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author dhenton
 */
public class RegistrationLineProcessor implements LineProcessor {
    
    
    public RegisterInput processLine(Map<String, String> dataMap)   {
        RegisterInput nextTransmission;
        //name,password,plan,length,date
        nextTransmission = new RegisterInput();
        nextTransmission.setName(dataMap.get("name"));
        nextTransmission.setPassword(dataMap.get("password"));
        RegistrationDetails details = new RegistrationDetails();
        details.setMonths(BigInteger.valueOf(Long.parseLong(dataMap.get("length"))));
        details.setPaymentPlan(dataMap.get("plan"));
        nextTransmission.setRegistrationDetails(details);
        Calendar dateCal = convertDate(dataMap.get("date"));
        nextTransmission.setRegistrationDate(dateCal);
        return nextTransmission;
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
    
}
