<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">
	<sf:form id="changeUserDetails" modelAttribute="userDetails"
		method="post"
		action="${pageContext.request.contextPath}/updateuserdetails"
		cssClass="form-horizontal">
	
		<legend>Dane użytkownika</legend>
		<sf:input type="hidden" path="username" />
	
		<div style="margin-top: 25px" class="form-group">
			<label class="col-md-2 control-label" for="textinput">Imię</label>
			<div class="col-md-15">
				<sf:input path="name" name="name" type="text"
					cssClass="form-control" />
				<br>
			</div>
		</div>
	
		<div class="form-group">
			<label class="col-md-2 control-label" for="textinput">Nazwisko</label>
			<div class="col-md-15">
				<sf:input path="surname" name="surname" type="text"
					cssClass="form-control" />
				<br>
			</div>
		</div>
	
		<div class="form-group">
			<label class="col-md-2 control-label" for="textinput">Numer telefonu</label>
			<div class="col-md-15">
				<sf:input path="phoneNumber" name="phoneNumber" type="text"
					cssClass="form-control" />
				<br>
			</div>
		</div>
	
		<div class="form-group">
			<label class="col-md-2 control-label" for="textinput">Adres</label>
			<div class="col-md-15">
				<sf:input path="address" name="address" type="text"
					cssClass="form-control" />
				<br>
			</div>
		</div>
	
		<div class="form-group">
			<label class="col-md-2 control-label" for="textinput">Kod pocztowy</label>
			<div class="col-md-15">
				<sf:input path="postalCode" name="postalCode" type="text"
					cssClass="form-control" />
				<br>
			</div>
		</div>
	
		<div class="form-group">
			<label class="col-md-2 control-label" for="textinput">Miasto</label>
			<div class="col-md-15">
				<sf:input path="city" name="city" type="text"
					cssClass="form-control" />
				<br>
			</div>
		</div>
	
		<div style="margin-top: 10px" class="form-group">
			<!-- Button -->
			<label class="col-md-2 control-label" for="singlebutton"></label>
			<div class="col-md-15">
				<a id="btn-signup"
					href="javascript:document.getElementById('changeUserDetails').submit();"
					class="btn btn-info">Zapisz zmiany </a>
			</div>
		</div>
	
	</sf:form>
</div>