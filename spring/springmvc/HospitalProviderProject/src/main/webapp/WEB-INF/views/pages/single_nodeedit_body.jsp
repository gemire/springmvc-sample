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
    
   
    
    var treeData = [${maintainTreeFormBean.treeData}];


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
            $('#insertParentName').val(node.name);
        });
        
        selectedNode = '${maintainTreeFormBean.selectedNodeId}';
        selectedNodeVal = parseInt(selectedNode);
        var node = $('#tree1').tree('getNodeById', selectedNodeVal);
        $('#tree1').tree('selectNode', node);
                
    }); 
</script>

</head>


<div style="position:absolute; top: 70px; left: 10px">
    <h3>Select A Tree</h3>
    <form:form id="form" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/selectTree">
        <div   class="linespacer">
            <s:bind path="*">
                <c:if test="${status.error}">
                    <form:errors cssClass="error" />
                </c:if>
            </s:bind>
        </div>


        <span class="linespacer">
            <form:select id="selectATree" path="selectedTree">             
                <form:option  value="NONE" label="---"/>
                <form:options items="${maintainTreeFormBean.treeSelectList}" />
            </form:select> 
        </span>
        <span  class="linespacer">
            <input id="selectTreeSubmit" class="myButton"
                   type="submit" value="Select">
        </span>
    </form:form>     
</div>   


<div style="position:absolute; top: 70px;  left: 300px">     
    <h3>Create New Tree</h3>
    <form:form id="form" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/createTree">

        <table cellpadding="4" cellspacing="4">
            <tr><th>Name:</th><td><form:input path="createTreeName" id="createTreeName" /></td>
                <td><input id="createTreeSubmit"  class="myButton"
                           type="submit" value="Create New Tree"></td></tr>

        </table>
    </form:form>
</div>






<div style="position:absolute;top: 250px; left: 10px">
    <h3>Nodes</h3> 
    <div  id="tree1"></div>
</div>


<div style="position:absolute;top: 250px;   left: 300px">

    <h3>Maintain Current Node Data</h3>
    <form:form id="form" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/maintainNode">
        <table cellpadding="4" cellspacing="4">
            <tr><th>Id:</th><td><span id="maintainId">${maintainTreeFormBean.maintainId}</span></td></tr>
            <tr><th>Type:</th><td><span id="maintainType">${maintainTreeFormBean.maintainType}</span></td></tr>
            <tr><th>Name:</th><td><form:input path="maintainName" id="maintainName" /></td></tr>
            <tr>
                <td><input type="submit"  class="myButton"  id="maintainNodeSave" name="submit" value="Save"></td> 
                <td><input type="submit"  class="myButton"  id="maintainNodeDelete" name="submit" value="Delete"></td>
            </tr>
        </table>
    </form:form>

</div>



<div style="position:absolute;top: 250px;   left: 650px">

    <h3>Insert Node At Current</h3>

    <form:form id="form" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/insertNode">

        <form:hidden id="insertParentName"  path="insertParentName" />
        <table cellpadding="4" cellspacing="4">
            <tr><th>Name:</th>
                <td><form:input path="insertName" id="insertName" /></td>
                <td><input type="submit"  class="myButton"  id="insertNodeSubmit" name="submit" value="Insert"></td>
            </tr></table>
        </form:form>

</div>


