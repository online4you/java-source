<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
		<title><s:text name="lang.gen.glo.cancela"/>-<s:text name="lang.gen.glo.imprime"/>-<s:text name="lang.gen.glo.envia"/></title>

		<tiles:insertAttribute name="head"/>
  	
		<script type="text/javascript">
			var $j=jQuery;
		</script>
		
			
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
	<s:if test="!voucher.equals('')">
		<center>
			<table cellpadding="0" cellspacing="0" border="0">
			        <tr> 
			          <td colspan="3">
							<s:property escape="false" value='voucher'/>
						</td>
					</tr>
					<tr> 
			          <td colspan="3">&nbsp;</td>
					</tr>
					<tr>
						<td>
					  		<button class="botonReserva" onClick="javascript: cancelReservation();"><s:text name="lang.gen.glo.cancela"/></button>
					  	</td>
			          	<td>
					  		<button class="botonReserva" onClick="javascript: printVoucher();"><s:text name="lang.gen.glo.imprime"/></button>
					  	</td>
			          	<td>
					  		<button class="botonReserva" onClick="javascript: reSendVoucher();"><s:text name="lang.gen.glo.envia"/></button>
					  	</td>
			        </tr>
			        <tr> 
			          <td colspan="3">&nbsp;</td>
					</tr>
			</table>
		</center>
	</s:if>
</body>
</html>
<script language="JavaScript">
	var canceled=false;
	function printVoucher(){
		this.print();
	}
	function reSendVoucher(){
		$j.ajax({ 
	        url: "<s:property value='getContextPath()'/>/apps/bdl/enviaReserva.html", 
	        type: "post", 
	        data: { localizador: "<s:property value="localizador"/>",mail: "<s:property value="mail"/>" }, 
	        // callback handler that will be called on success 
	        success: function(response, textStatus, jqXHR){ 
	        	if (response['resultado']=="ENVIADO"){
	        		alert("<s:text name='lang.gen.glo.sentMailOk'/>");
	        	}else{
	        		alert("<s:text name='lang.gen.glo.sentMailKo'/>");
	        	}
	        	
	        }, 
	        // callback handler that will be called on error 
	        error: function(jqXHR, textStatus, errorThrown){ 
	        	alert("<s:text name='lang.gen.glo.sentMailKo'/>");
	        }, 
	        // callback handler that will be called on completion 
	        // which means, either on success or error 
	        complete: function(){ 
	        	 //setFadeOff();
	        } 
	    }); 
	}
	function cancelReservation(){
		<s:if test="gastos">
			if (!confirm("<s:text name='lang.gen.crs.i_incurreEnGastos'/>")){
				return;
			}
		</s:if>
		$j.ajax({ 
	        url: "<s:property value='getContextPath()'/>/apps/bdl/cancelaReserva.html", 
	        type: "post", 
	        data: { localizador: "<s:property value="localizador"/>",mail: "<s:property value="mail"/>" }, 
	        // callback handler that will be called on success 
	        success: function(response, textStatus, jqXHR){ 
	        	if (response['resultado']=="CANCELLED"){
	        		alert("<s:text name='lang.gen.glo.cancelacionReserva'/>");
	        	}
	        	
	        }, 
	        // callback handler that will be called on error 
	        error: function(jqXHR, textStatus, errorThrown){ 
	           //
	        }, 
	        // callback handler that will be called on completion 
	        // which means, either on success or error 
	        complete: function(){ 
	        	 //setFadeOff();
	        } 
	    }); 
	}

</script>


