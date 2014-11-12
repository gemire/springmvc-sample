<h3>D3 Tree Demo</h3>
<div>
	<p>This is a demonstration of d3 for data visualization and
		interactivity.</p>
	<p>
		The data is a fictional collection of business divisions for an
		insurance company, and the providers who deliver service to the
		divisions. The tree represents a hierarchy of divisions. The nodes
		with the icons are <b>Providers</b> and all other nodes are <b>Divisions</b>
	</p>
</div>
<h4>Interactions Available</h4>
<ul>
	<li>Clicking on a node will show/hide any children, as long as
		they have children</li>
	<li>Clicking on a provider node will highlight the path to that
		node, as well as display explanatory text to the right</li>
	<li>Right clicking on any node will display a context menu with
		menu options</li>
	<li>The <b>Zoom In </b> and <b>Zoom Out</b> will magnify the graph
		and dismiss any context menus
	</li>
	<li>The graph can be panned if dragged on any part of the graph <b>except</b>
	the nodes</li>
</ul>


<div>
	The corresponding java code that handles these actions can be found in
	<code>com.dhenton9000.spring.mvc.controllers.d3.</code>
	<code>D3Controller</code>
</div>
