function getAJob()
{
    //this code was included as a javascript file
    //it doesn't do anything and it can be seen
    // at com.dhenton9000.wicket.pages.behaviors/behaviors.js
    
}

 
function handleMouseover(name)  
{
 // $(this).nextAll(".flyOutContent").fadeIn(300).show();
    $('#flyoutDisplay').html(name);
}
 
function handleMouseout() {
  $('#flyoutDisplay').html("");
}


function initialize(){
	
	//$('.actionItem').unbind("mouseover").mouseover(handleMouseover());
	//$('.flyOutContent').unbind("mouseleave").mouseleave(handleMouseout());
}
    
    
    
    
    
 