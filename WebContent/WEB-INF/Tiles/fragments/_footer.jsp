<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="datum" class="java.util.Date" />

<hr style="margin-top:50px" />
<footer>
	<p>BamCard d.d. &copy; <fmt:formatDate value="${datum}" pattern="yyyy" /></p>
</footer>
