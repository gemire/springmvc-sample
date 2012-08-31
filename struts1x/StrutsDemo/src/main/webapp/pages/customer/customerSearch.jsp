<%@ page language="java" import="java.util.*;" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">



<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<tiles:importAttribute scope="request" />
<bean:struts id="customers" mapping="/submitCustomerSearchForm"/>
 
<html>
	<head>
		<title><tiles:getAsString name="title" />
		</title>
		<html:base />

		<script type="text/javascript"
			src="<%=basePath%>/theme/js/jquery-1.5.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>/theme/js/menu.js"></script>
		<link rel="stylesheet" href="<%=basePath%>/theme/menustyle.css"
			type="text/css"></link>
			
			
<link rel="stylesheet" href="<%=basePath%>/theme/struts-training.css"
			type="text/css"></link>


	</head>
	<body>

		<table cellpadding="5" cellspacing="5" class='layouttable' border="0"
			cellspacing="0" width="80%">
			<tr>
				<td class="headerpane" colspan="2">
					<h1>
						Customer Database Demo
					</h1>
				</td>
			</tr>
			<tr>
				<td class="menupane" width="20%" id="menubar" valign="top">
					<!-- Begin Menu Layer -->
					<div id="menuLayer">
						<tiles:insert attribute='menu' />
					</div>
					<!-- End Menu Layer -->
				</td>
				<td class="bodypane" valign="top">
					<h2>
						<tiles:getAsString name="blockTitle" />
					</h2>


					<logic:messagesPresent>

						<div class="errorClass">
							<ul>
								<html:errors prefix="errors.prefix" suffix="errors.suffix"
									header="errors.header" />


							</ul>
						</div>

					</logic:messagesPresent>


					<html:form action="/submitCustomerSearchForm" focus="lastName"
						method="GET">

						<table width="60%">
							<tr>
								<td align="right">
									Customer LastName:
								</td>
								<td align="left">
									<html:text property="lastName" size="16" maxlength="25" />
								</td>
								<td align="left">
									<html:image property="searchButton" srcKey="image.search"
										altKey="image.search.alttext" bundle="bundle.image" />
								</td>
							</tr>
						</table>
					</html:form>
<hr/>

<logic:notPresent name="customers" property="customers">
No results found for this customer
</logic:notPresent>
<logic:present name="customers" property="customers">
 
 
 
 <table class="list">
					<thead class="list">
						<tr class="list">
							<td class="list">&nbsp;</td>
							<td class="list">First Name</td>
							<td class="list">Last Name</td>
							<td class="list">Email Address</td>
						</tr>
					</thead>

					<%
						int i = 1;
						String claz = null;
					%>

				<logic:iterate id="customer" name="customers" property="customers">
						<% claz = (i%2 != 0) ? "odd" : "even"; %>
						 
						<tr class="<%= claz %>">

							<td>
								 
									<bean:write name="customer" property="id" />
								 
							</td>

							<td><bean:write name="customer" property="firstName" />  </td>

							<td><bean:write name="customer" property="lastName" />  </td>

							<td><bean:write name="customer" property="emailAddress" /></td>

						</tr>
						<% i++; %>
					</logic:iterate>
				</table>
 
  
<!-- end customers present logic -->
</logic:present>





				</td>
			</tr>
		</table>
	</body>
</html>
