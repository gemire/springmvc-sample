<%@ page language="java" import="java.util.*;" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<tiles:importAttribute />
<tiles:useAttribute name="buttonBundleName"  classname="java.lang.String" scope="tile" />
<fmt:setBundle basename="<%= buttonBundleName %>"/>

<br/>This demonstrates the passing of parameters from the layout into included pages 
via the tiles def buttonBundleName is set in /pages/putList/layout.jsp 

<ul>

<li>Bundle Name: ${buttonBundleName}</li>

<logic:iterate id="a" name="sampleButtons"
	type="com.dhenton9000.strutsdemo.sample.ButtonItem">
	<li>
		<button type="button" class="action"
			id="action.<bean:write name="a" property="value" />"
			onClick="alert('Label from bundle: '+'<fmt:message key="${a.value}"/>' )">
			<bean:write name="a" property="showIfEqualProperty" />
		</button>
	</li>
</logic:iterate>
</ul>