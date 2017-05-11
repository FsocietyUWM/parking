<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form id="createParkingSpace" modelAttribute="parkingSpace" method="post" action="${pageContext.request.contextPath}/createparkingspace" acceptCharset="UTF-8">
<table class="table">
	<thead>
		<tr>
			<th>Numer miejsca</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td class="noBorderBottom"><sf:input path="spaceNumber"/></td>
		</tr>
	</tbody>
</table>
</sf:form>

<!-- Save Button -->
<div style="margin-top: 10px" class="form-group">
	<div class="col-sm-12 controls">
		<a id="btn-signup"
			href="javascript:document.getElementById('createParkingSpace').submit();"
			class="btn btn-success">Dodaj miejsce</a>
	</div>
</div>