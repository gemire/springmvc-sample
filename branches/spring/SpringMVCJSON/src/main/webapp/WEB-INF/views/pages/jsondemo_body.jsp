
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<script>


    function sendCoffee()
    {

        //var bean = $('#coffeeForm').serializeObject();
        // alert($.param(bean));
        var url = "<%= basePath%>/app/json/sendCoffee";
        var jsonMap = new Object();
        jsonMap['brand'] = $("#brandPost").val();
        var datastring = JSON.stringify(jsonMap, null);
        alert(datastring);

        var request = $.ajax({
            type: 'POST',
            url: url,
            data: datastring,
            contentType: 'application/json; charset=utf-8',
            dataType: 'json'
//        ,
//        beforeSend:function(xhr){
//         $.blockUI({ message: '<h1><img src="images/loader.gif" /> Just a moment...</h1>' });
//        
//        }
        });

        request.done(function(coffee) {
            
            alert('success: brand: '+coffee.brand+ " quantity: "+coffee.quantity);
        }
        );
        request.error(function(jqXHR, textStatus, errorThrown) {
            alert('error ' + textStatus + ' errorthrown ' + errorThrown);
        }
        );




    }

    function getJSON() {

        $.getJSON('app/json/getbook.json', function(book) {
            alert(book.author);
        });

    }


    function getCoffee()
    {
        var url = "app/json/coffee.json?brand=";
        var brand = $('#brandGet').val();
        url = url + brand;
        $.getJSON(url, function(coffee) {
            alert(coffee.brand);
        });

    }


</script>


<h3>Processing Jason on the Server via jQuery and JSON.js</h3>

<table border="0" cellpadding="4" cellspacing="4">
    <tr><td width="150px" colspan="3">
            <button class="btn large btn-primary" onclick="getJSON()">Get Json</button></td></tr>
    <tr><td width="150px"><button class="btn large  btn-primary" onclick="getCoffee()">Get Coffee</button></td><td width="100px">Brand</td><td><input type="text" id="brandGet" name="brand" size="20"/></td></tr>
</table>  

 
    <table border="0" cellpadding="4" cellspacing="4">
        <tr><td width="150px"><button class="btn large  btn-primary"  onclick="sendCoffee()">Send Coffee</button></td><td width="100px">
                Brand</td><td><input type="text" id="brandPost" name="brand" size="20"/></td></tr>
    </table>
 

