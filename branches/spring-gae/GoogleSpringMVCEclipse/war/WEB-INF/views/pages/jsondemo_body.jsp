
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

            alert('success: brand: ' + coffee.brand + " quantity: " + coffee.quantity);
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

<div class="row">
    <div class="offset2 row-separate">
        <button class="btn btn-primary" onclick="getJSON();">Get Json</button>
    </div>
</div>

<div class="row">
    <div class="offset2 row-separate form-horizontal">        
         Brand: <input type="text" id="brandGet" name="brand" class="input-prepend" size="20"/>
         <button class="btn btn-primary" onclick="getCoffee();">Get Coffee</button>
    </div>
</div> 

<div class="row">
    <div class="offset2 row-separate form-horizontal">
        
        Brand: <input type="text" id="brandPost" class="input-prepend"  name="brand" size="20"/>
         <button class="btn btn-primary"  onclick="sendCoffee()">Send Coffee</button>
    </div>
</div> 


