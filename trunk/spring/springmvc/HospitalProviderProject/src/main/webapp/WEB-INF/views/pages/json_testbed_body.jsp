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
    
   
    
    var treeData = [${treeData}];


    $(function() {
        $('#tree1').tree({data: treeData});
 

        $('#tree1').bind(
        'tree.select',
        function(event) {
            // The clicked node is 'event.node'
            var node = event.node;
            $('#maintainId').html(node.id);
            $('#maintainType').html(node.type);
            $('#maintainName').val(node.name);
        });
                
    }); 
</script>

</head>

<div style="position:absolute;top: 150px; left: 10px">
    <h4>Nodes</h4> 
    <div  id="tree1"></div>
</div>


<div style="position:absolute;top: 150px; left: 400px">
    <h4>Current Node</h4>  




    <p>
    <h4>Maintain Current Node Data</h4>
    <form:form id="form" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}json/testbed/maintainNode">
        <div>

            <c:if test="${not empty message}">
                <div id="message" class="${message.type}">${message.text}</div>	
            </c:if>
            <s:bind path="*">
                <c:if test="${status.error}">
                    <form:errors cssClass="error" />
                </c:if>
            </s:bind>


        </div>
        <table cellpadding="4" cellspacing="4">
            <tr><th>Id:</th><td><span id="maintainId"  /></td></tr>
            <tr><th>Type:</th><td><span id="maintainType" /></td></tr>
            <tr><th>Name:</th><td><form:input path="name" id="maintainName" /></td></tr>
            <tr>
                <td><input type="submit" id="maintainNodeSave" name="submit" value="Save"></td> 
                <td><input type="submit" id="maintainNodeDelete" name="submit" value="Delete"></td>
            </tr>
        </table>
    </form:form>
</p>

<p>
<h4>Create New Tree</h4>
<form:form id="form" method="post"  modelAttribute="createTreeFormBean" action="${baseURL}json/testbed/createTree">
    <div>

        <c:if test="${not empty message}">
            <div id="message" class="${message.type}">${message.text}</div>	
        </c:if>
        <s:bind path="*">
            <c:if test="${status.error}">
                <form:errors cssClass="error" />
            </c:if>
        </s:bind>


    </div>
    <table cellpadding="4" cellspacing="4">
        <tr><th>Name:</th><td><form:input path="name" id="createTreeName" /></td></tr>
        <tr><td colspan="2"><input id="createTreeSubmit" 
                                   type="submit" value="Create New Tree"></td></tr>

    </table>
</form:form>

</div>




