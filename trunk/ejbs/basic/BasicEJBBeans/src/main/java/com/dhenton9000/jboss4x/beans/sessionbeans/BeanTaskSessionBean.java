package com.dhenton9000.jboss4x.beans.sessionbeans;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import javax.ejb.TransactionManagement;
//import javax.ejb.TransactionManagementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

 


@Interceptors(SpringBeanAutowiringInterceptor.class)
@Stateless
//@TransactionManagement(TransactionManagementType.CONTAINER)
public class BeanTaskSessionBean   implements   BeanTask  , BeanTaskRemote {

	@Autowired
	@Qualifier("delegateTest")
	private String testString;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5747100666730896335L;
	private static final Logger log = LogManager.getLogger(BeanTaskSessionBean.class);
	
	
	public String getInfo(String request) {
		String info = "Got your "+request + " !!! "+" but the delegate test is "+testString;
		log.debug("@@@@ got "+info);
		return info;
	}


	public void setTestString(String testString) {
		this.testString = testString;
	}


	public String getTestString() {
		return testString;
	}

	 
	
	
	
}
