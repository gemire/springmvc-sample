/*global Backbone, jQuery, _, ENTER_KEY */



(function($) {
    window.FormView = Backbone.View.extend({
        _modelBinder: undefined,
        template : _.template($('#FormView-template').html()),
         
         
        initialize: function() {
            this._modelBinder = new Backbone.ModelBinder();
  
        }, //end initialize
        close: function() {
            this._modelBinder.unbind();
        },
        render: function() {
            this.setElement($('#mainContent'));
            var bindings = {
                            customer_name: '[name=customer_name]',
                            invoice_id: '[name=invoice_id]'  };
            this._modelBinder.bind(this.model, this.$('viewContent'));
             
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        },
    });


})(jQuery);


 
 

