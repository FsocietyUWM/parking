<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Hello World!</p>

	<p> <c:out value="${name}"> </c:out> </p>
	
	<!--  Wyciaganie info z BD za pomoca sql:query
	
	<sql:query var="rs" dataSource="jdbc/spring">
	select id, name, email, text from offers
	</sql:query>
	
	<c:forEach var="row" items="${rs.rows}">
	ID: ${row.id}<br/>
    Name: ${row.name}<br/>
    Email: ${row.email}<br/>
    Text: ${row.text}<br/>
	</c:forEach>
	-->
	
	<p><a href="${pageContext.request.contextPath}/offers">Show current offers.</a></p>
	<p><a href="${pageContext.request.contextPath}/createoffer">Add new offer.</a></p>
	
	<c:url var="logoutUrl" value="/logout"/>
	<form action="${logoutUrl}" method="post">
 		<input type="submit" value="Log out" />
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>