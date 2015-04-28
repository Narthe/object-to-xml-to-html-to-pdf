<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html lang="en" class="no-js">
            <head>
                <meta charset="UTF-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" /> 
                <meta name="viewport" content="width=device-width, initial-scale=1.0" /> 
                <title>Trajets</title>
                <meta name="description" content="Sticky Table Headers Revisited: Creating functional and flexible sticky table headers" />
                <meta name="keywords" content="Sticky Table Headers Revisited" />
                <meta name="author" content="Codrops" />
                <link rel="shortcut icon" href="../favicon.ico" />
                <link rel="stylesheet" type="text/css" href="normalize.css" />
                <link rel="stylesheet" type="text/css" href="demo.css" />
                <link rel="stylesheet" type="text/css" href="component.css" />
                <!--[if IE]>
                <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
                <![endif]-->
            </head>
            <body>
                <div class="container">
                    <!-- Top Navigation -->
                    <header>
                        <h1>Feuille de trajets professionnels de <em>Charlotte Vaire</em><span>Sur la periode du <em>01/05/2015</em> au <em>31/05/2015</em></span></h1> 
                    </header>
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