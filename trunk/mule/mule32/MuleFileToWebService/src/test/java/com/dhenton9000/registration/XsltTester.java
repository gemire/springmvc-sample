/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.registration;

import com.dhenton9000.registration.bindings.RegisterInput;
import com.dhenton9000.registration.bindings.runners.JaxBHelper;
import com.dhenton9000.xml.utils.XmlUtils;
import java.io.IOException;
import org.apache.log4j.*;

/**
 *
 * @author dhenton
 */
public class XsltTester {

    private static final Logger log = LogManager.getLogger(XsltTester.class);
    public static void main(String[] args) {
        //transformBatchSample();
        readinSample();
    }

    private static void readinSample() {
        try {
            String sString = XmlUtils.getStringResource("junk/testRegisterSplit.xml", null);
            JaxBHelper helper = new JaxBHelper();
           RegisterInput r = (RegisterInput) helper.stringToJaxb(sString);
           log.debug(r.getRegistrationDetails().getPaymentPlan());
        } catch (Exception ex) {
            log.error("ex "+ex.getMessage(),ex);
        }
    }

    private static void transformBatchSample() {
        try {

            String sString = XmlUtils.getStringResource("samples/batchSample.xml", null);
            XmlUtils.transformXMLToFile(sString, "target/classes/xslt/batchRegistration.xsl", "src/main/resources/xslt/batchSample_output.xml");

        } catch (Exception ex) {
            log.error("ex "+ex.getMessage(),ex);
        }
    }
}
