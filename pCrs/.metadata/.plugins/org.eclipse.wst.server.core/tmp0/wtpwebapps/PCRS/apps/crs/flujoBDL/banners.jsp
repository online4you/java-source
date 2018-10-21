<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- banners -->
<div class="art-nostyle">
	<div class="bannergroup">
		<s:iterator var="banner" value="leftBanners" status="bannersStat">
			<div class="banneritem" id="Banner<s:property value='#bannersStat.index'/>">
				<table border="0" height="68" cellspacing="0" cellpadding="0" width="178" style="table-layout:fixed">
							<tbody><tr>
							<td style="padding: 5px 20px 0;">&nbsp;<s:property value="#banner.name"/></td> 
							</tr>
							<tr>
							<td>
							<s:if test="#banner.clickurl.indexOf('LightBox=true')==-1">
								<a target="_blank" href="<s:property value="#banner.clickurl"/>">
									<img alt="Banner" src="/images/banners/<s:property value='#banner.imageurl'/>">
								</a>
							</s:if>
							<s:else>
								<a href="javascript: bannerInLightBox('index2.php?option=com_content&amp;view=article&amp;id=10&amp;LightBox=true','<s:property value="#bannersStat.index"/>');">
									<img alt="Banner" src="/images/banners/<s:property value='#banner.imageurl'/>">
								</a>	
							</s:else>
							<div class="clr"></div>
							</td>
							</tr>
			
					</tbody>
				</table>
			</div>
		</s:iterator>
	</div>
</div>

<script type="text/javascript">
	function setBannerFadeOn(id){
		//$j('#preloading').center();
		var pos=$j('#Banner'+id).offset();
		var left=pos.left;
		var top=pos.top;

		$j("#lightBanner").css( { "left":(left) + "px", "top":(top) + "px" } ); 
		$j('#lightBanner').show();
	} 
	function setBannerFadeOff(){
		$j('#lightBanner').hide();
	} 


	function bannerInLightBox(link,id){
		if (link.indexOf("/")!=0){
			link="/"+link;
		}
		if (link.indexOf("lang=")==-1){
			link=link+"lang=<s:property value='getLocale().getLanguage()'/>";
		}
		$j.ajax({ 
	        url: link, 
	        type: "get", 
	        // callback handler that will be called on success 
	        success: function(response, textStatus, jqXHR){ 
        		var str;
        		str='<div style="float:right"><a href="javascript: setBannerFadeOff()"><s:text name="lang.gen.crs.i_cerrar"/></a></div>';
        		str+=response;
	        	$j("#lightBanner").html(str);
        		setBannerFadeOn(id);
	        }, 
	        // callback handler that will be called on error 
	        error: function(jqXHR, textStatus, errorThrown){ 
	        	setBannerFadeOff();
	        	
	        }, 
	        // callback handler that will be called on completion 
	        // which means, either on success or error 
	        complete: function(){ 
	        	 //setFadeOff();
	        } 
	    }); 
		
		
	}
	
</script>
<!-- end banners -->
