<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="header clearfix">

<<<<<<< HEAD
	<nav>
	<ul class="nav nav-pills pull-right">
		<li role="presentation"><a href="<c:url value="/newreservation"/>">Dokonaj rezerwacji</a></li>
		<li role="presentation"><a href="<c:url value="/cennik"/>">Cennik</a></li>
		<li role="presentation"><a href="<c:url value="/kontakt"/>">Kontakt</a></li>
		<li role="presentation"><a href="Dojazd.html">Dojazd</a></li>
		
		<sec:authorize access="isAuthenticated()">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Moj profil<span class="caret"></span></a>
			<ul class="dropdown-menu navbar-left">
			<li><a href="<c:url value="/userdetails"/>">Moje dane</a></li>
			<li><a href="<c:url value="/myreservations"/>">Moje rezerwacje</a></li>
			<li><a href="<c:url value="/changepw"/>">Zmień hasło</a></li>
			</ul>
		</li>
		</sec:authorize>
		
		<sec:authorize access="!isAuthenticated()">
			<li role="presentation"><a href="<c:url value="/newaccount"/>">Załóż konto</a></li>
			<li role="presentation"><a href="<c:url value="/login"/>">Zaloguj się</a></li>
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
	<h3 class="text-muted active" style="display:inline"><a href="<c:url value="/"/>">Fsociety</a></h3>
	</nav>
	<hr>

</div>
<!--  
			
			<sec:authorize access="isAuthenticated()">
				<li class="dropdown">
				<a class="dropdown-toggle" href="#">Mój profil&nbsp;<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/userdetails"/>">Moje dane</a></li>
						<li><a href="<c:url value="/myreservations"/>">Moje rezerwacje</a></li>
						<li><a href="<c:url value="/changepw"/>">Zmień hasło</a></li>
					</ul>
				</li>
			</sec:authorize>
			
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="!isAuthenticated()">
				<li><a href="<c:url value="/newaccount"/>"><span class="glyphicon glyphicon-user"></span>&nbsp;Załóż konto</a></li>
				<li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Zaloguj się</a></li>
			</sec:authorize>
=======
</div>
<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">

			<ul class="nav navbar-nav">
				<li><a href="<c:url value="/"/>">Strona główna</a></li>
				<li><a href="<c:url value="/newreservation"/>">Dokonaj rezerwacji</a></li>
				<li><a href="<c:url value="/cennik"/>">Cennik</a></li>
				<li><a href="<c:url value="/kontakt"/>">Kontakt</a></li>
				<li><a href="#">Dojazd</a></li>
>>>>>>> 4f9ced90dd98627d1cb4de798e57ebb83d9fbb49
				
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
-->
	