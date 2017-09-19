<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="navbar navbar-default navbar-kviko navbar-fixed-top">
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
        	<c:set var="requestURI" value="${requestScope['javax.servlet.forward.request_uri']}" />
        	<c:set var="putanja" value="${fn:substring(requestURI, fn:length(pageContext.request.contextPath), fn:length(requestURI))}" />
            <ul class="nav navbar-nav">
                <li class="${fn:startsWith(putanja, '/banks') ? 'active' : ''}">
                	<a href="${pageContext.request.contextPath}/banks/list">
                		<i class="fa fa-university fa-fw"></i>&nbsp; Banks
                	</a>
                </li>
                <li class="${fn:startsWith(putanja, '/users') ? 'active' : ''}">
                	<a href="${pageContext.request.contextPath}/users/list">
                		<i class="fa fa-user-circle fa-fw"></i>&nbsp; Users
                	</a>
                </li>
                <li class="${fn:startsWith(putanja, '/atms') ? 'active' : ''}">
                	<a href="${pageContext.request.contextPath}/atms/list">
                		<i class="fa fa-map-marker fa-fw"></i>&nbsp; ATM
                	</a>
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
           			<form action="${logoutUrl}" id="logout-forma" method="post">
        				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    				</form>
            		<li>
            			<p class="navbar-text">
                        	<i class="fa fa-user fa-fw"></i>&nbsp; Pozdrav <span style="font-weight:bold; color:springgreen;">${pageContext.request.userPrincipal.name}</span>
                        </p>
                    </li>
                    <li>
                    	<button type="button" class="btn btn-default btn-sm navbar-btn" onclick="document.getElementById('logout-forma').submit()">
                        	<i class="fa fa-sign-out fa-fw"></i> Odjava
                        </button>
                    </li>
                </c:if>
           	</ul>
<%--            	<sec:authorize access="hasAuthority('ADMIN')"> --%>
	            <ul class="nav navbar-nav navbar-right">
            		<li class="dropdown ${fn:startsWith(putanja, '/admin') ? 'active' : ''}">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
          				<ul class="dropdown-menu">
            				<li><a href="${pageContext.request.contextPath}/admin">Index</a></li>
            				<li class="divider" role="separator"></li>
            				<li><a href="${pageContext.request.contextPath}/admin/app-users-roles">Application Users and Roles</a></li>
            				<li class="divider" role="separator"></li>
            				<li><a href="${pageContext.request.contextPath}/admin/generate-ddl">Generate DDL</a></li>
          				</ul>
        			</li>
	            </ul>
<%--             </sec:authorize> --%>
        </div>
    </div>
</div>
