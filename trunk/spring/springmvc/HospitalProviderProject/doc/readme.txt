tiles3 and springmvc 3
http://dhruvgairola.blogspot.com/2013/03/spring-mvc-with-apache-tiles-3.html
https://github.com/michaelisvy/mvc-layout-samples
http://jeromejaglale.com/doc/java/spring/mvc
https://github.com/jamesward/hello-java-spring-neo4j

spring bean for embedded server:

http://stackoverflow.com/questions/13432934/spring-data-neo4j-how-to-get-wrappingneoserverbootstrapper-to-listen-on-0-0-0

<neo4j:config graphDatabaseService="graphDatabaseService"/>

<bean id="graphDatabaseService" class="org.neo4j.kernel.EmbeddedGraphDatabase" destroy-method="shutdown">
    <constructor-arg index="0" value="${com.mycompany.neo4jDataDir}"/>
    <constructor-arg index="1">
        <map>
            <entry key="allow_store_upgrade" value="true"/>
            <entry key="enable_remote_shell" value="true"/>
        </map>
    </constructor-arg> 
</bean>

<bean id="config" class="com.mycompany.Neo4jServerConfig">
    <constructor-arg> 
        <map>
            <entry key="org.neo4j.server.webserver.address" value="0.0.0.0"/>
        </map>
    </constructor-arg>     
</bean>

<bean id="serverWrapper" class="org.neo4j.server.WrappingNeoServerBootstrapper" init-method="start" destroy-method="stop">
    <constructor-arg index="0" ref="graphDatabaseService"/>
    <constructor-arg index="1" ref="config"/>
</bean>

==================

public class Neo4jServerConfig implements Configurator {

    private Configuration config;

    public Ne4jServerConfig(Map<String, String> config) {
        this.config = new MapConfiguration(config);
    }

    @Override
    public Configuration configuration() {
        return config; 
    }

    @Override
    public Map<String, String> getDatabaseTuningProperties() {
        return null;
    }

    @Override
    public Set<ThirdPartyJaxRsPackage> getThirdpartyJaxRsClasses() {
        return new HashSet<>();
    }
}
======================

http://www.mkyong.com/spring-mvc/spring-3-mvc-and-json-example/


spring form tags reference
http://static.springsource.org/spring/docs/2.0.8/reference/spring-form.tld.html

///////////////////////////////////////////////////////////////

function findNode()
{
	
	 return $('#tree1').tree('getSelectedNode').name;
	 
}
function selectNode()
{
    $('#tree1').tree('selectNode', $('#tree1').tree('getNodeById', 3));
    
}



function selectByName(treeData)
{
   searchString = $('#nodeInformation').val();
   console.debug(searchString);
   var node = recurseName(treeData[0],searchString);
    if (typeof node === "undefined") 
    {
		"-1";
	}
	else
	{
		return node.id;
	}
}

function recurseName(item,searchString)
{
	 if (item == null)
	    return null;
	    
	 if (item.name == searchString)
	 {
		 return item;
	 }
	 for (i=0;i<item.children.length;i++)
	 {
		return recurseName(item.children[i],searchString);
		
	 }
	  
	 
}