<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h3 class="naslov-stranice">Bank List</h3>
<div style="margin:20px 0">
	<a href="${pageContext.request.contextPath}/banks/new-bank" class="btn btn-success">
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
				<sec:authorize access="hasAnyAuthority('ADMIN', 'UNOS')">
					<th>Action</th>
				</sec:authorize>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bankModel" items="${bankModels}">
				<tr>
					<td>${bankModel.bankId}</td>
					<td>${bankModel.bankName}</td>
					<td>${bankModel.status}</td>
					<td>${bankModel.bin}</td>
					<td>${bankModel.uppId}</td>
					<td>${bankModel.bamcardId}</td>
					<sec:authorize access="hasAnyAuthority('ADMIN', 'UNOS')">
						<td>
							<a href="${pageContext.request.contextPath}/banks/edit-bank/${bankModel.bankId}" style="float:left">
								<i class="fa fa-pencil" style="color: blue"></i> Edit Bank
							</a>
							<a href="${pageContext.request.contextPath}/banks/delete-bank?bankId=${bankModel.bankId}" style="float:right">
								<i class="fa fa-times" style="color: red"></i> Delete Bank
							</a>
						</td>
					</sec:authorize>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<c:if test="${deleteErrorMessage != ''}">
	<div class="alert alert-danger alert-dismissible" style="margin-top:20px; margin-bottom:0">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		${deleteErrorMessage}
	</div>
</c:if>
