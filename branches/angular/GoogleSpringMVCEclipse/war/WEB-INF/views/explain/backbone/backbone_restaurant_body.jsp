<h3>Backbone Restaurant Application</h3>


<div>
	This demonstration illustrates using <a href="http://backbonejs.org">Backbone</a>
	for a client side editing application. Several features are used here
	that are worth noting:

	<ul>
		<li>Using forms with Established markup to call into backbone
			views</li>
		<li>Creating non textbox controls</li>
		<li>Highlighting and locating models in a collection</li>
		<li>Using a model outside of a collection for REST aervices</li>
		<li>Using Mockjax for REST Services</li>
		<li>Backbone's REST Contract</li>
		<li>Using models for view state</li>

	</ul>
</div>

<h4>Using Forms With Established Markup</h4>

<div>
The editing form in this demo has HTML that exists outide of the usual Backbone system. Normally, 
Backbone views render HTML, and bind buttons, clicks, etc. In this case, the form calls into
methods in a View class designed specifically for the form.
</div>


<h4>Creating non textbox controls</h4>

<div>
The ratings area has a select box for number of stars. To make this happen the template engine had
to be used twice: Once to add <b>escaped</b> user content for the review, and a second time 
for <b>unescaped</b> HTML generated for the select box.
</div>
<h4>
Highlighting and locating models in a collection
</h4>

<div>
When you click on a row in the grid display, its highlighted and the form and review listing
are filled out. A Backbone collection of models powers this. Rendering of each row is done
by the individual Restaurant view. These views know which row they are on because they bind 
to individual rows for the click event. Also, in the collection an array of view objects are
tracked. During repainting, new views are created for the model elements, and the old ones
in the array are destroyed first. This is to prevent memory leaks, which would result from the
old views still being bound to the DOM for click events.
</div>

<h4>Using Mockjax for REST Services</h4>

<div>
In the tree_tests folder is a RestaurantMockData.js file, which was used to simulate the REST
service. Highlights include automatically generating a new Id for the POST which is used
when new objects are created.
</div>

<h4>Backbone's REST Contract</h4>
<div>
This demo also illustrates the nature of the Backbone's REST contract. Specifically POSTs for 
new object creation need to return the changed items (id) that you wish synced with your
objects. In this case to get server side ids. The urlRoot property needs to be on models if they
are used 'outside of a collection' eg. model.save() is called. Url property can be set on the
collection. Url on a model overrides default behavior for a model, but urlRoot merely moves
default behavior over to a different location. Default behavior is documented at:
<a href="http://backbonejs.org/#Sync">Backbone sync</a>.
</div>


<h4>Using Models for View State</h4>
<div>The review area will display an inline editor for a selected review. This is done
by marking a property of 'isEditing' = true, and then calling the render routine. For this to work
the JSON object on the server needs to use JsonIgnoreProperties attribute to prevent this
data from being saved on the server.</div>


<div>
	The corresponding java code that handles these actions can be found in
	<code>com.dhenton9000.spring.mvc.controllers.backbone.</code>
	<code>BasicBackboneController</code>
</div>

<div>
	The JSON services are provided by: <br>
	<code>com.dhenton9000.spring.rest.controllers.</code>
	<code>BackboneRestaurantRestController</code>
</div>
