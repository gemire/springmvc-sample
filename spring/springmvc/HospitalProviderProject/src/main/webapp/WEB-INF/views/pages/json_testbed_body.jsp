<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/" />


<script>
    


    
 
 
 
 
 function sendTest()
    {
           
       // var bean =  eval($('#tree1').tree('toJson'))[0];
        var url = "/neo4j/app/node/forms/fred/sendDivisionTwo.json";
        $.postJSON(url, bean, function(returnJSONObj) {
              var tttt = JSON.stringify(returnJSONObj);
             alert(tttt);
        });

	
    }
 
 
 
 
 
 
 
</script>

</head>
 


<div>
 
    <p><button onclick="sendTest()">Send Test</button></p>
     
</div>




