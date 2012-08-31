<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

 


<%-- this is from com.dhenton9000.strutsdemo.controllers.actions.BeanDemoAction --%>
<bean:define id="actionName" name="actionFromForward"  property="value"   type="java.lang.String" />
<bean:define id="focusName" name="focus"     type="java.lang.String" />
<%-- this exposes a struts mapping as an object http://struts.apache.org/1.2.x/userGuide/struts-bean.html#struts

--%>
 <bean:struts id="mapping" mapping="<%= actionName %>" />


    
    <p>This is from a tiles put for the 'focus' item. See  tiles.beantest def in tiles-def.xml:   <b> <%= focusName  %></b><br/>  
    Its parent tiles contains the 'tiles:importAttribute' tag</p>
    
    
    
    
    <p>This is from a menuItem that was placed by the BeanDemoAction:     <b> <%= actionName  %></b><br/>
    This was used with the 'bean:struts' tag in this page to create a reference to a struts item used below.
    
    </p>
 
      
      <p>This is information from a struts item: <%= mapping.getPath() %> </p>
      
      <p>See source for beantest.jsp for references and walkthru. In order to get the tile
      items exposed to the components the original layout at the top of the inheritance tree
      has to place those items as beans into scope. This is done via the <b>&lt;tiles:importAttribute /&gt; tag</b></p>
      
