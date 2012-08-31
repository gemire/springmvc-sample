To set up the server see notes at
http://donhenton.com/wiki/tiki-index.php?page=LDAP

This demo is for code that will place a properties file into an LDAP server. 
App.java creates a javaContainer, and BindDemo places properties items
into that container

SpringLdapJndiDemo reads the properties out of the LDAP server and the
spring file uses them for a propertyconfigurator
