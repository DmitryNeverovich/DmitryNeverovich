<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" 
                xmlns:gh="http://www.example.com/Greenhouse" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes" omit-xml-declaration="yes"/>

    <xsl:template match="/">
        <html>
        <head>
            <title>Greenhouse</title>
        </head>
        <body>    
        <table border="1">
            <tr bgcolor="#CCCCCC">
                <td align="center"><strong>Name</strong></td>
                <td align="center"><strong>Hight</strong></td>
                <td align="center"><strong>Soil</strong></td>
                <td align="center"><strong>Origin</strong></td>
                <td align="center"><strong>Multiplying</strong></td>
                <td align="center"><strong>ColorStalk</strong></td>
                <td align="center"><strong>ColorList</strong></td>
                <td align="center"><strong>Temperature</strong></td>
                <td align="center"><strong>Light</strong></td>
                <td align="center"><strong>Water</strong></td>
            </tr>
            <xsl:for-each select="gh:greenhouse/flower">
                <xsl:sort order="ascending"  data-type="number" select="visualParameters/growingtips/temperature"/>
                <tr bgcolor="#F5F5F5">
                    <td><xsl:value-of select="name"/></td>
                    <td><xsl:value-of select="hight"/></td>
                    <td><xsl:value-of select="soil"/></td>
                    <td><xsl:value-of select="origin"/></td>
                    <td><xsl:value-of select="multiplying"/></td>
                    <td><xsl:value-of select="visualParameters/colorStalk"/></td>
                    <td><xsl:value-of select="visualParameters/colorList"/></td>                    
                    <td><xsl:value-of select="visualParameters/growingtips/temperature"/></td>                    
                    <td><xsl:value-of select="visualParameters/growingtips/light"/></td>                    
                    <td><xsl:value-of select="visualParameters/growingtips/water"/></td>                                       
                </tr>
            </xsl:for-each>
        </table>
        </body>
      </html>  
    </xsl:template>
  
</xsl:stylesheet>