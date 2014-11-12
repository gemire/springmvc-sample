<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

%>
<h3>Login</h3>

<c:choose>
    <c:when test="${empty param.message}"></c:when>
    <c:otherwise>
       <div class="text-error" id="login-error"><%= request.getParameter("message") %></div>
   </c:otherwise>
</c:choose>
<form action="<%= basePath %>/j_spring_security_check" method="post" >

<p>
	<label for="j_username">Username</label>
	<input id="j_username" name="j_username" type="text" value="admin" />
</p>

<p>
	<label for="j_password">Password</label>
	<input id="j_password" name="j_password" type="password" value="admin" />
</p>
<p>
<i>(username: admin password: admin)</i>
</p>

<input class="btn btn-info" type="submit" value="Login"/>								
	
</form>
<div class="resultsClass">
<h4>The link below should be blocked by security and be for admins only</h4>

<div class="itemContainer"><a href="<%= basePath %>/app/security/demo/special/admin">Special Admin Page</a></div>
<div class="itemContainer"><a href="<%= basePath %>/app/security/demo/admin">Admin Page</a></div>
</div>
<p><a href="<%= basePath %>/app/security/demo/logout">Log Out</a></p>



<sec:authorize access="hasRole('ROLE_ADMIN')">

This content will only be visible to users who have
the "ROLE_ADMIN" authority in their list of <tt>GrantedAuthority</tt>s.
See <a href="http://static.springsource.org/spring-security/site/docs/3.0.x/reference/taglibs.html">Spring Security Documentation</a>

</sec:authorize>





</body>
</html>