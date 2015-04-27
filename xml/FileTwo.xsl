<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h1>Trajets</h1>
                <table border="1">
                    <tr>
                        <th>id</th>
                        <th>start</th>
                        <th>end</th>
                        <th>distance</th>
                    </tr>
         <xsl:for-each select="Courses/Course">
                    <tr>
                        <td><xsl:value-of select="id"/></td>
                        <td><xsl:value-of select="start"/></td>
                        <td><xsl:value-of select="end"/></td>
                        <td><xsl:value-of select="distance"/></td>
                    </tr>
                 </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet> 