<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Servlet Call</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  <jsp:include page="includes/menu.jsp" />
  
  
  
   <h2>Enter a String</h2>
   
   <form id="stringForm" method="get" action="<%= basePath %>CallBeanServlet">
   
   <table cellpadding="5" cellspacing="5">
   <tr><th>Info:</th><td><input name="stringInfo" size="20"/></td></tr>
   <tr><td colspan="2"><input type="submit" value="Go"/></td></tr>
   
   
   </table>
   
   </form>
   
   
  </body>
</html>
