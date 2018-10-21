<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:set name="path" value="getContextPath()"/>
<s:set name="metasAction" value="metasAction"/>
<s:set name="estilosAction" value="estilosAction"/>
<s:set name="scriptsAction" value="scriptsAction"/>
<s:set name="headAction" value="headAction"/>
<s:set name="contentAction" value="contentAction"/>
<s:set name="footAction" value="footAction"/>
<s:set name="postScriptAction" value="postScriptAction"/>
<s:set name="nameSpace" value="nameSpace"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title><s:property value="title"/></title>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  	
  		<tiles:insertAttribute name="head" />
  	
		<script type="text/javascript">
			var $j=jQuery;
		</script>
</head>
<body >
<!-- div id="fadeInit" class="sombraInicio" style="display:block;"></div-->	
<!-- div id="fadeInit" class="sombraInicio" style="display:block;"></div-->	
<div class="ocultar" id="capaCargandoV2" style="display: block;">
  <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/main/js/jquery.cycle.lite.min.js"></script>
  
   <div id="ventajasCargandoV2" class="fondo-cargando">
    <div class="area-1">
    <div class="dato1"><s:property value="getText('lang.trenes.trenes')"/></div>
    <div class="dato2" id="contenidoCargando" style="font-size: <s:property value="tamanoCargandoInicial"/>px;">
  			<s:property value="contenidoCargandoInicial"/>
  	</div>
    <div class="limpiar"></div>
	<div id="nombreProveedor"  style="position: relative;height:20px;text-align:center">
		<p class="ocultar" style="z-index: 1;  display: block; opacity: 1;width:100%"></p>
		<p class="ocultar" style="z-index: 2;  display: none; opacity: 0;width:100%"></p>
	</div>
	<div class="limpiar"></div>
	<div class="dato2"><s:property value="getText('lang.gen.pantallaCarga.espere')"/></div>
	<div class="limpiar"></div>
  </div>	

  <div id="ventajas" class="area-2" style="position: absolute; top: 290px;">
    <p class="dato1"><s:property value="getText('lang.gen.pantallaCarga.razonesPor')"/><br><s:property value="getText('lang.gen.pantallaCarga.confiarHalcon')"/></p>
    <ul>
      <li><span><s:property value="getText('lang.gen.pantallaCarga.garantiaGrupo')"/></span></li>
      <li><span><s:property value="getText('lang.gen.pantallaCarga.fee')"/></span></li>
      <!-- li><span><s:property value="getText('lang.gen.pantallaCarga.combina')"/></span></li-->
      <li><span><s:property value="getText('lang.gen.pantallaCarga.beneficiaTarifas')"/></span></li>
      <!-- li><span><s:property value="getText('lang.gen.pantallaCarga.aerolinias')"/></span></li-->
      <li><span><s:property value="getText('lang.gen.pantallaCarga.ahorroHasta60')"/></span></li>
      <li><span><s:property value="getText('lang.gen.pantallaCarga.mejoresOfertasTren')"/></span></li>
      
    </ul>
  </div>
  <div id="banner1" class="area-3" style="position: absolute; top: 290px; left: 724px;">
    <img width="300" height="250" alt="<s:property value="getText('lang.gen.pantallaCarga.altSolicitaTarjeta')"/>" src="<s:property value="getContextPath()"/>/static/main/images/HAL1024/banner_537549.gif">
  </div>	
  <div class="limpiar"></div>
  <div class="ocultar"></div>			</div>
  <script>
 	 $j('#nombreProveedor').cycle({fx:'fade',speed:'800',timeout: 1000}); 
  </script>
</div>
	
	
	
	
<!-- INI -->

<div id="main" style="display:none">
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="content">
		<tiles:insertAttribute name="content" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</div>


<!-- FIN -->
<div id='confirm'>
	<div class='header'><span><s:property value="getText('lang.gen.alerta')"/></span></div>
	<div class="limpiar"></div>
	<div class='body'>
		<div class='message'></div>
		<div class='buttons'>
			<div  class='no simplemodal-close boton-1'><s:property value="getText('lang.gen.aceptar')"/></div>
		</div>
		<div class="limpiar"></div>
	</div>
</div>
				
</body>
</html>
			<script type="text/javascript">
			$j(document).ready(function(){
 				$j('#capaCargandoV2').hide();
				$j('#nombreProveedor').cycle("stop");
				$j('#main').show();

				//$j("#main").html($j("#main").html().replace(/&amp;euro;/g,'€'));
			    
			});


			 function setContenidoCargando(text, fontSize){
				 $j("#contenidoCargando").html(text);
				 $("#contenidoCargando").css({'font-size' : fontSize + 'px' }); 
			 }
		</script>
	<s:action name="%{postScriptAction}"   executeResult="true"/>
	
<!-- SERVERCHECK OK -->