<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:importAttribute name="css_core" />
<tiles:importAttribute name="css_dodatno" />
<tiles:importAttribute name="js_core" />
<tiles:importAttribute name="js_dodatno" />


<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/images/kviko-logo.png" />
		
		<!-- Tiles - Title: -->
		<title><tiles:getAsString name="title"></tiles:getAsString></title>
		
		<!-- Tiles - CSS Core: -->
	    <c:forEach var="style" items="${css_core}">
	    	<link rel="stylesheet" type="text/css" href="<c:url value="${style}" />" />
	    </c:forEach>
	    <!-- Tiles - CSS Dodatno: -->
	    <c:forEach var="style" items="${css_dodatno}">
	    	<link rel="stylesheet" type="text/css" href="<c:url value="${style}" />" />
	    </c:forEach>
	    <!-- Site CSS: -->
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/_custom/site.css" />
	</head>
	<body>
		<!-- Tiles - Menu: -->
		<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		
		<div class="container body-content">
			<!-- Tiles - Body: -->
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
			<!-- Tiles - Footer: -->
			<tiles:insertAttribute name="footer"></tiles:insertAttribute>
		</div>
		
		<!-- Tiles - JS Core: -->
		<c:forEach var="script" items="${js_core}">
			<script type="text/javascript" src="<c:url value="${script}" />"></script>
		</c:forEach>
		<!-- Tiles - JS Dodatno: -->
		<c:forEach var="script" items="${js_dodatno}">
			<script type="text/javascript" src="<c:url value="${script}" />"></script>
		</c:forEach>
	</body>
</html>
