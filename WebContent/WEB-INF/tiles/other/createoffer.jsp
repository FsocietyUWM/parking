<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
	<div id="signupbox" style="margin-top: 40px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Stworz oferte</div>
			</div>
			<div class="panel-body">

				<sf:form id="details" method="post"
					action="${pageContext.request.contextPath}/docreate"
					commandName="offer">

					<sf:input type="hidden" name="id" path="id" />

					<div class="form-group">
						<div class="col-md-15">
							<sf:textarea class="control" path="text" name="text" rows="10"
								cols="10" placeholder="Treść oferty"></sf:textarea>
							<br>
							<sf:errors cssClass="error" path="text"></sf:errors>
						</div>
					</div>

					<!-- Save Button -->
					<div style="margin-top: 10px" class="form-group">
						<div class="col-sm-12 controls">
							<a id="btn-signup"
								href="javascript:document.getElementById('details').submit();"
								class="btn btn-info">Zapisz zmiany </a>
						</div>
					</div>

					<c:if test="${offer.id != 0}">
						<!-- Delete Button -->
						<table>
							<tr>
								<td class="label"></td>
								<td><input class="delete control" name="delete"
									value="Usun oferte" type="submit" /></td>
							</tr>
						</table>
					</c:if>

				</sf:form>

			</div>
		</div>
	</div>
</div>