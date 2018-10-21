<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- script type="text/javascript" src="/webApp/static/main/js/jquery-1.5.1.min.js"></script>
<script src="/webApp/static/main/js/jquery.center.js" type="text/javascript"></script>
<script type="text/javascript" src="/webApp/static/main/js/calendario.js"></script>
<link type="text/css" rel="stylesheet" href="/webApp/static/main/css/HAL/reset.css">
<link type="text/css" rel="stylesheet" href="/webApp/static/main/css/HAL/styleHAL1024.css"-->

<!-- div style="display: block; margin-left: 0px;" id="calendar" class="capa-flotante capa-flotante-3"-->
  <div class="cabecera-calendario">
  	<s:property value="getEtiquetaTipo()"/>
  </div> 
  <a class="cerrar" title="Cerrar Ventana" href="#"></a>
  <div class="limpiar">
  </div>
  <div class="zona-centrada">
  	<s:if test="anteriorMes.equalsIgnoreCase('S')"> 
    	<a style="display: block;" title="Mes Anterior" class="atras" href="#" id="flechaizda"></a>
    </s:if>
    <div class="caja-mes" style="height:15px">
    	<s:property value="etiquetaMes"/>
    </div>
    <s:if test="siguienteMes.equalsIgnoreCase('S')"> 
    	<a style="display: block;" title="" class="avance" href="#" id="flechadcha"></a>
    </s:if>
  </div>
  <div id="superior" class="fila-calendario"> 
    <span class="encabezado"><s:property value="getText('lang.gen.diasemana.lunes')"/>
    </span> 
    <span class="encabezado"><s:property value="getText('lang.gen.diasemana.martes')"/>
    </span> 
    <span class="encabezado"><s:property value="getText('lang.gen.diasemana.miercoles')"/>
    </span> 
    <span class="encabezado"><s:property value="getText('lang.gen.diasemana.jueves')"/>
    </span> 
    <span class="encabezado"><s:property value="getText('lang.gen.diasemana.viernes')"/>
    </span> 
    <span class="encabezado"><s:property value="getText('lang.gen.diasemana.sabado')"/>
    </span> 
    <span class="encabezado-dcha"><s:property value="getText('lang.gen.diasemana.domingo')"/>
    </span>
  </div>

<!-- s:property value="mesAct.size()"/-->

<s:iterator var="p" value="mesAct" status="rowstatus">
	
	<s:set name="dia" value="#p.split('-')" />
	<s:set name="n" value="getNumerico(#dia[0])"/>
	<s:set name="fecha" value="#dia[0]+'/'+#dia[1]+'/'+#dia[2]"/>
	<s:set name="act" value="#dia[3]"/>
	<s:set name="diaSem" value="#dia[4]"/>
	<s:set name="visible" value="#dia[5]"/>
	<s:set name="estilo">
		<s:if test="#diaSem.equalsIgnoreCase('1')">
			<s:if test="#act.equalsIgnoreCase('S')">
				dia-activo dcha
			</s:if>
			<s:elseif test="#act.equalsIgnoreCase('H')">
				dia-actual dcha <s:property value="#act"/>
			</s:elseif>
			<s:elseif test="#act.equalsIgnoreCase('O')">
				dia-seleccionado dcha
			</s:elseif>
			<s:elseif test="#act.equalsIgnoreCase('I')">
				dia-actual dcha
			</s:elseif>
			<s:else>
				dia-inactivo dcha
			</s:else>
		</s:if>
		<s:else>
			<s:if test="#act.equalsIgnoreCase('S')">
				dia-activo
			</s:if>
			<s:elseif test="#act.equalsIgnoreCase('H')">
				dia-actual <s:property value="#act"/>
			</s:elseif>
			<s:elseif test="#act.equalsIgnoreCase('O')">
				dia-seleccionado
			</s:elseif>
			<s:elseif test="#act.equalsIgnoreCase('I')">
				dia-actual <s:property value="#act"/>
			</s:elseif>
			<s:else>
				dia-inactivo
			</s:else>
		</s:else>
	</s:set>

	<s:if test="#diaSem.equalsIgnoreCase('2')">
		<div class="fila-calendario">
	</s:if>
	<s:if test="#act.equalsIgnoreCase('N') || #act.equalsIgnoreCase('I')">
		<div class="<s:property value="#estilo"/>">
	      <span>
	      	<s:if test="#visible.equalsIgnoreCase('S')">
	      	<s:property value="#n"/>
	      	</s:if>
	      	<s:else>
	      		&nbsp;
	      	</s:else>
	      </span>
	    </div>
	</s:if>
	<s:elseif test="#act.equalsIgnoreCase('S')||#act.equalsIgnoreCase('H') || #act.equalsIgnoreCase('O')">
		<a href="-<s:property value="#fecha"/>" class="<s:property value="#estilo"/>">
	      <span>
	      	<s:if test="#visible.equalsIgnoreCase('S')">
	      		<s:property value="#n"/>
	      	</s:if>
	      	<s:else>
	      		&nbsp;
	      	</s:else>
	      </span>
	    </a>
	</s:elseif>
	
	<s:if test="#diaSem.equalsIgnoreCase('1')">
		</div>	
	</s:if>

</s:iterator>
<div class="leyenda-calendario">
	<div class="item-leyenda-calendario">
		<span class="icono-leyenda"></span>
		<span class="leyenda-hoy"><s:property value="getText('lang.gen.calendario.hoy')"/></span>
	</div>
	<div class="item-leyenda-calendario">                
		<span class="icono-leyenda disponible"></span>
		<span class="leyenda-disponible"><s:property value="getText('lang.gen.calendario.disponible')"/></span>
	</div>
	<div>                
		<span class="icono-leyenda seleccionado"></span>
		<span class="leyenda-seleccionado"><s:property value="getText('lang.gen.calendario.seleccionado')"/></span>   
	</div>
</div>
<s:form id="foCalendario" action="CalendarioHome">
	<s:hidden name="fecIni" id="fecIni" value="%{getFecIni()}"/>
	<s:hidden name="fecFin" id="fecFin" value="%{getFecFin()}"/>
	<s:hidden name="mesSel" id="mesSel" value="%{getMesSel()}"/>
	<s:hidden name="tipoCal" id="tipoCal" value="%{getTipoCal()}"/>
</s:form>
<script>
$j('.cerrar').click(function(event) {
	event.preventDefault();
	hideLightBoxTrenes('calendar','fadeTrenes');
	
});
$j('#flechadcha,#flechaizda').click(function(event){
	
	event.preventDefault();
	var f = $j('#mesSel').attr('value');
	var fecha = $j('#mesSel').attr('value').split('/');
	($j(this).attr('id') == 'flechadcha')?fecha[1] = parseInt(fecha[1],10) + 1:fecha[1] = parseInt(fecha[1],10) - 1;
	if(parseInt(fecha[1],10) > 12){
		fecha[1] = 1;
		fecha[2] = parseInt(fecha[2],10) + 1;
	}
	if (parseInt(fecha[1],10)<1){
		fecha[1] = 12;
		fecha[2] = parseInt(fecha[2],10) - 1;
	}
	
	$j('#mesSel').attr('value','01/'+fecha[1]+'/'+fecha[2]);
	$j.ajax({
        type: 'POST',
        url: $j('#foCalendario').attr('action'),
        data: $j('#foCalendario').serialize(),
        success: function(data) {
		$j('#calendar').html(data);
        }
    });
});
$j('a.dia-seleccionado,a.dia-activo,a.dia-actual').click(function(event) {
	var valor;
	($j(this).attr('href'))? valor=$j(this).attr('href'):valor="void";
	event.preventDefault();
	actualizaFechas($j('#tipoCal').attr('value'),valor.split("-")[1]);
	hideLightBoxTrenes('calendar','fadeTrenes');
	
});
</script>

