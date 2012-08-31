mvn clean to remove all classes
mvn install to move needed jar files to WEB-INF lib

you need to add a DSN for the access database


a. Start --> Settings --> Control Panel --> Administrative Tools --> Data Sources (ODBC)
b. System DSN --> Add --> Microsoft Access Driver (*.mdb) --> Finish
c. DataSource Name: STRUTS_TRAINING
d. Database Select: --> C:\struts-training\customers.mdb

http://objectsource.com/resources.html


clean jetty:run-war will run the jetty server and you can 
visit the application at http://localhost:8080/StrutsDemo