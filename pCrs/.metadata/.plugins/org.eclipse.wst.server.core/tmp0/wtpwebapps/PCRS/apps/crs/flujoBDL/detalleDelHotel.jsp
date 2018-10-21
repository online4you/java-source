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
							<a id="hotelLink" style="text-decoration: none;" href="/index.php?tt=<s:property value="hotel.nombre"/>%20-%20<s:property value="hotel.destino"/>&action=detail&url=/apps/bdl/detalleHotel.html?idHotel=<s:property value="hotel.servicioCodigo"/>"><s:property value="hotel.nombre.toUpperCase()"/></a></h1>
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
					<button onclick="javascript: reservarThisHotel();" class="botonReserva" type="button"><s:text name="lang.gen.glo.reservar"/></button>
				</div>
					<br>
					<div style="clear:both;padding-bottom:10px;"></div>
				</td>
			</tr>
			<tr>
				<td height="25" valign="top" align="center">
					<p style="text-align:left">
						<s:iterator var="image" value="images" status="imagesStat"> 
							<a href="javascript: openImage('<s:property value="getImagesPath()+#image.imagepath"/>','<s:property value="#image.name"/>')" >						
								<img height="105px" width="105px" alt="<s:property value="#image.name"/>" title="<s:property value='#image.name'/>" src="<s:property value='getImagesPath()+#image.imagepath'/>" style="border-color:#DEDEDE" class="listimage">
							</a>
							<br>
						</s:iterator>
					</p>
					<div style="clear:both;padding-bottom:10px;"></div>
					<br>
				</td>
				<td>
					<div id="hotelContent" style="margin: 15px;">
						<div style="display: table;">
							<div style="display: table-record;">
								<div style="display: table-cell;"><h2><s:property value="hotel.nombre"/>, <s:property value="hotel.zona"/></h2></div>
								<div style="display: table-cell;">&nbsp;&nbsp;&nbsp;</div>
								<div style="display: table-cell;"><img alt="Star Rate" src="<s:property value='getLinkCategoria(hotel)'/>"></div>
							</div>
						</div>
						<br>
						<s:if test="des.hotelFacilities!=null && !des.hotelFacilities.equals('')">
							<p>
							<strong><s:text name="lang.gen.glo.tab_hotel3"/>:</strong><br>
							<s:property value="des.hotelFacilities"/>
							</p>
						</s:if>
						<br>
						<s:if test="des.hotelRoomDescription!=null && !des.hotelRoomDescription.equals('')">
							<p>
							<strong><s:text name="lang.gen.glo.tab_hotel1"/>:</strong><br>
							<s:property value="des.hotelRoomDescription"/>
							</p>
						</s:if>	
						<br>
						<s:if test="des.holelSportDescription!=null && !des.holelSportDescription.equals('')">
							<p>
							<strong><s:text name="lang.gen.glo.tab_hotel2"/>:</strong><br>
							<s:property value="des.holelSportDescription"/>
							</p>
						</s:if>
						<br>
						<s:if test="des.hotelMealsDescription!=null && !des.hotelMealsDescription.equals('')">
							<p>
							<strong><s:text name="lang.gen.glo.tab_hotel6"/>:</strong><br>
							<s:property value="des.hotelMealsDescription"/>
							</p>
						</s:if>
						<br>
						<s:if test="des.hotelComments!=null && !des.hotelComments.equals('')">
							<p>
							<strong><s:text name="lang.gen.crs.i_comentarios"/>:</strong><br>
							<s:property value="des.hotelComments"/>
							</p>
						</s:if>
						<br>
						<s:if test="des.hotelLocationDescription!=null && !des.hotelLocationDescription.equals('')">
							<p>
							<strong><s:text name="lang.gen.crs.i_localizahotel"/>:</strong><br>
							<s:property value="des.hotelLocationDescription"/>
							</p>
						</s:if>
						<br>
						<s:if test="des.hotelHowToGetThere!=null && !des.hotelHowToGetThere.equals('')">
							<p>
							<s:property value="des.hotelHowToGetThere"/>
							</p>
						</s:if>
					<br>
					<p>
								<a target="_blank" href="https://maps.google.com/maps?q=<s:property value='hotel.latitud'/>,<s:property value='hotel.longitud'/>&hl=<s:property value='getLocale().getLanguage()'/>&z=19">
									<s:text name="lang.gen.crs.i_mapagoogle"/>					
								</a>
					</p>
					<div style="clear:both;padding-bottom:10px;"></div>
					<div id="mappaneltab" class="ddpaneltab" style="color:#545454">
						<a style="float: right;background-color: #178EB6;" href="javascript:void(0)" onclick="appendBootstrap(); changeMapText();">
							<span style="color:#ddd"><img src="/components/com_hotelguide/assets/images/arrow-down.gif" class="pointerimage" style="border-width: 0px; "></span>
							<span id="openCloseMap" style="color:#ddd"><s:text name="lang.gen.crs.i_abrirMapa"/></span>
						</a>
					</div>
					<div id="mappanel" class="ddpanel" style="float:left;width:100%">
						<div id="mappanelcontent" class="ddpanelcontent" style="background-color: rgb(243, 138, 18); height: 25px; overflow: hidden; ">
							<div style="margin:5px 7px 7px 5px">
								<h3 style="margin: 0; text-align:center; font-size:16px;">
								<a target="_blank" href="https://maps.google.com/maps?q=<s:property value='hotel.latitud'/>,<s:property value='hotel.longitud'/>&hl=<s:property value='getLocale().getLanguage()'/>&z=19">
									<s:text name="lang.gen.crs.i_mapagoogle"/>					
								</a>
								</h3>
								<div id="mapcontent" class="ddpanelmap" style="width: 100%; height: 490px; overflow: hidden; ">
									<div id="map_canvas" style="width:100%; height: 450px"></div>
								</div>
							</div>
						</div>
					</div>
					<div style="clear:both;padding-bottom:10px;"></div>
						<table>
							<tr>
							<td colspan="2">
								<div id="topcontainer">
									<div id="toprow">
										<div id="topleft">
											<ul id="top" class="feature">
												<s:iterator var="group" value="fac" status="groupStat"> 
													<s:if test="mostrar(value)">
														<li class="feature">
															<strong><s:property value="key.split('-')[1]" />:&nbsp;</strong>
															<br>
															<s:iterator var="facilitie" value="value" status="facilitieStat">
														   		<s:if test="mostrarFacility(#facilitie)">
														   			<s:property value="#facilitie.name" />	
														   			<s:if test="dePago(#facilitie)">
														   				&nbsp;(<s:text name="lang.gen.crs.i_concoste"/>)
														   			</s:if>
														   			<br>
														   		</s:if>
														   	</s:iterator>
														   	<br>
														   	<br>
														</li>
													</s:if>
												</s:iterator> 
											</ul>
										</div>
									</div>
								</div>
							</td>
						</tr>
				</table>
				</div>
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
			eval("parent.loadDispoHotelBDL('<s:property value='hotel.servicioCodigo'/>','<s:property value='hotel.nombre.replace("\'", "")'/>','<s:property value='hotel.destinoCodigo'/>','<s:property value='hotel.destino'/>');");
		}else{
			document.location.href="http://www.online4you.es/index.php?eval=true&destinosid=B<s:property value='hotel.destinoCodigo'/>&destinos=<s:property value='hotel.destino'/>&hotelId=<s:property value='hotel.servicioCodigo'/>&hotel=<s:property value='hotel.nombre'/>";
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

	<script type="text/javascript"> 
	
	
	
	var PHotelMap = {
	  map: null,
	  infoWindow: null
	};
	  
	/**
	 * Called when clicking anywhere on the map and closes the info window.
	 */
	PHotelMap.closeInfoWindow = function() {
	  PHotelMap.infoWindow.close();
	};
	 
	/**
	 * Opens the shared info window, anchors it to the specified marker, and
	 * displays the marker's position as its content.
	 */
	PHotelMap.openInfoWindow = function(marker, txt) {
	  var markerLatLng = marker.getPosition();
	  PHotelMap.infoWindow.setContent([
		txt
	  ].join(''));
	  PHotelMap.infoWindow.open(PHotelMap.map, marker);
	};
	 
	/**
	 * Called only once on initial page load to initialize the map.
	 */
	PHotelMap.init = function() {
		dlat = <s:property value="hotel.latitud"/>;
		dlon = <s:property value="hotel.longitud"/>;
		dzoom = 10;
		dtype = google.maps.MapTypeId.ROADMAP;

	  // Create single instance of a Google Map.
	  var centerLatLng = new google.maps.LatLng(dlat,dlon);
			var myOptions = {
				zoom: dzoom,
				center: centerLatLng,
				mapTypeControl: true,
				mapTypeControlOptions: {style: google.maps.MapTypeControlStyle.DROPDOWN_MENU},
				navigationControl: true,
				navigationControlOptions: {
					style: google.maps.NavigationControlStyle.ZOOM_PAN,
					position: google.maps.ControlPosition.TOP_LEFT
				},

				mapTypeId: google.maps.MapTypeId.ROADMAP			}

		PHotelMap.map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);  
		
	  /*PHotelMap.map = new google.maps.Map(document.getElementById('map_canvas'), {
		zoom: 13,
		center: centerLatLng,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	  });*/
	  
	  // Create a single instance of the InfoWindow object which will be shared
	  // by all Map objects to display information to the user.
	  PHotelMap.infoWindow = new google.maps.InfoWindow();
	  
	  // Make the info window close when clicking anywhere on the map.
	  google.maps.event.addListener(PHotelMap.map, 'click', PHotelMap.closeInfoWindow);
	  

				var maplogo = '/components/com_hotelguide/assets/images/maplogo.png';
				var itemlink;
				var thumblink;
				var mainLogo;
				var title;
				var content;
				var contentInfo;
				var thisHotel='107';
				var someOtherHotel;
				var howMany='1';
	// loop
										someOtherHotel='107';
							itemlink = "#";
							thumblink = '<s:property value="getLogoHotel(hotel)"/>';
							mainLogo = '<s:property value="getLogoHotel(hotel)"/>';							
							//var slimboxlink = "http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/main_107.jpg";
							title = "<s:property value='hotel.nombre.toUpperCase()'/>";
							content = '<s:property value="des.hotelFacilities"/>';
							contentInfo0 = 	  '<table width="404"> ' +
													  '<tr><td colspan="2" align="center"> ' +
													  '<img src="' + maplogo + '" alt="' + title + ';" width="160px" height="25px"> ' +
													  '</td></tr> ' +
													  '<tr><td class="tituloHotel"  colspan="2" align="center">' +
													  '<a href="' + itemlink + '">' + title + '</a> ' +
													  '</td></tr> ' +
													  '<tr> ' +
													  '<td> ' +
													  '<img src="' + mainLogo + '" alt="' + title + '" style="border: 1px solid rgb(168, 115, 40);" width="50px" height="50px"> ' +
													  '</td><td> ' + content +
													  '</td></tr> ' +
													  '</table>';				  

									  var marker0 = new google.maps.Marker({
										//icon: thumblink,
										map: PHotelMap.map,
										position: new google.maps.LatLng(<s:property value="hotel.latitud"/>, <s:property value="hotel.longitud"/>)
									  });
								   
								  // Register event listeners to each marker to open a shared info
								  // window displaying the markers position when clicked or dragged.
								  google.maps.event.addListener(marker0, 'click', function() {
									PHotelMap.openInfoWindow(marker0,contentInfo0);
								  });

				

	}

		function appendBootstrap() {
			$j('#mappanelcontent').height(490);
			PHotelMap.init();
		}

		
		function changeMapText(){
			if ($j('#openCloseMap').html()=='<s:text name="lang.gen.crs.i_abrirMapa"/>'){
				$j('#openCloseMap').html('<s:text name="lang.gen.crs.i_cerrarMapa"/>');}
			else{
				$j('#openCloseMap').html('<s:text name="lang.gen.crs.i_abrirMapa"/>');
				$j('#mappanelcontent').height(25);}
			
			setTimeout('autoResize()',10);
		}
		
		function autoResize(){
			if (parent.location != window.location) {
				eval("parent.autoResize('iframeResultados');");
			}
		}
		
		
	</script>
<!-- end detaleDelHotel -->
