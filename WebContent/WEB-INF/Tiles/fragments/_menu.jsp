<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${pageContext.request.contextPath}/" class="navbar-brand">BamPay Administration</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            	<sec:authorize access="hasAuthority('ADMIN')">
            		<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
        		</sec:authorize>
                <li>
                	<a href="${pageContext.request.contextPath}/banks/list">Banks</a>
                </li>
            </ul>
           	<ul class="nav navbar-nav navbar-right navbar-user">
           		<c:url var="loginUrl" value="/login" />
           		<c:url var="logoutUrl" value="/login/odjava" />
           		<c:if test="${pageContext.request.userPrincipal == null}">
                	<li>
                    	<button type="button" class="btn btn-default btn-sm navbar-btn" onclick="location.href='${loginUrl}'">
                        	<i class="fa fa-sign-in fa-fw"></i> Prijava
                        </button>
                    </li>
                </c:if>
           		<c:if test="${pageContext.request.userPrincipal != null}">
            		<li>
            			<p class="navbar-text">
                        	<i class="fa fa-user fa-fw"></i>&nbsp; Pozdrav <span style="font-style:italic">${pageContext.request.userPrincipal.name}</span>
                        </p>
                    </li>
                    <li>
                    	<button type="button" class="btn btn-default btn-sm navbar-btn" onclick="location.href='${logoutUrl}'">
                        	<i class="fa fa-sign-out fa-fw"></i> Odjava
                        </button>
                    </li>
                </c:if>
           	</ul>
        </div>
    </div>
</div>
