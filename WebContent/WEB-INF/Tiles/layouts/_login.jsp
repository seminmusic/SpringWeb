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
		<link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/images/kviko-logo.png" />
		
		<!-- Tiles - Title: -->
		<title><tiles:getAsString name="title"></tiles:getAsString></title>
		
		<!-- Tiles - CSS: -->
	    <c:forEach var="style" items="${css}">
	    	<link rel="stylesheet" type="text/css" href="<c:url value="${style}"/>" />
	    </c:forEach>
	</head>
	<body>
		<div class="container">
			<!-- Tiles - Body: -->
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
		
		<!-- Tiles - JS: -->
		<c:forEach var="script" items="${js}">
			<script type="text/javascript" src="<c:url value="${script}"/>"></script>
		</c:forEach>
	</body>
</html>
