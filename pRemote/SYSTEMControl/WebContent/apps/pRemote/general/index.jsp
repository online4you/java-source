<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>
            Activación de dispositivos a distancia
        </title>
        <link rel="stylesheet" type="text/css" href="../../static/ExtJS/resources/css/ext-all.css">
        <link rel="stylesheet" type="text/css" href="../../static/main/css/treegrid.css">


        <script type="text/javascript" src="../../static/ExtJS/ext-all.js"></script>
        <script type="text/javascript" src="../../static/main/js/jquery-1.8.1.js"></script>
        <script type="text/javascript">
			var $j=jQuery;
		</script>
        <script type="text/javascript" src="../../static/main/js/treegrid.js"></script>
        
        <style type="text/css">
            .task {
                background-image: url(../../static/main/images/cog.gif) !important;
            }
            .task-folder {
                background-image: url(../../static/main/images/folder_go.gif) !important;
            }
        </style>
        
        <script type="text/javascript">
       		var jsonUrl='<s:property value="getContextPath()"/>/apps/pRemote/jsonDevices.html';
       		var operationUrl="<s:property value='getContextPath()'/>/apps/pRemote/jsonOperateDevice.html";
        </script>
        
    </head>
    <body>
        <div id="tree-example"></div>
    </body>
</html>
