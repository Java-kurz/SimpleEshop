<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<html>

<head>
	<title>Main page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
</head>

<body>

<%@include file="eshop-navbar.jsp" %>

<div class="main">

	<h2>Tohle je eshop</h2>
	<hr />
	<div class="row">
		<c:forEach items="${products}" var="product">
			<div class="column">
				<a href="<c:url value='product_detail?id=${product.id}&testParam=A&testParam2=B' />">
					<table class="table" style="text-align: center;">
						<tbody>
							<tr><td><b>${product.name}</b></td></tr>
							<tr><td>${product.description}</td></tr>
							<tr>
								<td>
									<img src="<c:url value='/static/images/${product.imageUrl}' />" width="200" />
								</td>
							</tr>
							<tr><td>${product.price} Kč</td></tr>
						</tbody>
					</table>
				</a>
			</div>
		</c:forEach>
	</div>
</div>
	
</body>
</html>