<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />

<c:if test="${not empty message}">
	<div class="alert alert-info">${message}</div>

</c:if>

<div class="alert alert-warning">This action deletes all previous data</div>
<div class="span5">
<a  href="${baseURL}/database/restaurant/load/load"  style="margin: 5px;padding: 5px" class="btn  btn-primary">Load Restaurant Sample Data</a>

</div>
 