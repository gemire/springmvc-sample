<script>
    /**
    jquery syntax is of the form
    $(selection criteria).operation(parms)

    find every div and set its border to 3px red
    $("div").css("border","3px solid red");
    | sel   |operation                    |
    */

    function findDiv()
    {
    $("div").css("border","3px solid red");


    }

    function findDivWithGrey()
    {

    //$(".grey").text().append(" fred ");
    var b = $(".grey");
    var text = $(".grey").text();
    alert("The grey box has text of "+text);

    }


    /** if this is the call back for each the object is an HTML DOM 
    * 
    */
    function actOnBlue(i,obj)
    {
    //alert($("#bluebox > p"));
    //$(" hit ").appendTo( $("#bluebox > p"));
    alert(i + " "+obj.firstChild.nodeValue);

    }

    function findDivWithBlueExt()
    {
    $("#bluebox > p").each(actOnBlue);
    }

    /** -------------------------------- */

    function findDivWithBlueExt2()
    {
    $("#bluebox > p").each(actOnBlueX2);
    }

    function actOnBlueX2(i,obj)
    {
    //alert($("#bluebox > p"));
    $(this).append(" hit ");
    alert(i + ':::: ' + $(this).text());

    }


    /** -------------------------------- */
    function findDivWithBlue()
    {
    $("#bluebox > p").each(function(index) {
    alert(index + ': ' + $(this).text());
    });

    }


</script>

<style>

    .grey
    {
        border: thin solid grey;
    }

    .blue
    {
        border: thin blue solid
    }

</style>


<h3>Finding Elements</h3>
<hr>
<div class="btn-group btn-group-vertical">
    <button class="btn btn-small btn-primary"  onclick="findDiv();">Find the div</button><br/>
    <button class="btn btn-small btn-primary" onclick="findDivWithGrey();">Find the grey box in the div</button><br/>
    <button class="btn btn-small btn-primary" onclick="findDivWithBlue();">Find the paragraphs in the blue box</button><br/>
    <button class="btn btn-small btn-primary" onclick="findDivWithBlueExt2();">Find the paragraphs in the blue box External</button><br/>
</div>

<div id="test">Test Div</div>

<div class="grey">
    This is the grey box by class

</div>

<div class="blue" id="bluebox">
    <p>alpha</p>
    <p>beta</p>
    <p>gamma</p>
    <br>
    <div>this is a div</div>
</div>
