<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- telefono -->
<div id="telefono">
<table border="0" height="123" cellspacing="0" cellpadding="0" width="161" style="table-layout:fixed">
	<tbody>
		<tr>
			<td height="54" width="111" class="textoReservasTelefonicas">
				<s:property escape="false" value="getText('lang.gen.glo.reservasTelefonicas')"/>
			</td>
			<td height="54" width="50">&nbsp;</td> 
		</tr>
		<tr>
			<td class="textoHorario" colspan="2">
			<s:property escape="false" value="getText('lang.gen.glo.horario')"/>
			<b><br></b>
			</td>
		</tr>
	</tbody>
</table>
</div>
<!-- end telefono -->
