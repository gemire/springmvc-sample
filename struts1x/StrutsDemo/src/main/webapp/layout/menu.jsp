<%@ page language="java" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<ul class="menu">

	<li class="expand">
		<a href="#">Struts Navigation</a>
		<div class="acitem panel">
			<ul>
				<li>
					<html:link module="" action="/mainTiles.do">Main Page</html:link>
				</li>
				<li>
					<html:link module="" title="demonstrates tiles forwarding" action="/main.do">Main Page via Tiles Forward</html:link>
				</li>
				<li>
					<html:link  title="demonstrates multiple struts modules" module="/moduleB" action="/mainB.do">Main Page via ModuleB</html:link>
				</li>
				<li>
					<html:link title="demonstrates error pages" module="/moduleB" action="/errorPageDemo.do">Error Page Demo</html:link>
				</li>
			 
					
				<li>
				    <html:link title="Set property and ActionMappings" module="" action="/actionMappingOne.do" >Action Mappings</html:link>
					 
				</li>
				<li>
				    <html:link title="Special Error Handling" module="" action="/errorDemoForward.do" >Error Handling</html:link>
					 
				</li>
				
			</ul>
		</div>
		
	</li>
	
	<li class="expand">
		<a href="#">Form Demos</a>
		<div class="acitem panel">
		<ul>
				<li>
				    <html:link title="multi part forms" module="" forward="global.step1.tiles" >Forms Using Tiles</html:link>
				</li>
				<li>
				    <html:link title="validation" module="/example" action="/showDynaActionForm.do" >Dynaforms and Validator</html:link>
				</li>
		</ul>		
		</div>
	</li>
	<li class="expand">
		<a href="#">Tiles Demos</a>
		<div class="acitem panel">
			<ul>
				<li>
					<html:link title="nested tiles examples" module="/moduleB" action="/nestedTilesDemos.do">Nested Tiles Demos</html:link>
				</li>
				
				<li>
					<html:link title="nested tiles examples" module="/example" action="/showCustomerSearchForm.do">Tiles And Validation</html:link>
				</li>
				
			</ul>
		</div>
	</li>
	
	
	<li class="expand">
		<a href="#">Struts Beans</a>
		<div class="acitem panel">
			<ul>
				<li>
					<html:link title="various tag demos" module="" action="/beanTest.do">Bean Test</html:link>
				</li>
			</ul>
		</div>
	</li>

<li class="expand">
		<a href="#">JSTL Tags</a>
		<div class="acitem panel">
			<ul>
				<li>
					<html:link module="" title="jstl tag demos" action="/jstlSetStart">Logic,For each,<br/>Tiles Bean Put</html:link>
				</li>
				<li>
					<html:link module="" title="use of tiles and beans" action="jstlButton">Button Demo</html:link>
				</li>			</ul>
		</div>
	</li>


</ul>
<!-- http://www.i-marco.nl/weblog/jquery-accordion-3/ -->