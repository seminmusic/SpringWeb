<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>New / Edit Bank</h1>
<div>
	<form:form action="save-bank" method="post" modelAttribute="bank">
		<form:hidden path="bankId" />
		<div class="row" style="margin-top:25px">
			<div class="col-xs-3">
				<div class="form-group">
					<form:label path="bankName">Bank Name:</form:label>
					<form:input path="bankName" class="form-control" />
				</div>
			</div>
			<div class="col-xs-3">
				<div class="form-group">
					<form:label path="status">Status:</form:label>
					<form:input path="status" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<div class="form-group">
					<form:label path="bin">BIN:</form:label>
					<form:input path="bin" class="form-control" />
				</div>
			</div>
			<div class="col-xs-3">
				<div class="form-group">
					<form:label path="uppId">UPP ID:</form:label>
					<form:input path="uppId" class="form-control" />
				</div>
			</div>
			<div class="col-xs-3">
				<div class="form-group">
					<form:label path="bamcardId">Bamcard ID:</form:label>
					<form:input path="bamcardId" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row" style="margin-top:20px">
			<div class="col-xs-12">
				<button type="submit" class="btn btn-success" style="margin-right:10px">
					<i class="fa fa-check"></i>&nbsp; Save
				</button>
				<button type="button" class="btn btn-default" onclick="window.location.href='list'">
					<i class="fa fa-reply"></i>&nbsp; Cancel
				</button>
			</div>
		</div>
	</form:form>
</div>
