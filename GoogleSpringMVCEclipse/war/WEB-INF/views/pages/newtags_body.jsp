<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:url var="baseURL" value="/app/" />

<p>Demonstration of using the tag system which does not involve tag-libs</p>

<tags:demo  repeat="10" items="${items}" url="fred" />

