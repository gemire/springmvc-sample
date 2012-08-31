<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

 
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()+path+"/";
%>


 
 
 <table width="55%" cellpadding="5" cellspacing="5">
 
 <tr><td width="10%" class="itemClass">City:</td><td><bean:write name="demoForm" property="city" /></td></tr>
 <tr><td  width="10%" class="itemClass">Country:</td><td><bean:write name="demoForm" property="country" /></td></tr>
 <tr><td  width="10%" class="itemClass">Phone:</td><td><bean:write name="demoForm" property="phone" /></td></tr>
 <tr><td  width="10%" class="itemClass">State:</td><td>
 <logic:match name="demoForm"  property="state"  value="CA">California</logic:match>
 <logic:match name="demoForm"  property="state"  value="KY">Kentucky</logic:match>
 <logic:match name="demoForm"  property="state"  value="NV">Nevada</logic:match>
 </td></tr>

  <tr><td width="10%" class="itemClass">Payment Date:</td><td><bean:write name="demoForm" property="paymentDate" /></td></tr>
 <tr><td width="10%" class="itemClass">Customer Number:</td><td><bean:write name="demoForm" property="customerNumber" /></td></tr>
 
 <tr><td  width="10%" class="itemClass">Product Types:</td><td>
 
 <logic:empty name="demoForm"  property="selectedProductTypes">
 </logic:empty>
 <logic:notEmpty name="demoForm"  property="selectedProductTypes">
 <ul>
 <logic:iterate id="type" name="demoForm"  property="selectedProductTypes">
   <li><bean:write name="type"  /></li>
  </logic:iterate>
  </ul>
  </logic:notEmpty>
 
 </td></tr>
 
 <tr><td colspan="2"><html:link title="multi part forms" forward="global.step1.tiles" >Step 1</html:link></td></tr>  
    

    
 </table>   
    
 