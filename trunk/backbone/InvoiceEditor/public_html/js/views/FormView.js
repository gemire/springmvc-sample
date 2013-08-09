/*global Backbone, jQuery, _, ENTER_KEY */



(function($) {
    window.FormView = Backbone.View.extend({
        _modelBinder: undefined,
        template : _.template($('#FormView-template').html()),
        bindings:
                ['customer_name']
         ,
        initialize: function() {
            this._modelBinder = new Backbone.ModelBinder();
  
        }, //end initialize
        close: function() {
            this._modelBinder.unbind();
        },
        render: function() {
            this._modelBinder.bind(model, this.el);
            
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        },
    });


})(jQuery);


 
 

