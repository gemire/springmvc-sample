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

<html:form   action="/dynaFormAction.do" focus="candidateName">
	
	<table border="0" cellpadding="5" cellspacing="5">
		<tr>
			<th class="right">
				  Candidate Name:
			</th>
			<td class="left">
				<html:text property="candidateName" size="30" />
			</td>
		</tr> 

		<tr>
			<th class="right">
				 Affiliation:
			</th>
			<td class="left">
				
				<span class="spacerClass"><html:multibox value="Republican" property="affiliation" />Republican</span>
	     		<span class="spacerClass"><html:multibox value="Democrat" property="affiliation" />Democrat</span>
	     		<span class="spacerClass"><html:multibox value="Tea Party" property="affiliation" />Tea Party</span>
	     		<span class="spacerClass"><html:multibox value="Communist" property="affiliation" />Communist</span>
				
				
			</td>
		</tr>

		<tr>
			<th class="right">
				Age:
			</th>
			<td class="left">
				<html:select property="candidateAge">
				<html:option value="25">25-35</html:option>
				<html:option value="36">36-45</html:option>
				<html:option value="46">46-50+</html:option>
				</html:select>
			</td>
		</tr>
				<tr>
			<th class="right">
				Gender:
			</th>
			<td class="left">
				<span class="spacerClass"><html:radio property="candidateGender" value="F">Female</html:radio></span>
				<span class="spacerClass"><html:radio property="candidateGender" value="M">Male</html:radio></span>
				<span class="spacerClass"><html:radio property="candidateGender" value="D">Dubious</html:radio></span>
				 
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


