package com.dhenton9000.basicejb.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dhenton9000.maven.ejb.utils.ServiceLocator;

public abstract class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8091758788750076713L;
	private final ServiceLocator  locator = new ServiceLocator();
	 
	protected ServiceLocator getLocator() {
		return locator;
	}
	
	
	protected void dispatch(String destination, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		 
		RequestDispatcher dispatcher =
		request.getRequestDispatcher(destination);
		dispatcher.forward(request, response);
	}
	

}
