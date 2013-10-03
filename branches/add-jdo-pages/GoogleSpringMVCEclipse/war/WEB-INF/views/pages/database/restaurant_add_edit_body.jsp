<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />

<c:if test="${not empty stateMessage}">
<h4>${stateMessage}</h4>
</c:if> 

<c:if test="${not empty viewItem.message}">
	<div class="alert alert-info">${viewItem.message}</div>

</c:if>

<form:form id="form" method="post" cssClass="form-horizontal"
	modelAttribute="restaurantBean"
	action="${baseURL}database/simple/restaurant/formProcessRestaurant">
	
	<c:if test="${state}=='EDIT'">
	   <form:hidden  path="id.id" />
	</c:if>
	 
	<table cellpadding="4" cellspacing="4">

		<tr>
			<th>Name</th>
			<td><form:input path="name" size="20" /> <form:errors
					path="name" cssClass="text-error" /></td>
		</tr>
		<tr>
			<th>Version</th>
			<td><form:input path="version" size="20" /> <form:errors
					path="version" cssClass="text-error" /></td>
		</tr>
		<tr>
			<th>Zip Code</th>
			<td><form:input path="zipCode" size="20" /> <form:errors
					path="zipCode" cssClass="text-error" /></td>
		</tr>
		<tr>
			<th>City</th>
			<td><form:input path="city" size="20" /> <form:errors
					path="city" cssClass="text-error" /></td>
		</tr>
		<tr>
			<th>State</th>
			<td><form:input path="state" size="20" /> <form:errors
					path="state" cssClass="text-error" /></td>
		</tr>

		<tr>
			<td><button class="btn-small btn-primary" type="submit">Submit</button></td>
		</tr>
	</table>

</form:form>
<div class="span3">
<a href="${baseURL}database/simple/restaurant/main" class="btn btn-small btn-primary">Restaurant Listing</a>
</div>

