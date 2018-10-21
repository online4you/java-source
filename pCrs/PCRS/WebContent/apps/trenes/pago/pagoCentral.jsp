<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
  <s:form  action="Confirmacion" id="Pago">
    <fieldset id="Datos de Pago">
    <div class="caja-contenido">
        <div class="cabecera">
          <h2 class="titulo1">3. <s:property value="getText('lang.trenes.pago.datosPago')"/></h2>
        </div>
        <div class="separador-contenido">
        </div>
        <div class="area-contenido">
        
          <div class="agrupa-datos-1" id="divFormaPago">
            <p class="etiqueta-1">* <s:property value="getText('lang.trenes.pago.formaPago')"/>
            </p> 
            <div  class="agrupa-datos-2" name="padre">

	            <s:select  name="formaPago"
	            			id="formaPago"
				       		list="tarjetas"
				       		headerKey=""
				       		headerValue='%{getText("lang.trenes.tarjetas.inicio")}'
				       		
				/>            	
              <!-- label class="etiqueta-2" for="rdFormaPago1"> 
                <input type="radio" name="formaPago" value="VHAL" class="radio-1 descuentoSiNo tarjetaActiva radioFormaPago" checked="checked" tabindex="1" id="rdFormaPago1" > &nbsp;<s:property value="getText('lang.trenes.pago.visaHalcon')"/>&nbsp;(+<s:property value="dameFee('VHAL')"/>&euro;)
              </label> 
              <a class="icono-ventajas masInfo" name="botonazo" href="javascript:infoVentajasFunc()"  title="Tarjeta Visa Halcón Viajes" id="infoTarjetaHalconEduard"></a> 
              <br>
            </div> 
            <br>
            <div class="agrupa-datos-16"> 
              <label class="etiqueta-2" for="rdFormaPago2">
                <input type="radio" name="formaPago" value="VOTR" class="radio-1 descuentoSiNo tarjetaActiva radioFormaPago" tabindex="2" id="rdFormaPago2"> &nbsp;<s:property value="getText('lang.trenes.pago.otrasTarjetas')"/>&nbsp;( +<s:property value="dameFee('VOTR')"/>&euro;)
              </label> 
              <br-->
            </div>
            <div class="agrupa-datos-2 caja-promocion" style="width: 100px; float: right;">
				<a id="infoTarjetaHalcon" href="javascript:infoVentajasFunc()" title="Tarjeta Visa Halcón Viajes" class="icono-ventajas masInfo margen_2"></a>
				<div class="destacado-1 flota-izq">
					<span class="dato3" >										
							<!-- s:property value="getText('lang.trenes.tarjetas.promoVHAL')"/-->
					</span>
				</div>				
			</div>
            <div class="limpiar">
            </div>
          </div>
          
          <div id="datosTarjeta" style="display:none">
            <div class="agrupa-datos-1">
              <div class="grupo-formulario-1">
                <!--  Nombre del Titular -->
                <s:label for="txtTitular" >* <s:property value="getText('lang.trenes.pago.nombreTitular')"/> 
                	<s:textfield id="txtTitular" name="nombreTitular" cssClass="campo-texto-5a" tabindex="3" />
                </s:label>
              </div>
              <div class="grupo-formulario-4">
                <!--  Numero de la tarjeta -->
                <s:label for="txtNumTarjeta" >* <s:property value="getText('lang.trenes.pago.numeroTarjeta')"/> 
                	<s:textfield  cssClass="campo-texto-1" maxlength="16" tabindex="4" size="16" id="txtNumTarjeta" name="numTarjeta" filtro="numerico"/>
                </s:label> 
              </div>
            </div>
            <div class="agrupa-datos-1">
              <div class="grupo-formulario-1" style="width:330px">
              	<div class="grupo-formulario-1-1">
	                <label for="numMes"> * <s:property value="getText('lang.trenes.pago.fechaTarjeta')"/>
	                  <!--  Caducidad Mes -->
	                  	<s:textfield  cssClass="campo-texto-3" tabindex="5" size="2" maxlength="2" id="txtCaducidadMes" name="numMes" filtro="numerico"/>
	                </label>
	            </div> 
                  <!--  Caducidad Año -->
                <div class="grupo-formulario-1-2">
	                  <s:textfield  cssClass="campo-texto-3" tabindex="6" size="2" maxlength="2" id="txtCaducidadAnio" name="numAno" filtro="numerico"/> 
	                  <span class="info-adicional">(<s:property value="getText('lang.gen.mes')"/> / <s:property value="getText('lang.gen.ano')"/>)
	                  </span>
	                <label for="numAno"> </label>
	            </div>
              </div>
              <div class="grupo-formulario-4"> 
                <label class="etiqueta-5" style="margin-left:0" for="txtCCV"><span style="margin-left:74px">*CVV</span>
                  <!-- Id CCV --> 
                  <s:textfield  cssClass="campo-texto-4" tabindex="7" id="txtCCV" maxlength="4" name="numCCV" filtro="numerico"/>
                </label>
                <a style="cursor: pointer;" class="icono-info-2" title="Información CCV" id="infoCCV"></a>
              </div>
            </div>
          
          <div class="agrupa-datos-1">
            <div class="grupo-formulario-5"> 
              <s:label for="txtComentarios"> <s:property value="getText('lang.trenes.pago.observaciones')"/> 
                  <s:textarea tabindex="8" id="txtComentarios" rows="4" cols="75" cssClass="campo-texto-16" name="observaciones"></s:textarea>
              </s:label>
            </div>
          </div>
          </div>
        </div>
      </div>
      <!-- -------FALLO---------- -->
      <div class="caja-contenido-inferior">
      </div>
    </fieldset>
    <div><s:property value="getText('lang.trenes.pago.camposObligatorios')"/>
    </div>
    <div class="espacio-vertical-2">
    </div>
    <!--fieldset id="MassiveGood">
      <div class="caja-contenido" id="caja-redondeo-solidario">
        <div class="cabecera">
          <table>
            <tbody>
              <tr> 
                <td style="width: 500px;"><h2><s:property value="getText('lang.trenes.pago.accionSolidaria')"/></h2></td> <td> <strong>
                    <a title="¿Qué es esto?" id="enlaceQueEsMassiveGood" class="etiqueta-2 masInfo cargaAjax" style="color:#000" href="<s:property value="getContextPath()"/>/static/trenes/massiveGood_<s:property value='strLocale'/>.html"><s:property value="getText('lang.trenes.pago.queEs')"/></a></strong></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="separador-contenido">
        </div>
        <div class="area-contenido">
          <div class="agrupa-datos-1">
            <div class="logoMassiveGood flota-izq">
              <s:checkbox value="SI" name="donacion" id="checkMassiveGood"/>
              <span class="pinchable" id="txt_checkMassiveGood">&nbsp;<strong><s:property value="getText('lang.trenes.pago.si')"/></strong><s:property value="getText('lang.trenes.pago.textoDonacion')"/> 
              </span> 
              <span id="redondeo_centimos">
              	<s:select id="importeMassiveGood" 
              		name="importeDonacion"
					headerKey="-1" 
					list="#{'2':'2', '4':'4','6':'6','8':'8','10':'10','12':'12','14':'14','16':'16','18':'18','20':'20','25':'25','30':'30','40':'40','50':'50','60':'60','70':'70','80':'80','90':'90','100':'100','150':'150','200':'200','250':'250','300':'300'}"
					value="2"
				/> 
                
              </span>
              <span class="pinchable" id="txt_checkMassiveGood">&nbsp;<s:property value="getText('lang.trenes.pago.eurosA')"/> &nbsp;
              </span> 
              <img width="150" height="15" alt="#" src="<s:property value="getContextPath()"/>/static/main/images/common1024/massivegood_small.png">
              <span class="pinchable" id="txt_checkMassiveGood"><s:property value="getText('lang.trenes.pago.textoCampana')"/>
              </span>
              <div class="texto-massivegood"> 
                <span class="pinchable" id="txt_checkMassiveGood"><s:property value="getText('lang.trenes.pago.campana')"/>
                </span>
                <a id="enlaceNinosMalariaMassiveGood" href="<s:property value="getContextPath()"/>/static/trenes/ninosSinMalaria_<s:property value='strLocale'/>.html" class="enlace-2 masInfo cargaAjax"><s:property value="getText('lang.trenes.pago.ninosMalaria')"/></a>, 
                <span class="pinchable" id="txt_checkMassiveGood"><s:property value="getText('lang.trenes.pago.colaboracionCruzRoja')"/>
                </span> 
                <span class="pinchable" id="txt_checkMassiveGood"><s:property value="getText('lang.trenes.pago.yAceptoSus')"/>
                </span>
                <a title="Terminos Legales" href="<s:property value="getContextPath()"/>/static/trenes/condicionesSinMalaria_<s:property value='strLocale'/>.html" id="enlaceTerminosMassiveGood" class="enlace-2 masInfo cargaAjax">(<s:property value="getText('lang.trenes.pago.terminosLegales')"/>S)</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="caja-contenido-inferior">
      </div>
    </fieldset-->
    <fieldset id="Datos adicionales" class="agrupa-datos-7">
    	<div class="contenedor-boton-1" style="margin:0 20px 10px 0">
			<div class="boton-1-izda" ></div>
				<button class="boton-1" type="button" id="volver"><s:property value="getText('lang.gen.volver')"/> </button>
			<div class="boton-1-dcha"></div>
		</div>
      <div class="grupo-formulario-11">
        <div> 
          <s:label for="factura"> 
            <s:checkbox id="factura" name="factura" /> <s:property value="getText('lang.trenes.pago.deseoFactura')"/>
          </s:label>
        </div>
        <div>
          <s:label for="condiciones-compra"> 
            <s:checkbox id="condiciones-compra" name="checkCondiciones"/> 
            <s:property value="getText('lang.trenes.pago.preCondicionesCompra')"/>
            <a class="enlace-2 cargaAjax" href="<s:property value="getContextPath()"/>/static/trenes/condicionesGenerales_<s:property value='strLocale'/>.html" id="enlaceCondicionesGenerales" title="Condiciones Generales Reservas Halcón Viajes">
	            <s:property value="getText('lang.trenes.pago.acuerdoCondicionesCompra')"/>
    		</a>
            <s:property value="getText('lang.trenes.pago.postCondicionesCompra')"/>

          </s:label>
        </div>
      </div>
      <div class="contenedor-boton-2">
        <div class="boton-1-izda">
        </div>
        <button type="button" class="boton-1" onclick="submitForm()"><s:property value="getText('lang.gen.aceptar')"/>
        </button>
        <div class="boton-1-dcha">
        </div>
      </div>
    </fieldset>

    <div id="datos" style="display:none;">
    	<s:textfield name="idSesion"/>
		<s:textfield name="fechaIda" value="%{getFechaIda()}"/>
		<s:textfield name="origenIda" />
		<s:textfield name="destinoIda" />
		<s:textfield name="origenIdaDes" />
		<s:textfield name="destinoIdaDes" />
		<s:textfield name="trenIda" />
		<s:textfield name="claseIda" />
		<s:textfield name="tarifaIda" />
		<s:textfield name="precioIda" />
		<s:textfield name="horaSalidaIda" />
		<s:textfield name="horaLlegadaIda" />

		
		<s:textfield name="precioTotal" />
		
		<s:textfield name="fechaVuelta" value="%{getFechaVuelta()}"/>
		<s:textfield name="origenVuelta" />
		<s:textfield name="destinoVuelta" />
		<s:textfield name="origenVueltaDes" />
		<s:textfield name="destinoVueltaDes" />
		<s:textfield name="tarifaVuelta" />
		<s:textfield name="trenVuelta" />
		<s:textfield name="claseVuelta" />
		<s:textfield name="precioVuelta" />
		<s:textfield name="horaSalidaVuelta" />
		<s:textfield name="horaLlegadaVuelta" />
		
		<s:textfield name="soloIda" />
		<s:textfield name="adultosKey" />
		<s:textfield name="ninosKey" />
		 <s:textfield id="criteria" name="criteria" />       
	</div>
	<div style="top: 357px; left: 345px; z-index: 5000;display:none" class="capa-flotante capa-flotante-3" id="divFactura">
	  <div class="encabezado-1">
	     	<div class="titulo-2"><s:property value="getText('lang.trenes.pago.datosFacturacion')"/></div>
	  </div>                
	  <a class="cerrar" title="Cerrar Ventana" id="cerrarDatosFacturacion" href="#"></a>
	  <div class="separador-3"></div>
	  <div class="contenido-flotante">
	  	<fieldset id="Datos de Facturación">					
	  		<div class="grupo-formulario-10">
	      	<label for="nomCliF">
	          <s:property value="getText('lang.trenes.pago.nombreFactura')"/>
	          <input type="text" name="nombreFactura" id="nombreFactura" class="campo-texto-10"  maxlength="150">                                        
	  			</label>
	  		</div>
	  		<div class="grupo-formulario-10">
	        <label for="nifF">
	          <s:property value="getText('lang.trenes.pago.documentoFactura')"/>
	          <input type="text" name="docFactura" id="docFactura" class="campo-texto-10"  maxlength="12">                                        
	  	    </label>
	  		</div>					
	  		<div class="grupo-formulario-10">
	        <label for="dirCliF">
	          <s:property value="getText('lang.trenes.pago.direccionFactura')"/>
	          <input type="text" name="dirFactura" id="dirFactura" class="campo-texto-10" maxlength="250">                                        
	        </label>
	  		</div>
	  		<div class="contenedor-boton-2">
	         		<div class="boton-1-izda"></div>
	             	<button class="boton-1" type="button" id="aceptarDatosFacturacion"><s:property value="getText('lang.gen.aceptar')"/></button>
	             	<div class="boton-1-dcha"></div>                                        
	         	</div>
	  	</fieldset>					                  
	  </div>
	</div>                         
  </s:form>
  <div class="limpiar">
  </div>
  <div class="agrupa-datos-2">
    <p><strong><s:property value="getText('lang.gen.condiciones')"/></strong>
    </p>
    <p>
      <s:property value="getText('lang.trenes.pasajeros.avisoConfirmacionReserva')"/>
      <a class="enlace-2 cargaAjax" href="<s:property value="getContextPath()"/>/static/trenes/condicionesGenerales_<s:property value='strLocale'/>.html" id="enlaceCondicionesGenerales" title="Condiciones Generales Reservas Halcón Viajes"><s:property value="getText('lang.gen.condicionesGenerales')"/></a>. <s:property value="getText('lang.trenes.pasajeros.textoCondicionesReserva')"/>
      <a class="enlace-2" href="<s:property value="getContextPath()"/>/static/trenes/proteccionDatos.html" id="enlacePoliticaProteccionDatos" title="Política de Protección de Datos Halcón Viajes" target="_blank"><s:property value="getText('lang.trenes.politicaProteccionDatos')"/></a>. <s:property value="getText('lang.trenes.pasajeros.textoPoliticaProteccionDatos')"/>
    </p>
  </div>
  <div style="display: none" class="sombra" id="fade"></div>
  
  <!-- CAPA VENTAJAS VISA HALCON -->
	<div style="z-index: 5000; top: 84px; left: 357px;display:none" class="capa-flotante capa-flotante-1" id="divInfoTarjetaVisaHalcon">
	  <div class="encabezado-1">
	     	<div class="titulo-2">	
	  	   	<s:property value="getText('lang.gen.ventajaVisaHalcon.ventajas')"/>	   	
	     	</div>
	  </div>                
	  <a class="cerrar" title="Cerrar Ventana" id="cerrarInfoTarjetaPepe"></a>
	  <div class="separador-3"></div>
	  <div class="contenido-flotante"> 	
	   	<ul class="lista-1">
	      <li><s:property value="getText('lang.gen.ventajaVisaHalcon.facilidadPago')"/></li>
	      <li><s:property value="getText('lang.gen.ventajaVisaHalcon.ventajasReserva')"/></li>
	      <li><s:property value="getText('lang.gen.ventajaVisaHalcon.devolucionCompras')"/></li>
	      <li><s:property value="getText('lang.gen.ventajaVisaHalcon.seguro')"/></li>
	      <li><s:property value="getText('lang.gen.ventajaVisaHalcon.sinCuota')"/></li>
	      <li><s:property value="getText('lang.gen.ventajaVisaHalcon.valida')"/></li>
	    </ul>
		 <img width="435" src="<s:property value="getContextPath()"/>/static/main/images/HAL1024/banner-visahalcon.gif" alt="<s:property value="getText('lang.ventajasVisaHalcon.ventajas')"/>">
	  </div>
	</div>
	<!-- CAPA INFO CCV -->
	<div style="display:none" class="capa-flotante capa-flotante-1" id="divCCV">
	  <div class="encabezado-1">
	    <div class="titulo-2"><s:property value="getText('lang.gen.pantallaCCV.tituloCCV')"/></div>
	  </div>                
	<!-- <a href="javascript:hideLightbox();" title="<s:property value="getText('lang.gen.cerrarVentana')"/>" class="cerrar"></a> -->
	  <div class="separador-3"></div>
	  <div class="contenido-flotante">
	    <div class="dato1">
	      <img class="dato1-1" src="<s:property value="getContextPath()"/>/static/main/images/common1024/ccv01.gif" alt="Código CCV">
	      <div class="dato1-2">                    
	        <p><s:property value="getText('lang.gen.pantallaCCV.queEsVisa')"/></p>
	        <p><s:property value="getText('lang.gen.pantallaCCV.dondeVisa')"/></p>
	      </div>                        
	    </div>
	    <div class="dato1">
	      <img class="dato1-1" src="<s:property value="getContextPath()"/>/static/main/images/common1024/ccv02.gif" alt="<s:property value="getText('lang.gen.pantallaCCV.codigoCCV')"/>">
	      <div class="dato1-2">                    
	        <p><s:property value="getText('lang.gen.pantallaCCV.queEsAmerican')"/></p>
	      </div>                        
	    </div>                    
	  </div>
	</div>
<div id="ajaxCargado"></div>
<div id="error"></div>
<script type="text/javascript">
$j("#volver").click(function(){
	history.go(-1);
});
var tars=new Array();

<s:iterator var="tar" value="tarjetas" status="tarStat">
tars['<s:property value="key"/>']='<s:property value="dameFeeFront(#tar.key)"/>';</s:iterator>


$j(".cargaAjax").click(function(event){
	event.preventDefault();
	var enlace = $j(this).attr('href');
	$j("#ajaxCargado").load(enlace);
	$j("#ajaxCargado").center();
	$j("#ajaxCargado").show();
});
function cargarCondiciones(tar){
	$j("#ajaxCargado").html('');
	var tarifa= tar.replace('##','');
	$j.ajax({
        type: 'POST',
        url:'/trenesApp/static/trenes/cond_<s:property value='strLocale'/>_'+tarifa+'.html',
        success: function(data){
			$j("#ajaxCargado").html(data);
			$j("#ajaxCargado").center();
			$j("#ajaxCargado").show();

        	},
        error: function(){
        		$j("#ajaxCargado").load('/trenesApp/static/trenes/condiciones_<s:property value='strLocale'/>.html');
        		$j("#ajaxCargado").center();
        		$j("#ajaxCargado").show();
                }
    	});

	}
$j('.cerrar').live('click', function (){
	$j("#ajaxCargado").hide();
});

function infoVentajasFunc(){
	$j("#divInfoTarjetaVisaHalcon").show();

}
$j("#enlaceNinosMalariaMassiveGood").click(function(event){event.preventDefault();$j("#divNinosMalariaMassiveGood").show();});
$j("#enlaceTerminosMassiveGood").click(function(event){event.preventDefault();$j("#divTerminosMassiveGood").show();});
$j("#enlaceCondicionesGenerales").click(function(event){event.preventDefault();$j("#divCondicionesGenerales").show();});



$j(".cerrar").click(function(){
	//alert(this.parentNode.id);
	$j('#'+this.parentNode.id).hide();
	
});
$j('#infoCCV').mouseover(function() {
	$j('#divCCV').show();
	$j('#divCCV').css('top',$j(this).offset().top-100);
	$j('#divCCV').css('left',$j(this).offset().left-500);
	});
	$j('#infoCCV').mouseout(function() {
	$j('#divCCV').hide();
	}); 

var confirmarForm='Pago';
var textoRequerido='<s:property value="getText('lang.trenes.pago.requerido')"/>';
//var textoDiaRequerido='Dia Requerido'
var textoMesRequerido='<s:property value="getText('lang.trenes.pago.mesRequerido')"/>';
var textoAnyoRequerido='<s:property value="getText('lang.trenes.pago.anoRequerido')" />';
var textoLongitudMinima='<s:property value="getText('lang.trenes.pago.longitudMinima')"/>';
var textoNombreRequerido='<s:property value="getText('lang.trenes.pago.titularRequerido')"/>';
var textoNombre='<s:property value="getText('lang.trenes.pago.titularNoValido')"/>';

var textoNombreFactura='<s:property value="getText('lang.trenes.pago.nombreFactura')"/>';

var textoTarjetaRequerido='<s:property value="getText('lang.trenes.pago.tarjetaRequerido')"/>';
var textoTarjeta='<s:property value="getText('lang.trenes.pago.tarjetaNoValido')"/>';
var textoCCVRequerido='<s:property value="getText('lang.trenes.pago.ccvRequerido')"/>';
var textoCCV='<s:property value="getText('lang.trenes.pago.ccvNoValido')"/>';
var textoFecha='<s:property value="getText('lang.trenes.pago.fechaNoValida')"/>';
var textoDocuNoValido='<s:property value="getText('lang.trenes.pago.textoDocuNoValido')"/>';
var textoAvisPago='<s:property value="getText('lang.trenes.pago.avisoFormaPago')"/>';
var aviso='<s:property value="getText('lang.trenes.pago.avisoCondiciones')"/>';
function submitForm(){

	var params=$j('#'+confirmarForm).serialize();
	$j('#criteria').val($j('#'+confirmarForm).serialize());
	if($j("input[type=checkbox][name='checkCondiciones']").attr("checked")==false){
			confirm(aviso);
			return;
		}
	if($j("#formaPago").val()==""){
		confirm(textoAvisPago);
		return;
		}
	var contenidoCargando;
	contenidoCargando='<s:property value="getText('lang.gen.pantallaCarga.ComprobandoReserva')"/>';	
	setContenidoCargando(contenidoCargando,15);
	showCargando("capaCargandoV2");
	$j('#'+confirmarForm).submit();
}
function callbackHideCargando(){
	hideCargando("capaCargandoV2")
	
}
function checkearInputsFactura(){
	
	$j('#nombreFactura').rules('add',{
		required: true,
		minlength: 3,
		messages: {
		required: textoRequerido,
		minlength:textoLongitudMinima
		}
		});
	$j('#docFactura').rules('add',{
		required: true,
		minlength: 3,
		messages: {
		required: textoRequerido,
		minlength:textoLongitudMinima
		}
		});
	$j('#dirFactura').rules('add',{
		required: true,
		minlength: 3,
		messages: {
		required: textoRequerido,
		minlength:textoLongitudMinima
		}
		}); 
	if($j('#nombreFactura').valid() && $j('#docFactura').valid() &&$j('#dirFactura').valid()){
		$j("#divFactura").hide();
		$j("#fade").hide();
	}
	
	
}
/*function getLastDOM() {
	  var lastDOM = new Date();
	  lastDOM.setTime(lastDOM.getTime() + ((32 - lastDOM.getDate()) * 86400000) );
	  lastDOM.setTime(lastDOM.getTime() - (lastDOM.getDate() * 86400000) );
	  return lastDOM.getDate();
	}
alert(getLastDOM());*/
//$j(".caja-contenido").click(function(){alert(this.innerHTML)})
$j(document).ready(function(){
	$j("input[name=factura]").attr('checked', false)
	$j("#factura").change(function(){
			if (this.checked==true){
				$j("#divFactura").show();
				$j("#fade").show();
			}else{
				$j("#divFactura").hide();
				$j("#fade").hide();
			}
	showForm();
	});
	$j('#aceptarDatosFacturacion').click(function(){checkearInputsFactura();});

	$j("#cerrarDatosFacturacion").click(function(){
							$j("#divFactura").hide();
							$j("#fade").hide();
							$j("input[name=factura]").attr('checked', false);
							});

	
	$j.validator.addMethod('checkCondicion'
			   ,function(value,element){
				   return (element.checked);
				   });
	$j.validator.addMethod('SelformaPago'
			   ,function(value){
				   return ($j("#formaPago").val()!="");
				   });
	$j.validator.addMethod('nombreFactura'
			   ,function(value){return (value.match(/[a-zA-Z]/));}
			   ,textoNombreFactura);
	$j.validator.addMethod('nombre'
						   ,function(value){return (value.match(/[a-zA-Z]/));}
						   ,textoNombre);
	$j.validator.addMethod('tarjeta'
						  , function(value){return (value.match(/\d/));/*(^((67\d{2})|(4\d{3})|(5[1-5]\d{2})|(6011))(-?\s?\d{4}){3}|(3[4,7])\ d{2}-?\s?\d{6}-?\s?\d{5}$));*/ }
						  , textoTarjeta);
	$j.validator.addMethod('fecha'
			  , function(value) {
				  				 var dataAct= new Date();
				  				 var mes = parseInt($("#txtCaducidadMes").attr("value"))-1;
				  				 var ano = parseInt("20"+$("#txtCaducidadAnio").attr("value"));
				  				 var data = new Date(ano,mes,1);
				  				 return (dataAct<data); }
			  , textoFecha);
	$j.validator.addMethod('CCV'
			  , function(value){return (value.match(/\d{3,4}/));/*(^((67\d{2})|(4\d{3})|(5[1-5]\d{2})|(6011))(-?\s?\d{4}){3}|(3[4,7])\ d{2}-?\s?\d{6}-?\s?\d{5}$));*/ }
			  , textoCCVRequerido);
	
	var validator=$j('#'+confirmarForm).validate({
		   invalidHandler:callbackHideCargando,
		   rules: {
			nombreTitular: {
		       required: true,
		       nombre: true,
		       minlength:3
		     },
		     numTarjeta: {
		       required: true,
		       tarjeta: true,
		       minlength:16
		     },
		     numMes:{
				required:true,
				//mesOk:true,
				minlength:2
			 },
		     numAno:{
				required:true,
				fecha:true,
				minlength:2
			 },
			 numCCV:{
				 required:true,
				 CCV:true
			 },
			 formaPago:{
				 SelformaPago:true
				 }
		},
		
		messages: {         
			nombreTitular:{
		       required: textoNombreRequerido,
		       nombre: textoNombre,
		       minlength:textoLongitudMinima
		     },
		     numTarjeta:{
		       required: textoTarjetaRequerido,
		       tarjeta: textoTarjeta,
		       minlength:textoLongitudMinima
		     },
		     numMes:{
				required:textoMesRequerido,
				//mesOk:true,
				minlength:textoLongitudMinima
			 },
		     numAno:{
				required:textoAnyoRequerido,
				fecha:textoFecha,
				minlength:textoLongitudMinima
			 },
			 numCCV:{
				 required:textoCCVRequerido,
				 CCV:textoCCV
			 },
			 formaPago:{
				SelformaPago:textoAvisPago
				 }
		   }} );
	function showForm(){
		if ($j("#formaPago").val()==""){
			$j("#datosTarjeta").hide();
		}
		if ($j("#formaPago").val()!=""){
			$j("#datosTarjeta").show();
		}
	}
	   //Autotab
	$j('#txtTitular').autotab({ target: 'txtNumTarjeta'});
	$j('#txtNumTarjeta').autotab({ target: 'txtCaducidadMes'});
	$j('#txtCaducidadMes').autotab({ target: 'txtCaducidadAnio'});
	$j('#txtCaducidadAnio').autotab({ target: 'txtCCV'});
	$j('#txtCCV').autotab({ target: 'txtComentarios'});

	$j("#divFormaPago").html($j("#divFormaPago").html().replace(/&amp;euro;/g,'€'));
	$j("#formaPago").change(function(){
			showForm();
			if (tars[$j("#formaPago").val()]){
				var tot=$j("#importeTotal").val()/1;
				var paxes=$j("#paxesTotal").val()/1;
				var tar=paxes*(tars[$j("#formaPago").val()]/1);
				tar+=tot;
				$j("#importeTotalVal").html(tar+'');
			}else{
				$j("#importeTotalVal").html($j("#importeTotal").val());
			}
		});
}); 
</script>							

