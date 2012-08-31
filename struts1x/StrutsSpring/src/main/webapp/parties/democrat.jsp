<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>    
<html>
<head>
</head>
<body>
<h1>Democrat page</h1>
<h1><bean:write name="voteForm" property="slogan" />
</h1>

<p>

<html:link  page="/Welcome.do">Home</html:link>

</p>

</body>
</html>