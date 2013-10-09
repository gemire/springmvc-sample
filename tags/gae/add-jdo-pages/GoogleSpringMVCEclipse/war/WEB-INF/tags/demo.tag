<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="repeat" type="java.lang.Integer" required="true"%>
<%@ attribute name="items" type="java.util.List" rtexprvalue="true"%>
<%@ attribute name="url" type="java.lang.String"%>

<ol>
	<c:forEach items="${items}" var="par">
		<li>${par}</li>
	</c:forEach>
</ol>
<div class="itemContainer">
<ol>

<c:forEach begin="1" end="${repeat}" var="t">
<li>Repeated ${t} times</li>


</c:forEach>
</ol>
</div>

