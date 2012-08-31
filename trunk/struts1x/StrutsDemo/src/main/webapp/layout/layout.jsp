<%@ page language="java" import="java.util.*;" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()+path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<tiles:importAttribute scope="request" />
<html>
 	<head>
		<title><tiles:getAsString name="title"/></title>
	 
	
	<script type="text/javascript" src="<%= basePath %>/theme/js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="<%= basePath %>/theme/js/menu.js"></script>
	<link rel="stylesheet" href="<%= basePath %>/theme/menustyle.css" type="text/css"></link>

	
	
	</head>
	<body>
		<table cellpadding="5" cellspacing="5" class='layouttable' border="0" cellspacing="0" width="80%">
			<tr>
				<td class="headerpane" colspan="2"><tiles:insert attribute="header" /></td>
			</tr>
			<tr>
					<td class="menupane" width="20%" id="menubar" valign="top" >
					<!-- Begin Menu Layer -->
					<div id="menuLayer">
						<tiles:insert attribute='menu'/>
					</div>
					<!-- End Menu Layer -->	
					</td>		
				<td class="bodypane" valign="top">
				   <h2><tiles:getAsString name="blockTitle"/></h2>
				   <tiles:insert attribute='body' />
				</td>
			</tr>
		</table>
	</body>
</html>
