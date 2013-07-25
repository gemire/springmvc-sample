<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"  %> 
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"  %> 

<%

 

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><tiles:insertAttribute name="title" ignore="true" />
		</title>
		 
		<base href="<%= basePath %>" />
		<script type="text/javascript"  src="js/jquery-1.6.2.min.js"></script>
 		<script type="text/javascript"  src="js/json.min.js"></script>
		<script type="text/javascript"	src="js/jquery-ui-1.8.15.custom.min.js"></script>
		<script type="text/javascript"	src="js/jquery.cookie.js"></script>

		<script>
		var $dialog = null;
		
		$(document).ready(function() {
			
			var cookieOptions = {
				    domain: '<%= request.getServerName() %>',
				    path: '/',
				    expiresAt: new Date( 3011, 1, 1 ),
				    secure: false
				  };
			
			var cookieName = 'navAccordion';
	        var activeIndex = $.cookie(cookieName);
	        activeIndex = parseInt(activeIndex, 10);
	        if (isNaN(activeIndex)) {
	            activeIndex = 0; //set to index for desired default open item
	        }
			
			
			
			$dialog = $('#explainPanel').dialog({ height: 350,
                width: 400,
                modal: false,
                position: 'center',
                autoOpen:false,
                title:'Page Explanation',
                overlay: { opacity: 0.5, background: 'black'}
                });
			
			$( "#menu" ).accordion({
					fillspace: true,
					collapsible: true,
		            autoHeight: false,
		            active: activeIndex,
		            change: function (e, ui) {
		                $.cookie(cookieName, $(this).find('h3').index(ui.newHeader[0]),cookieOptions);
		            }				
					});
		
		});
		
		function explain()
		{
			$dialog.dialog('open');	
		
		}
		</script>


		<link rel="stylesheet" href="css/newmain.css" type="text/css"></link>
		<link rel="stylesheet" href="css/jquery-ui-1.8.15.custom.css" type="text/css"></link>

	</head>
	<body>
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>

		<div id="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		<div id="body">
			<div class="column header1" id="subTitle">
				<tiles:getAsString name="subTitle" />
				<button id="helpButton" class="myButton itemContainer" onclick="explain()">Explain</button>
			</div>
			<div id="innerBody">
			<tiles:insertAttribute name="body" />  
			</div>
		</div>
		<div id="explainPanel"><tiles:insertAttribute name="explainPanel"/></div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</body>
	
</html>
