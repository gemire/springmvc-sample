<SCRIPT>

    $(document).ready(function() {


        

        setUp();


    });


    function setUp()
    {
        firstAccountant = depts['accounting'][0];
        $('#firstAccountantDisplay').html(firstAccountant.lastName + ", " + firstAccountant.firstName);


        ///////


        var accountantListing = "";
        $.each(depts['accounting'],
                function()
                {
                    accountantListing += this.firstName + " " + this.lastName + " age: " + this.age + "<br/>";
                }
        );
        $('#accountantListingDisplay').html(accountantListing);


        ////////////

        youngestSalesMan = $.grep(depts['sales'],
                function(item, idx)
                {

                    if (item.age < 30)
                        return true;
                    else
                        return false;
                }
        );
        youngestSalesManInfo = youngestSalesMan[0].lastName + ", " + youngestSalesMan[0].firstName + " age: " + youngestSalesMan[0].age;
        $('#youngestSalesManDisplay').html(youngestSalesManInfo);

    }


    var depts = {"accounting": [// accounting is an array in employees.                                    
            {"firstName": "John", // First element                                      
                "lastName": "Doe",
                "age": 23},
            {"firstName": "Mary", // Second Element  
                "lastName": "Smith",
                "age": 32}],
        // End "accounting" array.                                                    
        "sales": [// Sales is another array in employees.                                    
            {"firstName": "Sally", // First Element                                      
                "lastName": "Green",
                "age": 27},
            {"firstName": "Jim", // Second Element                                
                "lastName": "Galley",
                "age": 41}]
                // End "sales" Array.                
    } // End Employees




</SCRIPT>





<DIV class="tabbable">
    <UL class="nav nav-tabs">
        <LI class="active"><A href="#tabs-1"  data-toggle="tab">Code</A></LI>
        <LI><A href="#tabs-2"  data-toggle="tab">More Code</A></LI>
        <LI><A href="#tabs-3"  data-toggle="tab">JSON Data</A></LI>
    </UL>

    <div class="tab-content">
        <div id="tabs-1" class="tab-pane active">

            <table border="1" cellpadding="5" cellspacing="1" >
                <tr><th>Item</th><th>Formula</th><th>Result</th></tr>


                <tr><td>The first Accountant</td><td>
                        <pre>
firstAccountant  = depts['accounting'][0];
$('#firstAccountantDisplay').html(firstAccountant.lastName+", "
+firstAccountant.firstName);
                        </pre>
                    </td><td id="firstAccountantDisplay"></td></tr>
                <!--  -->
                <tr><td>List of Accountants</td><td>
                        <pre>
var accountantListing = "";
$.each(depts['accounting'],
  function()
  {
   accountantListing += this.firstName+" "+this.lastName+ " age: "
   +this.age +"&lt;br/&gt;";
  }
);
$('#accountantListingDisplay').html(firstAccountant.lastName+", "
+firstAccountant.firstName);
                        </pre>
                    </td><td id="accountantListingDisplay"></td></tr>
                <!--  -->

            </table>



        </div> <!-- end tab 1 -->
        <div id="tabs-2" class="tab-pane" >

            <table border="1" cellpadding="5" cellspacing="1" >
                <tr><th>Item</th><th>Formula</th><th>Result</th></tr>




                <tr><td>Salesman Under 30</td><td>
                        <pre>
youngestSalesMan = $.grep(depts['sales'],
  function(item,idx)
  {
	if (item.age < 30)
		return true;
	else
		return false;
  }
);
youngestSalesManInfo = youngestSalesMan[0].lastName+", "
+youngestSalesMan[0].firstName+" age: "+youngestSalesMan[0].age;
$('#youngestSalesManDisplay').html(youngestSalesManInfo);
 
                        </pre>
                    </td><td id="youngestSalesManDisplay"></td></tr>
            </table>



        </div> <!-- end tab 2 -->
        <div id="tabs-3" class="tab-pane">

            <pre>
var depts = 
{ "accounting" : [   // accounting is an array in employees.                                    
                   { "firstName" : "John",  // First element                                      
                        "lastName"  : "Doe",                                      
                       	"age"       : 23 }, 

                   { "firstName" : "Mary",  // Second Element  
                        "lastName"  : "Smith",                                      
                        "age"       : 32 } ],
                      // End "accounting" array.                                                    
  "sales"     : [ // Sales is another array in employees.                                    
                   { "firstName" : "Sally", // First Element                                      
                     "lastName"  : "Green",                                      
                     "age"       : 27 },                                                

				   { "firstName" : "Jim",   // Second Element                                
     				 "lastName"  : "Galley",                                      
     				 "age"       : 41 } ] 
     				 // End "sales" Array.                
               } // End Depts
            </pre>

        </div> <!-- end tab 3 -->
    </div>

</DIV>