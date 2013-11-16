<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>


<c:url var="baseURL" value="/app/backbone/demos/js/model" />

<!-- backbone restaurant scripts -->
 
  <style>  

        li 
        {
            margin: 5px
        }

        .ptrClass {cursor:pointer }

        
       /* td { margin: 3px; padding: 3px} */
        /*.selectedRow {background-color: #a47e3c;color:white}*/
        .selectedRow {background-color: #0044cc; color:whitesmoke }
        .editRow {  cursor:pointer }
        .tableHeader
        {

            font-size: 20px;
            font-weight: normal;

            color: white;
            padding: 4px 2px 2px 4px;
            margin: 2px;

        }


    </style>
    
    <!--
    <script src="tree_tests/jquery.mockjax.js"></script>
    -->
   
    <script>
        // generate using jsp tags
       _main_url = "<%= basePath %>/app/backbone/restaurant/";
       restaurantData = ${jsonRestaurants}
        //_main_url = "http://donhenton.appspot.com/app/backbone/restaurant"
        // generate using jsp tags
      
     
    </script>
 <!--      
    <script src="tree_tests/RestaurantMockData.js"></script>
        <script>
        // generate using jsp tags
 
        restaurantData = mockRestaurantData;
    </script>
 -->     
 
    <script src="js/backbone/underscore.js"></script>
    <script src="js/backbone/backbone.js"></script>
  
    <script id="reviewTemplate" type="text/template">
        <li id="review_{{pos}}">{{review}}({{star}}<span class='icon-star'></span>s) 
        <div style="margin:5px">
        <span onclick='window.myRatingsView.editReview({{pos}})' class='ptrClass badge badge-info'><i class='icon-edit editRatingClass icon-white'></i></span>
        <span onclick='window.myRatingsView.deleteReview({{pos}})' class='ptrClass badge badge-important'><i class='icon-remove deleteRatingClass icon-white'></i></span></li>
        </div>
    </script>
    <script id="reviewEditTemplate" type="text/template">
        <li id="review_{{pos}}">
        <span class='form-inline'>
        <input type='text'  id='r_{{pos}}'  name='review_{{pos}}' value='{{review}}' class='input-xlarge'>

        <select id='s_{{pos}}' name='star_{{pos}}' class='input-mini'>
        $$star_select_content$$
        </select>
        <div style="margin:5px">
        <input type='button' value='Save' onclick='window.myRatingsView.saveReview({{pos}})' class="btn btn-mini btn-primary" />
        <input type='button' value='Cancel' onclick='window.myRatingsView.cancelEdit({{pos}})' class="btn btn-mini btn-primary" />
        <span class="text-error" style="display:none" id="error_{{pos}}"></span>
        </div>
        </span>
        </li>
    </script>



    <script id="formTemplate" type="text/template">


        <label class="control-label" for="name"></label>
        <div class="controls">
        <div class="input-prepend">
        <span class="add-on">Name</span>
        <input id="name" name="name" class="input-xlarge" placeholder="Name"  value="{{name}}" type="text" required="">
        </div>
        <div class="input-prepend">
        <span class="add-on">City</span>
        <input id="city" name="city" class="input-medium" placeholder="City"  value="{{city}}"  type="text" required="">
        </div>
        <div class="input-prepend">
        <span class="add-on">State</span>
        <input id="state" name="city" class="input-small" placeholder="State"   value="{{state}}" type="text" required="">
        </div>
        <div class="input-prepend">
        <span class="add-on">Zip Code</span>
        <input id="zipCode" name="zipCode" class="input-small" placeholder="Zip Code"  value="{{zipCode}}"  type="text" required="">
        </div>
        <div class="input-prepend">
        <span class="add-on">Version</span>
        <input id="version" name="version" class="input-small" placeholder="Version"   value="{{version}}" type="text" required="">
        </div>
        </div>


    </script>  

    <script id="rowTemplate" type="text/template">
        <td class="editRow span6" data-id="{{id}}">{{name}}</td>
        <td class="editRow span2">{{city}}</td>
        <td class="editRow span1">{{state}}</td>
        <td class="editRow span1">{{zipCode}}</td>
        <td class="editRow span1">{{version}}</td>
        <td><span class="badge ptrClass badge-info editMarker"> <i class="icon-edit icon-white"></i> Edit</span></td>
        <td><span class="badge ptrClass badge-important deleteMarker"> <i class="icon-remove icon-white"></i> Delete</span></td>
    </script>
  

    
    
    