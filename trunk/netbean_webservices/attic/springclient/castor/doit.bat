SET CASTOR_JAR=.\\commons-logging.jar;.\\castor-1.3.1-core.jar;.\\castor-1.3.1-codegen.jar;.\\castor-1.3.1.jar;.\\castor-1.3.1-xml.jar;.\\castor-1.3.1-xml-schema.jar;.
SET CLASSPATH=%CASTOR_JAR%
java   org.exolab.castor.builder.SourceGeneratorMain -i ..\src\FootBallSchema.xsd    -package com.mason.castor.webtest
