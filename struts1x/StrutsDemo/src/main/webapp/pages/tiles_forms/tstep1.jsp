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

<logic:messagesPresent property="step1.invalidCountry">
	<li>forgetting the country is downright jingoistic (using property for specific error message)</li>
</logic:messagesPresent>
<logic:messagesPresent property="step1.invalidState">
	<li>State is required</li>
</logic:messagesPresent>


</ul>
</div>

</logic:messagesPresent>

<html:form action="/demoFormAction.do" focus="city">
	<html:hidden property="step" value="step2" />

	<table border="0" cellpadding="5" cellspacing="5">
		<tr>
			<th class="right">
				City:
			</th>
			<td class="left">
				<html:text property="city" size="16" />
			</td>
		</tr>

		<tr>
			<th class="right">
				Country:
			</th>
			<td class="left">

				<html:select property="country">
					<html:option value="0">Select Country</html:option>
					<html:optionsCollection name="demoForm" property="countryList"
						label="label" value="value" />


				</html:select>
			</td>
		</tr>
		<tr>
			<th class="right">
				State:
			</th>
			<td class="left">
				<html:radio name="demoForm" property="state" value="CA">CA</html:radio>
				<html:radio name="demoForm" property="state" value="NV">NV</html:radio>
				<html:radio name="demoForm" property="state" value="KY">KY</html:radio>

				</td>
		</tr>

		<tr>
			<th class="right">
				Phone:
			</th>
			<td class="left">
				<html:text property="phone" size="16" />
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


