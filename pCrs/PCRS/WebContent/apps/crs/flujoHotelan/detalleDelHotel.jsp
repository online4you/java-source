<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- detaleDelHotel -->
<div class="art-Post-body">
	<div class="art-Post-inner">
		<div class="art-PostContent">
			<div id="hotelguide" class="hotelguide">
				<div id="contentpane">
					<div id="titlehotel" class="textoCabeceraHotel" style="width:95%">
						<div class="maintitle"><h1>
							<a id="hotelLink" style="text-decoration: none;" href="/index.php?tt=<s:property value="hotel.ddbbHotel.name"/>%20-%20<s:property value="hotel.ddbbHotel.destinationDes"/>&action=detail&url=/apps/portvill/detalleHotel.html?idHotel=<s:property value="hotel.id"/>"><s:property value="hotel.ddbbHotel.name.toUpperCase()"/></a></h1>
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
					<button onclick="javascript: reservarThisHotel();" class="botonReserva" type="button">
					<s:text name="lang.gen.glo.reservar"/>
					</button>
				</div>
					<br>
					<div style="clear:both;padding-bottom:10px;"></div>
				</td>
			</tr>
			<tr>
				<td height="25" valign="top" align="center">
					<p style="text-align:left">
						<s:iterator var="image" value="hotel.images" status="imagesStat"> 
							<a href="javascript: openImage('<s:property value="#image.image"/>','<s:property value="#image.image"/>')" >						
								<img height="105px" width="105px" alt="<s:property value="#image.image"/>" title="<s:property value='#image.image'/>" src="<s:property value='#image.image'/>" style="border-color:#DEDEDE" class="listimage">
							</a>
							<br>
						</s:iterator>
					</p>
					<div style="clear:both;padding-bottom:10px;"></div>
					<br>
				</td>
				<td valign="top">
					<div id="hotelContent" style="margin: 15px;">
						<div style="display: table;">
							<div style="display: table-record;">
								<div style="display: table-cell;"><h2><s:property value="hotel.ddbbHotel.name"/>, <s:property value="hotel.ddbbHotel.zoneDes"/></h2></div>
								<div style="display: table-cell;">&nbsp;&nbsp;&nbsp;</div>
								<div style="display: table-cell;"><img alt="Star Rate" src="<s:property value='getLinkCategoriaHotelan(hotel)'/>"></div>
								<br/>
								<div style="display: table-cell;"><p class="license">N&uacute;m. Licencia:&nbsp;&nbsp;<i><s:property value="hotel.license"/></i></p></div>
							</div>
						</div>
	
						<br>
						<s:if test="hotel.ddbbHotel.details!=null && hotel.ddbbHotel.details!=''">
							<p style="text-align: justify;">
							<strong><s:text name="lang.gen.glo.tab_hotel1"/>:</strong><br><br>
							<s:property escape="false" value="convertIntrosBR(hotel.ddbbHotel.details)"/>
							</p>
						</s:if>	
						<br>
						<s:if test="hotel.ddbbHotel.acces!=null && hotel.ddbbHotel.acces!=''">
							<p>
							<strong><s:text name="lang.gen.crs.i_localizahotel"/>:</strong><br>
							<s:property value="hotel.ddbbHotel.acces"/>
							</p>
						</s:if>
					<br>
					<div style="clear:both;padding-bottom:10px;"></div>
				</td>
				
			</tr>
		</tbody>
	</table>
</div>
<div id="preloading" class="preloading_white_content" style="height:300px;width:300px">
	<img id="lightBoxImage" height="300px" width="300px" alt="" title="" src="" style="border-color:#DEDEDE" class="listimage">
</div>
<script type="text/javascript">
	var mouseX;
	var mouseY;
	$j().ready(function() {
		if (parent.location != window.location) {
			eval("parent.autoResize('iframeResultados');");
		}
		
		$j(document).mousemove(function(e){
				mouseX=e.pageX;
				mouseY=e.pageY;
		   }); 
		$j(document).click(function(e){
			setFadeOff();
	   }); 
		
		$j('#hotelLink').bind('click', function() {
				if (parent.location != window.location) {
					parent.location.href=this.href;
					return false;
				}else{
					window.location.href=this.href;
					return false;
					
				}  
			});
		
	});
	function reservarThisHotel(){
		if (parent.location != window.location) {
			eval("parent.loadDispoHotelBDL('<s:property value='hotel.id'/>','<s:property value='hotel.ddbbHotel.name.replace("\'", "")'/>','<s:property value='hotel.ddbbHotel.destinationId'/>','<s:property value='hotel.ddbbHotel.destinationDes'/>');");
		}else{
			document.location.href="http://www.book-villa.com/index.php?eval=true&destinosid=B<s:property value='hotel.ddbbHotel.destinationId'/>&destinos=<s:property value='hotel.ddbbHotel.destinationDes'/>&hotelId=<s:property value='hotel.id'/>&hotel=<s:property value='hotel.ddbbHotel.name'/>";
		}
	}
	function openImage(imageUrl, title){
		
		$j("#lightBoxImage").attr('src',imageUrl);
		$j("#lightBoxImage").attr('alt',title);
		$j("#lightBoxImage").attr('title',title);
	   	setFadeOn();
		
	}
	function setFadeOn(){
		//$j('#preloading').center();
    	var pos=$j('#factura').offset();
    	var left=mouseX+15;
    	var top=mouseY-100;
    	
    	
 		$j("#preloading").css( { "left":(left) + "px", "top":(top) + "px" } ); 
		$j('#preloading').show();
		//$j('#preloadingFade').show();
	} 
	function setFadeOff(){
		$j('#preloading').hide();
	} 
</script>

<!-- end detaleDelHotel -->
