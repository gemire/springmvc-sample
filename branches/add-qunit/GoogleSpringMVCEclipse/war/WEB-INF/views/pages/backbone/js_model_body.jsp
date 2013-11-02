<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/app";
%>
<link rel="stylesheet" href="css/backbone/jsdemo.css" media="screen">

<script>
	$(document).ready(function() {
		XTree.init({
			"attachmentPoint" : "tree",
			"transformBase" : "transforms/jsdemo/",
			"urlBase" : "<%=basePath %>/rest/categories"
		});
		XTree.getLevel1DataForGroup(3);
		$('#tree').html(XTree.toHtml());

	});
</script>

 
<div id="tree" class="span6 tree well"
	style="overflow-y: auto; height: 250px">
	
	</div>