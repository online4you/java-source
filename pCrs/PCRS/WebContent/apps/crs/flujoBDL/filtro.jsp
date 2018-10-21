<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test='isDebug()'>
	<s:set name="debug" value="%{'text'}" />
</s:if>
<s:else>
	<s:set name="debug" value="%{'hidden'}" />
</s:else>

<!-- filtro -->
<script language="javascript">
	$j().ready(function() {
			var precioMin=<s:property value="filtroPrecioMin(getPrecioDescuento(dispo.precioMin))"/>;
			var precioMax=<s:property value="filtroPrecioMax(getPrecioDescuento(dispo.precioMax))"/>;
			var precioMinSel;
			var precioMaxSel;
			var amountRangeInput='<s:property value="amountRangeInput"/>';
			if (amountRangeInput==''){
				precioMinSel=precioMin;
				precioMaxSel=precioMax;
			}else{
				precioMinSel=amountRangeInput.split('-')[0];
				precioMaxSel=amountRangeInput.split('-')[1];
			}
			$j( "#slider-range" ).slider({
					range: true,
					min: precioMin,
					max: precioMax,
					values: [ precioMinSel, precioMaxSel ],
					slide: function( event, ui ) {
						$j( "#amountRange" ).html( ui.values[ 0 ] + " - " + ui.values[ 1 ] + " EUR");
						$j( "#amountRangeInput" ).val(ui.values[ 0 ] + "-" + ui.values[ 1 ]);
					}	
				});
			$j( "#amountRange" ).html($j( "#slider-range" ).slider( "values", 0 ) + " - " + $j( "#slider-range" ).slider( "values", 1 ) + " EUR");
			$j( "#amountRangeInput" ).val($j( "#slider-range" ).slider( "values", 0 ) + "-" + $j( "#slider-range" ).slider( "values", 1 ));
	});
	
	function setFilterValue(field,value){
		var str=$j("#"+field).val();
		if (str==''){
			$j("#"+field).val(value);
		}else{
			var values=str.split("##");
			str='';
			var remove=false;
			for (i=0;i<values.length;i++){
				if(values[i]==value){
					remove=true;
				}else{
					if (i==0){
						str+=values[i];
					}else{
						str+="##"+values[i];
					}
				}
			}
			if (!remove){
				str+="##"+value
			}
			if(str.length>2 && str.substring(0,2)=='##'){
				str=str.substring(2,str.length);
			}
			$j("#"+field).val(str);
		}
		//Auto submit
		submitReservaFiltro();
	}
	function submitReservaFiltro(){
		if (parent.location != window.location) {
			eval("parent.fadeBDL();");
		}
		$j('#filtroBusqueda').submit();
		
	}
	function limpiarFiltro(){
		$j('#amountRangeInput').val('');
		$j('#categoriaInput').val('');
		$j('#regimenInput').val('');
		$j('#facilitieInput').val('');
		$j('#localidadInput').val('');
		if (parent.location != window.location) {
			eval("parent.fadeBDL();");
		}
		
		$j('#filtroBusqueda').submit();
		
	}
	
</script>
<div id="filtro">
<div id="divAjustarBusqueda" class="ajustarBusqueda" style="width:177px;  z-index:900; position:relative; left: 0px; top: 5px;"> 
	<div class="ajustarBusquedaLateral" style="width:100%; height:100%;  z-index:900; position:relative; top: 5px; "> 
		<s:form id="filtroBusqueda" name="filtroBusqueda" action="disponibilidad">
			<s:iterator var="par" value="getParameters()" >
				<s:if test="!#par.key.equals('sessionId') && !#par.key.equals('localidadInput') && !#par.key.equals('amountRangeInput') && !#par.key.equals('categoriaInput') && !#par.key.equals('regimenInput') && !#par.key.equals('facilitieInput')">
					<input name="<s:property value='#par.key'/>" type="<s:property value='#debug'/>" value="<s:property value='#par.value'/>"/>
				</s:if>	
			</s:iterator>
			<input name="sessionId" type="<s:property value='#debug'/>" value="<s:property value='sessionId'/>"/>
			<input id="amountRangeInput" name="amountRangeInput" type="<s:property value='#debug'/>" value=""/>
			<input id="categoriaInput" name="categoriaInput" type="<s:property value='#debug'/>" value="<s:property value='categoriaInput'/>"/>
			<input id="regimenInput" name="regimenInput" type="<s:property value='#debug'/>" value="<s:property value='regimenInput'/>"/>
			<input id="facilitieInput" name="facilitieInput" type="<s:property value='#debug'/>" value="<s:property value='facilitieInput'/>"/>
			<input id="localidadInput" name="localidadInput" type="<s:property value='#debug'/>" value="<s:property value='localidadInput'/>"/>
		</s:form>
		<table border="0" cellpadding="0" cellspacing="0" width="172" height="113" style="table-layout:fixed">
			<tbody>
				<tr> 
		        	<td width="111" height="35"> 
		 				<div class="topAjustarBusqueda"><s:text name="lang.gen.glo.ajustarBusqueda"/></div>
					</td>
		        </tr>
                <tr> 
                	<td width="111">
                		<div class="textoTituloAjustarBusqueda" style="height: 35px">
 							<div><s:text name="lang.gen.crs.i_escalaPrecios"/></div>
							<div id="amountRange" style="text-align: center;"></div>
						</div>	
					</td>
                    </tr>
		            <tr> 
		            	<td width="111">
		 					<div class="cuerpoAjustarBusqueda" style="white-space:normal">
								<div id="slider-range"></div>
			  				</div>
						</td>
					</tr>		
				   	<tr> 
		            	<td width="111"> 
			  				<div class="textoTituloAjustarBusqueda">
				 				<s:text name="lang.gen.crs.i_zona"/>								  
			 				</div>
			 			</td>
		            </tr>
		            <tr>
		            	<td width="111">
			  				<div class="cuerpoAjustarBusqueda" style="white-space:normal">
		 						<table border="0" cellpadding="0" cellspacing="0">
									<tbody>
										<tr>
											<td valign="bottom">
												<div>
													<select name="ajustarBusquedaciudad" id="ajustarBusquedaciudad" class="inputbox" size="1" style="width: 150px" onchange="$j('#localidadInput').val(this.value);submitReservaFiltro();">
														<option value=""></option>
														<s:iterator var="localidad" value="dispo.localidades" status="localidadesStat">
															<option value="<s:property value='#localidad.codigo'/>" <s:if test='#localidad.codigo.equals(localidadInput)'>selected="selected"</s:if>><s:property value='#localidad.descripcion'/></option>
														</s:iterator>
													</select>
												</div>
											</td>
										</tr>								 
			 						</tbody>
			 					</table>
							 </div>
						</td>
					</tr>		
		            <tr> 
		            	<td width="111"> 
			  				<div class="textoTituloAjustarBusqueda">
				 				<s:text name="lang.gen.crs.i_categoria"/>									  
			 				</div>
			 			</td>
                     </tr>
                     <tr> 
                        <td width="111">
							<div class="cuerpoAjustarBusqueda" style="white-space:normal">
							<table border="0" cellpadding="0" cellspacing="0">
							  	<tbody>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("1EST_1LL_ALBER_HR_APTH_HS_HSR",categoriaInput)'>checked</s:if> class="styled" title="setFilterValue('categoriaInput','1EST_1LL_ALBER_HR_APTH_HS_HSR')">
											</td>
											<td>
							 					<img alt="Star Rate" src="<s:property value='getContextPath()'/>/static/crs/images/1EST.png">
											</td>
									</tr>									
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("2EST_2LL_HR2_APTH2_HS2_HSR2",categoriaInput)'>checked</s:if> class="styled" title="setFilterValue('categoriaInput','2EST_2LL_HR2_APTH2_HS2_HSR2')">
											</td>
											<td>
							 					<img alt="Star Rate" src="<s:property value='getContextPath()'/>/static/crs/images/2EST.png">
											</td>
									</tr>									
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("3EST_3LL_HR3_APTH3_HS3_HSR3",categoriaInput)'>checked</s:if> class="styled" title="setFilterValue('categoriaInput','3EST_3LL_HR3_APTH3_HS3_HSR3')">
											</td>
											<td>
							 					<img alt="Star Rate" src="<s:property value='getContextPath()'/>/static/crs/images/3EST.png">
											</td>
									</tr>									
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("4EST_4LL_HR4_APTH4_HS4_HSR4",categoriaInput)'>checked</s:if> class="styled" title="setFilterValue('categoriaInput','4EST_4LL_HR4_APTH4_HS4_HSR4')">
											</td>
											<td>
							 					<img alt="Star Rate" src="<s:property value='getContextPath()'/>/static/crs/images/4EST.png">
											</td>
									</tr>									
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("5EST_5LL_HR5_APTH5_HS5_HSR5",categoriaInput)'>checked</s:if> class="styled" title="setFilterValue('categoriaInput','5EST_5LL_HR5_APTH5_HS5_HSR5')">
											</td>
											<td>
							 					<img alt="Star Rate" src="<s:property value='getContextPath()'/>/static/crs/images/5EST.png">
											</td>
									</tr>
							  		<!-- 
							  		<s:iterator var="categoria" value="dispo.categorias" status="categoriasStat">
										<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr(#categoria.codigo,categoriaInput)'>checked</s:if> class="styled" title="setFilterValue('categoriaInput','<s:property value='#categoria.codigo'/>')">
											</td>
											<td>
							 					<s:property value='#categoria.descripcion'/>
											</td>
										</tr>
									</s:iterator>
									-->
							 	</tbody>
							</table>
							</div>
						</td>
					</tr>		
					<tr>		
						<td width="111">
							<div class="bottomAjustaReserva"></div>
						</td>
                	</tr>
					<tr> 
                     	<td width="111"> 
							<div class="textoTituloAjustarBusqueda">
	 							<s:text name="lang.gen.crs.i_suplemento"/>									  
							</div>
						</td>
                     </tr>
                      <tr> 
                      		<td width="111">
						<div class="cuerpoAjustarBusqueda" style="white-space:normal">
					<table border="0" cellpadding="0" cellspacing="0">
						<tbody>
																<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("RO_SC",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','RO_SC')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_soloHab"/>
											</td>
									</tr>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("BB_CB_DB",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','BB_CB_DB')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_habYDes"/>
											</td>
									</tr>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("HB",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','HB')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_mediaPen"/>
											</td>
									</tr>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("MB",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','MB')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_mediaPensionBebidas"/>
											</td>
									</tr>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("FB",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','FB')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_pensionComp"/>
											</td>
									</tr>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("PB",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','PB')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_pensionCompletaBebidas"/>
											</td>
									</tr>
									<tr>
											<td>
												<input type="checkbox" <s:if test='isInStr("AI_AS",regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','AI_AS')">
											</td>
											<td>
												<s:text name="lang.gen.crs.i_todoIncl"/>
											</td>
									</tr>
							
							<!--  
							<s:iterator var="reg" value="dispo.regimenesAlimentarios" status="regimenesAlimentariosStat">
								<tr>
									<td>
										<input type="checkbox" <s:if test='isInStr(#reg.codigo,regimenInput)'>checked</s:if> class="styled" title="setFilterValue('regimenInput','<s:property value='#reg.codigo'/>')">
									</td>
									<td>
									 	<s:property value='#reg.codigo'/>--<s:property value='#reg.descripcion'/>
									</td>
								</tr>
							</s:iterator>
							-->
					 	</tbody>
					 </table>
						</div>
				</td>
			</tr>	
		
			<tr> 
                       		<td width="111"> 
								<div class="textoTituloAjustarBusqueda">
									<s:text name="lang.gen.glo.tab_hotel3"/>							  
							</div>
						</td>
                     	</tr>
				<tr> 
                       
                       <td width="111">
	  					 <div class="cuerpoAjustarBusqueda" style="white-space:normal">
							<table border="0" cellpadding="0" cellspacing="0">
								<tbody>
																				<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-380",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-380')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroMiniGolf"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-390",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-390')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroGolf"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-400",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-400')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroAnimacion"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-405",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-405')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroAnimacionInfantil"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-430",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-430')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroTenis"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-440",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-440')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroPadel"/>
											</td>
										</tr>
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr("90-270",facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','90-270')">
											</td>
											<td>
				 								<s:text name="lang.gen.crs.i_filtroSquash"/>
											</td>
										</tr>
								</tbody>
							</table>
						 </div>
					</td>
				</tr>
				
				
				
		<s:iterator var="group" value="dispo.facilities" status="groupStat"> 
			<s:if test="mostrarFacility(#group.key)">
				<tr> 
                       		<td width="111"> 
								<div class="textoTituloAjustarBusqueda">
							<s:property value='#group.key.split("-")[1]'/>							  
							</div>
						</td>
                     	</tr>
				<tr> 
                       
                       <td width="111">
	  					 <div class="cuerpoAjustarBusqueda" style="white-space:normal">
							<table border="0" cellpadding="0" cellspacing="0">
								<tbody>
									<s:iterator var="facilitie" value="#group.value" status="facilitieStat">
										<tr>
											<td>
												<input type="checkbox"  <s:if test='isInStr(#group.key.split("-")[0]+"-"+#facilitie.split("##")[1],facilitieInput)'>checked</s:if> class="styled" title="setFilterValue('facilitieInput','<s:property value="#group.key.split('-')[0]+'-'+#facilitie.split('##')[1]" />')">
											</td>
											<td>
				 								<s:property value="#facilitie.split('##')[4]" />	
											</td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						 </div>
					</td>
				</tr>
			</s:if>
		</s:iterator> 
			<tr>		
			<td width="111">
				<div class="bottomAjustaReserva"></div>
			</td>
             		</tr>    	                          
                     <tr> 
                    		<td width="111"> 
				<div class="buscarAjustarBusqueda">
	 		<table width="100%" border="0" cellpadding="0" cellspacing="0">
	 			<tbody>
	 				<tr>
	 					<td style="text-align:center">
							<button type="button" class="botonReserva" onclick="javascript: submitReservaFiltro();"><s:text name="lang.gen.glo.filtrar"/></button>
						</td>
					</tr>
					<tr>
						<td style="text-align:center">
							<button type="button" class="botonReserva" onclick="javascript: limpiarFiltro();"><s:text name="lang.gen.glo.linpiarFiltro"/></button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</td>
	</tr>
</tbody>
</table>
</div>
<div class="ajustarBusquedaBottom" style="width:175px;  height:8px; z-index:900; position:relative; bottom: 0px; "></div>

<!--end filtro-->
</div>

</div>
<!-- end filtro -->

