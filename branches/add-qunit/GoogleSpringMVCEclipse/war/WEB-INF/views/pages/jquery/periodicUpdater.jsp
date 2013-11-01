<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="baseURL" value="/app/" />
<script type="text/javascript"	src="js/smartupdater-3.0.02.js"></script>

<script>
$(document).ready(function() {


	$("#target1").smartupdater({
		url : '${baseURL}jquery/demos/doUpdate',
		minTimeout: 2000  // 2 sec update
		}, function(remoteData) {
	    	$("#target1").text("The value is "+remoteData);
	    });


});


</script>

	<h3>JQuery Polling via SmartUpdater</h3>



	
	<div class="itemContainer" id="target1"></div>