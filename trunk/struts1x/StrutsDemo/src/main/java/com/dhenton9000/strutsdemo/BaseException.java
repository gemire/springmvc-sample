package com.dhenton9000.strutsdemo;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class BaseException extends Exception {
   private Throwable rootCause = null;
   private List exceptions = new ArrayList();
   private String messageKey = null;
   private Object[] messageArgs = null;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -361929316875921363L;

	public BaseException() {
		 super();
	}



	public BaseException(Throwable cause) {
		this.setRootCause(cause);
		 
	}



	public void setExceptions(List exceptions) {
		this.exceptions = exceptions;
	}



	public List getExceptions() {
		return exceptions;
	}



	public void setMessageKey(String messageKey) {
		this.messageKey = messageKey;
	}



	public String getMessageKey() {
		return messageKey;
	}



	public void setMessageArgs(Object[] messageArgs) {
		this.messageArgs = messageArgs;
	}



	public Object[] getMessageArgs() {
		return messageArgs;
	}

 
	public void printStackTrace()
	{
	   printStackTrace(System.err);	
	}

	
	
	public void printStackTrace(PrintStream outStream)
	{
		printStackTrace(new PrintWriter(outStream));
	}
	
	public void printStackTrace(PrintWriter writer)
	{
		super.printStackTrace(writer);
		if (getRootCause() != null)
		{
			getRootCause().printStackTrace(writer);
		}
	}

	public static String getStackTrace(Throwable exception)
	{
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		pw.print(" [ " );
		pw.print(exception.getClass().getName());
		pw.print(" ] ");
		exception.printStackTrace(pw);
		return sw.toString();
	}
	
	
	public String getStackTraceContents() {
		String info = "";
		if (getRootCause() != null) {
			BaseException.getStackTrace(getRootCause());
		}

		return info;
	}
	
	

	public void setRootCause(Throwable rootCause) {
		this.rootCause = rootCause;
	}



	public Throwable getRootCause() {
		return rootCause;
	}
}
