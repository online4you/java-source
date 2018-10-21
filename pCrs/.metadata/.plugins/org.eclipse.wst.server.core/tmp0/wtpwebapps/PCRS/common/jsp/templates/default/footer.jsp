<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
        <div id="footer">
        	<div class="footer-izd">
                                               
            	<div class="info-box">
                	<p><strong><s:property value="getText('lang.gen.PIE_1')"/></strong></p>
                    <!-- p><s:property value="getText('lang.gen.PIE_TLF')"/></p-->
                    <p><s:property value="getText('lang.gen.provisionalTelefonoPie')"/></p>
                    <p><s:property value="getText('lang.gen.PIE_HOR')"/></p>                    
                </div>                
            </div>
        	<div class="footer-links">
       
				   
				<ul>
                    <s:iterator var="menu" value="menusPieGrupo1" status="menuStat"  >
						<li>
	                    	<a href="<s:property value="#menu.menu.gmeLinksecc"/>" title="<s:property value="#menu.menu.gmeDes"/>" ><s:property value="#menu.menu.gmeDes"/></a>
	                	</li>
	                </s:iterator>
                </ul>      
				<ul>
                    <s:iterator var="menu" value="menusPieGrupo2" status="menuStat"  >
						<li>
	                    	<a href="<s:property value="#menu.menu.gmeLinksecc"/>" title="<s:property value="#menu.menu.gmeDes"/>" ><s:property value="#menu.menu.gmeDes"/></a>
	                	</li>
	                </s:iterator>
                </ul>      

            <ul>
				<li>
					<s:property value="getText('lang.gen.pie.trypadvisor')"/>
					
					<a href="http://www.tripadvisor.es"><img src="<s:property value="getContextPath()"/>/static/main/images/common1024/tripadvisor_logo_132x24-13964-0.gif" alt="<s:property value="getText('lang.gen.pie.trypadvisor')"/>TripAdvisor" title="<s:property value="getText('lang.gen.pie.trypadvisor')"/>"/></a>
				</li>
			</ul>
			
            </div>  
            <div class="footer-inferior">
                <a href="/" title="Halcón Viajes">
                    <img src="<s:property value="getContextPath()"/>/static/main/images/HAL1024/viajes-vuelos-halcon-gris.png" height="50" width="150" alt="Halcón Viajes"/>
                </a>
                <p class="datos-empresa">
                    Viajes Halcón S.A.U, CIF A-10005510, con domicilio en Llucmajor, Carretera Arenal a Llucmajor Km 21,5 Poligono Son Noguera inscrita en el Registro Mercantil de Palma de Mallorca, Tomo 2032, Libro 0, folio 120, Hoja PM-45899, inscripción 2ª. - C.I -BAL 478.
                </p>
            </div>          
        </div>
        <!--<s:property value="getTimeStamp()"/>-->
