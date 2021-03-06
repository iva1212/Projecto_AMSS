<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
<xsl:template match="crearExamen">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="1cm" margin-bottom="1cm" margin-left="1cm" margin-right="1cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body" extent="20mm" font-family="Times New Roman Georgia">
				<xsl:apply-templates select="examen"/>
        </fo:flow>
      </fo:page-sequence>
     </fo:root>
</xsl:template>
<xsl:template match="examen">
		  <fo:block font-size="15pt" font-weight="bold" space-after="5mm" break-before="page" text-align="center"> <xsl:value-of select="titulo"/>
          </fo:block>
		  <fo:block font-size="13pt" font-style="italic" space-after="5mm" text-align="center"><xsl:value-of select="subtitulo"/>
		  </fo:block>
		  <fo:block font-size="13pt" space-after="4mm" text-align="right"><xsl:value-of select="instructor"/> &#160; <xsl:value-of select="nombre"/>
		  </fo:block>
		  <fo:block font-size="13pt" space-after="4mm" text-align="right"><xsl:value-of select="matricula"/>
		  </fo:block>
          <fo:block font-size="13pt" space-after="4mm" text-align="right"><xsl:value-of select="fecha"/>
		  </fo:block>
		  <fo:block font-size="11pt" space-after="4mm" font-style="italic" ><xsl:value-of select="instruciones"/>
		  </fo:block>
		  <fo:block border-top-style="solid" font-size="0pt">.
		  </fo:block>   
		  <fo:block space-after="10mm">
			<xsl:apply-templates select="pregunta"/>
		  </fo:block>
</xsl:template>
	<xsl:template match="pregunta">
		<fo:block font-size="12pt" space-after="7mm">
			<xsl:value-of select="numpregunta"/>.___ <xsl:value-of select="textoPregunta"/>
			<xsl:choose>
				<xsl:when test="tipo = 'Abierta'">
					<fo:block white-space-collapse="false" white-space-treatment="preserve" 
						font-size="0pt" line-height="40px">.</fo:block>
					</xsl:when>
				<xsl:otherwise>
					<xsl:apply-templates select="inciso"/>
				</xsl:otherwise>
			</xsl:choose>
		</fo:block>
  </xsl:template>
	<xsl:template match="inciso">
		<fo:block font-size="10pt" space-after="3mm">
			&#160; &#160; &#160; &#160; &#160; &#160;
			<xsl:value-of select="letra"/>.<xsl:value-of select="textoInciso"/>
		</fo:block>
	</xsl:template>
	<xsl:template match="br">
      <xsl:value-of select="'&#x2028;'"/>
   </xsl:template>
</xsl:stylesheet>