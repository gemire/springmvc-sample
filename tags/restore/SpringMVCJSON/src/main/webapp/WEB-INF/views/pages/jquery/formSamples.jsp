<SCRIPT type=text/javascript src="js/formSamplesCode.js"></SCRIPT>
<SCRIPT>
    $(document).ready(function() {

        documentReady();
//        $('#fred').addClass("text-error");
    });
</script>

<div class="row offset1 span8">

    <h3>Sample of Setting select via jQuery</h3>
</div>
<div class="row offset1 span4">
    <div class="form-stacked">
        <select id="mySelect" multiple="multiple">
            <option value="1">First</option>
            <option selected="selected" value="2">Second</option>
            <option value="3">Third</option>
            <option value="4">Fourth</option>
        </select>
        <input id="position" type="text" size="5" value="1">
        <button class="btn btn-primary" onclick="setSelect()">Set</button>
    </div>
</div>

<div class="row offset1 span10">

    <h3>Exclusive Radio Selections</h3>

    <div class="well">
        Each team can have at most one player, each player can only be on one team.
    </div>



    <div class="form-inline">
        <table class="table table-bordered table-striped">

            <tr>


                <th width='35%'>The Hawker Hurricanes</th>
                <td id="team0">



                    <input name="team0" id="team0_0"  value="0"  type="radio"><label for="team0_0">John</label>
                    <input name="team0" id="team0_1"  value="1"  type="radio"><label for="team0_1">Mary</label>
                    <input name="team0" id="team0_2"  value="2"  type="radio"><label for="team0_2">Sam</label>
                    <input name="team0" id="team0_3"  value="3"  type="radio"><label for="team0_3">Elmo</label>



                </td>
            </tr>

            <tr>
                <th width='35%'>The Herman Melvilles</th>
                <td id="team1">

                    <input name="team1" id="team1_0"  value="0"  type="radio"><label for="team1_0">John</label>
                    <input name="team1" id="team1_1"  value="1"  type="radio"><label for="team1_1">Mary</label>
                    <input name="team1" id="team1_2"  value="2"  type="radio"><label for="team1_2">Sam</label>
                    <input name="team1" id="team1_3"  value="3"  type="radio"><label for="team1_3">Elmo</label>

                </td>
            </tr>

            <tr>
                <th width='35%'>The Union Jacks</th>
                <td id="team2">

                    <input name="team2" id="team2_0"  value="0"  type="radio"><label for="team2_0">John</label>
                    <input name="team2" id="team2_1"  value="1"  type="radio"><label for="team2_1">Mary</label>
                    <input name="team2" id="team2_2"  value="2"  type="radio"><label for="team2_2">Sam</label>
                    <input name="team2" id="team2_3"  value="3"  type="radio"><label for="team2_3">Elmo</label>

                </td>
            </tr>


            <tr>
                <th width='35%'>The Mighty Quinns</th>
                <td id="team3">

                    <input name="team3" id="team3_0"  value="0"  type="radio"><label for="team3_0">John</label>
                    <input name="team3" id="team3_1"  value="1"  type="radio"><label for="team3_1">Mary</label>
                    <input name="team3" id="team3_2"  value="2"  type="radio"><label for="team3_2">Sam</label>
                    <input name="team3" id="team3_3"  value="3"  type="radio"><label for="team3_3">Elmo</label>

                </td>
            </tr>

        </table>


    </div>


</div>

