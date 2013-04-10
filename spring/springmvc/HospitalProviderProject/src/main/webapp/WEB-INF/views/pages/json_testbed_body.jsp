<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/" />

<!-- http://mbraak.github.com/jqTree
 {
            "type" : "Division",
            "id" : 1,
            "label" : "Alpha",
            "children" : []
        
        }

-->
<script>
    
    var currentParentId = '${parentInfo.id}';
    var sampleTree = "{\"type\": \"Division\",\"id\": 1,\"label\": \"Alpha\",\"children\":[]}";
    var treeData = [];


    $(function() {
        $('#tree1').tree({data: treeData});
 

        $('#tree1').bind(
        'tree.select',
        function(event) {
            // The clicked node is 'event.node'
            var node = event.node;
            $('#idEdit').val(node.id);
            $('#typeEdit').val(node.type);
            $('#nameEdit').val(node.name);
        });
        
        $('#tree1').bind('tree.init', testParent());   
    });

    function testParent() {
        currentParentNode = $('#tree1').tree('getNodeById', currentParentId);
        // alert(currentParentNode.name);
    }


    function createJunk()
    {
           
        //       var bean =  eval($('#tree1').tree('toJson'))[0];
        //        var url = "/neo4j/app/node/forms/fred/sendDivisionTwo.json";
        //        $.postJSON(url, bean, function(returnJSONObj) {
        //               rBean = new Array();
        //               rBean.push(returnJSONObj);
        //               //var tttt = JSON.stringify(rBean);
        //               //alert(tttt);
        //              $('#tree1').tree('loadData', rBean);
        //        });

	
    }
 
    function createNewTree()
    {
        newName =  $('#nameNewTree').val();
        var url = "/neo4j/app/json/testbed/"+newName+"/createNewTree.json";
        
        var jqxhr = $.getJSON( url, function() {
            console.log( "success" );
        })
        .done(function(data) {
            rBean = new Array();
            rBean.push(data);
            var tttt = JSON.stringify(rBean);
            alert(tttt);
    
         })
        .fail(function(e) { console.log( "error "+e ); })
        .always(function() { console.log( "complete" ); });
 
        // perform other work here ...
 
        // Set another completion function for the request above
        jqxhr.complete(function() { console.log( "second complete" ); });
        
        
        
       
    }
 
 
 
 
 
</script>

</head>

<div style="position:absolute;top: 150px; left: 10px">
    <h4>Nodes</h4> 
    <div  id="tree1"></div>
</div>


<div style="position:absolute;top: 150px; left: 400px">

    <p>
    <h4>Modify Node Data</h4>
    <table cellpadding="4" cellspacing="4">
        <tr><th>Id:</th><td><input name="id" id="idEdit"   readonly="true" ></td></tr>
        <tr><th>Type:</th><td><input name="type" id="typeEdit" ></td></tr>
        <tr><th>Label:</th><td><input name="name" id="nameEdit" ></td></tr>
        <tr><td colspan="2"><button onClick="addNode()">Add This Node To Current Parent"</button></td></tr>
        <tr><td colspan="2"><button onClick="editNode()">Edit This Node"</button></td></tr>
        <tr><td colspan="2"><button onClick="deleteNode()">Delete This Node"</button></td></tr>
    </table>
</p>

<p>
<h4>Create New Tree</h4>
<table cellpadding="4" cellspacing="4">
    <tr><th>Initial Node Name:</th><td><input name="name" id="nameNewTree" ></td></tr>
    <tr><td colspan="2"><button onClick="createNewTree()">Create New Tree</button></td></tr>
</table>
</p>
<button onclick="testParent()">Parent</button>
</div>




