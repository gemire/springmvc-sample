<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />


<form:form id="form" method="post" cssClass="form-horizontal"
	modelAttribute="formBean" action="${baseURL}complex/forms/addForm">
	<div>

		<c:if test="${not empty message}">
			<div id="message" class="${message.type}">${message.text}</div>
		</c:if>
		<s:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="text-error">Form has errors</div>
			</c:if>
		</s:bind>


	</div>
	<table cellpadding="4" cellspacing="4">

		<tr>
			<th>Name</th>
			<td><input size="20" /></td>
		</tr>
		<tr>
			<th>Version</th>
			<td><input size="20" /></td>
		</tr>
		<tr>
			<th>Zip Code</th>
			<td><input size="20" /></td>
		</tr>
		<tr>
			<th>City</th>
			<td><input size="20" /></td>
		</tr>
		<tr>
			<th>State</th>
			<td><input size="20" /></td>
		</tr>

		<tr>
			<td><button class="btn-small btn-primary" type="submit">Submit</button></td>
		</tr>
	</table>

</form:form>