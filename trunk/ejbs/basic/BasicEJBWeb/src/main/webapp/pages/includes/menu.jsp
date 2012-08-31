<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<table cellspacing="5" cellpadding="5">


<tr>
<td><a href="<%= basePath %>">Home</a></td>




</tr>



</table> 
<hr/>