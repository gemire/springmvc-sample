<%@page language="java"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>

<html:xhtml/>
<tiles:importAttribute scope="request"/>
<bean:define id="action" name="action" type="java.lang.String" />
<bean:define id="focus" name="focus" type="java.lang.String" />
<bean:define id="enctype" name="enctype" type="java.lang.String" />
<%// bind the java script doAction function to the form %> 
 <bean:struts id="mapping" mapping="<%= action %>" />
 <bean:define id="formName" name="mapping" property="name" type="java.lang.String"/>

<html:form action="<%= action %>" enctype="<%= enctype %>">

<html:hidden property="method"/>

<div>
 <logic:present name="message">
  <span class="status"><bean:message name="message"/></span>
 </logic:present>
 <tiles:insert attribute="preamble">
 </tiles:insert>
 <tiles:insert attribute="content" >
  <tiles:put name="action" beanName="action" beanScope="tile"/>
 </tiles:insert>
 <tiles:insert attribute="postamble">
 </tiles:insert>
 <logic:present name="receiptContent" >
    <logic:notEmpty name="receiptContent" >
      <tiles:insert name="receiptContent" />
    </logic:notEmpty>
   </logic:present>
 </div> 
<div>com.dhenton9000.strutsdemo.sample
  <logic:iterate id="a" name="actions" type="com.dhenton9000.strutsdemo.sample.ButtonItem" >
    <%-- Determine if we should show the button based on property settings --%>
    <logic:notEmpty name="a" property="showIfEqualProperty" > 
      <bean:define id="p" name="<%= formName %>" property="<%= a.getShowIfEqualProperty() %>"/>
    </logic:notEmpty>

    <logic:empty name="a" property="showIfEqualProperty" > 
      <bean:define id="p" name="a" property="showIfEqualValue"/>
    </logic:empty>
    
    <%-- Determine if user can edit payments 
    <logic:present name="a" property="role">
    	<bean:define id="hasAccess" value="<%=a.hasAccess(request) %>"/>
    </logic:present>
    <logic:notPresent name="a" property="role">
    	<bean:define id="hasAccess" value="true"/>
    </logic:notPresent>
--%>
    <%-- Determine if we should show the button if the page has errors --%>
    <logic:present name="org.apache.struts.action.ERROR">
      <bean:define id="showWithErrors" name="a" property="showIfErrors"/>
    </logic:present>
    
    <logic:notPresent name="org.apache.struts.action.ERROR">
        <bean:define id="showWithErrors" value="true"/>
    </logic:notPresent>

	<%-- Determine if we should provide an alternate Previous button link --%>
	<logic:equal name="a" property="alternatePreviousEnabled" value="true" >
	  <bean:define id="previousLink" name="<%= formName %>" property="alternatePreviousLink"/>
	</logic:equal>
	<logic:notEqual name="a" property="alternatePreviousEnabled" value="true" >
	  <bean:define id="previousLink" value=""/>
	</logic:notEqual>

    <%-- insert a line break if needed. --%>
    <logic:equal name="a" property="startNewLine" value="true">
      <br/>
    </logic:equal>
 
    <%-- Finally print the button if the logic allows --%>
    <logic:equal name="p" value="<%= a.getShowIfEqualValue() %>">
     <logic:equal name="showWithErrors" value="true">
      <logic:equal name="hasAccess" value="true">
       <logic:empty name="previousLink">
       <button type="button" class="action"
       	id="action.<bean:write name="a" property="value" />"
        onClick="doAction( this.form, <bean:write name="a" property="link" /> )">
         <bean:message key="<%= a.getValue() %>" />
       </button>
       </logic:empty>
       <logic:notEmpty name="previousLink">
        <button type="button" class="action"
       	 id="action.<bean:write name="a" property="value" />"
         onClick="doAction( this.form, <bean:write name="previousLink" /> )">
          <bean:message key="<%= a.getValue() %>" />
        </button>
       </logic:notEmpty>
      </logic:equal>
      <logic:notEqual name="hasAccess" value="true">
       <input type="hidden" id="action.<bean:write name="a" property="value" />"/>
      </logic:notEqual>
     </logic:equal>
     <%-- We need to create a hidden field in case focus was set to this to prevent a javascript error. --%>
     <logic:equal name="showWithErrors" value="false">
      <input type="hidden" id="action.<bean:write name="a" property="value" />"/>
     </logic:equal>
    </logic:equal>
    <logic:notEqual name="p" value="<%= a.getShowIfEqualValue() %>">
        <input type="hidden" id="action.<bean:write name="a" property="value" />"/>
    </logic:notEqual>
  </logic:iterate>
</div>

<script type="text/javascript" language="JavaScript">
doFocus("<%= focus %>", "<%= formName %>");
</script>

</html:form>
