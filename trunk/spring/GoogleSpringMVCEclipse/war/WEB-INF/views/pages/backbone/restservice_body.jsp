<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="baseURL" value="/app/" />





<h2>Service Description</h2>
<p><b>Service url:</b> http://donhenton.appspot.com/app/backbone/restaurant/</p>
<p><b>Service url:</b> http://localhost:8888/app/backbone/restaurant/</p>
<ul>
	<li>
		<h3>create(RestaurantDTO)</h3>
		<ul>
			<li><b>description: </b> Add a restaurant</li>
			<li><b>path: </b> /</li>
			<li><b>method: </b> POST</li>
			<li><b>type:</b>application/json</li>
			<li><b>post body:</b>new restaurant without id</li>
			<li><b>success: </b>returns <i>{id: 9999}, the id of the
					newly created item</i> status HttpStatus.CREATED</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX}</li>
		</ul>

	</li>
	<li>
		<h3>update(RestaurantDTO)</h3>
		<ul>
			<li><b>description: </b> update a restaurant</li>
			<li><b>path: </b> /{restaurant id}</li>
			<li><b>method: </b> PUT</li>
			<li><b>type:</b>application/json</li>
			<li><b>put body:</b>restaurant with changes, id is on path</li>
			<li><b>success: </b>returns nothing status: 200</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX} status 404
				for id not found</li>
		</ul>

	</li>
	<li>
		<h3>remove(RestaurantDTO)</h3>
		<ul>
			<li><b>description: </b> Add a restaurant</li>
			<li><b>path: </b> /{restaurant id}</li>
			<li><b>method: </b> DELETE</li>
			<li><b>type:</b>application/json</li>
			<li><b>success: </b>returns nothing status: 200</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX} status 404
				for id not found</li>
		</ul>

	</li>
	<li>
		<h3>getRestaurant(String id)</h3>
		<ul>
			<li><b>description: </b>get a single restaurant</li>
			<li><b>path: </b> /{restaurant id}</li>
			<li><b>method: </b>GET</li>
			<li><b>type:</b>application/json</li>
			<li><b>success: </b>returns the found restaurant</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX"} including
				ResourceNotFoundException and status:404</li>
		</ul>

	</li>
	<li>
		<h3>getAllRestaurants()</h3>
		<ul>
			<li><b>description: </b>get all restaurants</li>
			<li><b>path: </b> /</li>
			<li><b>method: </b>GET</li>
			<li><b>type:</b>application/json</li>
			<li><b>success: </b>returns all restaurants</li>

		</ul>

	</li>
	<li>
		<h3>addReview(RestaurantDTO)</h3>
		<ul>
			<li><b>description: </b> Add a review to a restaurant</li>
			<li><b>path: </b> /review/{restaurantId}</li>
			<li><b>method: </b> POST</li>
			<li><b>type:</b>application/json</li>
			<li><b>post body:</b>new review</li>
			<li><b>success: </b>returns <i>{id: 9999}, the id of the
					newly created review item</i> status HttpStatus.CREATED</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX}</li>
		</ul>

	</li>

	<li>
		<h3>saveReview(RestaurantDTO)</h3>
		<ul>
			<li><b>description: </b> update a review</li>
			<li><b>path: </b> /review/{restaurantId}/{reviewId}</li>
			<li><b>method: </b> PUT</li>
			<li><b>type:</b>application/json</li>
			<li><b>put body:</b>review with changes, id is on path</li>
			<li><b>success: </b>returns nothing status: 200</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX} status 404
				for id not found</li>
		</ul>

	</li>
	<li>
		<h3>removeReview(String restaurantId, String reviewId)</h3>
		<ul>
			<li><b>description: </b> remove a review</li>
			<li><b>path: </b> /review/{restaurantId}/{reviewId}</li>
			<li><b>method: </b> DELETE</li>
			<li><b>type:</b>application/json</li>
			<li><b>success: </b>returns nothing status: 200</li>
			<li><b>failure: </b>{message: "XXX" errorClass: "XXX} status 404
				for id not found</li>
		</ul>

	</li>


</ul>