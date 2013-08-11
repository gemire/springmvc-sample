<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/backbone/demos/" />

<script src="js/backbone/backbone.localStorage.js"></script>
<script src="js/backbone/localstorage/models.js"></script>
<script src="js/backbone/localstorage/views.js"></script>
<script src="js/backbone/localstorage/router.js"></script>



<script type="text/template" id="listTemplate">
    <div class="warning">Tested only in Chrome</div>
    <div class="row span6">
    <table class="fade in table table-condensed table-hover">
    <thead>
    <tr>
    <th>First name</th>
    <th>Second name</th>
    <th></th>
    </tr>
    </thead>	
    <tbody>
    </tbody>		
    </table>
    <a class="btn btn-small btn-primary" backboneActive="true" href="#add">Add a contact</a>	
    </div>

</script>
<!--
<c:out value="${baseURL}localstorage.html#app" />
-->
<script type="text/template" id="addTemplate">
    <form method="post" action="#" id= 'addForm' onsubmit="return false">
    <label for="firstname">First name</label>
    <input id="firstname" name='firstname' type="text" /><br />
    <label for="lastname">Last name</label>
    <input id="lastname" name='lastname' type="text" /><br />
    <input type="submit" value='Add'/>
    <input id="cancel" class="btn btn-small btn-warning" type="button" value="Cancel" />
    </form>
</script>

<script type="text/template" id="contactTemplate">
    <td><@= firstname@></td>
    <td><@= lastname@></td>
    <td><button class="btn btn-small btn-warning delete">delete</button></td>
</script>

 
