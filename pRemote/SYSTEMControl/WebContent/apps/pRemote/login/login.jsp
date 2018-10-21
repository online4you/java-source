<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>pRemote login</title>
    <link rel="stylesheet" type="text/css" href="<s:property value="getContextPath()"/>/static/main/css/pRemote.css" />
    <script type="text/javascript" src="<s:property value="getContextPath()"/>/static/main/js/jquery-1.8.1.js"></script>
    <script type="text/javascript">
		var $j=jQuery;
	</script>
</head>
<body style="background-color:#000000;margin:0px; padding:0px;">	
<div id="loading" class="loadinCentrado" style="display:none;z-index:200">
	<img src="<s:property value='getContextPath()'/>/static/main/images/loading.gif"/>
</div>
<div class="loginContent" style="z-index:100">
	<div style="margin: 0px auto;">
		<form id="loginForm" action="#" method="post" >
				<div style="float:left">
					<div style="float:left">
						<div style="margin-top:4px">
							<strong><s:property value="getText('lang.gen.login.user')"/>:&nbsp;<strong>
						</div>
						<div style="margin-top:4px"> 
							<strong><s:property value="getText('lang.gen.login.password')"/>:&nbsp;<strong>
						</div>
					</div>
					<div style="float:right">
						<div style="margin-top:1px">
							<input id="username" style="height: 16px;width: 160px;" onkeypress="return submitenter(this,event)" name="username" type="text" value=""/>
						</div>
						<div style="margin-top:1px"> 
							<input id="password" style="height: 16px;width: 160px;" onkeypress="return submitenter(this,event)" name="password" type="password" value=""/>
						</div>
					</div>
				</div>
				<div style="float:none;clear:both;"/>
					&nbsp;
				</div>
				<div style="text-align:center">
					<button style="background-color: #47B224;width: 100px;" type="button" onclick="javascript: submitForm()"><strong><s:property value="getText('lang.gen.login.entrar')"/></strong></button>
				</div>
				<div style="float:none;clear:both;"/>
				<div style="text-align:center">
					<s:property value="%{loginMessage}"/>
				</div>	
		</form>
	</div>
</div>

</body>
</html>
<script type="text/javascript">
		function submitForm(){
			if($j('#username').val()!='' && $j('#password').val()!=''){
				$j('#loading').show();
				$j('#loginForm').submit();
			}
		}

		function submitenter(myfield,e){
			var keycode;
			if (window.event) keycode = window.event.keyCode;
			else if (e) keycode = e.which;
			else return true;
		
			if (keycode == 13){
				submitForm();
			   	return false;
			   }
			else
			   return true;
		}
		$j(document).ready(function(){
			var loginPage="<s:property value="getContextPath()"/>/apps/pRemote/login.html";
			var actualPage=location.href;
			var domainPage=actualPage.substring(0,actualPage.indexOf("<s:property value="getContextPath()"/>"));
			actualPage=actualPage.substring(actualPage.indexOf("<s:property value="getContextPath()"/>"),actualPage.lenght);
			if (loginPage!=actualPage && actualPage.indexOf("/apps/pRemote/login.html")<0){
				location.href=domainPage+loginPage;
			}
			<s:if test='login.equals("logedIn")'>
				location.href=domainPage+'<s:property value="%{mainPage}"/>';
			</s:if>

		}); 
	</script>


