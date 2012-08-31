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

<tiles:insert page="/layout/layout.jsp">
	<tiles:put name="title" value="Form Demonstration" />
	<tiles:put name="header" value="/pages/tiles_forms/tilesFormHeader.jsp" />
	<tiles:put name="menu" value="/layout/menu.jsp" />
	<tiles:put name="body" value="/pages/tiles_forms/tstep3.jsp" />
	<tiles:put name="blockTitle" value="Results" />

</tiles:insert>


 