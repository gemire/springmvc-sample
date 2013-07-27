
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<script>
/*
$(window).bind("load", function() {

	$("#sendCoffeeForm").submit();

	
}
*/

function sendCoffee()
{

	    var bean = $('#coffeeForm').serializeObject();
	    alert($.param(bean));
	    var url = "app/json/sendCoffee.json";
	    $.postJSON(url, bean, function(coffee) {
	        alert(coffee.quantity);
	    });

	
}

function getJSON() {
	 
    $.getJSON('app/json/getbook.json',  function(book) {
         alert(book.author);
    });
	
}


function getCoffee()
{
	var url = "app/json/coffee.json?brand=";
	var brand = $('#brand').val();
	url = url + brand;
	$.getJSON(url,  function(coffee) {         alert(coffee.brand);    });
	
}


</script>




<h3>Processing Jason on the Server via jQuery</h3>

<table border="0" cellpadding="4" cellspacing="4">
<tr><td width="150px" colspan="3"><span class="myButton" onclick="getJSON()">Get Json</span></td></tr>
<tr><td width="150px"><span class="myButton" onclick="getCoffee()">Get Coffee</span></td><td width="100px">Brand</td><td><input type="text" id="brand" name="brand" size="20"/></td></tr>
</table>  

<form id="coffeeForm">
<table border="0" cellpadding="4" cellspacing="4">
<tr><td width="150px"><span class="myButton" onclick="sendCoffee()">Send Coffee</span></td><td width="100px">
Brand</td><td><input type="text" id="brand" name="brand" size="20"/></td></tr>
</table>
</form>