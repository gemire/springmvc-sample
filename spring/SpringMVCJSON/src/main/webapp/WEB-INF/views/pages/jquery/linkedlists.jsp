<script type="text/javascript"  src="js/linkedlistsjson.js"></script>
<script type="text/javascript"  src="js/linkedlistsviaCall.js"></script>

<div class="leftColumn">
<div class="column  header1">Using JSON Object</div>
<div class="itemContainer">

	<table cellpadding="5" cellspacing="5">

		<tr>
			<th>Car Maker</th>
			<td><select id="maker"></select>
			</td>
		</tr>
		<tr>
			<th>Model</th>
			<td><select id="model"></select>
			</td>
		</tr>
		<tr>
			<th>Feature</th>
			<td><select id="feature"></select>
			</td>
		</tr>
		<tr>
			<td colspan="2"><button onclick="showSelection()"
					class="myButton">Show Selection</button>
			</td>
		</tr>
	</table>
</div>



<div id="selectionInformation">
	<div class="column header1">You Selected:</div>
	<table cellpadding="5" cellspacing="5">

		<tr>
			<th>Car Maker</th>
			<td id="makerResult"></td>
		</tr>
		<tr>
			<th>Model</th>
			<td id="modelResult"></td>
		</tr>
		<tr>
			<th>Feature</th>
			<td id="featureResult"></td>
		</tr>
	</table>
</div>
</div>



<div class="rightColumn">
<div class="column  header1">Using MVC Call</div>
<div class="itemContainer">


<table cellpadding="4" cellspacing="4">
  <tr><th>Product Categories</th><td> <select style="width:140px" id="categories"></select></td><td rowspan="2"><img id="loaderImage"  width="40px" height="40px" src="images/loader.gif" /></td></tr>
  <tr><th>Product SubCategories</th><td> <select  style="width:140px"  id="subCategories"></select></td></tr>
   </table>
   


</div>
</div>
</div>
