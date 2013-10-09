<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/" />



<ol>
    <li>BookMaker: ${controller.bookMaker}</li>
    <li>Message: ${controller.message}</li>
    <li>Message: ${controller}</li>
</ol>

${bookMaker}

	 