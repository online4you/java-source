<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- detaleDelHotel -->
<div class="art-Post-body">
		<div class="art-Post-inner">
		
				<div class="art-PostContent">
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
		dlat = 39.869778;
		dlon = 4.21315;
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
							itemlink = "index.php?option=com_hotelguide&amp;view=hotel&amp;cid=66:sant-climent-alaior&amp;id=107:agroturismo-matchani-gran";
							thumblink = 'http://www.online4you.es/images/hotelguide/gallery/hotel_107/smallcrop/main_107.jpg';
							mainLogo = 'http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/main_107.jpg';							
							//var slimboxlink = "http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/main_107.jpg";
							title = "AGROTURISMO MATCHANI GRAN";
							content = '<br />	Matchani Gran, Alaior, Menorca<br /><br /><br />	Agroturismo Matchani Gran es una tipica casa de campo menorquina que ha sido restaurada y convertida en un peque&ntilde;o y familiar agroturismo dedicado a la ra....';
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
								  if (thisHotel==someOtherHotel && howMany > 1){
										var marker0 = new google.maps.Marker({
										map: PHotelMap.map,
										position: new google.maps.LatLng(39.869778, 4.21315)
									  });
								  }else{
									  var marker0 = new google.maps.Marker({
										icon: thumblink,
										map: PHotelMap.map,
										position: new google.maps.LatLng(39.869778, 4.21315)
									  });
									}
								   
								  // Register event listeners to each marker to open a shared info
								  // window displaying the markers position when clicked or dragged.
								  google.maps.event.addListener(marker0, 'click', function() {
									PHotelMap.openInfoWindow(marker0,contentInfo0);
								  });

				

	}

		function appendBootstrap() {
			document.getElementById('mappanelcontent').style.height='450px';
			PHotelMap.init();
		}

	</script>
<div id="hotelguide" class="hotelguide">
<div id="contentpane">
<div id="titlehotel" class="textoCabeceraHotel">
<div class="maintitle"><h1>
AGROTURISMO MATCHANI GRAN</h1></div>
</div>
</div>
<div style="clear:both;padding-bottom:5px;"></div>
<div style="clear:both;padding-bottom:10px;"></div>
<div id="topright">
</div></div></div><div style="clear:both;padding-bottom:5px;"></div>
		<table border="0" cellpadding="0" cellspacing="0" width="100%"><tbody><tr><td align="left" colspan="2">
		<div class="subLine" style="text-align: left">
		<spam class="tituloHotel">AGROTURISMO MATCHANI GRAN</spam>	
		</div>
		<br>
			<div style="float:left;width:120px">
				<div style="float:left;width:70px">
					<div style="height: 24px; width: 106px; display: inline-block; text-indent: 0px; margin: 0px; padding: 0px; background-color: transparent; border-style: none; float: none; line-height: normal; font-size: 1px; vertical-align: baseline; background-position: initial initial; background-repeat: initial initial; " id="___plusone_0"><iframe allowtransparency="true" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" style="position: static; top: 0px; width: 106px; margin: 0px; border-style: none; left: 0px; visibility: visible; height: 24px; " tabindex="0" vspace="0" width="100%" id="I0_1347206620648" name="I0_1347206620648" src="https://plusone.google.com/_/+1/fastbutton?bsv=pr&amp;url=http%3A%2F%2Fwww.online4you.es%2Findex.php%3Foption%3Dcom_hotelguide%26view%3Dhotel%26id%3D107%3Aagroturismo-matchani-gran%26lang%3Des&amp;size=standard&amp;count=true&amp;origin=http%3A%2F%2Fwww.online4you.es&amp;hl=en-US&amp;jsh=m%3B%2F_%2Fapps-static%2F_%2Fjs%2Fgapi%2F__features__%2Frt%3Dj%2Fver%3DpCwk60nUi-0.en.%2Fsv%3D1%2Fam%3D!CRLPOQbbTO-YhNdiPQ%2Fd%3D1%2Frs%3DAItRSTPLUNp_bKos6UFmh_prfr8o8CDtMw#_methods=onPlusOne%2C_ready%2C_close%2C_open%2C_resizeMe%2C_renderstart%2Concircled&amp;id=I0_1347206620648&amp;parent=http%3A%2F%2Fwww.online4you.es" title="+1"></iframe></div>
				</div>
				<div style="float:right;width:50px">
					<fb:like href="http://www.online4you.es/index.php?option=com_hotelguide&amp;view=hotel&amp;id=107:agroturismo-matchani-gran&amp;lang=es" layout="button_count" show_faces="false" width="400" action="like" font="segoe ui" colorscheme="light" class=" fb_edge_widget_with_comment fb_iframe_widget">
				<span style="height: 20px; width: 73px; "><iframe id="fff053908" name="f350047d64" scrolling="no" style="border: none; overflow: hidden; height: 20px; width: 73px; " title="Like this content on Facebook." class="fb_ltr " src="http://www.facebook.com/plugins/like.php?action=like&amp;channel_url=http%3A%2F%2Fstatic.ak.facebook.com%2Fconnect%2Fxd_arbiter.php%3Fversion%3D11%23cb%3Df2b1af15f4%26origin%3Dhttp%253A%252F%252Fwww.online4you.es%252Ff93bc796c%26domain%3Dwww.online4you.es%26relation%3Dparent.parent&amp;colorscheme=light&amp;extended_social_context=false&amp;font=segoe%20ui&amp;href=http%3A%2F%2Fwww.online4you.es%2Findex.php%3Foption%3Dcom_hotelguide%26view%3Dhotel%26id%3D107%3Aagroturismo-matchani-gran%26lang%3Des&amp;layout=button_count&amp;locale=en_US&amp;node_type=link&amp;sdk=joey&amp;show_faces=false&amp;width=400"></iframe></span></fb:like></div>
			</div>
			 	
		<div style="clear:both;padding-bottom:10px;"></div>
		</td></tr><tr><td height="25" valign="top" align="center">

		<p style="text-align:left"><a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/main_107.jpg" rel="lightbox" title="AGROTURISMO MATCHANI GRAN"><img class="catimage" style="border-color:#DEDEDE" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/resize/main_107.jpg" align="left" margin-right="10px" alt="AGROTURISMO MATCHANI GRAN"></a></p><div style="clear:both;padding-bottom:10px;"></div>
<div class="desdeHotel" style="position: relative; top: 0px;"><table border="0" cellpadding="0" cellspacing="0" width="100%"><tbody><tr><td align="center"><br>Desde&nbsp;62&nbsp;€<br>Por Unidad</td></tr></tbody></table></div>				<br>
				<button class="botonReserva" onclick="javascript: reservarHotel('107','Agroturismo Matchani Gran');">Reservar</button>
				</td><td>
				
				<div id="hotelContent"><h2>
	Matchani Gran, Alaior, Menorca</h2>
<br>
<p>
	<strong>Agroturismo Matchani Gran</strong> es una tipica casa de campo menorquina que ha sido restaurada y convertida en un pequeño y familiar agroturismo dedicado a la ramaderia, sus 40 corderos y 2 simpaticos burritos pastan por las 40 hectareas de terreno de que dispone la finca.<br>
	<br>
	<br>
	La playa más cercana de <strong>Agroturismo Matchani Gran</strong> es la de Binidali que está&nbsp; a 3&nbsp; minutos en coche.<br>
	<br>
	Distintivo de calidad de Platino&nbsp; hasta este verano 2010 en la página Trip Advisor<br>
	Certificada en el sistema de calidad Sicted<br>
	<br>
	Distancias:<br>
	Playa: 3 minutos en coche<br>
	Mahón: 6 km.<br>
	Sant Climent: 1.5 km</p></div><p></p><div style="clear:both;padding-bottom:10px;"></div>
</td></tr><tr><td colspan="2"><div id="topcontainer">
<div id="toprow">
<div id="topleft">
<ul id="top" class="feature">
<li class="feature">
<strong>Dirección:&nbsp;</strong>
Camino de San Climent a Binidali, 07712 Alaior (Menorca)</li>
<li class="feature">
<strong>Ciudad:&nbsp;</strong>
Sant Climent - Alaior</li>
<li class="feature">
<strong>Zona:&nbsp;</strong>
Menorca</li>
<li class="feature">
<strong>País:&nbsp;</strong>
España</li>
</ul>
</div></div></div></td></tr></tbody></table><div style="clear:both;"></div>

<div style="clear:both;padding-bottom:10px;"></div>
<div id="mappaneltab" class="ddpaneltab" style="color:#545454">
	<a style="float: right;background-color: #178EB6;" href="javascript:void(0)" onclick="appendBootstrap(); changeMapText();">
		<span style="color:#ddd"><img src="components/com_hotelguide/assets/images/arrow-down.gif" class="pointerimage" style="border-width: 0px; "></span>
		<span id="openCloseMap" style="color:#ddd">Abrir Mapa</span>
	</a>
</div>
<div id="mappanel" class="ddpanel" style="float:left;width:100%">
	<div id="mappanelcontent" class="ddpanelcontent" style="background-color: rgb(243, 138, 18); height: 25px; overflow: hidden; ">
		<div style="margin:5px 7px 7px 5px">
			<h3 style="margin: 0; text-align:center; font-size:16px;">Localización</h3>
			<div id="mapcontent" class="ddpanelmap" style="width: 100%; height: 450px; overflow: hidden; ">
				<div id="map_canvas" style="width:100%; height: 450px"></div>
			</div>
		</div>
	</div>
</div>
<div style="clear:both;padding-bottom:10px;"></div>





<div class="qtwrapper qtwrap-round1">
<div class="qthead-round1">
<ul class="qtabs" id="qtabs-tab">
<li onclick="setTimeout('reDimension()',10);" class="open"><span>Habitaciones</span></li>
<li onclick="setTimeout('reDimension()',10);" class="closed"><span>Gastronomía</span></li>
<li onclick="setTimeout('reDimension()',10);" class="closed"><span>Servicios</span></li>
<li onclick="setTimeout('reDimension()',10);" class="closed"><span>Instalaciones</span></li>
<li onclick="setTimeout('reDimension()',10);" class="closed"><span>Galería</span></li>
<li onclick="setTimeout('reDimension()',10);" class="closed"><span>Contacto</span></li>
</ul>
</div>
<div class="qtcurrent current-round1" id="current-tab" style="border-color: rgb(222, 222, 222); background-image: url(http://www.online4you.es/components/com_hotelguide/assets/images/trans_m.png); background-color: transparent; height: 639px; background-position: 0px 0px; background-repeat: repeat repeat; ">
<div class="qtcontent" style="visibility: visible; zoom: 1; opacity: 1; top: 0px; left: 0px; ">
<div class="innerelement">
<h2>
	Habitaciones Agroturismo Matchani Gran</h2>
<br>
<br>
<p>
	<strong>Agroturismo Matchani Gran</strong> consta de 10 habitaciones.<br>
	&nbsp;</p>
<br>
<img alt="" src="/images/Habitaciones/matchani gran.jpg" style="width: 250px; height: 188px;"><br>
<br>
<br>
<p>
	Todas las habitaciones de <strong>Agroturismo Matchani Gran</strong> están equipadas con:<br>
	Aire acondicionado<br>
	Caja fuerte<br>
	Ventilador<br>
	Secador de pelo<br>
	Amenities (champú, gel, toallitas desmaquillantes)<br>
	Facilidades para hacer te y café<br>
	Selección de pastas para el café.<br>
	<br>
	<br>
	Limpieza y cambio de toallas diario.<br>
	<br>
	<br>
	Matchani Gran dispone una habitación más amplia que el resto,&nbsp;está equipada con una cama doble de 1.80 y dos divanes de 90x200, esta habitación se facilitará en el caso de reservar 2 adultos &amp; 1 niño o 2 adultos &amp; 2 niños.<br>
	En esta habitación el 1er Niño no se cobrará.<br>
	Al sólo haber una habitación de estas caracteristicas se reservará bajo petición y se la confirmaremos o denegaremos en 24 horas.<br>
	<br>
	Agroturismo Matchani Gran dispone tambien de una piscina exterior, zona de solarium, jardin y terrazas.</p><div style="clear:both;padding-bottom:10px;"></div>
</div>
</div>
<div class="qtcontent" style="visibility: hidden; zoom: 1; opacity: 0; ">
<div class="innerelement">
<div class="innerelement">
<p style="text-align:left"></p><h2>
	Restauración Agroturismo Matchani Gran</h2>
<br>
<p>
	En <strong>Agroturismo Matchani Gran</strong>, la antigua boyera de 250 metros ha sido habilitada y cumple la función de pequeño salón con t.v. vía satélite, rincón de internet y comedor, la misma ha sido decorada con útiles y herramientas que usaban antiguos payeses de la finca en el desempeño de sus labores agrícolas.<br>
	<br>
	En Agroturismo <strong>Matchani Gran</strong> tiene&nbsp; una cocina de gas/carbón, barbacoa a su disposición.<br>
	En Sant climent encontrará un excelente supermercado donde adquirir los productos.<br>
	<br>
	En Agroturismo <strong>Matchani Gran</strong> servimos un desayuno continental que consiste en melón, fruta, zumo de naranja, yogurt y cereales.<br>
	Bollería fresca y huevos revueltos o hervidos.<br>
	Selección de hierbas para el Te.</p><p></p></div>
</div>
</div>
<div class="qtcontent" style="visibility: hidden; zoom: 1; opacity: 0; ">
<div class="innerelement">
<div class="innerelement">
<p style="text-align:left"></p><div>
	<h2>
		Condiciones de Reserva</h2>
	<br>
	Para reservar se realiza un pequeño prepago (normalmente el 15%) el resto se paga a la llegada del hotel. Exceptuando las tarifas no reembolsables en las que se ha de abonar el 100% del importe.<br>
	Reservas bajo petición serán confirmadas o anuladas en un plazo máximo de 24 horas laborales a la creación de la reserva.<br>
	&nbsp;<br>
	<h5>
		Cancelaciones &amp; Cambios</h5>
	<br>
	Cancelando con 7 días ó más de antelación a la fecha de entrada se devolverá el 100% del depósito pagado a cuenta, por la misma vía utilizada por el cliente al realizar el pago.<br>
	<br>
	Cancelando con menos de 7 días de antelación a la fecha de entrada o no presentación el día de llegada, se cobrará el 100% del depósito pagado a cuenta en concepto de gastos de anulación.<br>
	&nbsp;<br>
	Exceptuando las habitaciones con el texto NON-REFUND o NO REEMBOLSABLE que no admitirán cancelaciones bajo ningún concepto.<br>
	<br>
	<br>
	&nbsp;</div><p></p></div>
</div>
</div>
<div class="qtcontent" style="visibility: hidden; zoom: 1; opacity: 0; ">
<div class="innerelement">
<div style="clear:both;padding-bottom:10px;"></div>
<div style="clear:both;padding-bottom:10px;"></div>
<div class="frametitle"><strong>?&nbsp;&nbsp;SERVICES&nbsp;&nbsp;?</strong>
<div class="frame" style="border:none">
<div class="imagecontent" style="float:left; width:240px; margin-right:16px;">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/servicios.jpg" rel="lightbox" title="SERVICES"><img src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/resize/servicios.jpg" width="240px" alt=""></a></div><div class="textcontent">
<h2>
	Instalaciones y servicios Matchani Gran</h2>
<br>
<br>
<p>
	Agroturismo Matchani Gran es un espacio ideal para aquel que busque relax, tranquilidad y contacto con la naturaleza.<br>
	<br>
	<br>
	&nbsp;Agroturismo Matchani Gran dispone tambien de una piscina exterior, zona de solarium, jardin y terrazas.<br>
	&nbsp;<br>
	El acceso a la finca transcurre a lo largo de un precioso camino de 250 mtr flanqueado por pinos y situado a 6 km de mao y a 1,5 km del pueblo de sant climent , en el cual podra encontrar restaurantes de reconocido prestigio, club de jazz, bares, supermercado , autobus de linea etc. Agroturismo Matchani Gran se encuentra tambien cercano a las bonitas calas de binidali y biniparratx, canutells, calan porter y la famosa cueva de xoroy.<br>
	<br>
	<br>
	&nbsp;</p>
<h2>
	Como&nbsp; <span>llegar</span> a Agroturismo Matchani Gran</h2>
<br>
<p>
	<strong><span>Desde</span> el <span>aeropuerto</span>:</strong><br>
	<br>
	Al <span>salir</span> del <span>aeropuerto</span> encontrará una rotonda con un obelisco en el centro, coja la tercera salida, dirección a Calan Porter y Sant Climent (Me-12)<br>
	&nbsp;Siga la carretera aproximadamente&nbsp; 1 km y cuando entre en Sant Climent gire a la izquierda dirección a&nbsp; Canutells y Binidali. Siga la carretera aproximadamente 1 km a su izquierda podrá ver la entrada de&nbsp; Matchani Gran flanqueada por 2 largas filas de columnas blancas con una bolas encima de color rosa, el color tipico rosa menorquin. El camito está flanqueado con 100 arboles más o menos 1/3 km. aparque en el parking y vaya andando hasta la entrada de <strong>Agroturismo Matchani Gran</strong> donde le estaremos esperando <span>para</span> darle la bienvenida.</p>
<p>
	&nbsp;</p></div></div>
</div>
<div style="clear:both;padding-bottom:10px;"></div>
<div style="clear:both;padding-bottom:10px;"></div>
<p style="text-align:center; font-weight:bold;">Equipamiento habitaciones</p><p style="font-weight:normal"></p><div id="list_wrapper"><ul class="multiple_columns">
<li>Aire Acondicionado</li>
<li>Televisión</li>
</ul></div>
<div style="clear:both;padding-bottom:10px;"></div>
<p></p></div>
</div>
<div class="qtcontent" style="visibility: hidden; zoom: 1; opacity: 0; ">
<div class="innerelement">
<div id="ThumbMatrix">
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/1.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/1.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/2.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/2.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/3.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/3.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/4.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/4.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/5.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/5.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/6.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/6.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/7.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/7.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/8.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/8.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/9.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/9.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/10.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/10.jpg"></a></div>
<div class="AlbumCell" style="width: 105px; height: 50px">
<a href="http://www.online4you.es/images/hotelguide/gallery/hotel_107/album/11.jpg" rel="lightbox-gallery" title="AGROTURISMO MATCHANI GRAN"><img class="thumbnail" src="http://www.online4you.es/images/hotelguide/gallery/hotel_107/thumb/11.jpg"></a></div>
</div>
</div>
</div>
<div class="qtcontent" style="visibility: hidden; zoom: 1; opacity: 0; ">
<div class="innerelement">
				
            <form action="/index.php?option=com_hotelguide&amp;view=hotel&amp;id=107%3Aagroturismo-matchani-gran&amp;lang=es&amp;task=sendmail" method="post" enctype="application/x-www-form-urlencoded">
				
					<input type="hidden" name="showAlert" value="true">
					
                    <p><label for="name">Nombre :</label><br>
                       <input type="text" name="name" id="name" value="" size="40">
                    </p>
                    
                    <p><label for="email">Correo electrónico :</label><br>
                       <input type="text" name="email" id="email" value="" size="40">
                    </p>
                    <p>Asegúrese de que su dirección de correo electrónico es correcta. </p>
                    <p><label for="subject">Asunto :</label><br>
                       <input type="text" name="subject" id="subject" value="Ref : " size="40"></p>                  
                    <p><label for="e_message">Mensaje :</label><br> 
                       <textarea name="e_message" id="e_message" rows="10" cols="80%"></textarea>
                    </p>
                    <p>(La información aquí proporcionada sólo será utilizada para responder a sus preguntas) </p><br> 
                        <div>
                        <img id="captcha" align="left" style="margin-right: 15px; border: 1px solid #000" src="/components/com_hotelguide/lib/securimage/securimage_show.php" alt="CAPTCHA Image">
                        <!--<object type="application/x-shockwave-flash" data="/components/com_hotelguide/lib/securimage/securimage_play.swf?audio=/components/com_hotelguide/lib/securimage/securimage_play.php&amp;bgColor1=#fff&amp;bgColor2=#fff&amp;iconColor=#777&amp;borderWidth=1&amp;borderColor=#000" height="19" width="19">
                        <param name="movie" value="/components/com_hotelguide/lib/securimage/securimage_play.swf?audio=/components/com_hotelguide/lib/securimage/securimage_play.php&amp;bgColor1=#fff&amp;bgColor2=#fff&amp;iconColor=#777&amp;borderWidth=1&amp;borderColor=#000" /></object><br /> 
						-->
                        <a href="#" onclick="document.getElementById('captcha').src = '/components/com_hotelguide/lib/securimage/securimage_show.php?' + Math.random(); return false"><img src="/components/com_hotelguide/lib/securimage/images/refresh.gif" alt="Reload Image" border="0" onclick="this.blur()" align="bottom"></a></div>
                        <p>Código de la imagen de arriba :</p>
                        <input type="text" name="captcha_code" size="10" maxlength="6" style="width: 120px">&nbsp;                  
                        <br><br>                     <p>
                    <input type="hidden" name="created_by" value="63">
                    <input type="submit" value="Enviar">           
                    </p>
            </form>  
</div>
</div>
</div>
<script type="text/javascript">
	window.addEvent('domready', function(){ 
	var opt = {
			flexHeight: true,
			scrolling: 'rl'		
		};
	var t2 = new QTabs('tab', opt); 
})
</script>
</div>
<div style="clear:both;padding-bottom:15px;"></div>
<div style="clear:both;padding-bottom:10px;"></div>
  
<!-- Item navigation -->
    <div class="itemNav">
    		</div>
<div style="clear:both;padding-bottom:10px;"></div>
<div id="lastHotelDiv" style="clear:both;padding-bottom:10px;"></div>
</div>

<script language="JavaScript">


  
  
function changeMapText(){
	if (document.getElementById('openCloseMap').innerHTML=='Abrir Mapa'){
		document.getElementById('openCloseMap').innerHTML='Cerrar Mapa';}
	else{
		document.getElementById('openCloseMap').innerHTML='Abrir Mapa';}
	document.getElementById('mappanelcontent').style.height='35px';
	setTimeout('reDimension()',10);
}
</script>
		</div>
<!-- end detaleDelHotel -->
