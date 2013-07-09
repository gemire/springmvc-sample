 $(document).ready(function() {
                /*
                 * jQuery Ajax form submission and Wicket response
                 */
                $('#clickme').click(function() {
                    // get the form input values
                    // var fName = $('input.jqueryid_firstName').val();
                    // var lName = $('input.jqueryid_lastName').val();
                    // ajax callback to the server using jQuery
                    $('form.jqueryid_form1').ajaxSubmit({cache: false, success: function(html) {
                            $('#responses').append(html + "<br/>");
                        }});
                });

                /*
                 * jQuery Ajax lookup dropdown list
                 */
                $('input.jqueryid_state').keyup(function() {

                    var showStatesJson = function(json) {
                        var listDomElement = ""
                        $.each(json, function(index, value) {
                            if (listDomElement == "") {
                                listDomElement = "<select size=\"5\">";
                            }
                            listDomElement += "<option>" + value + "</option>"
                        });
                        if (listDomElement != "") {
                            listDomElement += "</select>";
                        }
                        $('#statelist').html(listDomElement);
                    };

                    // get the form input values
                    // var target = $(this).val();

                    var options = {
                        dataType: "json",
                        cache: false,
                        success: showStatesJson
                    };


                    if ($(this).val() != "") {
                        $('form.jqueryid_form2').ajaxSubmit(options);
                    } else {
                        $('#statelist').html("");
                    }
                });

            });