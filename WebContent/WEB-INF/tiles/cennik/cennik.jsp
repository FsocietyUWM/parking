<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
	<thead>
		<tr>
			<th>Rodzaj pojazdu</th>
			<th>Długość parkowania</th>
			<th>Cena</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="price" items="${prices}">
			<tr>
				<td class="noBorderBottom"><c:out value="${price.vehicleType}"></c:out></td>
				<td>Pierwsza doba</td>
				<td><c:out value="${price.firstDayPrice}"></c:out> zł</td>
			</tr>
			<tr>
				<td class="sep"></td>
				<td class="sep">Każda kolejna doba</td>
				<td class="sep"><c:out value="${price.nextDayPrice}"></c:out> zł</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="<c:url value="/addtocennik"/>" class="btn btn-info">Dodaj pozycje do cennika</a>

<c:if test="${prices.size() > 0}">
<a href="<c:url value="/editcennik"/>" class="btn btn-info">Edytuj cennik</a>
</c:if>