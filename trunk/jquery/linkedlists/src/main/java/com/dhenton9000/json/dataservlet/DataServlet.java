package com.dhenton9000.json.dataservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dhenton9000.json.SampleGenerator;
 
public class DataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2562304127789442129L;
	public  static final String REQUEST_TYPE_CATEGORIES = "CATEGORIES";
	public  static final String REQUEST_TYPE_SUBCATEGORIES = "SUBCATEGORIES";
	public  static final String REQUEST_TYPE_SUBCATEGORIES_NODELAY = "SUBCATEGORIES_NODELAY";
	private static final Logger log = LogManager.getLogger(DataServlet.class);
	private long delay = 1500L;
	

	/**
	 * Constructor of the object.
	 */
	public DataServlet() {
		super();
		SampleGenerator.getCategories();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doWork(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doWork(request, response);
	}

	private void doWork(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestType = request.getParameter("requestType");
		String subCategoryType = request.getParameter("subCategory");
		int subCategory = -99;
		if (subCategoryType != null)
		{
			subCategoryType = subCategoryType.trim();
			subCategory = Integer.parseInt(subCategoryType);
		}
		
		boolean foundSomething = false;
		if (requestType == null)
		{
			throw new ServletException("requestType cannot be empty");
		}
		
		requestType = requestType.trim().toUpperCase();
		String results = "";
		response.setHeader("Cache-Control", "no-cache");
	    response.setHeader("Pragma", "no-cache");
	    response.setContentType("application/json");
	   //response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
 	   if (requestType.equals(REQUEST_TYPE_CATEGORIES))
 	   {
 		   foundSomething = true;
 		   results = SampleGenerator.getJSONData(SampleGenerator.getCategories());
		   out.print(results);
 		   out.close();
 		   return;
 	   }
 	   
	   if (requestType.equals(REQUEST_TYPE_SUBCATEGORIES) &&
			   subCategory >= 0 && subCategory < SampleGenerator.getCategories().length)
	   {    
		   delay();
		   results = SampleGenerator.getJSONData(SampleGenerator.getSubCategory(SampleGenerator.getCategories()[subCategory]));
		   foundSomething = true;
	  	   out.print(results);
 		   out.close();
 		   return;
 	   }
	 
	   if (requestType.equals(REQUEST_TYPE_SUBCATEGORIES_NODELAY) &&
			   subCategory >= 0 && subCategory < SampleGenerator.getCategories().length)
	   {    
		    
		   results = SampleGenerator.getJSONData(SampleGenerator.getSubCategory(SampleGenerator.getCategories()[subCategory]));
		   foundSomething = true;
	  	   out.print(results);
 		   out.close();
 		   return;
 	   }
	    
	    
 	   if (foundSomething == false)
 	   {
 		   throw new ServletException("requestType '"+requestType+"' subcategory "+subCategory+"' not found");
 	   }
	    
	
	    
	}

	private void delay() {
		
		long startVar = System.currentTimeMillis();
		long diff = 0L;
		while (true)
		{
			long nowVar = System.currentTimeMillis();
			diff = nowVar- startVar;
			if (diff > delay)
			{
				break;
			}
		}
		
		
	}

}
