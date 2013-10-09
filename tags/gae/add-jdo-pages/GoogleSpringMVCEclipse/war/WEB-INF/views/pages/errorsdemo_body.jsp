<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />

<p></p>

<form:form method="post" cssClass="form-horizontal"  modelAttribute="errorInfo"  action="${baseURL}errors/demo/submitError">
<form:input path="errorValue" /> <input class="btn-larg btn-primary" type="submit" value="Submit Error" />
</form:form>




<c:choose>
	<c:when test="${not empty resultMessage}">


		<div class="row span12">
			${resultMessage}
		</div>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>
