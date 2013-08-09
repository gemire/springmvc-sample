/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$().ready(function() {


    window.model = new Backbone.Model();
    window.model.set({customer_name: 'Bob Cratchit',invoice_id: '100101'});
    window.viewItem = new window.FormView({model: window.model});
    //window.viewItem.model = window.model;
    $('#mainContent').append(window.viewItem.render().$el);

     


});// end document ready





