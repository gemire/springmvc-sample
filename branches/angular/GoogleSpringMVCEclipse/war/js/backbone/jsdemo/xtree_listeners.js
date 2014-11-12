XTREE_LISTENERS = {

	ON_REFRESH_EVENT : "ON_REFRESH",
	transformBase : "",
	list_xsl : null,
	init : function() {

		XTREE_LISTENERS.list_xsl = $.ajax(XTREE_LISTENERS.transformBase
				+ "list_transform.xslt", {
			"async" : false,
			"type" : "GET"
		}).responseText;

	},

	xml_block_refresh : function(arg) {
		$('#xml_block').text(XTree.toString());
	},

	selected_list_refresh : function(tree) {

		var html = jsxml.transReady(tree, XTREE_LISTENERS.list_xsl)
		$('#selected_list_items').html(html);
	}

};