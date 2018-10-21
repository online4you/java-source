<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="path" value="getContextPath()"/>
   <s:url id="destinoOrigenLink"  action="AutocompleteField">
    	<s:param name="tipo">DE</s:param>
     </s:url>
    <s:url id="provinciasDestinoLink"  action="ajaxProvincias"/>
   <s:url id="estacionDestinoLink"  action="ajaxEstacionDestino"/>
	<s:set name="disponibilidad" value="dispo"/>

                   	<h2 class="titulo1" style="margin-top: 10px"><s:property value="getText('lang.trenes.disponibilidad.miBusqueda')"/>
						<span class="subtitulo3"><s:property value="getText('lang.trenes.disponibilidad.textoNuevaBusqueda')"/></span>					
					</h2>
					
                	<div class="buscador-lateral">
                	<s:form id="formBuscador" action="Disponibilidad">
                    	<div class="buscador-lateral-contenido">
                                <fieldset>
                                    <div class="grupo-formulario-10">
                                        <label for="fecha-salida">
                                            <s:property value="getText('lang.trenes.disponibilidad.fechaSalida')"/>
                                            </label><br>
                                            <s:textfield cssClass="campo-texto-10 textoFecha" name="fechaIda" size="10" onKeyDown="return false;" />
                                        
                 						<a id="f_rangeStart_trigger" title="Calendario Fecha de Salida" >
										<img src="<s:property value="%{path}"/>/static/main/images/HAL1024/icono-calendario.gif" style="cursor: pointer; visibility: visible;">
										</a>
										<div class="divSoloIda">
										<s:property value="getText('lang.trenes.home.ida')"/><!-- Solo Ida -->
                                            <s:checkbox  name="soloIda" />
                                         </div> 
                                    </div>  
                                    <div class="grupo-formulario-10" id="box-fecha-vuelta">
                                        <label for="fecha-vuelta">
                                            <s:property value="getText('lang.trenes.disponibilidad.fechaRegreso')"/>
                                            </label><br>
                                            <s:textfield cssClass="campo-texto-10 textoFecha" name="fechaVuelta" size="10" onKeyDown="return false;"/>
                                        
                                        <a id="f_rangeEnd_trigger" title="Calendario Fecha de Salida" >
										<img src="<s:property value="%{path}"/>/static/main/images/HAL1024/icono-calendario.gif" style="cursor: pointer; visibility: visible;">
										</a>
										<div class="limpiar"></div> 
                                      </div>   

                                    
                                                                                              
                                    <div class="separador"></div>                                 
                                    <div class="grupo-formulario-10">
                                        <label for="fecha-salida">
                                            <s:property value="getText('lang.trenes.origen')"/>
                                            <br>
                                            <!-- sx:autocompleter  cssClass="comboProvincias seleccionable-8" listKey="key" listValue="value" name="provinciaOrigen"  list="provincias"  searchType="substring" valueNotifyTopics="/changed"  /-->
											<s:hidden type="hidden" name="provinciaOrigenKey" id="provinciaOrigenKey" />
											<s:hidden type="hidden" name="destinosOrigenKey" id="destinosOrigenKey" />
											<div>
												<div class="campo-buscadorTrenesComboSelect">
													<img style="cursor: pointer;" src="<s:property value="%{path}"/>/static/main/images/HAL1024/select-flecha.gif" id="trenProvinciaOrigenSelect">
													<!-- img style="cursor: pointer;" border="0" src="<s:property value="%{path}"/>/static/main/images/HAL1024/lupa.gif"  id="lupaTrenIda"--> 
												</div>
												<s:textfield cssClass="campo-buscadorTrenes" name="provinciaOrigen" id="provinciaOrigen" onKeyDown="delDetino();" onBlur="delOrigenIfBlank();" onKeyPress="return submitenter(this,event)"/>
											</div>
											
                            				<br>
                                        </label>
                                       <!-- 
                                        <label for="fecha-salida">
                                            <s:property value="getText('lang.trenes.estacion')"/> <s:property value="getText('lang.trenes.origen')"/>
                                            <br>
                                            <s:hidden type="hidden" name="destinosOrigenKey" id="destinosOrigenKey" />
											<s:textfield cssClass="campo-texto-11" name="destinosOrigen" id="destinosOrigen" onfocus="setKeysValues();"/>
                                        </label>
                                         -->
                                    </div>  
                                    <div class="grupo-formulario-10">
                 					<label for="fecha-salida">
                 							<s:property value="getText('lang.trenes.destino')"/>
                 							<br>
                 							<s:hidden type="hidden" name="provinciaDestinoKey" id="provinciaDestinoKey" />
                 							<s:hidden type="hidden" name="destinosDestinoKey" id="destinosDestinoKey" />
											<div>
												<div class="campo-buscadorTrenesComboSelect">
													<img style="cursor: pointer;" src="<s:property value="%{path}"/>/static/main/images/HAL1024/select-flecha.gif" id="trenProvinciaDestinoSelect">
													<!--img style="cursor: pointer;" border="0" src="<s:property value="%{path}"/>/static/main/images/HAL1024/lupa.gif"  id="lupaTrenVuelta"-->
												</div>
												<s:textfield cssClass="campo-buscadorTrenes" name="provinciaDestino" id="provinciaDestino" onfocus="setKeysValues();" onBlur="delDestinoIfBlank();" onKeyPress="return submitenter(this,event)"/>
											</div>
											
 
											<br>
                                        </label>
                                         <!-- 
                                        <label for="fecha-salida">
                                            <s:property value="getText('lang.trenes.estacion')"/> <s:property value="getText('lang.trenes.destino')"/>
                 							<br>
                                            <s:hidden type="hidden" name="destinosDestinoKey" id="destinosDestinoKey" />
											<s:textfield cssClass="campo-texto-11" name="destinosDestino" id="destinosDestino" onfocus="setKeysValues();"/>
                                       </label>
                                       -->
                                 </div>
									<div class="grupo-formulario-10">
									   	<s:property value="getText('lang.trenes.explicacionAsterisco')"/>
									</div>
                                    <div class="separador"></div>
                                    <div class="grupo-formulario-10">
                                    	<div class="dato1">
                                            <s:property value="getText('lang.trenes.pasajeros')"/>
                                        </div>
                                    	<label class="etiqueta-6" for="adultos">
                                            <s:property value="getText('lang.trenes.adultos')"/>
                                            <s:select cssClass="seleccionable-7" label="Adultos" 
											list="adultos" 
											name="adultosKey" 
											onChange="javascript: comprobarPasajeros();"
											/> 
											</label>
											<label class="etiqueta-6" for="ninos">
											<s:property value="getText('lang.trenes.reserva.tarifaNinos')"/>
                                            <s:select cssClass="seleccionable-7" label="Niños"
											list="ninos" 
											name="ninosKey" 
											onChange="javascript: comprobarPasajeros();"
											/>                                     
                                        </label>
                    	
                                    </div>
                                    <div class="separador"></div>
                                </fieldset>
                                <div class="contenedor-boton">
                                    <div class="boton-1-izda"></div>
                                    <button type="button" class="boton-2"  onclick="javascript: buscar();"><s:property value="getText('lang.trenes.disponibilidad.volverBuscar')"/></button>
                                    	
                                    <div class="boton-1-dcha"></div>                                        
                                </div>                                           

						</div>       
						</s:form>                     
                    </div>
                    <div class="separador-3"></div>
          <s:if test="#disponibilidad!=null">
                    <h2 class="titulo3">
				<s:property value="getText('lang.trenes.disponibilidad.filtroResultados')"/>
				<p class="subtitulo3"><s:property value="getText('lang.trenes.disponibilidad.textoFiltroResultados')"/></p>
			</h2>
			<div class="buscador-lateral">
				<s:form id="formBuscadorFiltro" action="#">
				<div class="buscador-lateral-contenido">
					<fieldset>
							<div class="grupo-formulario-10">
								<label for="filtroTipoTren">
									<s:property value="getText('lang.trenes.disponibilidad.tipoTren')"/>
									<br>
									<s:select 
										list="#{'AVE':getText('lang.trenes.disponibilidad.ave'),'NOAVE':getText('lang.trenes.disponibilidad.noAve')}" 
										id="filtroTipoTren" name="filtroTipoTren"
										headerKey="" headerValue="%{getText('lang.trenes.disponibilidad.todos')}"
										/>	
									
									
									</label><div class="espacio_vertical"></div>
									
								
							</div>
						
							<div class="grupo-formulario-10">
								<label for="filtroCompania">
									<s:property value="getText('lang.trenes.clase')"/>
									<br>
									<s:select 
										list="listaClases" 
										id="filtroClase" name="filtroClase"
										listKey="rclCod" listValue="rclDes"
										headerKey="" headerValue="%{getText('lang.trenes.disponibilidad.todas')}"
										/>	
									
									
									</label><div class="espacio_vertical"></div>
									
								
							</div>
													
							<div class="grupo-formulario-10">
								<label for="hora-ida">
									<s:property value="getText('lang.trenes.hora')"/> <s:property value="getText('lang.trenes.reserva.ida')"/>
									<br>
									<s:select label="hora-ida" 
										list="listaHorasIda" 
										id="filtroHoraIda" name="filtroHoraIda"
										listKey="key" listValue="value"
										headerKey="" headerValue="%{getText('lang.trenes.reserva.todosLosHorarios')}"
										/>	

								</label>
							</div>
							<div class="grupo-formulario-10">
								<label for="hora-ida">
									<s:property value="getText('lang.trenes.hora')"/> <s:property value="getText('lang.trenes.reserva.vuelta')"/>
									<br>
									<s:select label="hora-ida" 
										list="listaHorasVuelta" 
										id="filtroHoraVuelta" name="filtroHoraVuelta"
										listKey="key" listValue="value"
										headerKey="" headerValue="%{getText('lang.trenes.reserva.todosLosHorarios')}"
										/>	

								</label>
							</div>
							<div class="grupo-formulario-10">
								<label for="hora-ida">
									<s:property value="getText('lang.trenes.disponibilidad.duracionMaxima')"/>:
									<br>
									<s:select label="hora-ida" 
										list="listaDuraciones" 
										id="filtroDuracion" name="filtroDuracion"
										listKey="key" listValue="value"
										headerKey="" headerValue="%{getText('lang.trenes.disponibilidad.todas')}"
										/>	

								</label>
							</div>
						
							<div class="separador"></div>
							<div class="grupo-formulario-10">
								<label for="hora-vuelta">
    								<s:property value="getText('lang.trenes.precio')"/> <s:property value="getText('lang.trenes.reserva.desde')"/>:
									<br>
									<s:select label="hora-vuelta" 
										list="listaPrecios" 
										id="filtroPrecioDesde" name="filtroPrecioDesde"
										listKey="key" listValue="value + ' &euro;'"
										headerKey="" headerValue="%{getText('lang.trenes.disponibilidad.todos')}"
										/>	

							    </label>
							</div>
							<div class="grupo-formulario-10">
								<label for="hora-vuelta">
    								<s:property value="getText('lang.trenes.precio')"/> <s:property value="getText('lang.trenes.hasta')"/>::
									<br>
									<s:select label="hora-vuelta" 
										list="listaPrecios" 
										id="filtroPrecioHasta" name="filtroPrecioHasta"
										listKey="key" listValue="value + ' &euro;'"
										headerKey="" headerValue="%{getText('lang.trenes.disponibilidad.todos')}"
										/>	

							    </label>
							</div>
							<div class="separador"></div>
					</fieldset>
					<table class="tablaBotonera">
					<tr><td>
						<div class="zona-izda-1" >
							<div id="botonesFiltro" class="zona-centrada-6">
								<div class="boton-1-izda"></div>
									<button type="button" class="boton-8 filtrar" onclick="javascript: getFiltrado();"><s:property value="getText('lang.trenes.filtrar')"/></button>
								<div class="boton-1-dcha"></div>
							</div>
						</div>
					</td>
					<td>
						<div class="zona-izda-1">
							<div class="zona-centrada-5">
								<div class="boton-1-izda"></div>
									<button type="button" class="boton-8 noFiltrar"  onclick="javascript: removeFiltrado();"><s:property value="getText('lang.trenes.limpiar')"/></button>
								<div class="boton-1-dcha"></div>
							</div>
						</div>
					</td></tr>
					</table>
				</div>
				</s:form>  
			</div>
            </s:if>
            
 <!-- eduard 20110504 -->	              
<div id="calendar" class="capa-flotante capa-flotante-3" style="font-size: 1em;display:none">
</div>

<div class="capa-flotante capa-flotante-1 contenido-box" id="over" style="font-size: 1em;">
	<div class="encabezado-1">
	    <div class="titulo-1">Halcón Viajes</div>
	</div>
	<a id="cerrarOver" class="cerrar" title="Cerrar Ventana" href="#"></a>                
	<div class="separador-3"></div>
	<div class="contenido-flotante">
		<p>&nbsp;</p>
		<div class="contenedor-boton-3 zona-centrada-3">
		    <div class="boton-1-izda"></div>
		        <button id="aceptarOver" class="boton-1" type="button"><s:property value="getText('lang.gen.aceptar')"/></button>
		    <div class="boton-1-dcha"></div>                                        
		</div>          
	</div>
</div>
<div class="capa-flotante capa-flotante-1 contenido-box" id="capaLupa" style="display: none; z-index: 5000; height:auto;width: auto;"></div>
 <!--end eduard 20110504 -->

<script type="text/javascript">
/*var currentTime;
var currentMonth;
var currentDay;
var currentYear;
var currentTimeInt;*/
var currentProvOri='';
var oriBool=false;
var currentProvDes='';
var desBool=false;
var options;
var trenProvOrigen,trenProvDestino, trenEstOri, trenEstDest;


$j('#provinciaOrigen').focus(function(){
	currentProvOri=$j('#provinciaOrigen').val();
});

$j('#provinciaOrigen').blur(function(){
	//alert("boolean: " + (($j('#provinciaOrigen').val()!=currentProvOri)&& !oriBool)+" input="+$j('#provinciaOrigen').val()+"  variable="+currentProvOri + ' oriBoool='+ oriBool);
	if(($j('#provinciaOrigen').val()!=currentProvOri) && !oriBool){
		$j('#provinciaOrigenKey').val('');
		$j('#destinosOrigenKey').val();
	}
	oriBool=false;
});
$j('#provinciaDestino').focus(function(){
	currentProvOri=$j('#provinciaDestino').val();
});

$j('#provinciaDestino').blur(function(){
	//alert("boolean: " + (($j('#provinciaDestino').val()!=currentProvDes)&& !desBool)+" input="+$j('#provinciaDestino').val()+"  variable="+currentProvDes + ' desBool='+ desBool);
	if(($j('#provinciaDestino').val()!=currentProvDes) && !desBool){
		$j('#provinciaDestinoKey').val('');
		$j('#destinosDestinoKey').val();
	}
	desBool=false;
});


$j('#cargandoFiltro').center();
//inicio funcionalidad para calendario eduard 20110504
$j('#over').center();
$j("#cerrarOver,#aceptarOver").click(function(){
	hideLightBox('over','fade');
});
if($j('#formBuscador_soloIda').attr('checked')){
	$j('#formBuscador_fechaVuelta').css('backgroundColor','#E1E5E8');
	$j('#box-fecha-vuelta').css('opacity','0');
	$j('#formBuscador_fechaVuelta').attr('readOnly',true);	
}
$j('#formBuscador_soloIda').click(function(){
	if ($j(this).attr('checked')){
		$j('#formBuscador_fechaVuelta').css('backgroundColor','#E1E5E8');
		$j('#box-fecha-vuelta').css('opacity','0');
		//$j('#formBuscador_fechaVuelta').css('color','#E1E5E8');
		$j('#formBuscador_fechaVuelta').attr('readOnly',true);	
	}else{
		$j('#formBuscador_fechaVuelta').css('backgroundColor','#FFFFFF');
		$j('#box-fecha-vuelta').css('opacity','1');
		//$j('#formBuscador_fechaVuelta').css('color','#000000');
		$j('#formBuscador_fechaVuelta').attr('readOnly',false);	
	}
});

$j('#f_rangeStart_trigger,#f_rangeEnd_trigger,#formBuscador_fechaIda,#formBuscador_fechaVuelta').click(function(){
	muestraCalendario($j(this).attr('id'));	
});

function muestraCalendario(elemId){
	var url='<s:property value="getContextPath()"/>/apps/trenes/Calendario.html';
	if(elemId=='f_rangeEnd_trigger' || elemId == 'formBuscador_fechaVuelta' ){
		if($j('#formBuscador_soloIda').attr('checked')){
		return;
		}
		if($j('#formBuscador_fechaIda').attr('value')!=''){
			var mes;
			if($j('#formBuscador_fechaVuelta').attr('value')!=''){
				mes=$j('#formBuscador_fechaVuelta').attr('value');
			}else{
				mes=$j('#formBuscador_fechaIda').attr('value');
				$j('#formBuscador_fechaVuelta').val($j('#formBuscador_fechaVuelta').val());
			}
			url=url+'?fecIni='+$j('#formBuscador_fechaIda').attr('value')+'&fecFin='+$j('#formBuscador_fechaVuelta').attr('value')+'&mesSel=01/'+ mes.substring (3,10) +'&tipoCal=VUE';

		}else{
			$j('#over .contenido-flotante p').html('<s:property value="getText('lang.gen.calendario.avisoFechaIda')"/>');
			showLightBox('over','fade');
			return;
		}
	}else{
		var fechaVuelta = $j('#formBuscador_fechaVuelta').attr('value');
		if($j('#formBuscador_soloIda').attr('checked')){
			fechaVuelta="";
			}
		($j('#formBuscador_fechaIda').attr('value')!='')? url=url+'?fecIni='+$j('#formBuscador_fechaIda').attr('value')+'&fecFin='+fechaVuelta+'&mesSel=01/'+ $j('#formBuscador_fechaIda').attr('value').substring (3,10) : url=url;
	}
	
	$j('#calendar').load(url,function(){
		$j('#calendar').center();
		showLightBox('calendar','fade');
		});


	
}
function actualizaFechas(data,valor){
	if (data=='VUE'){
		$j('#formBuscador_fechaVuelta').attr('value',valor);
	}else{
		var vffin = $j('#formBuscador_fechaVuelta').attr('value')
		var ffin = new Date(vffin.split('/')[2],vffin.split('/')[1],vffin.split('/')[0]);
		var fini = new Date(valor.split('/')[2],valor.split('/')[1],valor.split('/')[0]);
		$j('#formBuscador_fechaIda').attr('value',valor);
		(fini>ffin)? $j('#formBuscador_fechaVuelta').attr('value',valor):$j('#formBuscador_fechaVuelta').attr('value');
		if ($j('#formBuscador_fechaVuelta').val()==''){
			$j('#formBuscador_fechaVuelta').val($j('#formBuscador_fechaIda').val());
		}
	}
	return;
}

function comprobarPasajeros(){
	var adultos=$j('#formBuscador_adultosKey').val();
	var ninos=$j('#formBuscador_ninosKey').val();
	if(((adultos/1)+(ninos/1))>9){
		confirm("<s:property value="getText('lang.trenes.disponibilidad.plazasSobrepasadas')"/>")
		$j('#formBuscador_ninosKey').val('0');
	}
}

function buscar (){
	
	if($j('#provinciaOrigen').val()==''){
		confirm('<s:property value="getText('lang.trenes.disponibilidad.avisoOrigen')"/>');
		return;
	}
	if($j('#formBuscador_fechaIda').val()==''){
		confirm('<s:property value="getText('lang.trenes.disponibilidad.avisoFechaIda')"/>');
		return;
	}
	if($j('#formBuscador_soloIda').attr('checked')==false && $j('#provinciaDestino').val()==''){
		confirm('<s:property value="getText('lang.trenes.disponibilidad.avisoDestino')"/>');
		return;
	}
	if($j('#formBuscador_soloIda').attr('checked')==false && $j('#formBuscador_fechaVuelta').val()==''){
		confirm('<s:property value="getText('lang.trenes.disponibilidad.avisoFechaVuelta')"/>');
		return;
	}
	var oriIni='<s:property value="provinciaOrigen"/>';
	var oriIniKey='<s:property value="provinciaOrigenKey"/>';
	var oriDestKey='<s:property value="destinosOrigenKey"/>';
	var desIni='<s:property value="provinciaDestino"/>';
	var desIniKey='<s:property value="provinciaDestinoKey"/>';
	var desDestKey='<s:property value="destinosDestinoKey"/>';
	if($j('#provinciaOrigen').val()!=oriIni && $j('#provinciaOrigenKey').val()==oriIniKey && $j('#destinosOrigenKey').val()== oriDestKey ){
		$j('#provinciaOrigenKey').val('');
		$j('#destinosOrigenKey').val();
		}
	if($j('#provinciaDestino').val()!=desIni && $j('#provinciaDestinoKey').val()==desIniKey && $j('#destinosDestinoKey').val()== desDestKey ){
		$j('#provinciaOrigenKey').val('');
		$j('#destinosOrigenKey').val();
		}
	var contenidoCargando;
	contenidoCargando='<s:property value="getText('lang.gen.pantallaCarga.estamosComprobando')"/><br>';
	contenidoCargando+='<s:property value="getText('lang.gen.pantallaCarga.mejoresPrecios')"/><br>';
	
	setContenidoCargando(contenidoCargando,20);
	showCargando('capaCargandoV2');
	var o=$j('#provinciaOrigenKey').val();
	var de=$j('#provinciaDestinoKey').val();
	$j('#formBuscador').submit();
}
// fin funcionalidad para calendario





	$j(document).ready(function(){
		$j(function(){
			  options = { 
					serviceUrl:'AutocompleteFieldJson.html', 
				    minChars:0, 
				    delimiter: /(,|;)\s*/, // regex or character
				    maxHeight:400,
				    width:300,
				    maxHeightFactor:18,
				    widthFactor:7,
				    zIndex: 9999,
				    deferRequestBy: 250, //miliseconds
				    //params: { country:'Yes' }, //aditional parameters
				    noCache: true, //default is false, set to true to disable caching
				    fixedHeight: true,
				    // callback function:
				    onSelect: function(value, data){ setTrenesIda(value,data); }
				    // local autosugest options:
				    //lookup: ['January', 'February', 'March', 'April', 'May'] //local lookup 
				};
			  trenProvOrigen = $j('#provinciaOrigen').autocomplete(options);
			  trenProvDestino = $j('#provinciaDestino').autocomplete(options);
			  trenEstOri =$j('#destinosOrigen').autocomplete(options);
			  trenEstDest =$j('#destinosDestino').autocomplete(options);

			  trenProvDestino.setOptions({ onSelect: function(value, data){ setTrenesVuelta(value,data); } });
			  trenEstOri.setOptions({ onSelect: function(value, data){ setTrenesIdaEst(value,data); } });
			  trenEstDest.setOptions({ onSelect: function(value, data){ setTrenesVueltaEst(value,data); } });

			});

		$j("#filtroPrecioDesde option").each(function(i){
			$j(this).html($j(this).html().replace('&amp;euro;','&euro;'));
	    });
		$j("#filtroPrecioHasta option").each(function(i){
			$j(this).html($j(this).html().replace('&amp;euro;','&euro;'));
	    });
		//add lupa click
		  /*
		  $j('#lupaTrenIda').click(function() {
			  $j.post('/trenesApp/apps/trenes/lupa.html','' , function(data) {

				  $j('#capaLupa').html(data);
				  $j('#capaLupa').center();	
				  showLightBox('capaLupa','fade');
				});
			});
		  $j('#lupaTrenVuelta').click(function() {
			  if($j('#provinciaOrigenKey').val()!=''){
			  $j.post('/trenesApp/apps/trenes/lupa.html',$j('#formBuscador').serialize() , function(data) {
				  $j('#capaLupa').html(data);
				  $j('#capaLupa').center();	
				  showLightBox('capaLupa','fade');
			 	  
				});
			  }
			});
		*/
			///Select
		  
		  $j('#trenProvinciaOrigenSelect').click(function() {
			  trenProvDestino.hide();
			  delDetino();
			  if(trenProvOrigen.container.css('display')=='block'){
			  	trenProvOrigen.hide();
			  }else {
			  	trenProvOrigen.enabled=true;
			  	trenProvOrigen.ignoreValueChange=false;
			  	trenProvOrigen.onKeyPress('*');
			  	trenProvOrigen.onKeyUp('*');
			  }
			});
		  $j('#trenProvinciaDestinoSelect').click(function() {
			  trenProvOrigen.hide();
			  if(trenProvDestino.container.css('display')=='block'){
				  	trenProvDestino.hide();
				  }else {
					  if($j('#provinciaOrigenKey').val()!=''){
						setKeysValues();
						trenProvDestino.enabled=true;
						trenProvDestino.ignoreValueChange=false;
						trenProvDestino.onKeyPress('*');
						trenProvDestino.onKeyUp('*');
					  }
				  }
			});
		
	}); 
	function setTrenesIda(value,data){
		var dat=data.split("##");
		oriBool=true;
		if (dat.length>1){
			$j('#provinciaOrigenKey').val(dat[0]);
			$j('#destinosOrigenKey').val(dat[1]);
		}else{
			$j('#provinciaOrigenKey').val(data);
			$j('#destinosOrigenKey').val('');
		}
		
	}
	function stripTags(data) { 
		return data.replaceWith( data.html().replace(/<\/?[^>]+>/gi, '') ); 
	}
	function setTrenesVuelta(value,data){
		var dat=data.split("##");
		desBool=true;
		if (dat.length>1){
			$j('#provinciaDestinoKey').val(dat[0]);
			$j('#destinosDestinoKey').val(dat[1]);
		}else{
			$j('#provinciaDestinoKey').val(data);
			$j('#destinosDestinoKey').val('');
		}
	}
	function setTrenesIdaEst(value,data){
		$j('#destinosOrigenKey').val(data);
	}

	function setTrenesVueltaEst(value,data){
		$j('#destinosDestinoKey').val(data);
	}
	function setKeysValues(){
		trenEstOri.setOptions({ params: { destino:'estacionOrigen', provinciaOrigenKey:$j('#provinciaOrigenKey').val() } });
		trenProvDestino.setOptions({ params: { destino:'provinciaDestino', provinciaOrigenKey:$j('#provinciaOrigenKey').val(),destinosOrigenKey:$j('#destinosOrigenKey').val()  } });
		trenEstDest.setOptions({ params: { destino:'estacionDestino', provinciaOrigenKey:$j('#provinciaDestinoKey').val(),provinciaDestinoKey:$j('#provinciaDestinoKey').val(),destinosOrigen:$j('#destinosOrigenKey').val() } });
		
	}

	function delDetino(){
		$j('#provinciaDestinoKey').val('');
		$j('#destinosDestinoKey').val('');
		$j('#provinciaDestino').val('');		
	}
	function delOrigenIfBlank(){
		if($j('#provinciaOrigen').val()==''){
			$j('#provinciaOrigenKey').val('');
			$j('#destinosOrigenKey').val('');
		}		
		tryToGetProvincia();
	}
	function delDestinoIfBlank(){
		if($j('#provinciaDestino').val()==''){
			$j('#provinciaDestinoKey').val('');
			$j('#destinosDestinoKey').val('');
		}		
		tryToGetProvincia();
	}
	function tryToGetProvincia(){
		var i, len,s,d;
	    len = trenProvOrigen.suggestions.length;
	    var current=$j('#provinciaOrigen').val();
	    for (i = 0; i < len; i++) {
	      s = trenProvOrigen.suggestions[i];
		  if (s.toUpperCase()==current.toUpperCase()){
			  d= trenProvOrigen.data[i];
			  setTrenesIda(s,d);
			  break;
		  }
	    }
	    len = trenProvDestino.suggestions.length;
	    current=$j('#provinciaDestino').val();
	    for (i = 0; i < len; i++) {
	      s = trenProvDestino.suggestions[i];
		  if (s.toUpperCase()==current.toUpperCase()){
			  d= trenProvDestino.data[i];
			  setTrenesVuelta(s,d);
			  break;
		  }
	    }
	}
	function submitenter(myfield,e){
			var keycode;
			if (window.event) keycode = window.event.keyCode;
			else if (e) keycode = e.which;
			else return true;
		
			if (keycode == 13){
				tryToGetProvincia();
				if($j('#provinciaOrigen').val()==''){
					return true;;
				}
				if($j('#formBuscador_fechaIda').val()==''){
					return true;;
				}
				if($j('#formBuscador_soloIda').attr('checked')==false && $j('#provinciaDestino').val()==''){
					return true;;
				}
				if($j('#formBuscador_soloIda').attr('checked')==false && $j('#formBuscador_fechaVuelta').val()==''){
					return true;;
				}
				
				buscar();
			   	return false;
			   }
			else
			   return true;
		}
		
	$j(document).ready(function(){
		 <s:iterator value="cookiesMapPut" >
		 	setCookieValue('<s:property value="key"/>','<s:property value="value"/>');
		 </s:iterator>
	});

	
</script>
