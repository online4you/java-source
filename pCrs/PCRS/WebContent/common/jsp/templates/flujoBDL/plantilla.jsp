<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:set name="path" value="getContextPath()"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<s:if test="metaTitle!=null">
		<title><s:property value='metaTitle'/></title>
	</s:if>
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  	
  		<tiles:insertAttribute name="head" />
  	
		<script type="text/javascript">
			var $j=jQuery;
		</script>
		<s:if test="getLocale().getLanguage()!='en'">
			<script type="text/javascript" src="<s:property value="getContextPathStatic()"/>/static/main/js/uiLocale/uiLocale_<s:property value="getLocale().getLanguage()"/>.js"></script>
		</s:if>
</head>
<body >
<!-- INI -->
<div id="header">
	<tiles:insertAttribute name="header" />
</div>	
<div class="art-contentLayout"> 
	<table border="0" width="880" cellspacing="1" cellpadding="1" style="table-layout:fixed" id="tbottomDiv">
	<tbody>
		<tr> 
			<tiles:insertAttribute name="content" />
		</tr>
	</tbody>
	</table>
	
</div>
<div id="footer">
	<tiles:insertAttribute name="footer" />
</div>

</body>
</html>
<!-- FIN -->
