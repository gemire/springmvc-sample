<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />

<p>
	Get Post Demo
</p>

<c:choose>
	<c:when test="${not empty message}">${message}</c:when>
	<c:otherwise>
		<p>
			This is from a get and/or the home page, note that the action for the form
			below cannot be reached by a GET
		</p>
		<div>
		<form method="post" action="${baseURL}getpostdemo/post.html">
			<input class="myButton" type="submit" value="Submit this form via post" />
		</form>
		</div>
		
		<h4>This should fail</h4>
		
		<div>
		<form method="get" action="${baseURL}getpostdemo/post.html">
			<input class="myButton" type="submit" value="Submit this form via get" />
		</form>
		</div>

	</c:otherwise>
</c:choose>