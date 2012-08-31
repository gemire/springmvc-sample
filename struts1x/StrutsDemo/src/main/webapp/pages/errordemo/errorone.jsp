<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>


<logic:messagesPresent>

<div class="errorClass">
<ul>
<html:errors   prefix="errors.prefix" suffix="errors.suffix"  header="errors.header"/>

</ul>
</div>

</logic:messagesPresent>

<html:form action="/errorDemoFormAction.do" focus="clownName">
	<html:hidden property="step" value="step2" />

	<table border="0" cellpadding="5" cellspacing="5">
		<tr>
			<th class="right">
				Clown Name:
			</th>
			<td class="left">
				<html:text property="clownName" size="30" />
			</td>
		</tr>

		
		<tr>
			<td class="right">
				<html:submit>
               Submit
            </html:submit>
			</td>
			<td class="right">
				<html:reset>
                Reset
            </html:reset>
			</td>
		</tr>
	</table>

</html:form>


