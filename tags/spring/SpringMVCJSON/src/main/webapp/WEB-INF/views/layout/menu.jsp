<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>

			
<c:url var="baseURL" value="/app/" />


<h3><a href="#">Home</a></h3>
	<div class="menuDiv">
		<a href="<c:out value="${baseURL}home.html"/>">Home</a>
		<a href="<c:out value="${baseURL}credits"/>">Credits</a>
	</div>
<h3><a href="#">Spring MVC 3</a></h3>
	<div class="menuDiv">
		<a href="<c:out value="${baseURL}jsondemo.html"/>">JSON Demo</a>
		<a href="<c:out value="${baseURL}getpostdemo/home.html"/>">Get Post	Demo</a>
		<a href="<c:out value="${baseURL}data/standard/home.html"/>">Standard
			Arguments</a>
		<a href="<c:out value="${baseURL}messageconverters/home.html"/>">Processing Input</a>
		<a href="<c:out value="${baseURL}views/html.html" />">Simple Html via JSP</a>
		<a href="<c:out value="${baseURL}tags/demo/home" />">Tag Demo</a>
		<a href="<c:out value="${baseURL}views/nontile.html" />">Non Tile Demos</a>
		<a href="<c:out value="${baseURL}complex/forms/home" />">Complex Forms</a>
		<a href="<c:out value="${baseURL}servlet/functions/home" />">Basic Servlet Functions</a>
	<!--  not supported by the google app engine as it uses java.awt.*
	  
		<a href="<c:out value="${baseURL}image/generator/home" />">Image Generator</a>
	
	-->
		<a href="<c:out value="${baseURL}errors/demo/home" />">Error Handling</a>
		<a href="<c:out value="${baseURL}security/demo/home" />">Security Demo</a>
</div>
<h3><a href="#">JQuery Demos</a></h3>
<div class="menuDiv">
		<a href="<c:out value="${baseURL}jquery/demos/linkedLists" />">Linked Lists</a>
		<a href="<c:out value="${baseURL}jquery/demos/jsonData" />">JSON Data</a>
		<a href="<c:out value="${baseURL}jquery/demos/findingElements" />">Selections</a>
		<a href="<c:out value="${baseURL}jquery/demos/positioning" />">Positioning</a>
		<a href="<c:out value="${baseURL}jquery/demos/pixDisplay" />">JQuery Lightbox</a>
		<a href="<c:out value="${baseURL}jquery/demos/periodicUpdater" />">Periodic Updater</a>
		<a href="<c:out value="${baseURL}jquery/demos/formSamples" />">Form Samples</a>
		<a href="<c:out value="${baseURL}jquery/formSubmission/home" />">Ajax Form Submission</a>
</div>
