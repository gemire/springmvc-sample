<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/search.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="account" />: <fmt:message key="crud.functionalities.example" /></title>
</head>
<body>
	<span class="ui-state-highlight button button-search"><fmt:message key="account" /></span> 
	<a href="${pageContext.request.contextPath}/domain/account/create" class="button button-create"><fmt:message key="crud.functionalities.create" /></a> 
	<a href="${pageContext.request.contextPath}/domain/account/showcase" class="button button-create"><fmt:message key="crud.functionalities.showcase" /></a>

	<form:form action="${pageContext.request.contextPath}/domain/account/list" modelAttribute="accountSearchForm" class="search">
		<table class="show">
			<tbody>
				<tr>
					<th><fmt:message key="account_username" /></th>
					<td>
						<form:input path="account.username"/>
						<form:errors path="account.username" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="account_password" /></th>
					<td>
						<form:password path="account.password"/>
						<form:errors path="account.password" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="account_email" /></th>
					<td>
						<form:input path="account.email"/>
						<form:errors path="account.email" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="account_isEnabled" /></th>
					<td>
						<label for="account.isEnabled.true"><fmt:message key="TRUE" /></label>
						<form:radiobutton id="account.isEnabled.true" path="account.isEnabled" value="true" />
						<label for="account.isEnabled.false"><fmt:message key="FALSE" /></label>
						<form:radiobutton id="account.isEnabled.false" path="account.isEnabled" value="false" />
						<label for="account.isEnabled.any"><fmt:message key="ANY" /></label>
						<form:radiobutton id="account.isEnabled.false" path="account.isEnabled" value="" />
						<form:errors path="account.isEnabled" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="account_addressId" /></th>
					<td>
						<form:select id="homeAddressRestriction" path="homeAddressNullRestriction.restriction" cssClass="number">
							<form:options />
						</form:select>
						<script>
						$('#homeAddressRestriction').change(function() {
							if ($('#homeAddressRestriction option:selected').val() == 'SPECIFIED') { 
								$('#homeAddressLink,#homeAddressLabel').removeAttr('disabled');
								$('#homeAddressLabel').focus();
							} else { 
								$('#homeAddressLink,#homeAddressLabel').attr('disabled', 'disabled'); 
							}
						});
						</script>
						<form:hidden id="homeAddressLink" path="account.homeAddress" />
						<input type="text" id="homeAddressLabel"  size="100">
						<script>
						$(function() {
							$('#homeAddressLabel').autocomplete('destroy');
							$('#homeAddressLabel').autocomplete({
								source: "${pageContext.request.contextPath}/domain/rest/address/autocomplete",
								select: function(event, ui) {
									$('#homeAddressLink').val(ui.item.id);
									$('#homeAddressLabel').val(ui.item.label);
								}
							});
						});
						</script>
						<form:errors path="account.addressId" cssClass="error"/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="button button-search" value="<fmt:message key="crud.search.button" />"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
	<div id="result"/>
</body>
