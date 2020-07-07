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
</head>

<body>

<%@include file="eshop-navbar.jsp" %>

<div class="main">

	<h2>Detail produktu ${product.name}</h2>
	<hr />
	<div class="row">
		<table class="table" style="text-align: center;">
			<tbody>
				<tr><td>${product.description}</td></tr>
				<tr><td><img src="<c:url value='/static/images/${product.imageUrl}' />" width="400" /></td></tr>
				<tr><td><h4>${product.price} Kč</h4></td></tr>
				<tr><td>
					<a href="<c:url value='addtocart?id=${product.id}' />" class="btn btn-primary">
						<spring:message code="productDetail.btn.addToCart" />
					</a>
				</td></tr>
			</tbody>
		</table>
	</div>
</div>

</body>
</html>