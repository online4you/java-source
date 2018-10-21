<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
response.setStatus(301);
response.setHeader( "Location", "/PCRS/apps/bdl/destinos.html");
response.setHeader( "Connection", "close" );
%>
