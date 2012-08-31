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
	Simple display of Products
</h2>
<%-- http://displaytag.sourceforge.net/ --%>
<display:table name="itemDisplay"  class="tableClass"  >
	<display:column property="productcode" title="Code" headerClass="headerClass"/>
	<display:column property="productname" title="Name" headerClass="headerClass"/>
	<display:column property="productdescription" title="Description" headerClass="headerClass"/>
	<display:column property="productvendor" title="Vendor"  headerClass="headerClass"/>
	 

</display:table>

