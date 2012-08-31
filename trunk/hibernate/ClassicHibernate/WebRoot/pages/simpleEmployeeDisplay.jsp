<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>


<h2>
	Simple display of Employees
</h2>
<%-- http://displaytag.sourceforge.net/ --%>
<display:table name="itemDisplay"  class="tableClass"  >
	<display:column property="firstname" title="First Name" headerClass="headerClass"/>
	<display:column property="lastname" title="Last Name" headerClass="headerClass"/>
	<display:column property="email" title="Email" headerClass="headerClass"/>
	<display:column property="jobtitle" title="Job Title"  headerClass="headerClass"/>
	 

</display:table>

