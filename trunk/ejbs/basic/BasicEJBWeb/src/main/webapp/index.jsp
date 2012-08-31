<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>EJB Demo Menu</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <h2>EJB Samples</h2>
   
   <ol>
   <li><a href="pages/servlet_call.jsp">Servlet Calls Session Bean</a></li>
   <li><a href="DataBaseBeanServlet">Database Servlet</a></li>
   <li><a href="SpringServlet">Spring Integration</a></li>
   
   
   
   </ol>
   
  </body>
</html>
