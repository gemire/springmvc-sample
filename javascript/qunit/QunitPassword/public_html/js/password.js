function validatePassword(passWord)
{
    var whiteSpaceCriteria = new RegExp(" ", "g");

    if (passWord.match(whiteSpaceCriteria))
    {
        return "fail";
    }

    var strength = 1;
    //letters numbers capitals, and something like '$'
    criteria = [/[a-z]+/, /[0-9]+/, /[A-Z]+/, /[^\w\*]/];

    for (var i = 0; i < criteria.length; i++) {
        if (passWord.match(criteria[i])) {
            strength++;
        }
    }

    if (strength == 1)
    {
        result = "bad";

    } else if (strength < 3) {
        result = "weak";

    } else if (strength == 3 && !passWord.match(/.{8,}/)) {
        result = "medium";

    } else {
        result = "good";
    }

    return result;
}