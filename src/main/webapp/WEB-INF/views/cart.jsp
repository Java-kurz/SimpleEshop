<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<html>

<head>
<title>Product detail</title>
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

<style type="text/css">
.table > tbody > tr > td {
     vertical-align: middle;
}
</style>
</head>

<body>

<%@include file="eshop-navbar.jsp" %>

<div class="main">

	<h2><spring:message code="cart.header" /></h2>
	<br />

	<table class="table">
		<tr>
			<th>Položka</th>
			<th>Počet kusů</th>
			<th>Cena celkem</th>
			<th>Odebrat z košíku</th>
		</tr>
		<tr>
			<td>
				<div>Název položky</div>
				<img src="<c:url value='/static/images/apple.jpg' />" width="150" />
			</td>
			<td>
				<a href="">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</a>
				<br /><br />
				<span>3 Kusy</span>
				<br /><br />
				<a href="">
					<i class="fa fa-minus" aria-hidden="true"></i>
				</a>
			</td>
			<td>
				<span>2000</span>
			</td>
			<td>
				<a href="">
					<i style="color:red" class="fa fa-remove" aria-hidden="true"></i>
				</a>
			</td>
		</tr>
		<tr>
			<td>
				<h3 style="text-align: left;">
					<br />
					<span>Cena celkem: </span>
					<span>5555</span>
				</h3>
			</td>
			<td></td><td></td><td></td><td></td>
		</tr>
	</table>

	<div align="center">
		<a href="" class="btn btn-danger">Vyprázdnit košík</a>
	</div>

</div>
	
</body>
</html>