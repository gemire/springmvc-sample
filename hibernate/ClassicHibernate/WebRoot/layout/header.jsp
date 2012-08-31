<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

 

<ul id="nav">
	<li>
		<html:link page="/">Home</html:link>
	</li>
	<li><a href="#">Simple Displays</a>
		<ul>
			<li>
				<html:link page="/simple.do?operation=simpleProductDisplay">Products</html:link>
			</li>
			<li>
				<html:link page="/simple.do?operation=simpleEmployeeDisplay">Employees</html:link>
			</li>
			<li>
				<html:link page="/simple.do?operation=simpleOfficeDisplay">Offices</html:link>
			</li>
		</ul>
	</li>
	<li>
		
	</li>
	 
	<li><a href="#">Office Maintenance</a>
		<ul>
			<li>
				<html:link page="/main.do?operation=addOffice">Add an Office</html:link>
		 	</li>
		</ul>
	</li>
	 
</ul>



