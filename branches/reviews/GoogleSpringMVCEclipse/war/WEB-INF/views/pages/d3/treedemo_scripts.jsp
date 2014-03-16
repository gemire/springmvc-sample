<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

    <style>

        body
        {
            background-color: #F7F2C5;
        }
        .node {
            cursor: pointer;
        }

        .type_Division circle
        {
            stroke: red;
        }
        .type_Provider circle
        {
            stroke: orange;
        }

        .node  circle {


            stroke-width: 1.5px;
        }

        .node text {
            font: 10px sans-serif;
        }

        .link {
            fill: none;
            stroke: #ccc;
           
        }
        .linkNormal
        {
           stroke-width: 1.5px; 
           stroke: #ccc;
        }
        .linkMark
        {
             stroke-width: 3.0px;
             stroke: firebrick
        }

        #tree-container
        {
            border: 2px solid #707f0e;
            float:left;
            margin-left:10px
        }

        #outputBox
        {

            margin: 5px;
            height: 150px;
        }

        #action-container
        {
            float: right;
            margin-right: 50px;
            width:150px;
            height: 240px

        }
        #my_custom_menu
        {

            padding: 2px;
            border: thin solid black;
            background-color: white;
            width:150px;
            height:110px;
            border-radius: 28px;
            -webkit-box-shadow: 4px 4px 3px #666666;
            -moz-box-shadow: 4px 4px 3px #666666;
            box-shadow: 4px 4px 3px #666666;

        }
        button
        {
            margin: 10px;
        }

    </style>
    
    
    <script src="js/d3/treedemo/action_code.js"></script>
    <script src="js/d3/treedemo/interactive_tree4.js"></script>
     