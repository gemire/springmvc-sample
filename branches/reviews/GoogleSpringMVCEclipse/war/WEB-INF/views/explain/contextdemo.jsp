<h3>Spring Context Demonstrations</h3>
<div>
    This controller demonstrates access to the applicationContext by the
    ApplicationContextAware interface, which will load the context into the 
    controller. The context then can be used to look up any bean, this is shown in
    item 1.
    <p>Item 2 item illustrates creating a bean and wiring it into the
        controller by having that done in a spring file. This would be an alterative
        to 'Autowire' annotations. The spring file in question is controllers.xml,
        and for this to work, it must be included in spring-servlet.xml. This last file
        creates the context for the controllers, and thus injection must be done in 
        this context.
    <p>Item 3 is the actual bean in scope, which happens to be the controller itself</p>
</div>

<div>
    The corresponding java code that handles these actions can be found in
    <code>com.dhenton9000.spring.mvc.controllers.</code> <code>ContextDemoController</code>
</div>
