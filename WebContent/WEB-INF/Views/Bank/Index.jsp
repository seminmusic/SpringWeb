<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Bank List</h1>
<div style="margin:20px 0">
	<a href="new-bank" class="btn btn-success">
		<i class="fa fa-plus"></i>&nbsp; New Bank
	</a>
</div>
<div>
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>ID</th>
				<th>Bank Name</th>
				<th>Status</th>
				<th>BIN</th>
				<th>UPP ID</th>
				<th>Bamcard ID</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bank" items="${banks}">
				<tr>
					<td>${bank.bankId}</td>
					<td>${bank.bankName}</td>
					<td>${bank.status}</td>
					<td>${bank.bin}</td>
					<td>${bank.uppId}</td>
					<td>${bank.bamcardId}</td>
					<td>
						<a href="edit-bank?bankId=${bank.bankId}" style="float: left">
							<i class="fa fa-pencil" style="color: blue"></i> Edit Bank
						</a>
						<a href="delete-bank?bankId=${bank.bankId}" style="float: right">
							<i class="fa fa-times" style="color: red"></i> Delete Bank
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
