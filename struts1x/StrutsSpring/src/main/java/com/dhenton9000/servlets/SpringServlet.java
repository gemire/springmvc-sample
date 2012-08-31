package com.dhenton9000.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dhenton9000.beans.InjectedBean;

 
/**
 * Servlet implementation class SpringServlet
 * This class demonstrates how to call a spring context
 * that is defined in the web xml
 * 
 */
public class SpringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpringServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebApplicationContext ctx = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(
				this.getServletContext());
		InjectedBean iBean = (InjectedBean) ctx.getBean("myInjectedBean");

		PrintWriter p = response.getWriter();
		
		p.println("<html><body><h1>"+iBean.getMessage()+"</h1></p>");
		String path = request.getContextPath();
		p.println("<p><a href=\""+path+"/Welcome.do\">Home</a></p>");
		p.println("</body></html>"); 
		
		p.close();
		
		
		
		
		
	}

	 

}
