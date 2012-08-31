/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.csv;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;
import static org.junit.Assert.*;
/**
 *
 * @author Don
 */
public class FileReaderTests {
    
    private WebServiceFileInputReaderImpl fileReader;
   
    @Before
    public void beforeTest()
    {
       
       fileReader = new WebServiceFileInputReaderImpl();
        
    }
    
    /**
     * TODO: actually predict the objects that will be sent to the 
     * transmit function
     * @throws Exception 
     */
    @Test
    public void testReader() throws Exception
    {
        InputStream iS = this.getClass().getClassLoader().getResourceAsStream("samples/csvsample.csv");
       
     
       ArrayList<RegisterInput> list =  fileReader.processInput(iS);
        
       assertEquals(3,list.size());
        
        iS.close();
    }
    
//name,password,plan,length,date
//manny,bilbo,American,20,12/10/2011
//moe,jo,Alien,23,06/22/2010
//mary,getajob,Armenian,6,10/10/2012
    
    
    @Test
    public void testContentsOfReader() throws Exception
    {
        InputStream iS = this.getClass().getClassLoader().getResourceAsStream("samples/twocsvsample.csv");
        RegisterInput firstInput = new RegisterInput();
        firstInput.setName("manny");
        firstInput.setPassword("bilbo");
        RegistrationDetails details = new RegistrationDetails();
        details.setMonths(BigInteger.valueOf(Long.parseLong("20")));
        details.setPaymentPlan("American");
        firstInput.setRegistrationDetails(details);
        Calendar dateCal = fileReader.convertDate("12/10/2011");
        firstInput.setRegistrationDate(dateCal);
          
        
        RegisterInput secondInput = new RegisterInput();
        secondInput.setName("moe");
        secondInput.setPassword("jo");
        RegistrationDetails details2 = new RegistrationDetails();
        details2.setMonths(BigInteger.valueOf(Long.parseLong("23")));
        details2.setPaymentPlan("Alien");
        secondInput.setRegistrationDetails(details2);
        Calendar dateCal2 = fileReader.convertDate("06/22/2010");
        firstInput.setRegistrationDate(dateCal2);

       
           
         
     
        ArrayList<RegisterInput> list =  fileReader.processInput(iS);
        assertEquals(firstInput, list.get(0));
        iS.close();

    }
    
    
    @Test
    public void testDateConversion()
    {
        Calendar c = fileReader.convertDate("12/27/2011");
        
        assertEquals(2011,c.get(Calendar.YEAR));
        assertEquals(Calendar.DECEMBER,c.get(Calendar.MONTH));
        assertEquals(27,c.get(Calendar.DAY_OF_MONTH));
        
    }
}
