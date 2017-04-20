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
				<td><c:out value="${price.vehicleType}"></c:out></td>
				<td>mniej niż tydzień</td>
				<td><c:out value="${price.oneDay}"></c:out> zł</td>
			</tr>
			<tr>
				<td></td>
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

<a href="<c:url value="/editcennik"/>">Edytuj cennik</a>


<div class="container">
    <form method="post" action="https://secure.payu.com/api/v2_1/orders">
        <input type="hidden" name="continueUrl" value="http://shop.url/continue">
        <input type="hidden" name="currencyCode" value="PLN">
        <input type="hidden" name="customerIp" value="123.123.123.123">
        <input type="hidden" name="description" value="Order description">
        <input type="hidden" name="merchantPosId" value="145227">
        <input type="hidden" name="notifyUrl" value="http://shop.url/notify">
        <input type="hidden" name="products[0].name" value="Miejsce 1">
        <input type="hidden" name="products[0].quantity" value="1">
        <input type="hidden" name="products[0].unitPrice" value="1000">
        <input type="hidden" name="totalAmount" value="1000">
        <input type="hidden" name="OpenPayu-Signature" value="sender=145227;algorithm=SHA-256;signature=bc94a8026d6032b5e216be112a5fb7544e66e23e68d44b4283ff495bdb3983a8">
        <button type="submit" formtarget="_blank" >Pay with PayU</button>
    </form >
</div>