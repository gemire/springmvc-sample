
    select
        "CUSTOMERNUMBER",
        "CUSTOMERNAME",
        "CONTACTLASTNAME",
        "CONTACTFIRSTNAME",
        "PHONE",
        "ADDRESSLINE1",
        "ADDRESSLINE2",
        "CITY",
        "STATE",
        "POSTALCODE",
        "COUNTRY",
        "SALESREPEMPLOYEENUMBER",
        "CREDITLIMIT" 
    from
        "CLASSICCARS"."CUSTOMER"
    where customernumber > 495