<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- datosReserva -->
<div id="datosReserva">
	<table border="0" width="100%" cellspacing="0" cellpadding="0">
	<tbody>
		<tr class="art-PostMetadataHeader">
			<td class="textoCabeceraDestinos">
				<s:text name="lang.gen.glovilla.reservesuhotel"/>
			</td>
		</tr>
		<tr>
			<td>
				<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td align="left" width="1%" class="textoBreadcrumbProcesoReserva"><div style="overflow:auto; font-size: 15px;">&nbsp;&nbsp;&nbsp;&nbsp;<s:text name="lang.gen.glo.en3pasos"/>&nbsp;&nbsp;</div></td>
						<td align="left" width="1%" class="textoBreadcrumbProcesoReserva"><div style="width: 10px" class="blueArrowLeft">&nbsp;&nbsp;</div></td>
						<td align="left" width="1%" <s:if test="paso==1">style="color: #F38A12; font-size: 15px;"</s:if> class="textoBreadcrumbProcesoReserva"><div style="overflow:auto;">&nbsp;&nbsp;<s:text name="lang.gen.glo.1seleccionHotel"/>&nbsp;&nbsp;</div></td>
						<td align="left" width="1%" class="textoBreadcrumbProcesoReserva"><div class="blueArrowLeft">&nbsp;&nbsp;</div></td>
						<td align="left" width="1%" <s:if test="paso==2">style="color: #F38A12; font-size: 15px;"</s:if> class="textoBreadcrumbProcesoReserva"><div style="overflow:auto;">&nbsp;&nbsp;<s:text name="lang.gen.glo.2datosDeCliente"/>&nbsp;&nbsp;</div></td>
						<td align="left" width="1%" class="textoBreadcrumbProcesoReserva"><div class="blueArrowLeft">&nbsp;&nbsp;</div></td>
						<td align="left" width="1%" class="textoBreadcrumbProcesoReserva"><div style="overflow:auto;">&nbsp;&nbsp;<s:text name="lang.gen.glo.3comprar"/>&nbsp;&nbsp;</div></td>
						<td align="left" width="100%" class="textoBreadcrumbProcesoReserva">&nbsp;</td>
					</tr>
				</tbody>
				</table>
			</td>
		</tr>
		<s:if test="paso==1">
			<tr>
				<td style="line-height: 0px;">
					<div style="padding: 10px 20px;">
						<h5><s:property value="dispo.villa.size()"/>&nbsp;<s:text name="lang.gen.glo.Villas"/> </h5>
					</div>
				</td>
			</tr>
		</s:if>
		<tr>
		<td>
			<div style="background-position:center top;height:2px; width:100%;" class="navHorizontal"></div>
			<div class="resumenReserva">
				<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td style="font-size: 15px" colspan="3"><h8><s:text name="lang.gen.glo.datosReserva"/></h8></td>
					</tr>
					<tr>
						<td><s:text name="lang.gen.glo.destino"/>:&nbsp;<s:property value="destinos"/></td>
						<td>
						<s:if test="paso==2">
							<h8><s:property value="hotel.name"/></h8>
						</s:if>
						&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><s:text name="lang.gen.glo.llegada"/>:&nbsp;<s:property value="entrada"/></td>
						<td><s:text name="lang.gen.glo.salida"/>:&nbsp;<s:property value="salida"/></td>
						<td><s:text name="lang.gen.glo.noches"/>:&nbsp;<s:property value="noches"/></td>
					</tr>
					<tr>
						<td colspan="3"><div style="background-position:center top;height:1px; width:100%;" class="navHorizontal"></div></td>
					</tr>
						<tr>
							<td colspan="3">
									<s:property value="getPaxesString(adults,ninos,bebes)"/>
							</td>
						</tr>
				</tbody>
				</table>
			</div>
			<div style="background-position:center top;height:2px; width:100%;" class="navHorizontal"></div>
		</td>
	</tr>
</tbody>
</table>
</div>
<!-- end datosReserva -->
