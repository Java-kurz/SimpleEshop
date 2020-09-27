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


 <div class="well lead"><spring:message code="admin.categoryList.${actionType}" /></div>


		<form:form action="category_administration" method="POST" modelAttribute="category" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">
						<spring:message code="admin.categoryList.table.th.name" />
					</label>
					<div class="col-md-7">
						<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="status">
						<spring:message code="admin.categoryList.table.th.active" />
					</label>
					<div class="col-md-7">
						<input type="checkbox" name="status" id="status" ${category.status == 'True' ? 'checked' : ''}/>
					</div>
				</div>
			</div>

			<input type="submit" value="<spring:message code="admin.productAdmin.form.btn.save" />" class="btn btn-success"/> 
			<a href="<c:url value='categories' />" class="btn btn-danger"><spring:message code="admin.productAdmin.form.btn.back" /></a>
		</form:form>
	</div>

</body>
</html>