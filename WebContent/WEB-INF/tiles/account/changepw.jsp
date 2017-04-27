<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">
	<div id="signupbox" style="margin-top: 40px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Zmień hasło</div>
			</div>
			<div class="panel-body">
			
			<sf:form id="changePassForm" modelAttribute="passwordOldNew" method="post" action="${pageContext.request.contextPath}/updatepw">
					
					<div class="form-group">
						<div class="col-md-15">
							<sf:input path="${passwordOldNew.oldPassword}" name="oldPassword" type="password" placeHolder="Aktualne hasło" cssClass="form-control" />
							<br>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-md-15">
							<sf:input path="${passwordOldNew.newPassword}" name="newPassword" type="password" placeHolder="Nowe hasło" cssClass="form-control"/>
							<br>
						</div>
					</div>
					
					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<a id="btn-signup"
								href="javascript:document.getElementById('changePassForm').submit();"
								class="btn btn-info">Zmień hasło </a>
						</div>
					</div>
					
			</sf:form>
			
			</div>
		</div>
	</div>
</div>
