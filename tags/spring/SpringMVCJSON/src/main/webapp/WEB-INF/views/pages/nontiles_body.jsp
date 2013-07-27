<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/views/" />

<p>
	These items demonstrate setting various parts of the response such as
	headers. These will require using the back button to get to the menu
</p>

 <ul>
 
 <li>
 <a href="<c:url value="/app/data/standard/response/writer.html" />">Response Writer</a>
 
 </li>
 <li>
 <a href="<c:url value="/app/data/standard/response/os.html" />">Response Writer via Outputstream</a>
 
 </li>
 <li>
 <a href="<c:url value="/app/response/entity/status.html" />">Custom status code</a>
 
 </li>
 
 <li>
 <a href="<c:url value="/app/response/entity/headers.html" />">Custom header code</a>
 
 </li>
 
 <li>
 <a href="<c:url value="/app/response/annotation.html" />">Custom annotations</a>
 
 </li>
 </ul>