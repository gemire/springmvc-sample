<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/data/standard/" />

<p>
	This is a collection of demos of standard argument access in
	controllers
</p>

<div>

	<table>
		<tr>
			<td>
				Request Variables
			</td>
			<td>
				<a href="<c:out value="${baseURL}request.html"/>">Go</a>
			</td>
		</tr>
		<tr>
			<td>
				Request Reader
			</td>
			<td>


				<form action="<c:out value="${baseURL}request/reader.html"/>" method="POST" >
					<input class="myButton" type="submit" value="Go" />
				</form>

			</td>
		</tr>
		<tr>
			<td>
				Request InputStream
			</td>
			<td>

				<form action='<c:out value="${baseURL}request/is.html"  />' method="POST" >
					<input class="myButton"  type="submit" value="Go" />
				</form>
			</td>
		</tr>

		<tr>
			<td>
				Response
			</td>
			<td>
					<a href="<c:out value="${baseURL}response.html"/>">Go</a>
				 
			</td>
		</tr>
		<tr>
			<td>
				Session
			</td>
			<td>
					<a href="<c:out value="${baseURL}session.html"/>">Go</a>
				 
			</td>
		</tr>
	</table>


</div>


<c:choose>
	<c:when test="${not empty results}">

		<h3>
			${results.description}
		</h3>
		<div class="resultsClass">
			${results.result}
		</div>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>