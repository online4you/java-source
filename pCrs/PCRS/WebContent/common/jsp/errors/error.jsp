<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="content">	
<script type="text/javascript">
	$j(document).ready(function(){
		$j("#zona-izda").css({'width':'994px','padding-left':'0'});
	});
	function enviarFormuError() {
		var formu = document.formularioError;
		var error='';
		if (formu.telefono.value==""){
		    confirm($j("#cadena"). val ());
			return;
		}
		//formu.metodo.value="insertarLlamadaCliente";
		document.formularioError.submit();
	}
</script>
<input type="hidden" id="cadena" value="<s:property value="getText('lang.gen.mensajeNoTelefono')"/>"/>
<s:form method="post" action="llamadasCliente" id="formularioError" name="formularioError">
	<div style="display:none">
		<s:textfield value="NEWHAL" id="codSite" name="codSite"/>
		<s:textfield value="Por problemas ajenos al sistema no es posible continuar con su proceso en estos momentos. Intentelo de nuevo en breves momentos o para más infomación contacte con nuestro call-center" id="error" name="error"/>
		<s:textfield name="provinciaOrigenKey"/>
		<s:textfield name="provinciaDestinoKey"/>
		<s:textfield name="origenIda"/>
		<s:textfield name="destinoIda"/>
	</div>

	<div id="detallesviaje">
		<div class="cabecera-informacion">
			<s:property value="getText('lang.gen.informacion')"/>
		</div>
		<div class="caja-detalle" style="background-color:#FFF">
			<div class="marco-imagen flota-izq">
				<img height="132px" width="136px" src="<s:property value="getContextPath()"/>/static/main/images/common1024/operadora.gif" text-align="center">
			</div>
			<div style="height:auto;" class="cabecera">
				<strong><s:property value="getText('lang.gen.avisoError')"/></strong>
			</div>
			<div class="fila-1">
				<img height="23px" width="30px" src="<s:property value="getContextPath()"/>/static/main/images/common1024/telefono.gif" margin="2px 10px" style="float:left;">
				<div id="CAPAERRORICONOTELEFONO1" class="titulo-1"><s:property value="getText('lang.gen.pantallaError.llamadaGratis')"/></div>
				<div id="CAPAERRORICONOTELEFONO2" class="titulo-2"><s:property value="getText('lang.gen.pantallaError.introducirtelefono')"/></div>
			</div>
			<div class="columna-1">
				<div class="etiqueta-1">
					<span id="SPNERRORTELEFONO1"><s:property value="getText('lang.gen.pantallaError.telefono')"/></span>
				</div>
				<s:textfield  cssClass="campo-texto-11" size="15" name="telefono"/>
				<div class="etiqueta-2">
					<span id="SPNERRORTELEFONO2"><s:property value="getText('lang.gen.pantallaError.ejemplo')"/></span>
		  		</div>
			</div>
	  		<div class="columna-2">
				<div class="etiqueta-1">
					<span id="SPNERRORTELEFONO3"><s:property value="getText('lang.gen.pantallaError.cuando')"/></span>
				</div>
				<s:select id="horaDia"  
              		name="importeDonacion" 
					headerKey="-1" headerValue="%{getText('lang.gen.pantallaError.posible')}" 
					list="#{'9:00':'9:00', '9:30':'9:30','10:00':'10:00','10:30':'10:30','11:00':'11:00','11:30':'11:30','12:00':'12:00','12:30':'12:30','13:00':'13:00','13:30':'13:30','14:00':'14:00','14:30':'14:00','15:00':'15:00','15:30':'15:30','16:00':'16:00','16:30':'16:30','17:00':'17:00','17:30':'17:30','18:00':'18:00','18:30':'18:30','19:00':'19:00','19:30':'19:30','20:00':'20:00'}" 
					value="1" 
					cssClass="campo-texto-11" 
					name="horaDia" 
				/> 
				
			</div>
			<div class="boton-inferior">
					<div class="contenedor-boton">
						<div class="boton-1-izda"></div>
							 <button type="button" id="ENLACEERRORBOTON" class="boton-1" onclick="enviarFormuError();"><s:property value="getText('lang.gen.aceptar')"/></button>
						<div class="boton-1-dcha"></div>    
					</div>
			</div>

		</div>
	</div>
	
	<div class="limpiar"></div>
	<div class="espacio_vertical"></div>
	<div id="pie-error">
		<div id="CAPAERRORHORARIO1"><s:property value="getText('lang.gen.pantallaError.horario')"/></div>
		<div id="CAPAERRORHORARIO2"><s:property value="getText('lang.gen.pantallaError.horarioFinSemana')"/></div>
	</div>
	<div style="height:50px;" class="limpiar"></div>
</s:form>
		
	
		





	

   	

</div>