<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="baseURL" value="/app/" />
<SCRIPT type=text/javascript src="js/jquery.form.js"></SCRIPT>

<script>
    $(document).ready(function() {
        var options = {
            //	target : '#target1', // target element(s) to be updated with server response 
            beforeSubmit: showRequest, // pre-submit callback 
            dataType: 'json',
            success: showResponse
                    // post-submit callback 

                    // other available options: 
                    //url:        override for form's 'action' attribute 
                    //type:      type        // 'get' or 'post', override for form's 'method' attribute 
                    //dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
                    //clearForm: true        // clear all form fields after successful submit 
                    //resetForm: true        // reset the form after successful submit 

                    // $.ajax options can be used here too, for example: 
                    //timeout:   3000 
        };

        // bind form using 'ajaxForm' 
        $('#demoForm').ajaxForm(options);
    });

    function clearText() {

        $("#target1").text("");
        $("#tableTarget").text("");

    }

// pre-submit callback 
    function showRequest(formData, jqForm, options) {
        // formData is an array; here we use $.param to convert it to a string to display it 
        // but the form plugin does this for you automatically when it submits the data 
        var queryString = $.param(formData);

        // jqForm is a jQuery object encapsulating the form element.  To access the 
        // DOM element for the form do this: 
        // var formElement = jqForm[0]; 

        //alert('About to submit: \n\n' + queryString);
        $('#target1').append("Query string posted: " + queryString + "<br/>");

        // here we could return false to prevent the form from being submitted; 
        // returning anything other than false will allow the form submit to continue 
        return true;
    }

// post-submit callback 
    function showResponse(responseItem, statusText, xhr, $form) {
        // for normal html responses, the first argument to the success callback 
        // is the XMLHttpRequest object's responseText property 

        // if the ajaxForm method was passed an Options Object with the dataType 
        // property set to 'xml' then the first argument to the success callback 
        // is the XMLHttpRequest object's responseXML property 

        // if the ajaxForm method was passed an Options Object with the dataType 
        // property set to 'json' then the first argument to the success callback 
        // is the json data object returned by the server 

        var resVar = '<b>Response</b>: status: '
                + statusText
                + '\n\Sample item ISBN: \n'
                + responseItem[0].iSBN + "<br/>";


        $('#target1').append(resVar);

        writeData(responseItem);
        //$("#target1").text(responseItem.ISBN);
        //$("#target1").append("<br/>"+responseItem.reviewers[0]);
    }

    function writeData(list) {
        var table = $('#tableTarget');
        var tStr = "<tr><th>Office Code</th><th>ISBN</th><th>Num Pages</th><th>Title</th></tr>";


        $('#target1').append("<p>The array has size of " + list.length + "</p>");

        $.each(list, function(index, data) {

            tStr += "<tr><td>" + data.officeName + "</td><td>" + data.iSBN + "</td><td>" + data.numPages + "</td><td>" + data.title + "</td></tr>";

        });

        table.append(tStr).fadeIn('slow');
        //$("#display").html(outString);

    }
</script>



<h3>JSON processing and jQuery Form Plugin</h3>



<form id="demoForm" class="form-inline row-separate" action="${baseURL}jquery/formSubmission/getBook.html" method="post">

    Office Code: <input type="text" name="officeCode" />	<input  class="btn btn-primary"  type="submit" value="Submit" />


</form>
 
<button class="btn btn-primary row-separate" onclick="clearText()">Clear text area</button>
<hr />

<p>&nbsp;</p>


<div class="outputClass" id="target1"></div>
<table  id="tableTarget" class="table table-bordered"></table>

