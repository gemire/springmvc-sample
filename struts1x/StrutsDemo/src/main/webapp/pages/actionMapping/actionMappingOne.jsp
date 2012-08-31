<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>

div.spacer
{
 margin: 5px;

}

</style>

<bean:struts id="mapping"   mapping="/actionMappingOne"  /> 
<bean:define id="demoMap" name="mapping" property="demoMap" />

<div class="spacer">
Information from the bean struts tag: <b>${mapping.sharedInformation}</b>
</div>
<div class="spacer">
	The action mapping class is passed into the execute method of the
	struts action. It contains the standard mappings listed in the struts
	config action element. It can be overridden by a class that subclasses
	org.apache.struts.action.ActionMapping
</div><br/>
<div class="spacer">
In this case the <i>bean:struts</i> tag in this page exposed the actionMapping for the action named
in the <i>mapping attribute</i>. Thus it exposes the <b>current values</b> of the action Mapping
properties that may be set via the <i>set-property tags of the struts action</i> or inside the
struts action code itself
</div>

<div class="spacer">
Since the ActionMapping is in application scope (defined for all beans) the boolean firstTime
is used to prevent repeated calls
</div>



<div class="spacer">

<table cellspacing="4" cellpadding="4">
	<tr>
		<th class="itemClass">
			Override Scope:
		</th>
		<th class="itemClass">
			Location:
		</th>
	</tr>
	<tr>
		<td  width="20%" class="itemClass">
			Per Action:
		</td>
		<td>
			In the className attribute of the action, this override will only
			apply to the action
		</td>
	</tr>
	<tr>
		<td  width="20%" class="itemClass">
			For all Actions:
		</td>
		<td>
			In the type attribute of the actionMappings item in the
			struts-config.xml file
		</td>
	</tr>

<tr><td colspan="2">


</td></tr>


</table>
</div>



<div class="spacer">
<h4>Information from a map that was defined in the struts-config.xml under name '/actionMappingOne'</h4>
<table cellspacing="4" border="0" cellpadding="4">

<tr><th class="itemClass">Key</th><th class="itemClass">Value</th></tr>

<logic:iterate id="mapItem" name="demoMap">
<tr>
 
<td class="itemClass" ><bean:write name="mapItem" property="key"/></td>

 
<td><bean:write name="mapItem" property="value"/></td>


</tr>   
 
</logic:iterate>
</table>
</div>
