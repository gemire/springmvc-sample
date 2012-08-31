<%-- 
    Document   : index
    Created on : Mar 1, 2012, 11:11:05 AM
    Author     : dhenton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jms Testing Page</title>
    </head>
    <body>
        <p>Click to see a servlet that reads the jndi context</p>
        <p><a href="JmsTestServlet">Jms Test</a></p>

        <p>Click to see a send a JMS Message</p>
        <p>
        <form action="JmsSenderServlet" method="Get">
            <table>
                <tr><td>
                        <input name="message" id="message" 
                               type="text" size="20"><input type="submit">
                   </td></tr>
            </table>
        </form>



    </p>

    <b>jars to add to application and $CATALINA_HOME/lib found in $ACTIVEMQ_HOME/lib</b>
    <ol>

        <li>activemq-core-5.5.1.jar</li>
        <li>commons-logging-1.1.jar</li>
        <li>geronimo-j2ee-management_1.1_spec-1.0.1</li>
        <li>geronimo-jms_1.1_spec-1.1.1</li>
        <li>geronimo-jta_1.0.1B_spec-1.0.1</li> 
        <li>log4j-1.2.16</li> 
        <li>slf4j-api-1.6.4</li> 
        <li>slf4j-log4j12-1.6.4</li> 



    </ol>


    <pre>
Add resource ref to web.xml
    &lt;resource-ref&gt;
        &lt;res-ref-name&gt;jms/ConnectionFactory&lt;/res-ref-name&gt;
        &lt;res-type&gt;javax.jms.ConnectionFactory&lt;/res-type&gt;
        &lt;res-auth&gt;Container&lt;/res-auth&gt;
        &lt;res-sharing-scope&gt;Shareable&lt;/res-sharing-scope&gt;
    &lt;/resource-ref&gt;	
    &lt;resource-ref&gt;
        &lt;res-ref-name&gt;jms/TomcatQueue&lt;/res-ref-name&gt;
        &lt;res-type&gt;javax.jms.Queue&lt;/res-type&gt;
        &lt;res-auth&gt;Container&lt;/res-auth&gt;
        &lt;res-sharing-scope&gt;Shareable&lt;/res-sharing-scope&gt;
    &lt;/resource-ref&gt;
 
added to the META-INF/context.xml file

    &lt;Resource auth="Container"
          name="jms/ConnectionFactory"
          type="org.apache.activemq.ActiveMQConnectionFactory"
          description="JMS Connection Factory"
          factory="org.apache.activemq.jndi.JNDIReferenceFactory"
          brokerURL="tcp://127.0.0.1:61616"
          brokerName="MyActiveMQBroker"/&gt;
 
    &lt;Resource auth="Container"
          name="jms/TomcatQueue"
          type="org.apache.activemq.command.ActiveMQQueue"
          description="JMS queue"
          factory="org.apache.activemq.jndi.JNDIReferenceFactory"
          physicalName="Tomcat.QUEUE"/&gt;
    </pre>
</body>
</html>
