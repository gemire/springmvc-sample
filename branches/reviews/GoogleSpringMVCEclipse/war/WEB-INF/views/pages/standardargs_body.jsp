<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/data/standard/" />

<p class="bar-info">
    This is a collection of demos of standard argument access in
    controllers
</p>
<div class="offset2">
    <div class="row">
        <div class="span6">
            <h4>Request Variables</h4>
            <a class="btn large btn-primary"  href="<c:out value="${baseURL}request.html"/>">Go</a>
        </div>


        <div class="span6">
            <h4>Request Reader</h4>
            <form action="<c:out value="${baseURL}request/reader.html"/>" method="POST" >
                <input class="btn large btn-primary" type="submit" value="Go" />
            </form>
        </div>
    </div>
    <div class="row">
        <div class="span6">
            <h4>Request InputStream</h4>
            <form action='<c:out value="${baseURL}request/is.html"  />' method="POST" >
                <input class="btn large btn-primary"  type="submit" value="Go" />
            </form>
        </div>
        <div class="span6">
            <h4>Response</h4>
            <a class="btn large btn-primary"  href="<c:out value="${baseURL}response.html"/>">Go</a>
        </div>
    </div>
    <div class="row">
        <div class="span6">
            <h4>Session</h4>
            <a class="btn large btn-primary" href="<c:out value="${baseURL}session.html"/>">Go</a>
        </div>
    </div>
</div>
<c:choose>
    <c:when test="${not empty results}">
        <div class="row offset1">
            <div class="blue">
                 <h5>${results.description}</h5>
                <div>${results.result}</div>
            </div>

        </div>
    </c:when>
    <c:otherwise></c:otherwise>
</c:choose>
