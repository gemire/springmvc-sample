var htmlSettings = {"attachmentPoint": "qunit-fixture", "urlBase": "alpha"};
var sampleHTML = null;
var simpleXML = "";

//////// testing helper functions ////////////////////

function getText(levelNum, id)
{
    selector = "#level_" + levelNum + "_name_" + id;
    return $(selector).text();
}

function isChecked(levelNum, id)
{
    selector = "#level_" + levelNum + "_" + id;
    return $(selector).children('input').is(':checked');
}

function  openFolder(levelNum, id)
{
    selector = "#level_" + levelNum + "_" + id+" .indicator";
    return $(selector).click();
}

function clickBox(levelNum,id)
{
    selector = "#level_" + levelNum + "_" + id;
    $(selector).children('input').click();
}
function areAllChildrenChecked(levelNum, id)
{
    selector = "#level_" + levelNum + "_" + id;
    uC = $(selector).children('ul').children('li').children('input');
    checkCount = 0;
    for (i = 0; i < uC.length; i++)
    {
        if ($(uC[i]).is(':checked'))
        {
            checkCount++;
        }

    }
    return checkCount;
}



/////// testing helper functions /////////////////////

function getHtmlSample()
{
    if (sampleHTML == null)
    {
        xr = $.ajax("sample.html", {
            "async": false,
            "type": "GET",
            "error":
                    function(xr, status, err)
                    {
                        alert(err + " " + status);
                    }

        });

        sampleHTML = xr.responseText;
    }
    return sampleHTML;
}
$(function() {
    module("xtext_html.js basic sample DOM Tests", {
        setup: function() {
            // console.log("in setup for xtree dom");
            $('#qunit-fixture').append(getHtmlSample());

        },
        teardown: function() {
            // console.log("in teardown for xtree dom");
        }
    });

    test('test replacing HTML', function() {

        //console.log($('#qunit-fixture').html())
        equal(getText(2, 2002), "gamma3");
        equal(false, areAllChildrenChecked(1, 33333));
        equal(false, isChecked(2, 2002));
        equal(true, isChecked(2, 2000));

    });

    ////////////////////////////////////////////////////
    module("xtext_html.js _html DOM Tests", {
        setup: function() {
            XTree.init({"attachmentPoint": 'qunit-fixture', "urlBase": "alpha"});
            XTree.getLevel1DataForGroup(3);
            stuff = XTree.toHtml();
            $('#qunit-fixture').html(stuff);
        },
        teardown: function() {

        }
    });


    test('click works for tree', function() {
        clickBox(1, 22);
        //xml changed
        equal(XTree.findLevel(1, 22).getAttribute("checked"), 'yes');
        //html changed
        equal(isChecked(1, 22), true);

    });
    
    test('open folder works for tree', function() {
        openFolder(1,22);
        equal(XTree.findLevel(1, 22).childNodes[0].getAttribute("visible"), 'yes');
        equal(XTree.findLevel(1, 22).getAttribute("folder"),"open");
        $('qunit-fixture').html(XTree.toHtml());
        ok(1 == 1,'ok')
    });


});// end jquery start function