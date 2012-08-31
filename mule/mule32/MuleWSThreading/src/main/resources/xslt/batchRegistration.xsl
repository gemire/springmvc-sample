<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : batchRegistration.xsl
    Created on : April 9, 2012, 8:26 AM
    Author     : dhenton
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet version="2.0"
	xmlns:ns1="uri:dhenton9000:registrationService:ref" 
        xmlns:ns2="http://www.registrationsSystem/registration"
        xmlns:ns3="uri:dhenton9000.registrationBatch:Processing"
	xmlns="http://www.w3.org/2001/XMLSchema" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="utf-8" indent="yes" />
    <xsl:template match="/">
        <ns3:Batch>
            <xsl:apply-templates />
        </ns3:Batch>
    </xsl:template>

    
    
    <xsl:template   match="ns2:BatchRegistration/ns2:Requests/ns2:User">
        <ns1:RegisterInput>
            <ns1:name>
                <xsl:value-of select="ns2:name" />
            </ns1:name>
            <ns1:password>
                <xsl:value-of select="ns2:credentials" />
            </ns1:password>
       
    
    
        <ns1:registrationDetails>
            <ns1:paymentPlan><xsl:value-of select="ns2:selectedPlan" /></ns1:paymentPlan>
            <ns1:months><xsl:value-of select="ns2:planLength" /></ns1:months>
        </ns1:registrationDetails>
        <ns1:registrationDate><xsl:value-of select="/ns2:BatchRegistration/ns2:BatchHeader/ns2:TransactionTime" /></ns1:registrationDate>

     </ns1:RegisterInput>
    
    
    </xsl:template>
    <xsl:template   match="ns2:BatchRegistration/ns2:BatchHeader" />
        
 



</xsl:stylesheet>




 