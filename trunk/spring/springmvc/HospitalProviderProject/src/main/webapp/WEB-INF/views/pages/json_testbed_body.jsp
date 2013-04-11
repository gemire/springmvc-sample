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
                
    }); 
</script>

</head>

<div style="position:absolute;top: 150px; left: 10px">
    <h4>Nodes</h4> 
    <div  id="tree1"></div>
</div>


<div style="position:absolute;top: 150px; left: 400px">

    <p>
    <h4>New Node Data</h4>
    <form:form id="form" method="post" modelAttribute="434" action="${baseURL}json/testbed/maintainNode">

        <table cellpadding="4" cellspacing="4">
            <tr><th>Type:</th><td><input name="type" id="type" ></td></tr>
            <tr><th>Label:</th><td><input name="name" id="name" ></td></tr>
            <tr><td colspan="2"><input type="submit" name="submit" value="Add"></td></tr>
            <tr><td colspan="2"><input type="submit" name="submit" value="Delete"></td></tr>
        </table>
    </form:form>
</p>

<p>
<h4>Create New Tree</h4>
<form:form id="form" method="post" modelAttribute="r43" action="${baseURL}json/testbed/createTree">

    <table cellpadding="4" cellspacing="4">
        <tr><th>Type:</th><td><input name="type" id="type" ></td></tr>
        <tr><th>Label:</th><td><input name="name" id="name" ></td></tr>
        <tr><td colspan="2"><input type="submit" value="Create New Tree"></td></tr>

    </table>
</form:form>
<button onclick="testParent()">Parent</button>
</div>




