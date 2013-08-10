<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

%>
<h3>Admin Page</h3>
<p>Only admins have access to this page.</p>
<p>Curabitur quis libero elit, dapibus iaculis nisl. Nullam quis velit eget odio 
adipiscing tristique non sed ligula. In auctor diam eget nisl condimentum laoreet..</p>

<p><a href="<%= basePath %>/app/security/demo/logout">Log Out</a></p>
 