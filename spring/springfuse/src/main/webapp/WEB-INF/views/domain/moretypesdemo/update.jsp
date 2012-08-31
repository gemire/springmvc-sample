<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/update.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="moreTypesDemo" />: <fmt:message key="crud.functionalities.update" /></title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/domain/moretypesdemo/search" class="ajaxy button button-search"><fmt:message key="moreTypesDemo" /></a>
	<a href="${pageContext.request.contextPath}/domain/moretypesdemo/show/${moreTypesDemo.primaryKey}" class="ajaxy button button-show"><fmt:message key="crud.show.button" /></a>
	<span class="ui-state-highlight button button-edit"><fmt:message key="crud.edit.button" /></span>
	<a href="${pageContext.request.contextPath}/domain/moretypesdemo/delete/${moreTypesDemo.primaryKey}" class="modal button button-delete"><fmt:message key="crud.delete.button" /></a>

	<form:form action="${pageContext.request.contextPath}/domain/moretypesdemo/update/${moreTypesDemo.primaryKey}" modelAttribute="moreTypesDemo" method="POST">
		<form:errors cssClass="error"/>
		<form:hidden path="moreTypesDemoId"/>
		<form:hidden path="version"/>
		<table class="edit">
			<tbody>
				<tr>
					<th><fmt:message key="moreTypesDemo_numberInt" /></th>
					<td>
						<form:input path="numberInt" cssClass="number"/>
						<form:errors path="numberInt" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_numberLong" /></th>
					<td>
						<form:input path="numberLong" cssClass="number"/>
						<form:errors path="numberLong" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_numberDouble" /></th>
					<td>
						<form:input path="numberDouble" cssClass="number"/>
						<form:errors path="numberDouble" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_numberFloat" /></th>
					<td>
						<form:input path="numberFloat" cssClass="number"/>
						<form:errors path="numberFloat" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_numberBigInteger" /></th>
					<td>
						<form:input path="numberBigInteger" cssClass="number"/>
						<form:errors path="numberBigInteger" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_numberBigDecimal" /></th>
					<td>
						<form:input path="numberBigDecimal" cssClass="number"/>
						<form:errors path="numberBigDecimal" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_dateJavaTemporalDate" /></th>
					<td>
						<form:input path="dateJavaTemporalDate" cssClass="datepicker" size="11"/>
						<form:errors path="dateJavaTemporalDate" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_dateJavaTemporalTimestamp" /></th>
					<td>
						<form:input path="dateJavaTemporalTimestamp" cssClass="datepicker" size="11"/>
						<form:errors path="dateJavaTemporalTimestamp" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_dateJoda" /></th>
					<td>
						<form:input path="dateJoda" cssClass="datepicker" size="11"/>
						<form:errors path="dateJoda" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="moreTypesDemo_dateTimeJoda" /></th>
					<td>
						<form:input path="dateTimeJoda" cssClass="datepicker" size="11"/>
						<form:errors path="dateTimeJoda" cssClass="error"/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="button button-save" value="<fmt:message key="crud.save.button" />" />
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
</body>
