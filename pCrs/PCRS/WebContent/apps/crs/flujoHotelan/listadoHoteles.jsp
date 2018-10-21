<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- listadoHoteles 
<s:if test='isDebug()'>
	<s:set name="debug" value="%{'text'}" />
</s:if>
<s:else>
	<s:set name="debug" value="%{'hidden'}" />
</s:else>
-->
<s:set name="debug" value="%{'hidden'}" />
<s:set name="debugPasajeros" value="%{'hidden'}" />

<!-- s:form id="detalleHotel" name="detalleHotel" action="detalleHotel"-->
<form id="detalleHotel" name="detalleHotel" action="">
	<input id="hotelSeleccionadoDetail" name="hotelSeleccionado" type="<s:property value='#debug'/>" value=""/>
	<input id="idHotel" name="idHotel" type="<s:property value='#debug'/>" value=""/>
	<input id="adults" name="adults" type="<s:property value='#debugPasajeros'/>" value="<s:property value='adults'/>"/>
	<input id="ninos" name="ninos" type="<s:property value='#debugPasajeros'/>" value="<s:property value='ninos'/>"/>
	<input id="bebes" name="bebes" type="<s:property value='#debugPasajeros'/>" value="<s:property value='bebes'/>"/>
</form>
<s:form id="datosPasajeros" name="datosPasajeros" action="datosPasajeros">
	<input id="hotelSeleccionado" name="hotelSeleccionado" type="<s:property value='#debugPasajeros'/>" value=""/>
	<input id="entrada" name="entrada" type="<s:property value='#debugPasajeros'/>" value="<s:property value='entrada'/>"/>
	<input id="salida" name="salida" type="<s:property value='#debugPasajeros'/>" value="<s:property value='salida'/>"/>
	<input id="noches" name="noches" type="<s:property value='#debugPasajeros'/>" value="<s:property value='noches'/>"/>
	<input id="zona" name="zona" type="<s:property value='#debugPasajeros'/>" value="<s:property value='zona'/>"/>
	<input id="destino" name="destino" type="<s:property value='#debugPasajeros'/>" value="<s:property value='destinosid'/>"/>
	<input id="adults" name="adults" type="<s:property value='#debugPasajeros'/>" value="<s:property value='adults'/>"/>
	<input id="ninos" name="ninos" type="<s:property value='#debugPasajeros'/>" value="<s:property value='ninos'/>"/>
	<input id="bebes" name="bebes" type="<s:property value='#debugPasajeros'/>" value="<s:property value='bebes'/>"/>
	<input id="idioma" name="idioma" type="<s:property value='#debugPasajeros'/>" value="<s:property value='idioma'/>"/>
</s:form>

<s:form id="reloadForm" name="reloadForm" action="disponibilidad">
	<s:iterator var="par" value="getParameters()" >
		<s:if test="!#par.key.equals('todosLosResultados') && !#par.key.equals('paginas') && !#par.key.equals('sessionId')">
			<input name="<s:property value='#par.key'/>" type="<s:property value='#debug'/>" value="<s:property value='#par.value'/>"/>
		</s:if>	
	</s:iterator>
	<input name="todosLosResultados" type="<s:property value='#debug'/>" value="false"/>
	<input name="paginas" type="<s:property value='#debug'/>" value="<s:property value='nextPaginas()'/>"/>
	<input name="sessionId" type="<s:property value='#debug'/>" value="<s:property value='sessionId'/>"/>
	
</s:form>
<s:if test='dispo.villa.size()==0'>
	<div class="art-PostMetadataHeader">
		<div class="textoCabeceraDestinos">
			<s:text name="lang.gen.glo.noDisponibilidad"/>
		</div>
	</div>
</s:if>

<s:iterator var="hotel" value="dispo.villa" status="hotelesStat">
	<s:if test='maxHoteles(#hotelesStat.index)'>
		<div style="display:none" id="hotel_<s:property value="#hotel.id"/>">
			<s:property value="getSerializedHotel(#hotel)"/>
		</div>
		<div style="position: relative; background: transparent; height: auto" class="titlebox">
			<table cellspacing="0" cellpadding="4" border="0">
				<tbody>
				<tr>
					<td>
						<div style="position: relative;  width: 100px" class="leftcell">
							<div class="inner">
								<a href="javascript: openDetail('<s:property value='#hotel.id'/>','<s:property value='#hotel.codHotelguide'/>','<s:property value='#hotel.ddbbHotel.name.toUpperCase().replace("\'", "")'/>','<s:property value='#hotel.ddbbHotel.zoneDes.replace("\'", "")'/>')" target="_self">
									<img height="105px" width="105px" alt="<s:property value="#hotel.ddbbHotel.name.toUpperCase()"/>" title="<s:property value='#hotel.ddbbHotel.name.toUpperCase()'/>" src="<s:property value='#hotel.image'/>" style="border-color:#DEDEDE" class="listimage">
								</a>
							</div>
						</div>
					</td>
					<td>
						<div style="position: relative; width: 445px; top: 10; left:0" class="centercell">
							<div class="inner">
								<table width="100%" cellspacing="0" cellpadding="0" border="0">
									<tbody>
									<tr>
										<td width="300px" style="text-align: left;">
											<a href="javascript: openDetail('<s:property value='#hotel.id'/>','<s:property value='#hotel.codHotelguide'/>','<s:property value='#hotel.ddbbHotel.name.toUpperCase().replace("\'", "")'/>','<s:property value='#hotel.ddbbHotel.zoneDes.replace("\'", "")'/>')"  class="textoListados" target="_self">
												<s:property value="#hotel.ddbbHotel.name.toUpperCase()"/></a>&nbsp;</td><td style="text-align: left;">
											<div class="subtitle">&nbsp;&nbsp;&nbsp;<img alt="Star Rate" src="<s:property value='getLinkCategoriaHotelan(#hotel)'/>"></div>
										</td>
										<td style="text-align: right;">
											<span style="padding-left:10px;" class="small">&nbsp;</span>
										</td>
									</tr>
									</tbody>
								</table>
								<p class="cat">
								<spam style="color: #000000">
								<strong><s:text name="lang.gen.glo.zona"/>:&nbsp;<s:property value="#hotel.ddbbHotel.zoneDes"/></strong></spam><br>
								<s:property escape="false" value='recortaDescipcion(#hotel)'/>
								....
								<s:if test="#hotel.codCrs==null">
									....
								</s:if>	
								
								
								<a href="javascript: openDetail('<s:property value='#hotel.id'/>','<s:property value='#hotel.codHotelguide'/>','<s:property value='#hotel.ddbbHotel.name.toUpperCase().replace("\'", "")'/>','<s:property value='#hotel.ddbbHotel.zoneDes.replace("\'", "")'/>')"  style="color: #F38A12;" class="textoListados" target="_self">
									<s:text name="lang.gen.glo.masinfirmacion"/>
								</a>
								 
								</p>
								</div></div>
					</td>
					<td>
						<div style="width: 75px; vertical-align: middle;" class="rightcell">
							<div class="inner"/>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div id="principalFrame"> 
			  				<div id="contenidoFrame"> 
			    				<div id="tipoHabi"> 
			        				<div style="height: auto; display: block;" class="lahabi" id="habita_1"> 
										<div class="listaPhotel" style="border-bottom:0 solid #919191">
												<!-- s:iterator var="contrato" value="#hotel.contratos" status="contratosStat"-->
													<div <s:if test="#ultimoHotel==#hotel.id">style="display:none"</s:if> id="<s:property value="#hotel.servicioCodigo"/>_<s:property value="#contrato.codigoClasificacion.replace(' ','_')"/>">
													<s:set name="ultimoHotel" value="#hotel.id"/>
													<table width="100%" cellspacing="0" cellpadding="0" border="0">
													<tbody>
														<tr>
															<td class="PhotelCeldaCabecera" colspan="2"><div class="PhotelTexxtoFila">
																<div style="padding:8px; color:#F38A12; text-decoration:underline">
																	
																	<s:property value="twoDecimalFormat(#hotel.priceBigDecimal)"/>
																	&nbsp;EUR
																</div>
															</div></td>
															<td class="PhotelCeldaCabecera" colspan="2"><div class="PhotelTextoCabecera">&nbsp;</div></td>
															<td class="PhotelCeldaCabecera" colspan="2"><div class="PhotelTextoCabecera"></td>
														</tr>
														<tr>
															<td class="PhotelCeldaCabecera"><div class="PhotelTextoCabecera">&nbsp;</div></td>
															<td class="PhotelCeldaCabecera"><div class="PhotelTextoCabecera"><s:text name="lang.gen.crs.i_tipohab"/></div></td>
															<td class="PhotelCeldaCabecera"><div class="PhotelTextoCabecera"><s:text name="lang.gen.crs.i_suplemento"/> </div></td>
															<td class="PhotelCeldaCabecera"><div class="PhotelTextoCabecera"><s:text name="lang.gen.crs.i_precioNoche"/></div></td>
															<td class="PhotelCeldaCabecera"><div class="PhotelTextoCabecera"><s:text name="lang.gen.crs.i_totalreserva"/></div></td>
															<td align="center" class="PhotelCeldaCabecera"><div class="PhotelTextoCabecera"><s:text name="lang.gen.crs.i_seleccione"/></div></td>
														</tr>
														<!-- s:iterator var="distribucion" value="#contrato.distribuciones" status="distribucionesStat"-->
															<tr>
																<td colspan="6">
																	<div>
																		<br>
																		<span style="color: #919191;font-size: 13px;"><b>
																		<s:property value="getPaxesString(adults,ninos,bebes)"/>
																		
																		</span>
																	</div>
																	
																	<br>
																	<!--s:property value="twoDecimalFormat(#distribucion.precioMin)"/-->
																</td>
															</tr>
															<!-- s:iterator var="room" value="#distribucion.rooms" status="roomsStat"-->
																<tr>
																	<td  style="border-bottom: 1px solid #919191;">
																		&nbsp;
																	</td>	
																	<td  style="border-bottom: 1px solid #919191;">
																		<div style="width: 150px;" class="PhotelTexxtoFila" >
																			<span style="font-size: 11px;">
																				<s:property value="formatCapitalizeAllWords(#hotel.ddbbHotel.typeDes)"/>&nbsp;<s:property value="#hotel.ddbbHotel.rooms"/>&nbsp;<s:text name="lang.gen.glo.habitaciones"/>
																			</span>
																		</div>
																	</td>	  
																	<td style="border-bottom: 1px solid #919191;">
														  				<div class="PhotelTexxtoFila">
														  					<s:property value="#hotel.board"/>
														  				</div>
																	</td>
																	<td style="border-bottom: 1px solid #919191;">					
																		<div class="PhotelTexxtoFila">
																			<span id="pornoche_<s:property value="#hotel.id"/>" style="font-size: 11px">
																			<s:property value="getRegimenValueXNocheFromString(#hotel.priceBigDecimal)"/> EUR
																			</span>
																		</div>
																	</td>
																	<td style="border-bottom: 1px solid #919191;">
								 										<div class="PhotelTexxtoFila">
																			<img width="16" height="16" class="espera" src="img/espera.gif" style="display: none" id="espera_1_0">
																			<span id="importe_<s:property value="#hotel.id"/>" tyle="font-size: 11px">
																			<s:property value="twoDecimalFormatFromString(#hotel.priceBigDecimal)"/> EUR
																			</span>
																		</div>
																	</td>
																	<td align="center" style="border-bottom: 1px solid #919191;">
																		<table cellspacing="0" cellpadding="0" border="0">
																			<tbody>
																			<tr>
																				<td>&nbsp;</td>
																				<td>
																					<input type="radio" class="styled" name="radio_<s:property value="#hotel.id"/>"  checked/>
																				</td>
																			</tr>
																			</tbody>
																		</table>
																	</td>
																	</tr>
																	<!-- Repetir tr por habitación -->
																<!-- /s:iterator-->
																<tr>
																<td colspan="6">
																	&nbsp;
																</td>
															</tr>
															<!-- /s:iterator-->
													</tbody>
													</table>
															  			<div style="border: 0px; border-bottom: 2px solid #F38A12;" class="listaPhotel" id="pieReserva"> 
															  			<br>
															  			*&nbsp;<s:text name="lang.gen.crs.i_impuestos"/>
															    			<div style="float: right"> 
															      				<button onclick="javascript: reservar('<s:property value="#hotel.id"/>');" class="botonReserva" type="button"><s:text name="lang.gen.glo.reservar"/></button>
															    			</div>
															    		<br>
															  			</div>
															      		
	
																		<br class="clear">
													</div>
												
												<!-- /s:iterator-->
												
											
				  						</div>
									</div>
								</div>
								<!-- tipoHabi -->
				  
	
			      			</div>
			  				<!--contenido-->
						</div>
						<!-- principalFrame -->
					</td>
				</tr>
				</tbody>
			</table>
		</div>
	</s:if>
</s:iterator>

<script type="text/javascript">
	
	function openDetail(codigoHotel,codigoHG,title,localidad){
			title=title + " - " + localidad + " - <s:property value='getDestinationDescription()'/>";
			var url=".com/index.php?tt="+title+"&action=detail&url=/apps/portvill/detalleHotel.html?idHotel="+codigoHotel
			if (codigoHG!=null && codigoHG!=''){
				url=".com/index.php?option=com_hotelguide&view=hotel&id="+codigoHG;	
			}
					
			var location=window.location.href;
			url=location.split(".com")[0]+url;
			url=encodeURI(url);
			//$j('#detalleHotel').attr("action", url)		
			//$j('#detalleHotel').submit()
			/*
			if (parent.location != window.location) {
				parent.location.href=url;
			}else{
				window.location.href=url;
			}
			*/
			var str = "<form name='f1' method='post' target='_self' action='"+url+"'>";
			str += "</form>";

			var vent=window.open("", '_blank', 'toolbar=yes,location=yes,directories=yes,resizable=yes,scrollbars=yes');
			vent.document.write(str);
			vent.document.f1.submit();
			
	}
	
	function reservar(hotel){
		$j('#hotelSeleccionado').val($j('#hotel_'+hotel).html());
		$j('#datosPasajeros').submit();
	}

	
	
	
	$j().ready(function() {
		if (parent.location != window.location) {
			eval("parent.autoResize('iframeResultados');");
		}
	});
	
	
	
	function doHashCange(){
		$j(window).hashchange();
	}
	
</script>

