<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />

<a  href="${baseURL}database/simple/restaurant/add"  style="margin: 5px;padding: 5px" class="span3 btn btn-small btn-primary">Add New Restaurant</a>


<c:if test="${not empty viewItem.restaurants}">

	<div  style="margin: 5px;padding: 5px;overflow-y:scroll;height:300px" class="span12 well">

		<table class="table  table-bordered">

			<tr>
				<th>Name</th>
				<th>City</th>
				<th>State</th>
				<th>Zip Code</th>
				<th>Version</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${viewItem.restaurants}" var="r">
				<tr>
					<td>${r.name}</td>
					<td>${r.city}</td>
					<td>${r.state}</td>
					<td>${r.zipCode}</td>
					<td>${r.version}</td>
					<td><a href="${baseURL}database/simple/restaurant/edit?restaurantId=${r.id.id}">Edit</a></td>
					<td><a href="${baseURL}database/simple/restaurant/delete?restaurantId=${r.id.id}">Delete</a></td>
				</tr>

			</c:forEach>


		</table>
	</div>
</c:if>
