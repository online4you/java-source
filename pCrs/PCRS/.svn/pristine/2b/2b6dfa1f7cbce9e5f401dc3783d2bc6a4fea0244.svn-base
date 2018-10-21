<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- preReserva -->
<div class="art-Post-body">
<div class="art-Post-inner">
<table style="width:100%">
		

		<tr>
			<td colspan="4">
				<div class="art-PostMetadataHeader">
					<h2 class="art-PostHeader" style="text-align:center"><s:property value="hotelBloqueado.nombre"/></h2>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<!-- 
		<tr>
			<td colspan="4">
				<span style="color:#178EB6;font-weight:bolder">Hotel:</span><span style="color:#000000">&nbsp;<s:property value="hotelBloqueado.nombre"/></span>
			</td>
		</tr>
		-->
		<tr>
			<td colspan="1">
				<span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.glo.llegada"/>:</span><span style="color:#000000">&nbsp;<s:property value="entrada"/></span>
			</td>
			<td colspan="1">
				<span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.glo.salida"/>:</span><span style="color:#000000">&nbsp;<s:property value="salida"/></span>
			</td>
			<td colspan="1">
				<span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.glo.noches"/>:</span><span style="color:#000000">&nbsp;<s:property value="noches"/></span>
			</td>
			<td colspan="1">&nbsp;</td>
		</tr>
		
		
		<tr>
			<td colspan="4"><hr></td>
		</tr>
	<s:iterator var="distribucion" value="getContratoSeleccionado().distribuciones" status="distribucionesStat">
      	<s:set name="habitacion" value="getHabitacionSeleccionada(#distribucionesStat.index)"/>
		<s:set name="regimen" value="getRegimenSeleccionado(#distribucionesStat.index)"/>

		<tr>
			<td colspan="4">
				<div>
					<span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.glo.habitacion"/>&nbsp;<s:property value="#distribucionesStat.index+1"/>:&nbsp;</h8>
									<s:property value="#distribucion.adultos"/>&nbsp;
									<s:if test="#distribucion.adultos==1"><s:text name="lang.gen.glo.Adulto"/></s:if>
									<s:else><s:text name="lang.gen.glo.Adultos"/></s:else>
									<s:if test="#distribucion.ninos!=0">
										<s:property value="#distribucion.ninos"/>&nbsp;
										<s:if test="#distribucion.ninos==1"><s:text name="lang.gen.glo.nino"/></s:if>
										<s:else><s:text name="lang.gen.glo.ninos"/></s:else>
									</s:if>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<s:property value="#habitacion.habitacion"/>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<s:property value="#regimen.descripcion"/>
			</td>
			<!-- 
			<td colspan="1" style="text-align:right">
				<span style="color:#000000"><s:property value="twoDecimalFormat(getPrecioDescuento(#regimen.precio))"/>&nbsp;EUR</span>
			</td>
			-->
		</tr>
	</s:iterator>
	<tr>
		<td colspan="4"><hr></td>
	</tr>

	<tr>
		<td colspan="3"><span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.crs.i_gastosCancelacion"/>:</span></td>
		<td colspan="1" style="text-align:right">
			<span style="color:#000000"><s:property value="twoDecimalFormat(getGastosTotalesCancelacion(hotelBloqueado))"/>&nbsp;EUR</span>
		</td>
	</tr>
	<tr>
		<td colspan="1"><span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.crs.i_fechaGastos"/>*:</span></td>
		<td colspan="1">
			<span style="color:#000000"><s:property value="formatDate(getPrimeraFechaCancelacionFicticia(hotelBloqueado))"/></span>
		</td>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td colspan="4"><hr></td>
	</tr>
	<tr>
		<td colspan="3"><span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.crs.i_importetotal"/>:</span></td>
		<td colspan="1" style="text-align:right">
			<span style="color:#000000"><s:property value="twoDecimalFormat(getPrecioDescuento(hotelBloqueado.purchase.totalPrice))"/>&nbsp;EUR</span>
		</td>
	</tr>
	
	<tr>
		<td colspan="3"><span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.crs.i_ImporteAPagar"/>:</span></td>
		<td colspan="1" style="text-align:right">
			<span style="color:#000000;font-weight:bolder"><s:property value="twoDecimalFormat(hotelBloqueado.purchase.toPay)"/>&nbsp;EUR</span>
		</td>
	</tr>
	<s:if test='toPayBefore!=null'>
		<tr>
			<td colspan="3"><span style="color:#178EB6;font-weight:bolder"><s:text name="lang.gen.crs.i_aPagarAntesDe"/>&nbsp;<s:property value="formatDate(getPrimeraFechaCancelacion(hotelBloqueado))"/>:</span></td>
			<td colspan="1" style="text-align:right">
				<span style="color:#000000;font-weight:bolder"><s:property value="twoDecimalFormat(toPayBefore)"/>&nbsp;EUR</span>
			</td>
		</tr>
	</s:if>
	<tr>
		<td colspan="4"><hr></td>
	</tr>
		<s:if test='reservarAvaliable()'>
			<tr>
				<td colspan="4" >
					<span style="color:#000000"><s:text name="lang.gen.crs.i_aceptoGastos"/></span> <input type="checkbox" style="border:none" value="1" id="aceptoPago" name="aceptoPago" class="styled" />
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<button id="botonReserva" onclick="javascript:doPasarelaDePago();" class="botonReserva" type="button"><s:text name="lang.gen.glo.reservar"/></button>
				</td>
			</tr>
			<tr>
				<td colspan="4"><hr></td>
			</tr>
		</s:if>
	
	<tr>
		<td colspan="4">* <s:text name="lang.gen.crs.i_explicacionGastos"/></td>
	</tr>
	<tr>
		<td colspan="4">&nbsp;</td>
	</tr>
	
	<s:set name="comments" value="getComentarios()"/>
	<s:if test="!#comments.equals('')">
		<tr>
			<td colspan="4"><strong><s:text name="lang.gen.crs.i_comentarios"/>:</strong></td>
		</tr>
		
		<tr>
			<td colspan="4"><div id="comentarios"><s:property value="#comments"/></div></td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
	</s:if>
	<tr>
		<td colspan="4" align="center">
			<s:if test='reservarAvaliable()'>
				<button id="botonCancelar" onclick="javascript:doCancelarPago();" class="botonReserva" type="button"><s:text name="lang.gen.crs.i_cerrar"/></button>
			</s:if>
			<s:else>
				<button id="botonCancelar" onclick="javascript:cierraDesglose();" class="botonReserva" type="button"><s:text name="lang.gen.crs.i_cerrar"/></button>
			</s:else>
		</td>
	</tr>
</table>
</div>
</div>
<script type="text/javascript">

$j().ready(function() {
	<s:if test="!#comments.equals('')">
		var str=$j('#comentarios').html();
		str = str.replace(/\n/g, "<br />"); 
		$j('#comentarios').html(str)
	</s:if>
});
	<s:if test='reservarAvaliable()'>
		function goToPago(idReserva){
			var str = "<form name='f1' method='post' target='_self' action='<s:property value="urlPago"/>'>";
			
			str += "<input type='hidden' ";
			str += "name='idReserva' ";
			str += "value='" + idReserva + "'>";
			str += "<br>\n";
			
			str += "</form>";
	
			var vent=window.open("", '_blank', 'toolbar=no,location=no,directories=no,resizable=yes,scrollbars=yes');
			vent.document.write(str);
			vent.document.f1.submit();
		} 
		function doPasarelaDePago(){
			if ($j('#aceptoPago').is(':checked')){
				goToPago('<s:property value="idReserva"/>');
			}else{
				alert('<s:text name="lang.gen.crs.i_debeAceptar"/>');
			}
				
			
		}
	
		function doCancelarPago(){
			$j('#preloading').hide();
			$j('#preloading').html('');
		}
		style1Item("aceptoPago");
	</s:if>
	<s:else>
		function cierraDesglose(){
			$j('#desglosePrecios').hide();
			if (parent.location != window.location) {
				eval("parent.autoResize('iframeResultados');");
			}
		}
	</s:else>
</script>
<!-- end preReserva -->
