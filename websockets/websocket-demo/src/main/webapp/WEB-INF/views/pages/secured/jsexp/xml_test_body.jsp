<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url var="baseURL" value="/" />
<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String socketDest = "ws://" + request.getServerName() + ":" + request.getServerPort() + path + "/echoHandler";
     
%>

<h3>Xml test</h3>

 <div class="panel-success" id="messageArea" />
 <p><button onclick="xmlTest.connect()" class="btn btn-primary">Connect</button></p> 
 <p><button onclick="xmlTest.getInfo()" class="btn btn-primary">Get Info</button></p>  


<script src="resources/js/stomp.js"></script>
<script src="resources/js/messagepump.js"></script>
<script src="resources/js/xmlTest/xmlTest.js"></script>	
<script>
   var socketDest= "<%= socketDest %>";
   xmlTest.init(socketDest);
    
</script>
<script src="resources/js/xmlTest/wsHandlers.js"></script>	
