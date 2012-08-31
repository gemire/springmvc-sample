package com.dhenton9000.strutsdemo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
 

public class MessageExceptionHandler extends ExceptionHandler {

	private static final Logger log = Logger.getLogger(MessageExceptionHandler.class);
	
	
	public ActionForward execute(Exception ex, ExceptionConfig config,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		ActionForward forward = null;
		ActionError error = null;
		String property = null;
		String path = null;

		// figure out the path to make an ActionForward
		if (config.getPath() != null) {
			path = config.getPath();
		} else {
			path = mapping.getInput();
		}

		 
		
		forward = new ActionForward(path);
		if (ex instanceof BaseException) {
			// specialized behavior
			
			BaseException baseException = (BaseException) ex;
			String messageKey = baseException.getMessageKey();
			Object[] exArgs = baseException.getMessageArgs();
			if (exArgs != null && exArgs.length > 0 && messageKey != null) {
				error = new ActionError(messageKey, exArgs);
			} else {
				// create an ActionError without arguments
				if (messageKey != null) {
					error = new ActionError(messageKey);
				} else {
					error = new ActionError(config.getKey());
				}
			}
		} else {
			// use the error key from the struts-config.xml element
			error = new ActionError(config.getKey());
			property = error.getKey();
		}
		
		storeException(request, property, error, forward, config.getScope());
		log.debug("Exception Handler called\nproperty: "+property+"\nError: "+error.getKey());
		
		return forward;
	}

}
