<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort();

	String appPath = basePath + path;
%>


<html>
	<head>
		<title><tiles:getAsString name="title" />
		</title>
		
		
		
	
		<meta name="GENERATOR" content="IBM WebSphere Studio" />
	
 
 	<link rel='stylesheet' type='text/css'
			href='<%=appPath %>/theme/layout.css' />
		<link rel='stylesheet' type='text/css'
			href='<%=appPath %>/theme/table.css' />
 
<link rel='stylesheet' type='text/css'
			href='<%=appPath %>/theme/menu.css' />


	<script type="text/javascript" src="<%= appPath %>/js/jquery-1.6.1.js"></script>
	<script type="text/javascript" src="<%= appPath %>/js/menu.js"></script> 
	
	</head>
	<body>
		<table class='layouttable' border="0" cellpadding="5" cellspacing="5"
			width="100%" height="100%">
			<tr>
				<td class="headerpane" colspan="2">
					<tiles:insert attribute="header" />
				</td>
			</tr>
			<tr>
				<td class="menupane" style="display: none;" id="menubar">
					<!-- Begin Menu Layer -->
					<div id="menuLayer" style="display: inline;">
						<tiles:insert attribute='menu' />
					</div>
					<!-- End Menu Layer -->
				</td>
				<td class="bodypane">
					<tiles:insert attribute='body' />
				</td>
			</tr>
		</table>
		
		
		
	
		
		
		
		
	</body>
</html>
