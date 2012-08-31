<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
</head>
<body>
<h1>Welcome</h1>
<p></p> 

<ol>
<li><html:link page="/Alpha.do">Alpha</html:link></li>
<li><html:link page="/Beta.do">Beta</html:link></li>
<li><html:link page="/helloWorld.do">Hello</html:link></li>
<li><html:link  forward="votePage">Get Out the Vote</html:link></li>
<li><html:link page="/beanDemo.do">Bean Demo</html:link></li>
<li><a href="<%= request.getContextPath() %>/SpringServlet">Spring Context in a Servlet</a>

</ol>

</body>
</html>