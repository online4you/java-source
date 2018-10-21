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
							<s:property value="hotel.nombre.toUpperCase()"/></h1></div>
					</div>
				</div>
				<div style="clear:both;padding-bottom:5px;"></div>
				<div style="clear:both;padding-bottom:10px;"></div>
				<div id="topright"></div>
			</div>
		</div>
		<div style="clear:both;padding-bottom:5px;"></div>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td align="left" colspan="2">
					<div class="subLine" style="text-align: left">
						<spam class="tituloHotel"></spam>	
					</div>
					<br>
					<div style="clear:both;padding-bottom:10px;"></div>
				</td>
			</tr>
			<tr>
				<td height="25" valign="top" align="center">
					<p style="text-align:left">
						<img height="105px" width="105px" alt="<s:property value="hotel.nombre.toUpperCase()"/>" title="<s:property value='hotel.nombre.toUpperCase()'/>" src="<s:property value='getLogoHotel(hotel)'/>" style="border-color:#DEDEDE" class="listimage">
					</p>
					<div style="clear:both;padding-bottom:10px;"></div>
					<br>
				</td>
				<td>
					<div id="hotelContent" style="margin: 15px;"><h2>
						<s:property value="hotel.nombre"/>, <s:property value="hotel.zona"/></h2>
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
							<s:property value="des.hotelLocationDescription"/>
							</p>
						</s:if>
						<br>
						<s:if test="des.hotelHowToGetThere!=null && !des.hotelHowToGetThere.equals('')">
							<p>
							<s:property value="des.hotelHowToGetThere"/>
							</p>
						</s:if>
					</div>
					<p>
					<a haref="https://maps.google.com/maps?q=<s:property value='hotel.latitud'/>,<s:property value='hotel.longitud'/>&hl=<s:property value='getLocale().getLanguage()'/>&z=19">
							<s:text name="lang.gen.crs.i_mapagoogle"/>					
					</a>
					</p>
					<div style="clear:both;padding-bottom:10px;"></div>
				</td>
			</tr>
			<!-- 
			<tr>
				<td colspan="2">
					<div id="topcontainer">
						<div id="toprow">
							<div id="topleft">
								<ul id="top" class="feature">
									<li class="feature">
										<strong>Dirección:&nbsp;</strong>
										Camino de San Climent a Binidali, 07712 Alaior (Menorca)
									</li>
									<li class="feature">
										<strong>Ciudad:&nbsp;</strong>
										Sant Climent - Alaior
									</li>
									<li class="feature">
										<strong>Zona:&nbsp;</strong>
										Menorca
									</li>
									<li class="feature">
										<strong>País:&nbsp;</strong>
										España
									</li>
								</ul>
							</div>
						</div>
					</div>
				</td>
			</tr>
			 -->
		</tbody>
	</table>
</div>
<script type="text/javascript">
	$j().ready(function() {
		if (parent.location != window.location) {
			eval("parent.autoResize('iframeResultados');");
		}
	});
</script>
<!-- end detaleDelHotel -->
