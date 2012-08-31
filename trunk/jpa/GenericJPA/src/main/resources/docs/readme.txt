This might work for hibernate :

 <bean id="sessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
   <property name="dataSource" ref="dataSource"/>
   <property name="annotatedClasses">
     <list>
       <value>test.package.Foo</value>
       <value>test.package.Bar</value>
     </list>
   </property>
 </bean>

Or when using classpath scanning for autodetection of entity classes:

 <bean id="sessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
   <property name="dataSource" ref="dataSource"/>
   <property name="packagesToScan" value="test.package"/>
 </bean>