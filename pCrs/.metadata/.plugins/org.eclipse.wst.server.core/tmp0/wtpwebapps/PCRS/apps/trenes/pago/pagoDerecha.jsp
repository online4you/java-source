<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="area-contenido">
                        <h2 class="titulo1"><s:property value="getText('lang.trenes.confirmacion.datosViaje')"/>
							<span class="subtitulo3"><s:property value="getText('lang.trenes.confirmacion.consulteDatosViaje')"/></span>					
						</h2>
                        <div class="separador-lateral"></div>
                        <div class="agrupa-datos-1">
	                        <div class="subtitulo1">
								<s:property value="origenIdaDes" />--<s:property value="destinoIdaDes" />
							</div>
						</div>		                            
                        <div class="separador-lateral"></div>           
                        <div class="agrupa-datos-1">         
                            <div class="dato1"><s:property value="getText('lang.gen.ida')"/></div>
                            <div class="dato2"><s:property value="getText('lang.gen.calendario.salida')"/></div>
                            <div class="dato3"><s:property value="fechaIda"/></div>
                            <div class="dato4"><s:property value="getFormatedHour(horaSalidaIda)" /></div>                                                            
                        </div>                        
                        <div class="agrupa-datos-1">         
                            <div class="tren"></div>
                            <div class="dato2"><s:property value="getText('lang.gen.llegada')"/></div>
                            <div class="dato3"><s:property value="fechaLlegada(horaLlegadaIda,horaSalidaIda, fechaIda)"/></div>
                            <div class="dato4"><s:property value="getFormatedHour(horaLlegadaIda)" /></div> 
                        </div>
                        <div class="agrupa-datos-1">         
                            <div class="dato1"><s:property value="getText('lang.trenes.tarifa')"/></div>
                            <div class="dato2"><s:property value="getText(getTxtTarifaIda())"/></div>
                            <div class="dato3"><s:property value="getText('lang.trenes.clase')"/></div>
                            <div class="dato4"><s:property value="getText(getTxtClaseIda())" /></div>
                        </div>
                        <div class="agrupa-datos-1">         
                            <div class="dato1"><a id="condicionesIda" class="enlace-2" style="font-size:1em" href="javascript:cargarCondiciones('<s:property value="tarifaIda"/>');"><s:property value="getText('lang.gen.condiciones')" /></a></div>
                        </div>       
                        <s:if test="%{soloIda!='true'}">
	                        <div class="separador-lateral"></div>
	                        <div class="agrupa-datos-1">
		                        <div class="subtitulo1">
									<s:property value="origenVueltaDes" />--<s:property value="destinoVueltaDes" />
								</div>
							</div>
	                        <div class="separador-lateral"></div>           
	                        <div class="agrupa-datos-1">         
	                            <div class="dato1"><s:property value="getText('lang.gen.calendario.vuelta')"/></div>
	                            <div class="dato2"><s:property value="getText('lang.gen.calendario.salida')"/></div>
	                            <div class="dato3"><s:property value="fechaVuelta"/></div>
	                            <div class="dato4"><s:property value="getFormatedHour(horaSalidaVuelta)" /></div>                                                            
	                        </div>                        
	                        <div class="agrupa-datos-1">         
	                            <div class="tren"></div>
	                            <div class="dato2"><s:property value="getText('lang.gen.llegada')"/></div>
	                            <div class="dato3"><s:property value="fechaLlegada(horaLlegadaVuelta,horaSalidaVuelta, fechaVuelta)"/></div>
	                            <div class="dato4"><s:property value="getFormatedHour(horaLlegadaVuelta)" /></div> 
	                        </div>
	                        <div class="agrupa-datos-1">         
	                            <div class="dato1"><s:property value="getText('lang.trenes.tarifa')"/></div>
	                            <div class="dato2"><s:property value="getText(getTxtTarifaVuelta())"/></div>
	                            <div class="dato3"><s:property value="getText('lang.trenes.clase')"/></div>
	                            <div class="dato4"><s:property value="getText(getTxtClaseVuelta())" /></div>
	                        </div>
	                        <div class="agrupa-datos-1">         
	                            <div class="dato1"><a id="condicionesVuelta" class="enlace-2" style="font-size:1em" href="javascript:cargarCondiciones('<s:property value="tarifaVuelta"/>');"><s:property value="getText('lang.gen.condiciones')" /></a></div>
	                        </div>  
						</s:if>
						                                    
                        <div class="separador-lateral"></div>
                        					 
					</div> 
					<div class="area-contenido">                     
                        <h2 class="titulo2"><s:property value="getText('lang.trenes.confirmacion.importeCompra')"/>
							<span class="subtitulo3"><s:property value="getText('lang.trenes.confirmacion.consultaDesgloseCompra')"/></span>						
						</h2>
                        <div class="separador-lateral"></div>
                        <div class="agrupa-datos-1"> 
                            <div class="subtitulo1"><s:property value="getText('lang.trenes.confirmacion.precioMedio')"/></div>
                            <span class="dato5"><s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getPrecioMedioConDescuento()))" />&euro;</span>
						</div>
                        <div class="separador-lateral"></div>           
						<s:iterator var="adultos" value="reserva.getClientesAdultos()" status="adultosStat"  >
	                        <div class="agrupa-datos-1">                                            
	                            <div class="subtitulo2"><s:property value="trcApellido1+ ' ' + trcApellido2 + ', ' + trcNombre" /></div>
	                            <span class="dato7"><s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getPrecioPasajero(#adultos)))" />&euro;</span>
							</div>  
						</s:iterator>                          
						<s:iterator var="ninos" value="reserva.getClientesNinos()" status="adultosStat"  >
	                        <div class="agrupa-datos-1">                                            
	                            <div class="subtitulo2"><s:property value="trcApellido1+ ' ' + trcApellido2 + ', ' + trcNombre" /></div>
	                            <span class="dato7"><s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getPrecioPasajero(#ninos)))" />&euro;</span>
							</div>  
						</s:iterator>                          
                        
                        <div class="separador-lateral"></div>         
                        <div class="agrupa-datos-1">                                            
	                    	<div class="subtitulo2"><s:property value="getText('lang.trenes.pago.gastosGestion')" /></div>
	                        <span class="dato7"><s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getGastosDescuento()))" />&euro;</span>
						</div>                                           
                        <div class="agrupa-datos-1">                                            
	                    	<div class="subtitulo2"><s:property value="getText('lang.trenes.pago.descuento')" /></div>
	                        <span class="dato7">-<s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getDescuento()))" />&euro;</span>
						</div> 
                        <div class="separador-lateral"></div>
                        <div class="agrupa-datos-1">         
                            <div class="dato6"><s:property value="getText('lang.gen.total')"/></div>
                            <div  class="dato9">
                            <span id="importeTotalVal">
                            	<s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getPrecioTotal()))" />
                            </span>
                            &euro; 
                            <input id="importeTotal" type="hidden" value="<s:property value="twoDecimalFormat(roundTwoDecimals(reserva.getPrecioTotal()))" />"/>
                            <input id="paxesTotal" type="hidden" value="<s:property value="reserva.getBilletesIda().size()" />"/>
                            
                            </div>
                        </div>       
                        
					</div>