<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>

<head>
	<title>Products List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
</head>

<body>

<%@include file="navbar.jsp" %>

<div class="main">
	<div class="panel panel-default">

		<div class="panel-heading">
			<span class="lead"><spring:message code="admin.productList.header" /></span>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th><spring:message code="admin.productList.table.th.name" /></th>
					<th><spring:message code="admin.productList.table.th.description" /></th>
					<th><spring:message code="admin.productList.table.th.imageUrl" /></th>
					<th><spring:message code="admin.productList.table.th.price" /></th>
					<th><spring:message code="admin.productList.table.th.categoryName" /></th>
					<th width="100"></th>
					<th width="100"></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty products}">
						<c:forEach items="${products}" var="product">
							<tr>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td>${product.imageUrl}</td>
								<td>${product.price}</td>
								<c:forEach items="${categories}" var="category">
									<c:if test= "${product.categoryId eq category.id}">
									<td>${category.name}</td>
									</c:if>
								</c:forEach>
								<td>
									<a href="<c:url value='edit_product_${product.id}' />" class="btn btn-primary">
										<spring:message code="admin.productList.table.btn.edit" />
									</a>
								</td>
								<td>
									<a href="<c:url value='remove_product_${product.id}' />" class="btn btn-danger">
										<spring:message code="admin.productList.table.btn.delete" />
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3"><spring:message code="admin.productList.emptyList" /></td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<div class="well">
	
		<a href="<c:url value='create_product' />" class="btn btn-success">
			<spring:message code="admin.productList.table.btn.create" />
		</a>
	</div>
</div>

</body>
</html>