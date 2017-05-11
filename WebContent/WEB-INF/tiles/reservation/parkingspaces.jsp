<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
	<thead>
		<tr>
			<th>Numer miejsca</th>
			<th>Status miejsca</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="space" items="${parkingSpaces}">
			<tr>
				<td><c:out value="${space.spaceNumber}"></c:out></td>
				<td>
					<c:if test="${space.available}">
						<p style="color:green; display:inline">WOLNE</p>
					</c:if>
					<c:if test="${space.available == false}">
						<p style="color:red; display:inline">ZAJĘTE</p> &nbsp; &nbsp; &nbsp;[ numer_rezerwacji ] - [ numer_rejestracyjny_pojazdu ]
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="<c:url value="/newparkingspace"/>" class="btn btn-info">Dodaj miejsce na parkingu</a>