<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="loadGoogleScript()">
		<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=en"></script>
</s:if>
<script type="text/javascript"> 
	var initLat=<s:property value="lat"/>;
	var initLon=<s:property value="lng"/>;
	var initZoom=<s:property value="zoom"/>;

			var markersArray= new Array();
			var mapZona = {
			  map: null,
			  infoWindow: null
			};
			  
			/**
			 * Called when clicking anywhere on the map and closes the info window.
			 */
			mapZona.closeInfoWindow = function() {
			  mapZona.infoWindow.close();
			};
			 
			/**
			 * Opens the shared info window, anchors it to the specified marker, and
			 * displays the marker's position as its content.
			 */
			mapZona.openInfoWindow = function(marker, txt) {
			  var markerLatLng = marker.getPosition();
			  mapZona.infoWindow.setContent([
			    txt
			  ].join(''));
			  mapZona.infoWindow.open(mapZona.map, marker);
			},
			 
			/**
			 * Called only once on initial page load to initialize the map.
			 */
			mapZona.init = function() {
			  	dlat = initLat;
				dlon = initLon;
				dzoom = initZoom;
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
			 
						mapTypeId: google.maps.MapTypeId.ROADMAP		}
			 
				mapZona.map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);  

			 		/*
			  		google.maps.event.addListener(mapZona.map, 'center_changed', function()
				  		      {getLantLongZoom()});
			  		google.maps.event.addListener(mapZona.map, 'zoom_changed', function()
				  		      {getLantLongZoom();});

			  		
			  		google.maps.event.addListener(mapZona.map, 'click', function(location)
                    {
                            var latLon   = location.latLng;
            				mapZona.map.setCenter(latLon);
            				setMarker();
                    });
  		         
			  		google.maps.event.addListener(mapZona.map, 'rightclick', function(location)
		                    {
		                            var latLon   = location.latLng;
		                            var decText  = latLon.toString();
		                            var theHtml  = "Hiiii";
		                            var infoWindow = new google.maps.InfoWindow({content: theHtml,position: latLon});
		                            infoWindow.open(mapZona.map);
		                    });
*/

					google.maps.event.addListener(mapZona.map, 'rightclick', function(location)
		            {
		                    var latLon   = location.latLng;
		    				mapZona.map.setCenter(latLon);
		    				getLantLongZoom() ;
		            });


					var centerLatLng = new google.maps.LatLng(initLat,initLon);
					var marker = new google.maps.Marker({map: mapZona.map,position: centerLatLng});
					markersArray.push(marker);
	    			
			 
			}
			function setMarker(){
				eraseMarkers();
				var centerLatLng = new google.maps.LatLng(mapZona.map.getCenter().lat(),mapZona.map.getCenter().lng());
				var marker = new google.maps.Marker({map: mapZona.map,position: centerLatLng});
				markersArray.push(marker);
			}
			function eraseMarkers(){
				if (markersArray) {     
    				for (i in markersArray) {       
        				markersArray[i].setMap(null);     
        				}
    				markersArray.length = 0;    
    			}  
			} 
			 
			function ini() {
				//document.getElementById('mappanelcontent').style.height='450px';
				document.getElementById("lat").value=initLat;
				document.getElementById("lon").value=initLon;
				document.getElementById("zoom").value=initZoom;
				mapZona.init();
				var centerLatLng = new google.maps.LatLng(initLat,initLon);
				mapZona.map.setCenter(centerLatLng);
				mapZona.map.setZoom(initZoom);
			}
			function getLantLongZoom() {
				document.getElementById("lat").value=mapZona.map.getCenter().lat();
				document.getElementById("lon").value=mapZona.map.getCenter().lng();
				document.getElementById("zoom").value=mapZona.map.getZoom();
				setMarker();	
			}
			function reestablecer() {
				var centerLatLng = new google.maps.LatLng(initLat,initLon);
				mapZona.map.setCenter(centerLatLng);
				mapZona.map.setZoom(initZoom);
				eraseMarkers(); 
				var marker = new google.maps.Marker({map: mapZona.map,position: centerLatLng});
				markersArray.push(marker);	
			}
			
			
</script>

<div id="mappanelcontent">
		<div id="map_canvas" style="width:440px; height:350px;"></div>
		</div>
		
			<div style="display:none;">
				lat:<input name="lat" id="lat" type="text"  size="10"  value=""/><br>
				lng:<input name="lng" id="lon" type="text"  size="10"  value=""/><br>
				zoom:<input name="zoom" id="zoom" type="text"  size="5"  value=""/><br>
			</div>		
<script type="text/javascript">
ini();
</script>
		
		