package com.dhenton9000.basicejb.servlets;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.*;


import com.dhenton9000.jboss4x.beans.sessionbeans.BeanTask;

public class CallBeanServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8645278220672371286L;
	private static final Logger log = LogManager
			.getLogger(CallBeanServlet.class);
	// @EJB this will probably work with a higher version of JBOSS
	private BeanTask bBean;

	/**
	 * Constructor of the object.
	 */
	public CallBeanServlet() {
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
			throws IOException {

	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String stringInfo = null;
		stringInfo = request.getParameter("stringInfo");
		log.debug("string info is " + stringInfo);

		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("<P>This is ");
		out.print(this.getClass() + "</p>");
		out.println("<h4>string is " + stringInfo + "</h4>");
		String findInfo = null;

		try {
			bBean = (BeanTask) getLocator().getEJB(
					"basicEJB/BeanTaskSessionBean/local");
		} catch (Exception e) {
			log.error("problem casting zz " + e.getClass().getName() + " - "
					+ e.getMessage());
		}

		if (bBean != null) {
			findInfo = bBean.getInfo(stringInfo);
		} else {
			findInfo = "bBean null";
		}

		out.println("<h4>out is " + findInfo + "</h4>");

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
