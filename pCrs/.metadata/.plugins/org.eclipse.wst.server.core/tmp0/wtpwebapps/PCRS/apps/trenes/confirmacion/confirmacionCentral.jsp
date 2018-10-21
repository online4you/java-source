<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
 <div class="caja-contenido">
                        <div class="cabecera">
							<h2 class="titulo1"><s:property value="getText('lang.trenes.confirmacion.confirmacionReserva')"/></h2>                                    
                        </div>                                
                        <div class="separador-contenido"></div>
                        <div class="area-contenido">
                        	<div class="agrupa-datos-15">
                        		<div class="encabezado-confirmacion">
                        			<div class="dato1"><s:property value="getText('lang.trenes.confirmacion.gracias')"/></div>
                        			<div class="dato2"><s:property value="getText('lang.trenes.confirmacion.reservaConfirmada')"/></div>									
                        		</div>
                        		<div class="dato1">
		                        	<p class="dato1-1"><s:property value="getText('lang.trenes.confirmacion.codigoReserva')"/>: <s:property value="getLocalizador()" /></p>
									
									<p class="dato1-2"><s:property value="getText('lang.trenes.confirmacion.observaciones')"/></p>
									<p class="dato1-3">
										<s:property value="getText('lang.trenes.confirmacion.observacionesDetalle')"/>
										<br>
										<s:property value="getText('lang.trenes.confirmacion.observacionesDetalle2')"/>
									</p>
									
									<p class="dato1-2"><s:property value="getText('lang.trenes.confirmacion.cambios')"/></p>
									<p class="dato1-3"><s:property value="getText('lang.trenes.confirmacion.cambiosDetalle')"/></p>

									<p class="dato1-2"><s:property value="getText('lang.trenes.confirmacion.equipaje')"/></p>
									<p class="dato1-3"><s:property value="getText('lang.trenes.confirmacion.equipajeDetalle')"/></p>

								</div>
								<div class="destacado-6">
		                        	<p class="dato1"><s:property value="getText('lang.trenes.confirmacion.textoClientesWeb')"/> <span class="dato1-1"><s:property value="getText('lang.gen.provisionalTelefonoCabecera')"/> </span>.</p>
								</div>								
							</div>								
                        </div>                        
                    </div>
                    <div class="caja-contenido-inferior"></div>             
					<div class="contenedor-boton-2" style="float:none;width:230px;margin:0 auto">
                        <div class="boton-1-izda"></div>
                            <button id="billetes" type="button" class="boton-1" style="font-size:1.5em;width:215px"><s:property value="getText('lang.gen.imprimirBilletes')"/></button>
                        <div class="boton-1-dcha"></div>                                        
                    </div>
					<!--  
					<div class="limpiar"></div>
					<div class="contenedor-boton-1">
	                    <button id="imprimir" type="button" class="boton-11"><s:property value="getText('lang.gen.imprimir')"/></button>
                    </div>	
                    -->					
<script>
$j('#imprimir').click(function(){window.print();});
$j('#billetes').click(function(){window.open('<s:property value="urlBillete"/>')});
</script>							