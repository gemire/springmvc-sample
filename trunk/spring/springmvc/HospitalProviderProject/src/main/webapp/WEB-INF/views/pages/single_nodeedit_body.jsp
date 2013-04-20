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
    
   
    function getNodeIdForName(searchString)
    {
        var node = recurseName(treeData[0],searchString);
        if (typeof node === "undefined") 
        {
            "-1";
        }
        else
        {
            return node.id+"";
        }
    }

    function recurseName(item,searchString)
    {
        if (item == null)
            return null;
	    
        if (item.name == searchString)
        {
            return item;
        }
        for (i=0;i<item.children.length;i++)
        {
            return recurseName(item.children[i],searchString);
		
        }	 
    }
   
    /////////////////////////////////////////////////////  
    var treeData = [${maintainTreeFormBean.treeData}];
    $(function() {
        $('#tree1').tree({data: treeData});
        $('#tree1').bind(
        'tree.select',
        function(event) {
            // The clicked node is 'event.node'
            var node = event.node;
            $('#maintainId').html(node.id);
            $('#maintainIdHidden1').val(node.id);
            $('#maintainIdHidden2').val(node.id);
            $('#maintainIdHidden3').val(node.id);
            $('#maintainIdHidden4').val(node.id);
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

<style>
    div.formBlock {

        border: 2px solid #59445A;
       	padding: 2px 5px 2px 5px;
        margin:   2px 5px 5px 5px;
        font-weight: bold;
        display: block;
        width: 400px;

    }
</style>




<div>

    <form:form id="errorForm" modelAttribute="maintainTreeFormBean"  >

        <s:bind path="*">
            <c:if test="${status.error}">
                <div class="formBlock" id="errorBlock">
                    <form:errors cssClass="error" />
                </div>
            </c:if>
        </s:bind>


    </form:form>


    <div class="formBlock">
        <h3>Select A Tree</h3>
        <form:form id="formSelect" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/selectTree">


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
            <form:hidden path="selectedNodeId" id="maintainIdHidden4" />
        </form:form>     
    </div>


    <div class="formBlock">
        <h3>Create New Tree</h3>
        <form:form id="formCreate" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/createTree">

            <table cellpadding="4" cellspacing="4">
                <tr><th>Name:</th><td><form:input path="createTreeName" id="createTreeName" /></td>
                    <td><input id="createTreeSubmit"  class="myButton"
                               type="submit" value="Create New Tree"></td></tr>

            </table>
            <form:hidden path="selectedNodeId" id="maintainIdHidden3" />
        </form:form>
    </div>


    <div class="formBlock">
        <h3>Maintain Current Node Data</h3>
        <form:form id="formMaintain" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/maintainNode">
            <table cellpadding="4" cellspacing="4">
                <tr><th>Id:</th><td><span id="maintainId">${maintainTreeFormBean.selectedNodeId}</span></td></tr>
                <tr><th>Type:</th><td><span id="maintainType">${maintainTreeFormBean.maintainType}</span></td></tr>
                <tr><th>Name:</th><td><form:input path="maintainName" id="maintainName" /></td>
                    <td><input type="submit"  class="myButton"  id="maintainNodeSave" name="submit" value="Save"></td> 
                    <td><input type="submit"  class="myButton"  id="maintainNodeDelete" name="submit" value="Delete"></td>
                </tr>
            </table>
            <form:hidden path="selectedNodeId" id="maintainIdHidden2" />
        </form:form>
    </div>


    <div class="formBlock">
        <h3>Insert Node At Current</h3>

        <form:form id="formInsert" method="post"  modelAttribute="maintainTreeFormBean" action="${baseURL}node/forms/insertNode">

            <form:hidden id="insertParentName"  path="insertParentName" />
            <table cellpadding="4" cellspacing="4">
                <tr><th>Name:</th>
                    <td><form:input path="insertName" id="insertName" /></td>
                    <td><input type="submit"  class="myButton"  id="insertNodeSubmit" name="submit" value="Insert"></td>
                </tr></table>
                <form:hidden path="selectedNodeId" id="maintainIdHidden1" />
            </form:form>
    </div>
</div>


<div style="position:absolute;top: 50px; left: 550px">
    <h3>Nodes</h3> 
    <div  id="tree1"></div>
</div>



