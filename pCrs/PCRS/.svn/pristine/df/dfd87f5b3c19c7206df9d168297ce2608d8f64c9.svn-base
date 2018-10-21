<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
	<div class="encabezado-1" style="padding:7px 0 0 0;font-size:1em;float:left">
		<div id="tituloLupa" class="titulo-2" style="font-size:1.32em;text-align:left"><s:property value="getText('lang.trenes.lupa.titulo')"/></div>
	</div>
	<a class="cerrar" href="javascript: hideLightBox('capaLupa','fade');" title=""></a>
	<div class="cabecera-indice-geografico"><s:property value="getText('lang.trenes.lupa.texto')"/></div>
	<div class="separador-3"></div>
		<div class="contenido-flotante">
<table id="tableContent" style="background-color:#FFF">
<tr>
<s:iterator var="cols" value="columns" status="columnStat">
	<td style="vertical-align: top;">
	<div >
	<ul class="bloque-destinos" style="padding-right:5px">
	<s:set name="odd" value="true"/>
	<s:set name="destOdd" value="true"/>
	
	<s:iterator var="sugest" value="#cols" status="sugestStat">
		<s:iterator var="sugestStat" value="#sugest">
			<s:if test="key.split('##').length<2">
				<s:set name="provKey" value="key"/>
				<li>
				<div id="prov_<s:property value="key" />">
				<s:if test="#odd == true">
					<s:if test="columns.size()<2">
						<div style=" padding-left: 10px; padding-top: 5px;width: 385px;padding-bottom: 5px; font-size: 0.9em;">
					</s:if>
					<s:else>
						<div style=" padding-left: 10px; padding-top: 5px;width: 270px;padding-bottom: 5px; font-size: 0.9em;">
					</s:else>
					<s:set name="odd" value="false"/>		
				</s:if>
				<s:else>
					<div style=" padding-left: 10px; padding-top: 5px;width: 270px;padding-bottom: 5px; font-size: 0.9em;">
					<s:set name="odd" value="true"/>	
				</s:else>
					<div>
						<div style="float: left">
							<a id="a_<s:property value="key" />" href="javascript: showEstaciones('<s:property value="key" />','a_<s:property value="key" />');" title="<s:property value="value" />">[+]</a>
						</div>
						&nbsp;
						<s:if test="provinciaOrigenKey == null">
							<a href="javascript: setLupaValuesOrigen('<s:property value="key" />','<s:property value="value" />');" title="<s:property value="value" />"><s:property value="value" /></a>
						</s:if>
						<s:else>
							<a href="javascript: setLupaValuesDestino('<s:property value="key" />','<s:property value="value" />');" title="<s:property value="value" />"><s:property value="value" /></a>
						</s:else>
					</div>
	
					</div>
				</div>
				</li>
			</s:if>
			<s:else>
				<div id="dest_<s:property value="provKey" />_<s:property value="key" />" style="display: none;">
				<div style="padding-left: 18px; padding-top: 5px;width: 260px;padding-bottom: 5px; font-size: 0.9em;">
					<div>
						<s:if test="key.split('##').length>1">
							&nbsp;&nbsp;
						</s:if>
						<s:if test="provinciaOrigenKey == null">
							<a class="bloque-destinos_lnk" href="javascript: setLupaValuesOrigen('<s:property value="key" />','<s:property value="value" />');" title="<s:property value="value" />"><s:property value="value" /></a>
						</s:if>
						<s:else>
							<a class="bloque-destinos_lnk" href="javascript: setLupaValuesDestino('<s:property value="key" />','<s:property value="value" />');" title="<s:property value="value" />"><s:property value="value" /></a>
						</s:else>
						</div>
					</div>
				</div>
			</s:else>
		</s:iterator>
	</s:iterator>
	</ul>
	</div>
	</td>
</s:iterator>
</tr>
</table>	
	
<div class="separador-3"></div>
	<div>
	</div>
   

<script type="text/javascript">
	function setLupaValuesOrigen(id,des){
		var dat=id.split("##");
		oriBool=true;
		if (dat.length>1){
			$j('#provinciaOrigenKey').val(dat[0]);
			$j('#destinosOrigenKey').val(dat[1]);
		}else{
			$j('#provinciaOrigenKey').val(id);
			$j('#destinosOrigenKey').val('');
		}
		$j('#provinciaOrigen').val(des);
		$j('#provinciaDestinoKey').val('');
		$j('#destinosDestinoKey').val('');
		$j('#provinciaDestino').val('');
		hideLightBoxTrenes('capaLupa','fade');
	}
	function setLupaValuesDestino(id,des){
		var dat=id.split("##");
		desBool=true;
		if (dat.length>1){
			$j('#provinciaDestinoKey').val(dat[0]);
			$j('#destinosDestinoKey').val(dat[1]);
		}else{
			$j('#provinciaDestinoKey').val(id);
			$j('#destinosDestinoKey').val('');
		}
		$j('#provinciaDestino').val(des);

		hideLightBoxTrenes('capaLupa','fade');
	}
	
	function showEstaciones(idProv,link){
		$j('div').each(function(n) { 
			if (this.id.indexOf("dest_"+idProv)!=-1){
				if($j('#'+link).text()=='[+]'){
					$j(this).show();
				}else {
					$j(this).hide();
				}
				
			}
		});
		if($j('#'+link).text()=='[+]'){
			$j('#'+link).text('[-]');
		}else {
			$j('#'+link).text('[+]');
		}
	}
	function ajustaCapa(){
		$j('#capaLupa').width($j('#tableContent').width());
		if ($j('#capaLupa').width()==0){
			setTimeout("ajustaCapa()",100);
		}else{
			//$j('#capaLupa').center();
			}

	}
	
	$j(document).ready(function(){
		ajustaCapa();
		
	});


	function hideLightBoxTrenes(idCapa,idCapaFade) {
		$j('#'+idCapa).hide();
		$j('#'+idCapaFade).hide();
	}

	
	
</script>	