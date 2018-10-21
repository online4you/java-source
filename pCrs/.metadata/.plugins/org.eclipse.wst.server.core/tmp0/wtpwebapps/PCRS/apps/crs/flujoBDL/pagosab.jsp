<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<style type="text/css">
	#container {display: none;}
</style>
</head>
	<body onload="document.f1.submit();">
		
		<div id="container">
			<FORM name='f1' target="_self" ACTION="<s:property value="urlCeca"/>" method="post" >
 <table>
        <tr><td>signature</td></tr>
        <tr><td><input type="hidden" name="Ds_Signature" value="<s:property value='merchantSignature'/>"/></td></tr>
        <tr><td>params</td></tr>
        <tr><td><input name="Ds_MerchantParameters" type="hidden" value="<s:property value='merchantParameters'/>"/></td></tr>
        <tr><td>signature version</td></tr>
        <tr><td><input name="Ds_SignatureVersion" type="hidden" value="<s:property value='merchantSignatureVersion'/>"/></td></tr>

        <input type="submit" value="Enviar"/>
    </table>
			  
				  <CENTER>
					<INPUT TYPE="submit" VALUE="Comprar"><br>
				  </CENTER>
			</FORM>
		</div>
	</body>
</html>

