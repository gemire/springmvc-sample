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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title" ignore="true" />
        </title>

        <base href="<%= basePath%>" />
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <style>
            body {
                padding-top: 10px;
                padding-bottom: 10px;
            }
        </style>
        <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="resources/css/main.css">

        <script src="resources/js/vendor/jquery-1.11.0.js"></script>	
        <script type="text/javascript" src="resources/js/vendor/bootstrap.min.js"></script>
        <script src="resources/js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>

        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <ul class="nav nav-pills">
                        <li>
                            <a href="<c:out value="${baseURL}"/>">Home</a>
                        </li>


                        <sec:authorize access="isFullyAuthenticated()">

                            <li>
                                <a href="<c:out value="${baseURL}secured/simpleDemo"/>">Simple</a>
                                 
                            </li>
                            <li>
                                <a href="<c:out value="${baseURL}secured/echoHandlerDemo"/>">Echo Handler Handler</a>
                            </li>
                            <li>
                                <a href="#"/>Demo 4</a>
                            </li>
                            
                            
                            
                            <li class="dropdown">
					 <a href="#" data-toggle="dropdown" class="dropdown-toggle">JS Experimental<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li>
							<a href="<c:out value="${baseURL}secured/jsexp/xmlTest"/>">Xml Test</a>
						</li>
						<li>
							<a href="<c:out value="${baseURL}secured/jsexp/chat"/>">Chat</a>
						</li>
						<li>
							<a href="#">Something else here</a>
						</li>
						<li class="divider">
						</li>
						<li>
							<a href="#">Separated link</a>
						</li>
					</ul>
</li>
                            
                            
                            
                            

                            <li class="pull-right">
                                <a href="<c:out value="${baseURL}logout"/>">Logout</a>
                            </li>
                        </sec:authorize>

                    </ul>   

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <tiles:getAsString name="title" />
                            </h3>
                        </div>
                        <div class="panel-body">
                            <tiles:insertAttribute name="body" />  
                        </div>

                    </div>
                </div>
            </div>
        </div>


    </body>
</html>