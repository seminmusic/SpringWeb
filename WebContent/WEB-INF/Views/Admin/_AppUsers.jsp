<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-hover" style="table-layout:fixed">
	<tbody>
		<c:forEach var="user" items="${model.users}">
			<tr>
				<td>
					${user.ime} ${user.prezime}
					<span class="edit-user" 
						  data-user-id="${user.korisnikId}" 
						  style="display:none; margin-left:10px; cursor:pointer"
						  title="Edit user ${user.ime} ${user.prezime}">
						<i class="fa fa-pencil" style="color:green"></i>
					</span>
				</td>
				<td>${not empty user.email ? "(".concat(user.email).concat(")") : ""}</td>
				<td><i>Username:</i> ${user.username}</td>
				<td style="font-weight:bold; ${user.status == 'Aktivan' ? 'color:green' : 'color:red'}">${user.status}</td>
				<td>
					<c:forEach var="rola" items="${user.roleKorisnika}">
						<span class="label label-primary">${rola}</span>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
