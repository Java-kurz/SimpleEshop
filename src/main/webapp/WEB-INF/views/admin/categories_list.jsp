<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>

<head>
	<title>Categories List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/stylesheet.css' />" rel="stylesheet"></link>
</head>

<body>

<%@include file="navbar.jsp" %>

<div class="main">
test
<%-- 	<div class="panel panel-default">

		<div class="panel-heading">
			<span class="lead"><spring:message code="admin.categoryList.header" /></span>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th><spring:message code="admin.categoryList.table.th.name" /></th>
					<th><spring:message code="admin.categoryList.table.th.active" /></th>
					
					<th width="100"></th>
					<th width="100"></th>
				</tr>
			</thead>
			<tbody>
			 <c:choose>
					<c:when test="${not empty categories}">
						<c:forEach items="${categories}" var="category">
							<tr>
								<td>${category.name}</td>
								<td>${category.active}</td>
								<td>
									<a href="<c:url value='edit_category_${category.id}' />" class="btn btn-primary">
										<spring:message code="admin.categoryList.table.btn.edit" />
									</a>
								</td>
								<td>
									<a href="<c:url value='remove_category_${category.id}' />" class="btn btn-danger">
										<spring:message code="admin.categoryList.table.btn.delete" />
									</a>
								</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="3"><spring:message code="admin.categoryList.emptyList" /></td>
						</tr>
					</c:otherwise>
				</c:choose> 
			</tbody>
		</table>
	</div>
	<div class="well"> --%>
	
		<a href="<c:url value='create_category' />" class="btn btn-success">
			<spring:message code="admin.productList.table.btn.create" />
		</a>
	</div>
</div>

</body>
</html>