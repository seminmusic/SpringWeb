<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>New / Edit Bank</h1>
<div>
	<form:form action="save-bank" method="post" modelAttribute="bank">
		<form:hidden path="bankId" />
		<div class="form-group">
			<form:label path="bankName">Bank Name:</form:label>
			<form:input path="bankName" class="form-control" />
		</div>
		<div class="form-group">
			<form:label path="status">Status:</form:label>
			<form:input path="status" class="form-control" />
		</div>
		<div>
			<button type="submit" class="btn btn-success">
				<i class="fa fa-check"></i>&nbsp; Save
			</button>
			<button type="button" class="btn btn-default" onclick="window.location.href='list'">
				<i class="fa fa-reply"></i>&nbsp; Cancel
			</button>
		</div>
	</form:form>
</div>
