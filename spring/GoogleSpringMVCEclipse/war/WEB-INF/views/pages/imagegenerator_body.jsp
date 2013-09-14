<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />


<div class="leftColumn">
<div class="column  header1">Using Response Body Converter</div>
<img src="${baseURL}image/generator/getImageBuffer" />
</div>

<div class="rightColumn">
<div class="column  header1">Using Response</div>
<img src="${baseURL}image/generator/getImage" />
</div>

 