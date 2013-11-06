<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />

<form:form method="post" modelAttribute="contact"  commandName="contact"  action="${baseURL}forms/addContact">
	<table>
		<tr>
			<td>
				<form:label path="firstname">First Name</form:label>
			</td>
			<td>
				<form:input path="firstname" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastname">Last Name</form:label>
			</td>
			<td>
				<form:input path="lastname" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastname">Email</form:label>
			</td>
			<td>
				<form:input path="email" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="lastname">Telephone</form:label>
			</td>
			<td>
				<form:input path="telephone" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="myButton" type="submit" value="Add Contact" />
			</td>
		</tr>
	</table>
</form:form>
<h4>Validation</h4>
<ul>
			<li>
				<a id="validateNoErrors" class="textLink" href="<c:url value="/app/forms/validate?number=3&date=2029-07-04" />">Validate, no errors</a>
			</li>
			<li>
				<a id="validateErrors" class="textLink" href="<c:url value="/app/forms/validate?number=3&date=2010-07-01" />">Validate, errors</a>
			</li>
</ul>
