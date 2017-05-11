<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<sf:form id="cennik_form" modelAttribute="cennikPrices" method="post" action="${pageContext.request.contextPath}/updatecennik" acceptCharset="UTF-8">
<table class="table">
	<thead>
		<tr>
			<th>Zaznacz aby usunąć</th>
			<th>Rodzaj pojazdu</th>
			<th>Długość parkowania</th>
			<th>Cena za dzień</th>
		</tr>
	</thead>
	<tbody>
		
		<c:forEach items="${cennikPrices.cennikPrices}" var="price" varStatus="current">
			
			<sf:input type="hidden" path="cennikPrices[${current.index}].id" />
			
			<tr>
				<td class="noBorderBottom"><sf:checkbox path="cennikPrices[${current.index}].toRemove"/></td>
				<td class="noBorderBottom"><sf:input path="cennikPrices[${current.index}].vehicleType"/></td>
				<td>24 H</td>
				<td><sf:input path="cennikPrices[${current.index}].pricePerDay"/> zł</td>
			</tr>
			
			<tr>
				<td class="sep"></td>
				<td class="sep"></td>
				<td class="sep">miesiąc</td>
				<td class="sep"><sf:input path="cennikPrices[${current.index}].pricePerMonth"/> zł</td>
			</tr>
			
		</c:forEach>
	</tbody>
</table>
</sf:form>

<!-- Save Button -->
<div style="margin-top: 10px" class="form-group">
	<div class="col-sm-12 controls">
		<a id="btn-signup"
			href="javascript:document.getElementById('cennik_form').submit();"
			class="btn btn-success">Zapisz zmiany </a>
	</div>
</div>