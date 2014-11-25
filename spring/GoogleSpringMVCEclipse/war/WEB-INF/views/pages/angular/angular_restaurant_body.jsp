<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


 <div ng-app="restaurantApp">
      <div class="container  restaurantContainer span12">


            <div ng-controller="listRestaurantController">

                <div class="row scrollHeader container span12">
                    <span class="tableHeader" style="position: relative; left:20px">Name</span>
                    <span class="tableHeader" style="position: relative; left:280px">City</span>
                    <span class="tableHeader" style="position: relative; left:360px">St.</span>
                    <span class="tableHeader" style="position: relative; left:370px">Zip</span>
                    <span class="tableHeader" style="position: relative; left:375px">Ver.</span>

                </div>

                <div class="row scrollList container well well-small span12">

                    <table style="width:100%">

                        <tr ng-repeat="restaurant in restaurantList">

                            <td  data-ng-click="changeRestaurant($event, restaurant)" ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]"   class="span6 editRow" data-id="{{restaurant.id}}">{{restaurant.name}}</td>
                            <td  data-ng-click="changeRestaurant($event, restaurant)" ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]"   class="span2 editRow">{{restaurant.city}}</td>
                            <td  data-ng-click="changeRestaurant($event, restaurant)" ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]"   class="span1 editRow">{{restaurant.state}}</td>
                            <td  data-ng-click="changeRestaurant($event, restaurant)" ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]"   class="span1 editRow">{{restaurant.zipCode}}</td>
                            <td  data-ng-click="changeRestaurant($event, restaurant)" ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]"   class="span1 editRow">{{restaurant.version}}</td>                            
                            <td ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]" >
                                <span data-ng-click="changeRestaurant($event, restaurant)"   class="badge ptrClass badge-info"> <i class="icon-edit icon-white"></i> Edit</span></td>
                            <td ng-class= "{true: 'currentUserRow', false: ''}[restaurant.is_current]" >
                                <span data-ng-click="deleteRestaurant(restaurant)"           class="badge ptrClass badge-important"> <i class="icon-remove icon-white"></i> Delete</span></td>


                        </tr>    
                    </table>
                </div>

                <div class="row container span12 errorPanel restaurantErrorPanel">
                   &nbsp; {{errorMessage}}
                </div>
            </div>
            <!-- edit and review container -->
            <!-- https://docs.angularjs.org/api/ng/directive/input -->

            <div class="row">
                <div class="span11">
                    <div  id="editRestaurantController"  ng-controller="editRestaurantController" class="well well-large span5 pull-left">
                        <h4 style="display: inline-block">Restaurants</h4>
                        <div class="form-group">

                            <button  ng-show="canAdd" ng-click="addNewRestaurant()"   class="btn btn-small btn-primary"><i class="icon-pencil icon-white"></i> Add New Restaurant</button>

                        </div>
                      

                        <form class="form-inline" name="editRestaurantForm"  role="form" novalidate ng-show="recordPresent">
                            <label class="control-label" for="name"></label>
                            <div class="controls">
                                <div class="input-prepend">
                                    <span class="add-on">Name</span>
                                    <input required  id="name" name="name" class="input-xlarge" placeholder="Name"   ng-model="currentRestaurant.name" type="text">
                                </div>
                                <div class="input-prepend">
                                    <span class="add-on">City</span>
                                    <input  required  id="city" name="city" class="input-medium" placeholder="City"  ng-model="currentRestaurant.city"  type="text">
                                </div>
                                <div class="input-prepend">
                                    <span class="add-on">State</span>
                                    <input required ng-pattern="/[A-Z]{2}/" minlength="2" maxlength="2" id="state" name="state" class="input-small" placeholder="State"   ng-model="currentRestaurant.state" type="text">
                                </div>
                                <div class="input-prepend">
                                    <span class="add-on">Zip Code</span>
                                    <input required ng-pattern="/[0-9]/" minlength="5" maxlength="5" id="zipCode" name="zipCode"   class="input-small" placeholder="Zip Code"  ng-model="currentRestaurant.zipCode"  type="text">
                                </div>
                                <div class="input-prepend">
                                    <span class="add-on">Version</span>
                                    <input required  ng-pattern="/[0-9]/"   id="version" name="version" class="input-small" placeholder="Version"   ng-model="currentRestaurant.version" type="text">
                                </div>
                            </div>
                            <div  style="margin-top:5px" ng-show="recordPresent">
                                <button  ng-click="saveClick()" class="btn btn-small btn-primary"> <i class="icon-edit  icon-white"></i>  Save</button>
                                <button  ng-click="cancelClick()" class="btn btn-small  btn-primary"> <i class="icon-refresh  icon-white"></i>  Restore</button>
                            </div>

                        </form>

                    </div><!-- end editRestaurantController -->

                    <div id="reviewController" class="span5" ng-controller="reviewController">

                        <h4 style="display: inline">Ratings</h4> 

                        <span class="restaurantErrorPanel" ng-show="addReviewForm.reviewListing.$error.required">Review Cannot be blank.</span>
                          <div ng-switch="isAdding">
                            <!-- begin adding new review -->
                            <form name="addReviewForm" role="form" novalidate>
                                <div ng-switch-when="true" style="margin-bottom:5px">

                                    <input required style="margin-right:3px"  ng-model="addNewReviewBuffer.reviewListing" name="reviewListing" id="reviewListing"  class="input-large"  type="text">  


                                    <select  style="margin-right:2px" ng-model="addNewReviewBuffer.starRating"  class="input-mini">  
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                        <option>5</option>
                                        <option>6</option>
                                        <option>7</option>
                                        <option>8</option>
                                        <option>9</option>
                                        <option>10</option>
                                        <option>11</option>
                                        <option>12</option>
                                        <option>13</option>

                                    </select>    <span class="icon-star"></span> s 
                                    <div>
                                        <button  ng-click="saveNewReview()" class="btn btn-small btn-primary"> 
                                            <i class="icon-edit icon-white"></i> Save 
                                        </button>
                                        <button ng-click="cancelNewReview()" class="btn btn-small btn-danger">
                                            <i class="icon-remove icon-white"></i> Cancel 
                                        </button>
                                    </div>

                                </div>
                            </form>   
                            <form name="editReviewForm" role="form" novalidate>
                                <div ng-switch-when="false">
                                    <div   ng-show="hasCurrentRestaurant()"  style="margin-bottom:5px">
                                        <button  id="addReviewButton" ng-click="addNewReview()" class='btn btn-small btn-primary'>
                                            <i class="icon-pencil icon-white"></i> Add Review</button>
                                    </div>

                                    <!-- end adding new review -->

                                    <div ng-repeat="review in currentReviews">
                                        <div ng-switch="review.isEditing">
                                            <div ng-switch-when="true" class="reviewRow" ng-class= "{true: 'editingReview', false: ''}[review.isEditing]">

                                                <input style="margin-right:3px" required class="input-large" ng-model="review.reviewListing" type="text">    


                                                <select  style="margin-right:2px" required class="input-mini" ng-model="review.starRating" type="text">  
                                                    <option>1</option>
                                                    <option>2</option>
                                                    <option>3</option>
                                                    <option>4</option>
                                                    <option>5</option>
                                                    <option>6</option>
                                                    <option>7</option>
                                                    <option>8</option>
                                                    <option>9</option>
                                                    <option>10</option>
                                                    <option>11</option>
                                                    <option>12</option>
                                                    <option>13</option>

                                                </select>    <span class="icon-star"></span> s
                                                <div>
                                                <button  ng-click="saveReviewEdit(review)" class="btn btn-mini btn-primary"> 
                                                    <i class="icon-edit icon-white"></i> 
                                                </button>
                                                <button ng-click="cancelReviewEdit(review)" class="btn btn-mini btn-danger">
                                                    <i class="icon-refresh  icon-white"></i>  
                                                </button>
                                                </div>

                                            </div>
                                            <div ng-switch-default  class="reviewRow">
                                                {{review.reviewListing}} ({{review.starRating}} 
                                                <span class="icon-star"></span> s) 


                                                <div style="margin:5px">
                                                    <button  ng-click="editReview(review)" class="btn btn-mini btn-primary"> 
                                                        <i class="icon-edit icon-white"></i> Edit
                                                    </button>
                                                    <button ng-click="deleteReview(review)" class="btn btn-mini btn-danger">
                                                        <i class="icon-remove icon-white"></i> Delete
                                                    </button>

                                                </div>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </form>
                        </div>


                    </div><!-- end reviewController -->


                </div><!-- edit and review container -->        
            </div>


        </div>    

 </div>      
       