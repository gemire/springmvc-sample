package com.dhenton9000.basicejb.servlets;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.*;
import com.dhenton9000.ejb.model.Customer;



public class DataBaseServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8645278220672371286L;
	private static final Logger log = LogManager
			.getLogger(DataBaseServlet.class);

	/**
	 * Constructor of the object.
	 */
	public DataBaseServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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

	private void doWork(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		DataSource dbComp = null;
		Customer cust = new Customer();
		cust.setCustomerName("fred");

		try {
			dbComp = getLocator().getDataSource("jdbc/testDBConnection");
		} catch (NamingException e) {
			cust.setCustomerName("error " + e.getMessage());
		}

		if (dbComp != null) {
			cust.setCustomerName(cust.getCustomerName() + " "
					+ dbComp.getClass().getName());
		}

		request.setAttribute("customer", cust);

		dispatch("/pages/dbdemo.jsp", request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
