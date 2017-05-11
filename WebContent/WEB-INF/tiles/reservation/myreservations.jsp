<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
	<thead>
		<tr>
			<th>Ważność od</th>
			<th>Ważność do</th>
			<th>Ilość pojazdów</th>
			<th>Koszt rezerwacji</th>
			<th>Czy opłacona?</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="reservation" items="${reservations}">
			<tr>
				<td><c:out value="${reservation.startDate}"></c:out></td>
				<td><c:out value="${reservation.expirationDate}"></c:out></td>
				<td><c:out value="${reservation.numberOfVehicles}"></c:out></td>
				<td><c:out value="${reservation.charge}"></c:out> zł</td>
				<td><c:out value="${reservation.doesPaid}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>
</table>