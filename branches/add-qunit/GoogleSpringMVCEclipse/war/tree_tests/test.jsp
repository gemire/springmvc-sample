<!doctype html>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/app/home.html";
%>

<html lang="en">
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>xTree - Test</title>

        <link rel="stylesheet" href="qunit.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.js"></script>
        <script>window.jQuery || document.write('<script src="../js/jquery.js"><\/script>')</script>

        <script src="../js/backbone/jsdemo/jsxml.js"></script>
        <script src="qunit.js"></script>
        <script src="../js/json.min.js"></script>
        <script src="../js/mpump/messagepump.js"></script>
        <script src="../js/backbone/jsdemo/xtree_listeners.js"></script>
        <script src="../js/backbone/jsdemo/xtree.js"></script>
        <script src="jquery.mockjax.js"></script>
        <script src="BeforeMock.js"></script>
        <script src="xtest.js"></script>
        <script src="jsobj_tests.js"></script>
        <script src="xtest_html.js"></script>

 
    </head>
    <body>
    <p><a href="<%= basePath %>">Return to Application</a></p>
        <h1 id="qunit-header">QUnit tests of xTree</h1>
        <h2 id="qunit-banner"></h2>
        <h2 id="qunit-userAgent"></h2>
        <ol id="qunit-tests"></ol>    
        <div id="qunit-fixture"></div>
    </body>
</html>