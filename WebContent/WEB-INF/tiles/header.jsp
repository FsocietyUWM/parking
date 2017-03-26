<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a class="title" href="<c:url value="/"/>">Parking</a>

<sec:authorize access="!isAuthenticated()">
	<a class="login" href="<c:url value="/login"/>">Log in</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	<c:url var="logoutUrl" value="/logout"/>
	<form action="${logoutUrl}" method="post">
 		<input class="logout" type="submit" value="Log out" />
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</sec:authorize>