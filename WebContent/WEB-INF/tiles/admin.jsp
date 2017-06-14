<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container">
    <div class="row">
        <div class="col-md-4">
        <h3>Panel administracyjny</h3>
            <div id="sidebar" class="well sidebar-nav">
                <h5><i class="glyphicon glyphicon-home"></i>
                    <small><b>CENNIK</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="<c:url value="/addtocennik"/>">Dodaj pozycje do cennika</a></li>
                    <li><a href="<c:url value="/editcennik"/>">Edytuj cennik</a></li>
                </ul>
                <h5><i class="glyphicon glyphicon-user"></i>
                    <small><b>PARKING</b></small>
                </h5>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="<c:url value="/parkingspaces"/>">Wyświetl parking</a></li>
                    <li><a href="#">Manage</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-8">
            <!-- Content Here -->
        </div>
    </div>
</div>