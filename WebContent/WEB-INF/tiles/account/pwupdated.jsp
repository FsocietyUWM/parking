<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${changeStatus == true}">
	<p>Hasło zostało zmienione.</p><br/>
	<a href="${pageContext.request.contextPath}/login">Zaloguj się przy użyciu nowego hasła.</a>
</c:if>

<c:if test="${changeStatus == false}">
	<p>Błędne hasło.</p><br/>
	<a href="${pageContext.request.contextPath}/changepw">Spróbuj ponownie.</a>
</c:if>