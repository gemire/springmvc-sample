<%@ page language="java" import="java.util.*;" pageEncoding="ISO-8859-1"%>

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

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute scope="request" />
<html>
	<head>
		<title><tiles:getAsString name="title" /></title>


		<script type="text/javascript"
			src="<%=basePath %>/theme/js/jquery-1.5.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath %>/theme/js/menu.js"></script>
		<link rel="stylesheet" href="<%= basePath %>/theme/menustyle.css"
			type="text/css"></link>

		<style>
div.dClass {
	padding: 10px;
	spacing: 10px;
	border: thin solid #aa0000;
	margin: 10px;
}

 
</style>

	</head>
	<body>

		

		<table cellpadding="5" cellspacing="5" class='layouttable' border="0"
			cellspacing="0" width="80%" height="80%">
			<tr>
				<td class="headerpane" colspan="2">
					<tiles:insert attribute="header">

					</tiles:insert>
				</td>
			</tr>
			<tr>
				<td class="menupane" width="10%" id="menubar">
					<!-- Begin Menu Layer -->
					<div id="menuLayer">
						<tiles:insert attribute='menu' />
					</div>
					<!-- End Menu Layer -->
				</td>
				<td class="bodypane" width="40%">
					<h2>
						<tiles:getAsString name="blockTitle" />
					</h2>

					<table border="0" id="sidebarTable" cellpadding="5" cellspacing="5">


						<tr>
							<td width="75%">
								<div class="dClass">
									<tiles:insert attribute='body1' />
								</div>
								<div class="dClass">
									<tiles:insert attribute='body2' />
								</div>
								<div class="dClass">
									<tiles:insert attribute='body3'>
										<tiles:put name="bundleInfo" beanName="bundleInfo"
											value="bundle.info" beanScope="tile" />
										<tiles:put name="requestURI" beanName="requestURI"
											value="<%= request.getRequestURI() %>" beanScope="tile" />

									</tiles:insert>
								</div>

								<div class="dClass">
									<tiles:insert attribute='body4' />
								</div>
							</td>
							<td valign="top">
							<div class="dClass">
							<!--  parm passing sample -->
							 These buttons were rendered using /pages/putList/buttonDisplay.jsp
							 and tiles <i>tiles.putList.buttonDisplay</i><br/>
							<tiles:insert attribute='buttons'>
							<tiles:put name="buttonBundleName" beanName="buttonBundleName"
											value="com.dhenton9000.strutsdemo.PutListResources" beanScope="tile" />
							</tiles:insert>
							
							


							</div>
							</td>
						</tr>

					</table>
					

				</td>
			</tr>
		</table>
	</body>
</html>
