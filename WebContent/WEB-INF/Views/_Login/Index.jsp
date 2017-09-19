<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:useBean id="datum" class="java.util.Date" />

<div class="row">
    <div class="col-md-4 col-md-offset-4">
    	
    	<div class="panel panel-default panel-kviko-2">
    		<div class="panel-heading">BamPay Administration</div>
    		<div class="panel-body">
    			<c:url var="loginUrl" value="/login" />
		        <form action="${loginUrl}" method="post" class="form-horizontal">
		            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
		            	<div class="alert alert-danger" style="text-align:center; padding:10px">
		                    <!-- <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" /> -->
		                    Pogrešno korisničko ime i/ili šifra.
		                </div>
					</c:if>
		            <div class="input-group" style="margin-bottom:15px">
		                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
		                <input type="text" id="username" name="username" class="form-control" placeholder="Enter Username" required />
		            </div>
		            <div class="input-group" style="margin-bottom:25px">
		                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
		                <input type="password" id="password" name="password" class="form-control" placeholder="Enter Password" required />
		            </div>
		            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		            <div>
		                <input type="submit" class="btn btn-block btn-primary btn-default" value="Login" />
		            </div>
		        </form>
    		</div>
    		<div class="panel-footer">BamCard d.d. &copy; <fmt:formatDate value="${datum}" pattern="yyyy" /></div>
    	</div>
    	
    </div>
</div>
