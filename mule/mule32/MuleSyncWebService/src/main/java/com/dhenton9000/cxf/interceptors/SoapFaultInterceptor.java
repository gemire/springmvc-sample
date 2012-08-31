/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.cxf.interceptors;



import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.Soap11FaultOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class SoapFaultInterceptor extends AbstractSoapInterceptor {

	private final Logger logger = LogManager.getLogger(SoapFaultInterceptor.class);

	public SoapFaultInterceptor() {
		super(Phase.MARSHAL);
		 
		getAfter().add(Soap11FaultOutInterceptor.class.getName());
	}

	@Override
	public void handleMessage(SoapMessage message) {
		Fault fault = (Fault) message.getContent(Exception.class);
		Throwable t = getOriginalCause(fault.getCause());
		String msg = null;
		if (null == t) {
			msg = "Error cause unknown";
		} else {
			msg = t.getMessage();
		}
		logger.error("Error encounted: " + fault.getFaultCode() + ": " + fault.getMessage() + ", sending this message in SOAP fault: " + msg);
		fault.setMessage(msg);
	}

	private Throwable getOriginalCause(Throwable t) {
		if (null == t || null == t.getCause() || t.getCause().equals(t)) {
			return t;
		}
		return getOriginalCause(t.getCause());
	}
}
