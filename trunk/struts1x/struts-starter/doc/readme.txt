http://blog.adaptivesoftware.biz/2012/04/creating-eclipse-web-project-using.html

//svn co http://svn.apache.org/repos/asf/struts/maven/trunk/struts-archetype-blank
from the zip file install the archetype in mvn
cd struts-archetype-blank
mvn install



mvn archetype:generate -DarchetypeGroupId=org.apache.struts -DarchetypeArtifactId=struts-archetype-blank -DarchetypeVersion=1.3.5-SNAPSHOT -DgroupId=com.diycomputerscience -DpackageName=com.diycomputerscience.stslides -DartifactId=struts-slides

inside the generated item:
mvn eclipse:eclipse -Dwtpversion=2.0


