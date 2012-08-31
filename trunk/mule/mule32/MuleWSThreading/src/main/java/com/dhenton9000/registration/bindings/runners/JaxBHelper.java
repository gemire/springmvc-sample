/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration.bindings.runners;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import com.dhenton9000.utils.xml.XMLUtils;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

 
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class for Jaxb Instantiate each time
 * 
 * @author dhenton
 * 
 */
public class JaxBHelper {

    private static final Logger log = LoggerFactory.getLogger(JaxBHelper.class);
    private JAXBContext jaxbContext = null;

    public JaxBHelper() {
        initJAXBContext();
    }

    /**
     * Initialize the JAXB context for AddDataRequest, classes that need to be recognized<br/>
     * can be added to the newInstance call below
     * 
     * @return the initialized context
     * @throws JAXBException
     */
    final void initJAXBContext() {

        try {
            setJaxbContext(JAXBContext.newInstance(RegisterInput.class, RegisterResponse.class));
        } catch (JAXBException e) {
            log.error("JAXB Context problem " + e.getMessage());
        }

    }

    /**
     * Translate a JAXB annotated object to a String xml representation
     * 
     * @param o object to translate
     * @return String with xml
     * @throws JAXBException
     * @throws UnsupportedEncodingException
     */
    public String jaxbToString(Object o) throws JAXBException, UnsupportedEncodingException {
        if (getJaxbContext() == null) {
            initJAXBContext();
        }

        String info = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        getJaxbContext().createMarshaller().marshal(o, baos);
        info = baos.toString("UTF-8");
        return info;
    }

    /**
     * return an object based on a xml string. Consumer must cast<br>
     * the object and is limited to what the context can understand<br>
     * 
     * @param xml
     * @return
     */
    public Object stringToJaxb(String xml) {

        StringReader sR = new StringReader(xml);
        Object o = null;
        try {
            if (jaxbContext == null) {
                initJAXBContext();
            }
            o = jaxbContext.createUnmarshaller().unmarshal(new StreamSource(sR));
        } catch (JAXBException e) {
            log.error(e.getMessage());
        }
        return o;
    }

    public JAXBContext getJaxbContext() {
        return jaxbContext;
    }

    public void setJaxbContext(JAXBContext jaxbContext) {
        this.jaxbContext = jaxbContext;
    }

    public static void main(String[] args) {
        JaxBHelper helper = new JaxBHelper();
        RegisterInput input = new RegisterInput();
        input.setName("name");
        input.setPassword("password");
        input.setRegistrationDate(Calendar.getInstance());
        RegistrationDetails details = new RegistrationDetails();
        details.setMonths(BigInteger.valueOf(10L));
        details.setPaymentPlan("American");
        input.setRegistrationDetails(details);
        try {
          String info =   helper.jaxbToString(input);
          XMLUtils.stringToFile(info, "src/test/resources/samples/registerInputSample.xml");
        } catch (Exception ex) {
            
            log.error("problem with jaxb: "+ex.getMessage());
            
        } 
    }
}
