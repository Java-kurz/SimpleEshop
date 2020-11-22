<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 
<html>

<head>
	<title>Order detail</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
</head>

<body>

<%@include file="navbar.jsp" %>

<div class="main">

	<div class="panel panel-default">

		<div class="panel-heading">
			<span class="lead"><spring:message code="admin.orderDetail.header" /> ${order.id}</span> 
		</div>
	
		<table class="table table-hover">
			<thead>
				<tr>
					<th><spring:message code="admin.orderDetail.table.th.productid" /></th>
					<th><spring:message code="admin.orderDetail.table.th.productname" /></th>
					<th><spring:message code="admin.orderDetail.table.th.count" /></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty orderItems}">
						<c:forEach items="${orderItems}" var="orderItem">
							<tr>
							<td>${orderItem.productId}</td>
							<c:forEach items="${products}" var="product">
								<c:if test = "${orderItem.productId eq product.id}">
								<td>${product.name}</td>
								</c:if>
							</c:forEach>
							<td>${orderItem.quantity}</td>
							</tr>
						</c:forEach>
					</c:when>					
				</c:choose> 
			</tbody>
		</table>
		
	</div>
	<a href="<c:url value='orders' />" class="btn btn-danger">Zpět</a>
</div>

</body>
</html>