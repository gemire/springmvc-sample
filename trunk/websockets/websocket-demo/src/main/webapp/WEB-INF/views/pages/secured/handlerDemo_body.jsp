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

<h3>Secure Page</h3>

 

 
    <div class="row">
      <div class="col-sm-6">
        <p>Your username is <sec:authentication property="principal.username"/></p>
        <!-- Connect and Disconnect buttons to establish/terminate a connection to the websocket service -->
        <div class="panel">
          <button id="connect" onclick="connect()" class="btn btn-success btn-sm">Connect</button>
          <button id="disconnect" onclick="disconnect()" class="btn btn-danger btn-sm">Disconnect</button>
        </div>
        <p />
        <div class="panel panel-default">
          <div class="panel-heading">Send Messages To WebSocket Server</div>
          <div class="panel-body" id="conversationDiv">
            <div class="input-group">
              <input type="text" class="form-control" id="txtSendMessage" placeholder="Enter message"> <span class="input-group-btn">
                <button id="sendMessage" onclick="sendMessage()" class="btn btn-primary">
                  <span class="glyphicon glyphicon-share-alt"></span>&nbsp;Send
                </button>
              </span>
            </div>
             
          </div>
          <!-- .panel-body -->
          <div class="panel-body" id="response"></div>
          <!-- Div to show the server responses -->
        </div>
        <!-- .panel -->
      </div>
    </div>
        <script>
            var socketDest= "<%= socketDest %>";
            
            
        </script>

<script src="resources/js/sockjs-0.3.4.min.js"></script>
<script src="resources/js/handlerDemo/handlerDemo.js"></script>	
