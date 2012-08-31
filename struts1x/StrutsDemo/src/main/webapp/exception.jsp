<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" isErrorPage="true" %>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()+path+"/";
%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Report</title>
</head>
<body>
<h2>Error</h2>
<h3><i>An error Occurred</i></h3>
<p> <a href="<%= basePath %>">Return to Home</a>.</p>

<hr/>



<h3>Exception Message:</h3>
<%=  exception.getMessage() %>

<h3>Exception Class:</h3>
<%=  exception.getClass().getName() %>


<h3>Stack Trace:</h3>
<%


Exception ex = new Exception("something went wrong");
StringWriter sw = new StringWriter();
ex.printStackTrace(new PrintWriter(sw));
String stacktrace = sw.toString();
 

%>

<div>

<%= stacktrace %>


</div>

</body>
</html>