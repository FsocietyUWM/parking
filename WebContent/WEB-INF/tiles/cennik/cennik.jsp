<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table">
	<thead>
		<tr>
			<th>Rodzaj pojazdu</th>
			<th>Długość parkowania</th>
			<th>Cena za dzień</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="price" items="${prices}">
			<tr>
				<td class="noBorderBottom"><c:out value="${price.vehicleType}"></c:out></td>
				<td>mniej niż tydzień</td>
				<td><c:out value="${price.oneDay}"></c:out> zł</td>
			</tr>
			<tr>
				<td class="noBorderBottom"></td>
				<td>ponad tydzień</td>
				<td><c:out value="${price.oneDayMoreThanWeek}"></c:out> zł</td>
			</tr>
			<tr>
				<td class="sep"></td>
				<td class="sep">ponad miesiąc</td>
				<td class="sep"><c:out value="${price.oneDayMoreThanMonth}"></c:out> zł</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="<c:url value="/addtocennik"/>" class="btn btn-info">Dodaj pozycje do cennika</a>

<c:if test="${prices.size() > 0}">
<a href="<c:url value="/editcennik"/>" class="btn btn-info">Edytuj cennik</a>
</c:if>