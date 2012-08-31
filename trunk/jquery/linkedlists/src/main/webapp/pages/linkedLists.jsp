<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Linked Lists in jQuery</title>
<style>

.invisible
{
  visibility: hidden;

}

.visible
{
  visibility: visible;

}

</style>
<SCRIPT type="text/javascript" src="js/json2.js"></SCRIPT> 
<SCRIPT type="text/javascript" src="js/jquery-1.6.2.min.js"></SCRIPT>
<script type="text/javascript">

//if console is not defined, e.g.,
//Firebug console is not enabled or Non-Firefox browser
if (typeof console == 'undefined') {
 var console = {};
 console.log = function(msg) {
     return;
 };
}
/*
$.fn.addItems = function(data) {
    return this.each(function(data) {
        var list = this;
        $.each(data, function(index, itemData) {
        	console.log(itemData.text);
            var option = new Option(itemData.text, itemData.value);
            list.add(option);
        });
    });
};
this works in ie but not firefox
*/

function addOptions(list,data)
{
	
	$.each(data, function(index, itemData) {
     	console.log(" z "+itemData.text);
        var op2 = $('<option>', { value :  itemData.value }).text(itemData.text)
       	list.append(op2);
     });
	console.log(list); 
}


//http://www.json.org/js.html
        $(document).ready(function() {
             
             $('#loaderImage').toggleClass('invisible');
			console.log("a1");
            $.getJSON("servlet/DataServlet?requestType=categories", null, function(data) {
            	console.log("a2");
               // $("#categories").addItems(data);
                addOptions($("#categories"),data);
            });

            var aItem = $.parseJSON('[{"text": "Please Select", "value": "-99"}]');
    		//$('#subCategories').addItems(aItem);
    		 addOptions($("#subCategories"),aItem);
    		fCall = "servlet/DataServlet?requestType=subcategories_nodelay&subCategory=0"
    		$.getJSON(fCall, null, function(data) {
    			//$("#subCategories").addItems(data);
    			addOptions($("#subCategories"),aItem);
    		});

    		
            $("#categories").change(function() {
       			//alert('you selected ' + $(this).val());
       			v = $(this).val();
       			loadSubCategories(v);
   			});
   			
   			
           });
		
		// this creates an addon function to jQuery that will add to a list
		// since it can be applied to multiples, this.each will work thru
		// each of the selected items
		
		



	function loadSubCategories(categoryValue)
	{
		fCall = "servlet/DataServlet?requestType=subcategories&subCategory="+categoryValue;
		$('#subCategories option').remove();
		$('#loaderImage').toggleClass('invisible visible');
		//$('#subCategories').append('<option value="-99">Please Select</option>').val('-99');
		var aItem = $.parseJSON('[{"text": "Waiting...", "value": "-99"}]');
		//$('#subCategories').addItems(aItem);
		addOptions($("#subCategories"),aItem);
		

		$.getJSON(fCall, null, function(data) {
			addOptions($("#subCategories"),data);
			//$("#subCategories").addItems(data);
			$("#subCategories option:eq(0)").replaceWith("<option value='-99'>Please Select</option>");

				
				$("#subCategories option").each(
					function(i,selected)
					{
						$(this).removeAttr('selected');
					}
				);
				 
				$("#subCategories option:eq(0)").attr('selected', 'selected');
				$('#loaderImage').toggleClass('visible invisible');


		});// end call
	}
</script>
 



  </head>
  
  <body>
  
  <h3>Linked Selects Via JSON</h3>
  
  <table cellpadding="4" cellspacing="4">
  <tr><th>Product Categories</th><td> <select style="width:140px" id="categories"></select></td><td rowspan="2"><img id="loaderImage"  width="40px" height="40px" src="images/loader.gif" /></td></tr>
  <tr><th>Product SubCategories</th><td> <select  style="width:140px"  id="subCategories"></select></td></tr>
   </table>
   
    
   
  </body>
</html>
