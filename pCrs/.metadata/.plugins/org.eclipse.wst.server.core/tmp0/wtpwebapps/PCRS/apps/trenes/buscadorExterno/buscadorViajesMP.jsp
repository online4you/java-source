<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:set name="path" value="getContextPath()"/>
	<!-- /trenesApp/apps/trenes/buscadorViajesMP.html Necesario para evitar que la página 404 haga que funcione el ajax de la home www.halconviajes.com -->
	<div class="separador"></div>
	<div class="titulo-buscador"><s:property value="getText('lang.trenes.buscador.viajes.titulo')"/></div>
	<input type="hidden" id="trenOrigen" name="trenOrigen" class="campo-texto-11trenes">
	<div class="fila-buscador" style="float: left;width:140px;">
		<label for="provinciaOrigen"><s:property value="getText('lang.trenes.origen')"/></label>
		<div class="caja-larga">
			<s:hidden  name="provinciaOrigenKey" id="provinciaOrigenKey" />
			<s:hidden  name="destinosOrigenKey" id="destinosOrigenKey" />
			<div>
				<div class="campo-buscadorTrenesComboSelect">
					<img style="cursor: pointer;" src="<s:property value="%{path}"/>/static/main/images/HAL1024/select-flecha.gif" id="trenProvinciaOrigenSelect"  onmouseover="$j('#provinciaOrigen').focus();">
					<!-- img style="cursor: pointer;" border="0" src="<s:property value="%{path}"/>/static/main/images/HAL1024/lupa.gif"  id="lupaTrenIda"--> 
				</div>
				<s:textfield name="provinciaOrigen" id="provinciaOrigen" cssClass="campo-texto-11trenes"  onKeyDown="delDetino();" onBlur="delOrigenIfBlank();" onKeyPress="return submitenter(this,event)"/>
			</div>
		</div>
	</div>
	
	<div class="fila-buscador" style="float: right;width:140px;margin-right:2px">
		<label for="provinciaDestino"><s:property value="getText('lang.trenes.destino')"/></label>
		<div class="caja-larga">
			<s:hidden  name="provinciaDestinoKey" id="provinciaDestinoKey" />
			<s:hidden  name="destinosDestinoKey" id="destinosDestinoKey" />
			<div>
				<div class="campo-buscadorTrenesComboSelect">
					<img style="cursor: pointer;" src="<s:property value="%{path}"/>/static/main/images/HAL1024/select-flecha.gif" id="trenProvinciaDestinoSelect" onmouseover="$j('#provinciaDestino').focus();">
					<!--img style="cursor: pointer;" border="0" src="<s:property value="%{path}"/>/static/main/images/HAL1024/lupa.gif"  id="lupaTrenVuelta"-->
				</div>
				<s:textfield name="provinciaDestino" id="provinciaDestino" cssClass="campo-texto-11trenes" onfocus="setKeysValues();" onBlur="delDestinoIfBlank();" onKeyPress="return submitenter(this,event)"/>
			</div>
		</div>
	</div>
	
	<div class="fila-buscador">
		<label for="trenFechaIda"><s:property value="getText('lang.trenes.disponibilidad.fechaSalida')"/></label>
		<div>
			<s:textfield name="trenFechaIda" id="trenFechaIda" cssClass="campo-texto-12" readonly="readonly"/>
		</div>
	</div>
	
	<div class="fila-buscador">
		<label for="trenFechaVuelta"><s:property value="getText('lang.trenes.disponibilidad.fechaRegreso')"/></label>
		<div>
			<s:textfield name="trenFechaVuelta" id="trenFechaVuelta" cssClass="campo-texto-12" readonly="readonly"/>
		</div>
	</div>

	<div class="fila-buscador">
		<label  for="trenSoloIda"><s:property value="getText('lang.trenes.home.ida')"/></label>
		<div>
			<s:checkbox  name="trenSoloIda" />
		</div>
	</div>
	
	<div class="fila-buscador">
		<label  for="trenTipoTren"><s:property value="getText('lang.trenes.home.ave')"/></label>
		<div>
			<s:checkbox  id="trenTipoTrenChk"  name="trenTipoTrenChk" onclick="checkTipoTren()"/>
			<s:hidden name="trenTipoTren" id="trenTipoTren"/>
		</div>
	</div>
	
	<div class="limpiar"></div>
	<div class="fila-buscador">
    	<label class="campo-texto-13" for="adultosKey"><s:property value="getText('lang.trenes.adultos')"/></label>
 		   	<s:select cssClass="seleccionable-7" 
			list="adultos" 
			name="adultosKey" 
			onChange="javascript: comprobarPasajeros();"
			/> 
	    </div>
    
	    <div class="fila-buscador">
		   	<label class="campo-texto-13" for="ninosKey"><s:property value="getText('lang.trenes.reserva.tarifaNinos')"/></label>
            <s:select cssClass="seleccionable-7" 
			list="ninos" 
			name="ninosKey" 
			onChange="javascript: comprobarPasajeros();"
			/> 
		    
		</div>
	 <div class="limpiar"></div>
	<div class="fila-buscador">
	   	<s:property value="getText(lang.trenes.explicacionAsterisco)"/>
	</div>
		<div class="limpiar"></div>
<div class="capa-flotante capa-flotante-1 contenido-box" id="capaLupa" style="display: none; z-index: 5000; height:auto;width: auto;"></div>
<div id="fadeTrenes" class="sombra" style="display:none;"></div>
<div id="calendar" class="capa-flotante capa-flotante-3" style="display:none"></div>
 <style type="text/css">	
	.autocomplete-w1 { position:absolute; top:0px; left:0px; margin:6px 0 0 6px; /* IE6 fix: */ _background:none; _margin:1px 0 0 0; }
	.autocomplete { border:1px solid #999; background:#FFF; cursor:default; text-align:left; max-height:350px; overflow:auto; margin:-6px 6px 6px -6px; /* IE6 specific: */ _height:350px;  _margin:0; _overflow-x:hidden; }
	.autocomplete .selected { background:#F0F0F0; }
	.autocomplete div { padding:0px 5px; white-space:nowrap; overflow:hidden; }
	.autocomplete strong { font-weight:bold; color:#000000; text-decoration: underline; }
	.autocomplete provincia { font-weight:bold; color:#000000; font-size:11px; }
	.autocomplete provinciaMini {margin:5px; color:#000000; font-size:12px;}
	.autocomplete destino {margin:10px;color:#000000; font-size:12px;}
	.campo-texto-11trenes {border: 1px solid #E1E5E8; font-size: 1.11em; height: 17px; width: 120px;}
	.campo-buscadorTrenesComboSelect {float: right;}
 </style>


<script type="text/javascript">
var currentProvOri='';
var oriBool=false;
var currentProvDes='';
var desBool=false;
function checkTipoTren(){
	if($j("#trenTipoTrenChk").attr('checked') == true){
		$j("#trenTipoTren").val('AVE');
	}else{
		$j("#trenTipoTren").val('');
	}
}
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




function trenSelDiaIda(fecha){
	$j('#trenFechaIda').val(fecha);
	if(comparaFechasString($j('#trenFechaIda').val(),$j('#trenFechaVuelta').val()) && ($j('#soloIda').attr('checked')!='checked')){
		$j('#trenFechaVuelta').val($j('#trenFechaIda').val());
	}
		cerrarCalendario();
	} 

function firstIdaTen(){
	if($j('#trenFechaIda').val()==""){
		alert('<s:property value="getText('lang.trenes.buscador.viajes.alertFecha')"/>');
		return false;
		}
		abrirCalendarioNuevo('NEWHALCON','trenFechaVuelta',obtenerTextoIdioma('CAPAREGRESOVUELO'),'1',$j('#trenFechaIda').val(),$j('#trenFechaVuelta').val(),0,'trenSelDiaVuelta','TREN');
	} 

function trenSelDiaVuelta(fecha){
		$j('#trenFechaVuelta').val(fecha);
	
		cerrarCalendario();
	} 


	

	function setTrenesIda(value,data){
		oriBool=true;
		var dat=data.split("##");
		if (dat.length>1){
			$j('#provinciaOrigenKey').val(dat[0]);
			$j('#destinosOrigenKey').val(dat[1]);
		}else{
			$j('#provinciaOrigenKey').val(data);
			$j('#destinosOrigenKey').val('');
		}
		
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
	function setKeysValues(){
		trenProvDestino.setOptions({ params: { destino:'provinciaDestino', provinciaOrigenKey:$j('#provinciaOrigenKey').val(),destinosOrigen:$j('#destinosOrigenKey').val()  } });
	}

	$j(document).ready(function(){
		var options;
		var a;
		/*
		$j('#trenFechaIda').click(function(){
			cerrarDiccionario();
			abrirCalendarioNuevo('NEWHALCON','trenFechaIda',obtenerTextoIdioma("CAPASALIDAVUELO"),'1','',$j("#trenFechaIda").val(),'0','trenSelDiaIda','TREN');
			});
		$j('#trenFechaVuelta').click(function(){
			firstIdaTen();
		});
*/
		$j('#icono_10 a').text('<s:property value="getText('lang.trenes.trenes')"/>'); 

		$j(function(){
			  options = { 
					serviceUrl:'trenesApp/apps/trenes/AutocompleteFieldJson.html', 
				    minChars:0, 
				    delimiter: /(,|;)\s*/, // regex or character
				    maxHeight:400,
				    width:300,
				    maxHeightFactor:18,
				    widthFactor:7,
				    zIndex: 9999,
				    deferRequestBy: 250, //miliseconds
				    //params: { country:'Yes' }, //aditional parameters
				    noCache: true   , //default is false, set to true to disable caching
				    fixedHeight: true,
				    // callback function:
				    onSelect: function(value, data){ setTrenesIda(value,data); }
				    // local autosugest options:
				    //lookup: ['January', 'February', 'March', 'April', 'May'] //local lookup 
				};
			  trenProvOrigen = $j('#provinciaOrigen').autocomplete(options);
			  trenProvDestino = $j('#provinciaDestino').autocomplete(options);
			  trenProvDestino.setOptions({ params: { destino:'true' } });
			  trenProvDestino.setOptions({ onSelect: function(value, data){ setTrenesVuelta(value,data); } });

				$j('#trenFechaIda,#trenFechaVuelta').click(function(){
					muestraCalendario($j(this).attr('id'));	
				});

				
			});

		//add lupa click
		  /*
		  $j('#lupaTrenIda').click(function() {
			  $j.post('/trenesApp/apps/trenes/lupa.html','' , function(data) {
				  var dataFade=data.replace(/\'fade\'/g,'\'fadeTrenes\'');
				  dataFade=dataFade.replace(/hideLightBox/g,'hideLightBoxTrenes'); 
				  $j('#capaLupa').html(dataFade);
				  $j('#capaLupa').center();	
				  showLightBoxTrenes('capaLupa','fadeTrenes');
				});
			});
		  $j('#lupaTrenVuelta').click(function() {
			if($j('#provinciaOrigenKey').val()!=''){
			  $j.post('/trenesApp/apps/trenes/lupa.html','provinciaOrigenKey='+$j('#provinciaOrigenKey').val()+'&destinoOrigenKey='+$j('#destinoOrigenKey').val() , function(data) {
				  var dataFade=data.replace(/\'fade\'/g,'\'fadeTrenes\'');
				  dataFade=dataFade.replace(/hideLightBox/g,'hideLightBoxTrenes');
				  $j('#capaLupa').html(dataFade);
				  $j('#capaLupa').center();	
				  showLightBoxTrenes('capaLupa','fadeTrenes');
			  
				});
			}
			});
		*/
		///Select
		  
		  $j('#trenProvinciaOrigenSelect').click(function() {
			 // $j('#provinciaOrigen').focus();
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
			  //$j('#provinciaDestino').focus();
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
	function showLightBoxTrenes(idCapa,idCapaFade) {
		$j('#'+idCapa).show();
		$j('#'+idCapaFade).show();
		$j('#'+idCapa).css('zIndex',5000);
	}
	function hideLightBoxTrenes(idCapa,idCapaFade) {
		$j('#'+idCapa).hide();
		$j('#'+idCapaFade).hide();
	}
	function delDetino(){
		$j('#provinciaDestinoKey').val('');
		$j('#destinosDestinoKey').val('');
		$j('#provinciaDestino').val('');		
	}



	function muestraCalendario(elemId){
		var url='<s:property value="getContextPath()"/>/apps/trenes/CalendarioHome.html';
		if(elemId == 'trenFechaVuelta' ){
			if($j('#trenSoloIda').attr('checked')){
			return;
			}
			if($j('#trenFechaIda').attr('value')!=''){
				var mes;
				if($j('#trenFechaVuelta').attr('value')!=''){
					mes=$j('#trenFechaVuelta').attr('value');
				}else{
					mes=$j('#trenFechaIda').attr('value');
				}
				url=url+'?fecIni='+$j('#trenFechaIda').attr('value')+'&fecFin='+$j('#trenFechaVuelta').attr('value')+'&mesSel=01/'+ mes.substring (3,10) +'&tipoCal=VUE';
			}else{
				alert('<s:property value="getText('lang.gen.calendario.avisoFechaIda')"/>');
				showLightBoxTrenes('over','fadeTrenes');
				return;
			}
		}else{
		var fechaVuelta = $j('#trenFechaVuelta').attr('value');
			if($j('#trenSoloIda').attr('checked')){
				fechaVuelta="";
				}
			($j('#trenFechaIda').attr('value')!='')? url=url+'?fecIni='+$j('#trenFechaIda').attr('value')+'&fecFin='+fechaVuelta+'&mesSel=01/'+ $j('#trenFechaIda').attr('value').substring (3,10) : url=url;
		
		}
		$j.ajax({     
			type: "get", 
			url: url,     
			success: function (data, text) {
				//var dataFade=data.replace(/\'fade\'/g,'\'fadeTrenes\'');
				//dataFade=dataFade.replace(/hideLightBox/g,'hideLightBoxTrenes'); 
				var dataFade=data;
				$j('#calendar').html(dataFade); 
				$j('#calendar').center();
				showLightBoxTrenes('calendar','fadeTrenes');
				}					
			});
		
		
	}
	function actualizaFechas(data,valor){
		if (data=='VUE'){
			$j('#trenFechaVuelta').attr('value',valor);
		}else{
			var vffin = $j('#trenFechaVuelta').attr('value')
			var ffin = new Date(vffin.split('/')[2],vffin.split('/')[1],vffin.split('/')[0]);
			var fini = new Date(valor.split('/')[2],valor.split('/')[1],valor.split('/')[0]);
			$j('#trenFechaIda').attr('value',valor);
			(fini>ffin)? $j('#trenFechaVuelta').attr('value',valor):$j('#trenFechaVuelta').attr('value');
			if ($j('#trenFechaVuelta').val()==''){
				$j('#trenFechaVuelta').val($j('#trenFechaIda').val());
			}
		}
		return;
	}
	function comprobarPasajeros(){
		var adultos=$j('#adultosKey').val();
		var ninos=$j('#ninosKey').val();
		if(((adultos/1)+(ninos/1))>9){
			alert($j("<div/>").html('<s:property value="getText('lang.trenes.disponibilidad.plazasSobrepasadas')"/>').text());
			$j('#ninosKey').val('0');
		}
	}
	function delOrigenIfBlank(){
		if($j('#provinciaOrigen').val()==''){
			$j('#provinciaOrigenKey').val('');
			$j('#destinosOrigenKey').val('');
		}		
		//trenProvOrigen.hide();
		tryToGetProvincia();
	}
	function delDestinoIfBlank(){
		if($j('#provinciaDestino').val()==''){
			$j('#provinciaDestinoKey').val('');
			$j('#destinosDestinoKey').val('');
		}		
		//trenProvDestino.hide();
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
				
				buscar_a_a();
			   	return false;
			   }
			else
			   return true;
		}
</script>	