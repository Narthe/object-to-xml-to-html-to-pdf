<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet 
    version="1.0" 
    xmlns:xhtml="http://www.w3.org/1999/xhtml"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    exclude-result-prefixes="xhtml xsl"
>
<xsl:output method="xml"
              doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" 
              encoding="UTF-8"
              doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
              indent="yes" />

    <xsl:template match="/">
        <html>
            <head>
                <!-- <meta charset="UTF-8" /> -->
                <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />  -->
                <meta name="viewport" content="width=device-width, initial-scale=1.0" /> 
                <title>Trajets</title>
                <meta name="description" content="Trajets professionnels de charlotte vaire" />
                <meta name="keywords" content="trajets professionnels" />
                <meta name="author" content="Kilometro" />
                <link rel="shortcut icon" href="../favicon.ico" />
                <link rel="stylesheet" type="text/css" href="../templates/style.css" />
                <!--[if IE]>
                <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
                <![endif]-->
            </head>
            <body>
                <div class="container">
                    <!-- Top Navigation -->
                    <div class="header">
                        <h1>Feuille de trajets professionnels de <em>Charlotte Vaire</em><span>Sur la periode du <em>01/05/2015</em> au <em>31/05/2015</em></span></h1> 
                    </div>
                    <div class="component">
                        <h2>Total : <em>548 km</em></h2>
                        <table>
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>start</th>
                                    <th>end</th>
                                    <th>distance</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="Courses/Course">
                                    <tr>
                                        <td class="user-name"><xsl:value-of select="id"/></td>
                                        <td class="user-email"><xsl:value-of select="start"/></td>
                                        <td class="user-phone"><xsl:value-of select="end"/></td>
                                        <td class="user-mobile"><xsl:value-of select="distance"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>    
                        </table>
                    </div>
                </div><!-- /container -->
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet> 