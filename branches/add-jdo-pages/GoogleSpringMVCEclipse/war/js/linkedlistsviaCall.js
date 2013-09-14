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
        var op2 = $('<option>', { value :  itemData.value }).text(itemData.text);
       	list.append(op2);
     });
	console.log(list); 
}


//http://www.json.org/js.html
        $(document).ready(function() {
             
             $('#loaderImage').toggleClass('invisible');
			
            $.getJSON("app/jquery/linkedlists/getCategories", null, function(data) {
            
               // $("#categories").addItems(data);
                addOptions($("#categories"),data);
            });

            var aItem = $.parseJSON('[{"text": "Please Select", "value": "-99"}]');
    		//$('#subCategories').addItems(aItem);
    		 addOptions($("#subCategories"),aItem);
    		fCall = "app/jquery/linkedlists/getSubCategories?delay=false&subCategory=0";
    		$.getJSON(fCall, null, function(data) {
    			//$("#subCategories").addItems(data);
    			addOptions($("#subCategories"),data);
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
		fCall = "app/jquery/linkedlists/getSubCategories?delay=true&subCategory="+categoryValue;
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