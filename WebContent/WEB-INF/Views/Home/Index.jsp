<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div>
	<h1>Dobro došli na BamPay Administraciju</h1>
	<sec:authorize access="isAuthenticated()" var="korisnikPrijavljen" />
	<sec:authentication property="authorities" var="roleKorisnika" />
	<c:choose>
		<c:when test="${korisnikPrijavljen}">
			<h3>Korisnik je prijavljen kao "<sec:authentication property="principal.username" />".</h3>
			<div>Role korisnika:</div>
			<div>
				<ul>
				    <c:forEach var="rola" items="${roleKorisnika}">
				    	<li>${rola}</li>
				    </c:forEach>
				</ul>
			</div>
		</c:when>
    	<c:otherwise>
    		<h3>Korisnik nije prijavljen.</h3>
    	</c:otherwise>
	</c:choose>
</div>
