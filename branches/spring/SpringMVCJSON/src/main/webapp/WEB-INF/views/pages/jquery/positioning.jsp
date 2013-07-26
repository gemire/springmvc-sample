
<style>

  div.initClass
  {

        position: absolute;
        top: 336px;
        left: 375px;
  }


  div.relClass
  {

        position: relative;
        left: 20px;
        top: 40px;
  }


</style>



<div id="foo">
	<div id="bar">This text is inside a div labeled #bar, which is inside a div labeled #foo</div>

</div>


<div class="itemContainer" id="results">


<table class="table">
<tr><th>Item</th><th>Top</th><th>Left</th><th>Offset (top,left)</th><th>Offset Parent Id</th></tr>
<tr><th>#foo</th><td id="foo_top"></td><td id="foo_left"></td><td id="foo_offset"></td><td id="foo_offset_parent"></td></tr>
<tr><th>#bar</th><td id="bar_top"></td><td id="bar_left"></td><td id="bar_offset"></td><td id="bar_offset_parent"></td></tr>

</table>
</div>

<div style="postion:absolute; left: 450px; top: 200px">
<button class="btn btn-primary" onclick="doMove()">Move The 'foo' Div</button>
</div>


<div id="explanation" class="well blue row-separate">

 An absolute CSS style has been applied to the foo outer container, and a relative style to the bar container.
 The offsets and calculations are reflected in the table above.

</div>


<script>
		var $foo = null;
		var $bar = null;


		jQuery(document).ready(


		function() {
					jQuery('#explanation').toggle();
					displayPositions();

				   }



		);


function doMove()
{
   $foo.toggleClass('initClass');
   $bar.toggleClass('relClass');
   displayPositions();
   jQuery('#explanation').toggle();


}




function displayPositions()
{

	$foo = jQuery('#foo');
	$bar = jQuery('#bar');

	jQuery('td').empty();
	jQuery('#foo_top').append(Math.round($foo.position().top));
	jQuery('#foo_left').append($foo.position().left);
	jQuery('#foo_offset').append('('+Math.round($foo.offset().top)+','+$foo.offset().left+')');
	jQuery('#foo_offset_parent').append($foo.offsetParent().attr('id'));

	jQuery('#bar_top').append(Math.round($bar.position().top));
	jQuery('#bar_left').append($bar.position().left);
	jQuery('#bar_offset').append('('+Math.round($bar.offset().top)+','+$bar.offset().left+')');
	jQuery('#bar_offset_parent').append($bar.offsetParent().attr('id'));




}
</script>