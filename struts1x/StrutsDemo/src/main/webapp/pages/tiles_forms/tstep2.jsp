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
<html:errors  prefix="errors.prefix" suffix="errors.suffix"  header="errors.header"/>


<logic:messagesPresent property="step2.invalidDate">
	<li>Date Required</li>
</logic:messagesPresent>

</ul>
</div>

</logic:messagesPresent>

<html:form action="/demoFormAction2.do" focus="paymentDate">
	<html:hidden property="step" value="step3" />

	<table border="0" cellpadding="5" cellspacing="5">
		<tr>
			<th class="right">
				Payment Date:
			</th>
			<td class="left">
				<html:text property="paymentDate" size="16" />
			</td>
		</tr>

		<tr>
			<th class="right">
				Product Types:
			</th>
			<td class="left">
				<logic:iterate name="demoForm" id="var" property="productTypes">
					<html:multibox property="selectedProductTypes">
						<bean:write name="var" property="value" />
					</html:multibox>
					<bean:write name="var" property="label" />
				</logic:iterate>


			</td>
		</tr>


		<tr>
			<th class="right">
				Customer Number:
			</th>
			<td class="left">
				<html:text property="customerNumber" size="4" />
			</td>
		</tr>
		<tr>
			<th class="right">
				Product Name:
			</th>
			<td class="left">
				<html:text property="productName" size="25" />
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



