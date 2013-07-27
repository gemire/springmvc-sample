<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

%>
<h3>Special Admin Page</h3>
<p>Only admins have access to this page. It is secured via annotations See <code>com.dhenton9000.spring.mvc.controllers.SecurityController</code></p>
 

<p><a href="<%= basePath %>/app/security/demo/logout">Log Out</a></p>
 