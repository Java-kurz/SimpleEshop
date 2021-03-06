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


 <div class="well lead"><spring:message code="admin.productAdmin.${actionType}" /></div>


		<form:form action="product_administration" method="POST" modelAttribute="productAdminDetailModel" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">
						<spring:message code="admin.productList.table.th.name" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="description">
						<spring:message code="admin.productList.table.th.description" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="description" id="description" class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="imageUrl">
						<spring:message code="admin.productList.table.th.imageUrl" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="imageUrl" id="imageUrl" class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="price">
						<spring:message code="admin.productList.table.th.price" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="price" id="price" class="form-control input-sm" />
					</div>
				</div>				
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="categoryId">
						<spring:message code="admin.productList.table.th.categoryName" />
					</label>
					<div class="col-md-7">
											
     					<form:select path="categoryId" id="categoryId" class="form-control input-sm">
        				 
        				 <c:forEach items="${productAdminDetailModel.categories}" var="category">
            				
            				<c:choose>
            					<c:when test= "${category.id eq productAdminDetailModel.categoryId}">
            						<option value="${category.id}"selected>${category.name}</option>
            					</c:when>
            					<c:otherwise>
            						<option value="${category.id}">${category.name}</option>
            					</c:otherwise>
            				</c:choose>
            				            					
        				</c:forEach>
    					</form:select> 
    				    					
					</div>
				</div>
			</div>
			
			<input type="submit" value="<spring:message code="admin.productAdmin.form.btn.save" />" class="btn btn-success"/> 
			<a href="<c:url value='products' />" class="btn btn-danger"><spring:message code="admin.productAdmin.form.btn.back" /></a>
		</form:form>
	</div>

</body>
</html>