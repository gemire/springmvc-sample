<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<base href="<%=basePath%>" />


<link rel="stylesheet" href="css/bootstrap.min.css" media="screen">
<!--  
<link rel="stylesheet" href="css/bootstrap-responsive.min.css"
	media="screen">
-->

<style type='text/css'>
.row-separate {
	padding-top: 5px;
	padding-bottom: 5px;
}

body {
	padding-top: 40px;
	/* 40px to make the container go all the way to the bottom of the topbar */
	background: url('<%=basePath%>img/background.png')
}

.container {
	width: 820px;
}
/* downsize our container to make the content feel a bit tighter and more cohesive. 
            NOTE: this removes two full columns from the grid, meaning you only go to 14 columns and not 16. */
.content {
	background-color: #fff;
	padding: 20px;
	margin: 0 -20px;
	/* negative indent the amount of the padding to maintain the grid system */
	-webkit-border-radius: 0 0 6px 6px;
	-moz-border-radius: 0 0 6px 6px;
	border-radius: 0 0 6px 6px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .15);
	z-index: -150;
}

.page-header {
	background-color: #f5f5f5;
	padding: 20px 20px 10px;
	margin: -20px -20px 20px;
}
</style>
  <script>
            
            g_restaurantUrlBase = "<%= basePath %>"+"app/backbone/restaurant/";
        </script>
  <script src="http://code.jquery.com/jquery.js"></script> 
<script src="js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="js/angular/restaurant/libs/angular.js/angular.js"
	type="text/javascript"></script>
<link href="css/angular/angular_restaurant.css" rel="stylesheet"
	type="text/css" />



</head>
<body>

	<div class='container'>
		<div class="content">


			<div class="page-header">
				<div class='row-fluid'>
					<div class='pull-left'>
						<h1>
							<small> <tiles:getAsString name="subTitle" />
							</small>
						</h1>
					</div>

					<div class='pull-right'>


						<a href="#explainModal" role="button" class="btn large btn-info"
							data-toggle="modal">Explain</a>


					</div>
				</div>


			</div>

			<div id="menu">
				<tiles:insertAttribute name="menu" />
			</div>

			<div id='content' class='row'>
				 
					<tiles:insertAttribute name="body" />
				 
			</div>

			<div id="explainModal" class="modal hide fade" tabindex="-1"
				role="dialog" aria-labelledby="explainModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="explainModalLabel">Explanation:</h3>
				</div>
				<div style="max-height: 200px" class="modal-body">

					<tiles:insertAttribute name="explainPanel" />
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" data-dismiss="modal"
						aria-hidden="false">Close</button>

				</div>
			</div>


			<tiles:insertAttribute name="footer" />
			
		</div>
		<!-- end content -->
	</div>
        
        <script src="js/angular/restaurant/libs/angular.js/angular-resource.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/app.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/messagePump.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/services/restaurantDAOService.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/services/reviewDAOService.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/services/messageFactory.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/services/reviewFactory.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/services/restaurantFactory.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/controllers/listRestaurantController.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/controllers/editRestaurantController.js" type="text/javascript"></script>
        <script src="js/angular/restaurant/app/controllers/reviewController.js" type="text/javascript"></script>

</body>

</html>
