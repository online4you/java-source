<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="disponibilidad" value="dispo"/>
<s:set name="paginas" value="#disponibilidad.getPages(false)"/>

<s:iterator var="page" value="#paginas" status="pageStat">
	<s:if test="#pageStat.index!=0">
	<div id="pagina_<s:property value='#pageStat.index'/>" class="area-contenido-2" style="display:none">
		<div id="dispoPage_<s:property value="#pageStat.index" />" style="display:block">
			<s:iterator var="agrup" value="#page" status="agrupStat"> 
				<s:if test="#disponibilidad.mostrarAgrup(#agrup) && #agrup!=null">
					<div id="positionReference_<s:property value="#agrup.replace('.','-')" />" >
						<s:iterator var="idaVuelta" value="{0,1}"  status="idaVueltaStat"  >
							<s:set name="resetImg" value="resetIdaVuelta(#idaVueltaStat.index)"/>
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
														<div class="dato2-1-6" title="<s:property value="#precio" />">
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
	
	</div>
	</s:if>
</s:iterator>






