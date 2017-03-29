<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">
	<div id="signupbox" style="margin-top: 40px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Zarejestruj się</div>
			</div>
			<div class="panel-body">
				
				<sf:form id="details" method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user" class="form-horizontal" role="form">

					<div class="form-group">
						<div class="col-md-15">
							<sf:input class="control" path="username" name="username" type="text" placeholder="Nazwa użytkownika" />
							<br>
							<sf:errors class="error" path="username"></sf:errors>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-15">
							<sf:input class="control" path="email" name="email" type="text" placeholder="Email" />
							<br>
							<sf:errors class="error" path="email"></sf:errors>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-15">
							<sf:input id="password" class="control" path="password" name="password" type="password" placeholder="Hasło" />
							<br>
							<sf:errors class="error" path="password"></sf:errors>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-15">
							<input id="confirmpass" class="control" name="confirmpass" type="password" placeholder="Powtórz hasło" />
							<br>
							<div id="matchpass"></div>
						</div>
					</div>
					
					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<a id="btn-signup"
								href="javascript:document.getElementById('details').submit();"
								class="btn btn-info">Zarejestruj </a>
						</div>
					</div>

				</sf:form>
			</div>
		</div>

	</div>
</div>
