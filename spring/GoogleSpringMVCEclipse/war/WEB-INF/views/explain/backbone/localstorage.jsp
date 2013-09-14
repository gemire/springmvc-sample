<h3>Local Storage And Backbone.js</h3>
<div>
    This controller demonstrates a simple application that uses 
    Backbone's local storage extension. Code is from this
    <a href="https://github.com/paulspencerwilliams/backbone_tutorial">Backbone Tutorial</a>.
</div>
<div>
    Two major modifications had to be made to the original code, both of which
    can be seen in the source off localstorage_body.jsp. 
    <ul>
        <li>Underscore uses '&lt;%' type substitution strings by default,
            which don't do so well in jsps. This was adjusted using underscore's
            <b>templateSettings</b></li>
        <li>The default routing call is a '#xxx', which will be seen as a 
            navigation anchor in this environment. Thus, a link click had to 
            be intercepted and routed to the backbone router, but also handle
            the case that normal links still have to function</li>
        <li>Note that local storage seems to only work in Chrome</li>
    </ul>
</div>

<div>
    The corresponding java code that handles these actions can be found in
    <code>com.dhenton9000.spring.mvc.controllers.backbone.</code> <code>BasicBackboneController</code>
</div>
