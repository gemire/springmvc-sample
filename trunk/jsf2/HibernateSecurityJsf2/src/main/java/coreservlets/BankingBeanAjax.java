package coreservlets;

import javax.faces.bean.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

 

/** From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, 
 *  Spring, Hibernate/JPA, and Java programming</a>.
 
 *
 */

@ManagedBean(name="bankingBeanAjax")
@SessionScoped
public class BankingBeanAjax extends BankingBeanBase { 
  private String message = "";
	private static Logger log = LogManager.getLogger(BankingBeanAjax.class);
 
  public String getMessage() {
    return(message);
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
  @Override
  public String showBalance() {
	  
	  log.debug("password "+getPassword()+" user "+this.getCustomerId());
	  
    if (!password.equals("secret")) {
      message = "Incorrect password";
    } else {
      CustomerLookupService service =
        new CustomerSimpleMap();
      customer = service.findCustomer(customerId);
      if (customer == null) {
        message = "Unknown customer";
      } else {
        message = 
          String.format("Balance for %s %s is $%,.2f",
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getBalance());
      }
    }
    return(null);
  }
}
