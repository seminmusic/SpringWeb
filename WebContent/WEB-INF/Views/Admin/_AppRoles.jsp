<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover" style="table-layout:fixed">
	<tbody>
		<c:forEach var="rola" items="${model.roles != null ? model.roles : roles}">
			<tr>
				<td style="width:15%">${rola.nazivRole}</td>
				<td>
					<c:forEach var="korisnik" items="${rola.korisniciRole}">
						<span class="label label-default" style="margin-right:8px">
							<i class="fa fa-user"></i>&nbsp; ${korisnik}
						</span>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
