<h3>Javascript Model Demonstration</h3>
<div>
	This code provides a demonstration of the following javascript
	application concepts:

	<ol>
		<li>The use of a model-view paradigm in displaying data</li>
		<li>On demand loading</li>
		<li>Loose coupling of components via a message pump architecture</li>
	</ol>
</div>

<h4>Model View Paradigm</h4>

<div>
The tree provides a list of various categories and subcategories. The data is actually represented internally
as xml, which can be viewed on the xml tab. The various actions on the tree such as selecting and opening folders
modify the in memory xml model, and <b>then</b> refresh the html via XSLT transforms. JQuery places the resultant html
into the page. This is similar to the concepts of such frameworks as backbone.
</div>

<h4>On Demand Loading</h4>
<div>
The original 4 categories are loaded with the page via a JSON service, 
but subsequent subcategories call out to another JSON service to load the items on demand. The items are inserted
into the XML model first, and then rendered to HTML via XSLT.
</div>

<h4>Loose Coupling</h4>
<div>
The XML tab and the Selected Items list process the XML model that drives the tree. The tree broadcasts a "ON_REFRESH" 
message to subscribers to a messagepump service, which then alerts them to the event and passes the XML document as
payload. This way, the tree only knows about the message pump, which acts as a mediator which does
not need to know about what is done with the payload, it only routes the message.
</div>


<div>
	The corresponding java code that handles these actions can be found in
	<code>com.dhenton9000.spring.mvc.controllers.backbone.</code>
	<code>BasicBackboneController</code>
</div>

<div>
	The JSON services are provided by: <br>
	<code>com.dhenton9000.spring.rest.controllers.</code>
	<code>StoreCategoryRestController</code>
</div>
