<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="baseURL" value="/app/" />


<div class="warning">Tested only in Chrome</civ>
<div id="content" class="content">
    <!-- Content div that is filled by the router -->
</div>




<!--
http://blog.karlwestin.com/2012/04/nested-modelscollections-and-storage-with-bac/
https://github.com/backbone-boilerplate/backbone-boilerplate/blob/master/app/main.js#L22
-->


<script type="text/javascript">
    <%-- needed to remove jsp style inserts which are the default for underscore --%>
    _.templateSettings = {
    interpolate: /\<\@\=(.+?)\@\>/gim,
    evaluate: /\<\@([\s\S]+?)\@\>/gim,
    escape: /\<\@\-(.+?)\@\>/gim
    };
    var router = new ApplicationRouter($('#content'));
    Backbone.history.start();

   // All navigation that is relative should be passed through the navigate
  // method, to be processed by the router.  If the link has a backboneActive
  // attribute, use this code else bypass this delegation completely.
  $(document).on("click", "a[backboneActive]", function(evt) {
    // Get the anchor href and protcol
    var href = $(this).attr("href");
    var protocol = this.protocol + "//";

    // Ensure the protocol is not part of URL, meaning its relative.
    if (href && href.slice(0, protocol.length) !== protocol &&
        href.indexOf("javascript:") !== 0) {
      // Stop the default event to ensure the link will not cause a page
      // refresh.
      evt.preventDefault();

      // `Backbone.history.navigate` is sufficient for all Routers and will
      // trigger the correct events.  The Router's internal `navigate` method
      // calls this anyways.
      Backbone.history.navigate(href, true);
    }
  });





</script>