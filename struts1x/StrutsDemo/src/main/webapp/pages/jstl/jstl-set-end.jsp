<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
 
<p>these also use the EL Expression Language to access the values</p>

  <ul>
  <li><b>Info:</b>   <c:out value="${info}" /></li>
  <li><b>Info 2:</b> <c:out value="${info2}" /></li>
  
  </ul>
  
  <p>The scoped beans can be removed from the session using <b>c:remove</b></p>
 

   <c:remove var="info" scope="session" />
    <c:remove var="info2" scope="session" />
    
    
    <ul>
  <li><b>Info:</b>   <c:out value="${info}"  default="info var gone"  /></li>
  <li><b>Info 2:</b> <c:out value="${info2}"  default="info2 var gone" /></li>
  
  </ul>
  
  
   <bean:define id="blockTitle" name="blockTitle"   type="java.lang.String"/>
   <p>Block Title from tiles def for this page: <c:out value="${blockTitle}" /></p>
   
   
   <bean:define id="sampleButtons" name="sampleButtons" type="java.util.List" />
   
 
   
   <h3>Iteration using a counter or number for loop</h3>
   
   <ul>
   <c:forEach var="b" begin="0" end="15" step="5">

   <li><c:out value="${b}"></c:out></li>
		
   </c:forEach>
   </ul>
   
     <h3>Iteration using the sampleButtons collection (see the tiles def for this page)</h3>
    <bean:define id="c1" value="label.button.c1"/>
    <% String testVar = "label.button.c2"; %>
   <ul>
   <c:forEach items="${sampleButtons}" var="b" >
	   <li>
		   	<ul>
		   		<li>link: <c:out value="${b.link}" /></li>
		   	    <li>value: <c:out value="${b.value}" /></li>
		   	    <li>show if equal: <c:out value="${b.showIfEqualValue}"  /></li>
		   	    
		   	    
		   	    <logic:notEmpty   name="b" property="showIfEqualProperty" > 
		   	    <li>
    				contingent 
    			</li>
    			</logic:notEmpty>
    			
		   	    <logic:equal value="<%= testVar %>"  name="b" property="value" > 
		   	    <li>
    				This entry has a value of '<%= testVar %>' as determined by a <b>logic:equal</b> tag 
    				using a scriptlet entry
    			</li>
    			</logic:equal>
		   	    
		   	    <logic:equal value="${c1}"  name="b" property="value" > 
		   	    <li>
    				This entry has a value of '${c1}' as determined by a <b>logic:equal</b> tag using a bean ref
    			</li>
    			</logic:equal>
		   	    
		   	    <li>role: <c:out value="${b.role}" /></li>
		   	</ul>
	    </li>
   </c:forEach>
   </ul>
   
   
   
     <logic:iterate id="a" name="sampleButtons" type="com.dhenton9000.strutsdemo.sample.ButtonItem" >
     
     <logic:empty name="a" property="showIfEqualProperty" > 
     <c:out value="${a.role}" />
    </logic:empty>
     
    </logic:iterate>
   
   
   <p>The sampleButtons list was set up in the 'tiles.jstl.set.end' tiles definition.
   
   
      </p>
   
   