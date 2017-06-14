<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sf:form id="parkingspaces_form" modelAttribute="formParkingSpaces" method="post" action="${pageContext.request.contextPath}/updateparkingspaces" acceptCharset="UTF-8">
<table class="table">
	<thead>
		<tr>
			<th>Zaznacz aby usunąć</th>
			<th>Numer miejsca</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${formParkingSpaces.parkingSpaces}" var="space" varStatus="current">
			
			<sf:input type="hidden" path="parkingSpaces[${current.index}].parkingSpaceID" />
			<c:if test="${space.available}">
				<tr>
					<td style="width:170px"><sf:checkbox path="parkingSpaces[${current.index}].toRemove"/></td>
					<td><sf:input cssStyle="width:100px" path="parkingSpaces[${current.index}].spaceNumber"/></td>
				</tr>
			</c:if>
		</c:forEach>
		
	</tbody>
</table>
</sf:form>

<!-- Save Button -->
<div style="margin-top: 10px" class="form-group">
	<div class="col-sm-12 controls">
		<a id="btn-signup"
			href="javascript:document.getElementById('parkingspaces_form').submit();"
			class="btn btn-success">Zapisz zmiany </a>
			
		<a href="<c:url value="/parkingspaces"/>" class="btn btn-default">Powrót</a>
	</div>
</div>