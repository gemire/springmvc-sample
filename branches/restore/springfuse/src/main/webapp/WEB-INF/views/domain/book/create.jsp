<%--
 | (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/create.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="book" />: <fmt:message key="crud.functionalities.create" /></title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/domain/book/search" class="ajaxy button button-search"><fmt:message key="book" /></a>
	<span class="ui-state-highlight button button-create"><fmt:message key="crud.functionalities.create" /></span>
	<form:form action="${pageContext.request.contextPath}/domain/book/create" modelAttribute="book" method="POST">
		<form:errors cssClass="error"/>
		<form:hidden path="bookId"/>
		<form:hidden path="version"/>
		<table class="create">
			<tbody>
				<c:choose>
				<c:when test="${not empty book.account}">
					<input type="hidden" name="account" value="<spring:eval expression="book.accountId" javaScriptEscape="true"/>" />
				</c:when>
				<c:otherwise>
				<tr>
					<th><fmt:message key="book_accountId" /></th>
					<td>
						<input type="hidden" id="accountLink" name="account" value="<spring:eval expression="book.accountId" javaScriptEscape="true"/>" />
						<input type="text" id="accountLabel" value="<spring:eval expression="book.account" javaScriptEscape="true"/>" size="100">
						<script>
						$(function() {
							$("#accountLabel").autocomplete('destroy');
							$("#accountLabel").autocomplete({
								source: "${pageContext.request.contextPath}/domain/rest/account/autocomplete",
								select: function(event, ui) {
									$("#accountLink").val(ui.item.id);
									$("#accountLabel").val(ui.item.label);
								}
							});
						});
						</script>
						<form:errors path="account" cssClass="error"/>
					</td>
				</tr>
				</c:otherwise>
				</c:choose>
				<tr>
					<th><fmt:message key="book_title" /> <em>*</em></th>
					<td>
						<form:input path="title" cssClass="required {maxlength: 255}" maxlength="255" size="100"/>
						<form:errors path="title" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="book_numberOfPages" /> <em>*</em></th>
					<td>
						<form:input path="numberOfPages" cssClass="number required"/>
						<form:errors path="numberOfPages" cssClass="error"/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="button button-save" value="<fmt:message key="crud.save.button" />"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
</body>
