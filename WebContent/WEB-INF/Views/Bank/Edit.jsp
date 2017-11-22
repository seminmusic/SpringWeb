<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h3 class="naslov-stranice">New / Edit Bank</h3>
<div>
	<form:form action="${pageContext.request.contextPath}/banks/save-bank" method="post" modelAttribute="newBankModel"
			   data-bv-message="Vrijednost nije validna"
    		   data-bv-icon-valid="glyphicon glyphicon-ok"
    		   data-bv-icon-invalid="glyphicon glyphicon-remove"
    		   data-bv-icon-validating="glyphicon glyphicon-refresh">
		<form:hidden path="bankId" />
		<div class="row" style="margin-top:25px">
			<div class="col-xs-3">
				<spring:bind path="bankName">
					<div class="form-group ${status.error ? 'has-error has-feedback' : ''}">
						<form:label path="bankName" class="control-label">Bank Name:</form:label>
						<form:input path="bankName" class="form-control" type="text" autocomplete="off"
									data-bv-notempty="true"
									data-bv-notempty-message="Obavezan unos naziva"
									data-bv-stringlength="true"
									data-bv-stringlength-max="100"
                					data-bv-stringlength-message="Maksimalno 100 karaktera" />
						<c:if test="${status.error}">
               				<i class="form-control-feedback glyphicon-remove glyphicon server-side-error" style="display:block"></i>
               				<small class="help-block server-side-error" style="display:block">${status.errorMessage}</small>
             			</c:if>
					</div>
				</spring:bind>
			</div>
			<div class="col-xs-3">
				<spring:bind path="status">
					<div class="form-group ${status.error ? 'has-error has-feedback' : ''}">
						<form:label path="status" class="control-label">Status:</form:label>
						<form:input path="status" class="form-control" type="text" autocomplete="off"
									data-bv-notempty="true"
									data-bv-notempty-message="Obavezan unos statusa"
									data-bv-integer="true"
									data-bv-integer-message="Unesite cijeli broj" />
						<c:if test="${status.error}">
               				<i class="form-control-feedback glyphicon-remove glyphicon server-side-error" style="display:block"></i>
               				<small class="help-block server-side-error" style="display:block">${status.errorMessage}</small>
             			</c:if>
					</div>
				</spring:bind>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-3">
				<spring:bind path="bin">
					<div class="form-group ${status.error ? 'has-error has-feedback' : ''}">
						<form:label path="bin" class="control-label">BIN:</form:label>
						<form:input path="bin" class="form-control" type="text" autocomplete="off"
									data-bv-notempty="true"
									data-bv-notempty-message="Obavezan unos BIN"
									data-bv-stringlength="true"
									data-bv-stringlength-max="10"
                					data-bv-stringlength-message="Maksimalno 10 karaktera" />
						<c:if test="${status.error}">
               				<i class="form-control-feedback glyphicon-remove glyphicon server-side-error" style="display:block"></i>
               				<small class="help-block server-side-error" style="display:block">${status.errorMessage}</small>
             			</c:if>
					</div>
				</spring:bind>
			</div>
			<div class="col-xs-3">
				<spring:bind path="uppId">
					<div class="form-group ${status.error ? 'has-error has-feedback' : ''}">
						<form:label path="uppId" class="control-label">UPP ID:</form:label>
						<form:input path="uppId" class="form-control" type="text" autocomplete="off"
									data-bv-stringlength="true"
									data-bv-stringlength-max="10"
                					data-bv-stringlength-message="Maksimalno 10 karaktera" />
						<c:if test="${status.error}">
               				<i class="form-control-feedback glyphicon-remove glyphicon server-side-error" style="display:block"></i>
               				<small class="help-block server-side-error" style="display:block">${status.errorMessage}</small>
             			</c:if>
					</div>
				</spring:bind>
			</div>
			<div class="col-xs-3">
				<spring:bind path="bamcardId">
					<div class="form-group ${status.error ? 'has-error has-feedback' : ''}">
						<form:label path="bamcardId" class="control-label">Bamcard ID:</form:label>
						<form:input path="bamcardId" class="form-control" type="text" autocomplete="off"
									data-bv-integer="true"
									data-bv-integer-message="Unesite cijeli broj" />
						<c:if test="${status.error}">
               				<i class="form-control-feedback glyphicon-remove glyphicon server-side-error" style="display:block"></i>
               				<small class="help-block server-side-error" style="display:block">${status.errorMessage}</small>
             			</c:if>
					</div>
				</spring:bind>
			</div>
			<div class="col-xs-3">
				<spring:bind path="smsRegCodeEnabled">
					<div class="form-group ${status.error ? 'has-error has-feedback' : ''}">
						<div class="checkbox" style="margin-top:25px">
							<label>
								<form:checkbox path="smsRegCodeEnabled" 
											   data-toggle="toggle" data-on="<i class='fa fa-check'></i> SMS" data-off="<i class='fa fa-times'></i> SMS"
											   data-onstyle="success" data-offstyle="warning" />
							</label>
						</div>
						<c:if test="${status.error}">
               				<i class="form-control-feedback glyphicon-remove glyphicon server-side-error" style="display:block"></i>
               				<small class="help-block server-side-error" style="display:block">${status.errorMessage}</small>
             			</c:if>
					</div>
				</spring:bind>
			</div>
		</div>
		<div class="row" style="margin-top:20px">
			<div class="col-xs-12">
				<button type="submit" class="btn btn-success" style="margin-right:10px">
					<i class="fa fa-check"></i>&nbsp; Save
				</button>
				<button type="button" class="btn btn-default" onclick="window.location.href='${pageContext.request.contextPath}/banks/list'">
					<i class="fa fa-reply"></i>&nbsp; Cancel
				</button>
			</div>
		</div>
	</form:form>
</div>
