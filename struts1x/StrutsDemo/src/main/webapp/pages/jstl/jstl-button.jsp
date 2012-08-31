<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<bean:define id="sampleButtons" name="sampleButtons"
	type="java.util.List" />
<c:set scope="request" var="dateSample"
	value="<%= new java.util.Date() %>" />

<p>
	Using the format tags to format a date:
</p>
<ul>
	<li>
		<fmt:formatDate value="${dateSample}" pattern="yyyy/MM/dd" />
		(pattern)
	</li>
	<li>
		<fmt:formatDate value="${dateSample}" dateStyle="short" />
		(dateStyle)
	</li>
</ul>


<h4>
	Sample button collection rendered straight:
</h4>

<ul>
<logic:iterate id="a" name="sampleButtons"
	type="com.dhenton9000.strutsdemo.sample.ButtonItem">


	<li>
	<button type="button" class="action"
		id="action.<bean:write name="a" property="value" />"
		onClick="alert('Link: '+'<bean:write name="a" property="value"  />' )">
		<bean:write name="a" property="showIfEqualProperty" />
	</button>
	</li>
</logic:iterate>
</ul>
<h4>
	Some conditional rendering
</h4>


<logic:iterate id="a" name="sampleButtons"
	type="com.dhenton9000.strutsdemo.sample.ButtonItem">
<bean:define id="p" name="a" property="showIfEqualValue"/>

    Show if Equal Value: <bean:write name="p"   /><br/>
    
    <logic:equal name="a" property="showIfEqualValue" value="true">
    <button type="button" class="action"
		id="action.<bean:write name="a" property="value" />"
		onClick="alert('Link: '+'<bean:write name="a" property="value"  />' )">
		<bean:write name="a" property="showIfEqualProperty" />
	</button><br/>
    </logic:equal>
    
    

</logic:iterate>

<br />
xxxxxxxxx
