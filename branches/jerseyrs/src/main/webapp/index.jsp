<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">

        <title>Starting Page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
    </head>

<body>
    <h2>Sample Post</h2>

    <form action="<%=basePath%>resources/post/resource/formdemo/" method="POST">
        <table cellpadding="3" cellspacing="3">
            <tr><td><label for="id">ID</label></td>
                <td> <input name="id" /></td>
            </tr>
            <tr><td><label for="summary">Summary</label></td>
                <td> <input name="summary" /></td>
            </tr>
            <tr><td colspan="2">
            <input type="submit" value="Submit" />
            </td></tr>
        </table>
    </form>


    
    </body>
</html>
