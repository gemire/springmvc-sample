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
				XTREE_LISTENERS.transformBase = "transforms/jsdemo/";
				XTREE_LISTENERS.init();
				MESSAGE_PUMP.subscribe(XTREE_LISTENERS.xml_block_refresh,
						XTREE_LISTENERS.ON_REFRESH_EVENT);
				MESSAGE_PUMP.subscribe(XTREE_LISTENERS.selected_list_refresh,
						XTREE_LISTENERS.ON_REFRESH_EVENT);
				

			});
</script>






<div id="tree-content" style="height: 400px"
	class="float-left span6 well">
	<ul class="nav nav-tabs pill" id="myTab">

		<li><a href="/app/backbone/demos/js/model.html#tree-home"
			data-toggle="pill">Tree</a></li>
		<li><a href="/app/backbone/demos/js/model.html#xml"
			data-toggle="pill">Xml</a></li>

	</ul>



	<div class="tab-content">
		<div class="tab-pane active" id="tree-home">

			<div id="tree" class="tree" style="overflow-y: auto; height: 250px"></div>



		</div>
		<div class="tab-pane" id="xml">

			<textarea id="xml_block" rows="15" style="width: 300px"></textarea>


		</div>
	</div>
</div>
 
<div id="right-side" class="float-right span5 well" style="height: 400px"> 
	<div class="panel panel-default"  style="border: thin solid grey; margin:5px; padding:2px">
		<div class="panel-heading"><h4>Selected Items</h4></div>
		<div class="panel-body" style="height: 250px; overflow-y: auto">
	
			<div id="selected_list_items"></div>
		</div>
	</div>
	
	 
	
	<p style="margin-top: 20px">
		Unit tests for the javascript used for developing the tree. <a
			href="<%=basePath%>tree_tests/test.jsp" class="btn small btn-info">QUnit
			Tests</a>
	</p>
</div>



