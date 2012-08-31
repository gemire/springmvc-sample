<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>DB Demo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	

  </head>
  
  <body>
  
  <jsp:include page="includes/menu.jsp" />
  
  
  
   <h2>DataBase Demo</h2>
   
   <p>This is from the servlet: <b>${customer.customerName}</b></p>
   
   
  </body>
</html>
