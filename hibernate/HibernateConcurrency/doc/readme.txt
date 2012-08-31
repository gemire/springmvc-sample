this command in the project folder (the one with the pom) will
generate the java classes. This has to be done from a prompt, 
as it doesn't work in eclipse.


mvn org.codehaus.mojo:hibernate3-maven-plugin:hbm2java

this creates a folder called target/hibernate3 which will contain the 
java classes.

mvn clean removes the target area
mvn package will move all the stuff out, and compile 
hbm and cfg files need to be in the resources folder which needs to 
be created by hand, at least if the project was set up in eclipse

however, it sucks. the ant script is the one you want to use, as it 
will produce all the nifty artifacts for hibernate.

====================================================================
This code also demonstrates concurrency "record has changed since you 
last read it" control in hibernate. The project doesn't contain a database
connection. but the users table has been set to handle concurrency
via the definition of a in the hbm file located in the resources folder
see that file for further notes.

concurrency demo in the test folder will show a sample of the error.
