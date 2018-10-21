<%@ taglib prefix="s" uri="/struts-tags" %>
<s:form id="pasajeros" action="Pago">
                    	<fieldset id="Datos del Comprador">
                            <div class="caja-contenido">
                                <div class="cabecera">
									<h2 class="titulo1">1. <s:property value="getText('lang.trenes.pasajeros.datosComprador')"/></h2>                                    
                                </div>                                
                                <div class="separador-contenido"></div>
                                <div class="area-contenido">
                                    <p class="destacado-2">
                                    	<strong><s:property value="getText('lang.trenes.pasajeros.introducirCorreo')"/></strong>. <s:property value="getText('lang.trenes.pasajeros.textoAdvertenciaCorreo')"/>
									</p>                                	
	                                <div class="agrupa-datos-1">                                
                                        <div class="grupo-formulario-1">
                                            <label for="email-comprador">
                                                <s:property value="getText('lang.gen.email')"/>
                                                <s:textfield id="emailComprador" cssClass="campo-texto-9" name="emailComprador" maxlength="100"/>
                                             </label>
                                        </div>                                    
                                        <div class="grupo-formulario-2">
                                            <label for="telefono">
                                                <s:property value="getText('lang.gen.telefono')"/>
                                               <s:textfield id="telefono" cssClass="ccampo-texto-1" name="telefono" filtro="numerico" maxlength="50"/>

                                            </label>                                        
                                        </div> 
                                	</div>                                                                              
                                </div>                        
                            </div>
	                        <div class="caja-contenido-inferior"></div>     
						</fieldset> 
                        <fieldset id="Datos de Pasajeros">
                            <div class="caja-contenido">
                                <div class="cabecera">
                                    <h2 class="titulo1">2. <s:property value="getText('lang.trenes.pasajeros.datosPasajeros')"/></h2>
                                </div>                                
                                <div class="separador-contenido"></div>

                                <s:iterator var="adultos" value="listaAdultos" status="adultosStat"  >
                               			<s:if test="#adultosStat.index==0">
		                                	<div class="area-contenido">
		                                    <p class="destacado-2">
		                                    	<s:property value="getText('lang.trenes.pasajeros.textoDatosNombre')"/>
											</p>                                   	
		        						</s:if>
		        						
		        							<div class="agrupa-datos-1">
		                                        <p class="etiqueta-3"><s:property value="getText('lang.trenes.reserva.adulto')"/> <s:property value="#adultos" /></p>
		                                        <div class="grupo-formulario-5">
		                                            <label for="nombre-pasajero-1">
		                                                <s:property value="getText('lang.gen.nombre')"/>
		                                                <s:textfield id="%{'nombrePasajero_'+#adultos}" cssClass="campo-texto-2" name="%{'nombrePasajero_'+#adultos}" maxlength="50" />                                       
		                                            </label>
		                                        </div>                                    
		                                        <div class="grupo-formulario-5">
		                                            <label for="primer-apellido-pasajero-1">
		                                                <s:property value="getText('lang.gen.primerApellido')"/>
		                                                <s:textfield id="%{'pirmerApellidoPasajero_'+#adultos}" cssClass="campo-texto-2" name="%{'pirmerApellidoPasajero_'+#adultos}" maxlength="50"/>
		                                            </label>                                        
		                                        </div>
		                                        <div class="grupo-formulario-6">
		                                            <label for="segundo-apellido-pasajero-1">
		                                                <s:property value="getText('lang.gen.segundoApellido')"/>
		                                                <s:textfield id="%{'segundoApellidoPasajero_'+#adultos}" cssClass="campo-texto-2" name="%{'segundoApellidoPasajero_'+#adultos}" maxlength="50"/>
		                                            </label>                                        
		                                        </div>                                         
		                                    </div>        
		        							<div class="agrupa-datos-1">
		                                        <div class="grupo-formulario-5">
		                                            <label for="tipo-documento-1">
		                                                <s:property value="getText('lang.gen.identificacion')"/>
		                                            <!--s:select label="hora-ida" 
															list="arrayTipoIdentificacion" 
															name="%{'tipoDocumentoPasajero_'+#adultos}"
															id="%{'tipoDocumentoPasajero_'+#adultos}"
															cssClass="seleccionable-5"/-->
													<s:select label="hora-ida" 
															list="treeTipoIdentificacion" 
															name="%{'tipoDocumentoPasajero_'+#adultos}"
															id="%{'tipoDocumentoPasajero_'+#adultos}"
															cssClass="seleccionable-5"
															onblur="testDoc(this)"
															/>	
										
		                                            </label>
												</div>
												<div class="grupo-formulario-5">
		                                            <label for="numero-documento-1">
		                                                <s:property value="getText('lang.gen.numero')"/>
														<span class="info-adicional">(<s:property value="getText('lang.gen.DNI')"/>, <s:property value="getText('lang.gen.CIF')"/>, <s:property value="getText('lang.gen.pasaporte')"/>)</span>
														<br />
		                                                <s:textfield id="%{'numDocPasajero_'+#adultos}" onblur="testDoc(this)" cssClass="campo-texto-2" name="%{'numDocPasajero_'+#adultos}" maxlength="30"/>
		                                            </label>                                        
		                                        </div>
		                                        <div class="grupo-formulario-6">
		                                            <label for="fecha-nacimiento">
		                                                <s:property value="getText('lang.gen.fechaNacimiento')"/>
		                                                <span class="info-adicional">(dd/mm/aaaa)</span>
		                                                <br />
		                                                <s:textfield id="%{'diaNacimientoPasajero_'+#adultos}" cssClass="campo-texto-6" name="%{'diaNacimientoPasajero_'+#adultos}" filtro="numerico" maxlength="2" />
		                                                <s:textfield id="%{'mesNacimientoPasajero_'+#adultos}" cssClass="campo-texto-6" name="%{'mesNacimientoPasajero_'+#adultos}"  filtro="numerico" maxlength="2"/>
		                                                <s:textfield id="%{'anyoNacimientoPasajero_'+#adultos}" cssClass="campo-texto-6" name="%{'anyoNacimientoPasajero_'+#adultos}"  filtro="numerico" maxlength="4"/>
		
		                                            </label>                                        
		                                        </div>
		                                    </div>
										 <div class="separador-contenido"></div>
		                                                                   
                                 </s:iterator> 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                <s:iterator var="ninos" value="listaNinos" status="ninosStat"  >
  						
		        							<div class="agrupa-datos-1">
		                                        <p class="etiqueta-3"> <s:property value="getText('lang.gen.nino')"/> <s:property value="#ninos" /></p>
		                                        <div class="grupo-formulario-5">
		                                            <label for="nombre-pasajero-1">
		                                                <s:property value="getText('lang.gen.nombre')"/>
		                                                <s:textfield id="%{'nombrePasajeroN_'+#ninos}" cssClass="campo-texto-2" name="%{'nombrePasajeroN_'+#ninos}" maxlength="50"/>                                       
		                                            </label>
		                                        </div>                                    
		                                        <div class="grupo-formulario-5">
		                                            <label for="primer-apellido-pasajero-1">
		                                                <s:property value="getText('lang.gen.primerApellido')"/>
		                                                <s:textfield id="%{'pirmerApellidoPasajeroN_'+#ninos}" cssClass="campo-texto-2" name="%{'pirmerApellidoPasajeroN_'+#ninos}" maxlength="50"/>
		                                            </label>                                        
		                                        </div>
		                                        <div class="grupo-formulario-6">
		                                            <label for="segundo-apellido-pasajero-1">
		                                                <s:property value="getText('lang.gen.segundoApellido')"/>
		                                                <s:textfield id="%{'segundoApellidoPasajeroN_'+#ninos}" cssClass="campo-texto-2" name="%{'segundoApellidoPasajeroN_'+#ninos}" maxlength="50"/>
		                                            </label>                                        
		                                        </div>                                         
		                                    </div>        
		        							<div class="agrupa-datos-1">
		                                        <div class="grupo-formulario-5">
		                                            <label for="tipo-documento-1">
		                                                <s:property value="getText('lang.gen.identificacion')"/>
		                                            	<s:select label="hora-ida" 
															list="treeTipoIdentificacion" 
															name="%{'tipoDocumentoPasajeroN_'+#ninos}"
															id="%{'tipoDocumentoPasajeroN_'+#ninos}"
															cssClass="seleccionable-5"
															onblur="testDocN(this)"/>	
										
                                    
		                                            </label>
												</div>
												<div class="grupo-formulario-5">
		                                            <label for="numero-documento-1">
		                                                <s:property value="getText('lang.gen.numero')"/>
														<span class="info-adicional">(<s:property value="getText('lang.gen.DNI')"/>, <s:property value="getText('lang.gen.CIF')"/>, <s:property value="getText('lang.gen.pasaporte')"/>)</span>
														<br />
		                                                <s:textfield id="%{'numDocPasajeroN_'+#ninos}" onblur="testDocN(this)" cssClass="campo-texto-2" name="%{'numDocPasajeroN_'+#ninos}" maxlength="30"/>
		                                            </label>                                        
		                                        </div>
		                                        <div class="grupo-formulario-6">
		                                            <label for="fecha-nacimiento">
		                                                <s:property value="getText('lang.gen.fechaNacimiento')"/>
		                                                <span class="info-adicional">(dd/mm/aaaa)</span>
		                                                <br />
		                                                <s:textfield id="%{'diaNacimientoPasajeroN_'+#ninos}" cssClass="campo-texto-6" name="%{'diaNacimientoPasajeroN_'+#ninos}" filtro="numerico" maxlength="2" />
		                                                <s:textfield id="%{'mesNacimientoPasajeroN_'+#ninos}" cssClass="campo-texto-6" name="%{'mesNacimientoPasajeroN_'+#ninos}" filtro="numerico" maxlength="2" />
		                                                <s:textfield id="%{'anyoNacimientoPasajeroN_'+#ninos}" cssClass="campo-texto-6" name="%{'anyoNacimientoPasajeroN_'+#ninos}" filtro="numerico" maxlength="4" />
		
		                                            </label>                                        
		                                        </div>
		                                    </div>
										 <div class="separador-contenido"></div>
		                                                                   
                                 </s:iterator> 
                                 </div>  
                                                     
                            </div>
                        	<div class="caja-contenido-inferior"></div>     
						</fieldset>	
                        <fieldset id="Datos adicionales" class="agrupa-datos-7">
                        	<div class="contenedor-boton-1" style="margin:0 20px 10px 0">
								<div class="boton-1-izda" ></div>
									<button class="boton-1" type="button" id="volver"><s:property value="getText('lang.gen.volver')"/> </button>
								<div class="boton-1-dcha"></div>
							</div>	
                            <s:checkbox  id="aceptaLOPD" name="aceptaLOPD" />
                            <s:property value="getText('lang.trenes.pasajeros.preAceptarLOPD')"/>
                             <a class="enlace-2" href="<s:property value="getContextPath()"/>/static/trenes/proteccionDatos.html" id="enlacePoliticaProteccionDatos" title="Política de Protección de Datos Halcón Viajes" target="_blank">
                            	<s:property value="getText('lang.trenes.pasajeros.aceptarLOPD')"/>
                            </a>
                            <s:property value="getText('lang.trenes.pasajeros.postAceptarLOPD')"/>
                            <div class="contenedor-boton-2">
                            <div class="boton-1-izda"></div>
                                <button type="button" class="boton-1" onclick="javascript: submitForm();"><s:property value="getText('lang.gen.continuar')"/></button>
                            <div class="boton-1-dcha"></div>                                        
                        </div>                                 
                        </fieldset>   
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
							 <s:textfield id="criteria" name="criteria" />       
							</div>                                                                     
					<div class="limpiar"></div>
					<div class="agrupa-datos-2">
						<p><strong><s:property value="getText('lang.gen.condiciones')"/></strong></p>
						<p><s:property value="getText('lang.trenes.pasajeros.avisoConfirmacionReserva')"/> <a class="enlace-2 cargaAjax" href="#" id="enlaceCondicionesGenerales" title="Condiciones Generales Reservas Halcón Viajes"><s:property value="getText('lang.gen.condicionesGenerales')"/></a>. <s:property value="getText('lang.trenes.pasajeros.textoCondicionesReserva')"/> <a class="enlace-2" href="<s:property value="getContextPath()"/>/static/trenes/proteccionDatos.html" id="enlacePoliticaProteccionDatos" title="Política de Protección de Datos Halcón Viajes" target="_blank"><s:property value="getText('lang.trenes.politicaProteccionDatos')"/></a>. <s:property value="getText('lang.trenes.pasajeros.textoPoliticaProteccionDatos')"/></p>
						<div class="espacio-vertical-2"></div>					
					</div>
					<fieldset id="Datos adicionales" class="agrupa-datos-8">
                        <s:checkbox id="deseaInfo" name="deseaInfo" /><s:property value="getText('lang.trenes.pasajeros.quieroInfo')"/>
                    </fieldset>   
				</s:form>


<div id="ajaxCargado"></div>
<div id="error"></div>
<input type="hidden" id="msgLOP" name="msgLOP" value="<s:property value="getText('lang.trenes.pasajeros.politica')"/>"/>							
<script type="text/javascript">
$j("#volver").click(function(){
	history.go(-1);
});
$j("#enlaceCondicionesGenerales").click(function(event){event.preventDefault();$j("#divCondicionesGenerales").show();});

$j(".cargaAjax").click(function(event){
	event.preventDefault();
	$j("#ajaxCargado").load('<s:property value="getContextPath()"/>/static/trenes/condicionesGenerales_<s:property value='strLocale'/>.html');
	$j("#ajaxCargado").center();
	$j("#ajaxCargado").show();
});

function cargarCondiciones(tar){
	$j("#ajaxCargado").html('');
	var tarifa= tar.replace('##','');
	$j.ajax({
        type: 'POST',
        url:'/trenesApp/static/trenes/cond_<s:property value='strLocale'/>_'+tarifa+'.html',
        success: function(data){
			$j("#ajaxCargado").html(data);
			$j("#ajaxCargado").center();
			$j("#ajaxCargado").show();
        	},
        error: function(){
        		$j("#ajaxCargado").load('/trenesApp/static/trenes/condiciones_<s:property value='strLocale'/>.html');
        		$j("#ajaxCargado").center();
        		$j("#ajaxCargado").show();
                }
    	});
		
	} 
/*$j('#error').ajaxError(function(e, jqxhr, settings, exception) {
	var error=settings.url;
	alert(error);
	//if(settings.url)
	$j("#ajaxCargado").load('/trenesApp/static/trenes/condiciones_<s:property value='strLocale'/>.html');
	$j("#ajaxCargado").center();
	$j("#ajaxCargado").show();
});*/
$j('.cerrar').live('click', function (){
	$j("#ajaxCargado").hide();
});

var confirmarForm='pasajeros';
var textoRequerido='<s:property value="getText('lang.trenes.pago.requerido')" />';
var textoDiaRequerido='<s:property value="getText('lang.trenes.pago.diaRequerido')"/>';
var textoMesRequerido='<s:property value="getText('lang.trenes.pago.mesRequerido')"/>';
var textoAnyoRequerido='<s:property value="getText('lang.trenes.pago.anoRequerido')" />';
var textoLongitudMinima='<s:property value="getText('lang.trenes.pago.longitudMinima')"/>';
var textoTelefono='<s:property value="getText('lang.trenes.pago.telefonoNoValido')"/>';
var textoFecha='<s:property value="getText('lang.trenes.pago.fechaNoValida')"/>';
var textoDocuNoValido='<s:property value="getText('lang.trenes.pago.textoDocuNoValido')"/>';
var validator;


function submitForm(){
	
	validarFechas();
	if (!validarPoliticaLOPD()){
		confirm('<s:property value="getText('lang.trenes.pasajeros.politica')"/>',function(){});
		return false;
	}
	var params=$j('#'+confirmarForm).serialize();
	$j('#criteria').val($j('#'+confirmarForm).serialize());
	var action=$j('#'+confirmarForm).attr('action'); 
	if (action.indexOf('<s:property value="getHttpsDomain()"/>')<0){
		action='<s:property value="getHttpsDomain()"/>'+action;
	}
	$j('#'+confirmarForm).attr("action",action); 

	var contenidoCargando;
	contenidoCargando='<s:property value="getText('lang.gen.pantallaCarga.comprobandoDatos')"/>';	
	setContenidoCargando(contenidoCargando,20);

	showCargando("capaCargandoV2");
	$j('#'+confirmarForm).submit();
}
function callbackHideCargando(){
	hideCargando("capaCargandoV2");
	confirm ('<s:property value="getText('lang.trenes.pasajeros.faltanDatosformulario')"/>');
	
}
function validarPoliticaLOPD(){
	var check=$j('#aceptaLOPD').attr('checked');
	if($j('#aceptaLOPD').attr('checked')){
		return true;}
	else{
		return false;}
}
function validarFechaNinos(id){
	try{
		anyo=$j('#anyoNacimientoPasajeroN_'+id).val();
		mes=$j('#mesNacimientoPasajeroN_'+id).val();
		if (mes.length==1){
			mes="0"+mes;}
		dia=$j('#diaNacimientoPasajeroN_'+id).val();
		if (dia.length==1){
			dia="0"+dia;}

		if ($j('#anyoNacimientoPasajeroN_'+id).val()!='' && $j('#mesNacimientoPasajeroN_'+id).val()!='' && $j('#diaNacimientoPasajeroN_'+id).val()!=''){
			dateToInt=anyo+mes+dia;
			
			var minAnyo='<s:property value="getMinAnyoNinos()"/>';
			if (minAnyo!=''){
				var iMinAnyo=minAnyo/1;	
				var iAnyo=dateToInt/1;
				if (iAnyo<=iMinAnyo){
					confirm ('<s:property value="getText('lang.trenes.pasajeros.NoEsNino')"/> ');
					//return false;
				}
			}
			return validarFecha(dia, mes, anyo);
		}
	}catch (err){
		//alert(err);
	}
}
function validarFechaAdultos(id){
	anyo=$j('#anyoNacimientoPasajero_'+id).val();
	mes=$j('#mesNacimientoPasajero_'+id).val();
	dia=$j('#diaNacimientoPasajero_'+id).val();

	return validarFecha(dia, mes, anyo);

}
function validarFechaNinosForm(id){
	anyo=$j('#anyoNacimientoPasajeroN_'+id).val();
	mes=$j('#mesNacimientoPasajeroN_'+id).val();
	dia=$j('#diaNacimientoPasajeroN_'+id).val();

	return validarFecha(dia, mes, anyo);

}

function validarFecha(dia, mes, anyo){
	if (dia!='' && mes!='' && anyo!=''){
		if (!isNaN(dia/1) && !isNaN(mes/1) && !isNaN(anyo)){
			if(mes>12||mes<1){return false;}
			if(anyo<1900){return false;}
			if(dia>31 || dia<1){return false;}
			var days=new Array();
			days[1]=31;
			days[2]=29;
			days[3]=31;
			days[4]=30;
			days[5]=31;
			days[6]=30;
			days[7]=30;
			days[8]=30;
			days[9]=30;
			days[0]=31;
			days[11]=30;
			days[12]=31;
			dia=dia/1;
			mes=mes/1;

			if (dia>days[mes]){
				return false;
			}else{
			return true;}
		}
		else{
			
			return false;
			}
	}else{
	
	return false;
	}
	
}
function validarFechas(){
	<s:iterator var="adultos" value="listaAdultos" status="adultosStat">
		validarFechaAdultos(<s:property value="#adultos" />);
	</s:iterator>
	<s:iterator var="ninos" value="listaNinos" status="ninosStat"  >
		validarFechaAdultos(<s:property value="#ninos" />);
	</s:iterator>
	}
$j(document).ready(function(){//valida_nif_cif_nie
	<s:iterator var="ninos" value="listaNinos" status="ninosStat"  >
		$('#diaNacimientoPasajeroN_<s:property value="#ninos" />').blur(function() {
			validarFechaNinos(<s:property value="#ninos" />);
		});
	
		$('#mesNacimientoPasajeroN_<s:property value="#ninos" />').blur(function() {
			validarFechaNinos(<s:property value="#ninos" />);
		});

		$('#anyoNacimientoPasajeroN_<s:property value="#ninos" />').blur(function() {
			validarFechaNinos(<s:property value="#ninos" />);
			});
	</s:iterator>


	$j("select[class='seleccionable-5']").live('change',function(){
		$j('#'+confirmarForm).validate().element("#numDocPasajero_"+this.id.split('_')[1]);	
		});
	$j.validator.addMethod('fechaValida', function(value,element) {
		var dia=$("#diaNacimientoPasajero_"+element.id.split('_')[1]).attr('value');
		var mes=$("#mesNacimientoPasajero_"+element.id.split('_')[1]).attr('value');
		var anyo=$("#anyoNacimientoPasajero_"+element.id.split('_')[1]).attr('value');
		try{
			var fecha = new Date(anyo,mes,dia);
			return true;
		}catch(e){
			return false;
		}
		});
	
	$j.validator.addMethod('documento', function(value,element) {
		if($j("#tipoDocumentoPasajero_"+element.id.split('_')[1]).attr("value").substring(1)=='Pasaporte'){
			return true;}
		var retorno=(valida_nif_cif_nie(value)<1)?false:true;	 
		return retorno;});
	$j.validator.addMethod('telefono', function(value) { 
		return (value.match(/^((\+)?[1-9]{1,9})?([-\s\.])?((\(\d{1,4}\))|\d{1,4})(([-\s\.])?[0-9]{1,12}){1,9}(\s*(ext|x)\s*\.?:?\s*([0-9]+))?$/)); }, textoTelefono);
	$j.validator.addMethod('fecha', function(value,element) {
		var tipo = (element.id.indexOf("PasajeroN")==-1)?validarFechaAdultos(element.id.split('_')[1]):validarFechaNinosForm(element.id.split('_')[1])
		return tipo;});
	
	validator=$j('#'+confirmarForm).validate({
		   invalidHandler:callbackHideCargando,
		   rules: {
		 	emailComprador: {
		       required: true,
		       email: true
		     },
			telefono: {
		       required: true,
		       telefono: true
		     },
		 	<s:iterator var="adultos" value="listaAdultos" status="adultosStat"  >
		     nombrePasajero_<s:property value="#adultos" />:{
			     	required: true},
		     pirmerApellidoPasajero_<s:property value="#adultos" />:{
				    required: true},
		     tipoDocumentoPasajero_<s:property value="#adultos" />:{
					required: true},
		     numDocPasajero_<s:property value="#adultos" />:{
					required: true,
					documento:true
					},
		     diaNacimientoPasajero_<s:property value="#adultos" />:{
					required: true, 
					minlength: 2},
		     mesNacimientoPasajero_<s:property value="#adultos" />:{
					required: true, 
					minlength: 2},
		     anyoNacimientoPasajero_<s:property value="#adultos" />:{
					required: true, 
					minlength: 4,
					fecha:true
					}<s:if test="!#adultosStat.last || !listaNinos.size()==0">,</s:if>
	  	</s:iterator>
		<s:iterator var="ninos" value="listaNinos" status="ninosStat"  >
	     	nombrePasajeroN_<s:property value="#ninos" />:{
			     	required: true},
		     pirmerApellidoPasajeroN_<s:property value="#ninos" />:{
				    required: true},
		     diaNacimientoPasajeroN_<s:property value="#ninos" />:{
					required: true, 
					minlength: 2},
		     mesNacimientoPasajeroN_<s:property value="#ninos" />:{
					required: true, 
					minlength: 2},
		     anyoNacimientoPasajeroN_<s:property value="#ninos" />:{
					required: true, 
					minlength: 4,
					fecha:true}<s:if test="!#ninosStat.last">,</s:if>
 		</s:iterator>

		},
		
		messages: {         
				emailComprador: {             
				required: "Entra una dirección valida" ,
				email:"Entra una dirección valida"          
				},
				telefono: {             
						required: "Requerido"        
						},
				<s:iterator var="adultos" value="listaAdultos" status="adultosStat"  >
						nombrePasajero_<s:property value="#adultos" />: {required: textoRequerido},
						pirmerApellidoPasajero_<s:property value="#adultos" />: {required: textoRequerido},
						tipoDocumentoPasajero_<s:property value="#adultos" />: {required: textoRequerido},
						numDocPasajero_<s:property value="#adultos" />: {required: textoRequerido,documento:textoDocuNoValido},
						diaNacimientoPasajero_<s:property value="#adultos" />: {required: textoDiaRequerido,minlength: textoLongitudMinima},
						mesNacimientoPasajero_<s:property value="#adultos" />: {required: textoMesRequerido,minlength: textoLongitudMinima},
						anyoNacimientoPasajero_<s:property value="#adultos" />: {required: textoAnyoRequerido,minlength: textoLongitudMinima,fecha: textoFecha}<s:if test="!#adultosStat.last || !listaNinos.size()==0">,</s:if>
				</s:iterator>
				<s:iterator var="ninos" value="listaNinos" status="ninosStat"  >
						
						nombrePasajeroN_<s:property value="#ninos" />: {required: textoRequerido},
						pirmerApellidoPasajeroN_<s:property value="#ninos" />: {required: textoRequerido},
						tipoDocumentoPasajeroN_<s:property value="#ninos" />: {required: textoRequerido},
						numDocPasajeroN_<s:property value="#ninos" />: {required: textoRequerido},
						diaNacimientoPasajeroN_<s:property value="#ninos" />: {required: textoDiaRequerido,minlength: textoLongitudMinima},
						mesNacimientoPasajeroN_<s:property value="#ninos" />: {required: textoMesRequerido,minlength: textoLongitudMinima},
						anyoNacimientoPasajeroN_<s:property value="#ninos" />: {required: textoAnyoRequerido,minlength: textoLongitudMinima,fecha: textoFecha}<s:if test="!#ninosStat.last">,</s:if>
				</s:iterator>
		   }} );

	//Autotab
				<s:iterator var="adultos" value="listaAdultos" status="adultosStat"  >
					<s:if test="!#adultosStat.first">
						$j('#anyoNacimientoPasajero_<s:property value="#last" />').autotab({ target: 'nombrePasajero_<s:property value="#adultos" />'});
					</s:if>
					$j('#nombrePasajero_<s:property value="#adultos" />').autotab({ target: 'pirmerApellidoPasajero_<s:property value="#adultos" />'});
					$j('#pirmerApellidoPasajero_<s:property value="#adultos" />').autotab({ target: 'numDocPasajero_<s:property value="#adultos" />'});
					$j('#numDocPasajero_<s:property value="#adultos" />').autotab({ target: 'diaNacimientoPasajero_<s:property value="#adultos" />'});
					$j('#diaNacimientoPasajero_<s:property value="#adultos" />').autotab({ target: 'mesNacimientoPasajero_<s:property value="#adultos" />'});
					$j('#mesNacimientoPasajero_<s:property value="#adultos" />').autotab({ target: 'anyoNacimientoPasajero_<s:property value="#adultos" />'});
					<s:set name="last" value="#adultos"/>	
				</s:iterator>
		//Autotab ninos
				<s:iterator var="ninos" value="listaNinos" status="ninosStat"  >
					<s:if test="!#ninosStat.first">
						$j('#anyoNacimientoPasajeroN_<s:property value="#last" />').autotab({ target: 'nombrePasajeroN_<s:property value="#ninos" />'});
					</s:if>
					<s:else>
						$j('#anyoNacimientoPasajero_<s:property value="#last" />').autotab({ target: 'nombrePasajeroN_<s:property value="#ninos" />'});
					</s:else>
					$j('#nombrePasajeroN_<s:property value="#ninos" />').autotab({ target: 'pirmerApellidoPasajeroN_<s:property value="#ninos" />'});
					$j('#pirmerApellidoPasajeroN_<s:property value="#ninos" />').autotab({ target: 'numDocPasajeroN_<s:property value="#ninos" />'});
					$j('#numDocPasajeroN_<s:property value="#ninos" />').autotab({ target: 'diaNacimientoPasajeroN_<s:property value="#ninos" />'});
					$j('#diaNacimientoPasajeroN_<s:property value="#ninos" />').autotab({ target: 'mesNacimientoPasajeroN_<s:property value="#ninos" />'});
					$j('#mesNacimientoPasajeroN_<s:property value="#ninos" />').autotab({ target: 'anyoNacimientoPasajeroN_<s:property value="#ninos" />'});
					<s:set name="last" value="#ninos"/>			
				</s:iterator>
		
				
	    
	 
	 
}); 

function testDoc(campo){
	var auxCol=campo.id.split("_")[1];	
	var auxTd=$j("#tipoDocumentoPasajero_"+auxCol).val();
	if(auxTd.substring(1)!='DNI'&& auxTd.substring(1)!='CIF'){
		return;
	}
	rellenaLongitud(document.getElementById('numDocPasajero_'+auxCol));
}
function testDocN(campo){
	var auxCol=campo.id.split("_")[1];	
	var auxTd=$j("#tipoDocumentoPasajeroN_"+auxCol).val();
	if(auxTd.substring(1)!='DNI'&& auxTd.substring(1)!='CIF'){
		return;
	}
	rellenaLongitud(document.getElementById('numDocPasajeroN_'+auxCol));
}


</script>							
							