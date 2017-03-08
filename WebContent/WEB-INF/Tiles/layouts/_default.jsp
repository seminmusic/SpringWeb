<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:importAttribute name="css" />
<tiles:importAttribute name="js" />


<!DOCTYPE html>

<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Tiles - Title: -->
		<title>
			<tiles:getAsString name="title"></tiles:getAsString>
		</title>
		
		<!--
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/site.css" />
		-->
		<!-- Tiles - CSS: -->
	    <c:forEach var="style" items="${css}">
	    	<link rel="stylesheet" type="text/css" href="<c:url value="${style}"/>" />
	    </c:forEach>
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
		
		<!--
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
		-->
		<!-- Tiles - JS: -->
		<c:forEach var="script" items="${js}">
			<script type="text/javascript" src="<c:url value="${script}"/>"></script>
		</c:forEach>
	</body>
</html>
