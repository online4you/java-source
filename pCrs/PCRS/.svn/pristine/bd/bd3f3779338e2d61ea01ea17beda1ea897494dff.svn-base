<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script>
	$j(document).ready(function(){
		$j("#zona-izda").css({'width':'984px','padding-left':'5px','padding-right':'5px','clear':'both'});
	});
</script>
<div class="caja-contenido" style="width:984px;background-image:none;"> 
  
  <div class="cabecera"  style="background-image:none;width:984px;">
    <h2 class="titulo1"><s:property value="getTextoOpciones()"/></h2>
  </div>
  <div class="separador-contenido" style="background:none;width:982px">
  </div>
  <div class="area-contenido">
    <div class="destacado-2">
      <p class="dato1"> 
        <span class="dato1-1"><s:property value="arrayOri.size()"/>
        </span> &nbsp; <s:property value="getTextoOrigen()"/>&nbsp; <strong><s:property value="provinciaOrigen"/></strong>
      </p>
    </div>
    <div class="destacado-2">
      <p class="dato1"> 
        <span class="dato1-1"><s:property value="arrayDest.size()"/>
        </span> &nbsp; <s:property value="getTextoDestino()"/>&nbsp; <strong><s:property value="provinciaDestino"/></strong>
      </p>
    </div>
    <s:if test="arrayOri.size()!=0">
	    <div class="subtitulo1"><s:property value="getText('lang.trenes.disponibilidadParcial.seleccione')"/>
	    </div>
	    <div class="contenedor-boton-2" style="margin-top:15px">
		<div class="boton-1-izda"></div>
			<button type="button" id="botonContinuar" class="boton-1"><s:property value="getText('lang.gen.aceptar')"/></button>
		<div class="boton-1-dcha"></div>
	   </div>
	    <div class="limpiar">
	    </div>
	    
	    <ul class="doble-lista" style="width:48%"> 
	      <li class="cabecera-lista"><s:property value="getText('lang.trenes.disponibilidadParcial.origen')"/>
	      </li>
			<s:iterator var="mOri" value="arrayOri">
				<li>
					<s:if test="#mOri.split('@@')[0].split('##').length>1">
						<label  style="margin-left:25px">
							<input type="radio" value="<s:property value='#mOri.split("@@")[0]'/>" onclick="func_<s:property value="#mOri.split('@@')[0].replace('##','_')"/>()" title="<s:property value="#mOri.split('@@')[1]"/>" name="radioOrigen"/> <s:property value="#mOri.split('@@')[1]"/>
						</label>
					</s:if>
					<s:else>
						<label>
							<input type="radio" value="<s:property value='#mOri.split("@@")[0]'/>" onclick="func_<s:property value="#mOri.split('@@')[0].replace('##','_')"/>()" title="<s:property value="#mOri.split('@@')[1]"/>" name="radioOrigen"/> <b><s:property value="#mOri.split('@@')[1]"/></b>
						</label>
					</s:else>
				</li>
			</s:iterator> 
	    </ul>
	    <ul class="doble-lista" id="derecha" style="width:48%"> 
	      <li class="cabecera-lista"><s:property value="getText('lang.trenes.disponibilidadParcial.destino')"/>
	      </li>
			<s:iterator var="mDest" value="arrayDest">
				<li  id="label_<s:property value='#mDest.split("@@")[0]'/>" name="destino">
					<s:if test="#mDest.split('@@')[0].split('##').length>1">
						<label style="margin-left:25px">
							<input id="des_<s:property value='#mDest.split("@@")[0]'/>" class="rdbDestino" type="radio" value="<s:property value='#mDest.split("@@")[0]'/>" title="<s:property value="#mDest.split('@@')[1]"/>" name="radioDestino"/> <s:property value="#mDest.split('@@')[1]"/> 
						</label>
					</s:if>
					<s:else>
						<label>
							<input id="des_<s:property value='#mDest.split("@@")[0]'/>" class="rdbDestino"  type="radio"  value="<s:property value='#mDest.split("@@")[0]'/>" title="<s:property value="#mDest.split('@@')[1]"/>" name="radioDestino"/> <b><s:property value="#mDest.split('@@')[1]"/></b>
						</label>
					</s:else>
				</li>
			</s:iterator>
	    </ul>
	    <div class="limpiar"></div>
	    <div class="separador-contenido" style="background-image:none;width:100%;margin-top:20px;height:0.51em;overflow:hidden">
	    </div>
	    <div class="subtitulo1" style="margin-top:15px"><s:property value="getText('lang.trenes.disponibilidadParcial.seleccione')"/>
	    </div>
	    <div class="contenedor-boton-2" style="margin-top:15px">
		<div class="boton-1-izda"></div>
			<button type="button" id="botonContinuar2" class="boton-1"><s:property value="getText('lang.gen.aceptar')"/></button>
		<div class="boton-1-dcha"></div>
	   </div>
	    
    </s:if>
    <s:form id="formBuscadorParcial" action="#">
    	<div style="display:none">
    		<s:checkbox name="soloIda"/>
    		<s:textfield name="adultosKey"/>
    		<s:textfield name="destinosDestinoKey"/>
    		<s:textfield name="destinosOrigenKey"/>
    		<s:textfield name="fechaIda"/>
    		<s:textfield name="fechaVuelta"/>
    		<s:textfield name="trenFechaIda"/>
    		<s:textfield name="trenFechaVuelta"/>
    		<s:textfield name="ninosKey"/>
    		<s:textfield name="provinciaDestino"/>
    		<s:textfield name="provinciaDestinoKey"/>
    		<s:textfield name="provinciaOrigen"/>
    		<s:textfield name="provinciaOrigenKey"/>
    	</div>
    </s:form>
  </div>
</div>



<script>
	$j("input[name='radioDestino']").click(function(){
		if ($j("input[name='radioOrigen']:checked").val()==undefined){
			confirm('<s:property value="getText(\"lang.trenes.disponibilidadParcial.alertaOrigenDestino\")"/>');
			this.checked=false;
			return;	
		}
		var aDesId = ""; 
		aDesId =  $j("input[name='radioDestino']:checked").val();
		var vDesDes = ""; 
		vDesDes = $j("input[name='radioDestino']:checked").attr("title");
		
		/*
		$j("input[name='provinciaDestinoKey']").attr('value',"");
		$j("input[name='destinosDestinoKey']").attr('value',"");
		$j("input[name='provinciaDestino']").attr('value',"");
		
		$j("input[name='provinciaDestinoKey']").attr('value',aDesId.split("##")[0]);
		$j("input[name='destinosDestinoKey']").attr('value',aDesId.split("##")[1]);
		$j("input[name='provinciaDestino']").attr('value',vDesDes);
		*/
	});
	$j("input[name='radioOrigen']").click(function(){
		var aOriId = ""; 
		aOriId = $j("input[name='radioOrigen']:checked").val();
		var vOriDes = "";
		vOriDes = $j("input[name='radioOrigen']:checked").attr("title");
		$j("input[type=radio]").each(function(){
			if (this.name.indexOf("radioDestino")!=-1){
				this.checked=false;
				}
			})
		var aDesId = ""; 
		var vDesDes = ""; 
		/*
		$j("input[name='provinciaOrigenKey']").attr('value',"");
		$j("input[name='destinosOrigenKey']").attr('value',"");
		$j("input[name='provinciaOrigen']").attr('value',"");
		$j("input[name='provinciaDestinoKey']").attr('value',"");
		$j("input[name='destinosDestinoKey']").attr('value',"");
		$j("input[name='provinciaDestino']").attr('value',"");
		
		$j("input[name='provinciaOrigenKey']").attr('value',aOriId.split("##")[0]);
		$j("input[name='destinosOrigenKey']").attr('value',aOriId.split("##")[1]);
		$j("input[name='provinciaOrigen']").attr('value',vOriDes);
		$j("input[name='provinciaDestinoKey']").attr('value',aDesId.split("##")[0]);
		$j("input[name='destinosDestinoKey']").attr('value',aDesId.split("##")[1]);
		$j("input[name='provinciaDestino']").attr('value',vDesDes);
		*/
	});

	$j("#botonContinuar,#botonContinuar2").click(function(){
		if($j("input[name='radioOrigen']:checked").val()==undefined){
			confirm('<s:property value="getText(\"lang.trenes.disponibilidadParcial.alertaOrigen\")"/>');
			return;
		}
		if($j("input[name='radioDestino']:checked").val()==undefined){
			confirm('<s:property value="getText(\"lang.trenes.disponibilidadParcial.alertaDestino\")"/>');
			return;
		}
		var aOriId = ""; 
		aOriId = $j("input[name='radioOrigen']:checked").val();
		var vOriDes = "";
		vOriDes = $j("input[name='radioOrigen']:checked").attr("title");
		var aDesId = ""; 
		aDesId =  $j("input[name='radioDestino']:checked").val();
		var vDesDes = ""; 
		vDesDes = $j("input[name='radioDestino']:checked").attr("title");
		
		$j("input[name='provinciaOrigenKey']").attr('value',"");
		$j("input[name='destinosOrigenKey']").attr('value',"");
		$j("input[name='provinciaOrigen']").attr('value',"");
		$j("input[name='provinciaDestinoKey']").attr('value',"");
		$j("input[name='destinosDestinoKey']").attr('value',"");
		$j("input[name='provinciaDestino']").attr('value',"");
		
		$j("input[name='provinciaOrigenKey']").attr('value',aOriId.split("##")[0]);
		$j("input[name='destinosOrigenKey']").attr('value',aOriId.split("##")[1]);
		$j("input[name='provinciaOrigen']").attr('value',vOriDes);
		$j("input[name='provinciaDestinoKey']").attr('value',aDesId.split("##")[0]);
		$j("input[name='destinosDestinoKey']").attr('value',aDesId.split("##")[1]);
		$j("input[name='provinciaDestino']").attr('value',vDesDes);

		var contenidoCargando;
		contenidoCargando='<s:property value="getText('lang.gen.pantallaCarga.estamosComprobando')"/><br>';
		contenidoCargando+='<s:property value="getText('lang.gen.pantallaCarga.mejoresPrecios')"/><br>';
		
		setContenidoCargando(contenidoCargando,20);
		showCargando('capaCargandoV2');
		
		$j('#formBuscadorParcial').submit();
	});
	function showLightBox(idCapa,idCapaFade) {
		$j('#'+idCapa).show();
		$j('#'+idCapaFade).show();
		$j('#'+idCapa).css('zIndex',5000);
	}
	function hideLightBox(idCapa,idCapaFade) {
		$j('#'+idCapa).hide();
		$j('#'+idCapaFade).hide();
	}
	<s:iterator var="nOri" value="arrayOri">
		function func_<s:property value="#nOri.replace('#','_').split('@@')[0]"/>(){
			$j("li[name='destino']").hide();
			<s:iterator var="destinos" value="disPar.getDestinosFromOrigen(#nOri.split('@@')[0],'')">
				$j("li[id='label_<s:property value="#destinos.split('@@')[0]"/>']").show();
			</s:iterator>
			}
	</s:iterator>
	

</script>