<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
 
 <style>
 th
 {
    background-color: #cc9;
    color: #aa0000;
 
 }
 td.editClass
 {
 	border: 3px solid  #cc9;
 
 }
 
 </style>


<h2>
	Add an Office
</h2>
 
<html:errors name="errors" />
 
 
 <html:form action="/office.do" focus="state">
 <table cellpadding="5">
 
 <tr><th>State</th><td class="editClass"><input type="text" id="state" name="state" size="25"/></td></tr>
 <tr><th>City</th><td class="editClass"><input type="text" id="city"  name="city" size="25"/></td></tr>
 <tr><th>Postal code</th><td class="editClass"><input type="text" id="postalcode"  name="postalcode" size="25"/></td></tr>
 <tr><th>Phone</th><td class="editClass"><input type="text" id="phone"  name="phone" size="25"/></td></tr>
 <tr><th>Country</th><td class="editClass"><input type="text" id="country"  name="country" size="25"/></td></tr>
 <tr><th>Territory</th><td class="editClass"><input type="text" id="territory"  name="territory" size="25"/></td></tr>
 <tr><th>Address Line 1</th><td class="editClass"><input type="text" id="addressline1"  name="addressline1" size="25"/></td></tr>
 <tr><th>Address Line 2</th><td class="editClass"><input type="text" id="addressline2"  name="addressline2" size="25"/></td></tr>
 <tr><td colspan="2"><html:submit>Submit</html:submit></td></tr>

 </table>
  </html:form>