<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sf:form id="cennik_form" modelAttribute="cennikPrices" method="post" action="${pageContext.request.contextPath}/updatecennik" acceptCharset="UTF-8">
<table class="table">
	<thead>
		<tr>
			<th>Rodzaj pojazdu</th>
			<th>Długość parkowania</th>
			<th>Cena</th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td class="noBorderBottom"><sf:input path="cennikPrices[0].vehicleType"/></td>
				<td>Pierwsza doba</td>
				<td><sf:input path="cennikPrices[0].firstDayPrice"/> zł</td>
			</tr>
			<tr>
				<td class="sep"></td>
				<td class="sep">Każda kolejna doba</td>
				<td class="sep"><sf:input path="cennikPrices[0].nextDayPrice"/> zł</td>
			</tr>
	</tbody>
</table>
</sf:form>

<!-- Save Button -->
<div style="margin-top: 10px" class="form-group">
	<div class="col-sm-12 controls">
		<a id="btn-signup"
			href="javascript:document.getElementById('cennik_form').submit();"
			class="btn btn-success">Dodaj do cennika </a>
	</div>
</div>