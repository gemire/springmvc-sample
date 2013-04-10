<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/" />


<script>
    <!-- http://mbraak.github.com/jqTree -->
    var fred = [

        {
            "type" : "Division",
            "id" : 1,
            "label" : "Alpha",
            "children" : [ 
                {
                    "type" : "Division",
                    "id" : 2,
                    "label" : "Division2",
                    "children" : [ ]
                } 
                ,{
                    "type" : "Provider", "id" : 3, 
                    "label" : "Provider2", 
                    "children" : [ 
                        {
                            "type" : "Provider",
                            "id" : 4,
                            "label" : "Provider4",  
                            "children" : [ ]
                        }
    
                    ]
                } ,{
                    "type" : "Provider",
                    "id" : 5,
                    "label" : "Provider3",
                    "children" : [ ]
                } 
  
  
  
            ]
        }


    ];


    $(function() {
        $('#tree1').tree({
            data: fred 
        });
 

        $('#tree1').bind(
        'tree.select',
        function(event) {
            // The clicked node is 'event.node'
            var node = event.node;
            $('#id').val(node.id);
            $('#type').val(node.type);
            $('#name').val(node.name);
        }
    );
    });
 
 

 
 function sendTreeTwo()
    {
           
       var bean =  eval($('#tree1').tree('toJson'))[0];
        var url = "/neo4j/app/node/forms/fred/sendDivisionTwo.json";
        $.postJSON(url, bean, function(returnJSONObj) {
               rBean = new Array();
               rBean.push(returnJSONObj);
               //var tttt = JSON.stringify(rBean);
               //alert(tttt);
              $('#tree1').tree('loadData', rBean);
        });

	
    }
 
 
 
 
 
 
 
</script>

</head>

<div style="position:absolute;top: 150px; left: 10px">
    <h4>Nodes</h4> 
    <div  id="tree1"></div>
</div>


<div style="position:absolute;top: 150px; left: 400px">
    <h4>Edit The Current Node</h4>
    <form:form id="form" method="post" modelAttribute="nodeBean" action="${baseURL}node/forms/nodeForm">

        <table cellpadding="4" cellspacing="4">
            <tr><th>Id:</th><td><input name="id" id="id"   readonly="true" ></td></tr>
            <tr><th>Type:</th><td><input name="type" id="type" ></td></tr>
            <tr><th>Label:</th><td><input name="name" id="name" ></td></tr>
            <tr><td colspan="2"><input type="submit" value="Edit Node"></td></tr>
        </table>
    </form:form>
    <hr/>
    
    <p><button onclick="sendTreeTwo()">Send Tree 2</button></p>
</div>




