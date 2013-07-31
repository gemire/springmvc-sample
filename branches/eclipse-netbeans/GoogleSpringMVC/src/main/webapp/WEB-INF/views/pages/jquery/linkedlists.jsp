<script type="text/javascript"  src="js/linkedlistsjson.js"></script>
<script type="text/javascript"  src="js/linkedlistsviaCall.js"></script>

<div class="row offset1">
    <div class="span5">
        <h3>Using JSON Object</h3>
        <table class="table">

            <tr>
                <th>Car Maker</th>
                <td><select id="maker"></select></td>
            </tr>
            <tr>
                <th>Model</th>
                <td><select id="model"></select></td>
            </tr>
            <tr>
                <th>Feature</th>
                <td><select id="feature"></select></td>
            </tr>
            <tr>
                <td colspan="2">

                    <a href="#selectionInformation" role="button" class="btn btn-info" 
                       data-toggle="modal">Show Selection</a>
                </td>
            </tr>
        </table>
    </div>
    <div class="span5">

        <h3>Using MVC Call</h3>
        <table class="table">
            <tr><th>Product Categories</th><td> <select style="width:140px" id="categories"></select></td><td rowspan="2"><img id="loaderImage"  width="40px" height="40px" src="images/loader.gif" /></td></tr>
            <tr><th>Product SubCategories</th><td> <select  style="width:140px"  id="subCategories"></select></td></tr>
        </table>
    </div>

</div>



<!--  ///////////////////// dialog ///////////////////////////// -->

<div id="selectionInformation" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="selectionInformationLabel" aria-hidden="true" >
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="selectionInformationLabel">You Selected:</h3>
    </div>
    <div style="max-height: 200px" class="modal-body">
       <table class="table">

            <tr>
                <th>Car Maker</th>
                <td id="makerResult"></td>
            </tr>
            <tr>
                <th>Model</th>
                <td id="modelResult"></td>
            </tr>
            <tr>
                <th>Feature</th>
                <td id="featureResult"></td>
            </tr>
        </table>
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary" data-dismiss="modal" aria-hidden="false">Close</button>

    </div>
</div>
