<%@ page language="java" import="java.util.*;" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setBundle basename="com.dhenton9000.strutsdemo.PutListResources"/>

<tiles:importAttribute/>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()+path+"/";
%>
<ul>
<li>The pages/putList/layout.jsp placed the key of <b>${bundleInfo}</b> into scope.</li>
<li>It was used to look up the following from PutListResources.properties</li>
<li><b><fmt:message key="${bundleInfo}"/></b></li>
<li>Header Text: ${headerText}</li>
<li>Here is information passed from layout.jsp via 'requestURI' bean:</li>
<li><b>${requestURI}</b></li>


</ul>



 