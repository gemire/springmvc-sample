<div class="column header1">Error Handling</div>
<div>
This demonstrates the Spring MVC error handling. Entering 'bozo'
into the form will throw a BozoException which is handled via a method
that is annoted with '@ExceptionHandler' and has the BozoException as
the single parameter of the method.

</div>
<div>
With this mechanism, it is possible to handle errors with a controller 
method call, which allows the handling/routing to take advantage of the
tiles functionality.
</div>



<div>
The corresponding java code that handles these actions can be found in
<code>com.dhenton9000.spring.mvc.controllers.</code><br/><code>ErrorDemoController</code>
</div>
