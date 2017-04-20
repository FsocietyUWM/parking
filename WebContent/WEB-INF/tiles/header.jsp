<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="container">
<img src="${pageContext.request.contextPath}/static/images/parking-logo2.png" width="720" height="130">

</div>
<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/"/>">Strona główna</a></li>
				<li><a href="#">Dokonaj rezerwacji</a></li>
				<li><a href="<c:url value="/cennik"/>">Cennik</a></li>
				<li><a href="<c:url value="/kontakt"/>">Kontakt</a></li>
				
				<li class="dropdown"><a class="dropdown-toggle" href="#">Dojazd&nbsp;<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Parking 1</a></li>
						<li><a href="#">Parking 2</a></li>
						<li><a href="#">Parking 3</a></li>
					</ul>
				</li>
				
				<sec:authorize access="isAuthenticated()">
					<li class="dropdown"><a class="dropdown-toggle" href="#">Mój profil&nbsp;<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Moje dane</a></li>
							<li><a href="#">Moje rezerwacje</a></li>
							<li><a href="#">Zmień hasło</a></li>
						</ul>
					</li>
				</sec:authorize>
				
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<sec:authorize access="!isAuthenticated()">
					<li><a href="<c:url value="/newaccount"/>"><span class="glyphicon glyphicon-user"></span>&nbsp;Załóż konto</a></li>
					<li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Zaloguj się</a></li>
				</sec:authorize>
					
				<sec:authorize access="isAuthenticated()">
					<li><a href="javascript:document.getElementById('logout-form').submit();">
						<span class="glyphicon glyphicon-log-out"></span>&nbsp;Wyloguj się
					</a></li>
					
					<c:url var="logoutUrl" value="/logout"/>
					<form action="${logoutUrl}" method="post" id="logout-form">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					</form>
				</sec:authorize>
			</ul>
		</div>
	</nav>
	
</div>