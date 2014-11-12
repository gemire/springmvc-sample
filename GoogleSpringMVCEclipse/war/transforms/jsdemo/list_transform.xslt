<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes" />    
     <xsl:template match="/">
         
            <xsl:apply-templates />
         
     </xsl:template>
     <xsl:template match="//level3[@checked = 'yes']">
           <span class="label label-important"><i class="icon-tag icon-white" /> <xsl:value-of select="@name" /></span> 
     </xsl:template>
</xsl:stylesheet>