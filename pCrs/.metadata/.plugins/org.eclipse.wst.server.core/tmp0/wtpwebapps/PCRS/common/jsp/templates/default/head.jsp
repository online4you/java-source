<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:iterator var="styleHref" value="styles" status="styleHrefStat"  >
	<link href="<s:property value="getContextPath()+genValue"/>" rel="stylesheet" type="text/css" />	
</s:iterator>

<s:iterator var="metaTags" value="metas" status="metaTagsStat"  >
	<meta name="<s:property value="id"/>" content="<s:property value="trnValue"/>">
</s:iterator>

<s:iterator var="scripts" value="scripts" status="styleHrefStat"  >
	<script type="text/javascript" src="<s:property value="getContextPath()+genValue"/>"></script>
</s:iterator>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=en"></script>

