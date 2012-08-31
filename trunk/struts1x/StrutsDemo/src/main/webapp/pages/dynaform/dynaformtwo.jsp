<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>


<h3>Information via EL for a DynaForm</h3>

<ul>
<li>Candidate Name: ${formBean.map["candidateName"]}</li>
<li>Candidate Gender: ${formBean.map["candidateGender"]}</li>

</ul>


<h3>Iterating the contents of the DynaForm Map</h3>

<table cellpadding="4" cellspacing="4">
<tr><th>Key</th><th>Value</th></tr>

<c:forEach var="entry" items="${formBean.map}">   
<tr>
	<c:set var="res" value="${entry.value}" />
	<td><c:out	value="${entry.key}" /></td>  
	<td>
	<c:out value="${entry.value}" />
	</td>
	
</tr>
	</c:forEach>



</table>
	

 


