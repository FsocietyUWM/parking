<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<table class="table">
	<thead>
		<tr>
			<th>Ważność od początku dnia</th>
			<th>Ważność do końca dnia</th>
			<th>Ilość pojazdów</th>
			<th>Koszt rezerwacji</th>
			<th>Czy opłacona?</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="details" items="${myReservations}">
			<tr>
				<td><c:out value="${details.reservation.startDate}"></c:out></td>
				<td><c:out value="${details.reservation.expirationDate}"></c:out></td>
				<td><c:out value="${details.reservation.numberOfVehicles}"></c:out></td>
				<td><c:out value="${details.reservation.charge}"></c:out> zł</td>
				<td><c:out value="${details.reservation.doesPaid}"></c:out></td>
				<td>

					<button type="button" class="btn btn-info btn-xs"
						data-toggle="modal" data-target="#<c:out value="${details.reservation.reservationID}"></c:out>">Szczegóły</button>
					<div class="modal fade" id="<c:out value="${details.reservation.reservationID}"></c:out>" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Szczegóły rezerwacji</h4>
								</div>
								
								<div class="modal-body">
									<table class="table">
										<thead>
											<tr>
												<th>Miejsce parkingowe</th>
												<th>Numer rejestracyjny</th>
												<th>Producent</th>
												<th>Model</th>
											</tr>
										</thead>
										<tbody>
										
										<c:forEach var="vehicle" items="${details.vehicles}">
											<tr>
												<td><c:out value="${vehicle.parkingSpace.spaceNumber}"></c:out></td>
												<td><c:out value="${vehicle.registrationNumber}"></c:out></td>
												<td><c:out value="${vehicle.manufacturer}"></c:out></td>
												<td><c:out value="${vehicle.model}"></c:out></td>
											</tr>
										</c:forEach>
	
										</tbody>
									</table>
								</div>
								
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>