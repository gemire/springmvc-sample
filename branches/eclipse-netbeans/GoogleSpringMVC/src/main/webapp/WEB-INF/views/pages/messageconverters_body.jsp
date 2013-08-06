<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>
<c:url var="baseURL" value="/app/views/" />

<p>
    Message Conversion or request/form conversion/processing demonstrations
</p>

<c:url var="stringPostVar" value="/app/messageconverters/stringPOST.html" />
<div class="offset1">



    <form id="readString" class="form-inline"
          action="<c:out value="${stringPostVar}" />" method="post">
        <input type="hidden" name="personalValue" value="astounding" />
        <input type="hidden" name="future" value="rosy" />
        <input class="btn large btn-primary" type="submit" value="Read a Post as String" />
        <input class="input-medium" type="text" size="20" name="input" value="boundless" />
   </form>





    <form id="readXml" class="form-inline" action="<c:url value="/app/messageconverters/xml.xml" />"
          method="get">
        <input class="btn large btn-primary" id="readXmlSubmit" type="submit" value="Read XML" />
    </form>


    <div class="btn-group btn-group-vertical">         
        <button class="btn large btn-primary" onclick="getJSON();">Get JSON via JQuery</button>
        <button  class="btn large btn-primary" onclick="getXML();">Get XML via jQuery</button> 
    </div>

</div>               





<c:choose>
    <c:when test="${not empty results}">
        <div class="row offset1">
            <div class="blue">

                <div>${results}</div>
            </div>

        </div>
    </c:when>
    <c:otherwise></c:otherwise>
</c:choose>                


<script>


    function getJSON() {


    $.getJSON('<c:url value="/app/messageconverters/xml.json" />', function(item) {
    alert(item.foo);
    });


    }

    function xmlToString(xmlData) {
    var xmlString;
    //IE     
    if (window.ActiveXObject)
    {
    xmlString = xmlData.xml;
    }
    // code for Mozilla, Firefox, Opera, etc.     
    else
    {
    xmlString = (new XMLSerializer()).serializeToString(xmlData);
    }

    return xmlString;
    }


    function getXML()
    {
    $.ajax({
    type: "GET",
    url: "<c:url value="/app/messageconverters/xml.xml" />",
    dataType: "xml",
    success: function(xml) {
    alert(xmlToString(xml));
    }
    });
    }


</script>




