
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.dhenton9000.registration.client;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.components.ws.RegistrationServiceWSDL;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.5.1
 * 2012-02-02T13:22:34.057-06:00
 * Generated source version: 2.5.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "RegistrationServiceWSDL",
                      portName = "RegistrationServiceWSDLSOAP",
                      targetNamespace = "uri:dhenton9000:registrationService",
                      wsdlLocation = "src/main/resources/RegistrationService.wsdl",
                      endpointInterface = "com.dhenton9000.registration.components.ws.RegistrationServiceWSDL")
                      
public class RegistrationServiceWSDLImpl implements RegistrationServiceWSDL {

    private static final Logger LOG = Logger.getLogger(RegistrationServiceWSDLImpl.class.getName());

    /* (non-Javadoc)
     * @see com.dhenton9000.registration.components.ws.RegistrationServiceWSDL#register(com.dhenton9000.registration.components.ws.RegisterInput  inputParameter )*
     */
    public com.dhenton9000.registration.bindings.RegisterResponse register(RegisterInput inputParameter) { 
        LOG.info("Executing operation register");
        System.out.println(inputParameter);
        try {
            com.dhenton9000.registration.bindings.RegisterResponse _return = null;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}