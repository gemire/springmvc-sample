
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.dhenton9000.admissions.components.ws.billing;

import org.slf4j.LoggerFactory;

/**
 * This class was generated by Apache CXF 2.5.1
 * 2012-12-18T14:41:14.651-06:00
 * Generated source version: 2.5.1
 * 
 */

@javax.jws.WebService(
                      serviceName = "BillingService",
                      portName = "BillingPort",
                      targetNamespace = "http://www.mule-health.com/SOA/service/billing/1.0",
                      wsdlLocation = "src/main/resources/billing/BillingService.wsdl",
                      endpointInterface = "com.dhenton9000.admissions.components.ws.billing.Billing")
                      
public class BillingImpl implements Billing {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BillingImpl.class.getName());

    /* (non-Javadoc)
     * @see com.dhenton9000.admissions.components.ws.billing.Billing#createBill(com.dhenton9000.admissions.components.ws.billing.CreateBill  parameters )*
     */
    public  CreateBillResponse createBill(CreateBill parameters) { 
        logger.info("Executing operation createBill");
          
        
        
         
        try {
            CreateBillResponse _return = new CreateBillResponse();
            BillType type = new BillType();
            type.setCostPerNight("29.99");
            type.setInitialStayEstimate("12");
            type.setRunningTotal("199.99");
            type.setStatus("Pending"); // Complete
            _return.setBill(type);
            return _return;
        } catch (java.lang.Exception ex) {
             
            throw new RuntimeException(ex);
        }
        
    }

}
