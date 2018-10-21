<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:set name="hayDispo" value="true"/>
<s:set name="disponibilidad" value="dispo"/>  

<s:if test="#disponibilidad==null">
		<s:set name="hayDispo" value="false"/>			
</s:if>
<s:elseif test="#disponibilidad.getPages(true).length==0">
	<s:set name="hayDispo" value="false"/>
</s:elseif>

<s:if test="#hayDispo==false ">
					
					<div class="contenido-superior">
						<span class="icono-seleccion"></span>
						<div class="bloque-1">
						<s:property value="getText('lang.trenes.disponibilidad.noDisponibilidad')"/>						
						</div>
					</div>		
</s:if>
<s:if test="!#disponibilidad.getPages(true).size>0">
	<div class="contenido-superior">
		<span class="icono-seleccion"></span>
		<div class="bloque-1">
		<s:property value="getText('lang.trenes.disponibilidad.noDisponibilidad')"/>						
		</div>
	</div>	
	<div class="zona-izda-1">
		<div class="zona-centrada-2">
			<s:property value="getText('lang.trenes.disponibilidad.NoHayResultadosFiltro')"/>		
		</div>
	</div>
	<div class="zona-izda-1">
		<div class="zona-centrada-3">
			<div class="boton-1-izda"></div>
				<button type="button" class="boton-8 noFiltrar"  onclick="javascript: removeFiltrado();"><s:property value="getText('lang.trenes.limpiar')"/></button>
			<div class="boton-1-dcha"></div>
		</div>
	</div>
</s:if>
<s:if test="#disponibilidad!=null && #disponibilidad.getPages(true).size>0">
			<s:set name="hayDispo" value="false"/>
			<s:set name="paginas" value="#disponibilidad.getPages(true)"/>
			<s:set name="primero" value="#paginas[0][0]"/>
						<div class="contenido-superior">
						<span class="icono-seleccion"></span>
						<div class="bloque-1">
						<s:property value="getText('lang.trenes.disponibilidad.seleccionaHorario')"/><br>
							<span class="dato1" id="numItemsFiltro"><s:property value="#disponibilidad.agrup.size"/></span>
							<span class="dato2"><s:property value="getText('lang.trenes.disponibilidad.combinacionesEncontradas')"/></span>							
						</div>
					</div>
                    <div class="caja-contenido">
						<div class="cabecera">
                            <p class="subtitulo8"><s:property value="getText('lang.trenes.disponibilidad.textoOpcionEconomica')"/></p>
						</div>           
                
						<s:form id="pasajeros" action="Pasajeros">
									<div class="area-contenido-2">
											<s:iterator var="page" value="#primero" status="pageStat">                           
											<s:if test="#pageStat.index>=0">
												<div id="masBarato" style="display:block">
											<s:iterator var="agrup" value="#page" status="agrupStat"> 
														<s:if test="#disponibilidad.mostrarAgrup(#agrup)">
														<div id="positionReference_<s:property value="#agrup.replace('.','-')" />" >
														<s:iterator var="idaVuelta" value="{0,1}"  status="idaVueltaStat"  >
															<s:if test="resetIdaVuelta(#idaVueltaStat.index)"></s:if>
															<s:iterator var="viaje" value="#disponibilidad.agrup.get(#agrup).get(#idaVueltaStat.index)" status="viajeStat"  >
															 <s:set name="fechaIda" value="getFechaIda()"/>
															 <s:set name="fechaVuelta" value="getFechaVuelta()"/>
															 
															 <s:if test="#idaVueltaStat.index==0">
															 	<s:iterator var="viajeClases" value="precio.getPreciosAgurpados().get(#agrup)" status="idaClasesStat"  >
															 				<s:if test="mostrar(#viaje,#viajeClases,#agrup)">
															 				<s:set name="precio" value="getPrecio().getMasBaratoPorClase(#viajeClases,false).getPrecio()"/>
															 				<div class="agrupa-datos-12 no-separa">
																				 		<s:set name="hayDispo" value="true"/>
																						<s:if test="isImgIdaVuelta()==true">
																							<div class="dato1 bloque-9">
																								<div class="dato1-1">
																									<s:property value="getText('lang.trenes.reserva.ida')"/>
																								</div>
																							</div>
																						</s:if>
																						<s:else>
																							<div class="dato1 ">
																								<div class="dato1-1">
																								&nbsp;
																								</div>
																							</div>																
																						</s:else>
																		
																						<div class="dato2 doble">
																							<div class="dato2-1">
																								<div class="dato2-1-1">
																								<input type="radio" ser="bloque-9" rec="1" ow="false" value="0" class="radioVuelo" id="radioIda" name="radioIda" onClick="javascript: setIda(this,'<s:property value="#viaje.horaSalida"/>','<s:property value="#viaje.horaLlegada"/>','<s:property value="#viaje.origenId"/>', '<s:property value="#viaje.destinoId"/>','<s:property value="#viaje.origen"/>', '<s:property value="#viaje.destino"/>','<s:property value="#viaje.tren"/>','<s:property value="#viajeClases"/>','<s:property value="getPrecio().getMasBaratoPorClase(#viajeClases,false).getTarifa()"/>', '<s:property value="getPrecio().getMasBaratoPorClase(#viajeClases,false).getPrecio()"/>','<s:property value="#agrup"/>','<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaIda)" />')">
																								
																								</div>
																								<div class="dato2-1-2"><span class="info-adicional"><s:property value="getTraducionDiaSemana(#fechaIda)" /><br> <s:property value="#fechaIda" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaSalida)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.origenId)" />','<s:property value="#viaje.origen" />');" title="<s:property value="#viaje.origenId" />"><s:property value="#viaje.origen" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaLlegada)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.destinoId)" />','<s:property value="#viaje.destino" />');" title="<s:property value="#viaje.destinoId" />"><s:property value="#viaje.destino" /></span></div>
																								<div class="dato2-1-4">
																									<div>
																										<img width="66" height="24"  class="img1" alt="RENFE (RF)" title="" src="<s:property value="getContextPath()"/>/static/main/images/common1024/logoscias/logo_RF.png">
																									</div>
																									<div>
																										<span title="<s:property value="#viaje.tren" />"><s:property value="#viaje.tipoTren" /></span>
																									</div>
																								</div>
																								<div class="dato2-1-5"> <s:property value="getTraducionFromParams(#viajeClases)" />
																									<s:property value="getDuracionHoras(#viaje.horaSalida,#viaje.horaLlegada,#fechaIda)" />h.&nbsp;<s:property value="getDuracionMinutos(#viaje.horaSalida,#viaje.horaLlegada,#fechaIda)" />Min.
																								</div>
																								<div class="dato2-1-6">
																								<s:property value="showPlazas(getPrecio().getMasBaratoPorClase(#viajeClases,false).getCupo())"/>
																								</div>
																								<a title="" class="icono-info-4 masInfo" href="javascript: muestraMasInfoTren(
																								'positionReference_<s:property value="#agrup.replace('.','-')" />',
																								true,
																								'<s:property value="#viaje.tipoTren + '&nbsp;' + #viaje.tren" />',
																								'<s:property value="getText(\"lang.trenes.renfe\")" />',
																								'<s:property value="getFormatedHour(#viaje.horaSalida)" />',
																								'<s:property value="getFormatedHour(#viaje.horaLlegada)" />',
																								'<s:property value="#fechaVuelta" />',
																								'<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaVuelta)" />',
																								'<s:property value="#viaje.origen" />',
																								'<s:property value="#viaje.destino" />',
																								'<s:property value="#precio" />');"></a>
																							</div>
																						</div>
													
																				</div>
																				</s:if>
															 	</s:iterator>
															 </s:if>
															 <s:else>
															 	<s:iterator var="viajeClases" value="#disponibilidad.getPreciosVueltas(#agrup,#viaje.getPrecio().getPreciosAgurpados().get(#agrup),#disponibilidad.getAgrup().get(#agrup).get(0),#viaje.getPrecio())" status="viajeClasesStat"  >
															 				<s:if test="mostrar(#viaje,getClase(),#agrup)">
															 				<s:set name="precio" value="#disponibilidad.getPrecioVueltaDouble(#viajeClases)"/>
															 				<div class="agrupa-datos-12 no-separa" id="vuelta__<s:property value="getIdVuelta(#agrup,#viajeClases,#viajeStat.index,#viajeClasesStat.index, #viaje.horaSalida)"/>">
																						<s:if test="isImgIdaVuelta()==true">
																					
																							<div class="dato1 bloque-9">
																								<div class="dato1-1">
																									<s:property value="getText('lang.trenes.reserva.vuelta')"/>
																								</div>
																							</div>
																						</s:if>
																						<s:else>
																							<div class="dato1">
																								<div class="dato1-1">
																								&nbsp;
																								</div>
																							</div>																
																						</s:else>
																					
																						<div class="dato2 doble">
																							<div class="dato2-1">
																								<div class="dato2-1-1">
																								<input type="radio" ser="bloque-9" rec="1" ow="false" value="0" class="radioVuelo" id="radioVuelta" name="radioVuelta" 
																								onClick="javascript: setVuelta('<s:property value="#viaje.horaSalida"/>','<s:property value="#viaje.horaLlegada"/>','<s:property value="#viaje.origenId"/>', '<s:property value="#viaje.destinoId"/>','<s:property value="#viaje.origen"/>', '<s:property value="#viaje.destino"/>','<s:property value="#viaje.tren"/>','<s:property value="getClase()"/>','<s:property value="getTarifa()"/>', '<s:property value="#disponibilidad.getPrecioVueltaDouble(#viajeClases)"/>','<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaVuelta)" />','<s:property value="#agrup"/>')"/>
																								
																								</div>
																								<div class="dato2-1-2"><span class="info-adicional"><s:property value="getTraducionDiaSemana(#fechaVuelta)" /><br> <s:property value="#fechaVuelta" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaSalida)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.origenId)" />','<s:property value="#viaje.origen" />');" title="<s:property value="#viaje.origenId" />"><s:property value="#viaje.origen" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaLlegada)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.destinoId)" />','<s:property value="#viaje.destino" />');" title="<s:property value="#viaje.destinoId" />"><s:property value="#viaje.destino" /></span></div>
																								<div class="dato2-1-4">
																									<div>
																										<img width="66" height="24"  class="img1" alt="RENFE (RF)" title="" src="<s:property value="getContextPath()"/>/static/main/images/common1024/logoscias/logo_RF.png">
																									</div>
																									<div>
																										<span title="<s:property value="#viaje.tren" />"><s:property value="#viaje.tipoTren" /></span>
																									</div>
																								</div>
																								<div class="dato2-1-5"> <s:property value="getTraducionFromParams(getClase())" />
																									<s:property value="getDuracionHoras(#viaje.horaSalida,#viaje.horaLlegada,#fechaVuelta)" />h.&nbsp;<s:property value="getDuracionMinutos(#viaje.horaSalida,#viaje.horaLlegada,#fechaVuelta)" />Min.
																								</div>
																								<div class="dato2-1-6" tile="<s:property value="#precio" />">
																									<s:property value="showPlazas(getCupo())"/>
																								
																								</div>
																								<a title="" class="icono-info-4 masInfo" href="javascript: muestraMasInfoTren(
																								'positionReference_<s:property value="#agrup.replace('.','-')" />',
																								false,
																								'<s:property value="#viaje.tipoTren + '&nbsp;' + #viaje.tren" />',
																								'<s:property value="getText(\"lang.trenes.renfe\")" />',
																								'<s:property value="getFormatedHour(#viaje.horaSalida)" />',
																								'<s:property value="getFormatedHour(#viaje.horaLlegada)" />',
																								'<s:property value="#fechaVuelta" />',
																								'<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaVuelta)" />',
																								'<s:property value="#viaje.origen" />',
																								'<s:property value="#viaje.destino" />',
																								'<s:property value="#precio" />');"></a>
																							</div>
																						</div>
													
																				</div>
																				</s:if>
															 	</s:iterator>
															 </s:else>
														</s:iterator>	
															<div class="separador-2"></div>
														</s:iterator>	
														<div class="pie-contenido">
														<div class="dato1">
															<p><s:property value="getText('lang.trenes.disponibilidad.textoPrecioMedioTI')"/></p>
														</div>
														<div class="dato2">
															<div class="dato2-2">
																<p>
																	<span class="dato2-2-1"><s:property value="getTotal(#agrup)" /></span>
																	<span class="dato2-1-1">&euro;</span>
																</p>
															</div>
															<button  type="button" title="" class="boton-5 verDesglose" id="botonVerPrecio__<s:property value="#agrup" />" type="button" onclick="javascript: muestraDesglose('positionReference_<s:property value="#agrup.replace('.','-')" />', '<s:property value="#agrup" />')"><s:property value="getText('lang.trenes.disponibilidad.verDesglose')"/></button>
														</div>
														<div class="contenedor-boton-2">
															<div class="boton-1-izda"></div>
																<button type="button" class="boton-1 seleccionarVuelo" id="seleccionar-0-0" onclick="javascript: submitForm();"><s:property value="getText('lang.trenes.seleccionar')"/></button>
															<div class="boton-1-dcha"></div>
														</div>
													</div>
													</div>
													</s:if>
											</s:iterator>	
										</div>
										</s:if>
									</s:iterator>
								</div>
							
					<s:if test="#disponibilidad.agrup.size>1">
                         <div class="cabecera4">
								<div class="subtitulo11"><s:property value="getText('lang.trenes.disponibilidad.otrosTrayectos')" /> <span>(<s:property value="getText('lang.trenes.disponibilidad.ordenadosPrecio')" />)</span></div>
								<div class="limpiar"></div>
								<div class="caja flota-izq" style="font-size:1em;width:319px">	
									<div class="destacado-12 flota-izq" style="padding:5px 10px 12px 10px">
										<label for="hora-ida" class="etiqueta-9"><p class="dato-1 flota-izq" style="padding:2px 0"><s:property value="getText('lang.trenes.reserva.eligeHoraSalida')" />&nbsp;&nbsp;</p>
										<s:select label="hora-ida" 
										list="listaHorasIda" 
										name="filtroHoraIda" 
										id="filtroHoraIdaMain"
										listKey="key" listValue="value + ' &euro;'"
										headerKey="-1" headerValue="%{getText('lang.trenes.reserva.todosLosHorarios')}"
										onchange="javascript: filtradoHoraIda('filtroHoraIdaMain');"/>	


										</label>
									</div>
								</div>

								<!-- Aqui empieza la paginacion -->
									<div  id="paginacion1" style="position:relative">
										<div id="ocultaPag1" class="ocultaPaginacion"></div>
										<div id="paginacionDiv"></div>
										
									</div>
								<!-- Aqui termina la paginacion -->
							</div>
 
								<div id="pagina_0" class="area-contenido-2">
									<s:set name="disponibilidad" value="dispo"/>
									<s:set name="paginas" value="#disponibilidad.getPages(true)"/>
									
									<s:if test="#paginas[0][0]==#primero">
										<s:set name="paginas" value="#disponibilidad.getPages(false)"/>
									</s:if>
									<s:iterator var="page" value="#paginas" status="pageStat"> 
											<s:if test="#pageStat.index==#disponibilidad.getPaginaActual()">
											<s:if test="#pageStat.index==0">
												<div id="dispoPage_<s:property value="#pageStat.index" />" style="display:block">
											</s:if>
											<s:else>
												<div id="dispoPage_<s:property value="#pageStat.index" />" style="display:none">
											</s:else>
											<s:iterator var="agrup" value="#page" status="agrupStat"> 
														<s:if test="#disponibilidad.mostrarAgrup(#agrup) && #agrup!=null">
														<div id="positionReference_<s:property value="#agrup.replace('.','-')" />" >
														<s:iterator var="idaVuelta" value="{0,1}"  status="idaVueltaStat"  >
															<s:if test="resetIdaVuelta(#idaVueltaStat.index)"></s:if>
															
															
															<s:iterator var="viaje" value="#disponibilidad.agrup.get(#agrup).get(#idaVueltaStat.index)" status="viajeStat"  >
															 <s:set name="fechaIda" value="getFechaIda()"/>
															 <s:set name="fechaVuelta" value="getFechaVuelta()"/>
															 <s:if test="#idaVueltaStat.index==0">
															 	<s:iterator var="viajeClases" value="precio.getPreciosAgurpados().get(#agrup)" status="idaClasesStat"  >
															 				<s:if test="mostrar(#viaje,#viajeClases,#agrup)">
															 				<s:set name="precio" value="getPrecio().getMasBaratoPorClase(#viajeClases,false).getPrecio()"/>
															 				<div class="agrupa-datos-12 no-separa">
																						<s:if test="isImgIdaVuelta()==true">
																							
																							<div class="dato1 bloque-9">
																								<div class="dato1-1">
																									<s:property value="getText('lang.trenes.reserva.ida')" />
																								</div>
																							</div>
																						</s:if>
																						<s:else>
																							<div class="dato1">
																								<div class="dato1-1">
																								&nbsp;
																								</div>
																							</div>																
																						</s:else>
																					
																						<div class="dato2 doble">
																							<div class="dato2-1">
																								<div class="dato2-1-1">
																								<input type="radio" ser="bloque-9" rec="1" ow="false" value="0" class="radioVuelo" id="radioIda" name="radioIda" onClick="javascript: setIda(this,'<s:property value="#viaje.horaSalida"/>','<s:property value="#viaje.horaLlegada"/>','<s:property value="#viaje.origenId"/>', '<s:property value="#viaje.destinoId"/>','<s:property value="#viaje.origen"/>', '<s:property value="#viaje.destino"/>','<s:property value="#viaje.tren"/>','<s:property value="#viajeClases"/>','<s:property value="getPrecio().getMasBaratoPorClase(#viajeClases,false).getTarifa()"/>', '<s:property value="getPrecio().getMasBaratoPorClase(#viajeClases,false).getPrecio()"/>','<s:property value="#agrup"/>','<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaIda)" />')">
																								
																								</div>
																								<div class="dato2-1-2"><span class="info-adicional"><s:property value="getTraducionDiaSemana(#fechaIda)" /><br> <s:property value="#fechaIda" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaSalida)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.origenId)" />','<s:property value="#viaje.origen" />');" title="<s:property value="#viaje.origenId" />"><s:property value="#viaje.origen" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaLlegada)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.destinoId)" />','<s:property value="#viaje.destino" />');" title="<s:property value="#viaje.destinoId" />"><s:property value="#viaje.destino" /></span></div>
																								<div class="dato2-1-4">
																									<div>
																										<img width="66" height="24"  class="img1" alt="RENFE (RF)" title="" src="<s:property value="getContextPath()"/>/static/main/images/common1024/logoscias/logo_RF.png">
																									</div>
																									<div>
																										<span title="<s:property value="#viaje.tren" />"><s:property value="#viaje.tipoTren" /></span>
																									</div>
																								</div>
																								<div class="dato2-1-5"> <s:property value="getTraducionFromParams(#viajeClases)" />
																									<s:property value="getDuracionHoras(#viaje.horaSalida,#viaje.horaLlegada,#fechaIda)" />h.&nbsp;<s:property value="getDuracionMinutos(#viaje.horaSalida,#viaje.horaLlegada,#fechaIda)" />Min.
																								</div>
																								<div class="dato2-1-6">
																								<s:property value="showPlazas(getPrecio().getMasBaratoPorClase(#viajeClases,false).getCupo())"/>
																								</div>
																								<a title="" class="icono-info-4 masInfo" href="javascript: muestraMasInfoTren(
																								'positionReference_<s:property value="#agrup.replace('.','-')" />',
																								true,
																								'<s:property value="#viaje.tipoTren + '&nbsp;' + #viaje.tren" />',
																								'<s:property value="getText(\"lang.trenes.renfe\")" />',
																								'<s:property value="getFormatedHour(#viaje.horaSalida)" />',
																								'<s:property value="getFormatedHour(#viaje.horaLlegada)" />',
																								'<s:property value="#fechaVuelta" />',
																								'<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaVuelta)" />',
																								'<s:property value="#viaje.origen" />',
																								'<s:property value="#viaje.destino" />',
																								'<s:property value="#precio" />');"></a>
																							</div>
																						</div>
													
																				</div>
																				</s:if>
															 	</s:iterator>
															 </s:if>
															 <s:else>
															 
															 	<s:iterator var="viajeClases" value="#disponibilidad.getPreciosVueltas(#agrup,#viaje.getPrecio().getPreciosAgurpados().get(#agrup),#disponibilidad.getAgrup().get(#agrup).get(0),#viaje.getPrecio())" status="viajeClasesStat"  >
															 				<s:if test="mostrar(#viaje,getClase(),#agrup)">
															 				<s:set name="precio" value="#disponibilidad.getPrecioVueltaDouble(#viajeClases)"/>
															 				<div class="agrupa-datos-12 no-separa" id="vuelta__<s:property value="getIdVuelta(#agrup,#viajeClases,#viajeStat.index,#viajeClasesStat.index, #viaje.horaSalida)"/>">
																						<s:property value="#imgIdaVuelta" />
																						<s:if test="isImgIdaVuelta()">
																							<div class="dato1 bloque-9">
																								<div class="dato1-1">
																									<s:property value="getText('lang.trenes.reserva.vuelta')" />
																								</div>
																							</div>
																						</s:if>
																						<s:else>
																							<div class="dato1 ">
																								<div class="dato1-1">
																								&nbsp;
																								</div>
																							</div>																
																						</s:else>
																						
																						<s:property value="#imgIdaVuelta" />
																						<div class="dato2 doble">
																							<div class="dato2-1">
																								<div class="dato2-1-1">
																								<input type="radio" ser="bloque-9" rec="1" ow="false" value="0" class="radioVuelo" id="radioVuelta" name="radioVuelta" onClick="javascript: setVuelta('<s:property value="#viaje.horaSalida"/>','<s:property value="#viaje.horaLlegada"/>','<s:property value="#viaje.origenId"/>', '<s:property value="#viaje.destinoId"/>','<s:property value="#viaje.origen"/>', '<s:property value="#viaje.destino"/>','<s:property value="#viaje.tren"/>','<s:property value="getClase()"/>','<s:property value="getTarifa()"/>', '<s:property value="#disponibilidad.getPrecioVueltaDouble(#viajeClases)"/>','<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaVuelta)" />','<s:property value="#agrup"/>')"/>
																								</div>
																								<div class="dato2-1-2"><span class="info-adicional"><s:property value="getTraducionDiaSemana(#fechaVuelta)" /><br> <s:property value="#fechaVuelta" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaSalida)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.origenId)" />','<s:property value="#viaje.origen" />');" title="<s:property value="#viaje.origenId" />"><s:property value="#viaje.origen" /></span></div>
																								<div class="dato2-1-3"><strong><s:property value="getFormatedHour(#viaje.horaLlegada)" /></strong><br><span style="cursor:pointer" onclick="javascript:openMap('<s:property value="getMap(#viaje.destinoId)" />','<s:property value="#viaje.destino" />');" title="<s:property value="#viaje.destinoId" />"><s:property value="#viaje.destino" /></span></div>
																								<div class="dato2-1-4">
																									<div>
																										<img width="66" height="24"  class="img1" alt="RENFE (RF)" title="" src="<s:property value="getContextPath()"/>/static/main/images/common1024/logoscias/logo_RF.png">
																									</div>
																									<div>
																										<span title="<s:property value="#viaje.tren" />"><s:property value="#viaje.tipoTren" /></span>
																									</div>
																								</div>
																								<div class="dato2-1-5"> <s:property value="getTraducionFromParams(getClase())" />
																									<s:property value="getDuracionHoras(#viaje.horaSalida,#viaje.horaLlegada,#fechaVuelta)" />h.&nbsp;<s:property value="getDuracionMinutos(#viaje.horaSalida,#viaje.horaLlegada,#fechaVuelta)" />Min.
																								</div>
																								<div class="dato2-1-6" tile="<s:property value="#precio" />">
																								<s:property value="showPlazas(getCupo())"/>
																								
																								</div>
																								<a title="" class="icono-info-4 masInfo" href="javascript: muestraMasInfoTren(
																								'positionReference_<s:property value="#agrup.replace('.','-')" />',
																								false,
																								'<s:property value="#viaje.tipoTren + '&nbsp;' + #viaje.tren" />',
																								'<s:property value="getText(\"lang.trenes.renfe\")" />',
																								'<s:property value="getFormatedHour(#viaje.horaSalida)" />',
																								'<s:property value="getFormatedHour(#viaje.horaLlegada)" />',
																								'<s:property value="#fechaVuelta" />',
																								'<s:property value="fechaLlegada(#viaje.horaLlegada,#viaje.horaSalida,#fechaVuelta)" />',
																								'<s:property value="#viaje.origen" />',
																								'<s:property value="#viaje.destino" />',
																								'<s:property value="#precio" />');"></a>
																							</div>
																						</div>
													
																				</div>
																				</s:if>
																				
															 	</s:iterator>
															 </s:else>
														</s:iterator>	
															<div class="separador-2"></div>
														</s:iterator>	
														<div class="pie-contenido">
														<div class="dato1">
															<p><s:property value="getText('lang.trenes.disponibilidad.textoPrecioMedioTI')" /></p>
														</div>
														<div class="dato2">
															<div class="dato2-2">
																<p>
																	<span class="dato2-2-1"><s:property value="getTotal(#agrup)" /></span>
																	<span class="dato2-1-1">&euro;</span>
																</p>
															</div>
															<button  type="button" title="" class="boton-5 verDesglose" id="botonVerPrecio__<s:property value="#agrup" />" type="button" onclick="javascript: muestraDesglose('positionReference_<s:property value="#agrup.replace('.','-')" />', '<s:property value="#agrup" />')"><s:property value="getText('lang.trenes.disponibilidad.verDesglose')" /></button>
														</div>
														<div class="contenedor-boton-2">
															<div class="boton-1-izda"></div>
															<button  type="button" class="boton-1 seleccionarVuelo" id="seleccionar-0-0" onclick="javascript: submitForm();"><s:property value="getText('lang.trenes.seleccionar')" /></button>
															<div class="boton-1-dcha"></div>
														</div>
													</div>
													</div>
													</s:if>
											</s:iterator>	
										</div>
										</s:if>
									</s:iterator>
								</div>
								<div id="MasPaginas"></div>
					</s:if>
								<!-- Aqui empieza la paginacion -->
									<div  id="paginacion12" class="paginacionInferior"   style="position:relative">
										<div id="ocultaPag2" class="ocultaPaginacion"></div>
										<div id="paginacionDiv2"></div>
										
									</div>
								<!-- Aqui termina la paginacion -->
							<div class="limpiar"></div>	
							<div id="datos" style="display:none;">
							<s:textfield name="fechaIda" value="%{getFechaIda()}"/>
							<s:textfield name="origenIda" />
							<s:textfield name="destinoIda" />
							<s:textfield name="origenIdaDes" />
							<s:textfield name="destinoIdaDes" />
							<s:textfield name="trenIda" />
							<s:textfield name="claseIda" />
							<s:textfield name="tarifaIda" />
							<s:textfield name="precioIda" />
							<s:textfield name="horaSalidaIda" />
							<s:textfield name="horaLlegadaIda" />
						
							<s:textfield name="precioTotal" />
							
							<s:textfield name="fechaVuelta" value="%{getFechaVuelta()}"/>
							<s:textfield name="origenVuelta" />
							<s:textfield name="destinoVuelta" />
							<s:textfield name="origenVueltaDes" />
							<s:textfield name="destinoVueltaDes" />
							<s:textfield name="tarifaVuelta" />
							<s:textfield name="trenVuelta" />
							<s:textfield name="claseVuelta" />
							<s:textfield name="precioVuelta" />
							<s:textfield name="horaSalidaVuelta" />
							<s:textfield name="horaLlegadaVuelta" />
							
							<s:textfield name="soloIda" />
							<s:textfield name="adultosKey" />
							<s:textfield name="ninosKey" />
							</div>
						</s:form> 
		
                    </div> 
                    <div class="caja-contenido-inferior">
                    	<div class="contenedor-boton-1" style="margin-top:10px">
							<div class="boton-1-izda" ></div>
								<button class="boton-1" type="button" id="volver"><s:property value="getText('lang.gen.volver')"/> </button>
								<div class="boton-1-dcha"></div>
							</div>
                    </div>     
</s:if>

<div id="fadeInicial" class="sombraInicio" style="display:block;"></div>
<div id="fade" class="sombra" style="display:none;"></div>
<div id="capaMasInfo" class="capa-flotante capa-flotante-1 contenido-box" style="display:none;position:absolute;"></div>
<script type="text/javascript">
$j().number_format({
    numberOfDecimals:2,
    decimalSeparator: '.',
    thousandSeparator: ','
}); 
function setContenidoCargandoFiltro(){
	var contenidoCargando;
	contenidoCargando='<s:property value="getText('lang.gen.pantallaCarga.aplicandoFiltro')"/>';	
	setContenidoCargando(contenidoCargando,20);
}
function getFiltrado(){
	doFiltrado('removeFiltro=0&pagina=0','capaCargandoV2');			
}
function removeFiltrado(){
	doFiltrado('removeFiltro=-1&pagina=0','capaCargandoV2');		
}
function doFiltrado(params,capaCargando){
	setContenidoCargandoFiltro();
	$j('#cargandoFiltro').center();
	showCargando(capaCargando);
	$j('#removeFiltro').val('0');
	$j.post('DisponibilidadRenfe.html',$j('#formBuscador').serialize()+'&'+$j('#formBuscadorFiltro').serialize()+'&'+params , function(data) {
		if (data!=''){
		  $j('#zona-izda').html(data);
		  hideCargando(capaCargando);
		}else{
			hideCargando(capaCargando);
			}
		});
			
}


</script>
<script type="text/javascript">
var formBuscador='formBuscador';
var formDispo='pasajeros';
//mostrarCargandoNuevoV2(1,1000,'NEW');
$j("#volver").click(function(){
	history.go(-1);
});

function submitForm(){
	if (!checkDatos()){
		confirm('<s:property value="getText(\"lang.trenes.reserva.datosIncorrectos\")"/>');
		return false;
	}
	
	$j('#pasajeros_adultosKey').val($j('#formBuscador_adultosKey').val());
	$j('#pasajeros_ninosKey').val($j('#formBuscador_ninosKey').val());

	var contenidoCargando;
	contenidoCargando='<s:property value="getText('lang.gen.pantallaCarga.Seleccion')"/>';	
	setContenidoCargando(contenidoCargando);
	showCargando('capaCargandoV2');
	$j('#'+formDispo).submit();
}
//CORREGIT 20120413 EDUARD
function getDescuento(precioTotal){
	var descuentos=new Array();
	<s:iterator var="aparente" value="getDescuentoAparente()" status="aparenteStat">
	descuentos['<s:property value="key"/>']='-<s:property value="value"/>';</s:iterator>
	var retorno=(descuentos[precioTotal])?descuentos[precioTotal]:0;
	return retorno;//descuentos[precioTotal];   
}
function getDescuentoViaje(precioTotal){
	var retorno=getDescuento(precioTotal)==0?0:getDescuento(precioTotal)/2;
	return retorno;
}
//

function setIda(obj,horaSalida,horaLLegada,origen, destino,origenDes, destinoDes,trenIda,claseIda,tarifaIda, precioIda,precioTotal,fechaV){
	var feeTotal=getDescuento(precioTotal);
	var feeViaje=getDescuentoViaje(precioTotal);
	
	feeViaje=feeViaje/1;
	feeTotal=feeTotal/1;
	
	$j('#'+formDispo+'_trenIda').val(trenIda);
	$j('#'+formDispo+'_claseIda').val(claseIda);
	$j('#'+formDispo+'_origenIda').val(origen);
	$j('#'+formDispo+'_destinoIda').val(destino);
	$j('#'+formDispo+'_origenIdaDes').val(origenDes);
	$j('#'+formDispo+'_destinoIdaDes').val(destinoDes);
	$j('#'+formDispo+'_precioIda').val((precioIda/1)+feeViaje);
	$j('#'+formDispo+'_precioTotal').val(precioTotal);
	$j('#'+formDispo+'_tarifaIda').val(tarifaIda);
	$j('#'+formDispo+'_horaSalidaIda').val(horaSalida);
	$j('#'+formDispo+'_horaLlegadaIda').val(horaLLegada);
	$j('#'+formDispo+'_adultosKey').val($j('#'+formBuscador+'_adultosKey').val());
	$j('#'+formDispo+'_ninosKey').val($j('#'+formBuscador+'_ninosKey').val());
	//reset
	$("input:radio").attr("checked", false);
	$j('#'+formDispo+'_trenVuelta').val('');
	$j('#'+formDispo+'_claseVuelta').val('');
	$j('#'+formDispo+'_precioVuelta').val('');
	$j('#'+formDispo+'_tarifaVuelta').val('');
	$j('#'+formDispo+'_origenVuelta').val('');
	$j('#'+formDispo+'_destinoVuelta').val('');
	$j('#'+formDispo+'_origenVueltaDes').val('');
	$j('#'+formDispo+'_destinoVueltaDes').val('');
	$j('#'+formDispo+'_horaSalidaVuelta').val('');
	$j('#'+formDispo+'_horaLlegadaVuelta').val('');

	vueltasIterator(precioIda,precioTotal);
	if('<s:property value="soloIda"/>'!='true' && ('<s:property value="fechaIda"/>'=='<s:property value="fechaVuelta"/>' || '<s:property value="fechaVuelta"/>'==fechaV)){
		fechaIda='<s:property value="#fechaIda"/>';
		if ('<s:property value="fechaVuelta"/>'==fechaV){
			fechaIda=fechaV;
		}
		vueltasIteratorHoraVuelta(horaLLegada,fechaV,precioTotal,fechaIda);
	}
	
	obj.checked=true;
}
function vueltasIteratorHoraVuelta(horaLLegada,fechaV,precioTotal,fechaI){
	var numVueltas=0;
	$j('div').each(function(n) { 
		var precioVuelta;
		var pIda;
		var pT;
		var precio;
		var precioT;
		var values;
		var salida;
		var llegada;
		var fIda = fechaI;
		var fechaIda = new Date(fIda.split('/')[2],fIda.split('/')[1],fIda.split('/')[0]);
		var fechaVuelta= new Date(fechaV.split('/')[2],fechaV.split('/')[1],fechaV.split('/')[0]);
		var margen='<s:property value="getTiempoMinutosEntreLlegadaTrenSalidaVuelta()"/>';
		if (margen==''){margen=0}
		margen=margen/1;
		
		var idIs;
		if (this.id.indexOf("vuelta")!=-1){
			if (this.id.indexOf("vuelta__"+(precioTotal.replace('.','-')))!=-1){
				values=this.id.split("__");
				salida=values[5];
				
				salida=(salida.substring(0,2)*60)+(salida.substring(2,4)/1);
				llegada=(horaLLegada.substring(0,2)*60)+(horaLLegada.substring(2,4)/1);
				
				llegada+=margen;
				//alert(llegada +' - '+ salida);
				idIs='#'+this.id;
				if (llegada>salida || fechaVuelta>fechaIda){
					$j(idIs).hide();
					$j(idIs).children(':radio').attr('checked', false); }
				else{
					$j(idIs).show();
					if (numVueltas==0){
						$j(idIs).children(':first-child').addClass("bloque-9");
						$j(idIs).children(':first-child').html('<s:property value="getText('lang.trenes.reserva.vuelta')"/>');
					} else{
						$j(idIs).children(':first-child').removeClass("bloque-9");
						$j(idIs).children(':first-child').html('&nbsp;');
					}
					numVueltas++;}
				
				} 
			}
		}
	
	);
		if (numVueltas==0 && '<s:property value="soloIda"/>'!='true'){
			confirm('<s:property value="getText('lang.trenes.reserva.vueltasNoDisponibles')"/>');
			$j('.agrupa-datos-12').show();
			resetRadios(precioTotal);
		}
	}

function setVuelta(horaSalida,horaLLegada,origen, destino,origenDes, destinoDes,trenVuelta,claseVuelta,tarifaVuelta, precioVuelta, fechaVuelta, precioTotal){
	
	var feeTotal=getDescuento(precioTotal);
	var feeViaje=getDescuentoViaje(precioTotal);
	feeViaje=feeViaje/1;
	feeTotal=feeTotal/1;
	$j('#'+formDispo+'_trenVuelta').val(trenVuelta);
	$j('#'+formDispo+'_claseVuelta').val(claseVuelta);
	$j('#'+formDispo+'_precioVuelta').val((precioVuelta/1)+feeViaje);
	$j('#'+formDispo+'_tarifaVuelta').val(tarifaVuelta);
	$j('#'+formDispo+'_origenVuelta').val(origen);
	$j('#'+formDispo+'_destinoVuelta').val(destino);
	$j('#'+formDispo+'_origenVueltaDes').val(origenDes);
	$j('#'+formDispo+'_destinoVueltaDes').val(destinoDes);
	$j('#'+formDispo+'_horaSalidaVuelta').val(horaSalida);
	$j('#'+formDispo+'_horaLlegadaVuelta').val(horaLLegada);
	
}
function clearRadioVuelta(){
 	
	$j('radiobutton').each(function(n) { 
		if (this.id.indexOf("radioVuelta")!=-1){
			$(this).attr('checked', false);  
			}
		}
	);
	}
function vueltasIterator(precioIda,precioTotal){
	var numVueltas=0;
	$j('div').each(function(n) { 
		var precioVuelta;
		var pIda;
		var pT;
		var precio;
		var precioT;
		var values;

		if (this.id.indexOf("vuelta")!=-1){
			if (this.id.indexOf("vuelta__"+(precioTotal.replace('.','-')))!=-1){
				values=this.id.split("__");
				precioVuelta=values[2].replace('-','.');
				pIda=precioIda;
				pT=precioTotal;
				precio=(pIda/1.0)+(precioVuelta/1.0);
				precio=(precio+"").split(".")[0];
				precioT=pT.split(".")[0];
				var idIs='#'+this.id;
				//alert (idIs);
				if (precio!=precioT){
					$j(idIs).hide();
					$j(idIs).children(':radio').attr('checked', false);}
				else{
					$j(idIs).show();
					if (numVueltas==0){
						$j(idIs).children(':first-child').addClass("bloque-9");
						$j(idIs).children(':first-child').html('<s:property value="getText('lang.trenes.reserva.vuelta')"/>');
					} else{
						$j(idIs).children(':first-child').removeClass("bloque-9");
						$j(idIs).children(':first-child').html('&nbsp;');
					}
					numVueltas++;}
				
			} 
		}
		}
	
		);
		if (numVueltas==0 && '<s:property value="soloIda"/>'!='true'){
			confirm('<s:property value="getText('lang.trenes.reserva.vueltasNoDisponibles')"/>');
			$j('.agrupa-datos-12').show();
			resetRadios(precioTotal);
		}
	
	}


	function resetRadios(precioTotal){
			$j('div').each(function(n) { 
				if (this.id.indexOf("vuelta")!=-1){
					if (this.id.indexOf("vuelta__"+(precioTotal.replace('.','-')))!=-1){
						var idIs='#'+this.id;
						$j(idIs).show();
						$j(idIs + " input[type=radio]").reset();
					} 
				}
			});
	}
	function cargaAjaxPagina(numPaginas){
		$j('#ocultaPag1').show();
		$j('#ocultaPag2').show();
		var llamada='PaginacionDisponibilidadRenfe.html?'+$j('#formBuscador').serialize()+'&'+$j('#formBuscadorFiltro').serialize()+'&pagina=0';
		$j('#MasPaginas').load(llamada,function(){
													$j('#ocultaPag1').hide();
													$j('#ocultaPag2').hide();
													});

	}
	
	function generarPaginacion(numPaginas, paginaActual,carga){
	    var links;
	    var ul='<ul id="paginacionUl" class="paginacion2"></ul>';
	    var ul2='<ul id="paginacionUl2" class="paginacion2"></ul>';
	    var bajo = true;
	    var alto = true;
	    var iniIni = 0;
	    var num=2; 
	    var medIni = paginaActual-1;
	    var medFin = paginaActual+2;
	    var finIni = numPaginas - 2;
	    var finFin = numPaginas;
	    
	    if(numPaginas>1){
	    
	      if (paginaActual<=num){
	        num=5;
	        medIni=0;
	        medFin=0;
	        ((numPaginas-2)<= num)?finIni=numPaginas-1:finIni=numPaginas-2;
	        finFin=numPaginas;
	        bajo=false;
	        if (numPaginas<=5){
	          alto=false;
	          num=numPaginas;
	          finIni=0;
	          finFin=0;
	        }
	      }
	      (num==2)?num = 1:num = num;
	      if(paginaActual>num && paginaActual>=(numPaginas-5)){
	        num=1;
	        medIni=0;
	        medFin=0;
	        bajo=false;
	        finIni=numPaginas-5;
	        finFin=numPaginas;	
	      }
	      if (numPaginas<6){
	    	  bajo=false;
	          alto=false;
	          num=numPaginas;
	          medIni=0;
	          medFin=0;
	          finIni=0;
	          finFin=0;
	        }
	      
	    
	      if (paginaActual==0){
	        links='<li><a class="retrocede-paginacion"></a></li>';
	      }else{
	        links='<li><a href="javascript:getPageFromServer('+numPaginas+',' + (paginaActual-1) + ');"  class="retrocede-paginacion" style="background-position:-25px 0px"></a></li>';
	      }
	    
	      for (var i=iniIni;i<num;i++){
	        if (i==paginaActual){
	          links+='<li><a title="'+ (i+1) +'" href="javascript:getPageFromServer('+numPaginas+',' + i +');"  id="actual">'+ (i+1) +'</a></li>';
	        }else{
	          links+='<li><a title="'+ (i+1) +'" href="javascript:getPageFromServer('+numPaginas+',' + i +');">'+ (i+1) +'</a></li>';
	        }
	      }
	      if(bajo){
	        links+='<li class="dato1">..</li>';
	      }
	    
	      for (var i=medIni;i<medFin;i++){
	        if (i==paginaActual){
	          links+='<li><a title="'+ (i+1) +'" href="javascript:getPageFromServer('+numPaginas+',' + i +');"  id="actual">'+ (i+1) +'</a></li>';
	        }else{
	          links+='<li><a title="'+ (i+1) +'" href="javascript:getPageFromServer('+numPaginas+',' +  i +');">'+ (i+1) +'</a></li>';
	        }
	      }
	      if(alto){
	        links+='<li class="dato1">..</li>';
	      }
	    
	      for (var i=finIni;i<finFin;i++){
	        if (i==paginaActual){
	          links+='<li><a title="'+ (i+1) +'" href="javascript:getPageFromServer('+numPaginas+',' + i +');"  id="actual">'+ (i+1) +'</a></li>';
	        }else{
	          links+='<li><a title="'+ (i+1) +'"  href="javascript:getPageFromServer('+numPaginas+',' +  i +');">'+ (i+1) +'</a></li>';
	        }
	      }
	    
	      if (paginaActual!=(numPaginas-1)){
	        links+='<li><a title="" href="javascript:getPageFromServer('+numPaginas+',' + (paginaActual+1) + ');" class="avanza-paginacion"></a></li>';
	      }else{
	        links+='<li><a title="" class="avanza-paginacion"  style="background-position:-25px 0px"></a></li>';
	      }
	    }
	    $j('#paginacionUl').remove();
	    $j(ul).insertAfter('#paginacionDiv');
	    $j("#paginacionUl").append(links);
	    
	    $j('#paginacionUl2').remove();
	    $j(ul2).insertAfter('#paginacionDiv2');
	    $j("#paginacionUl2").append(links);
	    if(carga && (numPaginas>1)){
	    	cargaAjaxPagina(numPaginas);
	    }
	    setPage(paginaActual);
	    
  }	
	
	function getPageFromServer(numPage,page){
		if($j("#pagina_"+page)){
			$j("div [id^='pagina_']").hide();
			$j("#pagina_"+page).show();
			generarPaginacion(numPage,parseInt(page),false);
		}else{

			}
		//doFiltrado('removeFiltro=0&pagina='+page,'capaCargandoV2');			
	}

	function setPage(paginaActual){
		var idIs;
		var pag="dispoPage_"+paginaActual;
		$j('div').each(function(n) { 
				idIs='#'+this.id;
				if (this.id.indexOf(pag)>=0){
					$j(idIs).show();
				} else {
					if (this.id.indexOf("dispoPage_")>=0){
						$j(idIs).hide();
					}
				}
			}
		);
	}
	
	
	function showLightBox(idCapa,idCapaFade) {
		$j('#'+idCapa).show();
		$j('#'+idCapaFade).show();
		$j('#'+idCapa).css('zIndex',5000);
	}
	function hideLightBox(idCapa,idCapaFade) {
		$j('#'+idCapa).hide();
		$j('#'+idCapaFade).hide();
	}
	function muestraMasInfoTren(idpos,ida,tren,compania,salida,llegada,fechaSalida,fechaLlegada,origen,destino,precio){
		var html='';
		var cabecera;
		
		html+='<div class="agrupa-datos-7" title="'+precio+'">';
		html+='<div class="fila-1 cabecera">';
		html+='<div class="dato1">';
		if (ida){html+='<s:property value="getText(\"lang.trenes.reserva.ida\")"/>&nbsp;:';}
		else{html+='<s:property value="getText(\"lang.trenes.reserva.vuelta\")"/>&nbsp;';}
		html+='<s:property value="getText(\"lang.trenes.reserva.tren\")"/>&nbsp;'+tren+'&nbsp;';
		html+='</div>';
		html+='<div class="dato6"><s:property value="getText(\"lang.trenes.reserva.compania\")"/>&nbsp;'+compania+'</div>';
		html+='</div>';
		html+='<div class="fila-1">';
		html+='<div class="dato4">'+salida+'</div>';
		html+='<div class="dato7">'+fechaSalida+'</div>';
		html+='<div class="dato8">'+origen+'</div>';					
		html+='</div>';				
		html+='<div class="fila-1 par">';
		html+='<div class="dato4">'+llegada+'</div>';
		html+='<div class="dato7">'+fechaLlegada+'</div>';
		html+='<div class="dato8">'+destino+'</div>';						
		html+='</div>';
		html+='</div>';

		cabecera='<div class="dato1 bloque-9"><div class="dato1-1">';
		cabecera+='</div></div>';
		cabecera+='<a title="<s:property value="lang.trenes.reserva.cerrarVentana"/>" href="javascript: hideLightBox(\'capaMasInfo\',\'fade\');" class="cerrar"></a>';
		cabecera+='<div class="contenido-flotante">'+html+'</div>';

		html=cabecera;
		
		masInfoTren(html,idpos);

	}
	function checkDatos(){
		//showCargando('capaCargandoV2');
		var campos='#'+formDispo+'_trenIda';
		campos+=',#'+formDispo+'_claseIda';
		campos+=',#'+formDispo+'_origenIda';
		campos+=',#'+formDispo+'_destinoIda';
		campos+=',#'+formDispo+'_origenIdaDes';
		campos+=',#'+formDispo+'_destinoIdaDes';
		campos+=',#'+formDispo+'_tarifaIda';
		var data=$j(campos).val();
		var dataVuelta='SoloIda';
		
		if('<s:property value="soloIda"/>'!='true'){
			campos=',#'+formDispo+'_trenVuelta';
			campos+=',#'+formDispo+'_claseVuelta';
			campos+=',#'+formDispo+'_precioVuelta';
			campos+=',#'+formDispo+'_tarifaVuelta';
			campos+=',#'+formDispo+'_origenVuelta';
			campos+=',#'+formDispo+'_destinoVuelta';
			campos+=',#'+formDispo+'_origenVueltaDes';
			campos+=',#'+formDispo+'_destinoVueltaDes';
			dataVuelta=$j(campos).val();
		}

		
		if(data=='' || dataVuelta==''){
			//hideCargando('capaCargandoV2');
			return false;
		}
		return true;
	}
	function muestraDesglose(idpos, precioTotal){
		var feeTotal=getDescuento(precioTotal);
		var feeViaje=getDescuentoViaje(precioTotal);
		feeViaje=feeViaje/1;
		feeTotal=feeTotal/1;

		//Solo hay dos
		idIs='#' + idpos + '  input[type=radio]';
		var totaRadios=0;
		$j(idIs).each(function(n) { 
				totaRadios++;
			});
		if(totaRadios==2){
			$j(idIs).attr('checked', true);
			$j(idIs).trigger('click');
			}
		




		var html='';
		var cabecera='';
		values=idpos.split("_");
		var precio=$j('#'+formDispo+'_precioTotal').val().replace(".","-");
		if(values[1]!=precio){
			confirm('<s:property value="getText(\"lang.trenes.reserva.datosIncorrectos\")"/>');
			return false;
		}
		if (!checkDatos()){
			confirm('<s:property value="getText(\"lang.trenes.reserva.datosIncorrectos\")"/>');
			return false;
		}
		html+='<div class="agrupa-datos-7" >';
		html+='<div class="fila-1 cabecera">';
		html+='<div class="dato1"><s:property value="getText(\"lang.trenes.reserva.adulto\")"/></div>';
		html+='<div class="dato2">&nbsp;</div>';
		html+='<div class="dato3"></div>';
		html+='<div class="dato4"></div>';
		html+='<div class="dato5"></div>';
		html+='</div>';

		html+='<div class="fila-1">';
		html+='<div class="dato1">'+$j('#'+formDispo+'_origenIdaDes').val()+'<br>'+$j('#'+formDispo+'_destinoIdaDes').val()+'</div>';
		html+='<div class="dato4"><s:property value="getText(\"lang.trenes.reserva.ida\")"/></div>';
		html+='<div class="dato6" style="color:#D42D12">'+$j().number_format($j('#'+formDispo+'_precioIda').val())+'&euro;</div>';
		html+='</div>';
		
		html+='<div class="fila-1 par">';
		html+='<div class="dato1">'+$j('#'+formDispo+'_origenVueltaDes').val()+'<br>'+$j('#'+formDispo+'_destinoVueltaDes').val()+'</div>';
		html+='<div class="dato4"><s:property value="getText(\"lang.trenes.reserva.vuelta\")"/></div>';
		html+='<div class="dato6" style="color:#D42D12">'+$j().number_format($j('#'+formDispo+'_precioVuelta').val())+'&euro;</div>';
		html+='</div>';

		html+='</div>';
		html+='<div class="separador-3"></div>';


	
		html+='<div class="destacado-5" style="padding: 5px;height:20px">';
		html+='<div style="float: right"><span class="dato1">'+$j().number_format((($j('#'+formDispo+'_precioTotal').val()/1)+feeTotal))+'&euro;</span></div>';
		html+='</div>';


		cabecera+='<div class="encabezado-1">';
		cabecera+='<div class="titulo-2">'+$j('#'+formDispo+'_origenIdaDes').val()+'&nbsp;--&nbsp;'+$j('#'+formDispo+'_destinoIdaDes').val()+'</div>';
		cabecera+='<div class="titulo-2">'+$j('#'+formDispo+'_origenVueltaDes').val()+'&nbsp;--&nbsp;'+$j('#'+formDispo+'_destinoVueltaDes').val()+'</div>';
		cabecera+='</div>';
		cabecera+='<a title="<s:property value="lang.trenes.reserva.cerrarVentana"/>" href="javascript: hideLightBox(\'capaMasInfo\',\'fade\');" class="cerrar"></a>';
		cabecera+='<div class="separador-3"></div>';
		cabecera+='<div class="contenido-flotante">'+html+'</div>';

		html=cabecera;
		
		masInfoTren(html,idpos);

	}
	function masInfoTren (html,idpos){
			
		$j('#capaMasInfo').html(html);
		var capa='capaMasInfo';

	 	$j('#capaMasInfo').removeAttr('style');
	 	$j('#capaMasInfo').addClass('capa-flotante').addClass('capa-flotante-1').addClass('contenido-box');
		showLightBox('capaMasInfo','fade');
		hideCargando("capaCargandoV2");
	 	var pos=$j('#'+idpos).offset();
	 	//$("#capaMasInfo").css( { "left":(pos.left+100) + "px", "top":(pos.top+100) + "px" } ); 
	 	$j('#capaMasInfo').center();
	}

	function filtradoHoraIda(objId){
		$j('#filtroHoraIda').val($j('#'+objId).val());
		getFiltrado();
	}


		$j(document).ready(function(){
			
			
			<s:if test="#disponibilidad!=null">
				generarPaginacion(<s:property value="#disponibilidad.getPages(false).size()"/>,<s:property value="#disponibilidad.getPaginaActual()"/>,true);
				//generarPaginacion(2,<s:property value="#disponibilidad.getPaginaActual()"/>);
				
			</s:if>

			$j("#filtroHoraIdaMain option").each(function(i){
					$j(this).html($j(this).html().replace('&amp;euro;','&euro;'));
			    });
		    
			hideLightBox('cargandoFiltro','fadeInicial');
			
		}); 

		function openMap(url,title){
			if (url!=''){
				$j.ajax({     
					type: "get", 
					url: url,     
					success: function (data, text) {
							var temp='<div class="dato1 bloque-9" style="height:40px"><div class="dato1-1">';
							temp+='</div></div>';
							temp+='<div style="margin-left: 70px; font-size: 20px; float: left;">'+title+'</div>';
							temp+='<a title="<s:property value="lang.trenes.reserva.cerrarVentana"/>" href="javascript: hideLightBox(\'capaMasInfo\',\'fade\');" class="cerrar"></a>';
							temp+='<div class="contenido-flotante">'+data+'</div>';
			
							$j('#capaMasInfo').html(temp);
						 	$j('#capaMasInfo').removeAttr('style');
						 	$j('#capaMasInfo').addClass('capa-flotante').addClass('capa-flotante-1').addClass('contenido-box');
							showLightBox('capaMasInfo','fade');
							hideCargando("capaCargandoV2");
						 	$j('#capaMasInfo').center();
						}					
					});
			}
		}

</script>

