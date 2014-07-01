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

%>

<h3<Secure Page</h3>

<sec:authentication property="principal.username" var="userName"/>


<div class="row">
    <div class="col-sm-6">
        <p>Your username is '${userName}'</p>
        <!-- Connect and Disconnect buttons to establish/terminate a connection to the websocket service -->
        <div class="panel">
            <button id="connect" class="btn btn-success btn-sm">Connect</button>
            <button id="disconnect" class="btn btn-danger btn-sm">Disconnect</button>
        </div>
        <p />
        <div class="panel panel-default">
            <div class="panel-heading">Send Messages To WebSocket Server</div>
            <div class="panel-body" id="conversationDiv">
                <div class="input-group">
                    <input type="text" class="form-control" id="txtSendMessage" placeholder="Enter message"> <span class="input-group-btn">
                        <button id="sendMessage" class="btn btn-primary">
                            <span class="glyphicon glyphicon-share-alt"></span>&nbsp;Send
                        </button>
                    </span>
                </div>
                <!-- Error alert -->
                <div class="alert alert-danger alert-dismissable" id="formAlert">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <strong>Error!</strong> Message cannot be blank.
                </div>
                <!-- /Error alert -->
                <!-- Info alert -->
                <div class="alert alert-info alert-dismissable" id="formInfoAlert">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    <strong>Message Sent!</strong> <br />Your message has been sent to the server. You can continue to do other actions. Server response will be shown when it arrives.
                </div>
                <!-- /Info alert -->
                <!-- .input-group -->
            </div>
            <!-- .panel-body -->
            <div class="panel-body" id="response"></div>
            <!-- Div to show the server responses -->
        </div>
        <!-- .panel -->
    </div>
</div>
<script>
    var contextPath = "<%= path%>";
    var userName = "${userName}";


</script>
<script src="resources/js/knockout-3.0.0.js"></script>	
<script src="resources/js/sockjs-0.3.4.min.js"></script>
<script src="resources/js/stomp.js"></script>
<script src="resources/js/simple/simple.js"></script>	
