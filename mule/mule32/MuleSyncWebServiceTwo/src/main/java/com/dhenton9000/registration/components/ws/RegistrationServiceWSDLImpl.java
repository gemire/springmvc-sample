/**
 * Please modify this class to meet your needs This class is not complete
 */
package com.dhenton9000.registration.components.ws;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.RegisterResponse;
import java.math.BigDecimal;
import java.util.Calendar;
import org.apache.log4j.*;

/**
 * This class was generated by Apache CXF 2.5.1 2012-02-02T13:22:34.057-06:00
 * Generated source version: 2.5.1
 *
 */
@javax.jws.WebService(serviceName = "RegistrationServiceWSDL",
portName = "RegistrationServiceWSDLSOAP",
targetNamespace = "uri:dhenton9000:registrationService",
wsdlLocation = "src/main/resources/RegistrationService.wsdl",
endpointInterface = "com.dhenton9000.registration.components.ws.RegistrationServiceWSDL")
public class RegistrationServiceWSDLImpl implements RegistrationServiceWSDL {

    private static final Logger logger = LogManager.getLogger(RegistrationServiceWSDLImpl.class.getName());

    /* (non-Javadoc)
     * @see com.dhenton9000.registration.components.ws.RegistrationServiceWSDL#register(com.dhenton9000.registration.components.ws.RegisterInput  inputParameter )*
     */
    @Override
    public RegisterResponse register(RegisterInput inputParameter) {
        final String name = inputParameter.getName();
        String replyString =
                "Thank you " + name + " for " + inputParameter.getRegistrationDetails().getPaymentPlan();
        RegisterResponse _return = new RegisterResponse();
        _return.setResponseInformation(replyString);
        _return.setCurrentTime(Calendar.getInstance());
        BigDecimal dd = BigDecimal.valueOf(100.25d);
        _return.setTotalCost(dd);
        _return.setPaymentDepartment("Fred");
        _return.setResponseStatus("OK");

        // the try catch simulates the place where real work takes place
        try {

            logger.debug("Executing operation register " + name);
            String t = null;
            if (name == null) {
                t = "";
            } else {
                t = name.toUpperCase().trim();
            }
            if (t.indexOf("BOZO") > -1) {

                throw new BozoException("You cannot be a bozo!");
            }
        } catch (Exception err) {
            
            return  composeErrorResponse(err);
        }

        logger.debug("Web service is saying " + replyString);
        return _return;

    }

    private RegisterResponse composeErrorResponse(Exception e) {
        RegisterResponse errorResponse = new RegisterResponse();
        logger.debug("compose error '"+e.getMessage()+"'");
        errorResponse.setResponseStatus("ERROR");
        errorResponse.setResponseInformation(e.getMessage());
        return errorResponse;

    }
}
