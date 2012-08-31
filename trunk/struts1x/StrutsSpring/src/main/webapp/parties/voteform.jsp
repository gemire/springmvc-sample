<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
</head>
<body>
<h1>Voting Form</h1>
<h3>Enter your option</h3>


<p><html:form action="/vote.do">

	<table width="50%" height="30%" cellpadding="5">

		<tr>
			<td>option:</td>
			<td><html:select property="party">
				<html:option value="democrat">Democrat</html:option>
				<html:option value="republican">Republican</html:option>
				<html:option value="independent">Independent</html:option>

			</html:select></td>
		</tr>

		<tr>
			<td colspan="2"><html:submit>Here's my party!!</html:submit></td>
		</tr>
	</table>




</html:form></p>

</body>
</html>