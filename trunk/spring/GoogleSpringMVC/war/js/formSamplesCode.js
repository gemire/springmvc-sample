var teams =
        [
            {"teamName": "Hawker Hurricanes"},
            {"teamName": "The Herman Melvilles"},
            {"teamName": "The Union Jacks"},
            {"teamName": "The Mighty Quinns"}
        ];

var players =
        [
            {"name": "John", value: "0", selected: false},
            {"name": "Mary", value: "1", selected: false},
            {"name": "Sam", value: "2", selected: false},
            {"name": "Elmo", value: "3", selected: false}

        ];


var teamOneItems = null;
var teamTwoItems = null;
var teamThreeItems = null;
var teamFourItems = null;
var teamPlayerMap = null;
var playerOneItems = null;
var playerTwoItems = null;
var playerThreeItems = null;
var itemsMap = new Object();

$.fn.hasAttr = function(attr) {
    var attribVal = this.attr(attr);
    return (attribVal !== undefined) && (attribVal !== false);
};



function documentReady()
{


    playerOneItems = $('td input[value=0]');
    playerTwoItems = $('td input[value=1]');
    playerThreeItems = $('td input[value=2]');
    playerFourItems = $('td input[value=3]');

    //method for creating an associative map
    //teamPlayerMap = new Object();
    //teamPlayerMap[myKey2] = myObj2;


    teamOneItems = $('#team0 input');
    teamOneItems.click(function(eventObj) {
        selectPlayer({'teamId': 0}, eventObj);
    });

    teamTwoItems = $('#team1 input');
    teamTwoItems.click(function(eventObj) {
        selectPlayer({'teamId': 1}, eventObj);
    });

    teamThreeItems = $('#team2 input');
    teamThreeItems.click(function(eventObj) {
        selectPlayer({'teamId': 2}, eventObj);
    });

    teamFourItems = $('#team3 input');
    teamFourItems.click(function(eventObj) {
        selectPlayer({'teamId': 3}, eventObj);
    });

    itemsMap[0] = teamOneItems;
    itemsMap[1] = teamTwoItems;
    itemsMap[2] = teamThreeItems;
    itemsMap[3] = teamFourItems;

    clearPlayers();


}


//this function will take the input and select it in the select box
function setSelect()
{

    var sel = $("#position").val();
    sel = $.trim(sel);
    //alert(sel);
    //alert($("#mySelect option[value='"+sel+"']").text());
    //if (!$("#mySelect option:selected").length)


    // clear out the values in the select
    $("#mySelect option").each(
            function(i, selected)
            {

                $(this).removeAttr('selected');
            }


    );


    // set the select based on the value in the textbox
    $("#mySelect option[value='" + sel + "']").attr('selected', 'selected');


}



//http://www.myphpetc.com/2009/07/jquery-css-cheat-sheet.html
//http://calisza.wordpress.com/2009/03/29/6-jquery-snippets-you-can-use-to-manipulate-select-inputs/
//http://calisza.wordpress.com/category/jquery/
// page flow 
//http://code.google.com/p/flexidev/


//remove checks at the start of page load
function clearPlayers()
{

    for (i = 0; i < teams.length; i++)
    {
        for (j = 0; j < players.length; j++)
        {

            //alert("i "+i+" j "+j);
            var ivar = $(itemsMap[i][j]);
            ivar.removeAttr('checked');
        }

    }

}


function selectPlayer(eventData, eventObj)
{

    // var value1 = $("input[name=group1]:checked").val();
    // var value2 = $("input[name=group2]:checked").val();
    // $(eventObj).addClass('marker')
    // $(eventObj.target).parent().addClass('marker')
    selectedTeam = eventData.teamId;
    selectedPlayer = eventObj.target.value;

    //alert("team id "+teams[selectedTeam].teamName+" player "+players[selectedPlayer].name+" parent "+$(eventObj.target).parent().attr('id'));

    // find the same player on the other teams

    for (i = 0; i < teams.length; i++)
    {
        for (j = 0; j < players.length; j++)
        {
            var ivar = $(itemsMap[i][j]);
            if (i != selectedTeam && j == selectedPlayer)
            {
                ivar.removeAttr('checked');
            }

            labelFinder = "label[for=team" + i + "_" + j + "]";
            $(labelFinder).removeAttr('disabled');
            $(labelFinder).removeClass('error');
        }

    }

    // now find which columns contain a checked box
    columnHits = new Array();
    hitCount = 1;

    for (i = 0; i < teams.length; i++)
    {
        for (j = 0; j < players.length; j++)
        {
            var ivar = $(itemsMap[i][j]);
            //ivar.hasAttr('checked')  
            if (ivar.prop("checked") != "undefined" && ivar.prop("checked") == true)
            {
                //alert("hit i "+i+" j "+j);
                columnHits.length = hitCount;
                columnHits[hitCount - 1] = j;
                hitCount++;
            }

        }
    }

    // clear all label of disabled state 
    for (i = 0; i < teams.length; i++)
    {
        for (j = 0; j < players.length; j++)
        {
            labelFinder = "label[for=team" + i + "_" + j + "]";
            $(labelFinder).removeAttr('disabled');
            $(labelFinder).removeClass('text-error');
        }
    }



    //disable other players when there exists a checked player in the column
    for (z = 0; z < columnHits.length; z++)
    {
        for (i = 0; i < teams.length; i++)
        {
            labelFinder = "label[for=team" + i + "_" + columnHits[z] + "]";
            var ivar = $(itemsMap[i][columnHits[z]]);

           // if (ivar.hasAttr('checked') == false)
            if (ivar.prop("checked") == false)
            {
                $(labelFinder).attr('disabled', true);
                $(labelFinder).addClass('text-error');
            }
        }
    }





}