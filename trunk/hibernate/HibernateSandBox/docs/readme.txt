This fragment in the build file and the maven ant task could allow maven
to do the generation



   <!--
    <target name="generateDDL">
        <property name="compile_classpath" refid="maven.compile.classpath"/>
        <property name="runtime_classpath" refid="maven.runtime.classpath"/>
        <property name="test_classpath" refid="maven.test.classpath"/>
        <property name="plugin_classpath" refid="maven.plugin.classpath"/>
        <echo message="compile classpath: ${compile_classpath}"/>
        <echo message="runtime classpath: ${runtime_classpath}"/>
        <echo message="test classpath:    ${test_classpath}"/>
        <echo message="plugin classpath:  ${plugin_classpath}"/>
        <mkdir dir="${basedir}/target/generated-sources/schema" />
        <taskdef name="hibernatetool" classname="org.hibernate.tool.ant.HibernateToolTask"  classpathref="compile_classpath" />
        <hibernatetool destdir="${basedir}/target/generated-sources">
            <classpath refid="${compile_classpath}" />
            <annotationconfiguration configurationfile="${basedir}/src/main/resources/hibernate.cfg.xml"/>
            <hbm2ddl drop="true" create="true" export="${export}" 
                    outputfilename="schema.ddl" delimiter=";" format="true" />
        </hibernatetool>
    </target>
    -->
    
this fragment in pom

     <!--
    <plugins>
        <plugin>
            <artifactId>maven-antrun-plugin</artifactId>
            <executions>
                <execution>
                    <id>generate-ddl</id>
                    <phase>process-classes</phase>
                    <goals>
                        <goal>run</goal>
                    </goals>
                    <configuration>
                        <tasks>
                            <ant antfile="${basedir}/build.xml" inheritRefs="true">
                                <target name="generateDDL" />
                            </ant>
                        </tasks>
                    </configuration>
                </execution>
            </executions>
               
        </plugin>


    </plugins>
    -->

=================================================================
The join demo illustrates the idea of the owning side of a hibernate 
relationship. The results produce identical sqls because the foreign key
column is also the primary key in the question table

use the ant build script build_join.xml
http://josian.wordpress.com/2006/09/09/hibernate-annotations-bidirectional-one-to-many/


=============================================================================
added a many-to-many demo. The build.xml file will create the students, 
classes, and class_assignments tables from 
com.dhenton9000.hibernate.join.mapping.demo.jointable package

The TestDao includes the testManyToMany that shows that the write is 
into students, class_assignments, and classes. Only merge seems to do 
this.
