<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	$(document).ready(function() {
		document.f.username.focus();
	});
</script>


<c:if test="${param.error != null}">
	<p class="error">Logowanie nie powiodło się, spróbuj ponownie.</p>
</c:if>

<div class="container">
	<div id="loginbox" style="margin-top: 40px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Zaloguj się</div>
				<div
					style="float: right; font-size: 80%; position: relative; top: -10px">
					<a href="#">Zapomniałeś hasła?</a>
				</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">

				<c:url var="loginUrl" value="/login" />
				<form name='f' action="${loginUrl}" method='POST' id="login-form"
					class="form-horizontal" role="form">

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input type="text"
							class="form-control" name="username" value=""
							placeholder="Nazwa użytkownika">
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input type="password"
							class="form-control" name="password" placeholder="Hasło">
					</div>

					<div class="input-group">
						<div class="checkbox">
							<label> <input type='checkbox' name='remember-me'
								checked="checked" /> Zapamiętaj mnie
							</label>
						</div>
					</div>

					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<a id="btn-login"
								href="javascript:document.getElementById('login-form').submit();"
								class="btn btn-success">Zaloguj </a>
						</div>
					</div>

					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>

			</div>
		</div>
	</div>
</div>
