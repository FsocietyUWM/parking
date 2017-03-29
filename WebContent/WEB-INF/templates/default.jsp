<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title><tiles:insertAttribute name="title"></tiles:insertAttribute></title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/static/css/main.css" />
		
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/script/jquery-3.2.0.min.js"></script>
	
	<tiles:insertAttribute name="includes"></tiles:insertAttribute>

</head>
<body>

<div class="container" id="wrapper">

	<div class="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	
	<div class="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	
	<div class="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>

</div>

</body>
</html>