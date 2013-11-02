<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="css/backbone/jsdemo.css" media="screen">

<script>
	$(document).ready(function() {
		XTree.init({
			"attachmentPoint" : "tree",
			"transformBase" : "transforms/jsdemo/",
			"urlBase" : "<%=basePath%>app/rest/categories"
		});
		XTree.getLevel1DataForGroup(3);
		$('#tree').html(XTree.toHtml());

	});
</script>


<div id="tree" class="float-left span6 tree well"
	style="overflow-y: auto; height: 250px"></div>

<div id="tree" class="float-right span4">
	<p>
		<a href="<%=basePath%>tree_tests/test.jsp"
			class="button button-important">QUnit Tests</a>
	</p>
	Unit tests for the javascript used for developing the tree.


</div>
