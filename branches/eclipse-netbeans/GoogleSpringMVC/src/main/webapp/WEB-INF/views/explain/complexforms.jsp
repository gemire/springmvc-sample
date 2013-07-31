<h3>Processing Input From Forms</h3>
<div>
A full fledged form demonstration taken from the Spring Showcase program 
from SpringSource. Try submitting the following errors:

<ol>
<li>Age under 21</li>
<li>'Bozo' in the name field</li>
<li>Name field blank</li>
<li>Improperly formatted money</li>

</ol>

The validation is using JSR303 in the class 
<code>com.dhenton9000.spring.mvc.model.</code> <code>FormBean</code>. The
bozo error is programmatic and is contained in the controller code, via a call to a
validator object, in the style of older Spring MVC validation. The messages displayed
come from the message properties file following the conventions for mapping error
types to messages.
</div>




<div>
The corresponding java code that handles these actions can be found in
<code>com.dhenton9000.spring.mvc.controllers.</code> <code>ComplexFormController</code>
</div>
