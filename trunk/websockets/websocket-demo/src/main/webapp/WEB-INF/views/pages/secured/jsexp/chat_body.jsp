<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url var="baseURL" value="/" />
<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    //String socketDest = "ws://" + request.getServerName() + ":" + request.getServerPort() + path + "/zzz";

%>


<sec:authentication property="principal.username" var="userName"/>
<!-- -->


<div class="panel">
    <div class="panel-body">
        <button id="connectButton" onclick="chat.connect()" class="btn btn-success btn-sm">Connect</button>
        <button id="disconnectButton" onclick="chat.closeRequested()"  disabled="true"  class=" btn btn-danger btn-sm">Disconnect</button>


    </div> 

</div>

<div class="row clearfix"  style="margin-bottom: 10px">
    <div class="col-md-9 column form-inline">
        
            <input id="sendMessageTextBox" size="75" class="form-control" placeholder="Enter message" type="text" /> 
            <button id="sendMessageButton" onclick="chat.sendMessage()"  disabled="true"  class=" btn btn-primary btn-sm">Send</button>  
        
    </div>
</div>
<div class="row clearfix">

    <div class="col-md-9 column">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title">Conversation</h3>
            </div>
            <!--     repeating unit 
                        <div class="row clearfix table-bordered">
            
                            <div class="col-md-1 column">User1</div>
                            <div class="col-md-8 column">conversation 1</div>
            
                        </div>
            -->

            <div class="panel-body" id="chatArea"></div>



        </div> 

    </div>

    <div class="col-md-2 column right">

        <h4 class="list-group-item-heading">Logged In Users</h4>
        <div class="list-group" id="usersList">

             


        </div>
    </div>
</div>


<!-- -->


<script>
    var basePath = "<%= path%>";
    var userName = "${userName}";

</script>

<script src="resources/js/stomp.js"></script>
<script src="resources/js/sockjs-0.3.4.min.js"></script>
<script src="resources/js/messagepump.js"></script>
<script src="resources/js/chat/chat.js"></script>
<script src="resources/js/mustache.js"></script>
<script src="resources/js/chat/chat_handlers.js"></script>
<script>
    $(document).ready(function() {
        var contextPath = "<%= path%>";
        chat.init(contextPath, userName);
    });
</script>
