<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div>
<ul>
	<li>
		A cset tag sets a string variable in session called "info" which will
		be picked up on the next page
	</li>
	<li>
		Variable "info2" was set using text in the body of the tag
	</li>
</ul>
</div>

<c:set var="info" scope="session" value="information" />

<c:set var="info2" scope="session">Information 2</c:set>


<p>
<html:link module="" action="/jstlSetEnd">Next</html:link>
</p>