<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover" style="table-layout:fixed">
	<tbody>
		<c:forEach var="rola" items="${model.roles}">
			<tr>
				<td>${rola.nazivRole}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
