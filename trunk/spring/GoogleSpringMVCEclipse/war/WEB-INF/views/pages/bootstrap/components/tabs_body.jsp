<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%>
<%@ taglib uri="/WEB-INF/tld/spring-form.tld" prefix="form"%>


<c:url var="baseURL" value="/app/components/tabs.html" />


  
        <ul class="nav nav-tabs" id="myTab">
            <li class="active"><a href="${baseURL}#home" data-toggle="pill">Home</a></li>
            <li><a href="${baseURL}#profile" data-toggle="pill"  >Profile</a></li>
            <li><a href="${baseURL}#messages" data-toggle="pill">Messages</a></li>
            <li><a href="${baseURL}#settings" data-toggle="pill">Settings</a></li>
        </ul>

        <div class="tab-content">
            <div class="tab-pane active" id="home">home</div>
            <div class="tab-pane" id="profile">profile</div>
            <div class="tab-pane" id="messages">messages</div>
            <div class="tab-pane" id="settings">settings</div>
        </div>


