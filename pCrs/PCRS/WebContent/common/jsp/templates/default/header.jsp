<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
        	<div id="logo">
            	<s:if test="logo!=null">
      			  	<a href="http://www.halconviajes.com" title="<s:property value="logo.getGenTitle()"/>"><img src="<s:property value="getContextPath()+logo.getGenValue()"/>" height="91" width="249" alt="<s:property value="getLogo().getGenAlt()"/>"/></a>
           	   	</s:if>
           	</div>
           	   	<s:if test="isPRO()">
					<div style="display:none;">      			  
      			  		<s:property value="getHostStamp()"/>
      			  	</div>
           	   	</s:if>
           	   	<s:else>
           	   		<div style="display:block;">      			  
      			  		<s:property value="getHostStamp()"/>
      			  	</div>
           	   	</s:else>
           	   
            
			<div id="banner">
				<div class="informacion">
					<h1><s:property value="getText('lang.gen.H1OFERTASINI')"/></h1>
					<p class="texto">
						<s:property value="getText('lang.gen.provisionalTelefonoCabecera')"/>
					</p>
					<s:property value="getText('lang.gen.PIE_1')"/>
				</div>				
			</div>
            <div class="navbar" id="jquerymenu">
                <ul>
                    <s:iterator var="menu" value="menus" status="menusStat"  >
						<li>
	                    	<a href="<s:property value="#menu.menu.gmeLinksecc"/>" title="<s:property value="#menu.menu.gmeDes"/>" ><s:property value="#menu.menu.gmeDes"/></a>
	                    <s:set name="subcount" value="#menu.submenu.size()"/>		
	                    <s:if test="#subcount!=0">
		                    <ul style="position: absolute">
			                    <s:iterator var="submenu" value="#menu.submenu" status="submenusStat"  >	
									<li>
			                    		<a href="<s:property value="#submenu.gopLnkopc"/>" title="<s:property value="#submenu.gopDes"/>" ><s:property value="#submenu.gopDes"/></a>
			                    	</li>
			                	</s:iterator>
		                	</ul>
	                	</s:if>
	                	</li>
	                </s:iterator>
                   
                </ul>            
			</div>   
			
			<script type="text/javascript">
			$j(document).ready(function(){
				jquerycssmenu.buildmenu("jquerymenu");
			
			}); 
		</script>
