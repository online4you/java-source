<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
</head>
	<body>
		<s:if test="debugInfo=='true'">
			<div style="display: block">
		</s:if>
		<s:else>
			<div style="display: none">
		</s:else>
			To:<s:property value="urlCeca"/><br>
			<FORM name='f1' target="_self" ACTION="<s:property value="urlCeca"/>" method="post" >
			     
			      
			      MerchantID<input type=text name="MerchantID" value="<s:property value='merchantID'/>"/><br>
			      AcquirerBIN<input type=text name="AcquirerBIN" value="<s:property value='acquirerBIN'/>"/><br>
			      TerminalID<input type=text name="TerminalID" value="<s:property value='terminalID'/>"/><br>
			      URL_OK<input type=text name="URL_OK" value="<s:property value='urlOk'/>" size="75"/><br>
			      URL_NOK<input type=text name="URL_NOK" value="<s:property value='urlKo'/>" size="75" /><br>
				  Firma<INPUT NAME="Firma" type=text VALUE="<s:property value='cadenaEncriptada'/>" size="75"/><br>
				  Cifrado<INPUT NAME="Cifrado" type=text VALUE="<s:property value='cifrado'/>"/><br>
			      Num_operacion<input type=text name="Num_operacion" value="<s:property value='idReserva'/>"/><br>
			      Importe<input type=text name="Importe" value="<s:property value='importe'/>"/><br>
			      TipoMoneda<input type=text name="TipoMoneda" value="<s:property value='tipoMoneda'/>"/><br>
			      Exponente<input type=text name="Exponente" value="<s:property value='exponente'/>"/><br>
			      Pago_soportado<input type=text name="Pago_soportado" value="<s:property value='pagoSoportado'/>"/><br>
			      Idioma<input type=text name="Idioma" value="<s:property value='idiceca'/>"><br>

			  
				  <CENTER>
					<INPUT TYPE="submit" VALUE="Comprar"><br>
				  </CENTER>
			</FORM>
		</div>
	</body>
</html>
<script language="javascript">
	<s:if test="debugInfo=='false'">
		document.f1.submit();
	</s:if>
</script>
