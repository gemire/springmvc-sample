Test
Here is sample usage. 
1.	Define an interface that extends the generic interface
2.	Define a concrete class that extends the GenericDAOSpringImpl
3.	In each case, name the Class of the concrete object and the class of the key
4.	Add extended methods to the implementation

---------- INTERFACE -----------------------------------------------------------------------

package com.dhenton9000.helpdesk.dao;

import com.dhenton9000.generic.GenericDAO;
import com.dhenton9000.helpdesk.generated.Codes;


public interface CodesDAO extends GenericDAO<Codes,Integer> {
    //application specific
	public void deleteById(int id);

}


---------- SAMPLE IMPLEMENTATION AND EXTENSION FOR A CONCRETE HIBERNATE ENTITY -------------
package com.dhenton9000.helpdesk.spring.dao;

import com.dhenton9000.helpdesk.dao.CodesDAO;
import com.dhenton9000.helpdesk.generated.Codes;
import com.dhenton9000.spring.dao.GenericDAOSpringImpl;

public class CodesDAOImpl extends GenericDAOSpringImpl<Codes, Integer> implements CodesDAO {

	 
	public void deleteById(int id) {
		 Integer var = new Integer(id);
		 Codes c = new Codes();
		 c.setCodeId(var);
		 delete(c);
		 
		
	}
	
----------- sample spring bean file ----------------------------------------------------------

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
	http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

	<bean id="sessionFactory"
		class="org.springframework.orm.hibernate3.LocalSessionFactoryBean">
		<property name="configLocation" value="file:src/hibernate.cfg.xml">
		</property>
	</bean>
	<bean id="transactionManager"
		class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory" />
	</bean>

	<bean id="codesDAO" class="com.dhenton9000.helpdesk.spring.dao.CodesDAOImpl">
		<property name="sessionFactory">
			<ref bean="sessionFactory" />
		</property>
		<property name="transactionManager">
			<ref bean="transactionManager" />
		</property>
	</bean>
	
</beans>		 
	

}
