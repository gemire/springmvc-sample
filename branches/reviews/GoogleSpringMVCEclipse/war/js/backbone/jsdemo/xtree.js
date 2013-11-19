/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//XTree = [];

XTree = {
    params: {},
    tree: undefined,
    xsl: "",
    groupId: 0,
    /**
     * initialize the XTree object with needed one time parameters
     * @param {type} settings
     * @return {undefined}
     */
    init: function(settings)
    {
        XTree.params.attachmentPoint = settings.attachmentPoint != null ?
                settings.attachmentPoint : "body";

        XTree.params.transformBase = settings.transformBase != null ?
                settings.transformBase : "";

        XTree.params.urlBase = settings.urlBase != null ?
                settings.urlBase : ""; // no ending slash
        XTree.createNewTree();
        XTree.xsl = $.ajax(XTree.params.transformBase + "transform.xslt", {"async": false, "type": "GET"}).responseText;

    },
    /**
     * Get the level 1 data for a group currently there is only one group
     * 
     * @param {type} groupId
     * @return {undefined}
     */
    getLevel1DataForGroup: function(groupId)
    {
        XTree.groupId = groupId;

        var url = XTree.params.urlBase + "/getLevelData?level=1" + "&groupId=" + groupId;
        $.getJSON(url, null, function(jsonItems) {

            for (var i = 0; i < jsonItems.length; i++)
            {
                XTree.appendLevel1(jsonItems[i].id, jsonItems[i].name);
            }

            XTree.refresh();
        });
    },
    /**
     * Get the level data for the given level and the id of the prior  level
     * so level = 2 and id = 35 means get level1 id 35's level 2 data.
     * level should never be one here.
     * 
     * @param {type} level the level you are requesting
     * @param {type} group the group id (eg tree 25)
     * @param {type} id the id of the parent level
     * @return {undefined}
     */
    getLevelDataForLevelAndGroupAndId: function(level, group, id)
    {
        var jsonItems = [];
        var url = XTree.params.urlBase + "/getLevelData?level=" + level + "&groupId=" + group + "&id=" + id;
        // you are asking for 2 so find parent node ie one level up
        var node = XTree.findLevel(level-1, id);
        //eg level = 2 id = 1 means get all the level 2 items for level 1 with id of '3'
        
        $.getJSON(url, null, function(jsonItems) {

            if (typeof jsonItems != "undefined")
            {
                for (var i = 0; i < jsonItems.length; i++)
                {
                    var n = XTree.appendChildLevel(node, level, jsonItems[i].id, jsonItems[i].name);
                    n.setAttribute("visible", "yes");
                }
                XTree.refresh();
            }


        });


    },
    /**
     * initialize the xml tree to empty
     * @return {undefined}
     */
    createNewTree: function()
    {
        XTree.tree = jsxml.fromString('<?xml version="1.0" encoding="UTF-8"?><tree/>');

    },
    /**
     * append a level one node with given id and name
     * set other properties to defaults
     * @param {type} id
     * @param {type} name
     * @return the node that was just added
     */
    appendLevel1: function(id, name)
    {
        var child = XTree.tree.createElement("level1");
        child.setAttribute("id", id);
        child.setAttribute("name", name);
        XTree.setChildtoDefault(child);
        XTree.tree.documentElement.appendChild(child);
        return child;
    },
    /**
     * set a node to the default attribute values
     * @param {type} child
     * @return {undefined}
     */
    setChildtoDefault: function(child)
    {
        child.setAttribute("checked", "no");
        child.setAttribute("folder", "closed");
        child.setAttribute("visible", "yes");

    },
    /**
     * append a level one node with given id and name
     * set other properties to defaults. This time its a 2 or 3 level
     *  
     * @param parentNode the node to append to
     * @param {int} levelNumber the requested level you want to append
     * @param {int} id
     * @param {string} name
     * @return the node that was just added
     */
    appendChildLevel: function(parentNode, levelNumber, id, name)
    {
        if (levelNumber < 2 && levelNumber > 3)
        {
            throw "child levels allowed: 2 and 3 only";
        }
        var parentLevel = null;
        if (!parentNode)
        {
        	parentLevel = "level1";
        }
        else
        {
        	parentLevel = parentNode.nodeName;
        }
        
        if (parentLevel == "level1" && levelNumber != 2)
        {
            throw "level1  can only have level2 children";
        }

        if (parentLevel == "level2" && levelNumber != 3)
        {
            throw "level2  can only have level3 children";
        }
        if (parentLevel == "level3")
        {
            throw "level3  can not have children";
        }

        var child = XTree.tree.createElement("level" + levelNumber);
        child.setAttribute("id", id);
        child.setAttribute("name", name);
        XTree.setChildtoDefault(child);
        parentNode.appendChild(child);
        return child;

    },
    /**
     * find a node based on the level number and the id
     * NB: this will NOT work with IE
     * 
     * @param {type} levelNumber
     * @param {type} id
     * @return the node or undefined if not found
     */
    findLevel: function(levelNumber, id)
    {

        var path = "//level" + levelNumber + "[@id='" + id + "']";
        var nodes = XTree.tree.evaluate(path, XTree.tree, null, XPathResult.ANY_TYPE, null);
        return   nodes.iterateNext();
    },
    /**
     * 
     * @return to String representation of the current tree
     */
    toString: function()
    {
        var stuff = jsxml.toXml(XTree.tree);
        return stuff;
    },
    toHtml: function()
    {
        var stuff = jsxml.transReady(XTree.tree, XTree.xsl);
        return stuff;
        // console.log("\n============\n" + jsxml.toXml(XTree.tree));

    },
    /**
     * repaint and announce an update
     * @return {undefined}
     */
    refresh: function()
    {

        $("#" + XTree.params.attachmentPoint).html(jsxml.transReady(XTree.tree, XTree.xsl));
        MESSAGE_PUMP.raiseEvent(XTree.tree, XTREE_LISTENERS.ON_REFRESH_EVENT);

    },
    ///////////// button handling routines ///////////////////

    /**
     * called when a checkbox is clicked, the level and the id are provided
     * by the html
     * 
     * @param {type} level which level 1,2,3
     * @param {type} id the id of the level node
     * @return {undefined}
     */
    selectItem: function(level, id)
    {
        console.log("selectItem1 id " + id + " level " + level);
        var clickedNode = XTree.findLevel(level, id);
        var clickedStatus = clickedNode.getAttribute("checked");
        var newStatus = "yes";
        if (typeof clickedStatus == undefined || clickedStatus == "no")
        {
            newStatus = "yes";
        }
        else
        {
            newStatus = "no";
        }
        XTree.findLevel(level, id).setAttribute("checked", newStatus);
        XTree.refresh();
    },
    /**
     * Get the remote level2 data or simply open the folder
     * @param {type} id
     * @param {type} level
     * @return {undefined}
     */
    openFolder: function(level, id)
    {
        console.log("openFolder id " + id + " level " + level);
        var node = XTree.findLevel(level, id);
        var newLevel = level + 1;
        var folderStatus = node.getAttribute("folder");
        if (folderStatus == "open")
        {
            node.setAttribute("folder", "closed");
            for (var i = 0; i < node.childNodes.length; i++)
            {
                node.childNodes[i].setAttribute("visible", "no");
            }
        }
        else
        {
            if (node.childNodes.length == 0)
            {
                XTree.getLevelDataForLevelAndGroupAndId(newLevel, XTree.groupId, id);
            }
            else
            {
                for (var i = 0; i < node.childNodes.length; i++)
                {
                    node.childNodes[i].setAttribute("visible", "yes");
                }
            }
            node.setAttribute("folder", "open");

        }
        XTree.refresh();

    }
}; // end Xtree


