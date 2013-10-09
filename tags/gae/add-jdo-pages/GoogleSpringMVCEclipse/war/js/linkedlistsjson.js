// if console is not defined, e.g.,
// Firebug console is not enabled or Non-Firefox browser
if (typeof console == 'undefined') {
    var console = {};
    console.log = function(msg) {
        return;
    };
}
var selectionDialog = null;
/* data object */

var carMakers = [{
        name: 'Honda',
        models: [{
                name: 'Accord',
                features: ['2dr', '4dr']
            }, {
                name: 'CRV',
                features: ['2dr', 'Hatchback']
            }, {
                name: 'Pilot',
                features: ['base', 'superDuper']
            }]
    }, {
        name: 'Toyota',
        models: [{
                name: 'Prius',
                features: ['green', 'superGreen']
            }, {
                name: 'Camry',
                features: ['sporty', 'square']
            }, {
                name: 'Corolla',
                features: ['cheap', 'superFly']
            }]
    }];

//////////////////////////////////////////////////////////////////	



// returns array of elements whose 'prop' property is 'value' 
function filterByProperty(arr, prop, value) {
    return $.grep(arr, function(item) {
        return item[prop] == value;
    });
}
// populates select list from array of items given as objects: { name: 'text', value: 'value' } 
function populateSelect(el, items) {
    if (notThere(items))
        return;
    el.options.length = 0;
    if (items.length > 0)
        el.options[0] = new Option('please select', '');
    $.each(items, function() {
        el.options[el.options.length] = new Option(this.name, this.value);
    });
}
//returns true if object is undefined or null
function notThere(obj)
{


    if ((typeof obj == 'undefined') || (obj == null))
    {
        return true;
    }
    if (obj instanceof Array && obj.length == 0)
    {

        return true;
    }
    return false;

}
// fill a select box from an flat array
function populateSelectFromArray(el, items) {
    if (notThere(items))
        return;
    el.options.length = 0;
    if (items.length > 0)
        el.options[0] = new Option('please select', '');
    $.each(items, function() {
        el.options[el.options.length] = new Option(this, this);
    });
}


function setUpFirstBox()
{

    populateSelect($('#maker').get(0), $.map(carMakers,
            function(maker) {
                return {
                    name: maker.name,
                    value: maker.name
                }
            }));





}

// given the name of a carmaker, get the array of models for that maker
function getModelsForMaker(makerName)
{

    carMaker = filterByProperty(carMakers, 'name', makerName), models = [];
    if (carMaker.length > 0)
        models = $
                .map(
                carMaker[0].models,
                function(model) {
                    return {
                        name: model.name,
                        value: model.name
                    }
                });

    return models;
}
// get model features  for a given car maker and Model
function getFeaturesForMakerandModel(makerName, modelName)
{
    carMaker = filterByProperty(carMakers, 'name', makerName);
    console.log(" carmaker " + carMaker[0].name);
    features = [];
    model = filterByProperty(carMaker[0].models, 'name', modelName);
    if (notThere(model))
    {
        return null;
    }
    else
    {
        console.log("model name " + model[0].name);
        features = $.map(model, function(z) {
            return(z.features);
        });
        console.log(features);
        return features;
    }

}

/* 
 * This is the main dispatch function
 * Parameters:
 item: reference to the select box calling this routine (not used)
 itemIndex: the order of the textbox
 This is essentially a state machine and this is the code
 that changes the state
 */
function doBoxChange(item, itemIndex)
{
    if (itemIndex === 1)
    {
        models = getModelsForMaker(item.value);
        if (notThere(models))
        {
            $('#model').empty();
        }
        else
        {
            populateSelect($('#model').get(0), models);
        }
        $('#feature').empty();
        $('#makerResult').empty();
        $('#modelResult').empty();
        $('#featureResult').empty();
    }
    if (itemIndex === 2)
    {

        maker = $('#maker').val();
        model = $('#model').val();
        features = getFeaturesForMakerandModel(maker, model);
        console.log("maker " + maker + " model " + model + " got features " + features);
        if (notThere(features))
        {
            $('#feature').empty();
            $('#featureResult').empty();
            $('#modelResult').html(model);

        }
        else
        {
            populateSelectFromArray($('#feature').get(0), features);
        }
    }
    if (itemIndex === 3)
    {
        maker = $('#maker').val();
        model = $('#model').val();
        feature = $('#feature').val();

        $('#makerResult').html(maker);
        $('#modelResult').html(model);
        $('#featureResult').html(feature);

        console.log("maker " + maker + " model " + model + " feature " + feature);



    }
}

function showSelection()
{

    selectionDialog.dialog('open');

}


/*
 This is the main document call. Since this page is inside a tile
 this function is called twice, once in the layout tile and once
 here, allowing for additivity.
 
 This function sets up the dispatch, each select box sends its 
 info to the doBoxChange method, and there is no other code in 
 this box.
 */
$(document)
        .ready(
        function()
        {
            setUpFirstBox();
            $('#maker')
                    .bind(
                    'change',
                    function()
                    {
                        doBoxChange(this, 1);
                    }
            );
            $('#model')
                    .bind(
                    'change',
                    function()
                    {
                        doBoxChange(this, 2);
                    }
            );
            $('#feature')
                    .bind(
                    'click',
                    function()
                    {
                        doBoxChange(this, 3);
                    }
            );


        }

);