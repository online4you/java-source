<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
	       	<td width="180" valign="top"> 
		       	<div class="art-sidebar1"> 
               		<div style="width:177px; height:144px; z-index:900; position:relative; background-image: url('<s:property value='getContextPath()'/>/static/crs/images/joomla/reservasTelefinicas.JPG'); left: 0px; top: 0px;"> 
						<tiles:insertAttribute name="telefono" />
			       	</div>   
			      	<!-- div style="width:177px;  z-index:900; position:relative; left: 0px; top: 5px;" class="ajustarBusqueda" id="divAjustarBusqueda"--> 
						<!-- tiles:insertAttribute name="filtro" /-->
			       	<!--  /div-->
			       	   
			       	<div style="width:177px; height:140px; z-index:900; position:relative; background-image: url('<s:property value='getContextPath()'/>/static/crs/images/joomla/newsletter.JPG'); left: 0px; top: 5px;">  
						<tiles:insertAttribute name="newsLetters" />
			       	</div>   
			       	<div style="width:177px; height:auto; z-index:900; position:relative; left: 0px; top: 5px; padding: 0px 0px 10px 0px"> 
			       		<tiles:insertAttribute name="banners" />
			       	</div>  
				 </div>
	       	</td>
          	<td width="100%" valign="top"> 
	          	<div class="art-Post">
				    <div class="art-Post-body">
						<div class="art-Post-inner">
							<div class="art-PostContent">
						       	<div class="hotelguide" id="hotelguide">
							       	<div>
										<tiles:insertAttribute name="datosReserva" />
							       	</div>   
							       	<div>
										<tiles:insertAttribute name="listadoHoteles" />
							       	</div>      
							    </div>
							</div>
						</div>
					</div>
				</div>
			</td>

