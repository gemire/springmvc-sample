/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function alpha()
{
    this.x = 1;
    this.y = 2;
}
alpha.prototype.setY = function(t)
{
    this.y = t;
};
alpha.prototype.setX = function(t)
{
    this.x = t;
};

alpha.prototype.getY = function()
{
    return this.y;
};
alpha.prototype.getX = function()
{
    return this.x;
};

module("jsobj_tests.js javascript objects", {
    setup: function() {
       // console.log("in setup for js obj");
    },
    teardown: function() {
       // console.log("in teardown for js obj");
    }
});


test('test init values', function() {
    var alpha1 = new alpha();

    equal(alpha1.getX(), 1);
    equal(alpha1.getY(), 2);
});

test('test mutators', function() {
    var alpha2 = new alpha();
    alpha2.setX(4);
    alpha2.setY(6);
    equal(alpha2.getX(), 4);
    equal(alpha2.getY(), 6);

    var alpha1 = new alpha();
    equal(alpha1.getX(), 1);
    equal(alpha1.getY(), 2);
});