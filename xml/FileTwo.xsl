<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>Indian Languages details</h1>
                <table border="1">
                    <tr>
                        <th>Language</th>
                        <th>Family/Origin</th>
                        <th>No. of speakers</th>
                        <th>Region</th>
                    </tr>
         <xsl:for-each select="languages-list/language">
                    <tr>
                        <td><xsl:value-of select="name"/></td>
                        <td><xsl:value-of select="family"/></td>
                        <td><xsl:value-of select="users"/></td>
                        <td><xsl:value-of select="region"/></td>
                    </tr>
                 </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet> 