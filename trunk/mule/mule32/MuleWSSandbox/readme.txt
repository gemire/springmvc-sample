a demonstration of returning a web service call to the client synchronously
the use of error routing, and the use of the web service impl to contact
the bus via jms.

The implementation is a Spring jmsTemplate, and uses the registry to transform
its object to a string for a TextMessage, the needed items for the template
are injected in the setContext method of the impl.