<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>
            Activación de dispositivos a distancia
        </title>
        <link rel="stylesheet" type="text/css" href="<s:property value="getContextPath()"/>/static/ExtJS/resources/css/ext-all.css">
        <link rel="stylesheet" type="text/css" href="<s:property value="getContextPath()"/>/static/main/css/pRemote.css">
		<link href="<s:property value="getContextPath()"/>/static/jdpicker_1.1/jdpicker.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/ExtJS/ext-all.js"></script>
        <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/main/js/jquery-1.8.1.js"></script>
        <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/main/js/jquery-1.8.1.js"></script>
        <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/jdpicker_1.1/jquery.jdpicker.js"></script>
       	
       	
        <script type="text/javascript">
			var $j=jQuery;
		</script>
        <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/main/js/pRemote.js"></script>
        
        
        <script type="text/javascript">
       		var jsonUrl='<s:property value="getContextPath()"/>/apps/pRemote/jsonDevices.html';
       		var operationUrl="<s:property value='getContextPath()'/>/apps/pRemote/jsonOperateDevice.html";
       		var deviceContentUrl="<s:property value='getContextPath()'/>/apps/pRemote/DeviceDetail.html";
       		
       		$j(document).ready(function() {
       			//tree.expand();
       		});
        </script>
        
    </head>
    <body>
    	 <div style="display: table;width: 100%;">
	        	<div style="display: table-row;width: 100%;">
	        		 <div style="display: table-cell;width:20%;vertical-align: top;">
	        		 		<div style="overflow:hidden;border-style: solid;border-color: #47B224;border-radius: 15px;padding: 5px;" id="treePanel"></div>
	        		 </div>
	        		 <div style="display: table-cell;">
	        		 		<div style="overflow:hidden;border-style: solid;display: inline-block;border-color: #47B224;border-radius: 15px;" id="deviceContent">content</div>
	        		 </div>
	        	</div>
	     </div>
    	
    </body>
</html>
