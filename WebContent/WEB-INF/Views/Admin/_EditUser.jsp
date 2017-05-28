<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tr class="tr-edit">
	<td colspan="5">
		<form:form modelAttribute="user" class="form-inline">
			<form:hidden path="korisnikId" />
			<div style="float:left; margin-right:8px">
				<form:input path="ime" class="form-control" type="text" autocomplete="off" placeholder="Ime" />
			</div>
			<div style="float:left; margin-right:8px">
				<form:input path="prezime" class="form-control" type="text" autocomplete="off" placeholder="Prezime" />
			</div>
			<div style="float:left; margin-right:8px">
				<form:input path="email" class="form-control" type="text" autocomplete="off" placeholder="E-mail" />
			</div>
			<div style="float:left">
				<form:input path="username" class="form-control" type="text" autocomplete="off" placeholder="Username" />
			</div>
			<div style="float:right">
				<button type="button" class="btn btn-sm btn-success" style="margin:2px 0;">
					<i class="fa fa-check"></i>&nbsp; Save
				</button>
				<button type="button" class="btn btn-sm btn-danger" style="margin:2px 0;">
					<i class="fa fa-times"></i>&nbsp; Cancel
				</button>
			</div>
		</form:form>
	</td>
</tr>
