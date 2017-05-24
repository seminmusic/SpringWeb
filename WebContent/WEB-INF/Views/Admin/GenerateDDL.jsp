<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
	<h1>DDL</h1>
	<div>
		<c:forEach var="query" items="${createQueries}">
			<div>
				<pre>${query}</pre>
			</div>
		</c:forEach>
	</div>	
</div>
