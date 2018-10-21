<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- hotelesDestino -->
<div class="art-Post-body">
	<div class="art-Post-inner">
		<div class="art-PostContent">
			<div id="hotelguide" class="hotelguide">
				<div id="contentpane">
					<div id="titlehotel" class="textoCabeceraHotel" style="width:95%">
						<div class="maintitle"><h1>
							<s:text name="lang.gen.crs.i_hotelesen"/>&nbsp;<s:property value='destino'/></h1>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td align="left" colspan="2">
					<div class="subLine" style="text-align: left">
						<spam class="tituloHotel"></spam>	
					</div>
					<div style="float:right">
				</div>
					<br>
					<div style="clear:both;padding-bottom:10px;"></div>
				</td>
			</tr>
			<tr>
				<td height="25" valign="top" align="center">
					<p style="text-align:left">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</p>
					<div style="clear:both;padding-bottom:10px;"></div>
					<br>
				</td>
				<td>
					<s:iterator var="hotel" value="hotels" status="hotelsStat"> 
						<a class="textoListados" href="<s:property value='getContextPath()'/>/apps/bdl/detalleHotel.html?idHotel=<s:property value='#hotel.servicioCodigo'/>" >						
							<s:property value='#hotel.nombre'/>
						</a>
						<br>
					</s:iterator>
				</td>
				
			</tr>
		</tbody>
	</table>
</div>

<script type="text/javascript">
	
	$j().ready(function() {
		if (parent.location != window.location) {
			eval("parent.autoResize('iframeResultados');");
		}
	});

	</script>
<!-- end hotelesDestino -->
