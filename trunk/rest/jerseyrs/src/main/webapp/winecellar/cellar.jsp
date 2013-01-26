<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>Backbone Cellar</title>
<link rel="stylesheet" href="css/styles.css" />
</head>

<body>

<div id="header"></div>

<div id="sidebar"></div>

<div id="content">
    <h1>Welcome to Backbone Wine Cellar</h1>
</div>

<script src="lib/jquery-1.7.1.min.js"></script>
<script src="lib/underscore-min.js"></script>
<script src="lib/backbone-min.js"></script>


<script src="js/utils.js"></script>
<script src="js/models/winemodel.js"></script>
<script src="js/views/header.js"></script>
<script src="js/views/winelist.js"></script>
<script src="js/views/winedetails.js"></script>
<script src="js/main.js"></script>

</body>

</html>