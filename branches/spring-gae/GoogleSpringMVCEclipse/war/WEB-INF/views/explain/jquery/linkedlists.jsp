<h3>JQuery Linked Lists</h3>

<p>
This form demonstrates linking select boxes using JQuery. Embedded in
the page is a JSON object that represents car makers, models, and features
for that model.
</p>
<p>
The 'Using JSON object' code illustrates the use of various JQuery functions that parse and 
manipulate JSON objects. A JSON object drives the three linked list boxes.
</p>

<p>
The 'Using MVC Call' uses JQuery AJax calls to pull down various JSON structures from the
remote server to get the subcategory data for a given category. An artificial delay has
been added to illustrate handling server issues.
</p>

<div>
The corresponding java code that handles these actions can be found in
<code>com.dhenton9000.spring.mvc.controllers.jquery MainJQueryController</code>
and 
<code>com.dhenton9000.spring.mvc.controllers.jquery LinkedListsRequestController</code>
</div>