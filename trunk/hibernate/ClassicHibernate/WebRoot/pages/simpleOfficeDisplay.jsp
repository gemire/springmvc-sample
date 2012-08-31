<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<%--
<jsp:useBean id="productDisplay" scope="request" class="java.util.ArrayList" type="java.util.ArrayList" />
--%>




<h2>
	Simple display of Offices
</h2>
<%-- http://displaytag.sourceforge.net/ --%>
<display:table name="itemDisplay"  class="tableClass"  >
	<display:column property="officecode" title="Code" headerClass="headerClass"/>
	<display:column property="city" title="City" headerClass="headerClass"/>
	<display:column property="state" title="State" headerClass="headerClass"/>
	<display:column property="country" title="Country"  headerClass="headerClass"/>
	 <display:column property="phone" title="Phone"  headerClass="headerClass"/>

</display:table>

