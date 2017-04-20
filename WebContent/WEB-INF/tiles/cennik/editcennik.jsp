<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


tutaj bedzie formularz do edycji cennika
<div class="container">
	<div id="signupbox" style="margin-top: 40px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Edytuj cennik</div>
			</div>
			<div class="panel-body">
				
				<input class="text" type="text" name="Rodzaj pojazdu" id=${vehicleType}/><br/>
				<input class="text" type="text" name="Czas parkowania" id=${parktime}  /><br/>
				<input class="text" type="text" name="Cena za dzień" id=${price.oneDay} zł /><br/>
				<input class="text" type="text" name="Cena za tydzień" id=${price.oneDayMoreThanWeek} zł/><br/>
				<input class="text" type="text" name="Cena za miesiąc" id=${price.oneDayMoreThanMonth} zł/><br/>
					
					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->
						<div class="col-sm-12 controls">
							<a id="btn-signup"
								href="javascript:document.getElementById('details').submit();"
								class="btn btn-info">Zapisz </a>
						</div>
					</div>

				</sf:form>
			</div>
		</div>

	</div>
</div>