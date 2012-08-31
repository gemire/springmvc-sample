<?xml version="1.0" encoding="windows-1252"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Application Output</title>
            </head>
            
            <body>
                <h3>Application:
                    <xsl:value-of select="applications/applicationName" />
                </h3>
                <h5>Application Id: 
                    <xsl:value-of select="applications/applicationId" />
                </h5>
                <table cellpadding="5" cellspacing="5">
                    <tr>
                        <td valign="top">
                            <table border="1">
                                <tr bgcolor="#9acd32">
                                    <th  colspan="2" >Groups</th>
                                </tr>
                                <tr bgcolor="#9acd32">
                                    <th>Name</th>
                                    <th>Id</th>
                                </tr>
                                <xsl:for-each select="applications/groups/group">
                                    <tr>
                                        <td>
                                            <xsl:value-of select="groupName"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="groupId"/>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </table>
                        </td>
                        <td>
                            <table border="1">
                                <tr bgcolor="#9acd32">
                                    <th  colspan="2" >Users</th>
                                </tr>
                                <tr bgcolor="#9acd32">
                                    <th>Name</th>
                                    <th>Id</th>
                                </tr>
                                <xsl:for-each select="applications/users/user">
                                    <tr>
                                        <td>
                                            <xsl:value-of select="username"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="userId"/>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </table>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
