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
        XTree.xsl = $.ajax(XTree.params.transformBase+"transform.xslt", {"async": false, "type": "GET"}).responseText;
    },
    getLevel1DataForGroup: function(groupId)
    {
        XTree.groupId = groupId;
        jsonItems = XTree.getLevelDataForLevelAndGroup(1, groupId);
        for (i = 0; i < jsonItems.length; i++)
        {
            XTree.appendLevel1(jsonItems[i].id, jsonItems[i].name);
        }

        return  jsonItems;
    },
    getLevelDataForLevelAndGroup: function(level, group)
    {
        url = XTree.params.urlBase + "/getLevelData?level=" + level + "&groupId=" + group;
        val = $.ajax(url, {"async": false, "type": "GET"});
        jsonItems = JSON.parse(val.responseText);
        return jsonItems;
    },
    getLevelDataForLevelAndGroupAndId: function(level, group, id)
    {
        jsonItems = [];
        url = XTree.params.urlBase + "/getLevelData?level=" + level + "&groupId=" + group + "&id=" + id;
        val = null;
        try {
            val = $.ajax(url, {"async": false, "type": "GET"});
        }
        catch (e) {
        }
        if (val != null)
        jsonItems = JSON.parse(val.responseText);

        return jsonItems;
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

        parentLevel = parentNode.nodeName;
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
        nodes = XTree.tree.evaluate(path, XTree.tree, null, XPathResult.ANY_TYPE, null);
        return   nodes.iterateNext();
    },
    /**
     * 
     * @return to String representation of the current tree
     */
    toString: function()
    {
          stuff = jsxml.toXml(XTree.tree);
          return stuff;
    },
    toHtml: function()
    {
        stuff =  jsxml.transReady(XTree.tree, XTree.xsl);
        return stuff;
        // console.log("\n============\n" + jsxml.toXml(XTree.tree));

    },
    refresh: function()
    {
        //jsxml.transReady(XTree.tree, XTree.xsl)
       // $(XTree.params.attachmentPoint).replaceWith("");
        $("#"+XTree.params.attachmentPoint).html(jsxml.transReady(XTree.tree, XTree.xsl));
        //console.log("\n============\n" + jsxml.toXml(XTree.tree));

    },
    ///////////// button handling routines ///////////////////

    selectItem: function(level, id)
    {
        console.log("selectItem1 id " + id + " level " + level);
        //console.log(XTree.toHtml());
        XTree.findLevel(level, id).setAttribute("checked", "yes");
        // console.log("\n============\n" + jsxml.toXml(XTree.tree));
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
        node = XTree.findLevel(level, id);
        newLevel = level + 1;
        folderStatus = node.getAttribute("folder");
        if (folderStatus == "open")
        {
            node.setAttribute("folder", "closed");
            for (i = 0; i < node.childNodes.length; i++)
            {
                node.childNodes[i].setAttribute("visible", "no");
            }
        }
        else
        {
            if (node.childNodes.length == 0)
            {
                items = XTree.getLevelDataForLevelAndGroupAndId(newLevel, XTree.groupId, id);
                for (i = 0; i < items.length; i++)
                {
                    n = XTree.appendChildLevel(node, newLevel, items[i].id, items[i].name);
                    n.setAttribute("visible", "yes");
                }
            }
            for (i = 0; i < node.childNodes.length; i++)
            {
                node.childNodes[i].setAttribute("visible", "yes");
            }
            node.setAttribute("folder", "open");
            
        }
        XTree.refresh();

    }
}; // end Xtree


