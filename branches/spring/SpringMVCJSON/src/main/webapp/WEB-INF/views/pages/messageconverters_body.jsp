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

<table border="1" cellpadding="4" cellspacing="4">
	<tr>
		<td>
			Read a Post as a String
		</td>
		<td>
			<form id="readString" class="textForm"
				action="<c:out value="${stringPostVar}" />" method="post">
				<input type="hidden" name="personalValue" value="astounding" />
				<input type="hidden" name="future" value="rosy" />

				<input type="text" size="20" name="input" value="boundless" />

				<input class="myButton" type="submit" value="Read a String" />
			</form>
		</td>
	</tr>




	<tr>
		<td>
			Read XML
		</td>
		<td>

			<form id="readXml" action="<c:url value="/app/messageconverters/xml.xml" />"
				method="get">
				<input class="myButton" id="readXmlSubmit" type="submit" value="Read XML" />
			</form>

		</td>
	</tr>



<tr><td>JSON via jQuery</td><td><button class="myButton" onclick="getJSON()">Get JSON</button></td></tr>
<tr><td>XML via jQuery</td><td><button  class="myButton" onclick="getXML()">Get XML</button></td></tr>
</table>
<script>


function getJSON() {

	 
    $.getJSON('<c:url value="/app/messageconverters/xml.json" />',  function(item) {
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

	   return xmlString; }    


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


<c:choose>
	<c:when test="${not empty results}">


		<div class="resultsClass">
			${results}
		</div>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>


