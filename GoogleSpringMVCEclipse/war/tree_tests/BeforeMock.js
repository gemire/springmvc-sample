_sample_Html = "";
_transform_content = "";


$.get("sample.html", setUpHtml);

function setUpHtml(content)
{
    _sample_Html = content;
}
;

$.get("transform.xslt", setUpXsl);

function setUpXsl(content)
{
    _transform_content = content;
}
;

var level_1_Data =
        [
            {"id": 7811, "name": "Clothing"},
            {"id": 22, "name": "Electronic Goods"},
            {"id": 33, "name": "Games"},
            {"id": 44, "name": "Home Improvement"}
        ];



var level_2_Data_for_1 =
        [
            {"id": 611, "name": "Mens"},
            {"id": 622, "name": "Womens"},
            {"id": 6333, "name": "Children"}
        ];


$.mockjax({
    url: '*getLevelData?level=2&groupId=3&id=7811',
    // responseTime: 100,
    responseText: JSON.stringify(level_2_Data_for_1)
});


// games level 2
var level_2_Data_for_33 =
        [
            {"id": 4091, "name": "Board Games"},
            {"id": 4092, "name": "Card Games"},
            {"id": 4093, "name": "WII"},
            {"id": 4094, "name": "PS III"},
            {"id": 4095, "name": "XBox"}
        ];


$.mockjax({
    url: '*getLevelData?level=2&groupId=3&id=33',
    // responseTime: 100,
    responseText: JSON.stringify(level_2_Data_for_33)
});



// electronics level 2
var level_2_Data_for_22 =
        [
            {"id": 41, "name": "Cellphones"},
            {"id": 42, "name": "Cameras"},
            {"id": 43, "name": "TV/Home Entertainment"}
        ];


$.mockjax({
    url: '*getLevelData?level=2&groupId=3&id=22',
    // responseTime: 100,
    responseText: JSON.stringify(level_2_Data_for_22)
});


//electronics level 3

var level_3_for_tv =
        [
            {"id": 41, "name": "Big Screen TV"},
            {"id": 42, "name": "Stereos"},
            {"id": 43, "name": "Game Consoles"}
        ];


$.mockjax({
    url: '*getLevelData?level=3&groupId=3&id=43',
    // responseTime: 100,
    responseText: JSON.stringify(level_3_for_tv)
});




//childrens
var level_3_Data_for_3 =
        [
            {"id": 3000, "name": "Boys"},
            {"id": 3005, "name": "Girls"},
            {"id": 3006, "name": "Outdoor Kids™"},
            {"id": 3007, "name": "Toddlers"},
            {"id": 3001, "name": "Teenagers"}
        ];


$.mockjax({
    url: '*alpha/getLevelData?level=3&groupId=3&id=6333',
    // responseTime: 100,
    responseText: JSON.stringify(level_3_Data_for_3)
});

//womens
var level_3_Data_for_2 =
        [
            {"id": 7000, "name": "Shoes"},
            {"id": 7005, "name": "Dresses"},
            {"id": 7006, "name": "Evening Wear"}
        ];


$.mockjax({
    url: '*alpha/getLevelData?level=3&groupId=3&id=622',
    // responseTime: 100,
    responseText: JSON.stringify(level_3_Data_for_2)
});



$.mockjax({
    url: 'alpha/getLevelData?level=1&groupId=3',
    // responseTime: 100,
    response: function(settings) {
         
       this.responseText = level_1_Data
  }
    
});
//$.mockjax({
//    url: '*getLevelData*',
//    responseTime: 100,
//    responseText: "[]"
//
//
//});

/*
 * 
 *   http://localhost:8383/js-sandbox/tests/xtree_testbed/alpha/http://localhost:8383/js-sandbox/tests/xtree_testbed/alpha/getLevelData?level=3&groupId=3&id=3?level=3&groupId=3&id=3
 
 * This is a catchall and must be at the bottom of the stack, however it
 * will block gets for things like sample files unless those are specifically
 * mocked with content such as above.
 * 
 * 
 
 $.mockjax({
 url: '*',
 responseTime: 100,
 responseText: "[]"
 
 
 });
 */