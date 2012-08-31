<%@ page language="java" import="java.util.*;" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

 

<tiles:importAttribute/>
<p>
 <b>body 4</b> this was inserted using 
 <i>&lt;put name="body4"   value="/moduleB/body4.do" /&gt;</i> in the tiles def.
 See tiles-def tiles.moduleb.putlist.default in module B</p>


 