<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
<xsl:template match="crearExamen">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body" extent="20mm">
				<xsl:apply-templates select="examen"/>
        </fo:flow>
      </fo:page-sequence>
     </fo:root>
</xsl:template>
<xsl:template match="examen">
		  <fo:block font-size="15pt" font-weight="bold" space-after="5mm" break-before="page"> <xsl:value-of select="titulo"/>
          </fo:block>
		  <fo:block font-size="13pt" font-style="italic" space-after="5mm"><xsl:value-of select="subtitulo"/>
		  </fo:block>
          <fo:block font-size="13pt" space-after="5mm"><xsl:value-of select="fecha"/>
		  </fo:block>
		  <fo:block font-size="13pt" space-after="5mm"><xsl:value-of select="nombre"/>
		  </fo:block>
		  <fo:block space-after="5mm">
			<xsl:apply-templates select="pregunta"/>
		  </fo:block>
</xsl:template>
	<xsl:template match="pregunta">
		<fo:block font-size="12pt" space-after="5mm">
			<xsl:value-of select="numpregunta"/>.<xsl:value-of select="textoPregunta"/>
			<xsl:apply-templates select="inciso"/>
		</fo:block>
  </xsl:template>
	<xsl:template match="inciso">
		<fo:block font-size="9pt" space-after="3mm">
			<xsl:value-of select="letra"/>.<xsl:value-of select="textoInciso"/>
		</fo:block>
	</xsl:template>
</xsl:stylesheet>