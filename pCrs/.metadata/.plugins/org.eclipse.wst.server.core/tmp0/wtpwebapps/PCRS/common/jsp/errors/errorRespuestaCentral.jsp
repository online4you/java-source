<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div style="margin: 0 auto;width:775px" id="contenedor" >
	<div style="font-family:Verdana,Arial,Helvetica,sans-serif;font-size:1.6em;" id="contenido">

		<div id="detallesviaje">
			<ul class="botonera03">
				<li id="LITITULOERROR" class="actual" style="text-align: center;"><s:property value="getText('lang.gen.informacion')"/></li>
			</ul>
			<div class="botonera03barra">
				<div class="activo"></div>
				<div class="noactivo"></div>
				<div class="noactivo"></div>
				<div class="noactivo"></div>
				<div style="margin-right:0px; margin-left:0px;" class="noactivo"></div>
			</div>
			<img height="120px" width="141px" src="<s:property value="getContextPath()"/>/static/main/images/HAL1024/operadora.jpg" text-align="center" style="float:left;">
			<div style="height:117px;" class="tabladetalles16">
				<div style="height:auto;" class="tabdetalleviajecabecera">
					<span id="SPNERRORCONFIRM1" class="texto_2"><s:property value="getText('lang.gen.pantallaError.confirmacionServicio')"/></span>
				</div>
				<div style="height:30px;" class="limpiar"></div>
			  	<div style="width:600px;" class="columna02">
					<div class="etiqueta1">
						<span id="SPNERRORCONFIRM2" class="texto_16"><s:property value="getText('lang.gen.pantallaError.textoConfirmacionServicio')"/></span>
					</div>
					<div style="height:14px;" class="limpiar"></div>
					<div class="botonInferior">
						<div class="contboton">
							<div class="bot03"><p><a id="ENLACEERRORCONFIRM" class="texto_15" href="http://www.halconviajes.com"><s:property value="getText('lang.gen.volver')"/></a></p></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="limpiar"></div>
		<div class="pieDerecho">
			<div id="CAPAERRORHORARIO1" class="texto_12"><s:property value="getText('lang.gen.pantallaError.horario')"/></div>
			<div id="CAPAERRORHORARIO2" class="texto_12"><s:property value="getText('lang.gen.pantallaError.horarioFinSemana')"/></div>
		</div>
		<div style="height:50px;" class="limpiar"></div>
	</div>
</div>
<script>
	$j(".zona-izda").css('width','930px');
	$j(".zona-dcha").hide();
	$j(".contenedor-general").css('padding-bottom','0px');
</script>