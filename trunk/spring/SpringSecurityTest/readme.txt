from

http://howtodoinjava.com/2013/04/19/how-to-unit-test-spring-security-authentication-with-junit/

This has been updated for the latest version of Spring Security

Changes from 2.5.x - 3.0.x to 3.1.x

This line in the test had to be changed as InMemoryDaoImpl is no longer
the implementation of <authentication-manager alias="authenticationManager"> 
    userDetailsService = applicationContext.getBean(InMemoryDaoImpl.class);


SimpleGrantedAuthority replaces GrantedAuthorityImpl for the tests requiring
grants.