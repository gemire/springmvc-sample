<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>




<div style="background-color: #3a87ad; height: 25px; padding: 5px"
	class="span12 pull-left">
	<span class="tableHeader" style="position: relative; left: 20px">Name</span>
	<span class="tableHeader" style="position: relative; left: 300px">City</span>
	<span class="tableHeader" style="position: relative; left: 375px">St.</span>
	<span class="tableHeader" style="position: relative; left: 380px">Zip</span>
	<span class="tableHeader" style="position: relative; left: 385px">Ver.</span>

</div>
<div style="overflow-y: auto; height: 200px" class="well well-small">
	<table id="listPoint" class="table  table-bordered">
		<tbody></tbody>
	</table>
</div>
<div>
	<div class="span12">
		<div id="editArea" class="well well-small  span6 pull-left">

			<div id="restaurantFormViewItems"></div>
			<div>

				<input type="button" id="saveEdits" style="display: none"
					class="btn btn-primary"
					onclick="window.myRestaurantFormView.saveEdits()"
					value="Save Changes" /> <input type="button" id="addRestaurant"
					style="margin: 2px" class="btn btn-primary"
					onclick="window.myRestaurantFormView.addRestaurant()"
					value="Add New Restaurant" />

			</div>
			<div>
				<ul id="errorItems">

				</ul>
			</div>
		</div>
		<div id="ratingsArea" class="span6 pull-right">
			<h4 style="display: inline-block">Ratings</h4>
			<button id="addReviewButton"
				onclick="window.myRatingsListView.addReview()" style="display: none"
				class='btn btn-small btn-primary'>
				<i class="icon-pencil icon-white"></i> Add Review
			</button>
			<ul id="ratingsLocation"></ul>
		</div>
	</div>
</div>


<div class="modal hide fade">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">&times;</button>
		<h3>Modal header</h3>
	</div>
	<div class="modal-body"></div>
	<div class="modal-footer">
		<a href="#" class="btn">Cancel</a> <a href="#" class="btn btn-primary">Save
			changes</a>
	</div>
</div>




<script src="js/backbone/restaurant/restaurant-app.js"></script>






