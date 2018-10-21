<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- head -->
<meta name="robots" content="index,follow" />
<s:if test="metaTitle!=null">
	<meta name="title" content="<s:property value='metaTitle'/>">
</s:if>
<s:if test="metaTitle!=null">
	<meta name="keywords" content="<s:property value='metaKeywords'/>, hotel, oferta, offer, oferta todo incluido, all inclusive offer">
</s:if>
<s:if test="metaDescription!=null">
	<s:set name="descri" value="metaDescription"/>
	<s:if test="#descri.length()>200">
		<meta name="description" content="<s:property value='#descri.substring(0,200)'/>">
	</s:if>
	<s:else>
		<meta name="description" content="<s:property value='#descri'/>">
	</s:else>
	
</s:if>

<s:iterator var="styleHref" value="styles" status="styleHrefStat"  >
	<link href="<s:property value="getContextPathStatic()+genValue"/>" rel="stylesheet" type="text/css" />	
</s:iterator>

<s:iterator var="metaTags" value="metas" status="metaTagsStat"  >
	<meta name="<s:property value="id"/>" content="<s:property value="trnValue"/>">
</s:iterator>

<s:iterator var="scripts" value="scripts" status="styleHrefStat"  >
	<script type="text/javascript" src="<s:property value="getContextPathStatic()+genValue"/>"></script>
</s:iterator>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=<s:property value='getLocale().getLanguage()'/>"></script>



<!-- end head -->