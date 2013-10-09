<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/" />



    


		
		<script type="text/javascript">
		$(document).ready(function() {
			$("#form").submit(function() {  
			
				$.post($(this).attr("action"), $(this).serialize());
			
			});
		
		});
		
		function submitForm()
		{
			var formVar = $('#form');
			var info = formVar.serialize();
			alert(formVar.attr("action"));
			alert(info);
			$.post(formVar.attr("action"), formVar.serialize(),function(html) {$("#infoMark").replaceWith(html);  });
		
		}
		
		
		
		</script>
		



		 
		<form:form id="form" method="post" cssClass="form-horizontal" modelAttribute="formBean" action="${baseURL}complex/forms/addForm">
			<div>
				
		  		<c:if test="${not empty message}">
					<div id="message" class="${message.type}">${message.text}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="text-error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
		  		
		  		
			</div>
		  	<fieldset>
		  		<legend>Personal Info</legend>
		  		
		  		<table>
		  		
		  		<tr>
		  		<td>
		  		<form:label path="name">Name 
		  		<form:errors path="name" cssClass="text-error" />
		  		</form:label>
		  		</td>
		  		<td><form:input path="name" /></td>
		  		</tr>
		  		
	  		
		  		<tr>
		  		<td>
		  		<form:label path="age">
		  			Age <form:errors path="age" cssClass="text-error" />
		 		</form:label>
		  		</td>
		  		<td><form:input path="age" /></td>
		  		</tr>
		  		
		  		<tr>
		  		<td>
				<form:label path="birthDate">
		  			Birth Date (in form yyyy-mm-dd) <form:errors path="birthDate" cssClass="text-error" />
		 		</form:label>		  		
		 		</td>
		  		<td><form:input path="birthDate" /></td>
		  		</tr>
		  		
		  		<tr>
		  		<td>
				<form:label path="currency">
		  			Currency (in form $#.##) <form:errors path="currency" cssClass="text-error" />
		  		</form:label>
		  		</td>
		  		<td><form:input path="currency" /></td>
		  		</tr>

		  		<tr>
		  		<td>
				<form:label path="percent">
		  			Percentage (in form ##%) <form:errors path="percent" cssClass="text-error" />
		  		</form:label>
		  		</td>
		  		<td><form:input path="percent" /></td>
		  		</tr>
		  		
		  		</table>
			  		
		  		<%--  
		  		<form:label path="phone">
		  			Phone (in form (###) ###-####) <form:errors path="phone" cssClass="text-error" />
		  		</form:label>
		  		<form:input path="phone" />
				--%>
		  		
		  		 
		  	</fieldset>
	
			<fieldset>
				<legend>Inquiry</legend>
				<form:label path="inquiry">
					Type (select one)
				</form:label>
				<form:select path="inquiry">
					<form:option value="comment">Comment</form:option>
					<form:option value="feedback">Feedback</form:option>
					<form:option value="suggestion">Suggestion</form:option>
				</form:select>
				
		  		<form:label path="inquiryDetails">
		  			Details
		  		</form:label>
		  		<form:textarea path="inquiryDetails" />
		  	</fieldset>
	
			<fieldset class="checkbox">
				<legend>Request Additional Info</legend>
				<label><form:checkbox path="additionalInfo[mvc]" value="true" />on Spring MVC</label>
				<label><form:checkbox path="additionalInfo[java]" value="true" />on Java (4-ever)</label>				
			</fieldset>
		  		  	
			<fieldset class="radio">
				<legend>Subscribe to Newsletter?</legend>
				<label><form:radiobutton path="subscribeNewsletter" value="true" />Yes</label>
				<label><form:radiobutton path="subscribeNewsletter" value="false" /> No</label>
			</fieldset>
	
			<p><button class="btn-large btn-primary" type="submit">Submit</button></p>
		</form:form>
		
	
