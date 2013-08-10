<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/" />


This page demonstrates various servlet functions
<br />
<p>
	See
	<a
		href="http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-arguments">
		http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping-arguments</a>
	for more details.
</p>
<div class="leftColumn">
<div class="column  header1">Cookies</div>
<a href="${baseURL}/servlet/functions/writeCookie">Write the cookie</a> <br/>

Here is a loop over the cookie collection:
<br />


	<%-- Loop over the JSTL cookie implicit object, which is a 
           map. If there are no cookies, the <c:forEach> action
           does nothing. --%>
   <h3>List of cookies</h3>
	<c:forEach items='${cookie}' var='mapEntry'>
		<ul>
			<%-- The mapEntry's key references the cookie name --%>
			<li>
				Cookie Name:
				<c:out value='${mapEntry.key}' />
			</li>

			<%-- The mapEntry's value references the Cookie
                 object, so we show the cookie's value --%>
			<li>
				Cookie Value:
				<c:out value='${mapEntry.value.value}' />
			</li>
		</ul>
	</c:forEach>
<h3>Single Access</h3> <b>${cookie["cookieKey"].value}</b>
	
	

</div>	
	
	

<div class="rightColumn">


<div class="column  header1">Request Parameters</div>
<h3>Path Variable as Parameters (REST style)</h3>
<a href="${baseURL}/servlet/functions/parms/elmo">Click to call parmId of 'elmo'</a>
<br/>
Parm: <b>${parmId}</b>
 
<h3>Request Variables as Parameters</h3>
<a href="${baseURL}/servlet/functions/requestParms?age=35&name=bozo">Click to send parameters to controller function</a>
<br/>
Parm: <b>${paramInfo}</b>
</div>
	