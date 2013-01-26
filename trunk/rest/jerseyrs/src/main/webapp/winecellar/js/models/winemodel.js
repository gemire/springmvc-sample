window.Wine = Backbone.Model.extend({
	urlRoot: "../resources/wines",
	defaults: {
		"id": null,
	    "name":  "",
	    "grapes":  "",
	    "country":  "USA",
	    "region":  "California",
	    "year":  "",
	    "description":  "",
	    "picture":  ""
	  }
});

window.WineCollection = Backbone.Collection.extend({
	model: Wine,
	url: "../resources/wines"
});