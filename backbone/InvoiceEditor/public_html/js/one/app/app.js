/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$().ready(function() {


    window.model = new Backbone.Model();
    window.model.set({customer_name: '',invoice_id: '', invoice_date: ''});
    window.viewItem = new window.FormView({model: window.model});
    //window.viewItem.model = window.model;

    window.model.bind('change', function () {
                $('#modelData').html(JSON.stringify(window.model.toJSON()));
    });

    model.trigger('change');
    $('#mainContent').append(window.viewItem.render().$el);
    model.set({customer_name:'bob farp'}) ;
    window.viewItem.render();

});// end document ready





