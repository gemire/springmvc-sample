
 
package com.dhenton9000.admissions.bindings.runners;
/*
import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import com.dhenton9000.registration.bindings.RegistrationDetails;
import com.dhenton9000.xml.utils.XmlUtils;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

 
import java.math.BigInteger;
import java.util.Calendar;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

 
public class JaxBHelper {

    private static final Logger log = LogManager.getLogger(JaxBHelper.class);
    private JAXBContext jaxbContext = null;

    public JaxBHelper() {
        initJAXBContext();
    }

   
    final void initJAXBContext() {

        try {
            setJaxbContext(JAXBContext.newInstance(RegisterInput.class, RegisterResponse.class));
        } catch (JAXBException e) {
            log.error("JAXB Context problem " + e.getMessage());
        }

    }

  
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
          XmlUtils.stringToFile(info, "src/test/resources/samples/registerInputSample.xml");
        } catch (Exception ex) {
            
            log.error("problem with jaxb: "+ex.getMessage());
            
        } 
    }
}
*/
public class JaxBHelper {}