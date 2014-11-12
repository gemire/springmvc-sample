<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes" />

    <xsl:variable name="vApos">'</xsl:variable>
    <xsl:variable name="vQuot">"</xsl:variable>
    <xsl:variable name="vOpenIcon">&#x25bc;</xsl:variable>
    <xsl:variable name="vClosedIcon">&#x25ba;</xsl:variable>
    
    <xsl:template match="/">
        <ul>
            <xsl:apply-templates />
        </ul>
     
    </xsl:template>
    <xsl:template match="level1">
          

        <li>
            <xsl:attribute name="id">
                <xsl:value-of select="concat('level_1_', @id)" />
            </xsl:attribute>
                
            <span class="indicator">
                <!-- <xsl:attribute name="class">indicator</xsl:attribute> -->
                <xsl:attribute name="onclick">
                    <xsl:value-of select="concat('XTree.openFolder(1,', @id,');')" />
                </xsl:attribute>
 
                <xsl:choose>
                    <xsl:when test="@folder = 'open'">
                        <i class='icon-folder-open' /> 
                        <xsl:value-of select="$vOpenIcon" />
                    </xsl:when>
                    <xsl:otherwise>
                        <i class='icon-folder-close' />
                        <xsl:value-of select="$vClosedIcon" />
                    </xsl:otherwise>
                </xsl:choose>    
            </span>
                            
            <xsl:variable name="escapedName">
                <xsl:apply-templates select="@name" mode="escape" />
            </xsl:variable>    
                
                
            <span class="badge">
                <xsl:attribute name="id">
                    <xsl:value-of select="concat('level_1_name_', @id)" />
                </xsl:attribute>
  
                <xsl:value-of select="@name"/>
            </span>
            
             <xsl:apply-templates select="level2" />
        </li>
       
    </xsl:template>
    <xsl:template match="level2">
        <ul> 
            <xsl:attribute name="class">
                <xsl:choose>
                    <xsl:when test="@visible = 'yes'">tree-folder</xsl:when>
                    <xsl:otherwise>tree-folder tree-hidden</xsl:otherwise>
                </xsl:choose>  
            </xsl:attribute>
            <li>
                <xsl:attribute name="id">
                    <xsl:value-of select="concat('level_2_', @id,this)" />
                </xsl:attribute>

                <span class="indicator">
                    <!-- <xsl:attribute name="class">indicator</xsl:attribute> -->
                    <xsl:attribute name="onclick">
                        <xsl:value-of select="concat('XTree.openFolder(2,', @id,');')" />
                    </xsl:attribute>
                       
                    <xsl:choose>
                        <xsl:when test="@folder = 'open'">
                            <i class='icon-folder-open' /> 
                            <xsl:value-of select="$vOpenIcon" />
                        </xsl:when>
                        <xsl:otherwise>
                            <i class='icon-folder-close' /> 
                            <xsl:value-of select="$vClosedIcon" />
                        </xsl:otherwise>
                    </xsl:choose>    
                </span>
   
                <xsl:variable name="escapedName">
                    <xsl:apply-templates select="@name" mode="escape" />
                </xsl:variable>    
                  
          
                <span class="badge badge-info">
                    <xsl:attribute name="id">
                        <xsl:value-of select="concat('level_2_name_', @id)" />
                    </xsl:attribute>
  
                    <xsl:value-of select="@name"/>
                </span>
  
                <xsl:apply-templates select="level3"   />
            </li>
        </ul>
    </xsl:template>
    <xsl:template match="level3">
        <ul>
            <xsl:attribute name="class">
                <xsl:choose>
                    <xsl:when test="@visible = 'yes'">tree-folder</xsl:when>
                    <xsl:otherwise>tree-folder tree-hidden</xsl:otherwise>
                </xsl:choose>  
            </xsl:attribute>
            <li>
                <xsl:variable name="escapedName">
                    <xsl:apply-templates select="@name" mode="escape" />
                </xsl:variable>    
               
                <span class="label label-important">
                    <xsl:attribute name="id">
                        <xsl:value-of select="concat('level_3_name_', @id)" />
                    </xsl:attribute>
                     <i class="icon-tag icon-white" />
                    <xsl:value-of select="@name"/> 
                </span>
                <input class="checkbox large"  type="checkbox">
                    <xsl:if test="@checked = 'yes'">
                        <xsl:attribute name="checked"></xsl:attribute>
                    </xsl:if>
                    <xsl:attribute name="onclick">
                        <xsl:value-of select="concat('XTree.selectItem(3,', @id,');')" />
                    </xsl:attribute>
                </input>   


            </li>
        </ul>
    </xsl:template>
   
    <!--  aaaaaaaaaaaaaaaaaaaaaaaaa escape  
    http://stackoverflow.com/questions/14287598/single-quote-escaping-a-dynamic-value-of-string-in-xslt-1-0 
    -->
    
    <xsl:template match="@* | node()" mode="escape">
        <!-- Escape the apostrophes second -->
        <xsl:call-template name="replace">
            <xsl:with-param name="pTarget" select='"&apos;"' />
            <xsl:with-param name="pReplacement" select='"\&apos;"'/>
            <xsl:with-param name="pText">
                <!-- Escape the backslashes first, and then pass that result directly into the next template -->
                <xsl:call-template name="replace">
                    <xsl:with-param name="pTarget" select="'\'" />
                    <xsl:with-param name="pReplacement" select="'\\'" />
                    <xsl:with-param name="pText" select="." />
                </xsl:call-template>
            </xsl:with-param>
        </xsl:call-template>
    </xsl:template>

    <xsl:template name="replace">
        <xsl:param name="pText"/>
        <xsl:param name="pTarget" select='"&apos;"'/>
        <xsl:param name="pReplacement" select="'\&quot;'"/>

        <xsl:if test="$pText">
            <xsl:value-of select='substring-before(concat($pText,$pTarget),$pTarget)'/>
            <xsl:if test='contains($pText, $pTarget)'>
                <xsl:value-of select='$pReplacement'/>
            </xsl:if>

            <xsl:call-template name="replace">
                <xsl:with-param name="pText" select='substring-after($pText, $pTarget)'/>
                <xsl:with-param name="pTarget" select="$pTarget"/>
                <xsl:with-param name="pReplacement" select="$pReplacement"/>
            </xsl:call-template>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>