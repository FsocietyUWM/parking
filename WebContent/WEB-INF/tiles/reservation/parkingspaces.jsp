<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h4 style="color:blue">Ilość wszystkich miejsc: ${iloscWszyskichMiejsc}</h4>
<h4 style="color:green">Ilość wolnych miejsc: ${iloscWolnychMiejsc}</h4>
<h4 style="color:red">Ilość zajętych miejsc: ${iloscZajetychMiejsc}</h4>
<br>

<table class="table">
	<thead>
		<tr>
			<th>Numer miejsca</th>
			<th>Status miejsca</th>
			<th>Numer rezerwacji</th>
			<th>Numer rejestracyjny pojazdu</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vehicle" items="${allVehicles}">
			<tr>
				<td style="color:blue"><c:out value="${vehicle.parkingSpace.spaceNumber}"></c:out></td>
				<td>
					<p style="color:red; display:inline">ZAJĘTE</p>
				</td>
				
				<td>
					<c:out value="${vehicle.reservation.reservationID}"></c:out>
				</td>
				
				<td>
					<c:out value="${vehicle.registrationNumber}"></c:out>
				</td>
			</tr>
		</c:forEach>
		
		<c:forEach var="space" items="${parkingSpaces}">
			<c:if test="${space.available}">
				<tr>
					<td style="color:blue">
						<c:out value="${space.spaceNumber}"></c:out>
					</td>
					<td>
						<p style="color:green; display:inline">WOLNE</p>
					</td>
					
					<td>
						<p style="color:green; display:inline">---</p>
					</td>
					
					<td>
						<p style="color:green; display:inline">---</p>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		
	</tbody>
</table>

<a href="<c:url value="/newparkingspace"/>" class="btn btn-info">Dodaj miejsce na parkingu</a>
<a href="<c:url value="/editparkingspaces"/>" class="btn btn-info">Edytuj lub usuń miejsce parkingowe</a>