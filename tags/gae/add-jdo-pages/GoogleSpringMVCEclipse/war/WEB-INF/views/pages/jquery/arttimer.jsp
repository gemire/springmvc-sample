<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>


<%
    String path = request.getContextPath();
    String baseURL = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

%>

<link rel="stylesheet" href="css/arttimer.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery.timers.js"></script>
<script type="text/javascript" src="js/arttimer.js"></script>

<script>
	var imageNames = new Array("<%= baseURL %>simages/a1.jpg", 
			"<%= baseURL %>simages/a2.jpg", "<%= baseURL %>simages/a3.jpg", "<%= baseURL %>simages/a4.jpg",
			"<%= baseURL %>simages/a5.jpg", "<%= baseURL %>simages/a6.jpg","<%= baseURL %>simages/a7.jpg",
			"<%= baseURL %>simages/a8.jpg","<%= baseURL %>simages/a9.jpg");
</script>

<div class="row offset1">
	<div id="fileAnnouncementDiv" class="fileAnnouncement">File
		Announcement</div>
</div>

<div class="row offset1 span12">

	<div id="controlContainerDiv" class="form-inline">

		<button class="btn btn-small btn-primary" id="startButton"
			onclick="startTimer()">Start</button>
		<button class="btn btn-small btn-primary" id="stopButton"
			onclick="stopTimer()">Stop</button>
		<button class="btn btn-small btn-primary" id="resetButton"
			onclick="resetTimer()">Reset</button>
		Delay: <select id="maxTimeSelect">
			<option>5</option>
			<option>90</option>
			<option>60</option>
			<option>180</option>
			<option>240</option>
			<option>10</option>

		</select> Image: <select onchange="imageChange(this)" id="imageSelect"></select>


	</div>
</div>
<!--  end control row -->

<div class="row span12">
	<div class="offset1">
		<table>
			<tr>
				<td>
					<div id="imageContainer" class="imageContainerDiv">
						<img id="topImage" class="displayImagePosition onTop"></img> 
						<img id="bottomImage" class="displayImagePosition onBottom"></img>
					</div></td>
				<td>
					<div class="span6">
						<div id="countDownText">1</div>
					</div></td>
			</tr>


		</table>

	</div>

</div>





