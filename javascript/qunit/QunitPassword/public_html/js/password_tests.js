test("hello test", function() {
    ok(1 == "1", "Passed!");
});


test("weak password test", function() {

    res = validatePassword("pass");
    deepEqual(res, "weak", "test failed bozo " + res);

});



test("medium password test", function() {

    res = validatePassword("a7b");
    deepEqual(res, "medium", "test failed bozo " + res);

});


test("medium password test with $", function() {

    res = validatePassword("7$");
    deepEqual(res, "medium", "test failed bozo " + res);

});


test("good password test", function() {

    res = validatePassword("adlkjf34$$");
    deepEqual(res, "good", "test failed bozo " + res);

});



test("fail with ws password test", function() {

    res = validatePassword("  a  7b  ");
    deepEqual(res, "fail", "test failed bozo '" + res + "'");

});

test("empy password test", function() {

    res = validatePassword("    ");
    deepEqual(res, "fail", "test failed bozo " + res);

});