/*global Backbone, jQuery, _, ENTER_KEY */



(function($) {
    window.FormView = Backbone.View.extend({
        template: _.template($('#FormView-template').html()),
        events: {
            "keypress #submit_invoice": "updateModel",
            "click #submit_invoice": "updateModel"
        },
        initialize: function() {


        }, //end initialize
        close: function() {

        },
        render: function() {
            //this.setElement($('#mainContent'));
            $(this.el).html(this.template(this.model.toJSON()));
            return this;
        },
        updateModel: function()
        {
           
            var customer_name = $("#viewContent [name='customer_name']").val();
            var invoice_id = $("#viewContent [name='invoice_id']").val();
            var invoice_date = $("#viewContent [name='invoice_date']").val();
 
            model.set({
                customer_name: customer_name,
                invoice_id: invoice_id,
                invoice_date: invoice_date
            });
            this.render();
        },
    });


})(jQuery);





