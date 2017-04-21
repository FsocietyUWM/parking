<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<table class="offers">
	<tr>
		<td>Username</td>
		<td>Email</td>
		<td>Text</td>
	</tr>
	<c:forEach var="offer" items="${offers}">
		<tr>
			<td><c:out value="${offer.user.username}"></c:out></td>
			<td><c:out value="${offer.user.email}"></c:out></td>
			<td><c:out value="${offer.text}"></c:out></td>
		</tr>
	</c:forEach>
</table>	

<br/>

<c:choose>
	<c:when test="${hasOffer}">
		<p><a href="${pageContext.request.contextPath}/createoffer">Edit or delete your current offer.</a></p>
	</c:when>
	
	<c:otherwise>
		<p><a href="${pageContext.request.contextPath}/createoffer">Add new offer.</a></p>
	</c:otherwise>
</c:choose>


<!-- <p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p> -->

<sec:authorize access="hasAuthority('ROLE_ADMIN')">
	<p><a href="<c:url value="/admin"/>">Admin</a></p>
</sec:authorize>
